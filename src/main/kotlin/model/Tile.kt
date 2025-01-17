package model

import model.Direction.*
import java.util.EnumMap
import java.util.EnumSet

sealed interface StraightTrack

sealed interface Turn

sealed interface Fork

sealed interface Tunnel

sealed interface ResetCarsAfterModification

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
    sealed class BaseVerticalTrack(
        secondaryIncomingDirections: EnumMap<Direction, List<Tile>> = EnumMap(Direction::class.java),
    ) : Tile(
        incomingDirections = EnumSet.of(UP, DOWN),
        secondaryIncomingDirections = secondaryIncomingDirections
    ), StraightTrack, ResetCarsAfterModification {
        override fun getNextPosition(position: CarPosition) = position.moveForward()

        data object VerticalTrack : BaseVerticalTrack(
            secondaryIncomingDirections = EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
                put(LEFT, listOf(DownRightUpFork(), UpRightDownFork()))
                put(RIGHT, listOf(DownLeftUpFork(), UpLeftDownFork()))
            }
        ) {
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

        data object FixedVerticalTrack : BaseVerticalTrack()

        data class VerticalBarrier(
            val color: BarrierColor,
            val open: Boolean,
        ) : BaseVerticalTrack() {
            override fun getNextPosition(position: CarPosition): CarPosition {
                return if (open) {
                    position.moveForward()
                } else {
                    position
                }
            }

            override fun matches(solution: Tile): Boolean {
                return if (solution is VerticalBarrier) {
                    solution.color == color && solution.open == open
                } else {
                    false
                }
            }
        }
    }

    sealed class BaseHorizontalTrack(
        secondaryIncomingDirections: EnumMap<Direction, List<Tile>> = EnumMap(Direction::class.java),
    ) : Tile(
        incomingDirections = EnumSet.of(LEFT, RIGHT),
        secondaryIncomingDirections = secondaryIncomingDirections
    ), StraightTrack, ResetCarsAfterModification {
        override fun getNextPosition(position: CarPosition) = position.moveForward()

        data object HorizontalTrack : BaseHorizontalTrack(
            secondaryIncomingDirections = EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
                put(UP, listOf(DownLeftRightFork(), DownRightLeftFork()))
                put(DOWN, listOf(UpLeftRightFork(), UpRightLeftFork()))
            }
        ) {
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

        data object FixedHorizontalTrack : BaseHorizontalTrack()

        data class HorizontalBarrier(
            val color: BarrierColor,
            val open: Boolean,
        ) : BaseHorizontalTrack() {
            override fun getNextPosition(position: CarPosition): CarPosition {
                return if (open) {
                    position.moveForward()
                } else {
                    position
                }
            }

            override fun matches(solution: Tile): Boolean = this == solution
        }
    }

    // Turns
    data class DownRightTurn(val fixed: Boolean = false) : Tile(
        incomingDirections = EnumSet.of(UP, LEFT),
        secondaryIncomingDirections = if (!fixed) {
            EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
                put(DOWN, listOf(DownRightUpFork()))
                put(RIGHT, listOf(DownRightLeftFork()))
            }
        } else {
            EnumMap(Direction::class.java)
        }
    ), Turn {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnRight()
            LEFT -> position.turnLeft()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }

        override fun matches(solution: Tile): Boolean {
            if (fixed) return super.matches(solution)
            if (solution is DownRightUpFork || solution is DownRightLeftFork) {
                return true
            }
            return super.matches(solution)
        }
    }

    data class DownLeftTurn(val fixed: Boolean = false) : Tile(
        incomingDirections = EnumSet.of(UP, RIGHT),
        secondaryIncomingDirections = if (!fixed) {
            EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
                put(DOWN, listOf(DownLeftUpFork()))
                put(LEFT, listOf(DownLeftRightFork()))
            }
        } else {
            EnumMap(Direction::class.java)
        }
    ), Turn {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnLeft()
            RIGHT -> position.turnRight()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }

        override fun matches(solution: Tile): Boolean {
            if (fixed) return super.matches(solution)
            if (solution is DownLeftUpFork || solution is DownLeftRightFork) {
                return true
            }
            return super.matches(solution)
        }
    }

    data class UpRightTurn(val fixed: Boolean = false) : Tile(
        incomingDirections = EnumSet.of(DOWN, LEFT),
        secondaryIncomingDirections = if (!fixed) {
            EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
                put(UP, listOf(UpRightDownFork()))
                put(RIGHT, listOf(UpRightLeftFork()))
            }
        } else {
            EnumMap(Direction::class.java)
        }
    ), Turn {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnLeft()
            LEFT -> position.turnRight()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }

        override fun matches(solution: Tile): Boolean {
            if (fixed) return super.matches(solution)
            if (solution is UpRightDownFork || solution is UpRightLeftFork) {
                return true
            }
            return super.matches(solution)
        }
    }

    data class UpLeftTurn(val fixed: Boolean = false) : Tile(
        incomingDirections = EnumSet.of(DOWN, RIGHT),
        secondaryIncomingDirections = if (!fixed) {
            EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
                put(UP, listOf(UpLeftDownFork()))
                put(LEFT, listOf(UpLeftRightFork()))
            }
        } else {
            EnumMap(Direction::class.java)
        }
    ), Turn {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnRight()
            RIGHT -> position.turnLeft()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }

        override fun matches(solution: Tile): Boolean {
            if (fixed) return super.matches(solution)
            if (solution is UpLeftDownFork || solution is UpLeftRightFork) {
                return true
            }
            return super.matches(solution)
        }
    }

    // Forks
    data class DownLeftRightFork(val fixed: Boolean = false) : Tile(UP, RIGHT, LEFT), Fork {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnLeft()
            RIGHT -> position.turnRight()
            LEFT -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    data class DownLeftUpFork(val fixed: Boolean = false) : Tile(UP, RIGHT, DOWN), Fork {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnLeft()
            RIGHT -> position.turnRight()
            DOWN -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    data class DownRightLeftFork(val fixed: Boolean = false) : Tile(UP, RIGHT, LEFT), Fork {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnRight()
            LEFT -> position.turnLeft()
            RIGHT -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    data class DownRightUpFork(val fixed: Boolean = false) : Tile(UP, LEFT, DOWN), Fork {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnRight()
            LEFT -> position.turnLeft()
            DOWN -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    data class UpLeftRightFork(val fixed: Boolean = false) : Tile(DOWN, RIGHT, LEFT), Fork {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnRight()
            RIGHT -> position.turnLeft()
            LEFT -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    data class UpLeftDownFork(val fixed: Boolean = false) : Tile(DOWN, RIGHT, UP), Fork {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnRight()
            RIGHT -> position.turnLeft()
            UP -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    data class UpRightLeftFork(val fixed: Boolean = false) : Tile(DOWN, RIGHT, LEFT), Fork {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnLeft()
            LEFT -> position.turnRight()
            RIGHT -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    data class UpRightDownFork(val fixed: Boolean = false) : Tile(DOWN, LEFT, UP), Fork {
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
    ) : Tile(RIGHT), Tunnel {
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
    ) : Tile(LEFT), Tunnel {
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
    ) : Tile(DOWN), Tunnel {
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
    ) : Tile(UP), Tunnel {
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