package model

import model.Action.Toggle
import model.Direction.DOWN
import model.Direction.LEFT
import model.Direction.RIGHT
import model.Direction.UP
import model.Tile.Fork.BaseDownLeftRightFork.DownLeftRightFork
import model.Tile.Fork.BaseDownLeftRightFork.DownLeftRightToggleableFork
import model.Tile.Fork.BaseDownLeftUpFork.DownLeftUpFork
import model.Tile.Fork.BaseDownLeftUpFork.DownLeftUpToggleableFork
import model.Tile.Fork.BaseDownRightLeftFork.DownRightLeftFork
import model.Tile.Fork.BaseDownRightLeftFork.DownRightLeftToggleableFork
import model.Tile.Fork.BaseDownRightUpFork.DownRightUpFork
import model.Tile.Fork.BaseDownRightUpFork.DownRightUpToggleableFork
import model.Tile.Fork.BaseUpLeftDownFork.UpLeftDownFork
import model.Tile.Fork.BaseUpLeftDownFork.UpLeftDownToggleableFork
import model.Tile.Fork.BaseUpLeftRightFork.UpLeftRightFork
import model.Tile.Fork.BaseUpLeftRightFork.UpLeftRightToggleableFork
import model.Tile.Fork.BaseUpRightDownFork.UpRightDownFork
import model.Tile.Fork.BaseUpRightDownFork.UpRightDownToggleableFork
import model.Tile.Fork.BaseUpRightLeftFork.UpRightLeftFork
import model.Tile.Fork.BaseUpRightLeftFork.UpRightLeftToggleableFork
import java.util.EnumMap
import java.util.EnumSet

sealed interface StraightTrack

sealed interface Toggleable {
    val color: Color
    fun toggled(): Tile
}

sealed interface Tunnel {
    val color: TunnelColor
    val exitPosition: CarPosition
}

sealed interface ModifiableTile {
    fun getIncomingDirectionsAfterModification(
        traverseDirections: EnumSet<Direction>
    ): EnumMap<Direction, List<Tile>>
}

sealed interface Barrier : Toggleable {
    override val color: Color
    val open: Boolean
    override fun toggled(): Tile
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

