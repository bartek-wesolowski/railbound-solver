package solver

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import com.danrusu.pods4k.immutableArrays.buildImmutableArray
import com.danrusu.pods4k.immutableArrays.indexOf
import com.danrusu.pods4k.immutableArrays.multiplicativeSpecializations.map
import com.danrusu.pods4k.immutableArrays.toSet
import model.Tile.*
import model.Board
import model.Car
import model.CarPosition
import model.Direction.*
import model.Fork
import model.Level
import model.ResetCarsAfterModification
import model.StraightTrack
import model.Tunnel
import model.Turn
import java.util.EnumMap
import java.util.PriorityQueue

class Solver {
    fun findSolutions(level: Level): Set<Board> {
        val statesToCheck = PriorityQueue<SolverState>(compareBy { it.tracksUsed })
        val statesChecked = mutableSetOf<SolverState>()
        val expectedCar = EnumMap(level.cars.map { it.color }.toSet().associateWith { 1 })
        statesToCheck.add(SolverState(level.board, level.cars, 0, expectedCar))
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
        val expectedCar = EnumMap(level.cars.map { it.color }.toSet().associateWith { 1 })
        statesToCheck.add(SolverState(level.board, level.cars, 0, expectedCar) to 1)
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
        var nextStates = getMoves(this, 0, initialCars)
        for (carIndex in 1..activeCars.lastIndex) {
            val updatedNextStates = mutableListOf<SolverState>()
            for (state in nextStates) {
                if (state.activeCars == initialCars) {
                    updatedNextStates.add(state)
                } else {
                    val adjustedCarIndex = state.activeCars.indexOf(activeCars[carIndex])
                    updatedNextStates.addAll(getMoves(state, adjustedCarIndex, initialCars))
                }
            }
            nextStates = updatedNextStates.filter { state ->
                if (state.activeCars == initialCars) return@filter true
                val carAIndex = state.activeCars.indexOfFirst {
                    it.color == activeCars[carIndex].color && it.number == activeCars[carIndex].number
                }
                if (carAIndex == -1) return@filter true
                val carA = state.activeCars[carAIndex]
                for (carBIndex in 0 until carAIndex) {
                    val carB = state.activeCars[carBIndex]
                    if (carB.position.row == carA.position.row && carA.position.column == carB.position.column) {
                        return@filter false
                    }
                    val initialCarBIndex = activeCars.indexOfFirst {
                        it.color == carB.color && it.number == carB.number
                    }
                    if (initialCarBIndex != -1) {
                        val initialCarA = activeCars[carIndex]
                        val initialCarB = activeCars[initialCarBIndex]
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
        }
        return nextStates
    }

    private fun getMoves(
        state: SolverState,
        carIndex: Int,
        initialCars: ImmutableArray<Car>
    ): List<SolverState> {
        val position = state.activeCars[carIndex].position
        val tile = state.board[position.row, position.column]
        return state.moveCar(carIndex, tile.getNextPosition(position), initialCars)
    }

    private fun SolverState.moveCar(
        carIndex: Int,
        newPosition: CarPosition,
        initialCars: ImmutableArray<Car>
    ): List<SolverState> {
        if (newPosition.row < 0 || newPosition.row >= board.rows) return emptyList()
        if (newPosition.column < 0 || newPosition.column >= board.columns) return emptyList()
        val car = activeCars[carIndex].copy(position = newPosition)
        val newCars = activeCars.updatePosition(carIndex, newPosition)
        return when (val tile = board[newPosition.row, newPosition.column]) {
            Obstacle -> emptyList()
            Empty -> availableTilesByDirection.getValue(car.direction)
                .filter { board.canInsert(newPosition.row, newPosition.column, it) }
                .map {
                    copy(
                        board = board.withInserted(newPosition.row, newPosition.column, car.direction,  it),
                        activeCars = activeCars.updatePosition(carIndex, newPosition),
                        tracksUsed = tracksUsed + 1
                    )
                }

            EndingTrack -> if (
                (car.direction in tile.incomingDirections) &&
                expectedCar[car.color] == car.number
            ) {
                listOf(
                    copy(
                        activeCars = buildImmutableArray {
                            for (i in activeCars.indices) {
                                if (i != carIndex) {
                                    add(activeCars[i])
                                }
                            }
                        },
                        expectedCar = EnumMap(expectedCar).apply { put(car.color, get(car.color)!! + 1) })
                )
            } else {
                emptyList()
            }

            is StraightTrack,
            is Turn,
            is Fork -> when (car.direction) {
                in tile.incomingDirections -> {
                    listOf(copy(activeCars = newCars))
                }

                in tile.secondaryIncomingDirections -> {
                    tile.secondaryIncomingDirections.getValue(car.direction).map { modifiedTile ->
                        copy(
                            board = board.with(newPosition.row, newPosition.column, modifiedTile),
                            activeCars = if (tile is ResetCarsAfterModification) {
                                initialCars
                            } else {
                                newCars
                            },
                            expectedCar = if (tile is ResetCarsAfterModification) {
                                EnumMap(initialCars.map { it.color }.toSet().associateWith { 1 })
                            } else {
                                expectedCar
                            }
                        )
                    }
                }

                else -> emptyList()
            }

            is Tunnel -> listOf(copy(activeCars = newCars))
        }
    }

    private fun ImmutableArray<Car>.updatePosition(carIndex: Int, newPosition: CarPosition): ImmutableArray<Car> {
        return buildImmutableArray {
            for (i in indices) {
                if (i == carIndex) {
                    add(this@updatePosition[i].copy(position = newPosition))
                } else {
                    add(this@updatePosition[i])
                }
            }
        }
    }

    companion object {
        private val availableTilesByDirection = mapOf(
            LEFT to setOf(HorizontalTrack(), UpRightTurn(), DownRightTurn()),
            RIGHT to setOf(HorizontalTrack(), UpLeftTurn(), DownLeftTurn()),
            UP to setOf(VerticalTrack(), DownLeftTurn(), DownRightTurn()),
            DOWN to setOf(VerticalTrack(), UpLeftTurn(), UpRightTurn()),
        )
    }
}

