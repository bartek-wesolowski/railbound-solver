package model

enum class Direction {
    UP, DOWN, LEFT, RIGHT;

    fun opposite() = when (this) {
        UP -> DOWN
        DOWN -> UP
        LEFT -> RIGHT
        RIGHT -> LEFT
    }
}