        data object VerticalTrack : BaseVerticalTrack(), ModifiableTile {
            override fun getIncomingDirectionsAfterModification(
                traverseDirections: EnumSet<Direction>
            ): EnumMap<Direction, List<Tile>> {
                if (UP in traverseDirections && DOWN in traverseDirections) return EnumMap(Direction::class.java)
                return EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
                    put(
                        LEFT,
                        buildList {
                            if (UP !in traverseDirections) add(DownRightUpFork)
                            if (DOWN !in traverseDirections) add(UpRightDownFork)
                        }
                    )
                    put(
                        RIGHT,
                        buildList {
                            if (UP !in traverseDirections) add(DownLeftUpFork)
                            if (DOWN !in traverseDirections) add(UpLeftDownFork)
                        }
                    )
                    if (UP !in traverseDirections) {
                        put(UP, listOf(DownLeftUpFork, DownRightUpFork))
                    }
                    if (DOWN !in traverseDirections) {
                        put(DOWN, listOf(UpLeftDownFork, UpRightDownFork))
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

        data object FixedVerticalTrack : BaseVerticalTrack()

        data class VerticalToggle(
            override val action: Action
        ) : BaseVerticalTrack(), HasAction {
            constructor(color: Color) : this(Toggle(color))
        }

        data class VerticalBarrier(
            override val color: Color,
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
            ): EnumMap<Direction, List<Tile>> {
                if (LEFT in traverseDirections && RIGHT in traverseDirections) return EnumMap(Direction::class.java)
                return EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
                    put(
                        UP,
                        buildList {
                            if (LEFT !in traverseDirections) add(DownRightLeftFork)
                            if (RIGHT !in traverseDirections) add(DownLeftRightFork)
                        }
                    )
                    put(
                        DOWN,
                        buildList {
                            if (LEFT !in traverseDirections) add(UpRightLeftFork)
                            if (RIGHT !in traverseDirections) add(UpLeftRightFork)
                        }
                    )
                    if (LEFT !in traverseDirections) {
                        put(LEFT, listOf(UpRightLeftFork, DownRightLeftFork))
                    }
                    if (RIGHT !in traverseDirections) {
                        put(RIGHT, listOf(UpLeftRightFork, DownLeftRightFork))
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

        data object FixedHorizontalTrack : BaseHorizontalTrack()

        data class HorizontalToggle(
            override val action: Action
        ) : BaseHorizontalTrack(), HasAction {
            constructor(color: Color) : this(Toggle(color))
        }

        data class HorizontalBarrier(
            override val color: Color,
            override val open: Boolean,
        ) : BaseHorizontalTrack(), Barrier {
            override fun toggled() = HorizontalBarrier(color, !open)

            override fun matches(solution: Tile): Boolean {
                return solution is HorizontalBarrier && solution.color == color
            }
        }
    }

    sealed class Turn(
        incomingDirections: EnumSet<Direction>,
        open val fixed: Boolean
    ) : Tile(incomingDirections) {
        sealed class BaseDownRightTurn(
            fixed: Boolean,
        ) : Turn(
            incomingDirections = EnumSet.of(UP, LEFT),
            fixed = fixed
        ) {
            override fun getNextPosition(position: CarPosition) = when (position.direction) {
                UP -> position.turnRight()
                LEFT -> position.turnLeft()
                else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
            }

            data object DownRightTurn : BaseDownRightTurn(fixed = false), ModifiableTile {
                override fun getIncomingDirectionsAfterModification(
                    traverseDirections: EnumSet<Direction>
                ): EnumMap<Direction, List<Tile>> {
                    return EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
                        put(DOWN, listOf(DownRightUpFork))
                        put(RIGHT, listOf(DownRightLeftFork))
                    }
                }

                override fun matches(solution: Tile): Boolean {
                    if (solution is DownRightUpFork || solution is DownRightLeftFork) {
                        return true
                    }
                    return super.matches(solution)
                }
            }

            data object FixedDownRightTurn : BaseDownRightTurn(fixed = true)

            data class DownRightToggle(
                override val action: Action
            ) : BaseDownRightTurn(fixed = true), HasAction {
                constructor(color: Color) : this(Toggle(color))
            }
        }

        sealed class BaseDownLeftTurn(
            fixed: Boolean,
        ) : Turn(
            incomingDirections = EnumSet.of(UP, RIGHT),
            fixed = fixed
        ) {
            override fun getNextPosition(position: CarPosition) = when (position.direction) {
                UP -> position.turnLeft()
                RIGHT -> position.turnRight()
                else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
            }

            data object DownLeftTurn : BaseDownLeftTurn(fixed = false), ModifiableTile {
                override fun getIncomingDirectionsAfterModification(
                    traverseDirections: EnumSet<Direction>
                ): EnumMap<Direction, List<Tile>> {
                    return EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
                        put(DOWN, listOf(DownLeftUpFork))
                        put(LEFT, listOf(DownLeftRightFork))
                    }
                }

                override fun matches(solution: Tile): Boolean {
                    if (solution is DownLeftUpFork || solution is DownLeftRightFork) {
                        return true
                    }
                    return super.matches(solution)
                }
            }

            data object FixedDownLeftTurn : BaseDownLeftTurn(fixed = true)

            data class DownLeftToggle(
                override val action: Action
            ) : BaseDownLeftTurn(fixed = true), HasAction {
                constructor(color: Color) : this(Toggle(color))
            }
        }

        sealed class BaseUpRightTurn(
            fixed: Boolean,
        ) : Turn(
            incomingDirections = EnumSet.of(DOWN, LEFT),
            fixed = fixed
        ) {
            override fun getNextPosition(position: CarPosition) = when (position.direction) {
                DOWN -> position.turnLeft()
                LEFT -> position.turnRight()
                else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
            }

            data object UpRightTurn : BaseUpRightTurn(fixed = false), ModifiableTile {
                override fun getIncomingDirectionsAfterModification(
                    traverseDirections: EnumSet<Direction>
                ): EnumMap<Direction, List<Tile>> {
                    return EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
                        put(UP, listOf(UpRightDownFork))
                        put(RIGHT, listOf(UpRightLeftFork))
                    }
                }

                override fun matches(solution: Tile): Boolean {
                    if (solution is UpRightDownFork || solution is UpRightLeftFork) {
                        return true
                    }
                    return super.matches(solution)
                }
            }

            data object FixedUpRightTurn : BaseUpRightTurn(fixed = true)

            data class UpRightToggle(
                override val action: Action
            ) : BaseUpRightTurn(fixed = true), HasAction {
                constructor(color: Color) : this(Toggle(color))
            }

            data class UpRightBarrier(
                override val color: Color,
                override val open: Boolean,
            ) : BaseUpRightTurn(
                fixed = true
            ), Barrier {
                override fun toggled() = UpRightBarrier(color, !open)

                override fun matches(solution: Tile): Boolean {
                    return solution is UpRightBarrier && solution.color == color
                }
            }
        }

        sealed class BaseUpLeftTurn(
            fixed: Boolean,
        ) : Turn(
            incomingDirections = EnumSet.of(DOWN, RIGHT),
            fixed = fixed
        ) {
            override fun getNextPosition(position: CarPosition) = when (position.direction) {
                DOWN -> position.turnRight()
                RIGHT -> position.turnLeft()
                else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
            }

            data object UpLeftTurn : BaseUpLeftTurn(fixed = false), ModifiableTile {
                override fun getIncomingDirectionsAfterModification(
                    traverseDirections: EnumSet<Direction>
                ): EnumMap<Direction, List<Tile>> {
                    return EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
                        put(UP, listOf(UpLeftDownFork))
                        put(LEFT, listOf(UpLeftRightFork))
                    }
                }

                override fun matches(solution: Tile): Boolean {
                    if (solution is UpLeftDownFork || solution is UpLeftRightFork) {
                        return true
                    }
                    return super.matches(solution)
                }
            }

            data object FixedUpLeftTurn : BaseUpLeftTurn(fixed = true)

            data class UpLeftToggle(
                override val action: Action
            ) : BaseUpLeftTurn(fixed = true), HasAction {
                constructor(color: Color) : this(Toggle(color))
            }
        }
    }

