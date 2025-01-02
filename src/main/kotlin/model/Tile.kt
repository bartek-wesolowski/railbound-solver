package model

import model.Direction.*
import java.util.EnumMap
import java.util.EnumSet

interface ResetCarsAfterModification

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

        override fun matches(solution: Tile): Boolean {
            return true
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
    ), ResetCarsAfterModification {
        override fun getNextPosition(position: CarPosition) = position.moveForward()

        override fun matches(solution: Tile): Boolean {
            if (
                solution is UpLeftDownFork ||
                solution is UpRightDownFork ||
                solution is DownLeftUpFork ||
                solution is DownRightUpFork
            ) {
                return true
            }
            return super.matches(solution)
        }
    }

    data object HorizontalTrack : Tile(
        incomingDirections = EnumSet.of(LEFT, RIGHT),
        secondaryIncomingDirections = EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
            put(UP, listOf(DownLeftRightFork, DownRightLeftFork))
            put(DOWN, listOf(UpLeftRightFork, UpRightLeftFork))
        }
    ), ResetCarsAfterModification {
        override fun getNextPosition(position: CarPosition) = position.moveForward()

        override fun matches(solution: Tile): Boolean {
            if (
                solution is DownLeftRightFork ||
                solution is DownRightLeftFork ||
                solution is UpLeftRightFork ||
                solution is UpRightLeftFork
            ) {
                return true
            }
            return super.matches(solution)
        }
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

        override fun matches(solution: Tile): Boolean {
            if (solution is DownRightUpFork || solution is DownRightLeftFork) {
                return true
            }
            return super.matches(solution)
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

        override fun matches(solution: Tile): Boolean {
            if (solution is DownLeftUpFork || solution is DownLeftRightFork) {
                return true
            }
            return super.matches(solution)
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

        override fun matches(solution: Tile): Boolean {
            if (solution is UpRightDownFork || solution is UpRightLeftFork) {
                return true
            }
            return super.matches(solution)
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

        override fun matches(solution: Tile): Boolean {
            if (solution is UpLeftDownFork || solution is UpLeftRightFork) {
                return true
            }
            return super.matches(solution)
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
    data object DownRightUpFork : Tile(UP, LEFT, DOWN) {
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
    data object UpRightDownFork : Tile(DOWN, LEFT, UP) {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnLeft()
            LEFT -> position.turnRight()
            UP -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    // Tunnels
    data class LeftTunnel(
        val color: TunnelColor,
        val exitPosition: CarPosition,
    ) : Tile(RIGHT) {
        override fun getNextPosition(position: CarPosition): CarPosition {
            return when (position.direction) {
                RIGHT -> exitPosition
                LEFT -> position.moveForward()
                else -> throw IllegalStateException("Invalid direction in LeftTunnel: ${position.direction}")
            }
        }
    }

    data class RightTunnel(
        val color: TunnelColor,
        val exitPosition: CarPosition,
    ) : Tile(LEFT) {
        override fun getNextPosition(position: CarPosition): CarPosition {
            return when (position.direction) {
                LEFT -> exitPosition
                RIGHT -> position.moveForward()
                else -> throw IllegalStateException("Invalid direction in RightTunnel: ${position.direction}")
            }
        }
    }

    data class UpTunnel(
        val color: TunnelColor,
        val exitPosition: CarPosition,
    ) : Tile(DOWN) {
        override fun getNextPosition(position: CarPosition): CarPosition {
            return when (position.direction) {
                DOWN -> exitPosition
                UP -> position.moveForward()
                else -> throw IllegalStateException("Invalid direction in UpTunnel: ${position.direction}")
            }
        }
    }

    data class DownTunnel(
        val color: TunnelColor,
        val exitPosition: CarPosition,
    ) : Tile(UP) {
        override fun getNextPosition(position: CarPosition): CarPosition {
            return when (position.direction) {
                UP -> exitPosition
                DOWN -> position.moveForward()
                else -> throw IllegalStateException("Invalid direction in DownTunnel: ${position.direction}")
            }
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

    open fun matches(solution: Tile): Boolean = this == solution

    abstract fun getNextPosition(position: CarPosition): CarPosition
}