package model

import model.Action.TakePassenger
import model.Action.ToggleColor
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

sealed interface Stop

sealed interface HasAction {
    fun getAction(board: Board): Action?
}

sealed interface Toggle: HasAction {
    val color: Color
    override fun getAction(board: Board) = ToggleColor(color)
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
        override fun getNextPosition(board: Board, car: Car): CarPosition {
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
        override fun getNextPosition(board: Board, car: Car) = car.position.moveForward()

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
            override val color: Color
        ) : BaseVerticalTrack(), Toggle

        data class VerticalBarrier(
            override val color: Color,
            override val open: Boolean,
        ) : BaseVerticalTrack(), Barrier {
            private val toggled by lazy(LazyThreadSafetyMode.NONE) { VerticalBarrier(color, !open) }
            override fun toggled() = toggled

            override fun matches(solution: Tile): Boolean {
                return solution is VerticalBarrier && solution.color == color
            }
        }

        data class VerticalStop(
            val number: Int
        ) : BaseVerticalTrack(), Stop, HasAction {
            override fun getNextPosition(board: Board, car: Car): CarPosition {
                return if (board.getPlatform(this).isFull) {
                    car.position
                } else {
                    super.getNextPosition(board, car)
                }
            }

            override fun getAction(board: Board): Action? {
                val platform = board.getPlatform(this)
                return if (platform.isFull) {
                    TakePassenger(board.getPlatformPosition(this))
                } else {
                    null
                }
            }
        }
    }

    sealed class BaseHorizontalTrack : Tile(
        incomingDirections = EnumSet.of(LEFT, RIGHT),
    ), StraightTrack {
        override fun getNextPosition(board: Board, car: Car) = car.position.moveForward()

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
            override val color: Color
        ) : BaseHorizontalTrack(), Toggle

        data class HorizontalBarrier(
            override val color: Color,
            override val open: Boolean,
        ) : BaseHorizontalTrack(), Barrier {
            private val toggled by lazy(LazyThreadSafetyMode.NONE) { HorizontalBarrier(color, !open) }
            override fun toggled() = toggled

            override fun matches(solution: Tile): Boolean {
                return solution is HorizontalBarrier && solution.color == color
            }
        }

        data class HorizontalStop(
            val number: Int
        ) : BaseHorizontalTrack(), Stop, HasAction {
            override fun getNextPosition(board: Board, car: Car): CarPosition {
                return if (board.getPlatform(this).isFull) {
                    car.position
                } else {
                    super.getNextPosition(board, car)
                }
            }

            override fun getAction(board: Board): Action? {
                val platform = board.getPlatform(this)
                return if (platform.isFull) {
                    TakePassenger(board.getPlatformPosition(this))
                } else {
                    null
                }
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
            override fun getNextPosition(board: Board, car: Car) = when (car.direction) {
                UP -> car.position.turnRight()
                LEFT -> car.position.turnLeft()
                else -> throw IllegalStateException("$car Invalid direction: ${car.direction}")
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
                override val color: Color
            ) : BaseDownRightTurn(fixed = true), Toggle
        }

        sealed class BaseDownLeftTurn(
            fixed: Boolean,
        ) : Turn(
            incomingDirections = EnumSet.of(UP, RIGHT),
            fixed = fixed
        ) {
            override fun getNextPosition(board: Board, car: Car) = when (car.direction) {
                UP -> car.position.turnLeft()
                RIGHT -> car.position.turnRight()
                else -> throw IllegalStateException("$car Invalid direction: ${car.direction}")
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
                override val color: Color
            ) : BaseDownLeftTurn(fixed = true), Toggle
        }

        sealed class BaseUpRightTurn(
            fixed: Boolean,
        ) : Turn(
            incomingDirections = EnumSet.of(DOWN, LEFT),
            fixed = fixed
        ) {
            override fun getNextPosition(board: Board, car: Car) = when (car.direction) {
                DOWN -> car.position.turnLeft()
                LEFT -> car.position.turnRight()
                else -> throw IllegalStateException("$car Invalid direction: ${car.direction}")
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
                override val color: Color
            ) : BaseUpRightTurn(fixed = true), Toggle

            data class UpRightBarrier(
                override val color: Color,
                override val open: Boolean,
            ) : BaseUpRightTurn(
                fixed = true
            ), Barrier {
                private val toggled by lazy(LazyThreadSafetyMode.NONE) { UpRightBarrier(color, !open) }
                override fun toggled() = toggled

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
            override fun getNextPosition(board: Board, car: Car) = when (car.direction) {
                DOWN -> car.position.turnRight()
                RIGHT -> car.position.turnLeft()
                else -> throw IllegalStateException("$car Invalid direction: ${car.direction}")
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
                override val color: Color
            ) : BaseUpLeftTurn(fixed = true), Toggle
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
            override fun getNextPosition(board: Board, car: Car) = when (car.direction) {
                UP -> car.position.turnLeft()
                RIGHT -> car.position.turnRight()
                LEFT -> car.position.moveForward()
                else -> throw IllegalStateException("$car Invalid direction: ${car.direction}")
            }

            data object DownLeftRightFork : BaseDownLeftRightFork(fixed = false)

            data object FixedDownLeftRightFork : BaseDownLeftRightFork(fixed = true)

            data class DownLeftRightToggle(
                override val color: Color
            ) : BaseDownLeftRightFork(fixed = true), Toggle

            data class DownLeftRightToggleableFork(
                override val color: Color
            ) : BaseDownLeftRightFork(fixed = true), Toggleable {
                private val toggled by lazy(LazyThreadSafetyMode.NONE) { DownRightLeftToggleableFork(color) }
                override fun toggled() = toggled

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
            override fun getNextPosition(board: Board, car: Car) = when (car.direction) {
                UP -> car.position.turnLeft()
                RIGHT -> car.position.turnRight()
                DOWN -> car.position.moveForward()
                else -> throw IllegalStateException("$car Invalid direction: ${car.direction}")
            }

            data object DownLeftUpFork : BaseDownLeftUpFork(fixed = false)

            data object FixedDownLeftUpFork : BaseDownLeftUpFork(fixed = true)

            data class DownLeftUpToggle(
                override val color: Color
            ) : BaseDownLeftUpFork(fixed = true), Toggle

            data class DownLeftUpToggleableFork(
                override val color: Color
            ) : BaseDownLeftUpFork(fixed = true), Toggleable {
                private val toggled by lazy(LazyThreadSafetyMode.NONE) { UpLeftDownToggleableFork(color) }
                override fun toggled() = toggled

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
            override fun getNextPosition(board: Board, car: Car) = when (car.direction) {
                UP -> car.position.turnRight()
                LEFT -> car.position.turnLeft()
                RIGHT -> car.position.moveForward()
                else -> throw IllegalStateException("$car Invalid direction: ${car.direction}")
            }

            data object DownRightLeftFork : BaseDownRightLeftFork(fixed = false)

            data object FixedDownRightLeftFork : BaseDownRightLeftFork(fixed = true)

            data class DownRightLeftToggle(
                override val color: Color
            ) : BaseDownRightLeftFork(fixed = true), Toggle

            data class DownRightLeftToggleableFork(
                override val color: Color
            ) : BaseDownRightLeftFork(fixed = true), Toggleable {
                private val toggled by lazy(LazyThreadSafetyMode.NONE) { DownLeftRightToggleableFork(color) }
                override fun toggled() = toggled

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
            override fun getNextPosition(board: Board, car: Car) = when (car.direction) {
                UP -> car.position.turnRight()
                LEFT -> car.position.turnLeft()
                DOWN -> car.position.moveForward()
                else -> throw IllegalStateException("$car Invalid direction: ${car.direction}")
            }

            data object DownRightUpFork : BaseDownRightUpFork(fixed = false)

            data object FixedDownRightUpFork : BaseDownRightUpFork(fixed = true)

            data class DownRightUpToggle(
                override val color: Color
            ) : BaseDownRightUpFork(fixed = true), Toggle

            data class DownRightUpToggleableFork(
                override val color: Color
            ) : BaseDownRightUpFork(fixed = true), Toggleable {
                private val toggled by lazy(LazyThreadSafetyMode.NONE) { UpRightDownToggleableFork(color) }
                override fun toggled() = toggled

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
            override fun getNextPosition(board: Board, car: Car) = when (car.direction) {
                DOWN -> car.position.turnRight()
                RIGHT -> car.position.turnLeft()
                LEFT -> car.position.moveForward()
                else -> throw IllegalStateException("$car Invalid direction: ${car.direction}")
            }

            data object UpLeftRightFork : BaseUpLeftRightFork(fixed = false)

            data object FixedUpLeftRightFork : BaseUpLeftRightFork(fixed = true)

            data class UpLeftRightToggle(
                override val color: Color
            ) : BaseUpLeftRightFork(fixed = true), Toggle

            data class UpLeftRightToggleableFork(
                override val color: Color
            ) : BaseUpLeftRightFork(fixed = true), Toggleable {
                private val toggled by lazy(LazyThreadSafetyMode.NONE) { UpRightLeftToggleableFork(color) }
                override fun toggled() = toggled

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
            override fun getNextPosition(board: Board, car: Car) = when (car.direction) {
                DOWN -> car.position.turnRight()
                RIGHT -> car.position.turnLeft()
                UP -> car.position.moveForward()
                else -> throw IllegalStateException("$car Invalid direction: ${car.direction}")
            }

            data object UpLeftDownFork : BaseUpLeftDownFork(fixed = false)

            data object FixedUpLeftDownFork : BaseUpLeftDownFork(fixed = true)

            data class UpLeftDownToggle(
                override val color: Color
            ) : BaseUpLeftDownFork(fixed = true), Toggle

            data class UpLeftDownToggleableFork(
                override val color: Color
            ) : BaseUpLeftDownFork(fixed = true), Toggleable {
                private val toggled by lazy(LazyThreadSafetyMode.NONE) { DownLeftUpToggleableFork(color) }
                override fun toggled() = toggled

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
            override fun getNextPosition(board: Board, car: Car) = when (car.direction) {
                DOWN -> car.position.turnLeft()
                LEFT -> car.position.turnRight()
                RIGHT -> car.position.moveForward()
                else -> throw IllegalStateException("$car Invalid direction: ${car.direction}")
            }

            data object UpRightLeftFork : BaseUpRightLeftFork(fixed = false)

            data object FixedUpRightLeftFork : BaseUpRightLeftFork(fixed = true)

            data class UpRightLeftToggle(
                override val color: Color
            ) : BaseUpRightLeftFork(fixed = true), Toggle

            data class UpRightLeftToggleableFork(
                override val color: Color
            ) : BaseUpRightLeftFork(fixed = true), Toggleable {
                private val toggled by lazy(LazyThreadSafetyMode.NONE) { UpLeftRightToggleableFork(color) }
                override fun toggled() = toggled

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
            override fun getNextPosition(board: Board, car: Car) = when (car.direction) {
                DOWN -> car.position.turnLeft()
                LEFT -> car.position.turnRight()
                UP -> car.position.moveForward()
                else -> throw IllegalStateException("$car Invalid direction: ${car.direction}")
            }

            data object UpRightDownFork : BaseUpRightDownFork(fixed = false)

            data object FixedUpRightDownFork : BaseUpRightDownFork(fixed = true)

            data class UpRightDownToggle(
                override val color: Color
            ) : BaseUpRightDownFork(fixed = true), Toggle

            data class UpRightDownToggleableFork(
                override val color: Color
            ) : BaseUpRightDownFork(fixed = true), Toggleable {
                private val toggled by lazy(LazyThreadSafetyMode.NONE) { DownRightUpToggleableFork(color) }
                override fun toggled() = toggled

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
        override fun getNextPosition(board: Board, car: Car): CarPosition {
            return when (car.direction) {
                RIGHT -> exitPosition.moveForward()
                LEFT -> car.position.moveForward()
                else -> throw IllegalStateException("Invalid direction in LeftTunnel: ${car.direction}")
            }
        }
    }

    data class RightTunnel(
        override val color: TunnelColor,
        override val exitPosition: CarPosition,
    ) : Tile(LEFT), Tunnel {
        override fun getNextPosition(board: Board, car: Car): CarPosition {
            return when (car.direction) {
                LEFT -> exitPosition.moveForward()
                RIGHT -> car.position.moveForward()
                else -> throw IllegalStateException("Invalid direction in RightTunnel: ${car.direction}")
            }
        }
    }

    data class UpTunnel(
        override val color: TunnelColor,
        override val exitPosition: CarPosition,
    ) : Tile(DOWN), Tunnel {
        override fun getNextPosition(board: Board, car: Car): CarPosition {
            return when (car.direction) {
                DOWN -> exitPosition.moveForward()
                UP -> car.position.moveForward()
                else -> throw IllegalStateException("Invalid direction in UpTunnel: ${car.direction}")
            }
        }
    }

    data class DownTunnel(
        override val color: TunnelColor,
        override val exitPosition: CarPosition,
    ) : Tile(UP), Tunnel {
        override fun getNextPosition(board: Board, car: Car): CarPosition {
            return when (car.direction) {
                UP -> exitPosition.moveForward()
                DOWN -> car.position.moveForward()
                else -> throw IllegalStateException("Invalid direction in DownTunnel: ${car.direction}")
            }
        }
    }

    // Other
    data object Obstacle : Tile() {
        override fun getNextPosition(board: Board, car: Car): Nothing {
            throw IllegalStateException("Obstacle should not be used")
        }
    }

    data object EndingTrack : Tile(RIGHT) {
        override fun getNextPosition(board: Board, car: Car): Nothing {
            throw IllegalStateException("Ending track should not be used")
        }
    }

    sealed class Platform(
        open val number: Int,
        open val isFull: Boolean,
    ) : Tile() {
        data class LeftPlatform(
            override val number: Int,
            override val isFull: Boolean,
        ) : Platform(number, isFull) {
            override fun getNextPosition(board: Board, car: Car): Nothing {
                throw IllegalStateException("Left platform should not be used")
            }
        }

        data class RightPlatform(
            override val number: Int,
            override val isFull: Boolean,
        ) : Platform(number, isFull) {
            override fun getNextPosition(board: Board, car: Car): Nothing {
                throw IllegalStateException("Right platform should not be used")
            }
        }

        data class UpPlatform(
            override val number: Int,
            override val isFull: Boolean,
        ) : Platform(number, isFull) {
            override fun getNextPosition(board: Board, car: Car): Nothing {
                throw IllegalStateException("Up platform should not be used")
            }
        }

        data class DownPlatform(
            override val number: Int,
            override val isFull: Boolean,
        ) : Platform(number, isFull) {
            override fun getNextPosition(board: Board, car: Car): Nothing {
                throw IllegalStateException("Down platform should not be used")
            }
        }

        fun withoutPassenger(): Platform = when(this) {
            is LeftPlatform -> LeftPlatform(number, isFull = false)
            is RightPlatform -> RightPlatform(number, isFull = false)
            is UpPlatform -> UpPlatform(number, isFull = false)
            is DownPlatform -> DownPlatform(number, isFull = false)
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

    abstract fun getNextPosition(board: Board, car: Car): CarPosition
}