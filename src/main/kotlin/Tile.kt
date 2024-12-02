package com.bartoszwesolowski

import com.bartoszwesolowski.Direction.DOWN
import com.bartoszwesolowski.Direction.LEFT
import com.bartoszwesolowski.Direction.RIGHT
import com.bartoszwesolowski.Direction.UP
import java.util.EnumSet

sealed class Tile(val attachments: EnumSet<Direction>) {
    constructor(vararg directions: Direction) : this(EnumSet.copyOf(directions.asList()))

    data object Empty : Tile()

    // Straight tracks
    data object VerticalTrack : Tile(UP, DOWN)
    data object HorizontalTrack : Tile(LEFT, RIGHT)

    // Turns
    data object DownRightTurn : Tile(DOWN, RIGHT)
    data object DownLeftTurn : Tile(DOWN, LEFT)
    data object UpRightTurn : Tile(UP, RIGHT)
    data object UpLeftTurn : Tile(UP, LEFT)

    // Forks
    data object DownLeftRightFork : Tile(DOWN, LEFT, RIGHT)
    data object DownLeftUpFork : Tile(DOWN, LEFT, UP)
    data object DownRightLeftFork : Tile(DOWN, LEFT, RIGHT)
    data object DownRightUpFork : Tile(DOWN, LEFT, UP)
    data object UpLeftRightFork : Tile(UP, LEFT, RIGHT)
    data object UpLeftDownFork : Tile(UP, LEFT, DOWN)
    data object UpRightLeftFork : Tile(UP, LEFT, RIGHT)
    data object UpRightDOWNFork : Tile(UP, LEFT, DOWN)

    // Other
    data object Obstacle : Tile()
    data object EndingTrack : Tile(LEFT)
}