package com.bartoszwesolowski

import com.bartoszwesolowski.Tile.DownLeftTurn
import com.bartoszwesolowski.Tile.DownRightTurn
import com.bartoszwesolowski.Tile.Empty
import com.bartoszwesolowski.Tile.EndingTrack
import com.bartoszwesolowski.Tile.HorizontalTrack
import com.bartoszwesolowski.Tile.Obstacle
import com.bartoszwesolowski.Tile.UpLeftTurn
import com.bartoszwesolowski.Tile.UpRightTurn
import com.bartoszwesolowski.Tile.VerticalTrack
import java.util.EnumMap
import java.util.PriorityQueue

class Solver {
    fun findSolutions(board: Board, cars: ArrayList<Car>): List<Board> {
        val statesToCheck = PriorityQueue<SolverState>(compareBy { it.tracksUsed })
        val expectedCar = EnumMap(cars.map { it.color }.toSet().associateWith { 1 })
        statesToCheck.add(SolverState(board, cars, 0, expectedCar))
        val solutions = mutableListOf<Board>()
        while (statesToCheck.isNotEmpty()) {
            val state = statesToCheck.poll()
            println("checking $state")
            if (state.isSolved()) {
                solutions.add(state.board)
                continue
            }
            val nextStates = state.nextStates().toList()
            println("next states: $nextStates")
            statesToCheck.addAll(nextStates)
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
                Direction.LEFT -> {
                    val newPosition = car.position.copy(column = car.position.column - 1)
                    state.moveCar(carIndex, newPosition)
                }

                Direction.RIGHT -> {
                    val newPosition = car.position.copy(column = car.position.column + 1)
                    state.moveCar(carIndex, newPosition)
                }

                Direction.UP, Direction.DOWN ->
                    throw IllegalStateException("Car is on a horizontal track but its direction is not horizontal")
            }

            is VerticalTrack -> {
                when (car.direction) {
                    Direction.UP -> {
                        val newPosition = car.position.copy(row = car.position.row - 1)
                        state.moveCar(carIndex, newPosition)
                    }

                    Direction.DOWN -> {
                        val newPosition = car.position.copy(row = car.position.row + 1)
                        state.moveCar(carIndex, newPosition)
                    }

                    Direction.LEFT, Direction.RIGHT ->
                        throw IllegalStateException("Car is on a vertical track but its direction is not vertical")
                }
            }

            DownLeftTurn -> when (car.direction) {
                Direction.UP -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        column = car.position.column - 1,
                        direction = Direction.LEFT
                    )
                )

                Direction.RIGHT -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        row = car.position.row + 1,
                        direction = Direction.DOWN
                    )
                )

                Direction.DOWN -> throw IllegalStateException("Car is on a down left turn and its direction is down")
                Direction.LEFT -> throw IllegalStateException("Car is on a down left turn and its direction is left")
            }

            DownRightTurn -> when (car.direction) {
                Direction.UP -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        column = car.position.column + 1,
                        direction = Direction.RIGHT
                    )
                )

                Direction.LEFT -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        row = car.position.row + 1,
                        direction = Direction.DOWN
                    )
                )

                Direction.DOWN -> throw IllegalStateException("Car is on a down right turn and its direction is down")
                Direction.RIGHT -> throw IllegalStateException("Car is on a down right turn and its direction is right")
            }

            UpLeftTurn -> when (car.direction) {
                Direction.DOWN -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        column = car.position.column - 1,
                        direction = Direction.LEFT
                    )
                )

                Direction.RIGHT -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        row = car.position.row - 1,
                        direction = Direction.UP
                    )
                )

                Direction.UP -> throw IllegalStateException("Car is on an up left turn and its direction is up")
                Direction.LEFT -> throw IllegalStateException("Car is on an up left turn and its direction is left")
            }

            UpRightTurn -> when (car.direction) {
                Direction.DOWN -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        column = car.position.column + 1,
                        direction = Direction.RIGHT
                    )
                )

                Direction.LEFT -> state.moveCar(
                    carIndex,
                    car.position.copy(
                        row = car.position.row - 1,
                        direction = Direction.UP
                    )
                )

                Direction.UP -> throw IllegalStateException("Car is on an up right turn and its direction is up")
                Direction.RIGHT -> throw IllegalStateException("Car is on an up right turn and its direction is right")
            }
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
                    (car.direction == Direction.LEFT || car.direction == Direction.RIGHT) &&
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
                if (car.direction == Direction.LEFT || car.direction == Direction.RIGHT) {
                    val newCars = activeCars.updatePosition(carIndex, newPosition)
                    listOf(copy(activeCars = newCars))
                } else {
                    emptyList()
                }
            }

            is VerticalTrack -> {
                if (car.direction == Direction.UP || car.direction == Direction.DOWN) {
                    val newCars = activeCars.updatePosition(carIndex, newPosition)
                    listOf(copy(activeCars = newCars))
                } else {
                    emptyList()
                }
            }

            DownLeftTurn -> TODO()
            DownRightTurn -> TODO()
            UpLeftTurn -> TODO()
            UpRightTurn -> TODO()
        }
    }

    private fun ArrayList<Car>.updatePosition(carIndex: Int, newPosition: CarPosition): ArrayList<Car> {
        val newCars = ArrayList(this)
        newCars[carIndex] = newCars[carIndex].copy(position = newPosition)
        return newCars
    }
}

private val availableTilesByDirection = mapOf(
    Direction.LEFT to setOf(HorizontalTrack, UpRightTurn, DownRightTurn),
    Direction.RIGHT to setOf(HorizontalTrack, UpLeftTurn, DownLeftTurn),
    Direction.UP to setOf(VerticalTrack, DownLeftTurn, DownRightTurn),
    Direction.DOWN to setOf(VerticalTrack, UpLeftTurn, UpRightTurn),
)