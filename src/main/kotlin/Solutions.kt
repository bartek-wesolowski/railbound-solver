package com.bartoszwesolowski

import com.bartoszwesolowski.Tile.*

object Solutions {
    object World1 {
        val level1_1 = setOf(
            Board.fromRows(
                arrayOf(FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack),
            )
        )
        val level1_2 = setOf(
            Board.fromRows(
                arrayOf(DownRightTurn, HorizontalTrack, DownLeftTurn, Obstacle, DownRightTurn, EndingTrack),
                arrayOf(VerticalTrack, Obstacle, VerticalTrack, Obstacle, VerticalTrack, Obstacle),
                arrayOf(FixedVerticalTrack, Obstacle, UpRightTurn, HorizontalTrack, UpLeftTurn, Obstacle),
            )
        )
        val level1_3 = setOf(
            Board.fromRows(
                arrayOf(FixedHorizontalTrack, DownLeftRightFork, FixedHorizontalTrack, DownRightTurn, EndingTrack),
                arrayOf(Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty),
                arrayOf(Empty, FixedUpRightTurn, FixedHorizontalTrack, FixedUpLeftTurn, Empty),
            )
        )
        val level1_4 = setOf(
            Board.fromRows(
                arrayOf(Empty, Empty, FixedVerticalTrack, Empty, Empty),
                arrayOf(Empty, FixedDownRightTurn, Empty, FixedDownLeftTurn, Empty),
                arrayOf(FixedHorizontalTrack, DownLeftTurn, Obstacle, DownRightTurn, EndingTrack),
                arrayOf(Empty, FixedUpRightTurn, HorizontalTrack, FixedUpLeftTurn, Empty),
                arrayOf(Empty, Empty, FixedVerticalTrack, Empty, Empty),
            ),
            Board.fromRows(
                arrayOf(Empty, Empty, FixedVerticalTrack, Empty, Empty),
                arrayOf(Empty, FixedDownRightTurn, HorizontalTrack, FixedDownLeftTurn, Empty),
                arrayOf(FixedHorizontalTrack, UpLeftTurn, Obstacle, UpRightTurn, EndingTrack),
                arrayOf(Empty, FixedUpRightTurn, Empty, FixedUpLeftTurn, Empty),
                arrayOf(Empty, Empty, FixedVerticalTrack, Empty, Empty),
            )
        )
        val level1_5 = setOf(
            Board.fromRows(
                arrayOf(DownRightTurn, HorizontalTrack, HorizontalTrack, EndingTrack),
                arrayOf(VerticalTrack, Obstacle, Obstacle, Obstacle),
                arrayOf(UpRightTurn, HorizontalTrack, HorizontalTrack, FixedHorizontalTrack),
            )
        )
        val level1_6 = setOf(
            Board.fromRows(
                arrayOf(Empty, Empty, Empty, Empty, Empty),
                arrayOf(FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack),
                arrayOf(Empty, Empty, Empty, Empty, Empty),
            )
        )
        val level1_7 = setOf(
            Board.fromRows(
                arrayOf(FixedVerticalTrack, Empty, Empty),
                arrayOf(VerticalTrack, Obstacle, Empty),
                arrayOf(UpRightTurn, HorizontalTrack, EndingTrack),
            )
        )
        val level1_8 = setOf(
            Board.fromRows(
                arrayOf(FixedHorizontalTrack, FixedHorizontalTrack, DownRightLeftFork, EndingTrack),
                arrayOf(Empty, DownRightTurn, UpLeftTurn, Empty),
                arrayOf(FixedHorizontalTrack, UpLeftTurn, Empty, Empty),
            ),
            Board.fromRows(
                arrayOf(FixedHorizontalTrack, FixedHorizontalTrack, DownRightLeftFork, EndingTrack),
                arrayOf(Empty, Empty, VerticalTrack, Empty),
                arrayOf(FixedHorizontalTrack, HorizontalTrack, UpLeftTurn, Empty),
            )
        )
        val level1_9 = setOf(
            Board.fromRows(
                arrayOf(FixedVerticalTrack, Obstacle, FixedVerticalTrack, Empty, Empty),
                arrayOf(VerticalTrack, Obstacle, FixedVerticalTrack, Empty, Empty),
                arrayOf(UpRightTurn, HorizontalTrack, UpRightLeftFork, FixedHorizontalTrack, EndingTrack),
            )
        )
        val level1_10 = setOf(
            Board.fromRows(
                arrayOf(FixedHorizontalTrack, HorizontalTrack, DownLeftTurn, Empty, Empty),
                arrayOf(Empty, FixedDownRightTurn, UpRightLeftFork, FixedDownLeftTurn, Empty),
                arrayOf(Empty, FixedVerticalTrack, Obstacle, UpRightDownFork, EndingTrack),
                arrayOf(Empty, FixedUpRightTurn, DownLeftTurn, FixedUpLeftTurn, Empty),
                arrayOf(FixedHorizontalTrack, HorizontalTrack, UpLeftTurn, Empty, Empty),
            )
        )
        val level1_11 = setOf(
            Board.fromRows(
                arrayOf(DownRightTurn, FixedHorizontalTrack, DownLeftTurn, Empty),
                arrayOf(VerticalTrack, Obstacle, UpRightTurn, EndingTrack),
                arrayOf(UpRightTurn, FixedHorizontalTrack, Empty, Empty),
            )
        )
        val solutions = listOf(
            level1_1,
            level1_2,
            level1_3,
            level1_4,
            level1_5,
            level1_6,
            level1_7,
            level1_8,
            level1_9,
            level1_10,
            level1_11,
        )
    }
}