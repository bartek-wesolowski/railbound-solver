package solver

import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import com.danrusu.pods4k.immutableArrays.indexOf
import com.danrusu.pods4k.immutableArrays.multiplicativeSpecializations.map
import com.danrusu.pods4k.immutableArrays.plus
import model.Barrier
import model.Board
import model.Car
import model.Direction
import model.Direction.DOWN
import model.Direction.LEFT
import model.Direction.RIGHT
import model.Direction.UP
import model.Fork
import model.HasAction
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
        statesToCheck.add(SolverState(level.board, level.cars, 0, 1, emptyMap(), emptyMap()))
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
                .filter { it !in statesChecked }
            statesToCheck.addAll(nextStates)
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
        statesToCheck.add(SolverState(level.board, level.cars, 0, 1, emptyMap(), emptyMap()) to 1)
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
        var partialStates = getMoves(
            partialState = PartialSolverState(
                state = this,
                actions = immutableArrayOf(),
                enterTiles = emptyMap()
            ),
            carIndex = 0
        )
        for (carIndex in 1..activeCars.lastIndex) {
            val updatedPartialStates = mutableListOf<PartialSolverState>()
            for (partialState in partialStates) {
                val state = partialState.state
                    val adjustedCarIndex = state.activeCars.indexOf(activeCars[carIndex])
                    updatedPartialStates.addAll(getMoves(partialState, adjustedCarIndex))
            }
            partialStates = updatedPartialStates.filterNoCollisions(board, this, carIndex)
        }
        return partialStates.map { partialState ->
            partialState.applyActions()
                .copy(enterTiles = partialState.enterTiles)
        }
    }

    private fun List<PartialSolverState>.filterNoCollisions(
        board: Board,
        previousState: SolverState,
        carIndex: Int
    ): List<PartialSolverState> = filter { partialState ->
        val state = partialState.state
        val carA = state.activeCars.firstOrNull {
            it.number == previousState.activeCars[carIndex].number
        } ?: return@filter true
        for (carB in state.activeCars) {
            if (carB == carA) break
            if (carB.row == carA.row && carA.column == carB.column) {
                return@filter false
            }
            val initialCarB = previousState.activeCars.first {
                it.number == carB.number
            }
            val initialCarA = previousState.activeCars[carIndex]
            val initialTileA = board[initialCarA.row, initialCarA.column]
            val initialTileB = board[initialCarB.row, initialCarB.column]
            if (initialTileA is Tunnel) {
                if (initialTileB is Tunnel && initialTileA.color == initialTileB.color) return@filter false
                val tileB = board[carB.row, carB.column]
                if (tileB is Tunnel && initialTileA.color == tileB.color && initialTileA != tileB) return@filter false
            } else if (initialTileB is Tunnel) {
                val tileA = board[carA.row, carA.column]
                if (tileA is Tunnel && initialTileB.color == tileA.color && initialTileB != tileA) return@filter false
            } else {
                if (arePositionsSwitched(initialCarA, carA, initialCarB, carB)) return@filter false
            }
        }
        true
    }

    private fun arePositionsSwitched(initialCarA: Car, carA: Car, initialCarB: Car, carB: Car): Boolean {
        return initialCarB.row == carA.row &&
                initialCarB.column == carA.column &&
                initialCarA.row == carB.row &&
                initialCarA.column == carB.column
    }

    private fun getMoves(
        partialState: PartialSolverState,
        carIndex: Int
    ): List<PartialSolverState> {
        val state = partialState.state
        val carPosition = state.activeCars[carIndex].position
        val position = carPosition.asPosition()
        val tile = if (position in state.enterTiles) {
            state.enterTiles.getValue(position)
        } else {
            state.board[carPosition.row, carPosition.column]
        }
        val newCarPosition = tile.getNextPosition(carPosition)
        val newPosition = newCarPosition.asPosition()
        if (newCarPosition.row < 0 || newCarPosition.row >= state.board.rows) return emptyList()
        if (newCarPosition.column < 0 || newCarPosition.column >= state.board.columns) return emptyList()
        val car = state.activeCars[carIndex].copy(position = newCarPosition)
        val newCars = state.activeCars.mapAt(carIndex) { it.copy(position = newCarPosition) }
        return when (val newTile = state.board[newCarPosition.row, newCarPosition.column]) {
            Obstacle -> emptyList()
            Empty -> availableTilesByDirection.getValue(car.direction)
                .filter { availableTile ->
                    state.board.canInsert(
                        newCarPosition.row,
                        newCarPosition.column,
                        availableTile,
                        state.traverseDirections.getOrDefault(newPosition, EnumSet.noneOf(Direction::class.java))
                    )
                }
                .map { insertedTile ->
                    partialState.copy(
                        state = state.copy(
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
                        )
                    )
                }

            EndingTrack -> if (
                car.direction in newTile.incomingDirections &&
                state.expectedCar == car.number
            ) {
                listOf(
                    partialState.copy(
                        state = state.copy(
                            activeCars = state.activeCars.removeAt(carIndex),
                            expectedCar = state.expectedCar + 1
                        )
                    )
                )
            } else {
                emptyList()
            }

            is StraightTrack,
            is Turn,
            is Fork -> buildList {
                if (car.direction in newTile.incomingDirections) {
                    val traverseDirections = if (newTile is VerticalTrack || newTile is HorizontalTrack) {
                        partialState.state.traverseDirections.with(newPosition, car.direction)
                    } else {
                        partialState.state.traverseDirections
                    }
                    val enterTiles = if (newTile is Fork && newTile.color != null) {
                        partialState.enterTiles + (newPosition to newTile)
                    } else {
                        partialState.enterTiles
                    }
                    if (newTile is Barrier && !newTile.open) {
                        add(partialState)
                    } else {
                        val actions = if (newTile is HasAction && newTile.action != null) {
                            partialState.actions + newTile.action!!
                        } else {
                            partialState.actions
                        }
                        add(
                            partialState.copy(
                                state = state.copy(
                                    activeCars = newCars,
                                    traverseDirections = traverseDirections,
                                ),
                                actions = actions,
                                enterTiles = enterTiles
                            )
                        )
                    }
                }
                if (newTile is ModifiableTile) {
                    val incomingDirectionsAfterModification = newTile.getIncomingDirectionsAfterModification(
                        state.traverseDirections.getOrDefault(
                            newPosition,
                            EnumSet.noneOf(Direction::class.java)
                        )
                    )
                    if (car.direction in incomingDirectionsAfterModification) {
                        addAll(
                            incomingDirectionsAfterModification
                                .getValue(car.direction)
                                .filter { modifiedTile ->
                                    state.board.canInsert(
                                        newCarPosition.row,
                                        newCarPosition.column,
                                        modifiedTile,
                                        state.traverseDirections.getOrDefault(
                                            newPosition,
                                            EnumSet.noneOf(Direction::class.java)
                                        )
                                    )
                                }
                                .map { modifiedTile ->
                                    partialState.copy(
                                        state = state.copy(
                                            board = state.board.with(
                                                newCarPosition.row,
                                                newCarPosition.column,
                                                modifiedTile
                                            ),
                                            activeCars = newCars,
                                        )
                                    )
                                }
                                .asIterable()
                        )
                    }
                }
            }

            is Tunnel -> listOf(partialState.copy(state = state.copy(activeCars = newCars)))
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
            LEFT to setOf(HorizontalTrack(), UpRightTurn(), DownRightTurn()),
            RIGHT to setOf(HorizontalTrack(), UpLeftTurn(), DownLeftTurn()),
            UP to setOf(VerticalTrack(), DownLeftTurn(), DownRightTurn()),
            DOWN to setOf(VerticalTrack(), UpLeftTurn(), UpRightTurn()),
        )
    }
}

