package com.bartoszwesolowski

import com.bartoszwesolowski.Direction.DOWN
import com.bartoszwesolowski.Direction.LEFT
import com.bartoszwesolowski.Direction.RIGHT
import com.bartoszwesolowski.Direction.UP
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

    data object Empty : Tile()

    // Straight tracks
    data object VerticalTrack : Tile(
        incomingDirections = EnumSet.of(UP, DOWN),
        secondaryIncomingDirections = EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
            put(LEFT, listOf(DownLeftUpFork, UpLeftRightFork))
            put(RIGHT, listOf(DownRightUpFork, UpRightDownFork))
        }
    ), ResetAfterModification

    data object HorizontalTrack : Tile(
        incomingDirections = EnumSet.of(LEFT, RIGHT),
        secondaryIncomingDirections = EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
            put(UP, listOf(DownLeftRightFork, DownRightLeftFork))
            put(DOWN, listOf(UpLeftRightFork, UpRightLeftFork))
        }
    ), ResetAfterModification

    // Turns
    data object DownRightTurn : Tile(
        incomingDirections = EnumSet.of(UP, LEFT),
        secondaryIncomingDirections = EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
            put(DOWN, listOf(DownRightUpFork))
            put(RIGHT, listOf(DownRightLeftFork))
        }
    )

    data object DownLeftTurn : Tile(
        incomingDirections = EnumSet.of(UP, RIGHT),
        secondaryIncomingDirections = EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
            put(DOWN, listOf(DownLeftUpFork))
            put(LEFT, listOf(DownLeftRightFork))
        }
    )

    data object UpRightTurn : Tile(
        incomingDirections = EnumSet.of(DOWN, LEFT),
        secondaryIncomingDirections = EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
            put(UP, listOf(UpRightDownFork))
            put(RIGHT, listOf(UpRightLeftFork))
        }
    )

    data object UpLeftTurn : Tile(
        incomingDirections = EnumSet.of(DOWN, RIGHT),
        secondaryIncomingDirections = EnumMap<Direction, List<Tile>>(Direction::class.java).apply {
            put(UP, listOf(UpLeftDownFork))
            put(LEFT, listOf(UpLeftRightFork))
        }
    )

    // Forks
    data object DownLeftRightFork : Tile(UP, RIGHT, LEFT)
    data object DownLeftUpFork : Tile(UP, RIGHT, DOWN)
    data object DownRightLeftFork : Tile(UP, RIGHT, LEFT)
    data object DownRightUpFork : Tile(UP, RIGHT, DOWN)
    data object UpLeftRightFork : Tile(DOWN, RIGHT, LEFT)
    data object UpLeftDownFork : Tile(DOWN, RIGHT, UP)
    data object UpRightLeftFork : Tile(DOWN, RIGHT, LEFT)
    data object UpRightDownFork : Tile(DOWN, RIGHT, UP)

    // Other
    data object Obstacle : Tile()
    data object EndingTrack : Tile(RIGHT)

    fun isValidIncomingDirection(direction: Direction): Boolean {
        return direction in incomingDirections || direction in secondaryIncomingDirections
    }
}