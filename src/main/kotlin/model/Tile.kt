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

sealed interface Fork {
    val color: ForkColor?
    fun toggled(): Fork
}

sealed interface Tunnel {
    val color: TunnelColor
    val exitPosition: CarPosition
}

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

sealed interface HasAction {
    val action: Action?
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

        data class VerticalTrack(
            override val action: Action? = null,
        ) : BaseVerticalTrack(), ModifiableTile, HasAction {
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
                    if (UP !in traverseDirections) {
                        put(UP, immutableArrayOf(DownLeftUpFork(), DownRightUpFork()))
                    }
                    if (DOWN !in traverseDirections) {
                        put(DOWN, immutableArrayOf(UpLeftDownFork(), UpRightDownFork()))
                    }
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

        data class FixedVerticalTrack(
            override val action: Action? = null,
        ) : BaseVerticalTrack(), HasAction

        data class VerticalBarrier(
            override val color: BarrierColor,
            override val open: Boolean,
        ) : BaseVerticalTrack(), Barrier {
            override fun toggled() = VerticalBarrier(color, !open)

            override fun matches(solution: Tile): Boolean {
                return solution is VerticalBarrier && solution.color == color
            }
        }
    }

    sealed class BaseHorizontalTrack : Tile(
        incomingDirections = EnumSet.of(LEFT, RIGHT),
    ), StraightTrack {
        override fun getNextPosition(position: CarPosition) = position.moveForward()

        data object HorizontalTrack : BaseHorizontalTrack(), ModifiableTile {
            override fun getIncomingDirectionsAfterModification(
                traverseDirections: EnumSet<Direction>
            ): EnumMap<Direction, ImmutableArray<Tile>> {
                if (LEFT in traverseDirections && RIGHT in traverseDirections) return EnumMap(Direction::class.java)
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
                    if (LEFT !in traverseDirections) {
                        put(LEFT, immutableArrayOf(UpRightLeftFork(), DownRightLeftFork()))
                    }
                    if (RIGHT !in traverseDirections) {
                        put(RIGHT, immutableArrayOf(UpLeftRightFork(), DownLeftRightFork()))
                    }
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

        data class FixedHorizontalTrack(
            override val action: Action? = null,
        ) : BaseHorizontalTrack(), HasAction

        data class HorizontalBarrier(
            override val color: BarrierColor,
            override val open: Boolean,
        ) : BaseHorizontalTrack(), Barrier {
            override fun toggled() = HorizontalBarrier(color, !open)

            override fun matches(solution: Tile): Boolean {
                return solution is HorizontalBarrier && solution.color == color
            }
        }
    }

    // Turns
    data class DownRightTurn(
        val fixed: Boolean = false,
        override val action: Action? = null,
    ) : Tile(
        incomingDirections = EnumSet.of(UP, LEFT),
    ), Turn, ModifiableTile, HasAction {
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

    data class DownLeftTurn(
        val fixed: Boolean = false,
        override val action: Action? = null,
    ) : Tile(
        incomingDirections = EnumSet.of(UP, RIGHT),
    ), Turn, ModifiableTile, HasAction {
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

    data class UpRightTurn(
        val fixed: Boolean = false,
        override val action: Action? = null,
    ) : Tile(
        incomingDirections = EnumSet.of(DOWN, LEFT),
    ), Turn, ModifiableTile, HasAction {
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

    data class UpLeftTurn(
        val fixed: Boolean = false,
        override val action: Action? = null,
    ) : Tile(
        incomingDirections = EnumSet.of(DOWN, RIGHT),
    ), Turn, ModifiableTile, HasAction {
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
    data class DownLeftRightFork(
        val fixed: Boolean = false,
        override val color: ForkColor? = null,
        override val action: Action? = null,
    ) : Tile(UP, RIGHT, LEFT), Fork, HasAction {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnLeft()
            RIGHT -> position.turnRight()
            LEFT -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }

        override fun toggled() = DownRightLeftFork(fixed, color, action)
    }

    data class DownLeftUpFork(
        val fixed: Boolean = false,
        override val color: ForkColor? = null,
        override val action: Action? = null,
    ) : Tile(UP, RIGHT, DOWN), Fork, HasAction {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnLeft()
            RIGHT -> position.turnRight()
            DOWN -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }

        override fun toggled() = UpLeftDownFork(fixed, color, action)
    }

    data class DownRightLeftFork(
        val fixed: Boolean = false,
        override val color: ForkColor? = null,
        override val action: Action? = null,
    ) : Tile(UP, RIGHT, LEFT), Fork, HasAction {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnRight()
            LEFT -> position.turnLeft()
            RIGHT -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }

        override fun toggled() = DownLeftRightFork(fixed, color, action)
    }

    data class DownRightUpFork(
        val fixed: Boolean = false,
        override val color: ForkColor? = null,
        override val action: Action? = null,
    ) : Tile(UP, LEFT, DOWN), Fork, HasAction {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            UP -> position.turnRight()
            LEFT -> position.turnLeft()
            DOWN -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }

        override fun toggled() = UpRightDownFork(fixed, color, action)
    }

    data class UpLeftRightFork(
        val fixed: Boolean = false,
        override val color: ForkColor? = null,
        override val action: Action? = null,
    ) : Tile(DOWN, RIGHT, LEFT), Fork, HasAction {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnRight()
            RIGHT -> position.turnLeft()
            LEFT -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }

        override fun toggled() = UpRightLeftFork(fixed, color, action)
    }

    data class UpLeftDownFork(
        val fixed: Boolean = false,
        override val color: ForkColor? = null,
        override val action: Action? = null,
    ) : Tile(DOWN, RIGHT, UP), Fork, HasAction {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnRight()
            RIGHT -> position.turnLeft()
            UP -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }

        override fun toggled() = DownLeftUpFork(fixed, color, action)
    }

