package model

import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import model.Board.Companion.buildBoard
import model.Board.Companion.row
import model.CarColor.*
import model.Direction.*
import model.Tile.*

object Levels {
    object World1 {
        val level1_1 = Level(
            name = "1-1",
            board = buildBoard(rows = 1) {
                row(FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 3
        )
        val level1_2 = Level(
            name = "1-2",
            board = buildBoard(rows = 3) {
                row(Empty, Empty, Empty, Obstacle, Empty, EndingTrack)
                row(Empty, Obstacle, Empty, Obstacle, Empty, Obstacle)
                row(FixedVerticalTrack, Obstacle, Empty, Empty, Empty, Obstacle)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(2, 0, UP)),
            ),
            tracks = 10
        )
        val level1_3 = Level(
            name = "1-3",
            board = buildBoard(rows = 3) {
                row(FixedHorizontalTrack, DownLeftRightFork, FixedHorizontalTrack, Empty, EndingTrack)
                row(Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty)
                row(Empty, FixedUpRightTurn, FixedHorizontalTrack, FixedUpLeftTurn, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 1
        )
        val level1_4 = Level(
            name = "1-4",
            board = buildBoard(rows = 5) {
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, FixedDownRightTurn, Empty, FixedDownLeftTurn, Empty)
                row(FixedHorizontalTrack, Empty, Obstacle, Empty, EndingTrack)
                row(Empty, FixedUpRightTurn, Empty, FixedUpLeftTurn, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(2, 0, RIGHT)),
            ),
            tracks = 4
        )
        val level1_5 = Level(
            name = "1-5",
            board = buildBoard(rows = 3) {
                row(Empty, Empty, Empty, EndingTrack)
                row(Empty, Obstacle, Obstacle, Obstacle)
                row(Empty, Empty, Empty, FixedHorizontalTrack)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(2, 3, LEFT)),
            ),
            tracks = 7
        )
        val level1_6 = Level(
            name = "1-6",
            board = buildBoard(rows = 3) {
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(1, 0, RIGHT)),
            ),
            tracks = 3
        )
        val level1_7 = Level(
            name = "1-7",
            board = buildBoard(rows = 3) {
                row(FixedVerticalTrack, Empty, Empty)
                row(Empty, Obstacle, Empty)
                row(Empty, Empty, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(0, 0, DOWN)),
            ),
            tracks = 3
        )
        val level1_8 = Level(
            name = "1-8",
            board = buildBoard(rows = 3) {
                row(FixedHorizontalTrack, FixedHorizontalTrack, DownRightLeftFork, EndingTrack)
                row(Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(2, 0, RIGHT)),
            ),
            tracks = 3
        )
        val level1_9 = Level(
            name = "1-9",
            board = buildBoard(rows = 3) {
                row(FixedVerticalTrack, Obstacle, FixedVerticalTrack, Empty, Empty)
                row(Empty, Obstacle, FixedVerticalTrack, Empty, Empty)
                row(Empty, Empty, Empty, FixedHorizontalTrack, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(0, 2, DOWN)),
                Car(2, Red, CarPosition(0, 0, DOWN)),
            ),
            tracks = 4
        )
        val level1_10 = Level(
            name = "1-10",
            board = buildBoard(rows = 5) {
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(Empty, FixedDownRightTurn, Empty, FixedDownLeftTurn, Empty)
                row(Empty, FixedVerticalTrack, Obstacle, UpRightDownFork, EndingTrack)
                row(Empty, FixedUpRightTurn, Empty, FixedUpLeftTurn, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(0, 0, RIGHT)),
                Car(2, Red, CarPosition(4, 0, RIGHT)),
            ),
            tracks = 6
        )
        val level1_11 = Level(
            name = "1-11",
            board = buildBoard(rows = 3) {
                row(Empty, FixedHorizontalTrack, Empty, Empty)
                row(Empty, Obstacle, Empty, EndingTrack)
                row(Empty, FixedHorizontalTrack, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(0, 1, RIGHT)),
                Car(2, Red, CarPosition(2, 1, LEFT)),
            ),
            tracks = 5
        )
        val level1_11A = Level(
            name = "1-11A",
            board = buildBoard(rows = 7) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(1, 1, RIGHT)),
                Car(2, Red, CarPosition(3, 1, RIGHT)),
                Car(3, Red, CarPosition(5, 1, RIGHT)),
            ),
            tracks = 9
        )
        val level1_11B = Level(
            name = "1-11B",
            board = buildBoard(rows = 7) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(1, 1, LEFT)),
                Car(2, Red, CarPosition(3, 1, RIGHT)),
                Car(3, Red, CarPosition(5, 1, LEFT)),
            ),
            tracks = 15
        )
        val level1_12 = Level(
            name = "1-12",
            board = buildBoard(rows = 3) {
                row(FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedHorizontalTrack, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(0, 0, RIGHT)),
                Car(2, Red, CarPosition(2, 2, RIGHT)),
            ),
            tracks = 6
        )
        val level1_12A = Level(
            name = "1-12A",
            board = buildBoard(rows = 3) {
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(1, 0, RIGHT)),
                Car(2, Red, CarPosition(1, 3, LEFT)),
            ),
            tracks = 4
        )
        val level1_13 = Level(
            name = "1-13",
            board = buildBoard(rows = 5) {
                row(FixedHorizontalTrack, Empty, Empty, Empty, FixedHorizontalTrack)
                row(Empty, Empty, Obstacle, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Obstacle, Empty, Empty)
                row(Empty, Empty, Empty, Empty, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(0, 0, RIGHT)),
                Car(2, Red, CarPosition(0, 4, LEFT)),
            ),
            tracks = 11
        )
        val level1_13A = Level(
            name = "1-13A",
            board = buildBoard(rows = 6) {
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, FixedHorizontalTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(1, 0, RIGHT)),
                Car(2, Red, CarPosition(1, 4, LEFT)),
                Car(3, Red, CarPosition(5, 0, RIGHT)),
            ),
            tracks = 14
        )
        val level1_14 = Level(
            name = "1-14",
            board = buildBoard(rows = 3) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedHorizontalTrack, FixedHorizontalTrack, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(1, 1, LEFT)),
                Car(2, Red, CarPosition(1, 2, RIGHT)),
            ),
            tracks = 12
        )
        val level1_14A = Level(
            name = "1-14A",
            board = buildBoard(rows = 3) {
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedHorizontalTrack, FixedHorizontalTrack, Empty, Empty, Empty, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(1, 1, LEFT)),
                Car(2, Red, CarPosition(1, 2, RIGHT)),
                Car(3, Red, CarPosition(1, 6, LEFT)),
            ),
            tracks = 13
        )
        val level1_15 = Level(
            name = "1-15",
            board = buildBoard(rows = 4) {
                row(FixedHorizontalTrack, FixedHorizontalTrack, Empty, Empty, FixedHorizontalTrack, FixedHorizontalTrack)
                row(Empty, Empty, FixedUpLeftTurn, FixedUpRightTurn, Empty, Empty)
                row(Empty, Empty, FixedDownLeftTurn, FixedDownRightTurn, Empty, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, Empty, Empty, FixedHorizontalTrack, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(3, 0, RIGHT)),
                Car(2, Red, CarPosition(0, 5, LEFT)),
                Car(3, Red, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 8
        )
        val level1_15A = Level(
            name = "1-15A",
            board = buildBoard(rows = 7) {
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, Empty, Empty, Empty, FixedHorizontalTrack, FixedHorizontalTrack)
                row(Empty, Empty, FixedUpLeftTurn, Empty, FixedUpRightTurn, Empty, Empty)
                row(Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty)
                row(Empty, Empty, FixedDownLeftTurn, Empty, FixedDownRightTurn, Empty, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, Empty, FixedVerticalTrack, Empty, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(1, 6, LEFT)),
                Car(2, Red, CarPosition(5, 0, RIGHT)),
                Car(3, Red, CarPosition(1, 0, RIGHT)),
            ),
            tracks = 15
        )
        val levels = mapOf(
            "1-1" to level1_1,
            "1-2" to level1_2,
            "1-3" to level1_3,
            "1-4" to level1_4,
            "1-5" to level1_5,
            "1-6" to level1_6,
            "1-7" to level1_7,
            "1-8" to level1_8,
            "1-9" to level1_9,
            "1-10" to level1_10,
            "1-11" to level1_11,
            "1-11A" to level1_11A,
            "1-11B" to level1_11B,
            "1-12" to level1_12,
            "1-12A" to level1_12A,
            "1-13" to level1_13,
            "1-13A" to level1_13A,
            "1-14" to level1_14,
            "1-14A" to level1_14A,
            "1-15" to level1_15,
            "1-15A" to level1_15A,
        )
    }
}