    sealed class Fork(
        incomingDirections: EnumSet<Direction>,
        open val fixed: Boolean,
    ) : Tile(incomingDirections) {
        sealed class BaseDownLeftRightFork(
            fixed: Boolean,
        ) : Fork(
            incomingDirections = EnumSet.of(UP, RIGHT, LEFT),
            fixed = fixed,
        ) {
            override fun getNextPosition(position: CarPosition) = when (position.direction) {
                UP -> position.turnLeft()
                RIGHT -> position.turnRight()
                LEFT -> position.moveForward()
                else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
            }

            data object DownLeftRightFork : BaseDownLeftRightFork(fixed = false)

            data object FixedDownLeftRightFork : BaseDownLeftRightFork(fixed = true)

            data class DownLeftRightToggle(
                override val action: Action
            ) : BaseDownLeftRightFork(fixed = true), HasAction {
                constructor(color: Color) : this(Toggle(color))
            }

            data class DownLeftRightToggleableFork(
                override val color: Color
            ) : BaseDownLeftRightFork(fixed = true), Toggleable {
                override fun toggled() = DownRightLeftToggleableFork(color)

                override fun matches(solution: Tile): Boolean {
                    return (solution is DownLeftRightToggleableFork && solution.color == color) ||
                            (solution is DownRightLeftToggleableFork && solution.color == color)
                }
            }
        }

        sealed class BaseDownLeftUpFork(
            fixed: Boolean,
        ) : Fork(
            incomingDirections = EnumSet.of(UP, RIGHT, DOWN),
            fixed = fixed,
        ) {
            override fun getNextPosition(position: CarPosition) = when (position.direction) {
                UP -> position.turnLeft()
                RIGHT -> position.turnRight()
                DOWN -> position.moveForward()
                else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
            }

            data object DownLeftUpFork : BaseDownLeftUpFork(fixed = false)

            data object FixedDownLeftUpFork : BaseDownLeftUpFork(fixed = true)

            data class DownLeftUpToggle(
                override val action: Action
            ) : BaseDownLeftUpFork(fixed = true), HasAction {
                constructor(color: Color) : this(Toggle(color))
            }

            data class DownLeftUpToggleableFork(
                override val color: Color
            ) : BaseDownLeftUpFork(fixed = true), Toggleable {
                override fun toggled() = UpLeftDownToggleableFork(color)

                override fun matches(solution: Tile): Boolean {
                    return (solution is DownLeftUpToggleableFork && solution.color == color) ||
                            (solution is UpLeftDownToggleableFork && solution.color == color)
                }
            }
        }

        sealed class BaseDownRightLeftFork(
            fixed: Boolean,
        ) : Fork(
            incomingDirections = EnumSet.of(UP, RIGHT, LEFT),
            fixed = fixed
        ) {
            override fun getNextPosition(position: CarPosition) = when (position.direction) {
                UP -> position.turnRight()
                LEFT -> position.turnLeft()
                RIGHT -> position.moveForward()
                else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
            }

            data object DownRightLeftFork : BaseDownRightLeftFork(fixed = false)

            data object FixedDownRightLeftFork : BaseDownRightLeftFork(fixed = true)

            data class DownRightLeftToggle(
                override val action: Action
            ) : BaseDownRightLeftFork(fixed = true), HasAction {
                constructor(color: Color) : this(Toggle(color))
            }

            data class DownRightLeftToggleableFork(
                override val color: Color
            ) : BaseDownRightLeftFork(fixed = true), Toggleable {
                override fun toggled() = DownLeftRightToggleableFork(color)

                override fun matches(solution: Tile): Boolean {
                    return (solution is DownRightLeftToggleableFork && solution.color == color) ||
                            (solution is DownLeftRightToggleableFork && solution.color == color)
                }
            }
        }

        sealed class BaseDownRightUpFork(
            fixed: Boolean,
        ) : Fork(
            incomingDirections = EnumSet.of(UP, LEFT, DOWN),
            fixed = fixed
        ) {
            override fun getNextPosition(position: CarPosition) = when (position.direction) {
                UP -> position.turnRight()
                LEFT -> position.turnLeft()
                DOWN -> position.moveForward()
                else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
            }

            data object DownRightUpFork : BaseDownRightUpFork(fixed = false)

            data object FixedDownRightUpFork : BaseDownRightUpFork(fixed = true)

            data class DownRightUpToggle(
                override val action: Action
            ) : BaseDownRightUpFork(fixed = true), HasAction {
                constructor(color: Color) : this(Toggle(color))
            }

            data class DownRightUpToggleableFork(
                override val color: Color
            ) : BaseDownRightUpFork(fixed = true), Toggleable {
                override fun toggled() = UpRightDownToggleableFork(color)

                override fun matches(solution: Tile): Boolean {
                    return (solution is DownRightUpToggleableFork && solution.color == color) ||
                            (solution is UpRightDownToggleableFork && solution.color == color)
                }
            }
        }

        sealed class BaseUpLeftRightFork(
            fixed: Boolean,
        ) : Fork(
            incomingDirections = EnumSet.of(DOWN, RIGHT, LEFT),
            fixed = fixed
        ) {
            override fun getNextPosition(position: CarPosition) = when (position.direction) {
                DOWN -> position.turnRight()
                RIGHT -> position.turnLeft()
                LEFT -> position.moveForward()
                else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
            }

            data object UpLeftRightFork : BaseUpLeftRightFork(fixed = false)

            data object FixedUpLeftRightFork : BaseUpLeftRightFork(fixed = true)

            data class UpLeftRightToggle(
                override val action: Action
            ) : BaseUpLeftRightFork(fixed = true), HasAction {
                constructor(color: Color) : this(Toggle(color))
            }

            data class UpLeftRightToggleableFork(
                override val color: Color
            ) : BaseUpLeftRightFork(fixed = true), Toggleable {
                override fun toggled() = UpRightLeftToggleableFork(color)

                override fun matches(solution: Tile): Boolean {
                    return (solution is UpLeftRightToggleableFork && solution.color == color) ||
                            (solution is UpRightLeftToggleableFork && solution.color == color)
                }
            }
        }

        sealed class BaseUpLeftDownFork(
            fixed: Boolean,
        ) : Fork(
            incomingDirections = EnumSet.of(DOWN, RIGHT, UP),
            fixed = fixed
        ) {
            override fun getNextPosition(position: CarPosition) = when (position.direction) {
                DOWN -> position.turnRight()
                RIGHT -> position.turnLeft()
                UP -> position.moveForward()
                else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
            }

            data object UpLeftDownFork : BaseUpLeftDownFork(fixed = false)

            data object FixedUpLeftDownFork : BaseUpLeftDownFork(fixed = true)

            data class UpLeftDownToggle(
                override val action: Action
            ) : BaseUpLeftDownFork(fixed = true), HasAction {
                constructor(color: Color) : this(Toggle(color))
            }

            data class UpLeftDownToggleableFork(
                override val color: Color
            ) : BaseUpLeftDownFork(fixed = true), Toggleable {
                override fun toggled() = DownLeftUpToggleableFork(color)

                override fun matches(solution: Tile): Boolean {
                    return (solution is UpLeftDownToggleableFork && solution.color == color) ||
                            (solution is DownLeftUpToggleableFork && solution.color == color)
                }
            }
        }

        sealed class BaseUpRightLeftFork(
            fixed: Boolean,
        ) : Fork(
            incomingDirections = EnumSet.of(DOWN, RIGHT, LEFT),
            fixed = fixed
        ) {
            override fun getNextPosition(position: CarPosition) = when (position.direction) {
                DOWN -> position.turnLeft()
                LEFT -> position.turnRight()
                RIGHT -> position.moveForward()
                else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
            }

            data object UpRightLeftFork : BaseUpRightLeftFork(fixed = false)

            data object FixedUpRightLeftFork : BaseUpRightLeftFork(fixed = true)

            data class UpRightLeftToggle(
                override val action: Action
            ) : BaseUpRightLeftFork(fixed = true), HasAction {
                constructor(color: Color) : this(Toggle(color))
            }

            data class UpRightLeftToggleableFork(
                override val color: Color
            ) : BaseUpRightLeftFork(fixed = true), Toggleable {
                override fun toggled() = UpLeftRightToggleableFork(color)

                override fun matches(solution: Tile): Boolean {
                    return (solution is UpRightLeftToggleableFork && solution.color == color) ||
                            (solution is UpLeftRightToggleableFork && solution.color == color)
                }
            }
        }

        sealed class BaseUpRightDownFork(
            fixed: Boolean,
        ) : Fork(
            incomingDirections = EnumSet.of(DOWN, LEFT, UP),
            fixed = fixed
        ) {
            override fun getNextPosition(position: CarPosition) = when (position.direction) {
                DOWN -> position.turnLeft()
                LEFT -> position.turnRight()
                UP -> position.moveForward()
                else -> throw IllegalStateException("$position Invalid direction: ${position.direction}")
            }

            data object UpRightDownFork : BaseUpRightDownFork(fixed = false)

            data object FixedUpRightDownFork : BaseUpRightDownFork(fixed = true)

            data class UpRightDownToggle(
                override val action: Action
            ) : BaseUpRightDownFork(fixed = true), HasAction {
                constructor(color: Color) : this(Toggle(color))
            }

            data class UpRightDownToggleableFork(
                override val color: Color
            ) : BaseUpRightDownFork(fixed = true), Toggleable {
                override fun toggled() = DownRightUpToggleableFork(color)

                override fun matches(solution: Tile): Boolean {
                    return (solution is UpRightDownToggleableFork && solution.color == color) ||
                            (solution is DownRightUpToggleableFork && solution.color == color)
                }
            }
        }
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