package model

import model.Direction.*

data class CarPosition(
    val row: Int,
    val column: Int,
    val direction: Direction,
) {
    fun asPosition(): Position = Position(row, column)

    fun moveForward(): CarPosition = when (direction) {
        UP -> copy(row = row - 1)
        DOWN -> copy(row = row + 1)
        LEFT -> copy(column = column - 1)
        RIGHT -> copy(column = column + 1)
    }

    fun turnLeft(): CarPosition = when (direction) {
        UP -> copy(
            column = column - 1,
            direction = LEFT
        )
        DOWN -> copy(
            column = column + 1,
            direction = RIGHT
        )
        LEFT -> copy(
            row = row + 1,
            direction = DOWN
        )
        RIGHT -> copy(
            row = row - 1,
            direction = UP
        )
    }

    fun turnRight(): CarPosition = when (direction) {
        UP -> copy(
            column = column + 1,
            direction = RIGHT
        )
        DOWN -> copy(
            column = column - 1,
            direction = LEFT
        )
        LEFT -> copy(
            row = row - 1,
            direction = UP
        )
        RIGHT -> copy(
            row = row + 1,
            direction = DOWN
        )
    }
}