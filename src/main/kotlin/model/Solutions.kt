package model

import model.Board.Companion.buildBoard
import model.Board.Companion.row
import model.Direction.LEFT
import model.Direction.RIGHT
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
        val level1_11B = setOf(
            buildBoard(rows = 7) {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(UpRightTurn, FixedHorizontalTrack, DownLeftTurn, VerticalTrack, Empty, Empty)
                row(Empty, Empty, VerticalTrack, VerticalTrack, Obstacle, Empty)
                row(DownRightTurn, FixedHorizontalTrack, UpLeftTurn, UpRightTurn, HorizontalTrack, EndingTrack)
                row(VerticalTrack, Empty, Empty, Empty, Obstacle, Empty)
                row(UpRightTurn, FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(DownRightTurn, FixedHorizontalTrack, DownLeftTurn, Empty, Empty, Empty)
                row(VerticalTrack, Empty, VerticalTrack, Empty, Obstacle, Empty)
                row(VerticalTrack, FixedHorizontalTrack, UpLeftDownFork, DownRightTurn, HorizontalTrack, EndingTrack)
                row(DownRightUpFork, HorizontalTrack, UpLeftTurn, VerticalTrack, Obstacle, Empty)
                row(UpRightTurn, FixedHorizontalTrack, HorizontalTrack, UpLeftTurn, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(DownRightTurn, FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(DownRightUpFork, HorizontalTrack, DownLeftTurn, Empty, Obstacle, Empty)
                row(VerticalTrack, FixedHorizontalTrack, UpLeftDownFork, DownRightTurn, HorizontalTrack, EndingTrack)
                row(DownRightUpFork, HorizontalTrack, UpLeftTurn, VerticalTrack, Obstacle, Empty)
                row(UpRightTurn, FixedHorizontalTrack, HorizontalTrack, UpLeftTurn, Empty, Empty)
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
        val level1_13A = setOf(
            buildBoard(rows = 6) {
                row(Empty, Empty, DownRightTurn, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, DownLeftUpFork, UpRightTurn, FixedHorizontalTrack)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(FixedHorizontalTrack, UpLeftTurn, UpRightTurn, HorizontalTrack, EndingTrack)
            },
            buildBoard(rows = 6) {
                row(Empty, Empty, DownRightTurn, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, DownLeftUpFork, UpRightTurn, FixedHorizontalTrack)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(Empty, VerticalTrack, UpRightTurn, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, UpLeftTurn, Empty, UpRightTurn, EndingTrack)
            },
            buildBoard(rows = 6) {
                row(Empty, Empty, DownRightTurn, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, DownLeftUpFork, UpRightTurn, FixedHorizontalTrack)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(Empty, VerticalTrack, UpRightTurn, DownLeftTurn, Empty)
                row(Empty, VerticalTrack, Empty, VerticalTrack, Empty)
                row(FixedHorizontalTrack, UpLeftTurn, Empty, UpRightTurn, EndingTrack)
            },
            buildBoard(rows = 6) {
                row(Empty, Empty, DownRightTurn, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, DownLeftUpFork, UpRightTurn, FixedHorizontalTrack)
                row(Empty, VerticalTrack, UpRightTurn, DownLeftTurn, Empty)
                row(Empty, VerticalTrack, Empty, VerticalTrack, Empty)
                row(Empty, VerticalTrack, Empty, VerticalTrack, Empty)
                row(FixedHorizontalTrack, UpLeftTurn, Empty, UpRightTurn, EndingTrack)
            },
        )
        val level1_14 = setOf(
            buildBoard(rows = 3) {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty)
                row(UpRightDownFork, FixedHorizontalTrack, FixedHorizontalTrack, DownLeftTurn, UpRightTurn, EndingTrack)
                row(UpRightTurn, HorizontalTrack, HorizontalTrack, UpLeftTurn, Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(DownRightUpFork, FixedHorizontalTrack, FixedHorizontalTrack, UpLeftTurn, DownRightTurn, EndingTrack)
                row(UpRightTurn, HorizontalTrack, HorizontalTrack, HorizontalTrack, UpLeftTurn, Empty)
            }
        )
        val level1_14A = setOf(
            buildBoard(rows = 3) {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, DownRightLeftFork, HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(UpRightDownFork, FixedHorizontalTrack, FixedHorizontalTrack, DownLeftUpFork, Empty, UpRightTurn, FixedHorizontalTrack, EndingTrack)
                row(UpRightTurn, HorizontalTrack, HorizontalTrack, UpLeftTurn, Empty, Empty, Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, DownRightLeftFork, DownLeftTurn, Empty, Empty, Empty)
                row(UpRightDownFork, FixedHorizontalTrack, FixedHorizontalTrack, DownLeftUpFork, UpRightTurn, HorizontalTrack, FixedHorizontalTrack, EndingTrack)
                row(UpRightTurn, HorizontalTrack, HorizontalTrack, UpLeftTurn, Empty, Empty, Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty, Empty, Empty, Empty)
                row(DownRightUpFork, FixedHorizontalTrack, FixedHorizontalTrack, UpLeftDownFork, Empty, DownRightTurn, FixedHorizontalTrack, EndingTrack)
                row(UpRightTurn, HorizontalTrack, HorizontalTrack, UpRightLeftFork, HorizontalTrack, UpLeftTurn, Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty, Empty, Empty, Empty)
                row(DownRightUpFork, FixedHorizontalTrack, FixedHorizontalTrack, UpLeftDownFork, DownRightTurn, HorizontalTrack, FixedHorizontalTrack, EndingTrack)
                row(UpRightTurn, HorizontalTrack, HorizontalTrack, UpRightLeftFork, UpLeftTurn, Empty, Empty, Empty)
            }
        )
        val level1_15 = setOf(
            buildBoard(rows = 4) {
                row(FixedHorizontalTrack, FixedHorizontalTrack, DownLeftTurn, DownRightTurn, FixedHorizontalTrack, FixedHorizontalTrack)
                row(Empty, DownRightTurn, FixedUpLeftTurn, FixedUpRightTurn, DownLeftTurn, Empty)
                row(Empty, UpRightTurn, FixedDownLeftTurn, FixedDownRightTurn, UpLeftTurn, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, UpRightLeftFork, UpRightLeftFork, FixedHorizontalTrack, EndingTrack)
            }
        )
        val level1_15A = setOf(
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, DownRightTurn, DownLeftTurn, Empty, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, DownLeftTurn, VerticalTrack, DownRightUpFork, FixedHorizontalTrack, FixedHorizontalTrack)
                row(Empty, DownRightTurn, FixedUpLeftTurn, VerticalTrack, FixedUpRightTurn, DownLeftTurn, Empty)
                row(Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty)
                row(Empty, UpRightTurn, FixedDownLeftTurn, VerticalTrack, FixedDownRightTurn, UpLeftTurn, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, DownLeftUpFork, FixedVerticalTrack, UpRightTurn, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, UpRightTurn, UpLeftTurn, Empty, Empty, Empty)
            }
        )
        val solutions = mapOf(
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
    object World2 {
        val level2_1 = setOf(
            buildBoard(rows = 4) {
                row(Empty, Empty, Empty, RightTunnel(TunnelColor.GRAY, CarPosition(3, 3, LEFT)), HorizontalTrack, HorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, LeftTunnel(TunnelColor.GRAY, CarPosition(0, 3, RIGHT)), Empty, Empty, Empty)
            },
        )
        val level2_2 = setOf(
            buildBoard(rows = 5) {
                row(Empty, Empty, Empty, DownRightTurn, EndingTrack)
                row(Empty, Empty, Empty, VerticalTrack, Empty)
                row(RightTunnel(TunnelColor.GRAY, CarPosition(2, 4, LEFT)), DownLeftTurn, Empty, UpRightTurn, LeftTunnel(TunnelColor.GRAY, CarPosition(2, 0, RIGHT)))
                row(Empty, VerticalTrack, Empty, Empty, Empty)
                row(FixedHorizontalTrack, UpLeftTurn, Empty, Empty, Empty)
            }
        )
        val solutions = mapOf(
            "2-1" to level2_1,
            "2-2" to level2_2,
        )
    }
}