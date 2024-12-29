package model

import model.Board.Companion.buildBoard
import model.Board.Companion.row
import model.Tile.*

object Solutions {
    object World1 {
        val level1_1 = setOf(
            buildBoard(rows = 1) {
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack)
            }
        )
        val level1_2 = setOf(
            buildBoard(rows = 3) {
                row(DownRightTurn, HorizontalTrack, DownLeftTurn, Obstacle, DownRightTurn, EndingTrack)
                row(VerticalTrack, Obstacle, VerticalTrack, Obstacle, VerticalTrack, Obstacle)
                row(FixedVerticalTrack, Obstacle, UpRightTurn, HorizontalTrack, UpLeftTurn, Obstacle)
            }
        )
        val level1_3 = setOf(
            buildBoard(rows = 3) {
                row(FixedHorizontalTrack, DownLeftRightFork, FixedHorizontalTrack, DownRightTurn, EndingTrack)
                row(Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty)
                row(Empty, FixedUpRightTurn, FixedHorizontalTrack, FixedUpLeftTurn, Empty)
            }
        )
        val level1_4 = setOf(
            buildBoard(rows = 5) {
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, FixedDownRightTurn, Empty, FixedDownLeftTurn, Empty)
                row(FixedHorizontalTrack, DownLeftTurn, Obstacle, DownRightTurn, EndingTrack)
                row(Empty, FixedUpRightTurn, HorizontalTrack, FixedUpLeftTurn, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
            },
            buildBoard(rows = 5) {
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, FixedDownRightTurn, HorizontalTrack, FixedDownLeftTurn, Empty)
                row(FixedHorizontalTrack, UpLeftTurn, Obstacle, UpRightTurn, EndingTrack)
                row(Empty, FixedUpRightTurn, Empty, FixedUpLeftTurn, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
            }
        )
        val level1_5 = setOf(
            buildBoard(rows = 3) {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, EndingTrack)
                row(VerticalTrack, Obstacle, Obstacle, Obstacle)
                row(UpRightTurn, HorizontalTrack, HorizontalTrack, FixedHorizontalTrack)
            }
        )
        val level1_6 = setOf(
            buildBoard(rows = 3) {
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level1_7 = setOf(
            buildBoard(rows = 3) {
                row(FixedVerticalTrack, Empty, Empty)
                row(VerticalTrack, Obstacle, Empty)
                row(UpRightTurn, HorizontalTrack, EndingTrack)
            }
        )
        val level1_8 = setOf(
            buildBoard(rows = 3) {
                row(FixedHorizontalTrack, FixedHorizontalTrack, DownRightLeftFork, EndingTrack)
                row(Empty, DownRightTurn, UpLeftTurn, Empty)
                row(FixedHorizontalTrack, UpLeftTurn, Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(FixedHorizontalTrack, FixedHorizontalTrack, DownRightLeftFork, EndingTrack)
                row(Empty, Empty, VerticalTrack, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, UpLeftTurn, Empty)
            }
        )
        val level1_9 = setOf(
            buildBoard(rows = 3) {
                row(FixedVerticalTrack, Obstacle, FixedVerticalTrack, Empty, Empty)
                row(VerticalTrack, Obstacle, FixedVerticalTrack, Empty, Empty)
                row(UpRightTurn, HorizontalTrack, UpRightLeftFork, FixedHorizontalTrack, EndingTrack)
            }
        )
        val level1_10 = setOf(
            buildBoard(rows = 5) {
                row(FixedHorizontalTrack, HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(Empty, FixedDownRightTurn, UpRightLeftFork, FixedDownLeftTurn, Empty)
                row(Empty, FixedVerticalTrack, Obstacle, UpRightDownFork, EndingTrack)
                row(Empty, FixedUpRightTurn, DownLeftTurn, FixedUpLeftTurn, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, UpLeftTurn, Empty, Empty)
            }
        )
        val level1_11 = setOf(
            buildBoard(rows = 3) {
                row(DownRightTurn, FixedHorizontalTrack, DownLeftTurn, Empty)
                row(VerticalTrack, Obstacle, UpRightTurn, EndingTrack)
                row(UpRightTurn, FixedHorizontalTrack, Empty, Empty)
            }
        )
        val level1_11A = setOf(
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedHorizontalTrack, DownRightLeftFork, DownLeftTurn, Empty, Empty)
                row(Empty, Empty, VerticalTrack, VerticalTrack, Obstacle, Empty)
                row(Empty, FixedHorizontalTrack, UpLeftDownFork, UpRightTurn, HorizontalTrack, EndingTrack)
                row(Empty, Empty, VerticalTrack, Empty, Obstacle, Empty)
                row(Empty, FixedHorizontalTrack, UpLeftTurn, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level1_12 = setOf(
            buildBoard(rows = 3) {
                row(FixedHorizontalTrack, HorizontalTrack, DownRightLeftFork, HorizontalTrack, EndingTrack)
                row(Empty, Empty, UpRightTurn, DownLeftTurn, Empty)
                row(Empty, Empty, FixedHorizontalTrack, UpLeftTurn, Empty)
            },
        )
        val level1_12A = setOf(
            buildBoard(rows = 3) {
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, DownRightLeftFork, FixedHorizontalTrack, EndingTrack)
                row(Empty, UpRightTurn, UpLeftTurn, Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(Empty, DownRightTurn, DownLeftTurn, Empty, Empty)
                row(FixedHorizontalTrack, UpRightLeftFork, UpRightLeftFork, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level1_13 = setOf(
            buildBoard(rows = 5) {
                row(FixedHorizontalTrack, DownLeftTurn, Empty, DownRightTurn, FixedHorizontalTrack)
                row(Empty, VerticalTrack, Obstacle, VerticalTrack, Empty)
                row(Empty, DownRightUpFork, HorizontalTrack, UpLeftTurn, Empty)
                row(Empty, VerticalTrack, Obstacle, Empty, Empty)
                row(Empty, UpRightTurn, HorizontalTrack, HorizontalTrack, EndingTrack)
            }
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
            level1_11A,
            level1_12,
            level1_12A,
            level1_13,
        )
    }
}