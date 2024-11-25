package com.bartoszwesolowski

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
        when (state.board[car.position.row, car.position.column]) {
            is Tile.Empty -> throw IllegalStateException("Car is not on a track")
            is Tile.EndingTrack -> throw IllegalStateException("Car is on an ending track")
            is Tile.HorizontalTrack -> when (car.position.direction) {
                Direction.LEFT -> {
                    val newPosition = car.position.copy(column = car.position.column - 1)
                    return if (newPosition.column >= 0) {
                        state.moveCar(carIndex, newPosition)
                    } else {
                        emptyList()
                    }
                }

                Direction.RIGHT -> {
                    val newPosition = car.position.copy(column = car.position.column + 1)
                    return if (newPosition.column < state.board.columns) {
                        state.moveCar(carIndex, newPosition)
                    } else {
                        emptyList()
                    }
                }

                Direction.UP, Direction.DOWN ->
                    throw IllegalStateException("Car is on a horizontal track but its direction is not horizontal")
            }

            is Tile.VerticalTrack -> {
                when (car.position.direction) {
                    Direction.UP -> {
                        val newPosition = car.position.copy(row = car.position.row - 1)
                        return if (newPosition.row >= 0) {
                            state.moveCar(carIndex, newPosition)
                        } else {
                            emptyList()
                        }
                    }

                    Direction.DOWN -> {
                        val newPosition = car.position.copy(row = car.position.row + 1)
                        return if (newPosition.row < state.board.rows) {
                            state.moveCar(carIndex, newPosition)
                        } else {
                            emptyList()
                        }
                    }

                    Direction.LEFT, Direction.RIGHT ->
                        throw IllegalStateException("Car is on a vertical track but its direction is not vertical")
                }
            }
            Tile.BottomLeftTurn -> TODO()
            Tile.BottomRightTurn -> TODO()
            Tile.Obstacle -> TODO()
            Tile.TopLeftTurn -> TODO()
            Tile.TopRightTurn -> TODO()
        }
    }

    private fun SolverState.moveCar(carIndex: Int, newPosition: CarPosition): List<SolverState> {
        val car = activeCars[carIndex]
        return when (board[newPosition.row, newPosition.column]) {
            is Tile.Empty -> availableTilesByDirection.getValue(car.position.direction)
                .filter { board.canInsert(newPosition.row, newPosition.column, it) }
                .map {
                    copy(
                        board = board.with(newPosition.row, newPosition.column, it),
                        activeCars = activeCars.updatePosition(carIndex, newPosition),
                        tracksUsed = tracksUsed + 1
                    )
                }

            is Tile.EndingTrack -> {
                return if (
                    (car.position.direction == Direction.LEFT || car.position.direction == Direction.RIGHT) &&
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

            is Tile.HorizontalTrack -> {
                return if (car.position.direction == Direction.LEFT || car.position.direction == Direction.RIGHT) {
                    val newCars = activeCars.updatePosition(carIndex, newPosition)
                    listOf(copy(activeCars = newCars))
                } else {
                    emptyList()
                }
            }

            is Tile.VerticalTrack -> {
                return if (car.position.direction == Direction.UP || car.position.direction == Direction.DOWN) {
                    val newCars = activeCars.updatePosition(carIndex, newPosition)
                    listOf(copy(activeCars = newCars))
                } else {
                    emptyList()
                }

            }

            Tile.BottomLeftTurn -> TODO()
            Tile.BottomRightTurn -> TODO()
            Tile.Obstacle -> TODO()
            Tile.TopLeftTurn -> TODO()
            Tile.TopRightTurn -> TODO()
        }
    }

    private fun ArrayList<Car>.updatePosition(carIndex: Int, newPosition: CarPosition): ArrayList<Car> {
        val newCars = ArrayList(this)
        newCars[carIndex] = newCars[carIndex].copy(position = newPosition)
        return newCars
    }
}

private val availableTilesByDirection = mapOf(
    Direction.LEFT to setOf(Tile.HorizontalTrack, Tile.TopLeftTurn, Tile.BottomLeftTurn),
    Direction.RIGHT to setOf(Tile.HorizontalTrack, Tile.TopRightTurn, Tile.BottomRightTurn),
    Direction.UP to setOf(Tile.VerticalTrack, Tile.BottomLeftTurn, Tile.BottomRightTurn),
    Direction.DOWN to setOf(Tile.VerticalTrack, Tile.TopLeftTurn, Tile.TopRightTurn),
)