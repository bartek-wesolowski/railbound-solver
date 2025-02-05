package solver

import com.danrusu.pods4k.immutableArrays.asList
import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import com.danrusu.pods4k.immutableArrays.indexOf
import com.danrusu.pods4k.immutableArrays.multiplicativeSpecializations.map
import com.danrusu.pods4k.immutableArrays.plus
import model.Action.ToggleBarrier
import model.Barrier
import model.BarrierSwitch
import model.Board
import model.Direction
import model.Direction.DOWN
import model.Direction.LEFT
import model.Direction.RIGHT
import model.Direction.UP
import model.ExpectedCars
import model.Fork
import model.Level
import model.ModifiableTile
import model.Position
import model.StraightTrack
import model.Tile
import model.Tile.BaseHorizontalTrack.HorizontalTrack
import model.Tile.BaseVerticalTrack.VerticalTrack
import model.Tile.DownLeftTurn
import model.Tile.DownRightTurn
import model.Tile.Empty
import model.Tile.EndingTrack
import model.Tile.Obstacle
import model.Tile.UpLeftTurn
import model.Tile.UpRightTurn
import model.Tunnel
import model.Turn
import util.mapAt
import util.removeAt
import java.util.EnumSet
import java.util.PriorityQueue

class Solver {
    fun findSolutions(level: Level): Set<Board> {
        val statesToCheck = PriorityQueue<SolverState>(compareBy { it.tracksUsed })
        val statesChecked = mutableSetOf<SolverState>()
        statesToCheck.add(SolverState(level.board, level.cars, 0, ExpectedCars(level.cars), emptyMap()))
        val solutions = mutableSetOf<Board>()
        while (statesToCheck.isNotEmpty()) {
            val state = statesToCheck.poll()
            if (state.isSolved()) {
                solutions.add(state.board)
                continue
            }
            statesChecked.add(state)
            val nextStates = state.nextStates()
                .filter { it.tracksUsed <= level.tracks }
            statesToCheck.addAll(nextStates.toSet() - statesChecked)
        }
        return solutions
    }

    fun getSolverStates(level: Level): Sequence<SolverState> = sequence {
        val statesToCheck = PriorityQueue(Comparator<Pair<SolverState, Int>> { p1, p2 ->
            val depth1 = p1.second
            val depth2 = p2.second
            depth2.compareTo(depth1)
        })
        val statesChecked = mutableSetOf<SolverState>()
        statesToCheck.add(SolverState(level.board, level.cars, 0, ExpectedCars(level.cars), emptyMap()) to 1)
        val solutions = mutableSetOf<Board>()
        while (statesToCheck.isNotEmpty()) {
            val (state, depth) = statesToCheck.poll()
            yield(state)
            if (state.isSolved()) {
                solutions.add(state.board)
                continue
            }
            statesChecked.add(state)
            val nextStates = state.nextStates()
                .filter { it.tracksUsed <= level.tracks }
            statesToCheck.addAll((nextStates.toSet() - statesChecked).map { it to depth + 1 })
        }
    }

    private fun SolverState.isSolved(): Boolean {
        return activeCars.isEmpty()
    }

    private fun SolverState.nextStates(): List<SolverState> {
        var partialStates = getMoves(PartialSolverState(this, immutableArrayOf()), 0)
        for (carIndex in 1..activeCars.lastIndex) {
            val updatedPartialStates = mutableListOf<PartialSolverState>()
            for (partialState in partialStates) {
                val state = partialState.state
                    val adjustedCarIndex = state.activeCars.indexOf(activeCars[carIndex])
                    updatedPartialStates.addAll(
                        getMoves(
                            PartialSolverState(state, partialState.actions),
                            adjustedCarIndex
                        )
                    )
            }
            partialStates = updatedPartialStates.filterNoCollisions(this, carIndex)
        }
        return partialStates.map { it.applyActions() }
    }

    private fun List<PartialSolverState>.filterNoCollisions(
        previousState: SolverState,
        carIndex: Int
    ): List<PartialSolverState> = filter { partialState ->
        val state = partialState.state
        val carAIndex = state.activeCars.indexOfFirst {
            it.color == previousState.activeCars[carIndex].color &&
                    it.number == previousState.activeCars[carIndex].number
        }
        if (carAIndex == -1) return@filter true
        val carA = state.activeCars[carAIndex]
        for (carBIndex in 0 until carAIndex) {
            val carB = state.activeCars[carBIndex]
            if (carB.position.row == carA.position.row && carA.position.column == carB.position.column) {
                return@filter false
            }
            val initialCarBIndex = previousState.activeCars.indexOfFirst {
                it.color == carB.color && it.number == carB.number
            }
            if (initialCarBIndex != -1) {
                val initialCarA = previousState.activeCars[carIndex]
                val initialCarB = previousState.activeCars[initialCarBIndex]
                if (
                    initialCarB.position.row == carA.position.row &&
                    initialCarB.position.column == carA.position.column &&
                    initialCarA.position.row == carB.position.row &&
                    initialCarA.position.column == carB.position.column
                ) {
                    return@filter false
                }
            }
        }
        true
    }


