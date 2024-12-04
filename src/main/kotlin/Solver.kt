package com.bartoszwesolowski

import com.bartoszwesolowski.Direction.*
import com.bartoszwesolowski.Tile.*
import java.util.EnumMap
import java.util.PriorityQueue

class Solver {
    fun findSolutions(board: Board, cars: ArrayList<Car>): Set<Board> {
        val statesToCheck = PriorityQueue<SolverState>(compareBy { it.tracksUsed })
        val statesChecked = mutableSetOf<SolverState>()
        val expectedCar = EnumMap(cars.map { it.color }.toSet().associateWith { 1 })
        statesToCheck.add(SolverState(board, cars, 0, expectedCar))
        val solutions = mutableSetOf<Board>()
        while (statesToCheck.isNotEmpty()) {
            val state = statesToCheck.poll()
            println("checking $state")
            if (state.isSolved()) {
                solutions.add(state.board)
                continue
            }
            statesChecked.add(state)
            val nextStates = state.nextStates().toList()
            println("next states: $nextStates")
            statesToCheck.addAll(nextStates.toSet() - statesChecked)
        }
        return solutions
    }

    private fun SolverState.isSolved(): Boolean {
        return activeCars.isEmpty()
    }

    private fun SolverState.nextStates(): List<SolverState> {
        var nextStates = getMoves(this, 0)
        for (carIndex in 1..activeCars.lastIndex) {
            val updatedNextStates = mutableListOf<SolverState>()
            for (state in nextStates) {
                updatedNextStates.addAll(getMoves(state, carIndex))
            }
            nextStates = updatedNextStates
        }
        return nextStates
    }

