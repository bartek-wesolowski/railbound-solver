package com.bartoszwesolowski

enum class Direction {
    UP, DOWN, LEFT, RIGHT;

    fun opposite(): Direction = when (this) {
        UP -> DOWN
        DOWN -> UP
        LEFT -> RIGHT
        RIGHT -> LEFT
    }
}