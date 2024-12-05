package com.bartoszwesolowski

import com.bartoszwesolowski.Tile.*

object Solutions {
    object World1 {
        val level1_1 = setOf(
            Board.fromRows(
                arrayOf(HorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack),
            )
        )

        val level1_2 = setOf(
            Board.fromRows(
                arrayOf(DownRightTurn, HorizontalTrack, DownLeftTurn, Obstacle, DownRightTurn, EndingTrack),
                arrayOf(VerticalTrack, Obstacle, VerticalTrack, Obstacle, VerticalTrack, Obstacle),
                arrayOf(VerticalTrack, Obstacle, UpRightTurn, HorizontalTrack, UpLeftTurn, Obstacle),
            )
        )

        val level1_3 = setOf(
            Board.fromRows(
                arrayOf(HorizontalTrack, DownLeftRightFork, HorizontalTrack, DownRightTurn, EndingTrack),
                arrayOf(Empty, VerticalTrack, Empty, VerticalTrack, Empty),
                arrayOf(Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, Empty),
            )
        )

        val level1_4 = setOf(
            Board.fromRows(
                arrayOf(Empty, Empty, VerticalTrack, Empty, Empty),
                arrayOf(Empty, DownRightTurn, Empty, DownLeftTurn, Empty),
                arrayOf(HorizontalTrack, DownLeftTurn, Obstacle, DownRightTurn, EndingTrack),
                arrayOf(Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, Empty),
                arrayOf(Empty, Empty, VerticalTrack, Empty, Empty),
            ),
            Board.fromRows(
                arrayOf(Empty, Empty, VerticalTrack, Empty, Empty),
                arrayOf(Empty, DownRightTurn, HorizontalTrack, DownLeftTurn, Empty),
                arrayOf(HorizontalTrack, UpLeftTurn, Obstacle, UpRightTurn, EndingTrack),
                arrayOf(Empty, UpRightTurn, Empty, UpLeftTurn, Empty),
                arrayOf(Empty, Empty, VerticalTrack, Empty, Empty),
            )
        )

        val level1_5 = setOf(
            Board.fromRows(
                arrayOf(DownRightTurn, HorizontalTrack, HorizontalTrack, EndingTrack),
                arrayOf(VerticalTrack, Obstacle, Obstacle, Obstacle),
                arrayOf(UpRightTurn, HorizontalTrack, HorizontalTrack, HorizontalTrack),
            )
        )

        val level1_6 = setOf(
            Board.fromRows(
                arrayOf(Empty, Empty, Empty, Empty, Empty),
                arrayOf(HorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack),
                arrayOf(Empty, Empty, Empty, Empty, Empty),
            )
        )

        val level1_7 = setOf(
            Board.fromRows(
                arrayOf(VerticalTrack, Empty, Empty),
                arrayOf(VerticalTrack, Obstacle, Empty),
                arrayOf(UpRightTurn, HorizontalTrack, EndingTrack),
            )
        )
    }
}