    private fun getMoves(
        partialState: PartialSolverState,
        carIndex: Int
    ): List<PartialSolverState> {
        val state = partialState.state
        val position = state.activeCars[carIndex].position
        val tile = state.board[position.row, position.column]
        val newCarPosition = tile.getNextPosition(position)
        val newPosition = newCarPosition.asPosition()
        if (newCarPosition.row < 0 || newCarPosition.row >= state.board.rows) return emptyList()
        if (newCarPosition.column < 0 || newCarPosition.column >= state.board.columns) return emptyList()
        val car = state.activeCars[carIndex].copy(position = newCarPosition)
        val newCars = state.activeCars.mapAt(carIndex) { it.copy(position = newCarPosition) }
        return when (val newTile = state.board[newCarPosition.row, newCarPosition.column]) {
            Obstacle -> emptyList()
            Empty -> availableTilesByDirection.getValue(car.direction)
                .filter {
                    state.board.canInsert(
                        newCarPosition.row,
                        newCarPosition.column,
                        it,
                        state.traverseDirections.getOrDefault(newPosition, EnumSet.noneOf(Direction::class.java))
                    )
                }
                .map { insertedTile ->
                    PartialSolverState(
                        state.copy(
                            board = state.board.withInserted(
                                newCarPosition.row,
                                newCarPosition.column,
                                car.direction,
                                insertedTile
                            ),
                            activeCars = newCars,
                            tracksUsed = state.tracksUsed + 1,
                            traverseDirections = if (insertedTile is VerticalTrack || insertedTile is HorizontalTrack) {
                                state.traverseDirections.with(newPosition, car.direction)
                            } else {
                                state.traverseDirections
                            }
                        ),
                        partialState.actions
                    )
                }

            EndingTrack -> if (
                car.direction in newTile.incomingDirections &&
                state.expectedCars.isExpected(car)
            ) {
                listOf(
                    PartialSolverState(
                        state.copy(
                            activeCars = state.activeCars.removeAt(carIndex),
                            expectedCars = state.expectedCars.withNextExpected(car.color)
                        ),
                        partialState.actions
                    )
                )
            } else {
                emptyList()
            }

            is StraightTrack,
            is Turn,
            is Fork -> {
                if (car.direction in newTile.incomingDirections) {
                    val traverseDirections = if (newTile is VerticalTrack || newTile is HorizontalTrack) {
                        partialState.state.traverseDirections.with(newPosition, car.direction)
                    } else {
                        partialState.state.traverseDirections
                    }
                    if (newTile is Barrier && !newTile.open) {
                        listOf(PartialSolverState(state, partialState.actions))
                    } else {
                        val actions = if (newTile is BarrierSwitch) {
                            partialState.actions + ToggleBarrier(newTile.color)
                        } else {
                            partialState.actions
                        }
                        listOf(
                            PartialSolverState(
                                state.copy(
                                    activeCars = newCars,
                                    traverseDirections = traverseDirections
                                ),
                                actions
                            )
                        )
                    }
                } else if (newTile is ModifiableTile) {
                    val incomingDirectionsAfterModification = newTile.getIncomingDirectionsAfterModification(
                        state.traverseDirections.getOrDefault(
                            newPosition,
                            EnumSet.noneOf(Direction::class.java)
                        )
                    )
                    if (car.direction in incomingDirectionsAfterModification) {
                        incomingDirectionsAfterModification
                            .getValue(car.direction)
                            .map { modifiedTile ->
                                PartialSolverState(
                                    state.copy(
                                        board = state.board.with(newCarPosition.row, newCarPosition.column, modifiedTile),
                                        activeCars = newCars,
                                        expectedCars = state.expectedCars
                                    ),
                                    partialState.actions
                                )
                            }
                            .asList()
                    } else {
                        emptyList()
                    }
                } else {
                    emptyList()
                }
            }

            is Tunnel -> listOf(PartialSolverState(state.copy(activeCars = newCars), partialState.actions))
        }
    }

    private fun Map<Position, EnumSet<Direction>>.with(
        position: Position,
        direction: Direction
    ): Map<Position, EnumSet<Direction>> {
        val directions = getOrDefault(position, EnumSet.noneOf(Direction::class.java))
        val newDirections = EnumSet.copyOf(directions).apply {
            add(direction)
        }
        return plus(position to newDirections)
    }

    companion object {
        private val availableTilesByDirection = mapOf<Direction, Set<Tile>>(
            LEFT to setOf(HorizontalTrack, UpRightTurn(), DownRightTurn()),
            RIGHT to setOf(HorizontalTrack, UpLeftTurn(), DownLeftTurn()),
            UP to setOf(VerticalTrack, DownLeftTurn(), DownRightTurn()),
            DOWN to setOf(VerticalTrack, UpLeftTurn(), UpRightTurn()),
        )
    }
}

