package model

import kotlinx.collections.immutable.persistentListOf
import model.Board.Companion.buildBoard
import model.Board.Companion.row
import model.CarColor.BLUE
import model.CarColor.RED
import model.Color.DARK_GREEN
import model.Color.LIGHT_BLUE
import model.Color.LIGHT_GREEN
import model.Color.ORANGE
import model.Color.PINK
import model.Direction.DOWN
import model.Direction.LEFT
import model.Direction.RIGHT
import model.Direction.UP
import model.Tile.BaseHorizontalTrack.FixedHorizontalTrack
import model.Tile.BaseHorizontalTrack.HorizontalBarrier
import model.Tile.BaseHorizontalTrack.HorizontalStop
import model.Tile.BaseHorizontalTrack.HorizontalToggle
import model.Tile.BaseVerticalTrack.FixedVerticalTrack
import model.Tile.BaseVerticalTrack.VerticalBarrier
import model.Tile.BaseVerticalTrack.VerticalStop
import model.Tile.BaseVerticalTrack.VerticalToggle
import model.Tile.DownTunnel
import model.Tile.Empty
import model.Tile.EndingTrack
import model.Tile.Fork.BaseDownLeftRightFork.DownLeftRightSelfToggleableFork
import model.Tile.Fork.BaseDownLeftRightFork.DownLeftRightToggle
import model.Tile.Fork.BaseDownLeftRightFork.DownLeftRightToggleableFork
import model.Tile.Fork.BaseDownLeftRightFork.FixedDownLeftRightFork
import model.Tile.Fork.BaseDownLeftUpFork.DownLeftUpSelfToggleableFork
import model.Tile.Fork.BaseDownLeftUpFork.DownLeftUpToggle
import model.Tile.Fork.BaseDownLeftUpFork.DownLeftUpToggleableFork
import model.Tile.Fork.BaseDownLeftUpFork.FixedDownLeftUpFork
import model.Tile.Fork.BaseDownRightLeftFork.DownRightLeftSelfToggleableFork
import model.Tile.Fork.BaseDownRightLeftFork.DownRightLeftToggleableFork
import model.Tile.Fork.BaseDownRightLeftFork.FixedDownRightLeftFork
import model.Tile.Fork.BaseDownRightUpFork.DownRightUpSelfToggleableFork
import model.Tile.Fork.BaseDownRightUpFork.DownRightUpToggleableFork
import model.Tile.Fork.BaseDownRightUpFork.FixedDownRightUpFork
import model.Tile.Fork.BaseUpLeftDownFork.FixedUpLeftDownFork
import model.Tile.Fork.BaseUpLeftDownFork.UpLeftDownSelfToggleableFork
import model.Tile.Fork.BaseUpLeftDownFork.UpLeftDownToggleableFork
import model.Tile.Fork.BaseUpLeftRightFork.UpLeftRightSelfToggleableFork
import model.Tile.Fork.BaseUpLeftRightFork.UpLeftRightToggle
import model.Tile.Fork.BaseUpLeftRightFork.UpLeftRightToggleableFork
import model.Tile.Fork.BaseUpRightDownFork.FixedUpRightDownFork
import model.Tile.Fork.BaseUpRightDownFork.UpRightDownSelfToggleableFork
import model.Tile.Fork.BaseUpRightDownFork.UpRightDownToggleableFork
import model.Tile.Fork.BaseUpRightLeftFork.FixedUpRightLeftFork
import model.Tile.Fork.BaseUpRightLeftFork.UpRightLeftToggle
import model.Tile.Fork.BaseUpRightLeftFork.UpRightLeftToggleableFork
import model.Tile.LeftTunnel
import model.Tile.Obstacle
import model.Tile.Platform.DownPlatform
import model.Tile.Platform.LeftPlatform
import model.Tile.Platform.RightPlatform
import model.Tile.Platform.UpPlatform
import model.Tile.RightTunnel
import model.Tile.Turn.BaseDownLeftTurn.DownLeftToggle
import model.Tile.Turn.BaseDownLeftTurn.FixedDownLeftTurn
import model.Tile.Turn.BaseDownRightTurn.DownRightToggle
import model.Tile.Turn.BaseDownRightTurn.FixedDownRightTurn
import model.Tile.Turn.BaseUpLeftTurn.FixedUpLeftTurn
import model.Tile.Turn.BaseUpLeftTurn.UpLeftToggle
import model.Tile.Turn.BaseUpRightTurn.FixedUpRightTurn
import model.Tile.Turn.BaseUpRightTurn.UpRightBarrier
import model.Tile.Turn.BaseUpRightTurn.UpRightToggle
import model.Tile.UpTunnel
import model.TunnelColor.BEIGE
import model.TunnelColor.BROWN
import model.TunnelColor.GRAY
import model.TunnelColor.GREEN
import model.TunnelColor.LIGHT_GRAY
import model.TunnelColor.MINT
import model.TunnelColor.NAVY
import model.TunnelColor.PURPLE

