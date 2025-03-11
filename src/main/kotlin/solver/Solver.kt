package solver

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.minus
import kotlinx.collections.immutable.persistentSetOf
import model.Action
import model.Action.ToggleColor
import model.Barrier
import model.Board
import model.Breadcrumb
import model.Car
import model.CarPosition
import model.Color
import model.Direction
import model.Direction.DOWN
import model.Direction.LEFT
import model.Direction.RIGHT
import model.Direction.UP
import model.HasAction
import model.Level
import model.ModifiableTile
import model.Position
import model.StraightTrack
import model.Tile
import model.Tile.BaseHorizontalTrack.HorizontalTrack
import model.Tile.BaseVerticalTrack.VerticalTrack
import model.Tile.Empty
import model.Tile.EndingTrack
import model.Tile.Fork
import model.Tile.Obstacle
import model.Tile.Platform
import model.Tile.Turn
import model.Tile.Turn.BaseDownLeftTurn.DownLeftTurn
import model.Tile.Turn.BaseDownRightTurn.DownRightTurn
import model.Tile.Turn.BaseUpLeftTurn.UpLeftTurn
import model.Tile.Turn.BaseUpRightTurn.UpRightTurn
import model.Toggleable
import model.Tunnel
import java.util.EnumSet
import java.util.PriorityQueue

