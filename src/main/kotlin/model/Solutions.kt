package model

import model.BarrierColor.DARK_GREEN
import model.BarrierColor.LIGHT_GREEN
import model.BarrierColor.PINK
import model.Board.Companion.buildBoard
import model.Board.Companion.row
import model.Direction.DOWN
import model.Direction.LEFT
import model.Direction.RIGHT
import model.Direction.UP
import model.Tile.*
import model.Tile.BaseHorizontalTrack.*
import model.Tile.BaseVerticalTrack.*
import model.TunnelColor.*

object Solutions {
    object World1 {
        val level1_1 = setOf(
            buildBoard(rows = 1) {
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack)
            }
        )
        val level1_2 = setOf(
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalTrack, DownLeftTurn(), Obstacle, DownRightTurn(), EndingTrack)
                row(VerticalTrack, Obstacle, VerticalTrack, Obstacle, VerticalTrack, Obstacle)
                row(FixedVerticalTrack, Obstacle, UpRightTurn(), HorizontalTrack, UpLeftTurn(), Obstacle)
            }
        )
        val level1_3 = setOf(
            buildBoard(rows = 3) {
                row(FixedHorizontalTrack, DownLeftRightFork(), FixedHorizontalTrack, DownRightTurn(), EndingTrack)
                row(Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty)
                row(Empty, UpRightTurn(fixed = true), FixedHorizontalTrack, UpLeftTurn(fixed = true), Empty)
            }
        )
        val level1_4 = setOf(
            buildBoard(rows = 5) {
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, DownRightTurn(fixed = true), Empty, DownLeftTurn(fixed = true), Empty)
                row(FixedHorizontalTrack, DownLeftTurn(), Obstacle, DownRightTurn(), EndingTrack)
                row(Empty, UpRightTurn(fixed = true), HorizontalTrack, UpLeftTurn(fixed = true), Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
            },
            buildBoard(rows = 5) {
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, DownRightTurn(fixed = true), HorizontalTrack, DownLeftTurn(fixed = true), Empty)
                row(FixedHorizontalTrack, UpLeftTurn(), Obstacle, UpRightTurn(), EndingTrack)
                row(Empty, UpRightTurn(fixed = true), Empty, UpLeftTurn(fixed = true), Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
            }
        )
        val level1_5 = setOf(
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalTrack, HorizontalTrack, EndingTrack)
                row(VerticalTrack, Obstacle, Obstacle, Obstacle)
                row(UpRightTurn(), HorizontalTrack, HorizontalTrack, FixedHorizontalTrack)
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
                row(UpRightTurn(), HorizontalTrack, EndingTrack)
            }
        )
        val level1_8 = setOf(
            buildBoard(rows = 3) {
                row(FixedHorizontalTrack, FixedHorizontalTrack, DownRightLeftFork(), EndingTrack)
                row(Empty, DownRightTurn(), UpLeftTurn(), Empty)
                row(FixedHorizontalTrack, UpLeftTurn(), Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(FixedHorizontalTrack, FixedHorizontalTrack, DownRightLeftFork(), EndingTrack)
                row(Empty, Empty, VerticalTrack, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, UpLeftTurn(), Empty)
            }
        )
        val level1_9 = setOf(
            buildBoard(rows = 3) {
                row(FixedVerticalTrack, Obstacle, FixedVerticalTrack, Empty, Empty)
                row(VerticalTrack, Obstacle, FixedVerticalTrack, Empty, Empty)
                row(UpRightTurn(), HorizontalTrack, UpRightLeftFork(), FixedHorizontalTrack, EndingTrack)
            }
        )
        val level1_10 = setOf(
            buildBoard(rows = 5) {
                row(FixedHorizontalTrack, HorizontalTrack, DownLeftTurn(), Empty, Empty)
                row(Empty, DownRightTurn(fixed = true), UpRightLeftFork(), DownLeftTurn(fixed = true), Empty)
                row(Empty, FixedVerticalTrack, Obstacle, UpRightDownFork(), EndingTrack)
                row(Empty, UpRightTurn(fixed = true), DownLeftTurn(), UpLeftTurn(fixed = true), Empty)
                row(FixedHorizontalTrack, HorizontalTrack, UpLeftTurn(), Empty, Empty)
            }
        )
        val level1_11 = setOf(
            buildBoard(rows = 3) {
                row(DownRightTurn(), FixedHorizontalTrack, DownLeftTurn(), Empty)
                row(VerticalTrack, Obstacle, UpRightTurn(), EndingTrack)
                row(UpRightTurn(), FixedHorizontalTrack, Empty, Empty)
            }
        )
        val level1_11A = setOf(
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedHorizontalTrack, DownRightLeftFork(), DownLeftTurn(), Empty, Empty)
                row(Empty, Empty, VerticalTrack, VerticalTrack, Obstacle, Empty)
                row(Empty, FixedHorizontalTrack, UpLeftDownFork(), UpRightTurn(), HorizontalTrack, EndingTrack)
                row(Empty, Empty, VerticalTrack, Empty, Obstacle, Empty)
                row(Empty, FixedHorizontalTrack, UpLeftTurn(), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level1_11B = setOf(
            buildBoard(rows = 7) {
                row(DownRightTurn(), HorizontalTrack, HorizontalTrack, DownLeftTurn(), Empty, Empty)
                row(UpRightTurn(), FixedHorizontalTrack, DownLeftTurn(), VerticalTrack, Empty, Empty)
                row(Empty, Empty, VerticalTrack, VerticalTrack, Obstacle, Empty)
                row(DownRightTurn(), FixedHorizontalTrack, UpLeftTurn(), UpRightTurn(), HorizontalTrack, EndingTrack)
                row(VerticalTrack, Empty, Empty, Empty, Obstacle, Empty)
                row(UpRightTurn(), FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(DownRightTurn(), FixedHorizontalTrack, DownLeftTurn(), Empty, Empty, Empty)
                row(VerticalTrack, Empty, VerticalTrack, Empty, Obstacle, Empty)
                row(VerticalTrack, FixedHorizontalTrack, UpLeftDownFork(), DownRightTurn(), HorizontalTrack, EndingTrack)
                row(DownRightUpFork(), HorizontalTrack, UpLeftTurn(), VerticalTrack, Obstacle, Empty)
                row(UpRightTurn(), FixedHorizontalTrack, HorizontalTrack, UpLeftTurn(), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(DownRightTurn(), FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(DownRightUpFork(), HorizontalTrack, DownLeftTurn(), Empty, Obstacle, Empty)
                row(VerticalTrack, FixedHorizontalTrack, UpLeftDownFork(), DownRightTurn(), HorizontalTrack, EndingTrack)
                row(DownRightUpFork(), HorizontalTrack, UpLeftTurn(), VerticalTrack, Obstacle, Empty)
                row(UpRightTurn(), FixedHorizontalTrack, HorizontalTrack, UpLeftTurn(), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level1_12 = setOf(
            buildBoard(rows = 3) {
                row(FixedHorizontalTrack, HorizontalTrack, DownRightLeftFork(), HorizontalTrack, EndingTrack)
                row(Empty, Empty, UpRightTurn(), DownLeftTurn(), Empty)
                row(Empty, Empty, FixedHorizontalTrack, UpLeftTurn(), Empty)
            },
        )
        val level1_12A = setOf(
            buildBoard(rows = 3) {
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork(), DownRightLeftFork(), FixedHorizontalTrack, EndingTrack)
                row(Empty, UpRightTurn(), UpLeftTurn(), Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(Empty, DownRightTurn(), DownLeftTurn(), Empty, Empty)
                row(FixedHorizontalTrack, UpRightLeftFork(), UpRightLeftFork(), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level1_13 = setOf(
            buildBoard(rows = 5) {
                row(FixedHorizontalTrack, DownLeftTurn(), Empty, DownRightTurn(), FixedHorizontalTrack)
                row(Empty, VerticalTrack, Obstacle, VerticalTrack, Empty)
                row(Empty, DownRightUpFork(), HorizontalTrack, UpLeftTurn(), Empty)
                row(Empty, VerticalTrack, Obstacle, Empty, Empty)
                row(Empty, UpRightTurn(), HorizontalTrack, HorizontalTrack, EndingTrack)
            }
        )
        val level1_13A = setOf(
            buildBoard(rows = 6) {
                row(Empty, Empty, DownRightTurn(), DownLeftTurn(), Empty)
                row(FixedHorizontalTrack, DownRightLeftFork(), DownLeftUpFork(), UpRightTurn(), FixedHorizontalTrack)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(FixedHorizontalTrack, UpLeftTurn(), UpRightTurn(), HorizontalTrack, EndingTrack)
            },
            buildBoard(rows = 6) {
                row(Empty, Empty, DownRightTurn(), DownLeftTurn(), Empty)
                row(FixedHorizontalTrack, DownRightLeftFork(), DownLeftUpFork(), UpRightTurn(), FixedHorizontalTrack)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(Empty, VerticalTrack, UpRightTurn(), DownLeftTurn(), Empty)
                row(FixedHorizontalTrack, UpLeftTurn(), Empty, UpRightTurn(), EndingTrack)
            },
            buildBoard(rows = 6) {
                row(Empty, Empty, DownRightTurn(), DownLeftTurn(), Empty)
                row(FixedHorizontalTrack, DownRightLeftFork(), DownLeftUpFork(), UpRightTurn(), FixedHorizontalTrack)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(Empty, VerticalTrack, UpRightTurn(), DownLeftTurn(), Empty)
                row(Empty, VerticalTrack, Empty, VerticalTrack, Empty)
                row(FixedHorizontalTrack, UpLeftTurn(), Empty, UpRightTurn(), EndingTrack)
            },
            buildBoard(rows = 6) {
                row(Empty, Empty, DownRightTurn(), DownLeftTurn(), Empty)
                row(FixedHorizontalTrack, DownRightLeftFork(), DownLeftUpFork(), UpRightTurn(), FixedHorizontalTrack)
                row(Empty, VerticalTrack, UpRightTurn(), DownLeftTurn(), Empty)
                row(Empty, VerticalTrack, Empty, VerticalTrack, Empty)
                row(Empty, VerticalTrack, Empty, VerticalTrack, Empty)
                row(FixedHorizontalTrack, UpLeftTurn(), Empty, UpRightTurn(), EndingTrack)
            },
        )
        val level1_14 = setOf(
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalTrack, HorizontalTrack, HorizontalTrack, DownLeftTurn(), Empty)
                row(UpRightDownFork(), FixedHorizontalTrack, FixedHorizontalTrack, DownLeftTurn(), UpRightTurn(), EndingTrack)
                row(UpRightTurn(), HorizontalTrack, HorizontalTrack, UpLeftTurn(), Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalTrack, HorizontalTrack, DownLeftTurn(), Empty, Empty)
                row(DownRightUpFork(), FixedHorizontalTrack, FixedHorizontalTrack, UpLeftTurn(), DownRightTurn(), EndingTrack)
                row(UpRightTurn(), HorizontalTrack, HorizontalTrack, HorizontalTrack, UpLeftTurn(), Empty)
            }
        )
        val level1_14A = setOf(
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalTrack, HorizontalTrack, DownRightLeftFork(), HorizontalTrack, DownLeftTurn(), Empty, Empty)
                row(UpRightDownFork(), FixedHorizontalTrack, FixedHorizontalTrack, DownLeftUpFork(), Empty, UpRightTurn(), FixedHorizontalTrack, EndingTrack)
                row(UpRightTurn(), HorizontalTrack, HorizontalTrack, UpLeftTurn(), Empty, Empty, Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalTrack, HorizontalTrack, DownRightLeftFork(), DownLeftTurn(), Empty, Empty, Empty)
                row(UpRightDownFork(), FixedHorizontalTrack, FixedHorizontalTrack, DownLeftUpFork(), UpRightTurn(), HorizontalTrack, FixedHorizontalTrack, EndingTrack)
                row(UpRightTurn(), HorizontalTrack, HorizontalTrack, UpLeftTurn(), Empty, Empty, Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalTrack, HorizontalTrack, DownLeftTurn(), Empty, Empty, Empty, Empty)
                row(DownRightUpFork(), FixedHorizontalTrack, FixedHorizontalTrack, UpLeftDownFork(), Empty, DownRightTurn(), FixedHorizontalTrack, EndingTrack)
                row(UpRightTurn(), HorizontalTrack, HorizontalTrack, UpRightLeftFork(), HorizontalTrack, UpLeftTurn(), Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalTrack, HorizontalTrack, DownLeftTurn(), Empty, Empty, Empty, Empty)
                row(DownRightUpFork(), FixedHorizontalTrack, FixedHorizontalTrack, UpLeftDownFork(), DownRightTurn(), HorizontalTrack, FixedHorizontalTrack, EndingTrack)
                row(UpRightTurn(), HorizontalTrack, HorizontalTrack, UpRightLeftFork(), UpLeftTurn(), Empty, Empty, Empty)
            }
        )
        val level1_15 = setOf(
            buildBoard(rows = 4) {
                row(FixedHorizontalTrack, FixedHorizontalTrack, DownLeftTurn(), DownRightTurn(), FixedHorizontalTrack, FixedHorizontalTrack)
                row(Empty, DownRightTurn(), UpLeftTurn(fixed = true), UpRightTurn(fixed = true), DownLeftTurn(), Empty)
                row(Empty, UpRightTurn(), DownLeftTurn(fixed = true), DownRightTurn(fixed = true), UpLeftTurn(), Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, UpRightLeftFork(), UpRightLeftFork(), FixedHorizontalTrack, EndingTrack)
            }
        )
        val level1_15A = setOf(
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, DownRightTurn(), DownLeftTurn(), Empty, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, DownLeftTurn(), VerticalTrack, DownRightUpFork(), FixedHorizontalTrack, FixedHorizontalTrack)
                row(Empty, DownRightTurn(), UpLeftTurn(fixed = true), VerticalTrack, UpRightTurn(fixed = true), DownLeftTurn(), Empty)
                row(Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty)
                row(Empty, UpRightTurn(), DownLeftTurn(fixed = true), VerticalTrack, DownRightTurn(fixed = true), UpLeftTurn(), Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, DownLeftUpFork(), FixedVerticalTrack, UpRightTurn(), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, UpRightTurn(), UpLeftTurn(), Empty, Empty, Empty)
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
                row(Empty, Empty, Empty, RightTunnel(GRAY, CarPosition(3, 3, LEFT)), HorizontalTrack, HorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, LeftTunnel(GRAY, CarPosition(0, 3, RIGHT)), Empty, Empty, Empty)
            },
        )
        val level2_2 = setOf(
            buildBoard(rows = 5) {
                row(Empty, Empty, Empty, DownRightTurn(), EndingTrack)
                row(Empty, Empty, Empty, VerticalTrack, Empty)
                row(RightTunnel(GRAY, CarPosition(2, 4, LEFT)), DownLeftTurn(), Empty, UpRightTurn(), LeftTunnel(GRAY, CarPosition(2, 0, RIGHT)))
                row(Empty, VerticalTrack, Empty, Empty, Empty)
                row(FixedHorizontalTrack, UpLeftTurn(), Empty, Empty, Empty)
            }
        )
        val level2_3 = setOf(
            buildBoard(rows = 5) {
                row(
                    RightTunnel(GRAY, CarPosition(3, 0, RIGHT)),
                    FixedHorizontalTrack,
                    FixedHorizontalTrack,
                    FixedHorizontalTrack,
                    EndingTrack
                )
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, DownRightTurn(), HorizontalTrack, DownLeftRightFork(), FixedHorizontalTrack)
                row(RightTunnel(GRAY, CarPosition(0, 0, RIGHT)), UpLeftTurn(), Empty, VerticalTrack, Empty)
                row(Empty, Empty, Empty, UpRightTurn(), FixedHorizontalTrack)
            },
            buildBoard(rows = 5) {
                row(
                    RightTunnel(color = GRAY, exitPosition = CarPosition(row = 3, column = 0, direction = RIGHT)),
                    FixedHorizontalTrack,
                    FixedHorizontalTrack,
                    FixedHorizontalTrack,
                    EndingTrack
                )
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightTurn(), DownLeftRightFork(), FixedHorizontalTrack)
                row(
                    RightTunnel(color = GRAY, exitPosition = CarPosition(row = 0, column = 0, direction = RIGHT)),
                    HorizontalTrack,
                    UpLeftTurn(),
                    VerticalTrack,
                    Empty
                )
                row(Empty, Empty, Empty, UpRightTurn(), FixedHorizontalTrack)
            }
        )
        val level2_3A = setOf(
            buildBoard(rows = 7) {
                row(RightTunnel(GRAY, CarPosition(5, 0, RIGHT)), DownLeftTurn(), DownRightTurn(), FixedHorizontalTrack, EndingTrack)
                row(Obstacle, FixedVerticalTrack, UpRightTurn(), DownLeftTurn(), Empty)
                row(Obstacle, UpRightTurn(), FixedHorizontalTrack, VerticalTrack, Empty)
                row(Obstacle, Obstacle, Obstacle, VerticalTrack, Empty)
                row(Empty, Empty, Empty, UpRightDownFork(), FixedHorizontalTrack)
                row(RightTunnel(GRAY, CarPosition(0, 0, RIGHT)), HorizontalTrack, HorizontalTrack, UpLeftDownFork(), Empty)
                row(Empty, Empty, Empty, UpRightTurn(), FixedHorizontalTrack)
            }
        )
        val level2_3B = setOf(
            buildBoard(rows = 7) {
                row(Empty, Empty, RightTunnel(GRAY, CarPosition(5, 6, LEFT)), HorizontalTrack, HorizontalTrack, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Obstacle, Empty, Empty, Obstacle, Empty)
                row(Empty, Empty, Obstacle, DownRightTurn(), FixedHorizontalTrack, Obstacle, Empty)
                row(Empty, Empty, Obstacle, UpRightTurn(), DownLeftTurn(), Obstacle, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork(), DownLeftRightFork(), HorizontalTrack, UpLeftTurn(), Empty, Empty)
                row(Empty, UpRightDownFork(), UpRightLeftFork(), HorizontalTrack, HorizontalTrack, HorizontalTrack, LeftTunnel(GRAY, CarPosition(0, 2, RIGHT)))
                row(FixedHorizontalTrack, UpLeftTurn(), Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level2_4 = setOf(
            buildBoard(rows = 4) {
                row(Empty, Empty, Empty, Empty, DownTunnel(GRAY, CarPosition(2, 0, RIGHT)), Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, VerticalTrack, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 4, DOWN)), HorizontalTrack, UpLeftRightFork(), DownLeftTurn(), VerticalTrack, Empty)
                row(Empty, Empty, FixedHorizontalTrack, UpLeftTurn(), UpRightTurn(), EndingTrack)
            }
        )
        val level2_4A = setOf(
            buildBoard(rows = 6) {
                row(Empty, Empty, DownTunnel(GRAY, CarPosition(5, 1, RIGHT)), Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, DownRightTurn(), DownLeftTurn())
                row(Empty, DownRightTurn(), UpRightLeftFork(), UpLeftRightFork(), UpLeftTurn())
                row(Empty, UpRightTurn(), DownLeftTurn(), Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 2, DOWN)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            },
            buildBoard(rows = 6) {
                row(Empty, Empty, DownTunnel(GRAY, CarPosition(5, 1, RIGHT)), Empty, Empty)
                row(DownRightTurn(), DownLeftTurn(), FixedVerticalTrack, Empty, Empty)
                row(UpRightTurn(), UpRightLeftFork(), UpLeftRightFork(), DownLeftTurn(), Empty)
                row(Empty, Empty, DownRightTurn(), UpLeftTurn(), Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 2, DOWN)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            },
            buildBoard(rows = 6) {
                row(Empty, Empty, DownTunnel(color = GRAY, exitPosition = CarPosition(row = 5, column = 1, direction = RIGHT)), Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(DownRightTurn(), DownRightLeftFork(), UpLeftRightFork(), DownLeftTurn(), Empty)
                row(UpRightTurn(), UpLeftTurn(), DownRightTurn(), UpLeftTurn(), Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(RightTunnel(color = GRAY, exitPosition = CarPosition(row = 0, column = 2, direction = DOWN)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            }, buildBoard(rows = 6) {
                row(Empty, Empty, DownTunnel(color = GRAY, exitPosition = CarPosition(row = 5, column = 1, direction = RIGHT)), Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, DownRightTurn(), UpRightLeftFork(), DownLeftRightFork(), DownLeftTurn())
                row(Empty, UpRightTurn(), DownLeftTurn(), UpRightTurn(), UpLeftTurn())
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(RightTunnel(color = GRAY, exitPosition = CarPosition(row = 0, column = 2, direction = DOWN)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            }, buildBoard(rows = 6) {
                row(Empty, Empty, DownTunnel(color = GRAY, exitPosition = CarPosition(row = 5, column = 1, direction = RIGHT)), DownRightTurn(), DownLeftTurn())
                row(Empty, Empty, FixedVerticalTrack, DownRightUpFork(), UpLeftTurn())
                row(Empty, Empty, UpRightTurn(), UpLeftDownFork(), Empty)
                row(Empty, Empty, DownRightTurn(), UpLeftTurn(), Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(RightTunnel(color = GRAY, exitPosition = CarPosition(row = 0, column = 2, direction = DOWN)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            }, buildBoard(rows = 6) {
                row(DownRightTurn(), DownLeftTurn(), DownTunnel(color = GRAY, exitPosition = CarPosition(row = 5, column = 1, direction = RIGHT)), Empty, Empty)
                row(UpRightTurn(), DownLeftUpFork(), FixedVerticalTrack, Empty, Empty)
                row(Empty, UpRightDownFork(), UpLeftTurn(), Empty, Empty)
                row(Empty, UpRightTurn(), DownLeftTurn(), Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(RightTunnel(color = GRAY, exitPosition = CarPosition(row = 0, column = 2, direction = DOWN)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            }
        )
        val level2_5 = setOf(
            buildBoard(rows = 5) {
                row(RightTunnel(BROWN, CarPosition(4, 4, UP)), DownLeftTurn(), Empty, Empty, DownTunnel(GRAY, CarPosition(4, 0, RIGHT)), Empty, Empty)
                row(Empty, FixedVerticalTrack, Empty, DownRightTurn(), UpLeftDownFork(fixed = true), Empty, Empty)
                row(Empty, FixedVerticalTrack, FixedVerticalTrack, FixedVerticalTrack, Empty, DownRightTurn(), EndingTrack)
                row(Empty, FixedVerticalTrack, UpRightTurn(), UpLeftTurn(), DownRightUpFork(fixed = true), UpLeftTurn(), Empty)
                row(RightTunnel(GRAY, CarPosition(0, 4, DOWN)), UpLeftTurn(), Empty, Empty, UpTunnel(BROWN, CarPosition(0, 0, RIGHT)), Empty, Empty)
            }
        )
        val level2_5A = setOf(
            buildBoard(rows = 5) {
                row(FixedVerticalTrack, Empty, DownTunnel(GRAY, CarPosition(4, 2, UP)), Empty, FixedVerticalTrack)
                row(UpRightTurn(), DownLeftTurn(), UpRightDownFork(), HorizontalTrack, UpLeftTurn())
                row(Obstacle, UpRightTurn(), UpLeftTurn(), Empty, Obstacle)
                row(DownRightTurn(), HorizontalTrack, DownRightLeftFork(), DownLeftTurn(), Empty)
                row(FixedVerticalTrack, Empty, UpTunnel(GRAY, CarPosition(0, 2, DOWN)), UpRightTurn(), EndingTrack)
            }
        )
        val level2_5B = setOf(
            buildBoard(rows = 5) {
                row(FixedVerticalTrack, Empty, DownTunnel(BROWN, CarPosition(4, 2, UP)), Empty, FixedVerticalTrack)
                row(UpRightTurn(), DownLeftTurn(), UpRightTurn(), DownLeftRightFork(), UpLeftTurn())
                row(RightTunnel(GRAY, CarPosition(2, 4, LEFT)), UpLeftTurn(), Obstacle, UpRightTurn(), LeftTunnel(GRAY, CarPosition(2, 0, RIGHT)))
                row(DownRightTurn(), HorizontalTrack, DownRightLeftFork(), DownLeftTurn(), Empty)
                row(FixedVerticalTrack, Empty, UpTunnel(BROWN, CarPosition(0, 2, DOWN)), UpRightTurn(), EndingTrack)
            }
        )
        val level2_6 = setOf(
            buildBoard(rows = 5) {
                row(FixedHorizontalTrack, HorizontalTrack, LeftTunnel(BROWN, CarPosition(4, 5, UP)), Empty, Empty, DownTunnel(GRAY, CarPosition(4, 2, LEFT)), Empty)
                row(Empty, Empty, Empty, Empty, Empty, VerticalTrack, Empty)
                row(Obstacle, Obstacle, Empty, Empty, DownRightTurn(), UpRightLeftFork(), EndingTrack)
                row(Empty, Empty, Empty, Empty, UpRightTurn(), DownLeftTurn(), Empty)
                row(FixedHorizontalTrack, HorizontalTrack, LeftTunnel(GRAY, CarPosition(0, 5, DOWN)), Empty, Empty, UpTunnel(BROWN, CarPosition(0, 2, LEFT)), Empty)
            }
        )
        val level2_6A = setOf(
            buildBoard(rows = 5) {
                row(RightTunnel(BROWN, CarPosition(4, 5, UP)), DownLeftRightFork(), DownLeftRightFork(), FixedHorizontalTrack, Empty, DownTunnel(GRAY, CarPosition(4, 0, RIGHT)), Empty)
                row(Empty, UpRightTurn(), UpLeftTurn(), Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, Obstacle, Obstacle, Obstacle, Empty, DownRightUpFork(fixed = true), EndingTrack)
                row(Empty, DownRightTurn(), DownLeftTurn(), Empty, Empty, FixedVerticalTrack, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 5, DOWN)), UpLeftTurn(), UpRightTurn(), FixedHorizontalTrack, Empty, UpTunnel(BROWN, CarPosition(0, 0, RIGHT)), Empty)
            }
        )
        val level2_7 = setOf(
            buildBoard(rows = 5) {
                row(Empty, DownTunnel(GRAY, CarPosition(4, 4, UP)), Empty, Empty, DownTunnel(BROWN, CarPosition(4, 1, UP)), Empty, Empty)
                row(Empty, VerticalTrack, Empty, Empty, VerticalTrack, Empty, Empty)
                row(FixedHorizontalTrack, UpLeftDownFork(), Empty, FixedHorizontalTrack, UpLeftTurn(), DownRightTurn(), EndingTrack)
                row(Empty, VerticalTrack, Empty, Empty, DownRightTurn(), UpLeftTurn(), Empty)
                row(Empty, UpTunnel(BROWN, CarPosition(0, 4, DOWN)), Empty, Empty, UpTunnel(GRAY, CarPosition(0, 1, DOWN)), Empty, Empty)
            },
            buildBoard(rows = 5) {
                row(Empty, DownTunnel(GRAY, CarPosition(4, 4, UP)), Empty, Empty, DownTunnel(BROWN, CarPosition(4, 1, UP)), Empty, Empty)
                row(Empty, VerticalTrack, Empty, Empty, UpRightTurn(), DownLeftTurn(), Empty)
                row(FixedHorizontalTrack, DownLeftUpFork(), Empty, FixedHorizontalTrack, DownLeftTurn(), UpRightTurn(), EndingTrack)
                row(Empty, VerticalTrack, Empty, Empty, VerticalTrack, Empty, Empty)
                row(Empty, UpTunnel(BROWN, CarPosition(0, 4, DOWN)), Empty, Empty, UpTunnel(GRAY, CarPosition(0, 1, DOWN)), Empty, Empty)
            }
        )
        val level2_7A = setOf(
            buildBoard(rows = 5) {
                row(Empty, DownTunnel(GRAY, CarPosition(4, 3, UP)), Empty, DownTunnel(PURPLE, CarPosition(4, 5, UP)), Empty, DownTunnel(BROWN, CarPosition(4, 1, UP)), Empty, Empty)
                row(Empty, VerticalTrack, Empty, VerticalTrack, Obstacle, UpRightTurn(), DownLeftTurn(), Empty)
                row(FixedHorizontalTrack, DownLeftUpFork(), FixedHorizontalTrack, DownLeftUpFork(), FixedHorizontalTrack, DownLeftTurn(), UpRightTurn(), EndingTrack)
                row(Empty, VerticalTrack, Empty, VerticalTrack, Obstacle, VerticalTrack, Empty, Empty)
                row(Empty, UpTunnel(BROWN, CarPosition(0, 5, DOWN)), Empty, UpTunnel(GRAY, CarPosition(0, 1, DOWN)), Empty, UpTunnel(PURPLE, CarPosition(0, 3, DOWN)), Empty, Empty)
            },
            buildBoard(rows = 5) {
                row(Empty, DownTunnel(GRAY, CarPosition(4, 3, UP)), Empty, DownTunnel(PURPLE, CarPosition(4, 5, UP)), Empty, DownTunnel(BROWN, CarPosition(4, 1, UP)), Empty, Empty)
                row(Empty, Empty, Empty, VerticalTrack, Obstacle, UpRightTurn(), DownLeftTurn(), Empty)
                row(FixedHorizontalTrack, DownLeftTurn(), FixedHorizontalTrack, DownLeftUpFork(), FixedHorizontalTrack, DownLeftTurn(), UpRightTurn(), EndingTrack)
                row(Empty, DownRightUpFork(), HorizontalTrack, UpLeftTurn(), Obstacle, VerticalTrack, Empty, Empty)
                row(Empty, UpTunnel(BROWN, CarPosition(0, 5, DOWN)), Empty, UpTunnel(GRAY, CarPosition(0, 1, DOWN)), Empty, UpTunnel(PURPLE, CarPosition(0, 3, DOWN)), Empty, Empty)
            }
        )
        val level2_7B = setOf(
            buildBoard(rows = 5) {
                row(Empty, Empty, DownTunnel(BROWN, CarPosition(4, 4, UP)), Empty, DownTunnel(GRAY, CarPosition(4, 2, UP)), Empty, Empty, Empty)
                row(Empty, DownRightTurn(), UpLeftRightFork(), DownLeftTurn(), UpRightTurn(), HorizontalTrack, DownLeftTurn(), Empty)
                row(FixedHorizontalTrack, DownLeftUpFork(), FixedHorizontalTrack, UpLeftTurn(), FixedHorizontalTrack, DownLeftTurn(), UpRightTurn(), EndingTrack)
                row(Empty, UpRightTurn(), DownLeftTurn(), Empty, DownRightTurn(), UpLeftTurn(), Empty, Empty)
                row(Empty, Empty, UpTunnel(GRAY, CarPosition(0, 4, DOWN)), Empty, UpTunnel(BROWN, CarPosition(0, 2, DOWN)), Empty, Empty, Empty)
            },
            buildBoard(rows = 5) {
                row(Empty, Empty, DownTunnel(color=BROWN, exitPosition=CarPosition(row=4, column=4, direction=UP)), Empty, DownTunnel(color=GRAY, exitPosition=CarPosition(row=4, column=2, direction=UP)), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn(), DownLeftTurn(), UpRightTurn(), DownLeftTurn(), Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn(), FixedHorizontalTrack, UpLeftTurn(), FixedHorizontalTrack, UpLeftTurn(), DownRightTurn(), EndingTrack)
                row(Empty, UpRightTurn(), DownRightLeftFork(), HorizontalTrack, DownRightLeftFork(), HorizontalTrack, UpLeftTurn(), Empty)
                row(Empty, Empty, UpTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=4, direction=DOWN)), Empty, UpTunnel(color=BROWN, exitPosition=CarPosition(row=0, column=2, direction=DOWN)), Empty, Empty, Empty)
            },
            buildBoard(rows = 5) {
                row(Empty, Empty, DownTunnel(color=BROWN, exitPosition=CarPosition(row=4, column=4, direction=UP)), Empty, DownTunnel(color=GRAY, exitPosition=CarPosition(row=4, column=2, direction=UP)), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn(), DownLeftRightFork(), HorizontalTrack, DownLeftTurn(), Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn(), FixedHorizontalTrack, UpLeftTurn(), FixedHorizontalTrack, UpLeftTurn(), DownRightTurn(), EndingTrack)
                row(Empty, UpRightTurn(), HorizontalTrack, HorizontalTrack, DownRightLeftFork(), HorizontalTrack, UpLeftTurn(), Empty)
                row(Empty, Empty, UpTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=4, direction=DOWN)), Empty, UpTunnel(color=BROWN, exitPosition=CarPosition(row=0, column=2, direction=DOWN)), Empty, Empty, Empty)
            },
            buildBoard(rows = 5) {
                row(Empty, Empty, DownTunnel(color=BROWN, exitPosition=CarPosition(row=4, column=4, direction=UP)), Empty, DownTunnel(color=GRAY, exitPosition=CarPosition(row=4, column=2, direction=UP)), Empty, Empty, Empty)
                row(Empty, DownRightTurn(), UpLeftTurn(), Empty, UpRightTurn(), DownLeftTurn(), Empty, Empty)
                row(FixedHorizontalTrack, UpLeftDownFork(), FixedHorizontalTrack, DownLeftTurn(), FixedHorizontalTrack, UpLeftTurn(), DownRightTurn(), EndingTrack)
                row(Empty, UpRightTurn(), DownLeftRightFork(), UpLeftTurn(), DownRightTurn(), HorizontalTrack, UpLeftTurn(), Empty)
                row(Empty, Empty, UpTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=4, direction=DOWN)), Empty, UpTunnel(color=BROWN, exitPosition=CarPosition(row=0, column=2, direction=DOWN)), Empty, Empty, Empty)
            },
            buildBoard(rows = 5) {
                row(Empty, Empty, DownTunnel(color=BROWN, exitPosition=CarPosition(row=4, column=4, direction=UP)), Empty, DownTunnel(color=GRAY, exitPosition=CarPosition(row=4, column=2, direction=UP)), Empty, Empty, Empty)
                row(Empty, DownRightTurn(), UpRightLeftFork(), HorizontalTrack, UpRightLeftFork(), HorizontalTrack, DownLeftTurn(), Empty)
                row(FixedHorizontalTrack, UpLeftTurn(), FixedHorizontalTrack, DownLeftTurn(), FixedHorizontalTrack, DownLeftTurn(), UpRightTurn(), EndingTrack)
                row(Empty, Empty, DownRightTurn(), UpLeftTurn(), DownRightTurn(), UpLeftTurn(), Empty, Empty)
                row(Empty, Empty, UpTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=4, direction=DOWN)), Empty, UpTunnel(color=BROWN, exitPosition=CarPosition(row=0, column=2, direction=DOWN)), Empty, Empty, Empty)
            },
            buildBoard(rows = 5) {
                row(Empty, Empty, DownTunnel(color=BROWN, exitPosition=CarPosition(row=4, column=4, direction=UP)), Empty, DownTunnel(color=GRAY, exitPosition=CarPosition(row=4, column=2, direction=UP)), Empty, Empty, Empty)
                row(Empty, DownRightTurn(), HorizontalTrack, HorizontalTrack, UpRightLeftFork(), HorizontalTrack, DownLeftTurn(), Empty)
                row(FixedHorizontalTrack, UpLeftTurn(), FixedHorizontalTrack, DownLeftTurn(), FixedHorizontalTrack, DownLeftTurn(), UpRightTurn(), EndingTrack)
                row(Empty, Empty, DownRightTurn(), UpLeftRightFork(), HorizontalTrack, UpLeftTurn(), Empty, Empty)
                row(Empty, Empty, UpTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=4, direction=DOWN)), Empty, UpTunnel(color=BROWN, exitPosition=CarPosition(row=0, column=2, direction=DOWN)), Empty, Empty, Empty)
            }
        )
        val level2_8 = setOf(
            buildBoard(rows = 6) {
                row(Empty, DownRightTurn(), HorizontalTrack, DownLeftTurn(), Empty, Empty)
                row(FixedHorizontalTrack, UpLeftDownFork(), RightTunnel(GRAY, CarPosition(5, 0, RIGHT)), UpLeftTurn(), DownRightTurn(), FixedHorizontalTrack)
                row(Empty, UpRightTurn(), DownLeftRightFork(), HorizontalTrack, UpLeftTurn(), Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(1, 2, RIGHT)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            }
        )
        val level2_9 = setOf(
            buildBoard(rows = 8) {
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, DownTunnel(BROWN, CarPosition(7, 0, RIGHT)), Empty)
                row(Empty, Empty, Empty, Empty, UpRightTurn(), HorizontalTrack, UpLeftTurn(), Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(7, 4, LEFT)), HorizontalTrack, HorizontalTrack, FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, VerticalTrack, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(BROWN, CarPosition(0, 6, DOWN)), HorizontalTrack, UpRightLeftFork(), HorizontalTrack, LeftTunnel(GRAY, CarPosition(3, 0, RIGHT)), Empty, Empty, Empty)
            }
        )
        val solutions = mapOf(
            "2-1" to level2_1,
            "2-2" to level2_2,
            "2-3" to level2_3,
            "2-3A" to level2_3A,
            "2-3B" to level2_3B,
            "2-4" to level2_4,
            "2-4A" to level2_4A,
            "2-5" to level2_5,
            "2-5A" to level2_5A,
            "2-5B" to level2_5B,
            "2-6" to level2_6,
            "2-6A" to level2_6A,
            "2-7" to level2_7,
            "2-7A" to level2_7A,
            "2-7B" to level2_7B,
            "2-8" to level2_8,
            "2-9" to level2_9,
        )
    }

    object World3 {
        val level3_1 = setOf(
            buildBoard(rows = 4) {
                row(FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, true), HorizontalTrack, DownRightLeftFork(), HorizontalTrack, HorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, VerticalBarrierSwitch(DARK_GREEN), Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalTrack, Empty, Empty, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty)
            }
        )
        val level3_2 = setOf(
            buildBoard(rows = 5) {
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(DARK_GREEN, true), Empty, Empty)
                row(Empty, Empty, DownRightTurn(), UpRightLeftFork(), DownLeftTurn(), Empty)
                row(Empty, Empty, UpRightTurn(), DownLeftTurn(), VerticalTrack, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalBarrierSwitch(DARK_GREEN), UpLeftTurn(), UpRightTurn(), EndingTrack)
            }
        )
        val level3_3 = setOf(
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalBarrier(color=DARK_GREEN, open=false), FixedHorizontalTrack, DownRightTurn(), DownLeftRightFork(fixed=true), FixedHorizontalTrack)
                row(UpRightTurn(), DownRightLeftFork(), DownRightLeftFork(), UpLeftTurn(), VerticalBarrierSwitch(color=DARK_GREEN), Empty)
                row(Empty, UpRightTurn(), UpLeftTurn(), Empty, UpRightTurn(fixed=true), EndingTrack)
            },
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalBarrier(DARK_GREEN, false), FixedHorizontalTrack, DownRightTurn(), DownLeftRightFork(fixed = true), FixedHorizontalTrack)
                row(UpRightTurn(), HorizontalTrack, DownRightLeftFork(), UpLeftDownFork(), VerticalBarrierSwitch(DARK_GREEN), Empty)
                row(Empty, Empty, UpRightTurn(), UpLeftTurn(), UpRightTurn(fixed = true), EndingTrack)
            },
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalBarrier(color=DARK_GREEN, open=false), FixedHorizontalTrack, DownRightTurn(), DownLeftRightFork(fixed=true), FixedHorizontalTrack)
                row(DownRightUpFork(), DownRightLeftFork(), HorizontalTrack, UpLeftTurn(), VerticalBarrierSwitch(color=DARK_GREEN), Empty)
                row(UpRightTurn(), UpLeftTurn(), Empty, Empty, UpRightTurn(fixed=true), EndingTrack)
            }
        )
        val level3_3A = setOf(
            buildBoard(rows = 5) {
                row(Empty, Empty, Empty, DownRightTurn(), DownLeftTurn(), Empty)
                row(Empty, Empty, Empty, DownRightUpFork(), UpLeftTurn(), Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(DownRightTurn(), DownLeftTurn(), Empty, VerticalBarrier(DARK_GREEN, false), Empty, Empty)
                row(UpRightTurn(), UpRightLeftFork(), FixedHorizontalTrack, UpRightLeftFork(), HorizontalBarrierSwitch(DARK_GREEN), EndingTrack)
            },
            buildBoard(rows = 5) {
                row(Empty, Empty, DownRightTurn(fixed=false), DownLeftTurn(fixed=false), Empty, Empty)
                row(Empty, Empty, UpRightTurn(fixed=false), DownLeftUpFork(fixed=false), Empty, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(DownRightTurn(fixed=false), DownLeftTurn(fixed=false), Empty, VerticalBarrier(color=DARK_GREEN, open=false), Empty, Empty)
                row(UpRightTurn(fixed=false), UpRightLeftFork(fixed=false), FixedHorizontalTrack, UpRightLeftFork(fixed=false), HorizontalBarrierSwitch(color=DARK_GREEN), EndingTrack)
            },
            buildBoard(rows = 5) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightTurn(fixed=false), DownLeftTurn(fixed=false), Empty, Empty)
                row(Empty, Empty, VerticalTrack, FixedVerticalTrack, Empty, Empty)
                row(DownRightTurn(fixed=false), DownLeftRightFork(fixed=false), UpLeftTurn(fixed=false), VerticalBarrier(color=DARK_GREEN, open=false), Empty, Empty)
                row(UpRightTurn(fixed=false), UpRightLeftFork(fixed=false), FixedHorizontalTrack, HorizontalTrack, HorizontalBarrierSwitch(color=DARK_GREEN), EndingTrack)
            },
            buildBoard(rows = 5) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, DownRightTurn(fixed=false), HorizontalTrack, DownLeftTurn(fixed=false), Empty, Empty)
                row(Empty, VerticalTrack, Empty, FixedVerticalTrack, Empty, Empty)
                row(DownRightTurn(fixed=false), DownLeftUpFork(fixed=false), Empty, VerticalBarrier(color=DARK_GREEN, open=false), Empty, Empty)
                row(UpRightTurn(fixed=false), UpRightLeftFork(fixed=false), FixedHorizontalTrack, HorizontalTrack, HorizontalBarrierSwitch(color=DARK_GREEN), EndingTrack)
            },
            buildBoard(rows = 5) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightTurn(fixed=false), DownLeftTurn(fixed=false), Empty, Empty)
                row(Empty, DownRightTurn(fixed=false), UpLeftTurn(fixed=false), FixedVerticalTrack, Empty, Empty)
                row(DownRightTurn(fixed=false), DownLeftUpFork(fixed=false), Empty, VerticalBarrier(color=DARK_GREEN, open=false), Empty, Empty)
                row(UpRightTurn(fixed=false), UpRightLeftFork(fixed=false), FixedHorizontalTrack, HorizontalTrack, HorizontalBarrierSwitch(color=DARK_GREEN), EndingTrack)
            }
        )
        val level3_4 = setOf(
            buildBoard(rows = 5) {
                row(FixedHorizontalTrack, DownLeftTurn(fixed=false), Empty, Empty, Empty, DownRightTurn(fixed=false), HorizontalBarrier(color=DARK_GREEN, open=true), DownLeftTurn(fixed=false))
                row(DownRightTurn(fixed=false), UpLeftTurn(fixed=false), Empty, Empty, Empty, VerticalTrack, DownRightTurn(fixed=true), UpLeftTurn(fixed=true))
                row(DownRightUpFork(fixed=false), HorizontalBarrierSwitch(color=DARK_GREEN), DownRightLeftFork(fixed=false), HorizontalTrack, HorizontalBarrierSwitch(color=DARK_GREEN), UpLeftTurn(fixed=false), UpRightTurn(fixed=true), DownLeftTurn(fixed=true))
                row(UpRightDownFork(fixed=false), HorizontalTrack, UpLeftTurn(fixed=false), Empty, Empty, Empty, DownRightTurn(fixed=true), UpLeftTurn(fixed=true))
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty, UpRightTurn(fixed=true), EndingTrack)
            },
            buildBoard(rows = 5) {
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, DownLeftTurn(), Empty, DownRightTurn(), HorizontalBarrier(DARK_GREEN, true), DownLeftTurn())
                row(Empty, Empty, DownRightTurn(), UpLeftTurn(), Empty, VerticalTrack, DownRightTurn(fixed = true), UpLeftTurn(fixed = true))
                row(DownRightTurn(), HorizontalBarrierSwitch(DARK_GREEN), UpRightLeftFork(), HorizontalTrack, HorizontalBarrierSwitch(DARK_GREEN), UpLeftTurn(), UpRightTurn(fixed = true), DownLeftTurn(fixed = true))
                row(VerticalTrack, Empty, Empty, Empty, Empty, Empty, DownRightTurn(fixed = true), UpLeftTurn(fixed = true))
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty, UpRightTurn(fixed = true), EndingTrack)
            },
            buildBoard(rows = 5) {
                row(FixedHorizontalTrack, DownLeftTurn(), Empty, Empty, Empty, DownRightTurn(), HorizontalBarrier(color=DARK_GREEN, open=true), DownLeftTurn())
                row(DownRightTurn(), UpLeftTurn(), Empty, Empty, Empty, VerticalTrack, DownRightTurn(fixed=true), UpLeftTurn(fixed=true))
                row(UpRightTurn(), HorizontalBarrierSwitch(color=DARK_GREEN), DownRightLeftFork(), HorizontalTrack, HorizontalBarrierSwitch(color=DARK_GREEN), UpLeftTurn(), UpRightTurn(fixed=true), DownLeftTurn(fixed=true))
                row(DownRightTurn(), HorizontalTrack, UpLeftTurn(), Empty, Empty, Empty, DownRightTurn(fixed=true), UpLeftTurn(fixed=true))
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty, UpRightTurn(fixed=true), EndingTrack)
            },
        )
        val level3_5 = setOf(
            buildBoard(rows = 3) {
                row(FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, false), HorizontalTrack, HorizontalTrack, HorizontalBarrier(DARK_GREEN, true), DownLeftTurn(), Empty)
                row(DownRightTurn(), DownLeftTurn(), Empty, Empty, Empty, VerticalTrack, Empty)
                row(UpRightTurn(), UpRightLeftFork(), HorizontalBarrierSwitch(DARK_GREEN), FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, true), UpRightLeftFork(), EndingTrack)
            }
        )
        val level3_6 = setOf(
            buildBoard(rows = 5) {
                row(DownRightTurn(), DownRightLeftFork(), FixedHorizontalTrack, HorizontalBarrierSwitch(DARK_GREEN), DownLeftTurn(), Empty, Empty, Empty)
                row(UpRightTurn(), UpLeftTurn(), Empty, Empty, VerticalBarrier(DARK_GREEN, false), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, UpRightDownFork(), HorizontalBarrierSwitch(DARK_GREEN), HorizontalBarrier(DARK_GREEN, true), EndingTrack)
                row(Empty, Empty, Empty, Empty, VerticalBarrierSwitch(DARK_GREEN), Empty, Empty, Empty)
                row(Empty, Empty, FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, false), UpLeftTurn(), Empty, Empty, Empty)
            }
        )
        val level3_7 = setOf(
            buildBoard(rows = 5) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(DownRightTurn(), HorizontalTrack, HorizontalTrack, HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrierSwitch(DARK_GREEN), FixedHorizontalTrack)
                row(DownRightUpFork(), FixedHorizontalTrack, EndingTrack, FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack)
                row(UpRightTurn(), HorizontalTrack, HorizontalBarrier(DARK_GREEN, true), DownLeftRightBarrierSwitch(LIGHT_GREEN), DownLeftRightFork(), FixedHorizontalTrack)
                row(Empty, Empty, Empty, UpRightTurn(), UpLeftTurn(), Empty)
            },
            buildBoard(rows = 5) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(DownRightTurn(fixed=false), HorizontalTrack, HorizontalTrack, HorizontalBarrier(color=LIGHT_GREEN, open=true), HorizontalBarrierSwitch(color=DARK_GREEN), FixedHorizontalTrack)
                row(DownRightUpFork(fixed=false), FixedHorizontalTrack, EndingTrack, FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack)
                row(UpRightDownFork(fixed=false), DownLeftRightFork(fixed=false), HorizontalBarrier(color=DARK_GREEN, open=true), DownLeftRightBarrierSwitch(color=LIGHT_GREEN), HorizontalTrack, FixedHorizontalTrack)
                row(UpRightTurn(fixed=false), UpLeftTurn(fixed=false), Empty, Empty, Empty, Empty)
            }
        )
        val level3_7A = setOf(
            buildBoard(rows = 4) {
                row(Empty, DownRightTurn(), HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrier(DARK_GREEN, true), EndingTrack)
                row(Empty, UpRightDownFork(), HorizontalBarrierSwitch(LIGHT_GREEN), HorizontalTrack, FixedHorizontalTrack)
                row(DownRightTurn(), UpRightLeftFork(), HorizontalBarrierSwitch(DARK_GREEN), DownLeftRightFork(), DownLeftTurn())
                row(FixedVerticalTrack, Empty, Empty, UpRightTurn(), UpLeftTurn())
            }
        )
        val level3_8 = setOf(
            buildBoard(rows = 6) {
                row(Empty, FixedVerticalTrack, Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, UpRightTurn(fixed=false), DownLeftTurn(fixed=false), Empty, FixedVerticalTrack, Empty)
                row(DownRightTurn(fixed=false), DownLeftTurn(fixed=false), VerticalTrack, Empty, VerticalBarrier(color=DARK_GREEN, open=true), Empty)
                row(VerticalBarrierSwitch(color=PINK), VerticalBarrierSwitch(color=LIGHT_GREEN), VerticalBarrierSwitch(color=DARK_GREEN), Empty, VerticalBarrier(color=LIGHT_GREEN, open=true), Empty)
                row(UpRightTurn(fixed=false), DownLeftUpFork(fixed=false), DownRightUpFork(fixed=false), DownLeftTurn(fixed=false), VerticalBarrier(color=PINK, open=true), Empty)
                row(Empty, UpRightTurn(fixed=false), UpLeftTurn(fixed=false), UpRightTurn(fixed=false), UpRightLeftFork(fixed=true), EndingTrack)
            },
            buildBoard(rows = 6) {
                row(Empty, FixedVerticalTrack, Empty, Empty, FixedVerticalTrack, Empty)
                row(DownRightTurn(fixed=false), DownLeftUpFork(fixed=false), Empty, Empty, FixedVerticalTrack, Empty)
                row(VerticalTrack, UpRightDownFork(fixed=false), DownLeftTurn(fixed=false), Empty, VerticalBarrier(color=DARK_GREEN, open=true), Empty)
                row(VerticalBarrierSwitch(color=PINK), VerticalBarrierSwitch(color=LIGHT_GREEN), VerticalBarrierSwitch(color=DARK_GREEN), Empty, VerticalBarrier(color=LIGHT_GREEN, open=true), Empty)
                row(VerticalTrack, UpRightTurn(fixed=false), UpLeftTurn(fixed=false), Empty, VerticalBarrier(color=PINK, open=true), Empty)
                row(UpRightTurn(fixed=false), HorizontalTrack, HorizontalTrack, HorizontalTrack, UpRightLeftFork(fixed=true), EndingTrack)
            },
            buildBoard(rows = 6) {
                row(Empty, FixedVerticalTrack, Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, UpRightTurn(fixed=false), DownLeftTurn(fixed=false), Empty, FixedVerticalTrack, Empty)
                row(DownRightTurn(fixed=false), DownLeftTurn(fixed=false), DownRightUpFork(fixed=false), DownLeftTurn(fixed=false), VerticalBarrier(color=DARK_GREEN, open=false), Empty)
                row(VerticalBarrierSwitch(color=PINK), VerticalBarrierSwitch(color=LIGHT_GREEN), VerticalBarrierSwitch(color=DARK_GREEN), VerticalTrack, VerticalBarrier(color=LIGHT_GREEN, open=true), Empty)
                row(UpRightTurn(fixed=false), UpRightLeftFork(fixed=false), UpLeftTurn(fixed=false), VerticalTrack, VerticalBarrier(color=PINK, open=true), Empty)
                row(Empty, Empty, Empty, UpRightTurn(fixed=false), UpRightLeftFork(fixed=true), EndingTrack)
            },
            buildBoard(rows = 6) {
                row(Empty, FixedVerticalTrack, Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, UpRightTurn(), DownLeftTurn(), Empty, FixedVerticalTrack, Empty)
                row(DownRightTurn(), DownLeftTurn(), VerticalTrack, Empty, VerticalBarrier(DARK_GREEN, true), Empty)
                row(VerticalBarrierSwitch(PINK), VerticalBarrierSwitch(LIGHT_GREEN), VerticalBarrierSwitch(DARK_GREEN), Empty, VerticalBarrier(LIGHT_GREEN, true), Empty)
                row(VerticalTrack, UpRightTurn(), UpLeftTurn(), Empty, VerticalBarrier(PINK, true), Empty)
                row(UpRightTurn(), HorizontalTrack, HorizontalTrack, HorizontalTrack, UpRightLeftFork(fixed = true), EndingTrack)
            }
        )
        val level3_8A = setOf(
            buildBoard(rows = 3) {
                row(DownRightTurn(), FixedHorizontalTrack, DownRightTurn(), HorizontalBarrier(DARK_GREEN, false), HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrier(PINK, false), EndingTrack)
                row(VerticalTrack, Empty, VerticalTrack, Empty, DownRightTurn(), HorizontalTrack, DownLeftTurn())
                row(UpRightTurn(), HorizontalBarrierSwitch(PINK), UpRightLeftFork(), HorizontalBarrierSwitch(LIGHT_GREEN), Empty, HorizontalBarrierSwitch(DARK_GREEN), UpLeftTurn())
            }
        )
        val level3_8B = setOf(
            buildBoard(rows = 5) {
                row(Empty, Empty, HorizontalBarrierSwitch(DARK_GREEN), DownRightTurn(), HorizontalBarrierSwitch(BarrierColor.PURPLE), DownLeftTurn(), HorizontalBarrierSwitch(DARK_GREEN), Empty, HorizontalBarrierSwitch(BarrierColor.PURPLE), Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn(), Obstacle, VerticalBarrierSwitch(DARK_GREEN), Obstacle, VerticalBarrierSwitch(LIGHT_GREEN), Obstacle, VerticalBarrierSwitch(PINK), Obstacle, DownRightTurn(), LeftTunnel(BROWN, CarPosition(4, 0, RIGHT)))
                row(Empty, UpRightTurn(), HorizontalBarrierSwitch(LIGHT_GREEN), UpLeftTurn(), HorizontalBarrierSwitch(PINK), UpRightTurn(), HorizontalBarrierSwitch(LIGHT_GREEN), HorizontalTrack, HorizontalBarrierSwitch(PINK), UpLeftTurn(), Empty)
                row(Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle)
                row(RightTunnel(BROWN, CarPosition(1, 10, LEFT)), FixedHorizontalTrack, HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrier(DARK_GREEN, true), HorizontalBarrier(BarrierColor.PURPLE, true), HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrier(DARK_GREEN, true), HorizontalBarrier(BarrierColor.PURPLE, true), HorizontalBarrier(PINK, true), FixedHorizontalTrack, EndingTrack)
            },
            buildBoard(rows = 5) {
                row(Empty, DownRightTurn(), HorizontalBarrierSwitch(DARK_GREEN), DownLeftTurn(), HorizontalBarrierSwitch(BarrierColor.PURPLE), DownRightTurn(), HorizontalBarrierSwitch(DARK_GREEN), HorizontalTrack, HorizontalBarrierSwitch(BarrierColor.PURPLE), DownLeftTurn(), Empty)
                row(FixedHorizontalTrack, UpLeftTurn(), Obstacle, VerticalBarrierSwitch(DARK_GREEN), Obstacle, VerticalBarrierSwitch(LIGHT_GREEN), Obstacle, VerticalBarrierSwitch(PINK), Obstacle, UpRightTurn(), LeftTunnel(BROWN, CarPosition(4, 0, RIGHT)))
                row(Empty, Empty, HorizontalBarrierSwitch(LIGHT_GREEN), UpRightTurn(), HorizontalBarrierSwitch(PINK), UpLeftTurn(), HorizontalBarrierSwitch(LIGHT_GREEN), Empty, HorizontalBarrierSwitch(PINK), Empty, Empty)
                row(Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle)
                row(RightTunnel(BROWN, CarPosition(1, 10, LEFT)), FixedHorizontalTrack, HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrier(DARK_GREEN, true), HorizontalBarrier(BarrierColor.PURPLE, true), HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrier(DARK_GREEN, true), HorizontalBarrier(BarrierColor.PURPLE, true), HorizontalBarrier(PINK, true), FixedHorizontalTrack, EndingTrack)
            }
        )
        val level3_9 = setOf(
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, DownRightTurn(fixed = false), DownLeftTurn(fixed = false), Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), UpRightTurn(fixed = false), DownLeftTurn(fixed = false), Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, DownLeftTurn(fixed = false), VerticalBarrierSwitch(color = LIGHT_GREEN), Empty, VerticalBarrierSwitch(color = DARK_GREEN), Empty, Empty)
                row(Empty, Empty, UpRightTurn(fixed = false), UpLeftTurn(fixed = false), DownRightTurn(fixed = false), UpRightLeftFork(fixed = false), HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), HorizontalTrack, DownLeftTurn(fixed = false), VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalTrack, VerticalBarrierSwitch(color = PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpRightTurn(fixed = false), UpLeftTurn(fixed = false), Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, DownRightTurn(fixed = false), HorizontalTrack, DownLeftTurn(fixed = false), Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), Empty, VerticalTrack, Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn(fixed = false), Empty, VerticalBarrierSwitch(color = LIGHT_GREEN), Empty, VerticalBarrierSwitch(color = DARK_GREEN), Empty, Empty)
                row(Empty, UpRightTurn(fixed = false), HorizontalTrack, UpLeftTurn(fixed = false), DownRightTurn(fixed = false), UpRightLeftFork(fixed = false), HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), HorizontalTrack, DownLeftTurn(fixed = false), VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalTrack, VerticalBarrierSwitch(color = PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpRightTurn(fixed = false), UpLeftTurn(fixed = false), Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, DownRightTurn(fixed = false), HorizontalTrack, DownLeftTurn(fixed = false), Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), Empty, VerticalTrack, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, DownLeftTurn(fixed = false), VerticalBarrierSwitch(color = LIGHT_GREEN), Empty, VerticalBarrierSwitch(color = DARK_GREEN), Empty, Empty)
                row(Empty, Empty, UpRightTurn(fixed = false), UpLeftTurn(fixed = false), DownRightTurn(fixed = false), UpRightLeftFork(fixed = false), HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), DownLeftTurn(fixed = false), Empty, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn(fixed = false), DownLeftTurn(fixed = false), VerticalBarrierSwitch(color = PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpRightTurn(fixed = false), UpLeftTurn(fixed = false), Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, DownRightTurn(fixed = false), DownLeftTurn(fixed = false), Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), UpRightTurn(fixed = false), DownLeftTurn(fixed = false), Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn(fixed = false), Empty, VerticalBarrierSwitch(color = LIGHT_GREEN), Empty, VerticalBarrierSwitch(color = DARK_GREEN), Empty, Empty)
                row(Empty, UpRightTurn(fixed = false), HorizontalTrack, UpLeftTurn(fixed = false), DownRightTurn(fixed = false), UpRightLeftFork(fixed = false), HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), DownLeftTurn(fixed = false), Empty, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, VerticalTrack, Empty, VerticalBarrierSwitch(color = PINK), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn(fixed = false), HorizontalTrack, UpLeftTurn(fixed = false), Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, DownRightTurn(fixed = false), DownLeftTurn(fixed = false), Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), UpRightTurn(fixed = false), DownLeftTurn(fixed = false), Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn(fixed = false), Empty, VerticalBarrierSwitch(color = LIGHT_GREEN), Empty, VerticalBarrierSwitch(color = DARK_GREEN), Empty, Empty)
                row(Empty, UpRightTurn(fixed = false), HorizontalTrack, UpLeftTurn(fixed = false), DownRightTurn(fixed = false), UpRightLeftFork(fixed = false), HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), HorizontalTrack, DownLeftTurn(fixed = false), VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalTrack, VerticalBarrierSwitch(color = PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpRightTurn(fixed = false), UpLeftTurn(fixed = false), Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, DownRightTurn(fixed = false), DownLeftTurn(fixed = false), Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), UpRightTurn(fixed = false), DownLeftTurn(fixed = false), Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, DownLeftTurn(fixed = false), VerticalBarrierSwitch(color = LIGHT_GREEN), Empty, VerticalBarrierSwitch(color = DARK_GREEN), Empty, Empty)
                row(Empty, Empty, UpRightTurn(fixed = false), UpLeftTurn(fixed = false), DownRightTurn(fixed = false), UpRightLeftFork(fixed = false), HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), DownLeftTurn(fixed = false), Empty, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn(fixed = false), DownLeftTurn(fixed = false), VerticalBarrierSwitch(color = PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpRightTurn(fixed = false), UpLeftTurn(fixed = false), Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, DownRightTurn(fixed = false), DownLeftTurn(fixed = false), Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), UpRightTurn(fixed = false), DownLeftTurn(fixed = false), Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, DownLeftTurn(fixed = false), VerticalBarrierSwitch(color = LIGHT_GREEN), Empty, VerticalBarrierSwitch(color = DARK_GREEN), Empty, Empty)
                row(Empty, Empty, UpRightTurn(fixed = false), UpLeftTurn(fixed = false), DownRightTurn(fixed = false), UpRightLeftFork(fixed = false), HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), DownLeftTurn(fixed = false), Empty, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, VerticalTrack, Empty, VerticalBarrierSwitch(color = PINK), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn(fixed = false), HorizontalTrack, UpLeftTurn(fixed = false), Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, DownRightTurn(fixed = false), DownLeftTurn(fixed = false), Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), UpRightTurn(fixed = false), DownLeftTurn(fixed = false), Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn(fixed = false), Empty, VerticalBarrierSwitch(color = LIGHT_GREEN), Empty, VerticalBarrierSwitch(color = DARK_GREEN), Empty, Empty)
                row(Empty, UpRightTurn(fixed = false), HorizontalTrack, UpLeftTurn(fixed = false), DownRightTurn(fixed = false), UpRightLeftFork(fixed = false), HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), DownLeftTurn(fixed = false), Empty, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn(fixed = false), DownLeftTurn(fixed = false), VerticalBarrierSwitch(color = PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpRightTurn(fixed = false), UpLeftTurn(fixed = false), Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, DownRightTurn(fixed = false), HorizontalTrack, DownLeftTurn(fixed = false), Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), Empty, VerticalTrack, Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn(fixed = false), Empty, VerticalBarrierSwitch(color = LIGHT_GREEN), Empty, VerticalBarrierSwitch(color = DARK_GREEN), Empty, Empty)
                row(Empty, UpRightTurn(fixed = false), HorizontalTrack, UpLeftTurn(fixed = false), DownRightTurn(fixed = false), UpRightLeftFork(fixed = false), HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), DownLeftTurn(fixed = false), Empty, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, VerticalTrack, Empty, VerticalBarrierSwitch(color = PINK), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn(fixed = false), HorizontalTrack, UpLeftTurn(fixed = false), Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, DownRightTurn(fixed = false), HorizontalTrack, DownLeftTurn(fixed = false), Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), Empty, VerticalTrack, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, DownLeftTurn(fixed = false), VerticalBarrierSwitch(color = LIGHT_GREEN), Empty, VerticalBarrierSwitch(color = DARK_GREEN), Empty, Empty)
                row(Empty, Empty, UpRightTurn(fixed = false), UpLeftTurn(fixed = false), DownRightTurn(fixed = false), UpRightLeftFork(fixed = false), HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), DownLeftTurn(fixed = false), Empty, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, VerticalTrack, Empty, VerticalBarrierSwitch(color = PINK), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn(fixed = false), HorizontalTrack, UpLeftTurn(fixed = false), Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, DownRightTurn(fixed = false), HorizontalTrack, DownLeftTurn(fixed = false), Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), Empty, VerticalTrack, Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn(fixed = false), Empty, VerticalBarrierSwitch(color = LIGHT_GREEN), Empty, VerticalBarrierSwitch(color = DARK_GREEN), Empty, Empty)
                row(Empty, UpRightTurn(fixed = false), HorizontalTrack, UpLeftTurn(fixed = false), DownRightTurn(fixed = false), UpRightLeftFork(fixed = false), HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), DownLeftTurn(fixed = false), Empty, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn(fixed = false), DownLeftTurn(fixed = false), VerticalBarrierSwitch(color = PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpRightTurn(fixed = false), UpLeftTurn(fixed = false), Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, DownRightTurn(fixed = false), HorizontalTrack, DownLeftTurn(fixed = false), Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), Empty, VerticalTrack, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, DownLeftTurn(fixed = false), VerticalBarrierSwitch(color = LIGHT_GREEN), Empty, VerticalBarrierSwitch(color = DARK_GREEN), Empty, Empty)
                row(Empty, Empty, UpRightTurn(fixed = false), UpLeftTurn(fixed = false), DownRightTurn(fixed = false), UpRightLeftFork(fixed = false), HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), HorizontalTrack, DownLeftTurn(fixed = false), VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalTrack, VerticalBarrierSwitch(color = PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpRightTurn(fixed = false), UpLeftTurn(fixed = false), Empty, Empty, Empty)
            }
        )
        val level3_10 = setOf(
            buildBoard(rows = 5) {
                row(DownTunnel(BROWN, CarPosition(4, 3, RIGHT)), Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty)
                row(UpRightDownFork(), DownLeftTurn(), Empty, Empty, VerticalTrack, Empty, Empty, Empty)
                row(VerticalBarrierSwitch(DARK_GREEN), VerticalTrack, Empty, Empty, VerticalTrack, Empty, Empty, Empty)
                row(UpRightTurn(), UpLeftTurn(), Empty, Empty, DownRightUpFork(), HorizontalTrack, HorizontalBarrier(DARK_GREEN, false), EndingTrack)
                row(Empty, Empty, Empty, RightTunnel(BROWN, CarPosition(0, 0, DOWN)), UpLeftTurn(), Empty, Empty, Empty)
            }
        )
        val level3_10A = setOf(
            buildBoard(rows = 5) {
                row(Empty, DownTunnel(BROWN, CarPosition(4, 3, LEFT)), Empty, RightTunnel(GRAY, CarPosition(4, 1, RIGHT)), DownLeftRightFork(), HorizontalBarrierSwitch(DARK_GREEN), DownLeftTurn())
                row(DownRightTurn(), UpLeftTurn(), Empty, Empty, UpRightTurn(), HorizontalTrack, UpLeftTurn())
                row(UpRightTurn(), FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrier(DARK_GREEN, true), EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, RightTunnel(GRAY, CarPosition(0, 3, RIGHT)), HorizontalBarrierSwitch(LIGHT_GREEN), LeftTunnel(BROWN, CarPosition(0, 1, DOWN)), Empty, Empty, Empty)
            }
        )
        val level3_10B = setOf(
            buildBoard(rows = 7) {
                row(FixedVerticalTrack, Empty, Empty, DownTunnel(BROWN, CarPosition(5, 3, LEFT)), Empty, Empty, Empty)
                row(UpRightTurn(fixed = true), HorizontalBarrier(DARK_GREEN, true), HorizontalTrack, UpLeftTurn(), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightTurn(), FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack)
                row(Empty, DownRightTurn(), UpLeftDownFork(), Empty, Empty, Empty, Empty)
                row(Empty, VerticalTrack, UpRightDownFork(), LeftTunnel(BROWN, CarPosition(0, 3, DOWN)), Empty, Empty, Empty)
                row(Empty, UpRightBarrierSwitch(DARK_GREEN), UpLeftTurn(), Empty, Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(FixedVerticalTrack, Empty, Empty, DownTunnel(color=BROWN, exitPosition=CarPosition(row=5, column=3, direction=LEFT)), Empty, Empty, Empty)
                row(UpRightTurn(fixed=true), HorizontalBarrier(color=DARK_GREEN, open=true), HorizontalTrack, UpLeftTurn(fixed=false), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, DownRightTurn(fixed=false), HorizontalTrack, FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack)
                row(Empty, VerticalTrack, Empty, Empty, Empty, Empty, Empty)
                row(Empty, UpRightDownFork(fixed=false), DownLeftRightFork(fixed=false), LeftTunnel(color=BROWN, exitPosition=CarPosition(row=0, column=3, direction=DOWN)), Empty, Empty, Empty)
                row(Empty, UpRightBarrierSwitch(color=DARK_GREEN), UpLeftTurn(fixed=false), Empty, Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(FixedVerticalTrack, Empty, Empty, DownTunnel(color=BROWN, exitPosition=CarPosition(row=5, column=3, direction=LEFT)), Empty, Empty, Empty)
                row(UpRightTurn(fixed=true), HorizontalBarrier(color=DARK_GREEN, open=true), HorizontalTrack, UpLeftTurn(fixed=false), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightTurn(fixed=false), FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack)
                row(Empty, DownRightTurn(fixed=false), UpLeftTurn(fixed=false), Empty, Empty, Empty, Empty)
                row(Empty, UpRightDownFork(fixed=false), DownLeftRightFork(fixed=false), LeftTunnel(color=BROWN, exitPosition=CarPosition(row=0, column=3, direction=DOWN)), Empty, Empty, Empty)
                row(Empty, UpRightBarrierSwitch(color=DARK_GREEN), UpLeftTurn(fixed=false), Empty, Empty, Empty, Empty)
            }
        )
        val level3_10C = setOf(
            buildBoard(rows = 7) {
                row(RightTunnel(GREEN, CarPosition(1, 4, DOWN)), HorizontalTrack, HorizontalBarrierSwitch(DARK_GREEN), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, HorizontalBarrierSwitch(PINK), HorizontalTrack, LeftTunnel(GRAY, CarPosition(6, 0, RIGHT)))
                row(Empty, DownRightTurn(), DownLeftTurn(), Empty, DownTunnel(GREEN, CarPosition(0, 0, RIGHT)), Empty, Empty, Empty, Empty)
                row(Empty, UpRightTurn(), DownLeftUpFork(), DownRightTurn(), UpLeftTurn(), Empty, Empty, Empty, Empty)
                row(RightTunnel(BROWN, CarPosition(6, 8, LEFT)), FixedHorizontalTrack, UpLeftTurn(), UpRightTurn(), DownRightLeftFork(), HorizontalBarrier(DARK_GREEN, true), HorizontalBarrier(LIGHT_GREEN, false), HorizontalBarrier(PINK, true), EndingTrack)
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 8, LEFT)), HorizontalTrack, HorizontalBarrierSwitch(DARK_GREEN), FixedHorizontalTrack, HorizontalBarrierSwitch(LIGHT_GREEN), FixedHorizontalTrack, HorizontalBarrierSwitch(PINK), HorizontalTrack, LeftTunnel(BROWN, CarPosition(3, 0, RIGHT)))
            }
        )
        val level3_11 = setOf(
            buildBoard(rows = 5) {
                row(Empty, Empty, DownTunnel(BROWN, CarPosition(4, 4, UP)), Empty, DownTunnel(GRAY, CarPosition(4, 2, UP)), Empty, Empty)
                row(Empty, Empty, UpRightDownFork(), DownLeftTurn(), VerticalBarrierSwitch(DARK_GREEN), Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn(), UpRightTurn(), UpLeftTurn(), DownRightUpFork(fixed = true), FixedHorizontalTrack, EndingTrack)
                row(Empty, UpRightTurn(), DownLeftTurn(), Empty, VerticalBarrier(DARK_GREEN, true), Empty, Empty)
                row(Empty, Empty, UpTunnel(GRAY, CarPosition(0, 4, DOWN)), Empty, UpTunnel(BROWN, CarPosition(0, 2, DOWN)), Empty, Empty)
            },
        )
        val level3_11A = setOf(
            buildBoard(rows = 5) {
                row(Empty, Empty, Empty, Empty, DownTunnel(BROWN, CarPosition(4, 4, UP)), Empty, Empty, Empty)
                row(Empty, Empty, Empty, DownRightTurn(), DownLeftUpFork(), Empty, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalBarrierSwitch(LIGHT_GREEN), DownLeftUpFork(), UpRightTurn(), HorizontalBarrier(LIGHT_GREEN, true), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, UpRightTurn(), DownLeftTurn(), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, UpTunnel(BROWN, CarPosition(0, 4, DOWN)), Empty, Empty, Empty)
            },
            buildBoard(rows = 5) {
                row(Empty, Empty, Empty, Empty, DownTunnel(color=BROWN, exitPosition=CarPosition(row=4, column=4, direction=UP)), Empty, Empty, Empty)
                row(Empty, Empty, Empty, DownRightTurn(fixed=false), UpLeftTurn(fixed=false), Empty, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalBarrierSwitch(color=LIGHT_GREEN), UpLeftDownFork(fixed=false), DownRightTurn(fixed=false), HorizontalBarrier(color=LIGHT_GREEN, open=true), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, UpRightTurn(fixed=false), UpLeftDownFork(fixed=false), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, UpTunnel(color=BROWN, exitPosition=CarPosition(row=0, column=4, direction=DOWN)), Empty, Empty, Empty)
            }
        )
        val level3_11B = setOf(
            buildBoard(rows = 5) {
                row(DownRightTurn(), HorizontalTrack, FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, true), FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, false), FixedHorizontalTrack)
                row(UpRightTurn(), DownRightLeftFork(), HorizontalBarrierSwitch(DARK_GREEN), DownLeftRightFork(), DownLeftTurn(), Empty, Empty)
                row(RightTunnel(BROWN, CarPosition(4, 0, RIGHT)), UpLeftTurn(), Empty, UpRightTurn(), UpLeftTurn(), Empty, Empty)
                row(Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle)
                row(RightTunnel(BROWN, CarPosition(2, 0, RIGHT)), HorizontalBarrier(DARK_GREEN, false), FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, true), DownLeftTurn(), DownRightTurn(), EndingTrack)
                row(Empty, DownRightTurn(), DownLeftTurn(), Empty, DownRightUpFork(), UpLeftTurn(), Empty)
                row(Empty, UpRightTurn(), UpRightLeftFork(), HorizontalBarrierSwitch(DARK_GREEN), UpLeftTurn(), Empty, Empty)
            }
        )
        val solutions = mapOf(
            "3-1" to level3_1,
            "3-2" to level3_2,
            "3-3" to level3_3,
            "3-3A" to level3_3A,
            "3-4" to level3_4,
            "3-5" to level3_5,
            "3-6" to level3_6,
            "3-7" to level3_7,
            "3-7A" to level3_7A,
            "3-8" to level3_8,
            "3-8A" to level3_8A,
            "3-8B" to level3_8B,
            "3-9" to level3_9,
            "3-10" to level3_10,
            "3-10A" to level3_10A,
            "3-10B" to level3_10B,
            "3-10C" to level3_10C,
            "3-11" to level3_11,
            "3-11A" to level3_11A,
            "3-11B" to level3_11B,
        )
    }
    val solutions = World1.solutions +
            World2.solutions +
            World3.solutions
}