package solver

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import com.danrusu.pods4k.immutableArrays.indexOf
import model.Board
import model.Car
import model.Direction.DOWN
import model.Direction.LEFT
import model.Direction.RIGHT
import model.Direction.UP
import model.ExpectedCars
import model.Fork
import model.Level
import model.ResetCarsAfterModification
import model.StraightTrack
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
import java.util.PriorityQueue

class Solver {
    fun findSolutions(level: Level): Set<Board> {
        val statesToCheck = PriorityQueue<SolverState>(compareBy { it.tracksUsed })
        val statesChecked = mutableSetOf<SolverState>()
        statesToCheck.add(SolverState(level.board, level.cars, 0, ExpectedCars(level.cars)))
        val solutions = mutableSetOf<Board>()
        while (statesToCheck.isNotEmpty()) {
            val state = statesToCheck.poll()
            if (state.isSolved()) {
                solutions.add(state.board)
                continue
            }
            statesChecked.add(state)
            val nextStates = state.nextStates(initialCars = level.cars)
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
        statesToCheck.add(SolverState(level.board, level.cars, 0, ExpectedCars(level.cars)) to 1)
        val solutions = mutableSetOf<Board>()
        while (statesToCheck.isNotEmpty()) {
            val (state, depth) = statesToCheck.poll()
            yield(state)
            if (state.isSolved()) {
                solutions.add(state.board)
                continue
            }
            statesChecked.add(state)
            val nextStates = state.nextStates(initialCars = level.cars)
                .filter { it.tracksUsed <= level.tracks }
            statesToCheck.addAll((nextStates.toSet() - statesChecked).map { it to depth + 1 })
        }
    }

    private fun SolverState.isSolved(): Boolean {
        return activeCars.isEmpty()
    }

    private fun SolverState.nextStates(initialCars: ImmutableArray<Car>): List<SolverState> {
        var partialStates = getMoves(PartialSolverState(this, emptyList()), 0, initialCars)
        for (carIndex in 1..activeCars.lastIndex) {
            val updatedPartialStates = mutableListOf<PartialSolverState>()
            for (partialState in partialStates) {
                val state = partialState.state
                if (state.activeCars == initialCars) {
                    updatedPartialStates.add(partialState)
                } else {
                    val adjustedCarIndex = state.activeCars.indexOf(activeCars[carIndex])
                    updatedPartialStates.addAll(
                        getMoves(
                            PartialSolverState(state, emptyList()),
                            adjustedCarIndex,
                            initialCars
                        )
                    )
                }
            }
            partialStates = updatedPartialStates.filterNoCollisions(this, carIndex, initialCars)
        }
        return partialStates.map { it.applyActions() }
    }

    private fun List<PartialSolverState>.filterNoCollisions(
        previousState: SolverState,
        carIndex: Int,
        initialCars: ImmutableArray<Car>
    ): List<PartialSolverState> = filter { partialState ->
        val state = partialState.state
        if (state.activeCars == initialCars) return@filter true
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
        carIndex: Int,
        initialCars: ImmutableArray<Car>
    ): List<PartialSolverState> {
        val state = partialState.state
        val position = state.activeCars[carIndex].position
        val tile = state.board[position.row, position.column]
        val newPosition = tile.getNextPosition(position)
        if (newPosition.row < 0 || newPosition.row >= state.board.rows) return emptyList()
        if (newPosition.column < 0 || newPosition.column >= state.board.columns) return emptyList()
        val car = state.activeCars[carIndex].copy(position = newPosition)
        val newCars = state.activeCars.mapAt(carIndex) { it.copy(position = newPosition) }
        return when (val newTile = state.board[newPosition.row, newPosition.column]) {
            Obstacle -> emptyList()
            Empty -> availableTilesByDirection.getValue(car.direction)
                .filter { state.board.canInsert(newPosition.row, newPosition.column, it) }
                .map {
                    PartialSolverState(
                        state.copy(
                            board = state.board.withInserted(newPosition.row, newPosition.column, car.direction, it),
                            activeCars = state.activeCars.mapAt(carIndex) { it.copy(position = newPosition) },
                            tracksUsed = state.tracksUsed + 1
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
            is Fork -> when (car.direction) {
                in newTile.incomingDirections -> {
                    listOf(PartialSolverState(state.copy(activeCars = newCars), partialState.actions))
                }

                in newTile.secondaryIncomingDirections -> {
                    newTile.secondaryIncomingDirections.getValue(car.direction).map { modifiedTile ->
                        PartialSolverState(
                            state.copy(
                                board = state.board.with(newPosition.row, newPosition.column, modifiedTile),
                                activeCars = if (newTile is ResetCarsAfterModification) {
                                    initialCars
                                } else {
                                    newCars
                                },
                                expectedCars = if (newTile is ResetCarsAfterModification) {
                                    ExpectedCars(initialCars)
                                } else {
                                    state.expectedCars
                                }
                            ),
                            partialState.actions
                        )
                    }
                }

                else -> emptyList()
            }

            is Tunnel -> listOf(PartialSolverState(state.copy(activeCars = newCars), partialState.actions))
        }
    }

    companion object {
        private val availableTilesByDirection = mapOf(
            LEFT to setOf(HorizontalTrack, UpRightTurn(), DownRightTurn()),
            RIGHT to setOf(HorizontalTrack, UpLeftTurn(), DownLeftTurn()),
            UP to setOf(VerticalTrack, DownLeftTurn(), DownRightTurn()),
            DOWN to setOf(VerticalTrack, UpLeftTurn(), UpRightTurn()),
        )
    }
}