class Solver {
    fun findSolutions(level: Level): Set<Board> {
        val statesToCheck = ArrayList<SolverState>()
        statesToCheck.add(
            SolverState(
                board = level.board,
                activeCars = level.cars,
                tracks = level.tracks,
                expectedCar = 1,
                traverseDirections = emptyMap(),
                enterTiles = emptyMap(),
                getInProgress = GetInProgress(level.cars),
                toggledColors = EnumSet.noneOf(Color::class.java),
                requiredTilesRemaining = level.board.requiredTiles,
                breadcrumbs = persistentSetOf(),
                carBreadcrumbs = CarBreadcrumbs(level.cars),
            )
        )
        val solutions = mutableSetOf<Board>()
        while (statesToCheck.isNotEmpty()) {
            val state = statesToCheck.removeLast()
            if (state.activeCars.isEmpty()) {
                if (state.board.isAllPlatformsEmpty()) {
                    solutions.add(state.board)
                }
                continue
            }
            val nextStates = state.nextStates()
                .filter { Breadcrumb(it.activeCars, it.toggledColors, it.getInProgress) !in state.breadcrumbs }
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
        statesToCheck.add(
            SolverState(
                board = level.board,
                activeCars = level.cars,
                tracks = level.tracks,
                expectedCar = 1,
                traverseDirections = emptyMap(),
                enterTiles = emptyMap(),
                getInProgress = GetInProgress(level.cars),
                toggledColors = EnumSet.noneOf(Color::class.java),
                requiredTilesRemaining = level.board.requiredTiles,
                breadcrumbs = persistentSetOf(),
                carBreadcrumbs = CarBreadcrumbs(level.cars),
            ) to 1
        )
        val solutions = mutableSetOf<Board>()
        while (statesToCheck.isNotEmpty()) {
            val (state, depth) = statesToCheck.poll()
            yield(state)
            if (state.activeCars.isEmpty()) {
                if (state.board.isAllPlatformsEmpty()) {
                    solutions.add(state.board)
                }
                continue
            }
            val nextStates = state.nextStates()
                .filter { Breadcrumb(it.activeCars, it.toggledColors, it.getInProgress) !in state.breadcrumbs }
            statesToCheck.addAll(nextStates.map { it to depth + 1 })
        }
    }

    private fun SolverState.nextStates(): List<SolverState> {
        var partialStates = getMoves(
            partialState = PartialSolverState(
                state = this,
                actions = listOf(),
                enterTiles = emptyMap(),
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
                .copy(
                    enterTiles = partialState.enterTiles,
                    getInProgress = partialState.state.getInProgress.update(partialState.actions),
                    toggledColors = partialState.state.toggledColors.withUpdatedToggledColors(partialState.actions),
                    breadcrumbs = partialState.state.breadcrumbs.add(
                        Breadcrumb(
                            cars = activeCars,
                            toggledColors = toggledColors,
                            getInProgress = getInProgress,
                        )
                    )
                )
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

    private fun EnumSet<Color>.withUpdatedToggledColors(actions: List<Action>): EnumSet<Color> {
        return if (isEmpty()) {
            EnumSet.noneOf(Color::class.java)
        } else {
            EnumSet.copyOf(this)
        }.apply {
            actions.forEach { action ->
                if (action is ToggleColor) {
                    if (action.color in this) {
                        remove(action.color)
                    } else {
                        add(action.color)
                    }
                }
            }
        }
    }

    private fun arePositionsSwitched(initialCarA: Car, carA: Car, initialCarB: Car, carB: Car): Boolean {
        return initialCarB.row == carA.row &&
                initialCarB.column == carA.column &&
                initialCarA.row == carB.row &&
                initialCarA.column == carB.column
    }

    private fun getMoves(
        partialState: PartialSolverState,
        carIndex: Int,
    ): List<PartialSolverState> {
        val state = partialState.state
        val car = state.activeCars[carIndex]
        val carPosition = car.position
        val position = carPosition.asPosition()
        val tile = if (position in state.enterTiles) {
            state.enterTiles.getValue(position)
        } else {
            state.board[carPosition.row, carPosition.column]
        }
        val newCarPosition = tile.getNextPosition(car, partialState.state.getInProgress[car.number])
        val newPosition = newCarPosition.asPosition()
        if (newCarPosition.row < 0 || newCarPosition.row >= state.board.rows) return emptyList()
        if (newCarPosition.column < 0 || newCarPosition.column >= state.board.columns) return emptyList()
        if (car.position != newCarPosition && state.carBreadcrumbs.contains(car.number, newCarPosition)) {
            return emptyList()
        }
        val newCar = state.activeCars[carIndex].copy(position = newCarPosition)
        return when (val newTile = state.board[newCarPosition.row, newCarPosition.column]) {
            Obstacle -> emptyList()
            is Platform -> emptyList()
            Empty -> if (state.tracks > 0) {
                if (state.tracks - state.requiredTilesRemaining.size > 0 || newPosition in state.requiredTilesRemaining) {
                    availableTilesByDirection.getValue(newCar.direction)
                        .filter { availableTile ->
                            state.board.canInsert(
                                newCarPosition.row,
                                newCarPosition.column,
                                availableTile,
                                noTraverseDirections
                            )
                        }
                        .map { insertedTile ->
                            partialState.copy(
                                state = state.copy(
                                    board = state.board.with(
                                        newCarPosition.row,
                                        newCarPosition.column,
                                        insertedTile
                                    ),
                                    activeCars = state.activeCars.withNewCarPosition(carIndex, newCarPosition),
                                    tracks = state.tracks - 1,
                                    traverseDirections = if (insertedTile is VerticalTrack || insertedTile is HorizontalTrack) {
                                        state.traverseDirections.with(newPosition, newCar.direction)
                                    } else {
                                        state.traverseDirections
                                    },
                                    requiredTilesRemaining = if (newPosition in partialState.state.requiredTilesRemaining) {
                                        partialState.state.requiredTilesRemaining.minus(newPosition)
                                    } else {
                                        partialState.state.requiredTilesRemaining
                                    },
                                    carBreadcrumbs = partialState.state.carBreadcrumbs.plus(car.number, newCarPosition),
                                )
                            )
                        }
                } else {
                    emptyList()
                }
            } else {
                emptyList()
            }

            EndingTrack -> if (
                newCar.direction in newTile.incomingDirections &&
                state.expectedCar == newCar.number
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
                if (newCar.direction in newTile.incomingDirections) {
                    val traverseDirections = if (newTile is VerticalTrack || newTile is HorizontalTrack) {
                        partialState.state.traverseDirections.with(newPosition, newCar.direction)
                    } else {
                        partialState.state.traverseDirections
                    }
                    val carBreadcrumbs = if (newTile is Toggleable) {
                        state.carBreadcrumbs.reset(car.number)
                    } else {
                        state.carBreadcrumbs.plus(car.number, newCarPosition)
                    }
                    val enterTiles = if (newTile is Fork && newTile is Toggleable) {
                        partialState.enterTiles + (newPosition to newTile)
                    } else {
                        partialState.enterTiles
                    }
                    if (newTile is Barrier && !newTile.open) {
                        add(partialState)
                    } else {
                        val actions =
                            if (newTile is HasAction && newTile.getAction(partialState.state.board, car) != null) {
                                partialState.actions + newTile.getAction(partialState.state.board, car)!!
                            } else {
                                partialState.actions
                            }
                        add(
                            partialState.copy(
                                state = state.copy(
                                    activeCars = state.activeCars.withNewCarPosition(carIndex, newCarPosition),
                                    traverseDirections = traverseDirections,
                                    carBreadcrumbs = carBreadcrumbs,
                                ),
                                actions = actions,
                                enterTiles = enterTiles,
                            )
                        )
                    }
                }
                if (newTile is ModifiableTile) {
                    val modifiedTiles = newTile.getPossibleModifications(
                        newCar.direction,
                        state.traverseDirections.getOrDefault(
                            newPosition,
                            EnumSet.noneOf(Direction::class.java)
                        )
                    )
                    addAll(
                        modifiedTiles
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
                                        activeCars = state.activeCars.withNewCarPosition(carIndex, newCarPosition),
                                        carBreadcrumbs = state.carBreadcrumbs.plus(car.number, newCarPosition),
                                    )
                                )
                            }
                            .asIterable()
                    )
                }
            }

            is Tunnel -> listOf(
                partialState.copy(
                    state = state.copy(
                        activeCars = state.activeCars.withNewCarPosition(carIndex, newCarPosition),
                        carBreadcrumbs = state.carBreadcrumbs.plus(car.number, newCarPosition),
                    )
                )
            )
        }
    }

    private fun PersistentList<Car>.withNewCarPosition(carIndex: Int, carPosition: CarPosition): PersistentList<Car> {
        val builder = builder()
        builder[carIndex] = get(carIndex).copy(position = carPosition)
        return builder.build()
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
            LEFT to setOf(HorizontalTrack, UpRightTurn, DownRightTurn),
            RIGHT to setOf(HorizontalTrack, UpLeftTurn, DownLeftTurn),
            UP to setOf(VerticalTrack, DownLeftTurn, DownRightTurn),
            DOWN to setOf(VerticalTrack, UpLeftTurn, UpRightTurn),
        )

        private val noTraverseDirections = EnumSet.noneOf(Direction::class.java)
    }
}

