package com.bartoszwesolowski

import java.util.EnumSet

sealed class Tile(val attachments: EnumSet<Direction>) {
    data object Empty : Tile(EnumSet.noneOf(Direction::class.java))
    data object VerticalTrack : Tile(EnumSet.of(Direction.UP, Direction.DOWN))
    data object HorizontalTrack : Tile(EnumSet.of(Direction.LEFT, Direction.RIGHT))
    data object DownRightTurn : Tile(EnumSet.of(Direction.DOWN, Direction.RIGHT))
    data object DownLeftTurn : Tile(EnumSet.of(Direction.DOWN, Direction.LEFT))
    data object UpRightTurn : Tile(EnumSet.of(Direction.UP, Direction.RIGHT))
    data object UpLeftTurn : Tile(EnumSet.of(Direction.UP, Direction.LEFT))
    data object Obstacle : Tile(EnumSet.noneOf(Direction::class.java))
    data object EndingTrack : Tile(EnumSet.of(Direction.LEFT))
}