    data class UpRightLeftFork(
        val fixed: Boolean = false,
        override val color: ForkColor? = null,
        override val action: Action? = null,
    ) : Tile(DOWN, RIGHT, LEFT), Fork, HasAction {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnLeft()
            LEFT -> position.turnRight()
            RIGHT -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }

        override fun toggled() = UpLeftRightFork(fixed, color, action)
    }

    data class UpRightDownFork(
        val fixed: Boolean = false,
        override val color: ForkColor? = null,
        override val action: Action? = null,
    ) : Tile(DOWN, LEFT, UP), Fork, HasAction {
        override fun getNextPosition(position: CarPosition) = when (position.direction) {
            DOWN -> position.turnLeft()
            LEFT -> position.turnRight()
            UP -> position.moveForward()
            else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
        }

        override fun toggled() = DownRightUpFork(fixed, color, action)
    }

    // Tunnels
    data class LeftTunnel(
        override val color: TunnelColor,
        override val exitPosition: CarPosition,
    ) : Tile(RIGHT), Tunnel {
        override fun getNextPosition(position: CarPosition): CarPosition {
            return when (position.direction) {
                RIGHT -> exitPosition.moveForward()
                LEFT -> position.moveForward()
                else -> throw IllegalStateException("Invalid direction in LeftTunnel: ${position.direction}")
            }
        }
    }

    data class RightTunnel(
        override val color: TunnelColor,
        override val exitPosition: CarPosition,
    ) : Tile(LEFT), Tunnel {
        override fun getNextPosition(position: CarPosition): CarPosition {
            return when (position.direction) {
                LEFT -> exitPosition.moveForward()
                RIGHT -> position.moveForward()
                else -> throw IllegalStateException("Invalid direction in RightTunnel: ${position.direction}")
            }
        }
    }

    data class UpTunnel(
        override val color: TunnelColor,
        override val exitPosition: CarPosition,
    ) : Tile(DOWN), Tunnel {
        override fun getNextPosition(position: CarPosition): CarPosition {
            return when (position.direction) {
                DOWN -> exitPosition.moveForward()
                UP -> position.moveForward()
                else -> throw IllegalStateException("Invalid direction in UpTunnel: ${position.direction}")
            }
        }
    }

    data class DownTunnel(
        override val color: TunnelColor,
        override val exitPosition: CarPosition,
    ) : Tile(UP), Tunnel {
        override fun getNextPosition(position: CarPosition): CarPosition {
            return when (position.direction) {
                UP -> exitPosition.moveForward()
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