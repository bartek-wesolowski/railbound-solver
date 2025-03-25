package solver

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.PersistentSet
import kotlinx.collections.immutable.minus
import kotlinx.collections.immutable.persistentSetOf
import kotlinx.collections.immutable.toPersistentSet
import model.Action
import model.Action.ToggleColor
import model.Action.ToggleFork
import model.Barrier
import model.Board
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
import model.ToggleableFork
import model.Tunnel
import java.util.EnumSet

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
                toggledForks = persistentSetOf(),
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
                    solutions.add(level.board.merge(state.board))
                }
                continue
            }
            val nextStates = state.nextStates(level.board.hasToggleableForks).run {
                if (level.board.hasToggleableForks) {
                    filter { it.createBreadcrumb() !in state.breadcrumbs }
                } else {
                    val breadcrumb = state.createBreadcrumb()
                    filter { it.createBreadcrumb() != breadcrumb }
                }
            }
            statesToCheck.addAll(nextStates)
        }
        return solutions
    }

    fun getSolverStates(level: Level): Sequence<SolverState> = sequence {
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
                toggledForks = persistentSetOf(),
                requiredTilesRemaining = level.board.requiredTiles,
                breadcrumbs = persistentSetOf(),
                carBreadcrumbs = CarBreadcrumbs(level.cars),
            )
        )
        val solutions = mutableSetOf<Board>()
        while (statesToCheck.isNotEmpty()) {
            val state = statesToCheck.removeLast()
            yield(state)
            if (state.activeCars.isEmpty()) {
                if (state.board.isAllPlatformsEmpty()) {
                    solutions.add(state.board)
                }
                continue
            }
            val nextStates = state.nextStates(level.board.hasToggleableForks).run {
                if (level.board.hasToggleableForks) {
                    filter { it.createBreadcrumb() !in state.breadcrumbs }
                } else {
                    val breadcrumb = state.createBreadcrumb()
                    filter { it.createBreadcrumb() != breadcrumb }
                }
            }
            statesToCheck.addAll(nextStates)
        }
    }

    private fun SolverState.nextStates(hasToggleableForks: Boolean): List<SolverState> {
        val carPositions = activeCars.map { Position(it.row, it.column) }
        var partialStates = getMoves(
            partialState = PartialSolverState(
                state = this,
                actions = listOf(),
                enterTiles = enterTiles.filterKeys { it in carPositions },
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
            val state = partialState.state
            state.copy(
                board = state.board.withAppliedActions(partialState.actions),
                enterTiles = partialState.enterTiles,
                getInProgress = state.getInProgress.update(partialState.actions),
                toggledColors = state.toggledColors.withUpdatedToggledColors(partialState.actions),
                toggledForks = state.toggledForks.withUpdatedToggledForks(partialState.actions),
                breadcrumbs = if (hasToggleableForks) {
                    state.breadcrumbs.add(createBreadcrumb())
                } else {
                    state.breadcrumbs
                }
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
        if (actions.count { it is ToggleColor } == 0) return this
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

    private fun PersistentSet<Position>.withUpdatedToggledForks(actions: List<Action>): PersistentSet<Position> {
        if (actions.count { it is ToggleFork } == 0) return this
        return HashSet(this).apply {
            actions.forEach { action ->
                if (action is ToggleFork) {
                    val position = Position(action.row, action.column)
                    if (position in this) {
                        remove(position)
                    } else {
                        add(position)
                    }
                }
            }
        }.toPersistentSet()
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
        val newCarPosition = tile.getNextPosition(car, state.board.tunnelExits, state.getInProgress[car.number])
        val newPosition = newCarPosition.asPosition()
        if (newCarPosition.row < 0 || newCarPosition.row >= state.board.rows) return emptyList()
        if (newCarPosition.column < 0 || newCarPosition.column >= state.board.columns) return emptyList()
        if (car.position != newCarPosition && state.carBreadcrumbs.contains(car.number, newCarPosition)) {
            return emptyList()
        }
        val newCar = state.activeCars[carIndex].copy(position = newCarPosition)
        val newDirection = newCar.direction
        return when (val newTile = state.board[newCarPosition.row, newCarPosition.column]) {
            Obstacle -> emptyList()
            is Platform -> emptyList()
            Empty -> if (state.tracks > 0) {
                if (state.tracks - state.requiredTilesRemaining.size > 0 || newPosition in state.requiredTilesRemaining) {
                    availableTilesByDirection.getValue(newDirection)
                        .flatMap { availableTile ->
                            state.board.tryInsert(
                                newCarPosition.row,
                                newCarPosition.column,
                                availableTile,
                                state.traverseDirections
                            ).map { availableTile to it }
                        }
                        .map { (insertedTile, updatedBoard) ->
                            partialState.copy(
                                state = state.copy(
                                    board = updatedBoard,
                                    activeCars = state.activeCars.withNewCarPosition(carIndex, newCarPosition),
                                    tracks = state.tracks - 1,
                                    traverseDirections = if (insertedTile is VerticalTrack || insertedTile is HorizontalTrack) {
                                        state.traverseDirections.with(newPosition, newDirection)
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
                newDirection in newTile.incomingDirections &&
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
                if (newDirection in newTile.incomingDirections) {
                    if (partialState.isCarCycleOnFork(newTile, newCar)) return@buildList
                    val traverseDirections = if (newTile is VerticalTrack || newTile is HorizontalTrack) {
                        partialState.state.traverseDirections.with(newPosition, newDirection)
                    } else {
                        partialState.state.traverseDirections
                    }
                    val carBreadcrumbs = if (newTile is ToggleableFork) {
                        state.carBreadcrumbs.reset(car.number)
                    } else {
                        state.carBreadcrumbs.plus(car.number, newCarPosition)
                    }
                    val enterTiles = if (newTile is ToggleableFork) {
                        partialState.enterTiles + (newPosition to newTile)
                    } else {
                        partialState.enterTiles
                    }
                    if (newTile is Barrier && !newTile.open) {
                        add(partialState)
                    } else {
                        val actions =
                            if (newTile is HasAction && newTile.getAction(partialState.state.board, newCar) != null) {
                                partialState.actions + newTile.getAction(partialState.state.board, newCar)!!
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
                        newDirection,
                        state.traverseDirections.getOrDefault(newPosition, noTraverseDirections)
                    )
                    addAll(
                        modifiedTiles
                            .filter { modifiedTile ->
                                !partialState.isCarCycleOnFork(modifiedTile, newCar)
                            }
                            .flatMap { modifiedTile ->
                                state.board.tryInsert(
                                    newCarPosition.row,
                                    newCarPosition.column,
                                    modifiedTile,
                                    state.traverseDirections
                                )
                            }
                            .map { updatedBoard ->
                                partialState.copy(
                                    state = state.copy(
                                        board = updatedBoard,
                                        activeCars = state.activeCars.withNewCarPosition(carIndex, newCarPosition),
                                        carBreadcrumbs = state.carBreadcrumbs.plus(car.number, newCarPosition),
                                    )
                                )
                            }
                    )
                }
            }

            is Tunnel -> if (newDirection in newTile.incomingDirections) {
                listOf(
                    partialState.copy(
                        state = state.copy(
                            activeCars = state.activeCars.withNewCarPosition(carIndex, newCarPosition),
                            carBreadcrumbs = state.carBreadcrumbs.plus(car.number, newCarPosition),
                        )
                    )
                )
            } else {
                emptyList()
            }
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

    private fun PartialSolverState.isCarCycleOnFork(tile: Tile, car: Car): Boolean {
        if (tile is Fork && tile !is ToggleableFork) {
            val nextPosition = tile.getNextPosition(car, emptyMap(), null)
            for (direction in tile.incomingDirections) {
                if (direction == car.direction) continue
                val nextPosition2 = tile.getNextPosition(
                    car.copy(position = car.position.copy(direction = direction)),
                    emptyMap(),
                    null
                )
                if (nextPosition2 == nextPosition && state.carBreadcrumbs.contains(
                        car.number,
                        car.position.copy(direction = direction)
                    )
                ) {
                    return true
                }
            }
        }
        return false
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

