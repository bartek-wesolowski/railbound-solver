package model

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import com.danrusu.pods4k.immutableArrays.buildImmutableArray
import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import model.Direction.DOWN
import model.Direction.LEFT
import model.Direction.RIGHT
import model.Direction.UP
import java.util.EnumMap
import java.util.EnumSet

sealed interface StraightTrack

sealed interface Turn

sealed interface Fork

sealed interface Tunnel

sealed interface ModifiableTile {
    fun getIncomingDirectionsAfterModification(
        traverseDirections: EnumSet<Direction>
    ): EnumMap<Direction, ImmutableArray<Tile>>
}

sealed interface Barrier {
    val color: BarrierColor
    val open: Boolean
    fun toggled(): Barrier
}

sealed interface BarrierSwitch {
    val color: BarrierColor
}

sealed class Tile(
    val incomingDirections: EnumSet<Direction>,
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
    sealed class BaseVerticalTrack : Tile(
        incomingDirections = EnumSet.of(UP, DOWN),
    ), StraightTrack {
        override fun getNextPosition(position: CarPosition) = position.moveForward()

        data object VerticalTrack : BaseVerticalTrack(), ModifiableTile {
            override fun getIncomingDirectionsAfterModification(
                traverseDirections: EnumSet<Direction>
            ): EnumMap<Direction, ImmutableArray<Tile>> {
                if (UP in traverseDirections && DOWN in traverseDirections) return EnumMap(Direction::class.java)
                return EnumMap<Direction, ImmutableArray<Tile>>(Direction::class.java).apply {
                    put(
                        LEFT,
                        buildImmutableArray {
                            if (UP !in traverseDirections) add(DownRightUpFork())
                            if (DOWN !in traverseDirections) add(UpRightDownFork())
                        }
                    )
                    put(
                        RIGHT,
                        buildImmutableArray {
                            if (UP !in traverseDirections) add(DownLeftUpFork())
                            if (DOWN !in traverseDirections) add(UpLeftDownFork())
                        }
                    )
                }
            }

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
            override val color: BarrierColor,
            override val open: Boolean,
        ) : BaseVerticalTrack(), Barrier {
            override fun toggled() = VerticalBarrier(color, !open)

            override fun matches(solution: Tile): Boolean {
                return solution is VerticalBarrier && solution.color == color
            }
        }

        data class VerticalBarrierSwitch(
            override val color: BarrierColor,
        ) : BaseVerticalTrack(), BarrierSwitch
    }

    sealed class BaseHorizontalTrack : Tile(
        incomingDirections = EnumSet.of(LEFT, RIGHT),
    ), StraightTrack {
        override fun getNextPosition(position: CarPosition) = position.moveForward()

        data object HorizontalTrack : BaseHorizontalTrack(), ModifiableTile {
            override fun getIncomingDirectionsAfterModification(
                traverseDirections: EnumSet<Direction>
            ): EnumMap<Direction, ImmutableArray<Tile>> {
                return EnumMap<Direction, ImmutableArray<Tile>>(Direction::class.java).apply {
                    put(
                        UP,
                        buildImmutableArray {
                            if (LEFT !in traverseDirections) add(DownRightLeftFork())
                            if (RIGHT !in traverseDirections) add(DownLeftRightFork())
                        }
                    )
                    put(
                        DOWN,
                        buildImmutableArray {
                            if (LEFT !in traverseDirections) add(UpRightLeftFork())
                            if (RIGHT !in traverseDirections) add(UpLeftRightFork())
                        }
                    )
                }
            }

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
            override val color: BarrierColor,
            override val open: Boolean,
        ) : BaseHorizontalTrack(), Barrier {
            override fun toggled() = HorizontalBarrier(color, !open)

            override fun matches(solution: Tile): Boolean {
                return solution is HorizontalBarrier && solution.color == color
            }
        }

        data class HorizontalBarrierSwitch(
            override val color: BarrierColor
        ) : BaseHorizontalTrack(), BarrierSwitch
    }

    // Turns
    data class DownRightTurn(val fixed: Boolean = false) : Tile(
        incomingDirections = EnumSet.of(UP, LEFT),
    ), Turn, ModifiableTile {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnRight()
            LEFT -> position.turnLeft()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }

        override fun getIncomingDirectionsAfterModification(
            traverseDirections: EnumSet<Direction>
        ): EnumMap<Direction, ImmutableArray<Tile>> {
            return if (!fixed) {
                EnumMap<Direction, ImmutableArray<Tile>>(Direction::class.java).apply {
                    put(DOWN, immutableArrayOf(DownRightUpFork()))
                    put(RIGHT, immutableArrayOf(DownRightLeftFork()))
                }
            } else {
                EnumMap(Direction::class.java)
            }
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
    ), Turn, ModifiableTile {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnLeft()
            RIGHT -> position.turnRight()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }

        override fun getIncomingDirectionsAfterModification(
            traverseDirections: EnumSet<Direction>
        ): EnumMap<Direction, ImmutableArray<Tile>> {
            return if (!fixed) {
                EnumMap<Direction, ImmutableArray<Tile>>(Direction::class.java).apply {
                    put(DOWN, immutableArrayOf(DownLeftUpFork()))
                    put(LEFT, immutableArrayOf(DownLeftRightFork()))
                }
            } else {
                EnumMap(Direction::class.java)
            }
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
    ), Turn, ModifiableTile {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnLeft()
            LEFT -> position.turnRight()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }

        override fun getIncomingDirectionsAfterModification(
            traverseDirections: EnumSet<Direction>
        ): EnumMap<Direction, ImmutableArray<Tile>> {
            return if (!fixed) {
                EnumMap<Direction, ImmutableArray<Tile>>(Direction::class.java).apply {
                    put(UP, immutableArrayOf(UpRightDownFork()))
                    put(RIGHT, immutableArrayOf(UpRightLeftFork()))
                }
            } else {
                EnumMap(Direction::class.java)
            }
        }

        override fun matches(solution: Tile): Boolean {
            if (fixed) return super.matches(solution)
            if (solution is UpRightDownFork || solution is UpRightLeftFork) {
                return true
            }
            return super.matches(solution)
        }
    }

    data class UpRightBarrierSwitch(
        override val color: BarrierColor
    ): Tile(
        incomingDirections = EnumSet.of(DOWN, LEFT),
    ), Turn, BarrierSwitch {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnLeft()
            LEFT -> position.turnRight()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }
    }

    data class UpLeftTurn(val fixed: Boolean = false) : Tile(
        incomingDirections = EnumSet.of(DOWN, RIGHT),
    ), Turn, ModifiableTile {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnRight()
            RIGHT -> position.turnLeft()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }

        override fun getIncomingDirectionsAfterModification(
            traverseDirections: EnumSet<Direction>
        ): EnumMap<Direction, ImmutableArray<Tile>> {
            return if (!fixed) {
                EnumMap<Direction, ImmutableArray<Tile>>(Direction::class.java).apply {
                    put(UP, immutableArrayOf(UpLeftDownFork()))
                    put(LEFT, immutableArrayOf(UpLeftRightFork()))
                }
            } else {
                EnumMap(Direction::class.java)
            }
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

    data class DownLeftRightBarrierSwitch(
        override val color: BarrierColor
    ) : Tile(UP, RIGHT, LEFT), Fork, BarrierSwitch {
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

    fun isValidIncomingDirection(direction: Direction, traverseDirections: EnumSet<Direction>): Boolean {
        return direction in incomingDirections
                || (
                this is ModifiableTile &&
                        direction in getIncomingDirectionsAfterModification(traverseDirections = traverseDirections)
                )
    }

    open fun matches(solution: Tile): Boolean = this == solution

    abstract fun getNextPosition(position: CarPosition): CarPosition
}