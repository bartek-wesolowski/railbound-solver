package model

import model.Direction.*
import java.util.EnumMap
import java.util.EnumSet

interface ResetAfterModification

sealed class Tile(
    val incomingDirections: EnumSet<Direction>,
    val secondaryIncomingDirections: EnumMap<Direction, List<Tile>> = EnumMap<Direction, List<Tile>>(Direction::class.java),
) {
    constructor(vararg incomingDirections: Direction) : this(
        incomingDirections = if (incomingDirections.isNotEmpty()) {
            EnumSet.copyOf(incomingDirections.asList())
        } else {
            EnumSet.noneOf(Direction::class.java)
        },
    )

    data object Empty : Tile() {
        override fun getNextPosition(position: CarPosition): CarPosition {
            throw IllegalStateException("Empty tile should not be used")
        }
    }

    // Straight tracks
    data object FixedVerticalTrack : Tile(UP, DOWN) {
        override fun getNextPosition(position: CarPosition) = position.moveForward()
    }

    data object FixedHorizontalTrack : Tile(LEFT, RIGHT) {
        override fun getNextPosition(position: CarPosition) = position.moveForward()
    }

    data object VerticalTrack : Tile(
        incomingDirections = EnumSet.of(UP, DOWN),
        secondaryIncomingDirections = EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
            put(LEFT, listOf(DownRightUpFork, UpRightDownFork))
            put(RIGHT, listOf(DownLeftUpFork, UpLeftDownFork))
        }
    ), ResetAfterModification {
        override fun getNextPosition(position: CarPosition) = position.moveForward()
    }

    data object HorizontalTrack : Tile(
        incomingDirections = EnumSet.of(LEFT, RIGHT),
        secondaryIncomingDirections = EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
            put(UP, listOf(DownLeftRightFork, DownRightLeftFork))
            put(DOWN, listOf(UpLeftRightFork, UpRightLeftFork))
        }
    ), ResetAfterModification {
        override fun getNextPosition(position: CarPosition) = position.moveForward()
    }

    // Turns
    data object FixedDownRightTurn : Tile(UP, LEFT) {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnRight()
            LEFT -> position.turnLeft()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    data object FixedDownLeftTurn : Tile(UP, RIGHT) {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnLeft()
            RIGHT -> position.turnRight()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    data object FixedUpRightTurn : Tile(DOWN, LEFT) {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnLeft()
            LEFT -> position.turnRight()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    data object FixedUpLeftTurn : Tile(DOWN, RIGHT) {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnRight()
            RIGHT -> position.turnLeft()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    data object DownRightTurn : Tile(
        incomingDirections = EnumSet.of(UP, LEFT),
        secondaryIncomingDirections = EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
            put(DOWN, listOf(DownRightUpFork))
            put(RIGHT, listOf(DownRightLeftFork))
        }
    ) {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnRight()
            LEFT -> position.turnLeft()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    data object DownLeftTurn : Tile(
        incomingDirections = EnumSet.of(UP, RIGHT),
        secondaryIncomingDirections = EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
            put(DOWN, listOf(DownLeftUpFork))
            put(LEFT, listOf(DownLeftRightFork))
        }
    ) {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnLeft()
            RIGHT -> position.turnRight()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    data object UpRightTurn : Tile(
        incomingDirections = EnumSet.of(DOWN, LEFT),
        secondaryIncomingDirections = EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
            put(UP, listOf(UpRightDownFork))
            put(RIGHT, listOf(UpRightLeftFork))
        }
    ) {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnLeft()
            LEFT -> position.turnRight()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    data object UpLeftTurn : Tile(
        incomingDirections = EnumSet.of(DOWN, RIGHT),
        secondaryIncomingDirections = EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
            put(UP, listOf(UpLeftDownFork))
            put(LEFT, listOf(UpLeftRightFork))
        }
    ) {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnRight()
            RIGHT -> position.turnLeft()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    // Forks
    data object DownLeftRightFork : Tile(UP, RIGHT, LEFT) {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnLeft()
            RIGHT -> position.turnRight()
            LEFT -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }
    data object DownLeftUpFork : Tile(UP, RIGHT, DOWN) {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnLeft()
            RIGHT -> position.turnRight()
            DOWN -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }
    data object DownRightLeftFork : Tile(UP, RIGHT, LEFT) {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnRight()
            LEFT -> position.turnLeft()
            RIGHT -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }
    data object DownRightUpFork : Tile(UP, RIGHT, DOWN) {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnRight()
            LEFT -> position.turnLeft()
            DOWN -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }
    data object UpLeftRightFork : Tile(DOWN, RIGHT, LEFT) {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnRight()
            RIGHT -> position.turnLeft()
            LEFT -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }
    data object UpLeftDownFork : Tile(DOWN, RIGHT, UP) {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnRight()
            RIGHT -> position.turnLeft()
            UP -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }
    data object UpRightLeftFork : Tile(DOWN, RIGHT, LEFT) {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnLeft()
            LEFT -> position.turnRight()
            RIGHT -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }
    data object UpRightDownFork : Tile(DOWN, RIGHT, UP) {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnLeft()
            LEFT -> position.turnRight()
            UP -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    // Other
    data object Obstacle : Tile() {
        override fun getNextPosition(position: CarPosition): Nothing {
            throw IllegalStateException("Obstacle should not be used")
        }
    }
    data object EndingTrack : Tile(RIGHT) {
        override fun getNextPosition(position: CarPosition): CarPosition {
            throw IllegalStateException("Ending track should not be used")
        }
    }

    fun isValidIncomingDirection(direction: Direction): Boolean {
        return direction in incomingDirections || direction in secondaryIncomingDirections
    }

    abstract fun getNextPosition(position: CarPosition): CarPosition
}