object Levels {
    object World1 {
        val level1_1 = Level(
            name = "1-1",
            board = buildBoard(requireFixed = true) {
                row(FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 3
        )
        val level1_2 = Level(
            name = "1-2",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Obstacle, Empty, EndingTrack)
                row(Empty, Obstacle, Empty, Obstacle, Empty, Obstacle)
                row(FixedVerticalTrack, Obstacle, Empty, Empty, Empty, Obstacle)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 0, UP)),
            ),
            tracks = 10
        )
        val level1_3 = Level(
            name = "1-3",
            board = buildBoard(requireFixed = true) {
                row(FixedHorizontalTrack, FixedDownLeftRightFork, FixedHorizontalTrack, Empty, EndingTrack)
                row(Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty)
                row(Empty, FixedUpRightTurn, FixedHorizontalTrack, FixedUpLeftTurn, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 1
        )
        val level1_4 = Level(
            name = "1-4",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, FixedDownRightTurn, Empty, FixedDownLeftTurn, Empty)
                row(FixedHorizontalTrack, Empty, Obstacle, Empty, EndingTrack)
                row(Empty, FixedUpRightTurn, Empty, FixedUpLeftTurn, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 0, RIGHT)),
            ),
            tracks = 4
        )
        val level1_5 = Level(
            name = "1-5",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, EndingTrack)
                row(Empty, Obstacle, Obstacle, Obstacle)
                row(Empty, Empty, Empty, FixedHorizontalTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 3, LEFT)),
            ),
            tracks = 7
        )
        val level1_6 = Level(
            name = "1-6",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 0, RIGHT)),
            ),
            tracks = 3
        )
        val level1_7 = Level(
            name = "1-7",
            board = buildBoard(requireFixed = true) {
                row(FixedVerticalTrack, Empty, Empty)
                row(Empty, Obstacle, Empty)
                row(Empty, Empty, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 0, DOWN)),
            ),
            tracks = 3
        )
        val level1_8 = Level(
            name = "1-8",
            board = buildBoard(requireFixed = true) {
                row(FixedHorizontalTrack, FixedHorizontalTrack, FixedDownRightLeftFork, EndingTrack)
                row(Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 0, RIGHT)),
            ),
            tracks = 3
        )
        val level1_9 = Level(
            name = "1-9",
            board = buildBoard(requireFixed = true) {
                row(FixedVerticalTrack, Obstacle, FixedVerticalTrack, Empty, Empty)
                row(Empty, Obstacle, FixedVerticalTrack, Empty, Empty)
                row(Empty, Empty, Empty, FixedHorizontalTrack, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 2, DOWN)),
                Car(2, CarPosition(0, 0, DOWN)),
            ),
            tracks = 4
        )
        val level1_10 = Level(
            name = "1-10",
            board = buildBoard(requireFixed = true) {
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(Empty, FixedDownRightTurn, Empty, FixedDownLeftTurn, Empty)
                row(Empty, FixedVerticalTrack, Obstacle, FixedUpRightDownFork, EndingTrack)
                row(Empty, FixedUpRightTurn, Empty, FixedUpLeftTurn, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 0, RIGHT)),
                Car(2, CarPosition(4, 0, RIGHT)),
            ),
            tracks = 6
        )
        val level1_11 = Level(
            name = "1-11",
            board = buildBoard(requireFixed = true) {
                row(Empty, FixedHorizontalTrack, Empty, Empty)
                row(Empty, Obstacle, Empty, EndingTrack)
                row(Empty, FixedHorizontalTrack, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 1, RIGHT)),
                Car(2, CarPosition(2, 1, LEFT)),
            ),
            tracks = 5
        )
        val level1_11A = Level(
            name = "1-11A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 1, RIGHT)),
                Car(2, CarPosition(3, 1, RIGHT)),
                Car(3, CarPosition(5, 1, RIGHT)),
            ),
            tracks = 9
        )
        val level1_11B = Level(
            name = "1-11B",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 1, LEFT)),
                Car(2, CarPosition(3, 1, RIGHT)),
                Car(3, CarPosition(5, 1, LEFT)),
            ),
            tracks = 15
        )
        val level1_12 = Level(
            name = "1-12",
            board = buildBoard(requireFixed = true) {
                row(FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedHorizontalTrack, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 0, RIGHT)),
                Car(2, CarPosition(2, 2, RIGHT)),
            ),
            tracks = 6
        )
        val level1_12A = Level(
            name = "1-12A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 0, RIGHT)),
                Car(2, CarPosition(1, 3, LEFT)),
            ),
            tracks = 4
        )
        val level1_13 = Level(
            name = "1-13",
            board = buildBoard(requireFixed = true) {
                row(FixedHorizontalTrack, Empty, Empty, Empty, FixedHorizontalTrack)
                row(Empty, Empty, Obstacle, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Obstacle, Empty, Empty)
                row(Empty, Empty, Empty, Empty, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 0, RIGHT)),
                Car(2, CarPosition(0, 4, LEFT)),
            ),
            tracks = 11
        )
        val level1_13A = Level(
            name = "1-13A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, FixedHorizontalTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 0, RIGHT)),
                Car(2, CarPosition(1, 4, LEFT)),
                Car(3, CarPosition(5, 0, RIGHT)),
            ),
            tracks = 14
        )
        val level1_14 = Level(
            name = "1-14",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedHorizontalTrack, FixedHorizontalTrack, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 1, LEFT)),
                Car(2, CarPosition(1, 2, RIGHT)),
            ),
            tracks = 12
        )
        val level1_14A = Level(
            name = "1-14A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedHorizontalTrack, FixedHorizontalTrack, Empty, Empty, Empty, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 1, LEFT)),
                Car(2, CarPosition(1, 2, RIGHT)),
                Car(3, CarPosition(1, 6, LEFT)),
            ),
            tracks = 13
        )
        val level1_15 = Level(
            name = "1-15",
            board = buildBoard(requireFixed = true) {
                row(FixedHorizontalTrack, FixedHorizontalTrack, Empty, Empty, FixedHorizontalTrack, FixedHorizontalTrack)
                row(Empty, Empty, FixedUpLeftTurn, FixedUpRightTurn, Empty, Empty)
                row(Empty, Empty, FixedDownLeftTurn, FixedDownRightTurn, Empty, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, Empty, Empty, FixedHorizontalTrack, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(3, 0, RIGHT)),
                Car(2, CarPosition(0, 5, LEFT)),
                Car(3, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 8
        )
        val level1_15A = Level(
            name = "1-15A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, Empty, Empty, Empty, FixedHorizontalTrack, FixedHorizontalTrack)
                row(Empty, Empty, FixedUpLeftTurn, Empty, FixedUpRightTurn, Empty, Empty)
                row(Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty)
                row(Empty, Empty, FixedDownLeftTurn, Empty, FixedDownRightTurn, Empty, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, Empty, FixedVerticalTrack, Empty, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 6, LEFT)),
                Car(2, CarPosition(5, 0, RIGHT)),
                Car(3, CarPosition(1, 0, RIGHT)),
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
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, RightTunnel(GRAY, CarPosition(3, 3, LEFT)), Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, LeftTunnel(GRAY, CarPosition(0, 3, RIGHT)), Empty, Empty, Empty)
            },
            carColor = BLUE,
            cars = persistentListOf(
                Car(1, CarPosition(3, 0, RIGHT)),
            ),
            tracks = 4
        )
        val level2_2 = Level(
            name = "2-2",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(2, 4, LEFT)), Empty, Empty, Empty, LeftTunnel(GRAY, CarPosition(2, 0, RIGHT)))
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty)
            },
            carColor = BLUE,
            cars = persistentListOf(
                Car(1, CarPosition(4, 0, RIGHT)),
            ),
            tracks = 6
        )
        val level2_3 = Level(
            name = "2-3",
            board = buildBoard(requireFixed = true) {
                row(RightTunnel(GRAY, CarPosition(3, 0, RIGHT)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, FixedHorizontalTrack)
                row(RightTunnel(GRAY, CarPosition(0, 0, RIGHT)), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, FixedHorizontalTrack)
            },
            carColor = BLUE,
            cars = persistentListOf(
                Car(1, CarPosition(2, 4, LEFT)),
                Car(2, CarPosition(4, 4, LEFT)),
            ),
            tracks = 6
        )
        val level2_3A = Level(
            name = "2-3A",
            board = buildBoard(requireFixed = true) {
                row(RightTunnel(GRAY, CarPosition(5, 0, RIGHT)), Empty, Empty, FixedHorizontalTrack, EndingTrack)
                row(Obstacle, FixedVerticalTrack, Empty, Empty, Empty)
                row(Obstacle, Empty, FixedHorizontalTrack, Empty, Empty)
                row(Obstacle, Obstacle, Obstacle, Empty, Empty)
                row(Empty, Empty, Empty, Empty, FixedHorizontalTrack)
                row(RightTunnel(GRAY, CarPosition(0, 0, RIGHT)), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, FixedHorizontalTrack)
            },
            carColor = BLUE,
            cars = persistentListOf(
                Car(1, CarPosition(4, 4, LEFT)),
                Car(2, CarPosition(6, 4, LEFT)),
                Car(3, CarPosition(2, 2, LEFT)),
            ),
            tracks = 12
        )
        val level2_3B = Level(
            name = "2-3B",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, RightTunnel(GRAY, CarPosition(5, 6, LEFT)), Empty, Empty, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Obstacle, Empty, Empty, Obstacle, Empty)
                row(Empty, Empty, Obstacle, Empty, FixedHorizontalTrack, Obstacle, Empty)
                row(Empty, Empty, Obstacle, Empty, Empty, Obstacle, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, LeftTunnel(GRAY, CarPosition(0, 2, RIGHT)))
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty, Empty, Empty)
            },
            carColor = BLUE,
            cars = persistentListOf(
                Car(1, CarPosition(4, 0, RIGHT)),
                Car(2, CarPosition(6, 0, RIGHT)),
                Car(3, CarPosition(2, 4, LEFT)),
            ),
            tracks = 15
        )
        val level2_4 = Level(
            name = "2-4",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, DownTunnel(GRAY, CarPosition(2, 0, RIGHT)), Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 4, DOWN)), Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedHorizontalTrack, Empty, Empty, EndingTrack)
            },
            carColor = BLUE,
            cars = persistentListOf(
                Car(1, CarPosition(1, 2, DOWN)),
                Car(2, CarPosition(3, 2, RIGHT)),
            ),
            tracks = 7
        )
        val level2_4A = Level(
            name = "2-4A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, DownTunnel(GRAY, CarPosition(5, 1, RIGHT)), Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 2, DOWN)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            },
            carColor = BLUE,
            cars = persistentListOf(
                Car(1, CarPosition(1, 2, DOWN)),
                Car(2, CarPosition(4, 2, UP)),
            ),
            tracks = 8
        )
        val level2_5 = Level(
            name = "2-5",
            board = buildBoard(requireFixed = true) {
                row(RightTunnel(BROWN, CarPosition(4, 4, UP)), Empty, Empty, Empty, DownTunnel(GRAY, CarPosition(4, 0, RIGHT)), Empty, Empty)
                row(Empty, FixedVerticalTrack, Empty, Empty, FixedUpLeftDownFork, Empty, Empty)
                row(Empty, FixedVerticalTrack, FixedVerticalTrack, FixedVerticalTrack, Empty, Empty, EndingTrack)
                row(Empty, FixedVerticalTrack, Empty, Empty, FixedDownRightUpFork, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 4, DOWN)), Empty, Empty, Empty, UpTunnel(BROWN, CarPosition(0, 0, RIGHT)), Empty, Empty)
            },
            carColor = BLUE,
            cars = persistentListOf(
                Car(1, CarPosition(2, 3, UP)),
                Car(2, CarPosition(2, 2, DOWN)),
            ),
            tracks = 7
        )
        val level2_5A = Level(
            name = "2-5A",
            board = buildBoard(requireFixed = true) {
                row(FixedVerticalTrack, Empty, DownTunnel(GRAY, CarPosition(4, 2, UP)), Empty, FixedVerticalTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Obstacle, Empty, Empty, Empty, Obstacle)
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedVerticalTrack, Empty, UpTunnel(GRAY, CarPosition(0, 2, DOWN)), Empty, EndingTrack)
            },
            carColor = BLUE,
            cars = persistentListOf(
                Car(1, CarPosition(4, 0, UP)),
                Car(2, CarPosition(0, 4, DOWN)),
                Car(3, CarPosition(0, 0, DOWN)),
            ),
            tracks = 12
        )
        val level2_5B = Level(
            name = "2-5B",
            board = buildBoard(requireFixed = true) {
                row(FixedVerticalTrack, Empty, DownTunnel(BROWN, CarPosition(4, 2, UP)), Empty, FixedVerticalTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(2, 4, LEFT)), Empty, Obstacle, Empty, LeftTunnel(GRAY, CarPosition(2, 0, RIGHT)))
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedVerticalTrack, Empty, UpTunnel(BROWN, CarPosition(0, 2, DOWN)), Empty, EndingTrack)
            },
            carColor = BLUE,
            cars = persistentListOf(
                Car(1, CarPosition(4, 0, UP)),
                Car(2, CarPosition(0, 4, DOWN)),
                Car(3, CarPosition(0, 0, DOWN)),
            ),
            tracks = 12
        )
        val level2_6 = Level(
            name = "2-6",
            board = buildBoard(requireFixed = true) {
                row(FixedHorizontalTrack, Empty, LeftTunnel(BROWN, CarPosition(4, 5, UP)), Empty, Empty, DownTunnel(GRAY, CarPosition(4, 2, LEFT)), Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Obstacle, Obstacle, Empty, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, LeftTunnel(GRAY, CarPosition(0, 5, DOWN)), Empty, Empty, UpTunnel(BROWN, CarPosition(0, 2, LEFT)), Empty)
            },
            carColor = BLUE,
            cars = persistentListOf(
                Car(1, CarPosition(4, 0, RIGHT)),
                Car(2, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 7
        )
        val level2_6A = Level(
            name = "2-6A",
            board = buildBoard(requireFixed = true) {
                row(RightTunnel(BROWN, CarPosition(4, 5, UP)), Empty, Empty, FixedHorizontalTrack, Empty, DownTunnel(GRAY, CarPosition(4, 0, RIGHT)), Empty)
                row(Empty, Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, Obstacle, Obstacle, Obstacle, Empty, FixedDownRightUpFork, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 5, DOWN)), Empty, Empty, FixedHorizontalTrack, Empty, UpTunnel(BROWN, CarPosition(0, 0, RIGHT)), Empty)
            },
            carColor = BLUE,
            cars = persistentListOf(
                Car(1, CarPosition(0, 3, LEFT)),
                Car(2, CarPosition(4, 3, LEFT)),
            ),
            tracks = 8
        )
        val level2_7 = Level(
            name = "2-7",
            board = buildBoard(requireFixed = true) {
                row(Empty, DownTunnel(GRAY, CarPosition(4, 4, UP)), Empty, Empty, DownTunnel(BROWN, CarPosition(4, 1, UP)), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, FixedHorizontalTrack, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, UpTunnel(BROWN, CarPosition(0, 4, DOWN)), Empty, Empty, UpTunnel(GRAY, CarPosition(0, 1, DOWN)), Empty, Empty)
            },
            carColor = BLUE,
            cars = persistentListOf(
                Car(1, CarPosition(2, 0, RIGHT)),
                Car(2, CarPosition(2, 3, RIGHT)),
            ),
            tracks = 8
        )
        val level2_7A = Level(
            name = "2-7A",
            board = buildBoard(requireFixed = true) {
                row(Empty, DownTunnel(GRAY, CarPosition(4, 3, UP)), Empty, DownTunnel(PURPLE, CarPosition(4, 5, UP)), Empty, DownTunnel(BROWN, CarPosition(4, 1, UP)), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, FixedHorizontalTrack, Empty, FixedHorizontalTrack, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Obstacle, Empty, Empty, Empty)
                row(Empty, UpTunnel(BROWN, CarPosition(0, 5, DOWN)), Empty, UpTunnel(GRAY, CarPosition(0, 1, DOWN)), Empty, UpTunnel(PURPLE, CarPosition(0, 3, DOWN)), Empty, Empty)
            },
            carColor = BLUE,
            cars = persistentListOf(
                Car(1, CarPosition(2, 0, RIGHT)),
                Car(2, CarPosition(2, 2, RIGHT)),
                Car(3, CarPosition(2, 4, RIGHT)),
            ),
            tracks = 11
        )
        val level2_7B = Level(
            name = "2-7B",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, DownTunnel(BROWN, CarPosition(4, 4, UP)), Empty, DownTunnel(GRAY, CarPosition(4, 2, UP)), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, FixedHorizontalTrack, Empty, FixedHorizontalTrack, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, UpTunnel(GRAY, CarPosition(0, 4, DOWN)), Empty, UpTunnel(BROWN, CarPosition(0, 2, DOWN)), Empty, Empty, Empty)
            },
            carColor = BLUE,
            cars = persistentListOf(
                Car(1, CarPosition(2, 0, RIGHT)),
                Car(2, CarPosition(2, 2, RIGHT)),
                Car(3, CarPosition(2, 4, RIGHT)),
            ),
            tracks = 14
        )
        val level2_8 = Level(
            name = "2-8",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, RightTunnel(GRAY, CarPosition(5, 0, RIGHT)), Empty, Empty, FixedHorizontalTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(1, 2, RIGHT)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            },
            carColor = BLUE,
            cars = persistentListOf(
                Car(1, CarPosition(1, 0, RIGHT)),
                Car(2, CarPosition(3, 2, UP)),
                Car(3, CarPosition(1, 5, LEFT)),
            ),
            tracks = 10
        )
        val level2_9 = Level(
            name = "2-9",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, DownTunnel(BROWN, CarPosition(7, 0, RIGHT)), Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(7, 4, LEFT)), Empty, Empty, FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(BROWN, CarPosition(0, 6, DOWN)), Empty, Empty, Empty, LeftTunnel(GRAY, CarPosition(3, 0, RIGHT)), Empty, Empty, Empty)
            },
            carColor = BLUE,
            cars = persistentListOf(
                Car(1, CarPosition(3, 3, RIGHT)),
                Car(2, CarPosition(5, 2, DOWN)),
                Car(3, CarPosition(0, 4, DOWN)),
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
            board = buildBoard(requireFixed = true) {
                row(FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, false), Empty, Empty, Empty, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, VerticalToggle(DARK_GREEN), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(3, 3, UP)),
                Car(2, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 4
        )
        val level3_2 = Level(
            name = "3-2",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(DARK_GREEN, false), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, HorizontalToggle(DARK_GREEN), Empty, Empty, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 3, DOWN)),
                Car(2, CarPosition(4, 0, RIGHT)),
            ),
            tracks = 9
        )
        val level3_3 = Level(
            name = "3-3",
            board = buildBoard(requireFixed = true) {
                row(Empty, HorizontalBarrier(DARK_GREEN, false), FixedHorizontalTrack, Empty, FixedDownLeftRightFork, FixedHorizontalTrack)
                row(Empty, Empty, Empty, Empty, VerticalToggle(DARK_GREEN), Empty)
                row(Empty, Empty, Empty, Empty, FixedUpRightTurn, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 5, LEFT)),
                Car(2, CarPosition(0, 2, LEFT)),
            ),
            tracks = 8
        )
        val level3_3A = Level(
            name = "3-3A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(DARK_GREEN, false), Empty, Empty)
                row(Empty, Empty, FixedHorizontalTrack, Empty, HorizontalToggle(DARK_GREEN), EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(4, 2, LEFT)),
                Car(2, CarPosition(2, 3, UP)),
            ),
            tracks = 9
        )
        val level3_4 = Level(
            name = "3-4",
            board = buildBoard(requireFixed = true) {
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty, Empty, HorizontalBarrier(DARK_GREEN, false), FixedDownLeftTurn)
                row(Empty, Empty, Empty, Empty, Empty, Empty, FixedDownRightTurn, FixedUpLeftTurn)
                row(Empty, HorizontalToggle(DARK_GREEN), Empty, Empty, HorizontalToggle(DARK_GREEN), Empty, FixedUpRightTurn, FixedDownLeftTurn)
                row(Empty, Empty, Empty, Empty, Empty, Empty, FixedDownRightTurn, FixedUpLeftTurn)
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty, FixedUpRightTurn, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(4, 0, UP)),
                Car(2, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 12
        )
        val level3_5 = Level(
            name = "3-5",
            board = buildBoard(requireFixed = true) {
                row(FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, false), Empty, Empty, HorizontalBarrier(DARK_GREEN, true), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, true), Empty, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 3, LEFT)),
                Car(2, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 9
        )
        val level3_6 = Level(
            name = "3-6",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, FixedHorizontalTrack, HorizontalToggle(DARK_GREEN), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, VerticalBarrier(DARK_GREEN, false), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, HorizontalToggle(DARK_GREEN), HorizontalBarrier(DARK_GREEN, true), EndingTrack)
                row(Empty, Empty, Empty, Empty, VerticalToggle(DARK_GREEN), Empty, Empty, Empty)
                row(Empty, Empty, FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, false), Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 2, RIGHT)),
                Car(2, CarPosition(4, 2, RIGHT)),
            ),
            tracks = 7
        )
        val level3_7 = Level(
            name = "3-7",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, HorizontalBarrier(LIGHT_GREEN, false), HorizontalToggle(DARK_GREEN), FixedHorizontalTrack)
                row(Empty, FixedHorizontalTrack, EndingTrack, FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack)
                row(Empty, Empty, HorizontalBarrier(DARK_GREEN, false), DownLeftRightToggle(LIGHT_GREEN), Empty, FixedHorizontalTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(3, 5, LEFT)),
                Car(2, CarPosition(1, 5, LEFT)),
            ),
            tracks = 9
        )
        val level3_7A = Level(
            name = "3-7A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, HorizontalBarrier(LIGHT_GREEN, false), HorizontalBarrier(DARK_GREEN, true), EndingTrack)
                row(Empty, Empty, HorizontalToggle(LIGHT_GREEN), Empty, FixedHorizontalTrack)
                row(Empty, Empty, HorizontalToggle(DARK_GREEN), Empty, Empty)
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 4, LEFT)),
                Car(2, CarPosition(3, 0, UP)),
            ),
            tracks = 9
        )
        val level3_8 = Level(
            name = "3-8",
            board = buildBoard(requireFixed = true) {
                row(Empty, FixedVerticalTrack, Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, Empty, Empty, Empty, VerticalBarrier(DARK_GREEN, false), Empty)
                row(VerticalToggle(PINK), VerticalToggle(LIGHT_GREEN), VerticalToggle(DARK_GREEN), Empty, VerticalBarrier(LIGHT_GREEN, false), Empty)
                row(Empty, Empty, Empty, Empty, VerticalBarrier(PINK, false), Empty)
                row(Empty, Empty, Empty, Empty, FixedUpRightLeftFork, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 4, DOWN)),
                Car(2, CarPosition(0, 1, DOWN)),
            ),
            tracks = 12
        )
        val level3_8A = Level(
            name = "3-8A",
            board = buildBoard(requireFixed = true) {
                row(Empty, FixedHorizontalTrack, Empty, HorizontalBarrier(DARK_GREEN, false), HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrier(PINK, false), EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, HorizontalToggle(PINK), Empty, HorizontalToggle(LIGHT_GREEN), Empty, HorizontalToggle(DARK_GREEN), Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 1, LEFT)),
            ),
            tracks = 11
        )
        val level3_8B = Level(
            name = "3-8B",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, HorizontalToggle(DARK_GREEN), Empty, HorizontalToggle(Color.PURPLE), Empty, HorizontalToggle(DARK_GREEN), Empty, HorizontalToggle(Color.PURPLE), Empty, Empty)
                row(FixedHorizontalTrack, Empty, Obstacle, VerticalToggle(DARK_GREEN), Obstacle, VerticalToggle(LIGHT_GREEN), Obstacle, VerticalToggle(PINK), Obstacle, Empty, LeftTunnel(BROWN, CarPosition(4, 0, RIGHT)))
                row(Empty, Empty, HorizontalToggle(LIGHT_GREEN), Empty, HorizontalToggle(PINK), Empty, HorizontalToggle(LIGHT_GREEN), Empty, HorizontalToggle(PINK), Empty, Empty)
                row(Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle)
                row(RightTunnel(BROWN, CarPosition(1, 10, LEFT)), FixedHorizontalTrack, HorizontalBarrier(LIGHT_GREEN, false), HorizontalBarrier(DARK_GREEN, false), HorizontalBarrier(Color.PURPLE, false), HorizontalBarrier(LIGHT_GREEN, false), HorizontalBarrier(DARK_GREEN, false), HorizontalBarrier(Color.PURPLE, false), HorizontalBarrier(PINK, false), FixedHorizontalTrack, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(4, 1, RIGHT)),
                Car(2, CarPosition(1, 0, RIGHT)),
            ),
            tracks = 9
        )
        val level3_9 = Level(
            name = "3-9",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(PINK, false), Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, VerticalToggle(LIGHT_GREEN), Empty, VerticalToggle(DARK_GREEN), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, HorizontalBarrier(DARK_GREEN, false), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(LIGHT_GREEN, false), Empty, Empty, VerticalBarrier(DARK_GREEN, false), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, VerticalToggle(PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 0, RIGHT)),
                Car(2, CarPosition(4, 0, RIGHT)),
            ),
            tracks = 15
        )
        val level3_10 = Level(
            name = "3-10",
            board = buildBoard(requireFixed = true) {
                row(DownTunnel(BROWN, CarPosition(4, 3, RIGHT)), Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(VerticalToggle(DARK_GREEN), Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, HorizontalBarrier(DARK_GREEN, false), EndingTrack)
                row(Empty, Empty, Empty, RightTunnel(BROWN, CarPosition(0, 0, DOWN)), Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 4, DOWN)),
            ),
            tracks = 10
        )
        val level3_10A = Level(
            name = "3-10A",
            board = buildBoard(requireFixed = true) {
                row(Empty, DownTunnel(BROWN, CarPosition(4, 3, LEFT)), Empty, RightTunnel(GRAY, CarPosition(4, 1, RIGHT)), Empty, HorizontalToggle(DARK_GREEN), Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrier(DARK_GREEN, false), EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, RightTunnel(GRAY, CarPosition(0, 3, RIGHT)), HorizontalToggle(LIGHT_GREEN), LeftTunnel(BROWN, CarPosition(0, 1, DOWN)), Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 1, LEFT)),
            ),
            tracks = 10
        )
        val level3_10B = Level(
            name = "3-10B",
            board = buildBoard(requireFixed = true) {
                row(FixedVerticalTrack, Empty, Empty, DownTunnel(BROWN, CarPosition(5, 3, LEFT)), Empty, Empty, Empty)
                row(FixedUpRightTurn, HorizontalBarrier(DARK_GREEN, false), Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, FixedHorizontalTrack, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, LeftTunnel(BROWN, CarPosition(0, 3, DOWN)), Empty, Empty, Empty)
                row(Empty, UpRightToggle(DARK_GREEN), Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(3, 3, LEFT)),
                Car(2, CarPosition(0, 0, DOWN)),
            ),
            tracks = 10
        )
        val level3_10C = Level(
            name = "3-10C",
            board = buildBoard(requireFixed = true) {
                row(RightTunnel(GREEN, CarPosition(1, 4, DOWN)), Empty, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, HorizontalToggle(PINK), Empty, LeftTunnel(GRAY, CarPosition(6, 0, RIGHT)))
                row(Empty, Empty, Empty, Empty, DownTunnel(GREEN, CarPosition(0, 0, RIGHT)), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(BROWN, CarPosition(6, 8, LEFT)), FixedHorizontalTrack, Empty, Empty, Empty, HorizontalBarrier(DARK_GREEN, true), HorizontalBarrier(LIGHT_GREEN, false), HorizontalBarrier(PINK, true), EndingTrack)
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 8, LEFT)), Empty, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, HorizontalToggle(LIGHT_GREEN), FixedHorizontalTrack, HorizontalToggle(PINK), Empty, LeftTunnel(BROWN, CarPosition(3, 0, RIGHT)))
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(4, 4, UP)),
                Car(2, CarPosition(3, 1, RIGHT)),
            ),
            tracks = 13
        )
        val level3_11 = Level(
            name = "3-11",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, DownTunnel(BROWN, CarPosition(4, 4, UP)), Empty, DownTunnel(GRAY, CarPosition(4, 2, UP)), Empty, Empty)
                row(Empty, Empty, Empty, Empty, VerticalToggle(DARK_GREEN), Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, FixedDownRightUpFork, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, VerticalBarrier(DARK_GREEN, false), Empty, Empty)
                row(Empty, Empty, UpTunnel(GRAY, CarPosition(0, 4, DOWN)), Empty, UpTunnel(BROWN, CarPosition(0, 2, DOWN)), Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 0, RIGHT)),
            ),
            tracks = 7
        )
        val level3_11A = Level(
            name = "3-11A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, DownTunnel(BROWN, CarPosition(4, 4, UP)), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, HorizontalToggle(LIGHT_GREEN), Empty, Empty, HorizontalBarrier(LIGHT_GREEN, false), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, UpTunnel(BROWN, CarPosition(0, 4, DOWN)), Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 0, RIGHT)),
                Car(2, CarPosition(2, 6, LEFT)),
            ),
            tracks = 7
        )
        val level3_11B = Level(
            name = "3-11B",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, true), FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, false), FixedHorizontalTrack)
                row(Empty, Empty, HorizontalToggle(DARK_GREEN), Empty, Empty, Empty, Empty)
                row(RightTunnel(BROWN, CarPosition(4, 0, RIGHT)), Empty, Empty, Empty, Empty, Empty, Empty)
                row(Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle)
                row(RightTunnel(BROWN, CarPosition(2, 0, RIGHT)), HorizontalBarrier(DARK_GREEN, false), FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, true), Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, HorizontalToggle(DARK_GREEN), Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 2, LEFT)),
                Car(2, CarPosition(0, 6, LEFT)),
            ),
            tracks = 18
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
            level3_8,
            level3_8A,
            level3_8B,
            level3_9,
            level3_10,
            level3_10A,
            level3_10B,
            level3_10C,
            level3_11,
            level3_11A,
            level3_11B,
        ).associateBy { it.name }
    }

    object World4 {
        val level4_1 = Level(
            name = "4-1",
            board = buildBoard(requireFixed = true) {
                row(Empty, HorizontalToggle(Color.PURPLE), Empty, Empty, FixedHorizontalTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(DownRightUpToggleableFork(Color.PURPLE), FixedHorizontalTrack, EndingTrack, FixedHorizontalTrack, FixedHorizontalTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(4, 0, UP)),
                Car(2, CarPosition(0, 4, LEFT)),
            ),
            tracks = 5
        )
        val level4_2 = Level(
            name = "4-2",
            board = buildBoard(requireFixed = true) {
                row(FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Obstacle, Obstacle, VerticalToggle(Color.PURPLE), Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, Empty, UpRightLeftToggleableFork(Color.PURPLE), Empty, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 0, DOWN)),
                Car(2, CarPosition(0, 2, DOWN)),
            ),
            tracks = 8
        )
        val level4_3 = Level(
            name = "4-3",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, DownLeftUpToggleableFork(Color.PURPLE), Obstacle, UpRightDownToggleableFork(Color.PURPLE), EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, UpLeftToggle(Color.PURPLE), Empty, FixedUpLeftTurn, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 0, RIGHT)),
            ),
            tracks = 9
        )
        val level4_3A = Level(
            name = "4-3A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, HorizontalToggle(Color.PURPLE), Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, UpLeftDownToggleableFork(Color.PURPLE), FixedHorizontalTrack, Empty, VerticalToggle(Color.PURPLE), UpRightDownToggleableFork(Color.PURPLE), EndingTrack)
                row(Empty, Empty, HorizontalToggle(Color.PURPLE), Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 0, RIGHT)),
                Car(2, CarPosition(1, 2, RIGHT)),
            ),
            tracks = 9
        )
        val level4_3B = Level(
            name = "4-3B",
            board = buildBoard(requireFixed = true) {
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty)
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, VerticalToggle(Color.PURPLE), Empty, Empty, EndingTrack)
                row(Empty, Empty, UpLeftRightToggleableFork(Color.PURPLE), UpLeftRightToggleableFork(Color.PURPLE), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 0, DOWN)),
                Car(2, CarPosition(1, 0, DOWN)),
            ),
            tracks = 12
        )
        val level4_4 = Level(
            name = "4-4",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedVerticalTrack, DownRightToggle(Color.PURPLE), DownLeftToggle(Color.PURPLE), DownRightUpToggleableFork(Color.PURPLE), EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 0, UP)),
            ),
            tracks = 7
        )
        val level4_4A = Level(
            name = "4-4A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, FixedHorizontalTrack)
                row(Empty, Empty, FixedDownRightUpFork, FixedDownLeftTurn, Empty)
                row(Empty, DownLeftUpToggle(Color.PURPLE), VerticalToggle(Color.PURPLE), DownRightUpToggleableFork(Color.PURPLE), EndingTrack)
                row(Empty, Empty, FixedUpRightLeftFork, FixedUpLeftTurn, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 4, LEFT)),
                Car(2, CarPosition(4, 0, RIGHT)),
            ),
            tracks = 7
        )
        val level4_5 = Level(
            name = "4-5",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, VerticalToggle(Color.PURPLE), Empty, Empty)
                row(FixedHorizontalTrack, Empty, FixedHorizontalTrack, Empty, UpLeftRightToggleableFork(ORANGE), DownLeftRightToggleableFork(Color.PURPLE), EndingTrack)
                row(Empty, Empty, FixedDownRightTurn, Empty, Empty, UpLeftToggle(ORANGE), Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 2, RIGHT)),
                Car(2, CarPosition(2, 0, RIGHT)),
            ),
            tracks = 12
        )
        val level4_5A = Level(
            name = "4-5A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, DownRightToggle(ORANGE), Empty, Empty)
                row(Empty, FixedHorizontalTrack, Empty, UpLeftRightToggleableFork(ORANGE), DownLeftRightToggleableFork(Color.PURPLE), EndingTrack)
                row(Empty, Empty, Empty, Empty, UpRightToggle(Color.PURPLE), Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 1, RIGHT)),
                Car(2, CarPosition(4, 1, RIGHT)),
            ),
            tracks = 16
        )
        val level4_6 = Level(
            name = "4-6",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(VerticalToggle(Color.PURPLE), Empty, FixedVerticalTrack, Empty, HorizontalBarrier(Color.PURPLE, false), EndingTrack)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty)
                row(Empty, Empty, UpLeftRightToggleableFork(Color.PURPLE), Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 2, DOWN)),
                Car(2, CarPosition(0, 2, DOWN)),
            ),
            tracks = 12
        )
        val level4_6A = Level(
            name = "4-6A",
            board = buildBoard(requireFixed = true) {
                row(FixedDownRightTurn, FixedDownLeftTurn, Empty, Empty, Empty, HorizontalBarrier(Color.PURPLE, true), EndingTrack)
                row(UpRightDownToggleableFork(Color.PURPLE), UpLeftRightToggleableFork(Color.PURPLE), Empty, Empty, Empty, Empty, Empty)
                row(FixedVerticalTrack, Empty, Empty, UpRightLeftToggle(Color.PURPLE), Empty, FixedHorizontalTrack, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 5, LEFT)),
                Car(2, CarPosition(2, 0, UP)),
            ),
            tracks = 6
        )
        val level4_6B = Level(
            name = "4-6B",
            board = buildBoard(requireFixed = true) {
                row(Empty, FixedHorizontalTrack, HorizontalToggle(Color.PURPLE), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, HorizontalBarrier(Color.PURPLE, true), EndingTrack)
                row(Empty, Empty, FixedDownRightTurn, FixedDownLeftTurn, Empty, Empty, Empty)
                row(Empty, FixedHorizontalTrack, UpLeftRightToggleableFork(Color.PURPLE), UpRightLeftToggleableFork(Color.PURPLE), HorizontalToggle(Color.PURPLE), Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 1, RIGHT)),
                Car(2, CarPosition(4, 1, RIGHT)),
            ),
            tracks = 17
        )
        val level4_6C = Level(
            name = "4-6C",
            board = buildBoard(requireFixed = true) {
                row(Empty, FixedVerticalTrack, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedVerticalTrack, DownRightUpToggleableFork(Color.PURPLE), HorizontalBarrier(Color.PURPLE, false), EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, UpLeftRightToggleableFork(Color.PURPLE), Empty, HorizontalToggle(Color.PURPLE), Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 1, DOWN)),
                Car(2, CarPosition(2, 1, DOWN)),
            ),
            tracks = 10
        )
        val level4_7 = Level(
            name = "4-7",
            board = buildBoard(requireFixed = true) {
                row(FixedDownRightTurn, FixedHorizontalTrack, FixedDownRightLeftFork, FixedDownLeftTurn, Empty)
                row(DownRightUpToggleableFork(Color.PURPLE), HorizontalToggle(Color.PURPLE), FixedDownLeftUpFork, FixedVerticalTrack, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(Color.PURPLE, false), Empty)
                row(FixedVerticalTrack, Empty, FixedVerticalTrack, FixedUpRightTurn, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(4, 2, UP)),
                Car(2, CarPosition(4, 0, UP)),
            ),
            tracks = 6
        )
        val level4_7A = Level(
            name = "4-7A",
            board = buildBoard(requireFixed = true) {
                row(FixedHorizontalTrack, Empty, HorizontalToggle(Color.PURPLE), HorizontalBarrier(ORANGE, false), DownLeftToggle(Color.PURPLE), Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, VerticalToggle(ORANGE), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, UpRightLeftToggleableFork(ORANGE), HorizontalBarrier(Color.PURPLE, true), HorizontalToggle(ORANGE), Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 0, RIGHT)),
                Car(2, CarPosition(0, 7, DOWN)),
            ),
            tracks = 11
        )
        val level4_7B = Level(
            name = "4-7B",
            board = buildBoard(requireFixed = true) {
                row(Empty, FixedHorizontalTrack, HorizontalToggle(ORANGE), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, HorizontalBarrier(Color.PURPLE, false), EndingTrack)
                row(Empty, FixedDownRightTurn, FixedDownLeftTurn, Empty, Empty, Empty)
                row(FixedHorizontalTrack, FixedUpRightLeftFork, UpRightLeftToggleableFork(ORANGE), HorizontalToggle(Color.PURPLE), Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 1, RIGHT)),
                Car(2, CarPosition(4, 0, RIGHT)),
            ),
            tracks = 13
        )
        val level4_8 = Level(
            name = "4-8",
            buildBoard(requireFixed = true) {
                row(Empty, FixedVerticalTrack, Empty)
                row(Empty, Empty, Empty)
                row(VerticalToggle(Color.PURPLE), Obstacle, VerticalToggle(ORANGE))
                row(UpRightDownToggleableFork(ORANGE), Empty, UpLeftDownToggleableFork(Color.PURPLE))
                row(Empty, Empty, Empty)
                row(Empty, FixedVerticalTrack, Empty)
                row(Empty, UpRightBarrier(Color.PURPLE, false), EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 1, DOWN)),
                Car(2, CarPosition(5, 1, UP)),
            ),
            tracks = 7
        )
        val level4_8A = Level(
            name = "4-8A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, DownLeftRightToggleableFork(Color.PURPLE), Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, VerticalToggle(Color.PURPLE), VerticalToggle(ORANGE), Empty, Empty, Empty, Empty)
                row(Empty, Empty, UpLeftRightToggleableFork(ORANGE), FixedUpRightLeftFork, FixedHorizontalTrack, HorizontalBarrier(ORANGE, false), HorizontalBarrier(Color.PURPLE, false), EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 2, DOWN)),
                Car(2, CarPosition(6, 2, UP)),
                Car(3, CarPosition(2, 0, RIGHT)),
            ),
            tracks = 8
        )
        val level4_8B = Level(
            name = "4-8B",
            board = buildBoard(requireFixed = true) {
                row(RightTunnel(GRAY, CarPosition(3, 0, RIGHT)), Empty, Empty, Empty, DownTunnel(BEIGE, CarPosition(3, 7, LEFT)), Empty, Empty, Empty)
                row(Empty, VerticalToggle(Color.PURPLE), Empty, Empty, FixedUpRightTurn, HorizontalBarrier(ORANGE, false), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, HorizontalToggle(ORANGE), Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 0, RIGHT)), DownLeftUpToggleableFork(ORANGE), Empty, HorizontalToggle(Color.PURPLE), DownRightLeftToggleableFork(Color.PURPLE), UpLeftRightToggleableFork(ORANGE), FixedHorizontalTrack, LeftTunnel(BEIGE, CarPosition(0, 4, DOWN)))
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(5, 2, UP)),
                Car(2, CarPosition(5, 4, UP)),
            ),
            tracks = 12
        )
        val level4_9 = Level(
            name = "4-9",
            board = buildBoard(requireFixed = true) {
                row(Empty, FixedVerticalTrack, Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, VerticalBarrier(Color.PURPLE, false), Empty, Empty)
                row(Empty, DownRightLeftToggleableFork(Color.PURPLE), Empty, Empty, Empty, VerticalBarrier(ORANGE, false), Empty, Empty)
                row(VerticalToggle(Color.PURPLE), VerticalToggle(ORANGE), VerticalToggle(LIGHT_BLUE), Empty, Empty, VerticalBarrier(LIGHT_BLUE, false), Empty, Empty)
                row(Empty, UpLeftRightToggleableFork(LIGHT_BLUE), Empty, Empty, Empty, Empty, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 1, DOWN)),
                Car(2, CarPosition(0, 5, DOWN)),
                Car(3, CarPosition(6, 1, UP)),
            ),
            tracks = 11
        )
        val level4_9A = Level(
            name = "4-9A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, DownTunnel(BEIGE, CarPosition(4, 8, LEFT)), Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(4, 0, RIGHT)), Empty, DownLeftToggle(ORANGE), Empty, FixedUpRightTurn, FixedHorizontalTrack, HorizontalBarrier(ORANGE, false), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(1, 0, RIGHT)), Empty, UpLeftToggle(Color.PURPLE), Empty, HorizontalToggle(Color.PURPLE), Empty, Empty, DownRightLeftToggleableFork(Color.PURPLE), LeftTunnel(BEIGE, CarPosition(0, 4, DOWN)))
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(6, 3, UP)),
                Car(2, CarPosition(6, 5, UP)),
            ),
            tracks = 15
        )
        val level4_9B = Level(
            name = "4-9B",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, DownTunnel(BEIGE, CarPosition(4, 8, LEFT)), Empty, Empty, Empty, Empty)
                row(RightTunnel(MINT, CarPosition(7, 8, LEFT)), Empty, DownLeftToggle(ORANGE), Empty, FixedUpRightTurn, FixedHorizontalTrack, HorizontalBarrier(ORANGE, false), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Obstacle, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Obstacle, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(7, 0, RIGHT)), Empty, UpLeftToggle(Color.PURPLE), Empty, HorizontalToggle(Color.PURPLE), Empty, Empty, DownRightLeftToggleableFork(Color.PURPLE), LeftTunnel(BEIGE, CarPosition(0, 4, DOWN)))
                row(Empty, Empty, Empty, Empty, Obstacle, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(4, 0, RIGHT)), Empty, Empty, Empty, Empty, Empty, Empty, UpLeftRightToggleableFork(Color.PURPLE), LeftTunnel(MINT, CarPosition(1, 0, RIGHT)))
                row(Empty, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(8, 2, UP)),
                Car(2, CarPosition(8, 4, UP)),
            ),
            tracks = 18
        )

        val levels = listOf(
            level4_1,
            level4_2,
            level4_3,
            level4_3A,
            level4_3B,
            level4_4,
            level4_4A,
            level4_5,
            level4_5A,
            level4_6,
            level4_6A,
            level4_6B,
            level4_6C,
            level4_7,
            level4_7A,
            level4_7B,
            level4_8,
            level4_8A,
            level4_8B,
            level4_9,
            level4_9A,
            level4_9B,
        ).associateBy { it.name }
    }

    object World5 {
        val level5_1 = Level(
            name = "5-1",
            board = buildBoard(requireFixed = true) {
                row(Obstacle, Obstacle, DownPlatform(1, true), Obstacle, Obstacle)
                row(Empty, Empty, HorizontalStop(1), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(3, 0, RIGHT)),
            ),
            tracks = 6,
        )
        val level5_2 = Level(
            name = "5-2",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, EndingTrack)
                row(VerticalStop(1), LeftPlatform(1, true), Empty, Empty)
                row(FixedVerticalTrack, Empty, Empty, Empty)
                row(Empty, Empty, FixedHorizontalTrack, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 0, UP)),
                Car(2, CarPosition(3, 2, LEFT)),
            ),
            tracks = 5,
        )
        val level5_3 = Level(
            name = "5-3",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, FixedHorizontalTrack, Empty, Empty)
                row(Obstacle, Obstacle, DownPlatform(2, true), Empty, EndingTrack)
                row(FixedHorizontalTrack, Empty, HorizontalStop(2), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 0, RIGHT)),
                Car(2, CarPosition(3, 0, RIGHT)),
            ),
            tracks = 8,
        )
        val level5_3A = Level(
            name = "5-3A",
            board = buildBoard(requireFixed = true) {
                row(Empty, HorizontalStop(1), Empty, Empty, Empty, Empty, Empty)
                row(Empty, UpPlatform(1, true), Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedHorizontalTrack, Empty, FixedHorizontalTrack, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, FixedHorizontalTrack, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 1, LEFT)),
                Car(2, CarPosition(2, 3, RIGHT)),
            ),
            tracks = 14,
        )
        val level5_3B = Level(
            name = "5-3B",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, FixedHorizontalTrack, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedUpRightTurn, HorizontalStop(2), FixedHorizontalTrack, Empty)
                row(Obstacle, Obstacle, Obstacle, UpPlatform(2, true), Obstacle, Obstacle)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 3, LEFT)),
                Car(2, CarPosition(2, 0, RIGHT)),
                Car(3, CarPosition(4, 4, LEFT)),
            ),
            tracks = 11,
        )
        val level5_4 = Level(
            name = "5-4",
            board = buildBoard(requireFixed = true) {
                row(Empty, FixedHorizontalTrack, FixedHorizontalTrack, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, HorizontalStop(2), HorizontalStop(1), Empty, Empty)
                row(Empty, UpPlatform(2, true), UpPlatform(1, true), Empty, Empty)
                row(Empty, Empty, Empty, Empty, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 2, RIGHT)),
                Car(2, CarPosition(0, 1, RIGHT)),
            ),
            tracks = 9,
        )
        val level5_4A = Level(
            name = "5-4A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, DownPlatform(2, true), Empty, Empty)
                row(Empty, FixedHorizontalTrack, HorizontalStop(2), Empty, Empty)
                row(Empty, DownPlatform(1, true), Empty, Empty, EndingTrack)
                row(Empty, HorizontalStop(1), FixedHorizontalTrack, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(3, 2, LEFT)),
                Car(2, CarPosition(1, 1, RIGHT)),
            ),
            tracks = 8,
        )
        val level5_4B = Level(
            name = "5-4B",
            board = buildBoard(requireFixed = true) {
                row(Obstacle, Obstacle, DownPlatform(1, true), Obstacle, Obstacle)
                row(FixedVerticalTrack, Empty, HorizontalStop(1), Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack)
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack)
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty)
                row(FixedVerticalTrack, Empty, HorizontalStop(2), Empty, Empty)
                row(Obstacle, Obstacle, UpPlatform(2, true), Obstacle, Obstacle)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(6, 0, UP)),
                Car(2, CarPosition(1, 0, DOWN)),
                Car(3, CarPosition(4, 4, UP)),
            ),
            tracks = 18,
        )
        val level5_4C = Level(
            name = "5-4C",
            board = buildBoard(requireFixed = true) {
                row(Obstacle, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightPlatform(3, true), VerticalStop(3), Empty, Empty, FixedHorizontalTrack, Empty, Empty)
                row(Obstacle, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Obstacle, Empty, Empty, Empty, FixedHorizontalTrack, Empty, EndingTrack)
                row(Obstacle, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightPlatform(1, true), VerticalStop(1), Empty, Empty, FixedHorizontalTrack, Empty, Empty)
                row(Obstacle, Empty, Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 4, RIGHT)),
                Car(2, CarPosition(3, 4, LEFT)),
                Car(3, CarPosition(5, 4, RIGHT)),
            ),
            tracks = 26,
        )
        val level5_5 = Level(
            name = "5-5",
            board = buildBoard(requireFixed = true) {
                row(Obstacle, Obstacle, DownPlatform(2, true), Obstacle, Obstacle)
                row(Empty, FixedHorizontalTrack, HorizontalStop(2), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedHorizontalTrack, HorizontalStop(1), Empty, Empty)
                row(FixedVerticalTrack, Empty, UpPlatform(1, true), Empty, Empty)
                row(Empty, FixedHorizontalTrack, EndingTrack, FixedHorizontalTrack, FixedHorizontalTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 1, RIGHT)),
                Car(2, CarPosition(4, 0, UP)),
            ),
            tracks = 9,
        )
        val level5_5A = Level(
            name = "5-5A",
            board = buildBoard(requireFixed = true) {
                row(Obstacle, Obstacle, Obstacle, Obstacle, DownPlatform(2, true), Obstacle, Obstacle)
                row(Obstacle, Empty, FixedHorizontalTrack, Empty, HorizontalStop(2), Empty, Obstacle)
                row(Obstacle, Empty, Empty, Empty, Empty, VerticalStop(1), LeftPlatform(1, true))
                row(Obstacle, Empty, Empty, Empty, Empty, Empty, Obstacle)
                row(RightPlatform(2, true), VerticalStop(2), Empty, Empty, Empty, FixedHorizontalTrack, EndingTrack)
                row(Obstacle, Empty, HorizontalStop(1), Empty, Empty, FixedHorizontalTrack, Obstacle)
                row(Obstacle, Obstacle, UpPlatform(1, true), Obstacle, Obstacle, Obstacle, Obstacle)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 2, RIGHT)),
                Car(2, CarPosition(5, 5, LEFT)),
            ),
            tracks = 14,
        )
        val level5_5B = Level(
            name = "5-5B",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, DownPlatform(1, true), Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, HorizontalStop(1), Empty, Empty, Empty, VerticalStop(1), LeftPlatform(1, true), Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedHorizontalTrack, Empty, Empty, FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, RightPlatform(1, true), VerticalStop(1), Empty, Empty, Empty, HorizontalStop(1), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, UpPlatform(1, true), Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(3, 1, RIGHT)),
                Car(2, CarPosition(3, 4, RIGHT)),
            ),
            tracks = 26,
        )
        val level5_6 = Level(
            name = "5-6",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, DownTunnel(LIGHT_GRAY, CarPosition(5, 7, LEFT)), Empty, Empty, DownTunnel(GRAY, CarPosition(4, 1, RIGHT)), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, FixedUpRightTurn, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty)
                row(Empty, RightTunnel(GRAY, CarPosition(0, 5, DOWN)), Empty, Empty, HorizontalStop(1), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, UpPlatform(1, true), Empty, Empty, LeftTunnel(LIGHT_GRAY, CarPosition(0, 2, DOWN)))
                row(Empty, FixedHorizontalTrack, Empty, Empty, HorizontalStop(2), Empty, Obstacle, Empty)
                row(Obstacle, Obstacle, Obstacle, Obstacle, UpPlatform(2, true), Obstacle, Obstacle, Obstacle)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(3, 2, UP)),
                Car(2, CarPosition(6, 1, RIGHT)),
            ),
            tracks = 11,
        )
        val level5_6A = Level(
            name = "5-6A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, DownTunnel(LIGHT_GRAY, CarPosition(5, 7, LEFT)), Empty, Empty, DownTunnel(GRAY, CarPosition(4, 1, RIGHT)), Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, FixedHorizontalTrack, FixedUpLeftTurn, Empty, Empty, FixedUpRightTurn, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, RightTunnel(GRAY, CarPosition(0, 5, DOWN)), Empty, Empty, HorizontalStop(2), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, UpPlatform(2, true), Empty, Empty, LeftTunnel(LIGHT_GRAY, CarPosition(0, 2, DOWN)))
                row(Empty, FixedHorizontalTrack, Empty, Empty, HorizontalStop(1), Empty, Obstacle, Empty)
                row(Obstacle, Obstacle, Obstacle, Obstacle, UpPlatform(1, true), Obstacle, Obstacle, Obstacle)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(6, 1, RIGHT)),
                Car(2, CarPosition(2, 1, RIGHT)),
            ),
            tracks = 14,
        )
        val level5_6B = Level(
            name = "5-6B",
            board = buildBoard(requireFixed = true) {
                row(Obstacle, Obstacle, DownPlatform(1, true), Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle)
                row(RightTunnel(LIGHT_GRAY, CarPosition(3, 5, RIGHT)), Empty, HorizontalStop(1), Empty, Empty, RightTunnel(GRAY, CarPosition(3, 0, RIGHT)), FixedHorizontalTrack, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Obstacle, Empty, Empty, EndingTrack)
                row(RightTunnel(GRAY, CarPosition(1, 5, RIGHT)), Empty, HorizontalStop(2), Empty, Empty, RightTunnel(LIGHT_GRAY, CarPosition(1, 0, RIGHT)), FixedHorizontalTrack, Empty, Empty)
                row(Obstacle, Obstacle, UpPlatform(2, true), Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(3, 6, LEFT)),
                Car(2, CarPosition(1, 6, LEFT)),
            ),
            tracks = 11,
        )
        val level5_7 = Level(
            name = "5-7",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, DownLeftUpToggleableFork(LIGHT_BLUE), Empty, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, HorizontalToggle(LIGHT_BLUE), Empty, Empty, HorizontalStop(3), Empty)
                row(Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, UpPlatform(3, true), Obstacle)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 0, RIGHT)),
                Car(2, CarPosition(3, 0, RIGHT)),
                Car(3, CarPosition(1, 2, RIGHT)),
            ),
            tracks = 12,
        )
        val level5_7A = Level(
            name = "5-7A",
            board = buildBoard(requireFixed = true) {
                row(Empty, FixedHorizontalTrack, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, VerticalStop(2), LeftPlatform(2, true))
                row(Empty, Empty, Empty, FixedHorizontalTrack, Empty, UpRightDownToggleableFork(LIGHT_BLUE), EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, VerticalStop(1), LeftPlatform(1, true))
                row(Empty, FixedHorizontalTrack, Empty, Empty, UpLeftRightToggle(LIGHT_BLUE), Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 1, LEFT)),
                Car(2, CarPosition(4, 1, LEFT)),
                Car(3, CarPosition(2, 3, LEFT)),
            ),
            tracks = 18,
        )

        val level5_8 = Level(
            name = "5-8",
            board = buildBoard(requireFixed = true) {
                row(Empty, HorizontalStop(1), Empty, DownLeftRightToggleableFork(LIGHT_BLUE), Empty, Empty, Empty, Empty)
                row(VerticalToggle(LIGHT_BLUE), UpPlatform(1, true), Empty, Empty, Obstacle, Empty, VerticalToggle(LIGHT_BLUE), Empty)
                row(Empty, Empty, FixedHorizontalTrack, Empty, FixedHorizontalTrack, Empty, Empty, Empty)
                row(Empty, Empty, Obstacle, Empty, HorizontalBarrier(LIGHT_BLUE, false), FixedHorizontalTrack, EndingTrack, FixedHorizontalTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 2, LEFT)),
                Car(2, CarPosition(2, 4, RIGHT)),
            ),
            tracks = 16,
        )
        val level5_8A = Level(
            name = "5-8A",
            board = buildBoard(requireFixed = true) {
                row(Obstacle, Obstacle, DownPlatform(1, true), Obstacle, Obstacle)
                row(Empty, Empty, HorizontalStop(1), Empty, DownLeftToggle(PINK))
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, DownLeftUpToggleableFork(PINK), UpRightDownToggleableFork(LIGHT_BLUE), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, HorizontalStop(2), Empty, UpLeftToggle(LIGHT_BLUE))
                row(Obstacle, Obstacle, UpPlatform(2, true), Obstacle, Obstacle)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(3, 0, RIGHT)),
                Car(2, CarPosition(3, 3, LEFT)),
            ),
            tracks = 12,
        )

        val levels = listOf(
            level5_1,
            level5_2,
            level5_3,
            level5_3A,
            level5_3B,
            level5_4,
            level5_4A,
            level5_4B,
            level5_4C,
            level5_5,
            level5_5A,
            level5_5B,
            level5_6,
            level5_6A,
            level5_6B,
            level5_7,
            level5_7A,
            level5_8,
            level5_8A,
        ).associateBy { it.name }
    }

    object World6 {
        val level6_1 = Level(
            name = "6-1",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, FixedHorizontalTrack)
                row(Empty, UpLeftRightSelfToggleableFork, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 2, LEFT)),
            ),
            tracks = 3,
        )
        val level6_2 = Level(
            name = "6-2",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, FixedDownRightTurn, Empty, FixedDownLeftTurn, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, UpLeftDownSelfToggleableFork, Empty, FixedUpRightTurn, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 1, RIGHT)),
                Car(2, CarPosition(1, 0, RIGHT)),
            ),
            tracks = 4,
        )
        val level6_2A = Level(
            name = "6-2A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, DownLeftRightSelfToggleableFork, Empty)
                row(Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, Empty, Empty, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 0, RIGHT)),
                Car(2, CarPosition(4, 2, UP)),
                Car(3, CarPosition(0, 2, DOWN)),
            ),
            tracks = 8,
        )
        val level6_3 = Level(
            name = "6-3",
            board = buildBoard(requireFixed = true) {
                row(FixedHorizontalTrack, Empty, Empty, DownRightLeftSelfToggleableFork, Empty, Empty, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 0, RIGHT)),
                Car(2, CarPosition(3, 3, UP)),
            ),
            tracks = 8,
        )
        val level6_3A = Level(
            name = "6-3A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, Empty, Empty, Empty)
                row(Empty, UpRightDownSelfToggleableFork, Empty, Empty)
                row(Empty, Empty, DownLeftUpSelfToggleableFork, Empty)
                row(Empty, Empty, Empty, Empty)
                row(Empty, FixedVerticalTrack, FixedVerticalTrack, Empty)
                row(Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedHorizontalTrack, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(5, 2, UP)),
                Car(2, CarPosition(0, 2, DOWN)),
                Car(3, CarPosition(5, 1, UP)),
            ),
            tracks = 9,
        )
        val level6_3B = Level(
            name = "6-3B",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedHorizontalTrack, DownRightLeftSelfToggleableFork, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpLeftRightSelfToggleableFork, DownLeftRightSelfToggleableFork, FixedHorizontalTrack, EndingTrack)
                row(Empty, FixedHorizontalTrack, DownLeftUpSelfToggleableFork, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 1, RIGHT)),
                Car(2, CarPosition(3, 1, RIGHT)),
                Car(3, CarPosition(2, 5, LEFT)),
            ),
            tracks = 9,
        )
        val level6_4 = Level(
            name = "6-4",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, DownRightLeftSelfToggleableFork, DownLeftUpSelfToggleableFork, Empty, Empty)
                row(Empty, Empty, DownRightUpSelfToggleableFork, UpLeftRightSelfToggleableFork, Empty, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 1, RIGHT)),
                Car(2, CarPosition(1, 0, RIGHT)),
            ),
            tracks = 9,
        )
        val level6_4A = Level(
            name = "6-4A",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, FixedVerticalTrack, Empty, EndingTrack)
                row(FixedVerticalTrack, Empty, DownLeftUpSelfToggleableFork, Empty, Empty)
                row(FixedVerticalTrack, Empty, UpRightDownSelfToggleableFork, Empty, FixedVerticalTrack)
                row(Empty, Empty, DownLeftUpSelfToggleableFork, Empty, FixedVerticalTrack)
                row(Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 0, UP)),
                Car(2, CarPosition(2, 4, DOWN)),
            ),
            tracks = 11,
        )
        val level6_5 = Level(
            name = "6-5",
            board = buildBoard(requireFixed = true) {
                row(FixedHorizontalTrack, Empty, Empty, Empty, DownTunnel(NAVY, CarPosition(5, 0, RIGHT)))
                row(Empty, Empty, UpLeftDownSelfToggleableFork, Empty, FixedVerticalTrack)
                row(FixedHorizontalTrack, Empty, DownRightUpSelfToggleableFork, Empty, Empty)
                row(Empty, Empty, UpLeftRightSelfToggleableFork, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(NAVY, CarPosition(0, 4, DOWN)), FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack, FixedHorizontalTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(2, 0, RIGHT)),
                Car(2, CarPosition(0, 0, RIGHT)),
                Car(3, CarPosition(1, 4, DOWN)),
            ),
            tracks = 8,
        )
        val level6_6 = Level(
            name = "6-6",
            board = buildBoard(requireFixed = true) {
                row(Empty, FixedHorizontalTrack, FixedHorizontalTrack, Empty)
                row(UpRightDownSelfToggleableFork, Empty, Empty, Empty)
                row(FixedVerticalTrack, Empty, VerticalToggle(Color.PURPLE), Empty)
                row(UpRightDownSelfToggleableFork, Empty, Empty, Empty)
                row(Empty, Empty, HorizontalBarrier(Color.PURPLE, false), EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 2, LEFT)),
                Car(2, CarPosition(0, 1, LEFT)),
            ),
            tracks = 7,
        )
        val level6_7 = Level(
            name = "6-7",
            board = buildBoard(requireFixed = true) {
                row(FixedVerticalTrack, DownRightToggle(Color.PURPLE), Empty, Empty)
                row(Empty, Empty, VerticalBarrier(PINK, false), Empty)
                row(Empty, Obstacle, Empty, Empty)
                row(UpRightDownSelfToggleableFork, Empty, DownLeftUpSelfToggleableFork, Empty)
                row(Empty, Empty, VerticalToggle(PINK), Empty)
                row(Empty, Empty, VerticalBarrier(Color.PURPLE, false), Empty)
                row(FixedVerticalTrack, Empty, FixedUpRightTurn, EndingTrack)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(0, 0, DOWN)),
                Car(2, CarPosition(6, 0, UP)),
            ),
            tracks = 10,
        )
        val level6_8 = Level(
            name = "6-8",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, RightTunnel(NAVY, CarPosition(4, 2, LEFT)), FixedHorizontalTrack, HorizontalBarrier(Color.PURPLE, false), Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, UpLeftDownSelfToggleableFork, Empty, HorizontalToggle(Color.PURPLE), EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, LeftTunnel(NAVY, CarPosition(0, 2, RIGHT)), Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(1, 0, RIGHT)),
                Car(2, CarPosition(4, 0, RIGHT)),
            ),
            tracks = 10,
        )
        val level6_9 = Level(
            name = "6-9",
            board = buildBoard(requireFixed = true) {
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, HorizontalToggle(Color.PURPLE), Empty, DownLeftRightToggleableFork(PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, HorizontalBarrier(PINK, false), DownLeftRightSelfToggleableFork, EndingTrack)
                row(Empty, HorizontalToggle(PINK), Empty, UpLeftRightToggleableFork(Color.PURPLE), Empty, Empty, Empty)
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(4, 0, UP)),
                Car(2, CarPosition(0, 0, DOWN)),
            ),
            tracks = 11,
        )
        val level6_10 = Level(
            name = "6-10",
            board = buildBoard(requireFixed = true) {
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, UpLeftToggle(Color.PURPLE), DownPlatform(1, true), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, HorizontalStop(1), Empty, Empty, Empty)
                row(FixedHorizontalTrack, Empty, Empty, Empty, Empty, UpRightDownSelfToggleableFork, HorizontalBarrier(Color.PURPLE, false), EndingTrack)
                row(Empty, Empty, Empty, HorizontalStop(2), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpPlatform(2, true), Empty, Empty, Empty, Empty)
            },
            carColor = RED,
            cars = persistentListOf(
                Car(1, CarPosition(3, 0, RIGHT)),
                Car(2, CarPosition(1, 0, RIGHT)),
            ),
            tracks = 13,
        )

        val levels = listOf(
            level6_1,
            level6_2,
            level6_2A,
            level6_3,
            level6_3A,
            level6_3B,
            level6_4,
            level6_4A,
            level6_5,
            level6_6,
            level6_7,
            level6_8,
            level6_9,
            level6_10,
        ).associateBy { it.name }
    }

    val levels = World1.levels +
            World2.levels +
            World3.levels +
            World4.levels +
            World5.levels +
            World6.levels
}
