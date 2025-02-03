package model

import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import model.BarrierColor.DARK_GREEN
import model.BarrierColor.LIGHT_GREEN
import model.Board.Companion.buildBoard
import model.Board.Companion.row
import model.CarColor.*
import model.Direction.*
import model.Tile.*
import model.Tile.BaseHorizontalTrack.*
import model.Tile.BaseVerticalTrack.*
import model.TunnelColor.*

object Levels {
    object World1 {
        val level1_1 = Level(
            name = "1-1",
            board = buildBoard(rows = 1) {
                row(FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, RED, CarPosition(0, 0, RIGHT)),
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
                Car(1, RED, CarPosition(2, 0, UP)),
            ),
            tracks = 10
        )
        val level1_3 = Level(
            name = "1-3",
            board = buildBoard(rows = 3) {
                row(FixedHorizontalTrack, DownLeftRightFork(), FixedHorizontalTrack, Empty, EndingTrack)
                row(Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty)
                row(Empty, UpRightTurn(fixed = true), FixedHorizontalTrack, UpLeftTurn(fixed = true), Empty)
            },
            cars = immutableArrayOf(
                Car(1, RED, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 1
        )
        val level1_4 = Level(
            name = "1-4",
            board = buildBoard(rows = 5) {
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, DownRightTurn(fixed = true), Empty, DownLeftTurn(fixed = true), Empty)
                row(FixedHorizontalTrack, Empty, Obstacle, Empty, EndingTrack)
                row(Empty, UpRightTurn(fixed = true), Empty, UpLeftTurn(fixed = true), Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, RED, CarPosition(2, 0, RIGHT)),
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
                Car(1, RED, CarPosition(2, 3, LEFT)),
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
                Car(1, RED, CarPosition(1, 0, RIGHT)),
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
                Car(1, RED, CarPosition(0, 0, DOWN)),
            ),
            tracks = 3
        )
        val level1_8 = Level(
            name = "1-8",
            board = buildBoard(rows = 3) {
                row(FixedHorizontalTrack, FixedHorizontalTrack, DownRightLeftFork(), EndingTrack)
                row(Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, RED, CarPosition(2, 0, RIGHT)),
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
                Car(1, RED, CarPosition(0, 2, DOWN)),
                Car(2, RED, CarPosition(0, 0, DOWN)),
            ),
            tracks = 4
        )
        val level1_10 = Level(
            name = "1-10",
            board = buildBoard(rows = 5) {
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(Empty, DownRightTurn(fixed = true), Empty, DownLeftTurn(fixed = true), Empty)
                row(Empty, FixedVerticalTrack, Obstacle, UpRightDownFork(), EndingTrack)
                row(Empty, UpRightTurn(fixed = true), Empty, UpLeftTurn(fixed = true), Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, RED, CarPosition(0, 0, RIGHT)),
                Car(2, RED, CarPosition(4, 0, RIGHT)),
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
                Car(1, RED, CarPosition(0, 1, RIGHT)),
                Car(2, RED, CarPosition(2, 1, LEFT)),
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
                Car(1, RED, CarPosition(1, 1, RIGHT)),
                Car(2, RED, CarPosition(3, 1, RIGHT)),
                Car(3, RED, CarPosition(5, 1, RIGHT)),
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
                Car(1, RED, CarPosition(1, 1, LEFT)),
                Car(2, RED, CarPosition(3, 1, RIGHT)),
                Car(3, RED, CarPosition(5, 1, LEFT)),
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
                Car(1, RED, CarPosition(0, 0, RIGHT)),
                Car(2, RED, CarPosition(2, 2, RIGHT)),
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
                Car(1, RED, CarPosition(1, 0, RIGHT)),
                Car(2, RED, CarPosition(1, 3, LEFT)),
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
                Car(1, RED, CarPosition(0, 0, RIGHT)),
                Car(2, RED, CarPosition(0, 4, LEFT)),
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
                Car(1, RED, CarPosition(1, 0, RIGHT)),
                Car(2, RED, CarPosition(1, 4, LEFT)),
                Car(3, RED, CarPosition(5, 0, RIGHT)),
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
                Car(1, RED, CarPosition(1, 1, LEFT)),
                Car(2, RED, CarPosition(1, 2, RIGHT)),
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
                Car(1, RED, CarPosition(1, 1, LEFT)),
                Car(2, RED, CarPosition(1, 2, RIGHT)),
                Car(3, RED, CarPosition(1, 6, LEFT)),
            ),
            tracks = 13
        )
        val level1_15 = Level(
            name = "1-15",
            board = buildBoard(rows = 4) {
                row(FixedHorizontalTrack, FixedHorizontalTrack, Empty, Empty, FixedHorizontalTrack, FixedHorizontalTrack)
                row(Empty, Empty, UpLeftTurn(fixed = true), UpRightTurn(fixed = true), Empty, Empty)
                row(Empty, Empty, DownLeftTurn(fixed = true), DownRightTurn(fixed = true), Empty, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, Empty, Empty, FixedHorizontalTrack, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, RED, CarPosition(3, 0, RIGHT)),
                Car(2, RED, CarPosition(0, 5, LEFT)),
                Car(3, RED, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 8
        )
        val level1_15A = Level(
            name = "1-15A",
            board = buildBoard(rows = 7) {
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, Empty, Empty, Empty, FixedHorizontalTrack, FixedHorizontalTrack)
                row(Empty, Empty, UpLeftTurn(fixed = true), Empty, UpRightTurn(fixed = true), Empty, Empty)
                row(Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty)
                row(Empty, Empty, DownLeftTurn(fixed = true), Empty, DownRightTurn(fixed = true), Empty, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, Empty, FixedVerticalTrack, Empty, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, RED, CarPosition(1, 6, LEFT)),
                Car(2, RED, CarPosition(5, 0, RIGHT)),
                Car(3, RED, CarPosition(1, 0, RIGHT)),
            ),
            tracks = 15
        )
        val levels = listOf(
            level1_1,
            level1_2,
            level1_4,
            level1_5,
            level1_3,
            level1_6,
            level1_7,
            level1_8,
            level1_9,
            level1_10,
            level1_11,
            level1_11A,
            level1_11B,
            level1_12,
            level1_12A,
            level1_13,
            level1_13A,
            level1_14,
            level1_14A,
            level1_15,
            level1_15A,
        ).associateBy { it.name }
    }
    object World2 {
        val level2_1 = Level(
            name = "2-1",
            board = buildBoard(rows = 4) {
                row(Empty, Empty, Empty, RightTunnel(GRAY, CarPosition(3, 3, LEFT)), Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, LeftTunnel(GRAY, CarPosition(0, 3, RIGHT)), Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, BLUE, CarPosition(3, 0, RIGHT)),
            ),
            tracks = 4
        )
        val level2_2 = Level(
            name = "2-2",
            board = buildBoard(rows = 5) {
                row(Empty, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(2, 4, LEFT)), Empty, Empty, Empty, LeftTunnel(GRAY, CarPosition(2, 0, RIGHT)))
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, BLUE, CarPosition(4, 0, RIGHT)),
            ),
            tracks = 6
        )
        val level2_3 = Level(
            name = "2-3",
            board = buildBoard(rows = 5) {
                row(RightTunnel(GRAY, CarPosition(3, 0, RIGHT)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, FixedHorizontalTrack)
                row(RightTunnel(GRAY, CarPosition(0, 0, RIGHT)), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, FixedHorizontalTrack)
            },
            cars = immutableArrayOf(
                Car(1, BLUE, CarPosition(2, 4, LEFT)),
                Car(2, BLUE, CarPosition(4, 4, LEFT)),
            ),
            tracks = 6
        )
        val level2_3A = Level(
            name = "2-3A",
            board = buildBoard(rows = 7) {
                row(RightTunnel(GRAY, CarPosition(5, 0, RIGHT)), Empty, Empty, FixedHorizontalTrack, EndingTrack)
                row(Obstacle, FixedVerticalTrack, Empty, Empty, Empty)
                row(Obstacle, Empty, FixedHorizontalTrack, Empty, Empty)
                row(Obstacle, Obstacle, Obstacle, Empty, Empty)
                row(Empty, Empty, Empty, Empty, FixedHorizontalTrack)
                row(RightTunnel(GRAY, CarPosition(0, 0, RIGHT)), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, FixedHorizontalTrack)
            },
            cars = immutableArrayOf(
                Car(1, BLUE, CarPosition(4, 4, LEFT)),
                Car(2, BLUE, CarPosition(6, 4, LEFT)),
                Car(3, BLUE, CarPosition(2, 2, LEFT)),
            ),
            tracks = 12
        )
        val level2_3B = Level(
            name = "2-3B",
            board = buildBoard(rows = 7) {
                row(Empty, Empty, RightTunnel(GRAY, CarPosition(5, 6, LEFT)), Empty, Empty, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Obstacle, Empty, Empty, Obstacle, Empty)
                row(Empty, Empty, Obstacle, Empty, FixedHorizontalTrack, Obstacle, Empty)
                row(Empty, Empty, Obstacle, Empty, Empty, Obstacle, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, LeftTunnel(GRAY, CarPosition(0, 2, RIGHT)))
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, BLUE, CarPosition(4, 0, RIGHT)),
                Car(2, BLUE, CarPosition(6, 0, RIGHT)),
                Car(3, BLUE, CarPosition(2, 4, LEFT)),
            ),
            tracks = 15
        )
        val level2_4 = Level(
            name = "2-4",
            board = buildBoard(rows = 4) {
                row(Empty, Empty, Empty, Empty, DownTunnel(GRAY, CarPosition(2, 0, RIGHT)), Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 4, DOWN)), Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedHorizontalTrack, Empty, Empty, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, BLUE, CarPosition(1, 2, DOWN)),
                Car(2, BLUE, CarPosition(3, 2, RIGHT)),
            ),
            tracks = 7
        )
        val level2_4A = Level(
            name = "2-4A",
            board = buildBoard(rows = 6) {
                row(Empty, Empty, DownTunnel(GRAY, CarPosition(5, 1, RIGHT)), Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 2, DOWN)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, BLUE, CarPosition(1, 2, DOWN)),
                Car(2, BLUE, CarPosition(4, 2, UP)),
            ),
            tracks = 8
        )
        val level2_5 = Level(
            name = "2-5",
            board = buildBoard(rows = 5) {
                row(RightTunnel(BROWN, CarPosition(4, 4, UP)), Empty, Empty, Empty, DownTunnel(GRAY, CarPosition(4, 0, RIGHT)), Empty, Empty)
                row(Empty, FixedVerticalTrack, Empty, Empty, UpLeftDownFork(fixed = true), Empty, Empty)
                row(Empty, FixedVerticalTrack, FixedVerticalTrack, FixedVerticalTrack, Empty, Empty, EndingTrack)
                row(Empty, FixedVerticalTrack, Empty, Empty, DownRightUpFork(fixed = true), Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 4, DOWN)), Empty, Empty, Empty, UpTunnel(BROWN, CarPosition(0, 0, RIGHT)), Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, BLUE, CarPosition(2, 3, UP)),
                Car(2, BLUE, CarPosition(2, 2, DOWN)),
            ),
            tracks = 7
        )
        val level2_5A = Level(
            name = "2-5A",
            board = buildBoard(rows = 5) {
                row(FixedVerticalTrack, Empty, DownTunnel(GRAY, CarPosition(4, 2, UP)), Empty, FixedVerticalTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Obstacle, Empty, Empty, Empty, Obstacle)
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedVerticalTrack, Empty, UpTunnel(GRAY, CarPosition(0, 2, DOWN)), Empty, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, BLUE, CarPosition(4, 0, UP)),
                Car(2, BLUE, CarPosition(0, 4, DOWN)),
                Car(3, BLUE, CarPosition(0, 0, DOWN)),
            ),
            tracks = 12
        )
        val level2_5B = Level(
            name = "2-5B",
            board = buildBoard(rows = 5) {
                row(FixedVerticalTrack, Empty, DownTunnel(BROWN, CarPosition(4, 2, UP)), Empty, FixedVerticalTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(2, 4, LEFT)), Empty, Obstacle, Empty, LeftTunnel(GRAY, CarPosition(2, 0, RIGHT)))
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedVerticalTrack, Empty, UpTunnel(BROWN, CarPosition(0, 2, DOWN)), Empty, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, BLUE, CarPosition(4, 0, UP)),
                Car(2, BLUE, CarPosition(0, 4, DOWN)),
                Car(3, BLUE, CarPosition(0, 0, DOWN)),
            ),
            tracks = 12
        )
        val level2_6 = Level(
            name = "2-6",
            board = buildBoard(rows = 5) {
                row(FixedHorizontalTrack, Empty, LeftTunnel(BROWN, CarPosition(4, 5, UP)), Empty, Empty, DownTunnel(GRAY, CarPosition(4, 2, LEFT)), Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Obstacle, Obstacle, Empty, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, LeftTunnel(GRAY, CarPosition(0, 5, DOWN)), Empty, Empty, UpTunnel(BROWN, CarPosition(0, 2, LEFT)), Empty)
            },
            cars = immutableArrayOf(
                Car(1, BLUE, CarPosition(4, 0, RIGHT)),
                Car(2, BLUE, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 7
        )
        val level2_6A = Level(
            name = "2-6A",
            board = buildBoard(rows = 5) {
                row(RightTunnel(BROWN, CarPosition(4, 5, UP)), Empty, Empty, FixedHorizontalTrack, Empty, DownTunnel(GRAY, CarPosition(4, 0, RIGHT)), Empty)
                row(Empty, Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, Obstacle, Obstacle, Obstacle, Empty, DownRightUpFork(fixed = true), EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 5, DOWN)), Empty, Empty, FixedHorizontalTrack, Empty, UpTunnel(BROWN, CarPosition(0, 0, RIGHT)), Empty)
            },
            cars = immutableArrayOf(
                Car(1, BLUE, CarPosition(0, 3, LEFT)),
                Car(2, BLUE, CarPosition(4, 3, LEFT)),
            ),
            tracks = 8
        )
        val level2_7 = Level(
            name = "2-7",
            board = buildBoard(rows = 5) {
                row(Empty, DownTunnel(GRAY, CarPosition(4, 4, UP)), Empty, Empty, DownTunnel(BROWN, CarPosition(4, 1, UP)), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, FixedHorizontalTrack, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, UpTunnel(BROWN, CarPosition(0, 4, DOWN)), Empty, Empty, UpTunnel(GRAY, CarPosition(0, 1, DOWN)), Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, BLUE, CarPosition(2, 0, RIGHT)),
                Car(2, BLUE, CarPosition(2, 3, RIGHT)),
            ),
            tracks = 8
        )
        val level2_7A = Level(
            name = "2-7A",
            board = buildBoard(rows = 5) {
                row(Empty, DownTunnel(GRAY, CarPosition(4, 3, UP)), Empty, DownTunnel(PURPLE, CarPosition(4, 5, UP)), Empty, DownTunnel(BROWN, CarPosition(4, 1, UP)), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, FixedHorizontalTrack, Empty, FixedHorizontalTrack, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty, Empty, Empty)
                row(Empty, UpTunnel(BROWN, CarPosition(0, 5, DOWN)), Empty, UpTunnel(GRAY, CarPosition(0, 1, DOWN)), Empty, UpTunnel(PURPLE, CarPosition(0, 3, DOWN)), Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, BLUE, CarPosition(2, 0, RIGHT)),
                Car(2, BLUE, CarPosition(2, 2, RIGHT)),
                Car(3, BLUE, CarPosition(2, 4, RIGHT)),
            ),
            tracks = 11
        )
        val level2_7B = Level(
            name = "2-7B",
            board = buildBoard(rows = 5) {
                row(Empty, Empty, DownTunnel(BROWN, CarPosition(4, 4, UP)), Empty, DownTunnel(GRAY, CarPosition(4, 2, UP)), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, FixedHorizontalTrack, Empty, FixedHorizontalTrack, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, UpTunnel(GRAY, CarPosition(0, 4, DOWN)), Empty, UpTunnel(BROWN, CarPosition(0, 2, DOWN)), Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, BLUE, CarPosition(2, 0, RIGHT)),
                Car(2, BLUE, CarPosition(2, 2, RIGHT)),
                Car(3, BLUE, CarPosition(2, 4, RIGHT)),
            ),
            tracks = 14
        )
        val level2_8 = Level(
            name = "2-8",
            board = buildBoard(rows = 6) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, RightTunnel(GRAY, CarPosition(5, 0, RIGHT)), Empty, Empty, FixedHorizontalTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(1, 2, RIGHT)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, BLUE, CarPosition(1, 0, RIGHT)),
                Car(2, BLUE, CarPosition(3, 2, UP)),
                Car(3, BLUE, CarPosition(1, 5, LEFT)),
            ),
            tracks = 10
        )
        val level2_9 = Level(
            name = "2-9",
            board = buildBoard(rows = 8) {
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, DownTunnel(BROWN, CarPosition(7, 0, RIGHT)), Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(7, 4, LEFT)), Empty, Empty, FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(BROWN, CarPosition(0, 6, DOWN)), Empty, Empty, Empty, LeftTunnel(GRAY, CarPosition(3, 0, RIGHT)), Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, BLUE, CarPosition(3, 3, RIGHT)),
                Car(2, BLUE, CarPosition(5, 2, DOWN)),
                Car(3, BLUE, CarPosition(0, 4, DOWN)),
            ),
            tracks = 12
        )
        val levels = listOf(
            level2_1,
            level2_2,
            level2_3,
            level2_3A,
            level2_3B,
            level2_4,
            level2_4A,
            level2_5,
            level2_5A,
            level2_5B,
            level2_6,
            level2_6A,
            level2_7,
            level2_7A,
            level2_7B,
            level2_8,
            level2_9,
        ).associateBy { it.name }
    }

    object World3 {
        val level3_1 = Level(
            name = "3-1",
            board = buildBoard(rows = 4) {
                row(FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, false), Empty, Empty, Empty, HorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, VerticalBarrierSwitch(DARK_GREEN), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, RED, CarPosition(3, 3, UP)),
                Car(2, RED, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 4
        )
        val level3_2 = Level(
            name = "3-2",
            board = buildBoard(rows = 5) {
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(DARK_GREEN, false), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, HorizontalBarrierSwitch(DARK_GREEN), Empty, Empty, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, RED, CarPosition(0, 3, DOWN)),
                Car(2, RED, CarPosition(4, 0, RIGHT)),
            ),
            tracks = 9
        )
        val level3_3 = Level(
            name = "3-3",
            board = buildBoard(rows = 3) {
                row(Empty, HorizontalBarrier(DARK_GREEN, false), FixedHorizontalTrack, Empty, DownLeftRightFork(fixed = true), FixedHorizontalTrack)
                row(Empty, Empty, Empty, Empty, VerticalBarrierSwitch(DARK_GREEN), Empty)
                row(Empty, Empty, Empty, Empty, UpRightTurn(fixed = true), EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, RED, CarPosition(0, 5, LEFT)),
                Car(2, RED, CarPosition(0, 2, LEFT)),
            ),
            tracks = 8
        )
        val level3_3A = Level(
            name = "3-3A",
            board = buildBoard(rows = 5) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(DARK_GREEN, false), Empty, Empty)
                row(Empty, Empty, FixedHorizontalTrack, Empty, HorizontalBarrierSwitch(DARK_GREEN), EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, RED, CarPosition(4, 2, LEFT)),
                Car(2, RED, CarPosition(2, 3, UP)),
            ),
            tracks = 9
        )
        val level3_4 = Level(
            name = "3-4",
            board = buildBoard(rows = 5) {
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty, Empty, HorizontalBarrier(DARK_GREEN, false), DownLeftTurn())
                row(Empty, Empty, Empty, Empty, Empty, Empty, DownRightTurn(fixed = true), UpLeftTurn(fixed = true))
                row(Empty, HorizontalBarrierSwitch(DARK_GREEN,), Empty, Empty, HorizontalBarrierSwitch(DARK_GREEN), Empty, UpRightTurn(fixed = true), DownLeftTurn(fixed = true))
                row(Empty, Empty, Empty, Empty, Empty, Empty, DownRightTurn(fixed = true), UpLeftTurn(fixed = true))
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty, UpRightTurn(fixed = true), EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, RED, CarPosition(4, 0, UP)),
                Car(2, RED, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 12
        )
        val level3_5 = Level(
            name = "3-5",
            board = buildBoard(rows = 3) {
                row(FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, false), Empty, Empty, HorizontalBarrier(DARK_GREEN, true), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, HorizontalBarrierSwitch(DARK_GREEN), FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, true), Empty, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, RED, CarPosition(2, 3, LEFT)),
                Car(2, RED, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 9
        )
        val level3_6 = Level(
            name = "3-6",
            board = buildBoard(rows = 5) {
                row(Empty, Empty, FixedHorizontalTrack, HorizontalBarrierSwitch(DARK_GREEN), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, VerticalBarrier(DARK_GREEN, false), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, HorizontalBarrierSwitch(DARK_GREEN), HorizontalBarrier(DARK_GREEN, true), EndingTrack)
                row(Empty, Empty, Empty, Empty, VerticalBarrierSwitch(DARK_GREEN), Empty, Empty, Empty)
                row(Empty, Empty, FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, false), Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, RED, CarPosition(0, 2, RIGHT)),
                Car(2, RED, CarPosition(4, 2, RIGHT)),
            ),
            tracks = 7
        )
        val level3_7 = Level(
            name = "3-7",
            board = buildBoard(rows = 5) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, HorizontalBarrier(LIGHT_GREEN, false), HorizontalBarrierSwitch(DARK_GREEN), FixedHorizontalTrack)
                row(Empty, FixedHorizontalTrack, EndingTrack, FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack)
                row(Empty, Empty, HorizontalBarrier(DARK_GREEN, false), DownLeftRightBarrierSwitch(LIGHT_GREEN), Empty, FixedHorizontalTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, RED, CarPosition(3, 5, LEFT)),
                Car(2, RED, CarPosition(1, 5, LEFT)),
            ),
            tracks = 9
        )
        val level3_7A = Level(
            name = "3-7A",
            board = buildBoard(rows = 4) {
                row(Empty, Empty, HorizontalBarrier(LIGHT_GREEN, false), HorizontalBarrier(DARK_GREEN, true), EndingTrack)
                row(Empty, Empty, HorizontalBarrierSwitch(LIGHT_GREEN), Empty, FixedHorizontalTrack)
                row(Empty, Empty, HorizontalBarrierSwitch(DARK_GREEN), Empty, Empty)
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, RED, CarPosition(1, 4, LEFT)),
                Car(2, RED, CarPosition(3, 0, UP)),
            ),
            tracks = 9
        )
        val levels = listOf(
            level3_1,
            level3_2,
            level3_3,
            level3_3A,
            level3_4,
            level3_5,
            level3_6,
            level3_7,
            level3_7A,
        ).associateBy { it.name }
    }

    val levels = World1.levels +
            World2.levels +
            World3.levels
}
