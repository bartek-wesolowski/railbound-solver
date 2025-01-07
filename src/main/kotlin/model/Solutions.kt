package model

import model.Board.Companion.buildBoard
import model.Board.Companion.row
import model.Direction.DOWN
import model.Direction.LEFT
import model.Direction.RIGHT
import model.Direction.UP
import model.Tile.*
import model.TunnelColor.*

object Solutions {
    object World1 {
        val level1_1 = setOf(
            buildBoard(rows = 1) {
                row(HorizontalTrack(fixed = true), HorizontalTrack(), HorizontalTrack(), HorizontalTrack(), EndingTrack)
            }
        )
        val level1_2 = setOf(
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalTrack(), DownLeftTurn(), Obstacle, DownRightTurn(), EndingTrack)
                row(VerticalTrack(), Obstacle, VerticalTrack(), Obstacle, VerticalTrack(), Obstacle)
                row(VerticalTrack(fixed = true), Obstacle, UpRightTurn(), HorizontalTrack(), UpLeftTurn(), Obstacle)
            }
        )
        val level1_3 = setOf(
            buildBoard(rows = 3) {
                row(HorizontalTrack(fixed = true), DownLeftRightFork(), HorizontalTrack(fixed = true), DownRightTurn(), EndingTrack)
                row(Empty, VerticalTrack(fixed = true), Empty, VerticalTrack(fixed = true), Empty)
                row(Empty, UpRightTurn(fixed = true), HorizontalTrack(fixed = true), UpLeftTurn(fixed = true), Empty)
            }
        )
        val level1_4 = setOf(
            buildBoard(rows = 5) {
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, Empty)
                row(Empty, DownRightTurn(fixed = true), Empty, DownLeftTurn(fixed = true), Empty)
                row(HorizontalTrack(fixed = true), DownLeftTurn(), Obstacle, DownRightTurn(), EndingTrack)
                row(Empty, UpRightTurn(fixed = true), HorizontalTrack(), UpLeftTurn(fixed = true), Empty)
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, Empty)
            },
            buildBoard(rows = 5) {
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, Empty)
                row(Empty, DownRightTurn(fixed = true), HorizontalTrack(), DownLeftTurn(fixed = true), Empty)
                row(HorizontalTrack(fixed = true), UpLeftTurn(), Obstacle, UpRightTurn(), EndingTrack)
                row(Empty, UpRightTurn(fixed = true), Empty, UpLeftTurn(fixed = true), Empty)
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, Empty)
            }
        )
        val level1_5 = setOf(
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalTrack(), HorizontalTrack(), EndingTrack)
                row(VerticalTrack(), Obstacle, Obstacle, Obstacle)
                row(UpRightTurn(), HorizontalTrack(), HorizontalTrack(), HorizontalTrack(fixed = true))
            }
        )
        val level1_6 = setOf(
            buildBoard(rows = 3) {
                row(Empty, Empty, Empty, Empty, Empty)
                row(HorizontalTrack(fixed = true), HorizontalTrack(), HorizontalTrack(), HorizontalTrack(), EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level1_7 = setOf(
            buildBoard(rows = 3) {
                row(VerticalTrack(fixed = true), Empty, Empty)
                row(VerticalTrack(), Obstacle, Empty)
                row(UpRightTurn(), HorizontalTrack(), EndingTrack)
            }
        )
        val level1_8 = setOf(
            buildBoard(rows = 3) {
                row(HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), DownRightLeftFork(), EndingTrack)
                row(Empty, DownRightTurn(), UpLeftTurn(), Empty)
                row(HorizontalTrack(fixed = true), UpLeftTurn(), Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), DownRightLeftFork(), EndingTrack)
                row(Empty, Empty, VerticalTrack(), Empty)
                row(HorizontalTrack(fixed = true), HorizontalTrack(), UpLeftTurn(), Empty)
            }
        )
        val level1_9 = setOf(
            buildBoard(rows = 3) {
                row(VerticalTrack(fixed = true), Obstacle, VerticalTrack(fixed = true), Empty, Empty)
                row(VerticalTrack(), Obstacle, VerticalTrack(fixed = true), Empty, Empty)
                row(UpRightTurn(), HorizontalTrack(), UpRightLeftFork(), HorizontalTrack(fixed = true), EndingTrack)
            }
        )
        val level1_10 = setOf(
            buildBoard(rows = 5) {
                row(HorizontalTrack(fixed = true), HorizontalTrack(), DownLeftTurn(), Empty, Empty)
                row(Empty, DownRightTurn(fixed = true), UpRightLeftFork(), DownLeftTurn(fixed = true), Empty)
                row(Empty, VerticalTrack(fixed = true), Obstacle, UpRightDownFork(), EndingTrack)
                row(Empty, UpRightTurn(fixed = true), DownLeftTurn(), UpLeftTurn(fixed = true), Empty)
                row(HorizontalTrack(fixed = true), HorizontalTrack(), UpLeftTurn(), Empty, Empty)
            }
        )
        val level1_11 = setOf(
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalTrack(fixed = true), DownLeftTurn(), Empty)
                row(VerticalTrack(), Obstacle, UpRightTurn(), EndingTrack)
                row(UpRightTurn(), HorizontalTrack(fixed = true), Empty, Empty)
            }
        )
        val level1_11A = setOf(
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, HorizontalTrack(fixed = true), DownRightLeftFork(), DownLeftTurn(), Empty, Empty)
                row(Empty, Empty, VerticalTrack(), VerticalTrack(), Obstacle, Empty)
                row(Empty, HorizontalTrack(fixed = true), UpLeftDownFork(), UpRightTurn(), HorizontalTrack(), EndingTrack)
                row(Empty, Empty, VerticalTrack(), Empty, Obstacle, Empty)
                row(Empty, HorizontalTrack(fixed = true), UpLeftTurn(), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level1_11B = setOf(
            buildBoard(rows = 7) {
                row(DownRightTurn(), HorizontalTrack(), HorizontalTrack(), DownLeftTurn(), Empty, Empty)
                row(UpRightTurn(), HorizontalTrack(fixed = true), DownLeftTurn(), VerticalTrack(), Empty, Empty)
                row(Empty, Empty, VerticalTrack(), VerticalTrack(), Obstacle, Empty)
                row(DownRightTurn(), HorizontalTrack(fixed = true), UpLeftTurn(), UpRightTurn(), HorizontalTrack(), EndingTrack)
                row(VerticalTrack(), Empty, Empty, Empty, Obstacle, Empty)
                row(UpRightTurn(), HorizontalTrack(fixed = true), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(DownRightTurn(), HorizontalTrack(fixed = true), DownLeftTurn(), Empty, Empty, Empty)
                row(VerticalTrack(), Empty, VerticalTrack(), Empty, Obstacle, Empty)
                row(VerticalTrack(), HorizontalTrack(fixed = true), UpLeftDownFork(), DownRightTurn(), HorizontalTrack(), EndingTrack)
                row(DownRightUpFork(), HorizontalTrack(), UpLeftTurn(), VerticalTrack(), Obstacle, Empty)
                row(UpRightTurn(), HorizontalTrack(fixed = true), HorizontalTrack(), UpLeftTurn(), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(DownRightTurn(), HorizontalTrack(fixed = true), Empty, Empty, Empty, Empty)
                row(DownRightUpFork(), HorizontalTrack(), DownLeftTurn(), Empty, Obstacle, Empty)
                row(VerticalTrack(), HorizontalTrack(fixed = true), UpLeftDownFork(), DownRightTurn(), HorizontalTrack(), EndingTrack)
                row(DownRightUpFork(), HorizontalTrack(), UpLeftTurn(), VerticalTrack(), Obstacle, Empty)
                row(UpRightTurn(), HorizontalTrack(fixed = true), HorizontalTrack(), UpLeftTurn(), Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level1_12 = setOf(
            buildBoard(rows = 3) {
                row(HorizontalTrack(fixed = true), HorizontalTrack(), DownRightLeftFork(), HorizontalTrack(), EndingTrack)
                row(Empty, Empty, UpRightTurn(), DownLeftTurn(), Empty)
                row(Empty, Empty, HorizontalTrack(fixed = true), UpLeftTurn(), Empty)
            },
        )
        val level1_12A = setOf(
            buildBoard(rows = 3) {
                row(Empty, Empty, Empty, Empty, Empty)
                row(HorizontalTrack(fixed = true), DownRightLeftFork(), DownRightLeftFork(), HorizontalTrack(fixed = true), EndingTrack)
                row(Empty, UpRightTurn(), UpLeftTurn(), Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(Empty, DownRightTurn(), DownLeftTurn(), Empty, Empty)
                row(HorizontalTrack(fixed = true), UpRightLeftFork(), UpRightLeftFork(), HorizontalTrack(fixed = true), EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level1_13 = setOf(
            buildBoard(rows = 5) {
                row(HorizontalTrack(fixed = true), DownLeftTurn(), Empty, DownRightTurn(), HorizontalTrack(fixed = true))
                row(Empty, VerticalTrack(), Obstacle, VerticalTrack(), Empty)
                row(Empty, DownRightUpFork(), HorizontalTrack(), UpLeftTurn(), Empty)
                row(Empty, VerticalTrack(), Obstacle, Empty, Empty)
                row(Empty, UpRightTurn(), HorizontalTrack(), HorizontalTrack(), EndingTrack)
            }
        )
        val level1_13A = setOf(
            buildBoard(rows = 6) {
                row(Empty, Empty, DownRightTurn(), DownLeftTurn(), Empty)
                row(HorizontalTrack(fixed = true), DownRightLeftFork(), DownLeftUpFork(), UpRightTurn(), HorizontalTrack(fixed = true))
                row(Empty, VerticalTrack(), VerticalTrack(), Empty, Empty)
                row(Empty, VerticalTrack(), VerticalTrack(), Empty, Empty)
                row(Empty, VerticalTrack(), VerticalTrack(), Empty, Empty)
                row(HorizontalTrack(fixed = true), UpLeftTurn(), UpRightTurn(), HorizontalTrack(), EndingTrack)
            },
            buildBoard(rows = 6) {
                row(Empty, Empty, DownRightTurn(), DownLeftTurn(), Empty)
                row(HorizontalTrack(fixed = true), DownRightLeftFork(), DownLeftUpFork(), UpRightTurn(), HorizontalTrack(fixed = true))
                row(Empty, VerticalTrack(), VerticalTrack(), Empty, Empty)
                row(Empty, VerticalTrack(), VerticalTrack(), Empty, Empty)
                row(Empty, VerticalTrack(), UpRightTurn(), DownLeftTurn(), Empty)
                row(HorizontalTrack(fixed = true), UpLeftTurn(), Empty, UpRightTurn(), EndingTrack)
            },
            buildBoard(rows = 6) {
                row(Empty, Empty, DownRightTurn(), DownLeftTurn(), Empty)
                row(HorizontalTrack(fixed = true), DownRightLeftFork(), DownLeftUpFork(), UpRightTurn(), HorizontalTrack(fixed = true))
                row(Empty, VerticalTrack(), VerticalTrack(), Empty, Empty)
                row(Empty, VerticalTrack(), UpRightTurn(), DownLeftTurn(), Empty)
                row(Empty, VerticalTrack(), Empty, VerticalTrack(), Empty)
                row(HorizontalTrack(fixed = true), UpLeftTurn(), Empty, UpRightTurn(), EndingTrack)
            },
            buildBoard(rows = 6) {
                row(Empty, Empty, DownRightTurn(), DownLeftTurn(), Empty)
                row(HorizontalTrack(fixed = true), DownRightLeftFork(), DownLeftUpFork(), UpRightTurn(), HorizontalTrack(fixed = true))
                row(Empty, VerticalTrack(), UpRightTurn(), DownLeftTurn(), Empty)
                row(Empty, VerticalTrack(), Empty, VerticalTrack(), Empty)
                row(Empty, VerticalTrack(), Empty, VerticalTrack(), Empty)
                row(HorizontalTrack(fixed = true), UpLeftTurn(), Empty, UpRightTurn(), EndingTrack)
            },
        )
        val level1_14 = setOf(
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalTrack(), HorizontalTrack(), HorizontalTrack(), DownLeftTurn(), Empty)
                row(UpRightDownFork(), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), DownLeftTurn(), UpRightTurn(), EndingTrack)
                row(UpRightTurn(), HorizontalTrack(), HorizontalTrack(), UpLeftTurn(), Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalTrack(), HorizontalTrack(), DownLeftTurn(), Empty, Empty)
                row(DownRightUpFork(), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), UpLeftTurn(), DownRightTurn(), EndingTrack)
                row(UpRightTurn(), HorizontalTrack(), HorizontalTrack(), HorizontalTrack(), UpLeftTurn(), Empty)
            }
        )
        val level1_14A = setOf(
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalTrack(), HorizontalTrack(), DownRightLeftFork(), HorizontalTrack(), DownLeftTurn(), Empty, Empty)
                row(UpRightDownFork(), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), DownLeftUpFork(), Empty, UpRightTurn(), HorizontalTrack(fixed = true), EndingTrack)
                row(UpRightTurn(), HorizontalTrack(), HorizontalTrack(), UpLeftTurn(), Empty, Empty, Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalTrack(), HorizontalTrack(), DownRightLeftFork(), DownLeftTurn(), Empty, Empty, Empty)
                row(UpRightDownFork(), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), DownLeftUpFork(), UpRightTurn(), HorizontalTrack(), HorizontalTrack(fixed = true), EndingTrack)
                row(UpRightTurn(), HorizontalTrack(), HorizontalTrack(), UpLeftTurn(), Empty, Empty, Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalTrack(), HorizontalTrack(), DownLeftTurn(), Empty, Empty, Empty, Empty)
                row(DownRightUpFork(), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), UpLeftDownFork(), Empty, DownRightTurn(), HorizontalTrack(fixed = true), EndingTrack)
                row(UpRightTurn(), HorizontalTrack(), HorizontalTrack(), UpRightLeftFork(), HorizontalTrack(), UpLeftTurn(), Empty, Empty)
            },
            buildBoard(rows = 3) {
                row(DownRightTurn(), HorizontalTrack(), HorizontalTrack(), DownLeftTurn(), Empty, Empty, Empty, Empty)
                row(DownRightUpFork(), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), UpLeftDownFork(), DownRightTurn(), HorizontalTrack(), HorizontalTrack(fixed = true), EndingTrack)
                row(UpRightTurn(), HorizontalTrack(), HorizontalTrack(), UpRightLeftFork(), UpLeftTurn(), Empty, Empty, Empty)
            }
        )
        val level1_15 = setOf(
            buildBoard(rows = 4) {
                row(HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), DownLeftTurn(), DownRightTurn(), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true))
                row(Empty, DownRightTurn(), UpLeftTurn(fixed = true), UpRightTurn(fixed = true), DownLeftTurn(), Empty)
                row(Empty, UpRightTurn(), DownLeftTurn(fixed = true), DownRightTurn(fixed = true), UpLeftTurn(), Empty)
                row(HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), UpRightLeftFork(), UpRightLeftFork(), HorizontalTrack(fixed = true), EndingTrack)
            }
        )
        val level1_15A = setOf(
            buildBoard(rows = 7) {
                row(Empty, Empty, Empty, DownRightTurn(), DownLeftTurn(), Empty, Empty)
                row(HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), DownLeftTurn(), VerticalTrack(), DownRightUpFork(), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true))
                row(Empty, DownRightTurn(), UpLeftTurn(fixed = true), VerticalTrack(), UpRightTurn(fixed = true), DownLeftTurn(), Empty)
                row(Empty, VerticalTrack(fixed = true), Empty, VerticalTrack(fixed = true), Empty, VerticalTrack(fixed = true), Empty)
                row(Empty, UpRightTurn(), DownLeftTurn(fixed = true), VerticalTrack(), DownRightTurn(fixed = true), UpLeftTurn(), Empty)
                row(HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), DownLeftUpFork(), VerticalTrack(fixed = true), UpRightTurn(), HorizontalTrack(fixed = true), EndingTrack)
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
                row(Empty, Empty, Empty, RightTunnel(GRAY, CarPosition(3, 3, LEFT)), HorizontalTrack(), HorizontalTrack(), EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(HorizontalTrack(fixed = true), HorizontalTrack(), HorizontalTrack(), LeftTunnel(GRAY, CarPosition(0, 3, RIGHT)), Empty, Empty, Empty)
            },
        )
        val level2_2 = setOf(
            buildBoard(rows = 5) {
                row(Empty, Empty, Empty, DownRightTurn(), EndingTrack)
                row(Empty, Empty, Empty, VerticalTrack(), Empty)
                row(RightTunnel(GRAY, CarPosition(2, 4, LEFT)), DownLeftTurn(), Empty, UpRightTurn(), LeftTunnel(GRAY, CarPosition(2, 0, RIGHT)))
                row(Empty, VerticalTrack(), Empty, Empty, Empty)
                row(HorizontalTrack(fixed = true), UpLeftTurn(), Empty, Empty, Empty)
            }
        )
        val level2_3 = setOf(
            buildBoard(rows = 5) {
                row(
                    RightTunnel(GRAY, CarPosition(3, 0, RIGHT)),
                    HorizontalTrack(fixed = true),
                    HorizontalTrack(fixed = true),
                    HorizontalTrack(fixed = true),
                    EndingTrack
                )
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, DownRightTurn(), HorizontalTrack(), DownLeftRightFork(), HorizontalTrack(fixed = true))
                row(RightTunnel(GRAY, CarPosition(0, 0, RIGHT)), UpLeftTurn(), Empty, VerticalTrack(), Empty)
                row(Empty, Empty, Empty, UpRightTurn(), HorizontalTrack(fixed = true))
            },
            buildBoard(rows = 5) {
                row(
                    RightTunnel(color = GRAY, exitPosition = CarPosition(row = 3, column = 0, direction = RIGHT)),
                    HorizontalTrack(fixed = true),
                    HorizontalTrack(fixed = true),
                    HorizontalTrack(fixed = true),
                    EndingTrack
                )
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightTurn(), DownLeftRightFork(), HorizontalTrack(fixed = true))
                row(
                    RightTunnel(color = GRAY, exitPosition = CarPosition(row = 0, column = 0, direction = RIGHT)),
                    HorizontalTrack(),
                    UpLeftTurn(),
                    VerticalTrack(),
                    Empty
                )
                row(Empty, Empty, Empty, UpRightTurn(), HorizontalTrack(fixed = true))
            }
        )
        val level2_3A = setOf(
            buildBoard(rows = 7) {
                row(RightTunnel(GRAY, CarPosition(5, 0, RIGHT)), DownLeftTurn(), DownRightTurn(), HorizontalTrack(fixed = true), EndingTrack)
                row(Obstacle, VerticalTrack(fixed = true), UpRightTurn(), DownLeftTurn(), Empty)
                row(Obstacle, UpRightTurn(), HorizontalTrack(fixed = true), VerticalTrack(), Empty)
                row(Obstacle, Obstacle, Obstacle, VerticalTrack(), Empty)
                row(Empty, Empty, Empty, UpRightDownFork(), HorizontalTrack(fixed = true))
                row(RightTunnel(GRAY, CarPosition(0, 0, RIGHT)), HorizontalTrack(), HorizontalTrack(), UpLeftDownFork(), Empty)
                row(Empty, Empty, Empty, UpRightTurn(), HorizontalTrack(fixed = true))
            }
        )
        val level2_3B = setOf(
            buildBoard(rows = 7) {
                row(Empty, Empty, RightTunnel(GRAY, CarPosition(5, 6, LEFT)), HorizontalTrack(), HorizontalTrack(), HorizontalTrack(fixed = true), EndingTrack)
                row(Empty, Empty, Obstacle, Empty, Empty, Obstacle, Empty)
                row(Empty, Empty, Obstacle, DownRightTurn(), HorizontalTrack(fixed = true), Obstacle, Empty)
                row(Empty, Empty, Obstacle, UpRightTurn(), DownLeftTurn(), Obstacle, Empty)
                row(HorizontalTrack(fixed = true), DownRightLeftFork(), DownLeftRightFork(), HorizontalTrack(), UpLeftTurn(), Empty, Empty)
                row(Empty, UpRightDownFork(), UpRightLeftFork(), HorizontalTrack(), HorizontalTrack(), HorizontalTrack(), LeftTunnel(GRAY, CarPosition(0, 2, RIGHT)))
                row(HorizontalTrack(fixed = true), UpLeftTurn(), Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level2_4 = setOf(
            buildBoard(rows = 4) {
                row(Empty, Empty, Empty, Empty, DownTunnel(GRAY, CarPosition(2, 0, RIGHT)), Empty)
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, VerticalTrack(), Empty)
                row(RightTunnel(GRAY, CarPosition(0, 4, DOWN)), HorizontalTrack(), UpLeftRightFork(), DownLeftTurn(), VerticalTrack(), Empty)
                row(Empty, Empty, HorizontalTrack(fixed = true), UpLeftTurn(), UpRightTurn(), EndingTrack)
            }
        )
        val level2_4A = setOf(
            buildBoard(rows = 6) {
                row(Empty, Empty, DownTunnel(GRAY, CarPosition(5, 1, RIGHT)), Empty, Empty)
                row(Empty, Empty, VerticalTrack(fixed = true), DownRightTurn(), DownLeftTurn())
                row(Empty, DownRightTurn(), UpRightLeftFork(), UpLeftRightFork(), UpLeftTurn())
                row(Empty, UpRightTurn(), DownLeftTurn(), Empty, Empty)
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 2, DOWN)), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), EndingTrack)
            },
            buildBoard(rows = 6) {
                row(Empty, Empty, DownTunnel(GRAY, CarPosition(5, 1, RIGHT)), Empty, Empty)
                row(DownRightTurn(), DownLeftTurn(), VerticalTrack(fixed = true), Empty, Empty)
                row(UpRightTurn(), UpRightLeftFork(), UpLeftRightFork(), DownLeftTurn(), Empty)
                row(Empty, Empty, DownRightTurn(), UpLeftTurn(), Empty)
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 2, DOWN)), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), EndingTrack)
            },
            buildBoard(rows = 6) {
                row(Empty, Empty, DownTunnel(color = GRAY, exitPosition = CarPosition(row = 5, column = 1, direction = RIGHT)), Empty, Empty)
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, Empty)
                row(DownRightTurn(), DownRightLeftFork(), UpLeftRightFork(), DownLeftTurn(), Empty)
                row(UpRightTurn(), UpLeftTurn(), DownRightTurn(), UpLeftTurn(), Empty)
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, Empty)
                row(RightTunnel(color = GRAY, exitPosition = CarPosition(row = 0, column = 2, direction = DOWN)), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), EndingTrack)
            }, buildBoard(rows = 6) {
                row(Empty, Empty, DownTunnel(color = GRAY, exitPosition = CarPosition(row = 5, column = 1, direction = RIGHT)), Empty, Empty)
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, Empty)
                row(Empty, DownRightTurn(), UpRightLeftFork(), DownLeftRightFork(), DownLeftTurn())
                row(Empty, UpRightTurn(), DownLeftTurn(), UpRightTurn(), UpLeftTurn())
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, Empty)
                row(RightTunnel(color = GRAY, exitPosition = CarPosition(row = 0, column = 2, direction = DOWN)), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), EndingTrack)
            }, buildBoard(rows = 6) {
                row(Empty, Empty, DownTunnel(color = GRAY, exitPosition = CarPosition(row = 5, column = 1, direction = RIGHT)), DownRightTurn(), DownLeftTurn())
                row(Empty, Empty, VerticalTrack(fixed = true), DownRightUpFork(), UpLeftTurn())
                row(Empty, Empty, UpRightTurn(), UpLeftDownFork(), Empty)
                row(Empty, Empty, DownRightTurn(), UpLeftTurn(), Empty)
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, Empty)
                row(RightTunnel(color = GRAY, exitPosition = CarPosition(row = 0, column = 2, direction = DOWN)), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), EndingTrack)
            }, buildBoard(rows = 6) {
                row(DownRightTurn(), DownLeftTurn(), DownTunnel(color = GRAY, exitPosition = CarPosition(row = 5, column = 1, direction = RIGHT)), Empty, Empty)
                row(UpRightTurn(), DownLeftUpFork(), VerticalTrack(fixed = true), Empty, Empty)
                row(Empty, UpRightDownFork(), UpLeftTurn(), Empty, Empty)
                row(Empty, UpRightTurn(), DownLeftTurn(), Empty, Empty)
                row(Empty, Empty, VerticalTrack(fixed = true), Empty, Empty)
                row(RightTunnel(color = GRAY, exitPosition = CarPosition(row = 0, column = 2, direction = DOWN)), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), HorizontalTrack(fixed = true), EndingTrack)
            }
        )
        val level2_5 = setOf(
            buildBoard(rows = 5) {
                row(RightTunnel(BROWN, CarPosition(4, 4, UP)), DownLeftTurn(), Empty, Empty, DownTunnel(GRAY, CarPosition(4, 0, RIGHT)), Empty, Empty)
                row(Empty, VerticalTrack(fixed = true), Empty, DownRightTurn(), UpLeftDownFork(fixed = true), Empty, Empty)
                row(Empty, VerticalTrack(fixed = true), VerticalTrack(fixed = true), VerticalTrack(fixed = true), Empty, DownRightTurn(), EndingTrack)
                row(Empty, VerticalTrack(fixed = true), UpRightTurn(), UpLeftTurn(), DownRightUpFork(fixed = true), UpLeftTurn(), Empty)
                row(RightTunnel(GRAY, CarPosition(0, 4, DOWN)), UpLeftTurn(), Empty, Empty, UpTunnel(BROWN, CarPosition(0, 0, RIGHT)), Empty, Empty)
            }
        )
        val level2_5A = setOf(
            buildBoard(rows = 5) {
                row(VerticalTrack(fixed = true), Empty, DownTunnel(GRAY, CarPosition(4, 2, UP)), Empty, VerticalTrack(fixed = true))
                row(UpRightTurn(), DownLeftTurn(), UpRightDownFork(), HorizontalTrack(), UpLeftTurn())
                row(Obstacle, UpRightTurn(), UpLeftTurn(), Empty, Obstacle)
                row(DownRightTurn(), HorizontalTrack(), DownRightLeftFork(), DownLeftTurn(), Empty)
                row(VerticalTrack(fixed = true), Empty, UpTunnel(GRAY, CarPosition(0, 2, DOWN)), UpRightTurn(), EndingTrack)
            }
        )
        val level2_5B = setOf(
            buildBoard(rows = 5) {
                row(VerticalTrack(fixed = true), Empty, DownTunnel(BROWN, CarPosition(4, 2, UP)), Empty, VerticalTrack(fixed = true))
                row(UpRightTurn(), DownLeftTurn(), UpRightTurn(), DownLeftRightFork(), UpLeftTurn())
                row(RightTunnel(GRAY, CarPosition(2, 4, LEFT)), UpLeftTurn(), Obstacle, UpRightTurn(), LeftTunnel(GRAY, CarPosition(2, 0, RIGHT)))
                row(DownRightTurn(), HorizontalTrack(), DownRightLeftFork(), DownLeftTurn(), Empty)
                row(VerticalTrack(fixed = true), Empty, UpTunnel(BROWN, CarPosition(0, 2, DOWN)), UpRightTurn(), EndingTrack)
            }
        )
        val level2_6 = setOf(
            buildBoard(rows = 5) {
                row(HorizontalTrack(fixed = true), HorizontalTrack(), LeftTunnel(BROWN, CarPosition(4, 5, UP)), Empty, Empty, DownTunnel(GRAY, CarPosition(4, 2, LEFT)), Empty)
                row(Empty, Empty, Empty, Empty, Empty, VerticalTrack(), Empty)
                row(Obstacle, Obstacle, Empty, Empty, DownRightTurn(), UpRightLeftFork(), EndingTrack)
                row(Empty, Empty, Empty, Empty, UpRightTurn(), DownLeftTurn(), Empty)
                row(HorizontalTrack(fixed = true), HorizontalTrack(), LeftTunnel(GRAY, CarPosition(0, 5, DOWN)), Empty, Empty, UpTunnel(BROWN, CarPosition(0, 2, LEFT)), Empty)
            }
        )
        val level2_6A = setOf(
            buildBoard(rows = 5) {
                row(RightTunnel(BROWN, CarPosition(4, 5, UP)), DownLeftRightFork(), DownLeftRightFork(), HorizontalTrack(fixed = true), Empty, DownTunnel(GRAY, CarPosition(4, 0, RIGHT)), Empty)
                row(Empty, UpRightTurn(), UpLeftTurn(), Empty, Empty, VerticalTrack(fixed = true), Empty)
                row(Empty, Obstacle, Obstacle, Obstacle, Empty, DownRightUpFork(fixed = true), EndingTrack)
                row(Empty, DownRightTurn(), DownLeftTurn(), Empty, Empty, VerticalTrack(fixed = true), Empty)
                row(RightTunnel(GRAY, CarPosition(0, 5, DOWN)), UpLeftTurn(), UpRightTurn(), HorizontalTrack(fixed = true), Empty, UpTunnel(BROWN, CarPosition(0, 0, RIGHT)), Empty)
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
        )
    }
}