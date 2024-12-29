package model

import model.Board.Companion.buildBoard
import model.Board.Companion.row
import model.CarColor.*
import model.Direction.*
import model.Tile.*

object Levels {
    object World1 {
        val level1_1 = Level(
            board = buildBoard(rows = 1) {
                row(FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
            },
            cars = arrayListOf(
                Car(1, Red, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 3
        )
        val level1_2 = Level(
            board = buildBoard(rows = 3) {
                row(Empty, Empty, Empty, Obstacle, Empty, EndingTrack)
                row(Empty, Obstacle, Empty, Obstacle, Empty, Obstacle)
                row(FixedVerticalTrack, Obstacle, Empty, Empty, Empty, Obstacle)
            },
            cars = arrayListOf(
                Car(1, Red, CarPosition(2, 0, UP)),
            ),
            tracks = 10
        )
        val level1_3 = Level(
            board = buildBoard(rows = 3) {
                row(FixedHorizontalTrack, DownLeftRightFork, FixedHorizontalTrack, Empty, EndingTrack)
                row(Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty)
                row(Empty, FixedUpRightTurn, FixedHorizontalTrack, FixedUpLeftTurn, Empty)
            },
            cars = arrayListOf(
                Car(1, Red, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 1
        )
        val level1_4 = Level(
            board = buildBoard(rows = 5) {
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, FixedDownRightTurn, Empty, FixedDownLeftTurn, Empty)
                row(FixedHorizontalTrack, Empty, Obstacle, Empty, EndingTrack)
                row(Empty, FixedUpRightTurn, Empty, FixedUpLeftTurn, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
            },
            cars = arrayListOf(
                Car(1, Red, CarPosition(2, 0, RIGHT)),
            ),
            tracks = 4
        )
        val level1_5 = Level(
            board = buildBoard(rows = 3) {
                row(Empty, Empty, Empty, EndingTrack)
                row(Empty, Obstacle, Obstacle, Obstacle)
                row(Empty, Empty, Empty, FixedHorizontalTrack)
            },
            cars = arrayListOf(
                Car(1, Red, CarPosition(2, 3, LEFT)),
            ),
            tracks = 7
        )
        val level1_6 = Level(
            board = buildBoard(rows = 3) {
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
            },
            cars = arrayListOf(
                Car(1, Red, CarPosition(1, 0, RIGHT)),
            ),
            tracks = 3
        )
        val level1_7 = Level(
            board = buildBoard(rows = 3) {
                row(FixedVerticalTrack, Empty, Empty)
                row(Empty, Obstacle, Empty)
                row(Empty, Empty, EndingTrack)
            },
            cars = arrayListOf(
                Car(1, Red, CarPosition(0, 0, DOWN)),
            ),
            tracks = 3
        )
        val level1_8 = Level(
            board = buildBoard(rows = 3) {
                row(FixedHorizontalTrack, FixedHorizontalTrack, DownRightLeftFork, EndingTrack)
                row(Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty)
            },
            cars = arrayListOf(
                Car(1, Red, CarPosition(2, 0, RIGHT)),
            ),
            tracks = 3
        )
        val level1_9 = Level(
            board = buildBoard(rows = 3) {
                row(FixedVerticalTrack, Obstacle, FixedVerticalTrack, Empty, Empty)
                row(Empty, Obstacle, FixedVerticalTrack, Empty, Empty)
                row(Empty, Empty, Empty, FixedHorizontalTrack, EndingTrack)
            },
            cars = arrayListOf(
                Car(1, Red, CarPosition(0, 2, DOWN)),
                Car(2, Red, CarPosition(0, 0, DOWN)),
            ),
            tracks = 4
        )
        val level1_10 = Level(
            board = buildBoard(rows = 5) {
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(Empty, FixedDownRightTurn, Empty, FixedDownLeftTurn, Empty)
                row(Empty, FixedVerticalTrack, Obstacle, UpRightDownFork, EndingTrack)
                row(Empty, FixedUpRightTurn, Empty, FixedUpLeftTurn, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty)
            },
            cars = arrayListOf(
                Car(1, Red, CarPosition(0, 0, RIGHT)),
                Car(2, Red, CarPosition(4, 0, RIGHT)),
            ),
            tracks = 6
        )
        val level1_11 = Level(
            board = buildBoard(rows = 3) {
                row(Empty, FixedHorizontalTrack, Empty, Empty)
                row(Empty, Obstacle, Empty, EndingTrack)
                row(Empty, FixedHorizontalTrack, Empty, Empty)
            },
            cars = arrayListOf(
                Car(1, Red, CarPosition(0, 1, RIGHT)),
                Car(2, Red, CarPosition(2, 1, LEFT)),
            ),
            tracks = 5
        )
        val level1_11A = Level(
            board = buildBoard(rows = 7) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            cars = arrayListOf(
                Car(1, Red, CarPosition(1, 1, RIGHT)),
                Car(2, Red, CarPosition(3, 1, RIGHT)),
                Car(3, Red, CarPosition(5, 1, RIGHT)),
            ),
            tracks = 9
        )
        val levels = listOf(
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
        )
    }
}
