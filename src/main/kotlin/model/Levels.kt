package model

import com.danrusu.pods4k.immutableArrays.immutableArrayOf
import model.Board.Companion.buildBoard
import model.Board.Companion.row
import model.CarColor.*
import model.Direction.*
import model.Tile.*
import model.TunnelColor.*

object Levels {
    object World1 {
        val level1_1 = Level(
            name = "1-1",
            board = buildBoard(rows = 1) {
                row(HorizontalTrack(fixed = true), Empty, Empty, Empty, EndingTrack)
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
                row(VerticalTrack(fixed = true), Obstacle, Empty, Empty, Empty, Obstacle)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(2, 0, UP)),
            ),
            tracks = 10
        )
        val level1_3 = Level(
            name = "1-3",
            board = buildBoard(rows = 3) {
                row(HorizontalTrack(fixed = true), DownLeftRightFork(), HorizontalTrack(fixed = true), Empty, EndingTrack)
                row(Empty, VerticalTrack(fixed = true), Empty, VerticalTrack(fixed = true), Empty)
                row(Empty, UpRightTurn(fixed = true), HorizontalTrack(fixed = true), UpLeftTurn(fixed = true), Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 1
        )
        val level1_4 = Level(
            name = "1-4",
            board = buildBoard(rows = 5) {
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, Empty)
                row(Empty, DownRightTurn(fixed = true), Empty, DownLeftTurn(fixed = true), Empty)
                row(HorizontalTrack(fixed = true), Empty, Obstacle, Empty, EndingTrack)
                row(Empty, UpRightTurn(fixed = true), Empty, UpLeftTurn(fixed = true), Empty)
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, Empty)
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
                row(Empty, Empty, Empty, HorizontalTrack(fixed = true))
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
                row(HorizontalTrack(fixed = true), Empty, Empty, Empty, EndingTrack)
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
                row(VerticalTrack(fixed = true), Empty, Empty)
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
                row(HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), DownRightLeftFork(), EndingTrack)
                row(Empty, Empty, Empty, Empty)
                row(HorizontalTrack(fixed = true), Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(2, 0, RIGHT)),
            ),
            tracks = 3
        )
        val level1_9 = Level(
            name = "1-9",
            board = buildBoard(rows = 3) {
                row(VerticalTrack(fixed = true), Obstacle, VerticalTrack(fixed = true), Empty, Empty)
                row(Empty, Obstacle, VerticalTrack(fixed = true), Empty, Empty)
                row(Empty, Empty, Empty, HorizontalTrack(fixed = true), EndingTrack)
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
                row(HorizontalTrack(fixed = true), Empty, Empty, Empty, Empty)
                row(Empty, DownRightTurn(fixed = true), Empty, DownLeftTurn(fixed = true), Empty)
                row(Empty, VerticalTrack(fixed = true), Obstacle, UpRightDownFork(), EndingTrack)
                row(Empty, UpRightTurn(fixed = true), Empty, UpLeftTurn(fixed = true), Empty)
                row(HorizontalTrack(fixed = true), Empty, Empty, Empty, Empty)
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
                row(Empty, HorizontalTrack(fixed = true), Empty, Empty)
                row(Empty, Obstacle, Empty, EndingTrack)
                row(Empty, HorizontalTrack(fixed = true), Empty, Empty)
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
                row(Empty, HorizontalTrack(fixed = true), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty)
                row(Empty, HorizontalTrack(fixed = true), Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty)
                row(Empty, HorizontalTrack(fixed = true), Empty, Empty, Empty, Empty)
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
                row(Empty, HorizontalTrack(fixed = true), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty)
                row(Empty, HorizontalTrack(fixed = true), Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty)
                row(Empty, HorizontalTrack(fixed = true), Empty, Empty, Empty, Empty)
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
                row(HorizontalTrack(fixed = true), Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, HorizontalTrack(fixed = true), Empty, Empty)
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
                row(HorizontalTrack(fixed = true), Empty, Empty, HorizontalTrack(fixed = true), EndingTrack)
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
                row(HorizontalTrack(fixed = true), Empty, Empty, Empty, HorizontalTrack(fixed = true))
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
                row(HorizontalTrack(fixed = true), Empty, Empty, Empty, HorizontalTrack(fixed = true))
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(HorizontalTrack(fixed = true), Empty, Empty, Empty, EndingTrack)
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
                row(Empty, HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), Empty, Empty, EndingTrack)
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
                row(Empty, HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), Empty, Empty, Empty, HorizontalTrack(fixed = true), EndingTrack)
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
                row(HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), Empty, Empty, HorizontalTrack(fixed = true), HorizontalTrack(fixed = true))
                row(Empty, Empty, UpLeftTurn(fixed = true), UpRightTurn(fixed = true), Empty, Empty)
                row(Empty, Empty, DownLeftTurn(fixed = true), DownRightTurn(fixed = true), Empty, Empty)
                row(HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), Empty, Empty, HorizontalTrack(fixed = true), EndingTrack)
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
                row(HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), Empty, Empty, Empty, HorizontalTrack(fixed = true), HorizontalTrack(fixed = true))
                row(Empty, Empty, UpLeftTurn(fixed = true), Empty, UpRightTurn(fixed = true), Empty, Empty)
                row(Empty, VerticalTrack(fixed = true), Empty, VerticalTrack(fixed = true), Empty, VerticalTrack(fixed = true), Empty)
                row(Empty, Empty, DownLeftTurn(fixed = true), Empty, DownRightTurn(fixed = true), Empty, Empty)
                row(HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), Empty, VerticalTrack(fixed = true), Empty, HorizontalTrack(fixed = true), EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(1, 6, LEFT)),
                Car(2, Red, CarPosition(5, 0, RIGHT)),
                Car(3, Red, CarPosition(1, 0, RIGHT)),
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
                row(HorizontalTrack(fixed = true), Empty, Empty, LeftTunnel(GRAY, CarPosition(0, 3, RIGHT)), Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(3, 0, RIGHT)),
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
                row(HorizontalTrack(fixed = true), Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(4, 0, RIGHT)),
            ),
            tracks = 6
        )
        val level2_3 = Level(
            name = "2-3",
            board = buildBoard(rows = 5) {
                row(RightTunnel(GRAY, CarPosition(3, 0, RIGHT)), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, HorizontalTrack(fixed = true))
                row(RightTunnel(GRAY, CarPosition(0, 0, RIGHT)), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, HorizontalTrack(fixed = true))
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(2, 4, LEFT)),
                Car(2, Red, CarPosition(4, 4, LEFT)),
            ),
            tracks = 6
        )
        val level2_3A = Level(
            name = "2-3A",
            board = buildBoard(rows = 7) {
                row(RightTunnel(GRAY, CarPosition(5, 0, RIGHT)), Empty, Empty, HorizontalTrack(fixed = true), EndingTrack)
                row(Obstacle, VerticalTrack(fixed = true), Empty, Empty, Empty)
                row(Obstacle, Empty, HorizontalTrack(fixed = true), Empty, Empty)
                row(Obstacle, Obstacle, Obstacle, Empty, Empty)
                row(Empty, Empty, Empty, Empty, HorizontalTrack(fixed = true))
                row(RightTunnel(GRAY, CarPosition(0, 0, RIGHT)), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, HorizontalTrack(fixed = true))
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(4, 4, LEFT)),
                Car(2, Red, CarPosition(6, 4, LEFT)),
                Car(3, Red, CarPosition(2, 2, LEFT)),
            ),
            tracks = 12
        )
        val level2_3B = Level(
            name = "2-3B",
            board = buildBoard(rows = 7) {
                row(Empty, Empty, RightTunnel(GRAY, CarPosition(5, 6, LEFT)), Empty, Empty, HorizontalTrack(fixed = true), EndingTrack)
                row(Empty, Empty, Obstacle, Empty, Empty, Obstacle, Empty)
                row(Empty, Empty, Obstacle, Empty, HorizontalTrack(fixed = true), Obstacle, Empty)
                row(Empty, Empty, Obstacle, Empty, Empty, Obstacle, Empty)
                row(HorizontalTrack(fixed = true), Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, LeftTunnel(GRAY, CarPosition(0, 2, RIGHT)))
                row(HorizontalTrack(fixed = true), Empty, Empty, Empty, Empty, Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(4, 0, RIGHT)),
                Car(2, Red, CarPosition(6, 0, RIGHT)),
                Car(3, Red, CarPosition(2, 4, LEFT)),
            ),
            tracks = 15
        )
        val level2_4 = Level(
            name = "2-4",
            board = buildBoard(rows = 4) {
                row(Empty, Empty, Empty, Empty, DownTunnel(GRAY, CarPosition(2, 0, RIGHT)), Empty)
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 4, DOWN)), Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, HorizontalTrack(fixed = true), Empty, Empty, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(1, 2, DOWN)),
                Car(2, Red, CarPosition(3, 2, RIGHT)),
            ),
            tracks = 7
        )
        val level2_4A = Level(
            name = "2-4A",
            board = buildBoard(rows = 6) {
                row(Empty, Empty, DownTunnel(GRAY, CarPosition(5, 1, RIGHT)), Empty, Empty)
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 2, DOWN)), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(1, 2, DOWN)),
                Car(2, Red, CarPosition(4, 2, UP)),
            ),
            tracks = 8
        )
        val level2_5 = Level(
            name = "2-5",
            board = buildBoard(rows = 5) {
                row(RightTunnel(BROWN, CarPosition(4, 4, UP)), Empty, Empty, Empty, DownTunnel(GRAY, CarPosition(4, 0, RIGHT)), Empty, Empty)
                row(Empty, VerticalTrack(fixed = true), Empty, Empty, UpLeftDownFork(fixed = true), Empty, Empty)
                row(Empty, VerticalTrack(fixed = true), VerticalTrack(fixed = true), VerticalTrack(fixed = true), Empty, Empty, EndingTrack)
                row(Empty, VerticalTrack(fixed = true), Empty, Empty, DownRightUpFork(fixed = true), Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 4, DOWN)), Empty, Empty, Empty, UpTunnel(BROWN, CarPosition(0, 0, RIGHT)), Empty, Empty)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(2, 3, UP)),
                Car(2, Red, CarPosition(2, 2, DOWN)),
            ),
            tracks = 7
        )
        val level2_5A = Level(
            name = "2-5A",
            board = buildBoard(rows = 5) {
                row(VerticalTrack(fixed = true), Empty, DownTunnel(GRAY, CarPosition(4, 2, UP)), Empty, VerticalTrack(fixed = true))
                row(Empty, Empty, Empty, Empty, Empty)
                row(Obstacle, Empty, Empty, Empty, Obstacle)
                row(Empty, Empty, Empty, Empty, Empty)
                row(VerticalTrack(fixed = true), Empty, UpTunnel(GRAY, CarPosition(0, 2, DOWN)), Empty, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(4, 0, UP)),
                Car(2, Red, CarPosition(0, 4, DOWN)),
                Car(3, Red, CarPosition(0, 0, DOWN)),
            ),
            tracks = 12
        )
        val level2_5B = Level(
            name = "2-5B",
            board = buildBoard(rows = 5) {
                row(VerticalTrack(fixed = true), Empty, DownTunnel(BROWN, CarPosition(4, 2, UP)), Empty, VerticalTrack(fixed = true))
                row(Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(2, 4, LEFT)), Empty, Obstacle, Empty, LeftTunnel(GRAY, CarPosition(2, 0, RIGHT)))
                row(Empty, Empty, Empty, Empty, Empty)
                row(VerticalTrack(fixed = true), Empty, UpTunnel(BROWN, CarPosition(0, 2, DOWN)), Empty, EndingTrack)
            },
            cars = immutableArrayOf(
                Car(1, Red, CarPosition(4, 0, UP)),
                Car(2, Red, CarPosition(0, 4, DOWN)),
                Car(3, Red, CarPosition(0, 0, DOWN)),
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
        ).associateBy { it.name }
    }
}
