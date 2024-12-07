package com.bartoszwesolowski

import com.bartoszwesolowski.Direction.*
import com.bartoszwesolowski.Tile.*
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
            println("checking $state")
            if (state.isSolved()) {
                solutions.add(state.board)
                continue
            }
            statesChecked.add(state)
            val nextStates = state.nextStates().filter { it.tracksUsed <= level.tracks }
            if (nextStates.isEmpty()) println("no next states")
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
                val adjustedCarIndex = state.activeCars.indexOf(activeCars[carIndex])
                updatedNextStates.addAll(getMoves(state, adjustedCarIndex))
            }
            nextStates = updatedNextStates.filterNot { it.hasCarCollision() }
        }
        return nextStates
    }

    private fun SolverState.hasCarCollision(): Boolean {
        return activeCars.groupBy { it.position.row to it.position.column }.any { it.value.size > 1 }
    }

    private fun getMoves(state: SolverState, carIndex: Int): List<SolverState> {
        val position = state.activeCars[carIndex].position
        val tile = state.board[position.row, position.column]
        return state.moveCar(carIndex, tile.getNextPosition(position))
    }

    private fun SolverState.moveCar(carIndex: Int, newPosition: CarPosition): List<SolverState> {
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
                        activeCars = ArrayList(activeCars).apply { removeAt(carIndex) },
                        expectedCar = EnumMap(expectedCar).apply { put(car.color, get(car.color)!! + 1) })
                )
            } else {
                emptyList()
            }

            FixedHorizontalTrack,
            FixedVerticalTrack,
            FixedDownLeftTurn,
            FixedDownRightTurn,
            FixedUpLeftTurn,
            FixedUpRightTurn,
            HorizontalTrack,
            VerticalTrack,
            DownLeftTurn,
            DownRightTurn,
            UpLeftTurn,
            UpRightTurn -> when (car.direction) {
                in tile.incomingDirections -> {
                    listOf(copy(activeCars = newCars))
                }

                in tile.secondaryIncomingDirections -> {
//                    if (tile is ResetAfterModification) TODO()
                    tile.secondaryIncomingDirections.getValue(car.direction).map { modifiedTile ->
                        copy(
                            board = board.with(newPosition.row, newPosition.column, modifiedTile),
                            activeCars = newCars,
                        )
                    }
                }

                else -> emptyList()
            }

            DownLeftRightFork,
            DownLeftUpFork,
            DownRightLeftFork,
            DownRightUpFork,
            UpLeftDownFork,
            UpLeftRightFork,
            UpRightDownFork,
            UpRightLeftFork -> if (car.direction in tile.incomingDirections) {
                listOf(copy(activeCars = newCars))
            } else {
                emptyList()
            }
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