    private fun getMoves(state: SolverState, carIndex: Int): List<SolverState> {
        val car = state.activeCars[carIndex]
        return when (state.board[car.position.row, car.position.column]) {
            is Empty -> throw IllegalStateException("Car is not on a track")
            is EndingTrack -> throw IllegalStateException("Car is on an ending track")
            is Obstacle -> throw IllegalStateException("Car is on an obstacle")
            is HorizontalTrack -> when (car.direction) {
                LEFT -> {
                    val newPosition = car.position.copy(column = car.position.column - 1)
                    state.moveCar(carIndex, newPosition)
                }

                RIGHT -> {
                    val newPosition = car.position.copy(column = car.position.column + 1)
                    state.moveCar(carIndex, newPosition)
                }

                UP, DOWN ->
                    throw IllegalStateException("Car is on a horizontal track but its direction is not horizontal")
            }

            is VerticalTrack -> {
                when (car.direction) {
                    UP -> {
                        val newPosition = car.position.copy(row = car.position.row - 1)
                        state.moveCar(carIndex, newPosition)
                    }

                    DOWN -> {
                        val newPosition = car.position.copy(row = car.position.row + 1)
                        state.moveCar(carIndex, newPosition)
                    }

                    LEFT, RIGHT ->
                        throw IllegalStateException("Car is on a vertical track but its direction is not vertical")
                }
            }

            DownLeftTurn -> when (car.direction) {
                UP -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        column = car.position.column - 1,
                        direction = LEFT
                    )
                )

                RIGHT -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        row = car.position.row + 1,
                        direction = DOWN
                    )
                )

                DOWN -> throw IllegalStateException("Car is on a down left turn and its direction is down")
                LEFT -> throw IllegalStateException("Car is on a down left turn and its direction is left")
            }

            DownRightTurn -> when (car.direction) {
                UP -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        column = car.position.column + 1,
                        direction = RIGHT
                    )
                )

                LEFT -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        row = car.position.row + 1,
                        direction = DOWN
                    )
                )

                DOWN -> throw IllegalStateException("Car is on a down right turn and its direction is down")
                RIGHT -> throw IllegalStateException("Car is on a down right turn and its direction is right")
            }

            UpLeftTurn -> when (car.direction) {
                DOWN -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        column = car.position.column - 1,
                        direction = LEFT
                    )
                )

                RIGHT -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        row = car.position.row - 1,
                        direction = UP
                    )
                )

                UP -> throw IllegalStateException("Car is on an up left turn and its direction is up")
                LEFT -> throw IllegalStateException("Car is on an up left turn and its direction is left")
            }

            UpRightTurn -> when (car.direction) {
                DOWN -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        column = car.position.column + 1,
                        direction = RIGHT
                    )
                )

                LEFT -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        row = car.position.row - 1,
                        direction = UP
                    )
                )

                UP -> throw IllegalStateException("Car is on an up right turn and its direction is up")
                RIGHT -> throw IllegalStateException("Car is on an up right turn and its direction is right")
            }

            DownLeftRightFork -> when (car.direction) {
                UP -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        column = car.position.column - 1,
                        direction = LEFT
                    )
                )

                LEFT -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        row = car.position.column - 1,
                    )
                )

                RIGHT -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        row = car.position.row + 1,
                        direction = DOWN
                    )
                )

                DOWN -> throw IllegalStateException("Car is on a down left right fork and its direction is down")
            }

            DownLeftUpFork -> TODO()
            DownRightLeftFork -> TODO()
            DownRightUpFork -> TODO()
            UpLeftDownFork -> TODO()
            UpLeftRightFork -> TODO()
            UpRightDOWNFork -> TODO()
            UpRightLeftFork -> TODO()
        }
    }

    private fun SolverState.moveCar(carIndex: Int, newPosition: CarPosition): List<SolverState> {
        if (newPosition.row < 0 || newPosition.row >= board.rows) return emptyList()
        if (newPosition.column < 0 || newPosition.column >= board.columns) return emptyList()
        val car = activeCars[carIndex].copy(position = newPosition)
        return when (board[newPosition.row, newPosition.column]) {
            is Obstacle -> emptyList()
            is Empty -> availableTilesByDirection.getValue(car.direction)
                .filter { board.canInsert(newPosition.row, newPosition.column, it) }
                .map {
                    copy(
                        board = board.with(newPosition.row, newPosition.column, it),
                        activeCars = activeCars.updatePosition(carIndex, newPosition),
                        tracksUsed = tracksUsed + 1
                    )
                }

            is EndingTrack -> {
                if (
                    (car.direction == LEFT || car.direction == RIGHT) &&
                    expectedCar[car.color] == car.number
                ) {
                    val newCars = ArrayList(activeCars).apply { removeAt(carIndex) }
                    listOf(
                        copy(
                            activeCars = newCars,
                            expectedCar = EnumMap(expectedCar).apply { put(car.color, get(car.color)!! + 1) })
                    )
                } else {
                    emptyList()
                }
            }

            is HorizontalTrack -> {
                if (car.direction == LEFT || car.direction == RIGHT) {
                    val newCars = activeCars.updatePosition(carIndex, newPosition)
                    listOf(copy(activeCars = newCars))
                } else {
                    emptyList()
                }
            }

            is VerticalTrack -> {
                if (car.direction == UP || car.direction == DOWN) {
                    val newCars = activeCars.updatePosition(carIndex, newPosition)
                    listOf(copy(activeCars = newCars))
                } else {
                    emptyList()
                }
            }

            DownLeftTurn -> if (car.direction == UP || car.direction == RIGHT) {
                val newCars = activeCars.updatePosition(carIndex, newPosition)
                listOf(copy(activeCars = newCars))
            } else {
                emptyList()
            }

            DownRightTurn -> if (car.direction == UP || car.direction == LEFT) {
                val newCars = activeCars.updatePosition(carIndex, newPosition)
                listOf(copy(activeCars = newCars))
            } else {
                emptyList()
            }

            UpLeftTurn -> if (car.direction == DOWN || car.direction == RIGHT) {
                val newCars = activeCars.updatePosition(carIndex, newPosition)
                listOf(copy(activeCars = newCars))
            } else {
                emptyList()
            }

            UpRightTurn -> if (car.direction == DOWN || car.direction == LEFT) {
                val newCars = activeCars.updatePosition(carIndex, newPosition)
                listOf(copy(activeCars = newCars))
            } else {
                emptyList()
            }

            DownLeftRightFork -> if (car.direction == UP || car.direction == RIGHT || car.direction == LEFT) {
                val newCars = activeCars.updatePosition(carIndex, newPosition)
                listOf(copy(activeCars = newCars))
            } else {
                emptyList()
            }

            DownLeftUpFork -> TODO()
            DownRightLeftFork -> TODO()
            DownRightUpFork -> TODO()
            UpLeftDownFork -> TODO()
            UpLeftRightFork -> TODO()
            UpRightDOWNFork -> TODO()
            UpRightLeftFork -> TODO()
        }
    }

    private fun ArrayList<Car>.updatePosition(carIndex: Int, newPosition: CarPosition): ArrayList<Car> {
        val newCars = ArrayList(this)
        newCars[carIndex] = newCars[carIndex].copy(position = newPosition)
        return newCars
    }
}

private val availableTilesByDirection = mapOf(
    LEFT to setOf(HorizontalTrack, UpRightTurn, DownRightTurn),
    RIGHT to setOf(HorizontalTrack, UpLeftTurn, DownLeftTurn),
    UP to setOf(VerticalTrack, DownLeftTurn, DownRightTurn),
    DOWN to setOf(VerticalTrack, UpLeftTurn, UpRightTurn),
)