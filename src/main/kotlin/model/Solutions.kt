package model

import model.Board.Companion.buildBoard
import model.Board.Companion.row
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
import model.Tile.BaseHorizontalTrack.HorizontalTrack
import model.Tile.BaseVerticalTrack.FixedVerticalTrack
import model.Tile.BaseVerticalTrack.VerticalBarrier
import model.Tile.BaseVerticalTrack.VerticalStop
import model.Tile.BaseVerticalTrack.VerticalToggle
import model.Tile.BaseVerticalTrack.VerticalTrack
import model.Tile.DownTunnel
import model.Tile.Empty
import model.Tile.EndingTrack
import model.Tile.Fork.BaseDownLeftRightFork.DownLeftRightFork
import model.Tile.Fork.BaseDownLeftRightFork.DownLeftRightToggle
import model.Tile.Fork.BaseDownLeftRightFork.DownLeftRightToggleableFork
import model.Tile.Fork.BaseDownLeftRightFork.FixedDownLeftRightFork
import model.Tile.Fork.BaseDownLeftUpFork.DownLeftUpFork
import model.Tile.Fork.BaseDownLeftUpFork.DownLeftUpToggle
import model.Tile.Fork.BaseDownLeftUpFork.DownLeftUpToggleableFork
import model.Tile.Fork.BaseDownLeftUpFork.FixedDownLeftUpFork
import model.Tile.Fork.BaseDownRightLeftFork.DownRightLeftFork
import model.Tile.Fork.BaseDownRightLeftFork.DownRightLeftToggleableFork
import model.Tile.Fork.BaseDownRightLeftFork.FixedDownRightLeftFork
import model.Tile.Fork.BaseDownRightUpFork.DownRightUpFork
import model.Tile.Fork.BaseDownRightUpFork.DownRightUpToggleableFork
import model.Tile.Fork.BaseDownRightUpFork.FixedDownRightUpFork
import model.Tile.Fork.BaseUpLeftDownFork.FixedUpLeftDownFork
import model.Tile.Fork.BaseUpLeftDownFork.UpLeftDownFork
import model.Tile.Fork.BaseUpLeftDownFork.UpLeftDownToggleableFork
import model.Tile.Fork.BaseUpLeftRightFork.UpLeftRightFork
import model.Tile.Fork.BaseUpLeftRightFork.UpLeftRightToggleableFork
import model.Tile.Fork.BaseUpRightDownFork.FixedUpRightDownFork
import model.Tile.Fork.BaseUpRightDownFork.UpRightDownFork
import model.Tile.Fork.BaseUpRightDownFork.UpRightDownToggleableFork
import model.Tile.Fork.BaseUpRightLeftFork.FixedUpRightLeftFork
import model.Tile.Fork.BaseUpRightLeftFork.UpRightLeftFork
import model.Tile.Fork.BaseUpRightLeftFork.UpRightLeftToggle
import model.Tile.Fork.BaseUpRightLeftFork.UpRightLeftToggleableFork
import model.Tile.LeftTunnel
import model.Tile.Obstacle
import model.Tile.Platform.DownPlatform
import model.Tile.Platform.LeftPlatform
import model.Tile.Platform.UpPlatform
import model.Tile.RightTunnel
import model.Tile.Turn.BaseDownLeftTurn.DownLeftToggle
import model.Tile.Turn.BaseDownLeftTurn.DownLeftTurn
import model.Tile.Turn.BaseDownLeftTurn.FixedDownLeftTurn
import model.Tile.Turn.BaseDownRightTurn.DownRightToggle
import model.Tile.Turn.BaseDownRightTurn.DownRightTurn
import model.Tile.Turn.BaseDownRightTurn.FixedDownRightTurn
import model.Tile.Turn.BaseUpLeftTurn.FixedUpLeftTurn
import model.Tile.Turn.BaseUpLeftTurn.UpLeftToggle
import model.Tile.Turn.BaseUpLeftTurn.UpLeftTurn
import model.Tile.Turn.BaseUpRightTurn.FixedUpRightTurn
import model.Tile.Turn.BaseUpRightTurn.UpRightBarrier
import model.Tile.Turn.BaseUpRightTurn.UpRightToggle
import model.Tile.Turn.BaseUpRightTurn.UpRightTurn
import model.Tile.UpTunnel
import model.TunnelColor.BEIGE
import model.TunnelColor.BROWN
import model.TunnelColor.GRAY
import model.TunnelColor.GREEN
import model.TunnelColor.LIGHT_GRAY
import model.TunnelColor.MINT
import model.TunnelColor.PURPLE

object Solutions {
    object World1 {
        val level1_1 = setOf(
            buildBoard {
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack)
            }
        )
        val level1_2 = setOf(
            buildBoard {
                row(DownRightTurn, HorizontalTrack, DownLeftTurn, Obstacle, DownRightTurn, EndingTrack)
                row(VerticalTrack, Obstacle, VerticalTrack, Obstacle, VerticalTrack, Obstacle)
                row(FixedVerticalTrack, Obstacle, UpRightTurn, HorizontalTrack, UpLeftTurn, Obstacle)
            }
        )
        val level1_3 = setOf(
            buildBoard {
                row(FixedHorizontalTrack, FixedDownLeftRightFork, FixedHorizontalTrack, DownRightTurn, EndingTrack)
                row(Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty)
                row(Empty, FixedUpRightTurn, FixedHorizontalTrack, FixedUpLeftTurn, Empty)
            }
        )
        val level1_4 = setOf(
            buildBoard {
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, FixedDownRightTurn, Empty, FixedDownLeftTurn, Empty)
                row(FixedHorizontalTrack, DownLeftTurn, Obstacle, DownRightTurn, EndingTrack)
                row(Empty, FixedUpRightTurn, HorizontalTrack, FixedUpLeftTurn, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, FixedDownRightTurn, HorizontalTrack, FixedDownLeftTurn, Empty)
                row(FixedHorizontalTrack, UpLeftTurn, Obstacle, UpRightTurn, EndingTrack)
                row(Empty, FixedUpRightTurn, Empty, FixedUpLeftTurn, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
            }
        )
        val level1_5 = setOf(
            buildBoard {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, EndingTrack)
                row(VerticalTrack, Obstacle, Obstacle, Obstacle)
                row(UpRightTurn, HorizontalTrack, HorizontalTrack, FixedHorizontalTrack)
            }
        )
        val level1_6 = setOf(
            buildBoard {
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level1_7 = setOf(
            buildBoard {
                row(FixedVerticalTrack, Empty, Empty)
                row(VerticalTrack, Obstacle, Empty)
                row(UpRightTurn, HorizontalTrack, EndingTrack)
            }
        )
        val level1_8 = setOf(
            buildBoard {
                row(FixedHorizontalTrack, FixedHorizontalTrack, FixedDownRightLeftFork, EndingTrack)
                row(Empty, DownRightTurn, UpLeftTurn, Empty)
                row(FixedHorizontalTrack, UpLeftTurn, Empty, Empty)
            },
            buildBoard {
                row(FixedHorizontalTrack, FixedHorizontalTrack, FixedDownRightLeftFork, EndingTrack)
                row(Empty, Empty, VerticalTrack, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, UpLeftTurn, Empty)
            }
        )
        val level1_9 = setOf(
            buildBoard {
                row(FixedVerticalTrack, Obstacle, FixedVerticalTrack, Empty, Empty)
                row(VerticalTrack, Obstacle, FixedVerticalTrack, Empty, Empty)
                row(UpRightTurn, HorizontalTrack, UpRightLeftFork, FixedHorizontalTrack, EndingTrack)
            }
        )
        val level1_10 = setOf(
            buildBoard {
                row(FixedHorizontalTrack, HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(Empty, FixedDownRightTurn, UpRightLeftFork, FixedDownLeftTurn, Empty)
                row(Empty, FixedVerticalTrack, Obstacle, FixedUpRightDownFork, EndingTrack)
                row(Empty, FixedUpRightTurn, DownLeftTurn, FixedUpLeftTurn, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, UpLeftTurn, Empty, Empty)
            }
        )
        val level1_11 = setOf(
            buildBoard {
                row(DownRightTurn, FixedHorizontalTrack, DownLeftTurn, Empty)
                row(VerticalTrack, Obstacle, UpRightTurn, EndingTrack)
                row(UpRightTurn, FixedHorizontalTrack, Empty, Empty)
            }
        )
        val level1_11A = setOf(
            buildBoard {
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
            buildBoard {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(UpRightTurn, FixedHorizontalTrack, DownLeftTurn, VerticalTrack, Empty, Empty)
                row(Empty, Empty, VerticalTrack, VerticalTrack, Obstacle, Empty)
                row(DownRightTurn, FixedHorizontalTrack, UpLeftTurn, UpRightTurn, HorizontalTrack, EndingTrack)
                row(VerticalTrack, Empty, Empty, Empty, Obstacle, Empty)
                row(UpRightTurn, FixedHorizontalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(DownRightTurn, FixedHorizontalTrack, DownLeftTurn, Empty, Empty, Empty)
                row(VerticalTrack, Empty, VerticalTrack, Empty, Obstacle, Empty)
                row(VerticalTrack, FixedHorizontalTrack, UpLeftDownFork, DownRightTurn, HorizontalTrack, EndingTrack)
                row(DownRightUpFork, HorizontalTrack, UpLeftTurn, VerticalTrack, Obstacle, Empty)
                row(UpRightTurn, FixedHorizontalTrack, HorizontalTrack, UpLeftTurn, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            buildBoard {
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
            buildBoard {
                row(FixedHorizontalTrack, HorizontalTrack, DownRightLeftFork, HorizontalTrack, EndingTrack)
                row(Empty, Empty, UpRightTurn, DownLeftTurn, Empty)
                row(Empty, Empty, FixedHorizontalTrack, UpLeftTurn, Empty)
            },
        )
        val level1_12A = setOf(
            buildBoard {
                row(Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, DownRightLeftFork, FixedHorizontalTrack, EndingTrack)
                row(Empty, UpRightTurn, UpLeftTurn, Empty, Empty)
            },
            buildBoard {
                row(Empty, DownRightTurn, DownLeftTurn, Empty, Empty)
                row(FixedHorizontalTrack, UpRightLeftFork, UpRightLeftFork, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level1_13 = setOf(
            buildBoard {
                row(FixedHorizontalTrack, DownLeftTurn, Empty, DownRightTurn, FixedHorizontalTrack)
                row(Empty, VerticalTrack, Obstacle, VerticalTrack, Empty)
                row(Empty, DownRightUpFork, HorizontalTrack, UpLeftTurn, Empty)
                row(Empty, VerticalTrack, Obstacle, Empty, Empty)
                row(Empty, UpRightTurn, HorizontalTrack, HorizontalTrack, EndingTrack)
            }
        )
        val level1_13A = setOf(
            buildBoard {
                row(Empty, Empty, DownRightTurn, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, DownLeftUpFork, UpRightTurn, FixedHorizontalTrack)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(FixedHorizontalTrack, UpLeftTurn, UpRightTurn, HorizontalTrack, EndingTrack)
            },
            buildBoard {
                row(Empty, Empty, DownRightTurn, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, DownLeftUpFork, UpRightTurn, FixedHorizontalTrack)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(Empty, VerticalTrack, UpRightTurn, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, UpLeftTurn, Empty, UpRightTurn, EndingTrack)
            },
            buildBoard {
                row(Empty, Empty, DownRightTurn, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, DownLeftUpFork, UpRightTurn, FixedHorizontalTrack)
                row(Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(Empty, VerticalTrack, UpRightTurn, DownLeftTurn, Empty)
                row(Empty, VerticalTrack, Empty, VerticalTrack, Empty)
                row(FixedHorizontalTrack, UpLeftTurn, Empty, UpRightTurn, EndingTrack)
            },
            buildBoard {
                row(Empty, Empty, DownRightTurn, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, DownLeftUpFork, UpRightTurn, FixedHorizontalTrack)
                row(Empty, VerticalTrack, UpRightTurn, DownLeftTurn, Empty)
                row(Empty, VerticalTrack, Empty, VerticalTrack, Empty)
                row(Empty, VerticalTrack, Empty, VerticalTrack, Empty)
                row(FixedHorizontalTrack, UpLeftTurn, Empty, UpRightTurn, EndingTrack)
            },
        )
        val level1_14 = setOf(
            buildBoard {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty)
                row(UpRightDownFork, FixedHorizontalTrack, FixedHorizontalTrack, DownLeftTurn, UpRightTurn, EndingTrack)
                row(UpRightTurn, HorizontalTrack, HorizontalTrack, UpLeftTurn, Empty, Empty)
            },
            buildBoard {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(DownRightUpFork, FixedHorizontalTrack, FixedHorizontalTrack, UpLeftTurn, DownRightTurn, EndingTrack)
                row(UpRightTurn, HorizontalTrack, HorizontalTrack, HorizontalTrack, UpLeftTurn, Empty)
            }
        )
        val level1_14A = setOf(
            buildBoard {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, DownRightLeftFork, HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(UpRightDownFork, FixedHorizontalTrack, FixedHorizontalTrack, DownLeftUpFork, Empty, UpRightTurn, FixedHorizontalTrack, EndingTrack)
                row(UpRightTurn, HorizontalTrack, HorizontalTrack, UpLeftTurn, Empty, Empty, Empty, Empty)
            },
            buildBoard {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, DownRightLeftFork, DownLeftTurn, Empty, Empty, Empty)
                row(UpRightDownFork, FixedHorizontalTrack, FixedHorizontalTrack, DownLeftUpFork, UpRightTurn, HorizontalTrack, FixedHorizontalTrack, EndingTrack)
                row(UpRightTurn, HorizontalTrack, HorizontalTrack, UpLeftTurn, Empty, Empty, Empty, Empty)
            },
            buildBoard {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty, Empty, Empty, Empty)
                row(DownRightUpFork, FixedHorizontalTrack, FixedHorizontalTrack, UpLeftDownFork, Empty, DownRightTurn, FixedHorizontalTrack, EndingTrack)
                row(UpRightTurn, HorizontalTrack, HorizontalTrack, UpRightLeftFork, HorizontalTrack, UpLeftTurn, Empty, Empty)
            },
            buildBoard {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty, Empty, Empty, Empty)
                row(DownRightUpFork, FixedHorizontalTrack, FixedHorizontalTrack, UpLeftDownFork, DownRightTurn, HorizontalTrack, FixedHorizontalTrack, EndingTrack)
                row(UpRightTurn, HorizontalTrack, HorizontalTrack, UpRightLeftFork, UpLeftTurn, Empty, Empty, Empty)
            }
        )
        val level1_15 = setOf(
            buildBoard {
                row(FixedHorizontalTrack, FixedHorizontalTrack, DownLeftTurn, DownRightTurn, FixedHorizontalTrack, FixedHorizontalTrack)
                row(Empty, DownRightTurn, FixedUpLeftTurn, FixedUpRightTurn, DownLeftTurn, Empty)
                row(Empty, UpRightTurn, FixedDownLeftTurn, FixedDownRightTurn, UpLeftTurn, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, UpRightLeftFork, UpRightLeftFork, FixedHorizontalTrack, EndingTrack)
            }
        )
        val level1_15A = setOf(
            buildBoard {
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
            buildBoard {
                row(Empty, Empty, Empty, RightTunnel(GRAY, CarPosition(3, 3, LEFT)), HorizontalTrack, HorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, LeftTunnel(GRAY, CarPosition(0, 3, RIGHT)), Empty, Empty, Empty)
            },
        )
        val level2_2 = setOf(
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, EndingTrack)
                row(Empty, Empty, Empty, VerticalTrack, Empty)
                row(RightTunnel(GRAY, CarPosition(2, 4, LEFT)), DownLeftTurn, Empty, UpRightTurn, LeftTunnel(GRAY, CarPosition(2, 0, RIGHT)))
                row(Empty, VerticalTrack, Empty, Empty, Empty)
                row(FixedHorizontalTrack, UpLeftTurn, Empty, Empty, Empty)
            }
        )
        val level2_3 = setOf(
            buildBoard {
                row(
                    RightTunnel(GRAY, CarPosition(3, 0, RIGHT)),
                    FixedHorizontalTrack,
                    FixedHorizontalTrack,
                    FixedHorizontalTrack,
                    EndingTrack
                )
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, DownRightTurn, HorizontalTrack, DownLeftRightFork, FixedHorizontalTrack)
                row(RightTunnel(GRAY, CarPosition(0, 0, RIGHT)), UpLeftTurn, Empty, VerticalTrack, Empty)
                row(Empty, Empty, Empty, UpRightTurn, FixedHorizontalTrack)
            },
            buildBoard {
                row(
                    RightTunnel(color = GRAY, exitPosition = CarPosition(row = 3, column = 0, direction = RIGHT)),
                    FixedHorizontalTrack,
                    FixedHorizontalTrack,
                    FixedHorizontalTrack,
                    EndingTrack
                )
                row(Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightTurn, DownLeftRightFork, FixedHorizontalTrack)
                row(
                    RightTunnel(color = GRAY, exitPosition = CarPosition(row = 0, column = 0, direction = RIGHT)),
                    HorizontalTrack,
                    UpLeftTurn,
                    VerticalTrack,
                    Empty
                )
                row(Empty, Empty, Empty, UpRightTurn, FixedHorizontalTrack)
            }
        )
        val level2_3A = setOf(
            buildBoard {
                row(RightTunnel(GRAY, CarPosition(5, 0, RIGHT)), DownLeftTurn, DownRightTurn, FixedHorizontalTrack, EndingTrack)
                row(Obstacle, FixedVerticalTrack, UpRightTurn, DownLeftTurn, Empty)
                row(Obstacle, UpRightTurn, FixedHorizontalTrack, VerticalTrack, Empty)
                row(Obstacle, Obstacle, Obstacle, VerticalTrack, Empty)
                row(Empty, Empty, Empty, UpRightDownFork, FixedHorizontalTrack)
                row(RightTunnel(GRAY, CarPosition(0, 0, RIGHT)), HorizontalTrack, HorizontalTrack, UpLeftDownFork, Empty)
                row(Empty, Empty, Empty, UpRightTurn, FixedHorizontalTrack)
            }
        )
        val level2_3B = setOf(
            buildBoard {
                row(Empty, Empty, RightTunnel(GRAY, CarPosition(5, 6, LEFT)), HorizontalTrack, HorizontalTrack, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Obstacle, Empty, Empty, Obstacle, Empty)
                row(Empty, Empty, Obstacle, DownRightTurn, FixedHorizontalTrack, Obstacle, Empty)
                row(Empty, Empty, Obstacle, UpRightTurn, DownLeftTurn, Obstacle, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, DownLeftRightFork, HorizontalTrack, UpLeftTurn, Empty, Empty)
                row(Empty, UpRightDownFork, UpRightLeftFork, HorizontalTrack, HorizontalTrack, HorizontalTrack, LeftTunnel(GRAY, CarPosition(0, 2, RIGHT)))
                row(FixedHorizontalTrack, UpLeftTurn, Empty, Empty, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, RightTunnel(color=GRAY, exitPosition=CarPosition(row=5, column=6, direction=LEFT)), DownLeftTurn, DownRightTurn, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Obstacle, UpRightDownFork, UpLeftTurn, Obstacle, Empty)
                row(Empty, Empty, Obstacle, UpRightTurn, FixedHorizontalTrack, Obstacle, Empty)
                row(Empty, Empty, Obstacle, Empty, Empty, Obstacle, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, HorizontalTrack, DownLeftTurn, DownRightTurn, DownLeftTurn, Empty)
                row(Empty, VerticalTrack, Empty, UpRightTurn, UpRightLeftFork, UpRightLeftFork, LeftTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=2, direction=RIGHT)))
                row(FixedHorizontalTrack, UpLeftTurn, Empty, Empty, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, RightTunnel(color=GRAY, exitPosition=CarPosition(row=5, column=6, direction=LEFT)), DownLeftTurn, DownRightTurn, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Obstacle, UpRightDownFork, UpLeftTurn, Obstacle, Empty)
                row(Empty, Empty, Obstacle, UpRightTurn, FixedHorizontalTrack, Obstacle, Empty)
                row(Empty, Empty, Obstacle, Empty, Empty, Obstacle, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, DownLeftTurn, Empty, DownRightTurn, DownLeftTurn, Empty)
                row(Empty, VerticalTrack, UpRightTurn, HorizontalTrack, UpRightLeftFork, UpRightLeftFork, LeftTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=2, direction=RIGHT)))
                row(FixedHorizontalTrack, UpLeftTurn, Empty, Empty, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, RightTunnel(color=GRAY, exitPosition=CarPosition(row=5, column=6, direction=LEFT)), DownLeftTurn, DownRightTurn, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Obstacle, UpRightDownFork, UpLeftTurn, Obstacle, Empty)
                row(Empty, Empty, Obstacle, UpRightTurn, FixedHorizontalTrack, Obstacle, Empty)
                row(Empty, Empty, Obstacle, Empty, Empty, Obstacle, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, HorizontalTrack, DownRightLeftFork, DownLeftRightFork, DownLeftTurn, Empty)
                row(Empty, VerticalTrack, Empty, UpRightTurn, UpRightLeftFork, UpRightLeftFork, LeftTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=2, direction=RIGHT)))
                row(FixedHorizontalTrack, UpLeftTurn, Empty, Empty, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, RightTunnel(color=GRAY, exitPosition=CarPosition(row=5, column=6, direction=LEFT)), DownLeftTurn, DownRightTurn, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Obstacle, UpRightDownFork, UpLeftTurn, Obstacle, Empty)
                row(Empty, Empty, Obstacle, UpRightTurn, FixedHorizontalTrack, Obstacle, Empty)
                row(Empty, Empty, Obstacle, Empty, Empty, Obstacle, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, HorizontalTrack, DownLeftTurn, Empty, Empty, Empty)
                row(Empty, VerticalTrack, Empty, UpRightTurn, DownRightLeftFork, DownRightLeftFork, LeftTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=2, direction=RIGHT)))
                row(FixedHorizontalTrack, UpLeftTurn, Empty, Empty, UpRightTurn, UpLeftTurn, Empty)
            },
            buildBoard {
                row(Empty, Empty, RightTunnel(color=GRAY, exitPosition=CarPosition(row=5, column=6, direction=LEFT)), DownLeftTurn, DownRightTurn, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Obstacle, UpRightDownFork, UpLeftTurn, Obstacle, Empty)
                row(Empty, Empty, Obstacle, UpRightTurn, FixedHorizontalTrack, Obstacle, Empty)
                row(Empty, Empty, Obstacle, Empty, Empty, Obstacle, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, DownRightLeftFork, HorizontalTrack, DownLeftRightFork, DownLeftTurn, Empty)
                row(Empty, UpRightDownFork, UpLeftTurn, Empty, UpRightTurn, UpRightLeftFork, LeftTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=2, direction=RIGHT)))
                row(FixedHorizontalTrack, UpLeftTurn, Empty, Empty, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, RightTunnel(color=GRAY, exitPosition=CarPosition(row=5, column=6, direction=LEFT)), DownLeftTurn, DownRightTurn, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Obstacle, UpRightDownFork, UpLeftTurn, Obstacle, Empty)
                row(Empty, Empty, Obstacle, UpRightTurn, FixedHorizontalTrack, Obstacle, Empty)
                row(Empty, Empty, Obstacle, Empty, Empty, Obstacle, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, DownLeftTurn, Empty, Empty, Empty, Empty)
                row(Empty, VerticalTrack, UpRightTurn, HorizontalTrack, DownRightLeftFork, DownRightLeftFork, LeftTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=2, direction=RIGHT)))
                row(FixedHorizontalTrack, UpLeftTurn, Empty, Empty, UpRightTurn, UpLeftTurn, Empty)
            }
        )
        val level2_4 = setOf(
            buildBoard {
                row(Empty, Empty, Empty, Empty, DownTunnel(GRAY, CarPosition(2, 0, RIGHT)), Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, VerticalTrack, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 4, DOWN)), HorizontalTrack, UpLeftRightFork, DownLeftTurn, VerticalTrack, Empty)
                row(Empty, Empty, FixedHorizontalTrack, UpLeftTurn, UpRightTurn, EndingTrack)
            }
        )
        val level2_4A = setOf(
            buildBoard {
                row(Empty, Empty, DownTunnel(GRAY, CarPosition(5, 1, RIGHT)), Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, DownRightTurn, DownLeftTurn)
                row(Empty, DownRightTurn, UpRightLeftFork, UpLeftRightFork, UpLeftTurn)
                row(Empty, UpRightTurn, DownLeftTurn, Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 2, DOWN)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            },
            buildBoard {
                row(Empty, Empty, DownTunnel(GRAY, CarPosition(5, 1, RIGHT)), Empty, Empty)
                row(DownRightTurn, DownLeftTurn, FixedVerticalTrack, Empty, Empty)
                row(UpRightTurn, UpRightLeftFork, UpLeftRightFork, DownLeftTurn, Empty)
                row(Empty, Empty, DownRightTurn, UpLeftTurn, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 2, DOWN)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            },
            buildBoard {
                row(Empty, Empty, DownTunnel(color = GRAY, exitPosition = CarPosition(row = 5, column = 1, direction = RIGHT)), Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(DownRightTurn, DownRightLeftFork, UpLeftRightFork, DownLeftTurn, Empty)
                row(UpRightTurn, UpLeftTurn, DownRightTurn, UpLeftTurn, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(RightTunnel(color = GRAY, exitPosition = CarPosition(row = 0, column = 2, direction = DOWN)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            }, buildBoard {
                row(Empty, Empty, DownTunnel(color = GRAY, exitPosition = CarPosition(row = 5, column = 1, direction = RIGHT)), Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, DownRightTurn, UpRightLeftFork, DownLeftRightFork, DownLeftTurn)
                row(Empty, UpRightTurn, DownLeftTurn, UpRightTurn, UpLeftTurn)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(RightTunnel(color = GRAY, exitPosition = CarPosition(row = 0, column = 2, direction = DOWN)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            }, buildBoard {
                row(Empty, Empty, DownTunnel(color = GRAY, exitPosition = CarPosition(row = 5, column = 1, direction = RIGHT)), DownRightTurn, DownLeftTurn)
                row(Empty, Empty, FixedVerticalTrack, DownRightUpFork, UpLeftTurn)
                row(Empty, Empty, UpRightTurn, UpLeftDownFork, Empty)
                row(Empty, Empty, DownRightTurn, UpLeftTurn, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(RightTunnel(color = GRAY, exitPosition = CarPosition(row = 0, column = 2, direction = DOWN)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            }, buildBoard {
                row(DownRightTurn, DownLeftTurn, DownTunnel(color = GRAY, exitPosition = CarPosition(row = 5, column = 1, direction = RIGHT)), Empty, Empty)
                row(UpRightTurn, DownLeftUpFork, FixedVerticalTrack, Empty, Empty)
                row(Empty, UpRightDownFork, UpLeftTurn, Empty, Empty)
                row(Empty, UpRightTurn, DownLeftTurn, Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(RightTunnel(color = GRAY, exitPosition = CarPosition(row = 0, column = 2, direction = DOWN)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            }
        )
        val level2_5 = setOf(
            buildBoard {
                row(RightTunnel(BROWN, CarPosition(4, 4, UP)), DownLeftTurn, Empty, Empty, DownTunnel(GRAY, CarPosition(4, 0, RIGHT)), Empty, Empty)
                row(Empty, FixedVerticalTrack, Empty, DownRightTurn, FixedUpLeftDownFork, Empty, Empty)
                row(Empty, FixedVerticalTrack, FixedVerticalTrack, FixedVerticalTrack, Empty, DownRightTurn, EndingTrack)
                row(Empty, FixedVerticalTrack, UpRightTurn, UpLeftTurn, FixedDownRightUpFork, UpLeftTurn, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 4, DOWN)), UpLeftTurn, Empty, Empty, UpTunnel(BROWN, CarPosition(0, 0, RIGHT)), Empty, Empty)
            }
        )
        val level2_5A = setOf(
            buildBoard {
                row(FixedVerticalTrack, Empty, DownTunnel(GRAY, CarPosition(4, 2, UP)), Empty, FixedVerticalTrack)
                row(UpRightTurn, DownLeftTurn, UpRightDownFork, HorizontalTrack, UpLeftTurn)
                row(Obstacle, UpRightTurn, UpLeftTurn, Empty, Obstacle)
                row(DownRightTurn, HorizontalTrack, DownRightLeftFork, DownLeftTurn, Empty)
                row(FixedVerticalTrack, Empty, UpTunnel(GRAY, CarPosition(0, 2, DOWN)), UpRightTurn, EndingTrack)
            }
        )
        val level2_5B = setOf(
            buildBoard {
                row(FixedVerticalTrack, Empty, DownTunnel(BROWN, CarPosition(4, 2, UP)), Empty, FixedVerticalTrack)
                row(UpRightTurn, DownLeftTurn, UpRightTurn, DownLeftRightFork, UpLeftTurn)
                row(RightTunnel(GRAY, CarPosition(2, 4, LEFT)), UpLeftTurn, Obstacle, UpRightTurn, LeftTunnel(GRAY, CarPosition(2, 0, RIGHT)))
                row(DownRightTurn, HorizontalTrack, DownRightLeftFork, DownLeftTurn, Empty)
                row(FixedVerticalTrack, Empty, UpTunnel(BROWN, CarPosition(0, 2, DOWN)), UpRightTurn, EndingTrack)
            }
        )
        val level2_6 = setOf(
            buildBoard {
                row(FixedHorizontalTrack, HorizontalTrack, LeftTunnel(BROWN, CarPosition(4, 5, UP)), Empty, Empty, DownTunnel(GRAY, CarPosition(4, 2, LEFT)), Empty)
                row(Empty, Empty, Empty, Empty, Empty, VerticalTrack, Empty)
                row(Obstacle, Obstacle, Empty, Empty, DownRightTurn, UpRightLeftFork, EndingTrack)
                row(Empty, Empty, Empty, Empty, UpRightTurn, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, LeftTunnel(GRAY, CarPosition(0, 5, DOWN)), Empty, Empty, UpTunnel(BROWN, CarPosition(0, 2, LEFT)), Empty)
            }
        )
        val level2_6A = setOf(
            buildBoard {
                row(RightTunnel(BROWN, CarPosition(4, 5, UP)), DownLeftRightFork, DownLeftRightFork, FixedHorizontalTrack, Empty, DownTunnel(GRAY, CarPosition(4, 0, RIGHT)), Empty)
                row(Empty, UpRightTurn, UpLeftTurn, Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, Obstacle, Obstacle, Obstacle, Empty, FixedDownRightUpFork, EndingTrack)
                row(Empty, DownRightTurn, DownLeftTurn, Empty, Empty, FixedVerticalTrack, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 5, DOWN)), UpLeftTurn, UpRightTurn, FixedHorizontalTrack, Empty, UpTunnel(BROWN, CarPosition(0, 0, RIGHT)), Empty)
            }
        )
        val level2_7 = setOf(
            buildBoard {
                row(Empty, DownTunnel(GRAY, CarPosition(4, 4, UP)), Empty, Empty, DownTunnel(BROWN, CarPosition(4, 1, UP)), Empty, Empty)
                row(Empty, VerticalTrack, Empty, Empty, VerticalTrack, Empty, Empty)
                row(FixedHorizontalTrack, UpLeftDownFork, Empty, FixedHorizontalTrack, UpLeftTurn, DownRightTurn, EndingTrack)
                row(Empty, VerticalTrack, Empty, Empty, DownRightTurn, UpLeftTurn, Empty)
                row(Empty, UpTunnel(BROWN, CarPosition(0, 4, DOWN)), Empty, Empty, UpTunnel(GRAY, CarPosition(0, 1, DOWN)), Empty, Empty)
            },
            buildBoard {
                row(Empty, DownTunnel(GRAY, CarPosition(4, 4, UP)), Empty, Empty, DownTunnel(BROWN, CarPosition(4, 1, UP)), Empty, Empty)
                row(Empty, VerticalTrack, Empty, Empty, UpRightTurn, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, DownLeftUpFork, Empty, FixedHorizontalTrack, DownLeftTurn, UpRightTurn, EndingTrack)
                row(Empty, VerticalTrack, Empty, Empty, VerticalTrack, Empty, Empty)
                row(Empty, UpTunnel(BROWN, CarPosition(0, 4, DOWN)), Empty, Empty, UpTunnel(GRAY, CarPosition(0, 1, DOWN)), Empty, Empty)
            }
        )
        val level2_7A = setOf(
            buildBoard {
                row(Empty, DownTunnel(GRAY, CarPosition(4, 3, UP)), Empty, DownTunnel(PURPLE, CarPosition(4, 5, UP)), Empty, DownTunnel(BROWN, CarPosition(4, 1, UP)), Empty, Empty)
                row(Empty, VerticalTrack, Empty, VerticalTrack, Obstacle, UpRightTurn, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, DownLeftUpFork, FixedHorizontalTrack, DownLeftUpFork, FixedHorizontalTrack, DownLeftTurn, UpRightTurn, EndingTrack)
                row(Empty, VerticalTrack, Empty, VerticalTrack, Obstacle, VerticalTrack, Empty, Empty)
                row(Empty, UpTunnel(BROWN, CarPosition(0, 5, DOWN)), Empty, UpTunnel(GRAY, CarPosition(0, 1, DOWN)), Empty, UpTunnel(PURPLE, CarPosition(0, 3, DOWN)), Empty, Empty)
            },
            buildBoard {
                row(Empty, DownTunnel(GRAY, CarPosition(4, 3, UP)), Empty, DownTunnel(PURPLE, CarPosition(4, 5, UP)), Empty, DownTunnel(BROWN, CarPosition(4, 1, UP)), Empty, Empty)
                row(Empty, Empty, Empty, VerticalTrack, Obstacle, UpRightTurn, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, DownLeftTurn, FixedHorizontalTrack, DownLeftUpFork, FixedHorizontalTrack, DownLeftTurn, UpRightTurn, EndingTrack)
                row(Empty, DownRightUpFork, HorizontalTrack, UpLeftTurn, Obstacle, VerticalTrack, Empty, Empty)
                row(Empty, UpTunnel(BROWN, CarPosition(0, 5, DOWN)), Empty, UpTunnel(GRAY, CarPosition(0, 1, DOWN)), Empty, UpTunnel(PURPLE, CarPosition(0, 3, DOWN)), Empty, Empty)
            }
        )
        val level2_7B = setOf(
            buildBoard {
                row(Empty, Empty, DownTunnel(BROWN, CarPosition(4, 4, UP)), Empty, DownTunnel(GRAY, CarPosition(4, 2, UP)), Empty, Empty, Empty)
                row(Empty, DownRightTurn, UpLeftRightFork, DownLeftTurn, UpRightTurn, HorizontalTrack, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, DownLeftUpFork, FixedHorizontalTrack, UpLeftTurn, FixedHorizontalTrack, DownLeftTurn, UpRightTurn, EndingTrack)
                row(Empty, UpRightTurn, DownLeftTurn, Empty, DownRightTurn, UpLeftTurn, Empty, Empty)
                row(Empty, Empty, UpTunnel(GRAY, CarPosition(0, 4, DOWN)), Empty, UpTunnel(BROWN, CarPosition(0, 2, DOWN)), Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, DownTunnel(color=BROWN, exitPosition=CarPosition(row=4, column=4, direction=UP)), Empty, DownTunnel(color=GRAY, exitPosition=CarPosition(row=4, column=2, direction=UP)), Empty, Empty, Empty)
                row(Empty, DownRightTurn, UpLeftTurn, Empty, UpRightTurn, DownLeftTurn, Empty, Empty)
                row(FixedHorizontalTrack, UpLeftDownFork, FixedHorizontalTrack, DownLeftTurn, FixedHorizontalTrack, UpLeftTurn, DownRightTurn, EndingTrack)
                row(Empty, UpRightTurn, DownLeftRightFork, UpLeftTurn, DownRightTurn, HorizontalTrack, UpLeftTurn, Empty)
                row(Empty, Empty, UpTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=4, direction=DOWN)), Empty, UpTunnel(color=BROWN, exitPosition=CarPosition(row=0, column=2, direction=DOWN)), Empty, Empty, Empty)
            }
        )
        val level2_8 = setOf(
            buildBoard {
                row(Empty, DownRightTurn, HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(FixedHorizontalTrack, UpLeftDownFork, RightTunnel(GRAY, CarPosition(5, 0, RIGHT)), UpLeftTurn, DownRightTurn, FixedHorizontalTrack)
                row(Empty, UpRightTurn, DownLeftRightFork, HorizontalTrack, UpLeftTurn, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(1, 2, RIGHT)), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, EndingTrack)
            }
        )
        val level2_9 = setOf(
            buildBoard {
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, DownTunnel(color=BROWN, exitPosition=CarPosition(row=7, column=0, direction=RIGHT)), Empty)
                row(Empty, Empty, Empty, Empty, VerticalTrack, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, VerticalTrack, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=7, column=4, direction=LEFT)), Empty, Empty, FixedHorizontalTrack, DownLeftUpFork, Empty, DownRightTurn, EndingTrack)
                row(Empty, Empty, Empty, Empty, VerticalTrack, Empty, VerticalTrack, Empty)
                row(Empty, Empty, FixedVerticalTrack, DownRightTurn, UpRightLeftFork, HorizontalTrack, UpLeftTurn, Empty)
                row(Empty, Empty, UpRightTurn, UpLeftTurn, Empty, Empty, Empty, Empty)
                row(RightTunnel(color=BROWN, exitPosition=CarPosition(row=0, column=6, direction=DOWN)), Empty, Empty, Empty, LeftTunnel(color=GRAY, exitPosition=CarPosition(row=3, column=0, direction=RIGHT)), Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, DownTunnel(color=BROWN, exitPosition=CarPosition(row=7, column=0, direction=RIGHT)), Empty)
                row(Empty, Empty, Empty, Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=7, column=4, direction=LEFT)), Empty, DownRightTurn, FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack)
                row(Empty, Empty, VerticalTrack, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty)
                row(Empty, DownRightTurn, UpLeftDownFork, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(color=BROWN, exitPosition=CarPosition(row=0, column=6, direction=DOWN)), UpRightLeftFork, UpLeftTurn, Empty, LeftTunnel(color=GRAY, exitPosition=CarPosition(row=3, column=0, direction=RIGHT)), Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, DownTunnel(color=BROWN, exitPosition=CarPosition(row=7, column=0, direction=RIGHT)), Empty)
                row(Empty, Empty, Empty, Empty, VerticalTrack, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, VerticalTrack, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=7, column=4, direction=LEFT)), Empty, Empty, FixedHorizontalTrack, DownLeftUpFork, Empty, DownRightTurn, EndingTrack)
                row(Empty, Empty, Empty, Empty, VerticalTrack, DownRightTurn, UpLeftTurn, Empty)
                row(Empty, Empty, FixedVerticalTrack, DownRightTurn, UpRightLeftFork, UpLeftTurn, Empty, Empty)
                row(Empty, Empty, UpRightTurn, UpLeftTurn, Empty, Empty, Empty, Empty)
                row(RightTunnel(color=BROWN, exitPosition=CarPosition(row=0, column=6, direction=DOWN)), Empty, Empty, Empty, LeftTunnel(color=GRAY, exitPosition=CarPosition(row=3, column=0, direction=RIGHT)), Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, DownTunnel(color=BROWN, exitPosition=CarPosition(row=7, column=0, direction=RIGHT)), Empty)
                row(Empty, Empty, Empty, Empty, VerticalTrack, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, VerticalTrack, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=7, column=4, direction=LEFT)), Empty, Empty, FixedHorizontalTrack, DownLeftUpFork, DownRightTurn, HorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, VerticalTrack, VerticalTrack, Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, DownRightTurn, UpRightLeftFork, UpLeftTurn, Empty, Empty)
                row(Empty, Empty, UpRightTurn, UpLeftTurn, Empty, Empty, Empty, Empty)
                row(RightTunnel(color=BROWN, exitPosition=CarPosition(row=0, column=6, direction=DOWN)), Empty, Empty, Empty, LeftTunnel(color=GRAY, exitPosition=CarPosition(row=3, column=0, direction=RIGHT)), Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, DownTunnel(BROWN, CarPosition(7, 0, RIGHT)), Empty)
                row(Empty, Empty, Empty, Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(7, 4, LEFT)), HorizontalTrack, HorizontalTrack, FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, VerticalTrack, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(BROWN, CarPosition(0, 6, DOWN)), HorizontalTrack, UpRightLeftFork, HorizontalTrack, LeftTunnel(GRAY, CarPosition(3, 0, RIGHT)), Empty, Empty, Empty)
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
            buildBoard {
                row(FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, true), HorizontalTrack, DownRightLeftFork, HorizontalTrack, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, VerticalToggle(DARK_GREEN), Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalTrack, Empty, Empty, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty)
            }
        )
        val level3_2 = setOf(
            buildBoard {
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(DARK_GREEN, true), Empty, Empty)
                row(Empty, Empty, DownRightTurn, UpRightLeftFork, DownLeftTurn, Empty)
                row(Empty, Empty, UpRightTurn, DownLeftTurn, VerticalTrack, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalToggle(DARK_GREEN), UpLeftTurn, UpRightTurn, EndingTrack)
            }
        )
        val level3_3 = setOf(
            buildBoard {
                row(DownRightTurn, HorizontalBarrier(color=DARK_GREEN, open=false), FixedHorizontalTrack, DownRightTurn, FixedDownLeftRightFork, FixedHorizontalTrack)
                row(UpRightTurn, DownRightLeftFork, DownRightLeftFork, UpLeftTurn, VerticalToggle(DARK_GREEN), Empty)
                row(Empty, UpRightTurn, UpLeftTurn, Empty, FixedUpRightTurn, EndingTrack)
            },
            buildBoard {
                row(DownRightTurn, HorizontalBarrier(DARK_GREEN, false), FixedHorizontalTrack, DownRightTurn, FixedDownLeftRightFork, FixedHorizontalTrack)
                row(UpRightTurn, HorizontalTrack, DownRightLeftFork, UpLeftDownFork, VerticalToggle(DARK_GREEN), Empty)
                row(Empty, Empty, UpRightTurn, UpLeftTurn, FixedUpRightTurn, EndingTrack)
            },
            buildBoard {
                row(DownRightTurn, HorizontalBarrier(color=DARK_GREEN, open=false), FixedHorizontalTrack, DownRightTurn, FixedDownLeftRightFork, FixedHorizontalTrack)
                row(DownRightUpFork, DownRightLeftFork, HorizontalTrack, UpLeftTurn, VerticalToggle(DARK_GREEN), Empty)
                row(UpRightTurn, UpLeftTurn, Empty, Empty, FixedUpRightTurn, EndingTrack)
            }
        )
        val level3_3A = setOf(
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, DownLeftTurn, Empty)
                row(Empty, Empty, Empty, DownRightUpFork, UpLeftTurn, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(DownRightTurn, DownLeftTurn, Empty, VerticalBarrier(DARK_GREEN, false), Empty, Empty)
                row(UpRightTurn, UpRightLeftFork, FixedHorizontalTrack, UpRightLeftFork, HorizontalToggle(DARK_GREEN), EndingTrack)
            },
            buildBoard {
                row(Empty, Empty, DownRightTurn, DownLeftTurn, Empty, Empty)
                row(Empty, Empty, UpRightTurn, DownLeftUpFork, Empty, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(DownRightTurn, DownLeftTurn, Empty, VerticalBarrier(color=DARK_GREEN, open=false), Empty, Empty)
                row(UpRightTurn, UpRightLeftFork, FixedHorizontalTrack, UpRightLeftFork, HorizontalToggle(DARK_GREEN), EndingTrack)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightTurn, DownLeftTurn, Empty, Empty)
                row(Empty, Empty, VerticalTrack, FixedVerticalTrack, Empty, Empty)
                row(DownRightTurn, DownLeftRightFork, UpLeftTurn, VerticalBarrier(color=DARK_GREEN, open=false), Empty, Empty)
                row(UpRightTurn, UpRightLeftFork, FixedHorizontalTrack, HorizontalTrack, HorizontalToggle(DARK_GREEN), EndingTrack)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, DownRightTurn, HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(Empty, VerticalTrack, Empty, FixedVerticalTrack, Empty, Empty)
                row(DownRightTurn, DownLeftUpFork, Empty, VerticalBarrier(color=DARK_GREEN, open=false), Empty, Empty)
                row(UpRightTurn, UpRightLeftFork, FixedHorizontalTrack, HorizontalTrack, HorizontalToggle(DARK_GREEN), EndingTrack)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightTurn, DownLeftTurn, Empty, Empty)
                row(Empty, DownRightTurn, UpLeftTurn, FixedVerticalTrack, Empty, Empty)
                row(DownRightTurn, DownLeftUpFork, Empty, VerticalBarrier(color=DARK_GREEN, open=false), Empty, Empty)
                row(UpRightTurn, UpRightLeftFork, FixedHorizontalTrack, HorizontalTrack, HorizontalToggle(DARK_GREEN), EndingTrack)
            }
        )
        val level3_4 = setOf(
            buildBoard {
                row(FixedHorizontalTrack, DownLeftTurn, Empty, Empty, Empty, DownRightTurn, HorizontalBarrier(color=DARK_GREEN, open=true), FixedDownLeftTurn)
                row(DownRightTurn, UpLeftTurn, Empty, Empty, Empty, VerticalTrack, FixedDownRightTurn, FixedUpLeftTurn)
                row(DownRightUpFork, HorizontalToggle(DARK_GREEN), DownRightLeftFork, HorizontalTrack, HorizontalToggle(DARK_GREEN), UpLeftTurn, FixedUpRightTurn, FixedDownLeftTurn)
                row(UpRightDownFork, HorizontalTrack, UpLeftTurn, Empty, Empty, Empty, FixedDownRightTurn, FixedUpLeftTurn)
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty, FixedUpRightTurn, EndingTrack)
            },
            buildBoard {
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty, DownRightTurn, HorizontalBarrier(DARK_GREEN, true), FixedDownLeftTurn)
                row(Empty, Empty, DownRightTurn, UpLeftTurn, Empty, VerticalTrack, FixedDownRightTurn, FixedUpLeftTurn)
                row(DownRightTurn, HorizontalToggle(DARK_GREEN), UpRightLeftFork, HorizontalTrack, HorizontalToggle(DARK_GREEN), UpLeftTurn, FixedUpRightTurn, FixedDownLeftTurn)
                row(VerticalTrack, Empty, Empty, Empty, Empty, Empty, FixedDownRightTurn, FixedUpLeftTurn)
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty, FixedUpRightTurn, EndingTrack)
            },
            buildBoard {
                row(FixedHorizontalTrack, DownLeftTurn, Empty, Empty, Empty, DownRightTurn, HorizontalBarrier(color=DARK_GREEN, open=true), FixedDownLeftTurn)
                row(DownRightTurn, UpLeftTurn, Empty, Empty, Empty, VerticalTrack, FixedDownRightTurn, FixedUpLeftTurn)
                row(UpRightTurn, HorizontalToggle(DARK_GREEN), DownRightLeftFork, HorizontalTrack, HorizontalToggle(DARK_GREEN), UpLeftTurn, FixedUpRightTurn, FixedDownLeftTurn)
                row(DownRightTurn, HorizontalTrack, UpLeftTurn, Empty, Empty, Empty, FixedDownRightTurn, FixedUpLeftTurn)
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty, FixedUpRightTurn, EndingTrack)
            },
        )
        val level3_5 = setOf(
            buildBoard {
                row(FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, false), HorizontalTrack, HorizontalTrack, HorizontalBarrier(DARK_GREEN, true), DownLeftTurn, Empty)
                row(DownRightTurn, DownLeftTurn, Empty, Empty, Empty, VerticalTrack, Empty)
                row(UpRightTurn, UpRightLeftFork, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, true), UpRightLeftFork, EndingTrack)
            }
        )
        val level3_6 = setOf(
            buildBoard {
                row(DownRightTurn, DownRightLeftFork, FixedHorizontalTrack, HorizontalToggle(DARK_GREEN), DownLeftTurn, Empty, Empty, Empty)
                row(UpRightTurn, UpLeftTurn, Empty, Empty, VerticalBarrier(DARK_GREEN, false), Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, UpRightDownFork, HorizontalToggle(DARK_GREEN), HorizontalBarrier(DARK_GREEN, true), EndingTrack)
                row(Empty, Empty, Empty, Empty, VerticalToggle(DARK_GREEN), Empty, Empty, Empty)
                row(Empty, Empty, FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, false), UpLeftTurn, Empty, Empty, Empty)
            }
        )
        val level3_7 = setOf(
            buildBoard {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, HorizontalBarrier(LIGHT_GREEN, true), HorizontalToggle(DARK_GREEN), FixedHorizontalTrack)
                row(DownRightUpFork, FixedHorizontalTrack, EndingTrack, FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack)
                row(UpRightTurn, HorizontalTrack, HorizontalBarrier(DARK_GREEN, true), DownLeftRightToggle(LIGHT_GREEN), DownLeftRightFork, FixedHorizontalTrack)
                row(Empty, Empty, Empty, UpRightTurn, UpLeftTurn, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, Empty, Empty)
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, HorizontalBarrier(color=LIGHT_GREEN, open=true), HorizontalToggle(DARK_GREEN), FixedHorizontalTrack)
                row(DownRightUpFork, FixedHorizontalTrack, EndingTrack, FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack)
                row(UpRightDownFork, DownLeftRightFork, HorizontalBarrier(color=DARK_GREEN, open=true), DownLeftRightToggle(LIGHT_GREEN), HorizontalTrack, FixedHorizontalTrack)
                row(UpRightTurn, UpLeftTurn, Empty, Empty, Empty, Empty)
            }
        )
        val level3_7A = setOf(
            buildBoard {
                row(Empty, DownRightTurn, HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrier(DARK_GREEN, true), EndingTrack)
                row(Empty, UpRightDownFork, HorizontalToggle(LIGHT_GREEN), HorizontalTrack, FixedHorizontalTrack)
                row(DownRightTurn, UpRightLeftFork, HorizontalToggle(DARK_GREEN), DownLeftRightFork, DownLeftTurn)
                row(FixedVerticalTrack, Empty, Empty, UpRightTurn, UpLeftTurn)
            }
        )
        val level3_8 = setOf(
            buildBoard {
                row(Empty, FixedVerticalTrack, Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, UpRightTurn, DownLeftTurn, Empty, FixedVerticalTrack, Empty)
                row(DownRightTurn, DownLeftTurn, VerticalTrack, Empty, VerticalBarrier(color=DARK_GREEN, open=true), Empty)
                row(VerticalToggle(PINK), VerticalToggle(LIGHT_GREEN), VerticalToggle(DARK_GREEN), Empty, VerticalBarrier(color=LIGHT_GREEN, open=true), Empty)
                row(UpRightTurn, DownLeftUpFork, DownRightUpFork, DownLeftTurn, VerticalBarrier(color=PINK, open=true), Empty)
                row(Empty, UpRightTurn, UpLeftTurn, UpRightTurn, FixedUpRightLeftFork, EndingTrack)
            },
            buildBoard {
                row(Empty, FixedVerticalTrack, Empty, Empty, FixedVerticalTrack, Empty)
                row(DownRightTurn, DownLeftUpFork, Empty, Empty, FixedVerticalTrack, Empty)
                row(VerticalTrack, UpRightDownFork, DownLeftTurn, Empty, VerticalBarrier(color=DARK_GREEN, open=true), Empty)
                row(VerticalToggle(PINK), VerticalToggle(LIGHT_GREEN), VerticalToggle(DARK_GREEN), Empty, VerticalBarrier(color=LIGHT_GREEN, open=true), Empty)
                row(VerticalTrack, UpRightTurn, UpLeftTurn, Empty, VerticalBarrier(color=PINK, open=true), Empty)
                row(UpRightTurn, HorizontalTrack, HorizontalTrack, HorizontalTrack, FixedUpRightLeftFork, EndingTrack)
            },
            buildBoard {
                row(Empty, FixedVerticalTrack, Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, UpRightTurn, DownLeftTurn, Empty, FixedVerticalTrack, Empty)
                row(DownRightTurn, DownLeftTurn, DownRightUpFork, DownLeftTurn, VerticalBarrier(color=DARK_GREEN, open=false), Empty)
                row(VerticalToggle(PINK), VerticalToggle(LIGHT_GREEN), VerticalToggle(DARK_GREEN), VerticalTrack, VerticalBarrier(color=LIGHT_GREEN, open=true), Empty)
                row(UpRightTurn, UpRightLeftFork, UpLeftTurn, VerticalTrack, VerticalBarrier(color=PINK, open=true), Empty)
                row(Empty, Empty, Empty, UpRightTurn, FixedUpRightLeftFork, EndingTrack)
            },
            buildBoard {
                row(Empty, FixedVerticalTrack, Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, UpRightTurn, DownLeftTurn, Empty, FixedVerticalTrack, Empty)
                row(DownRightTurn, DownLeftTurn, VerticalTrack, Empty, VerticalBarrier(DARK_GREEN, true), Empty)
                row(VerticalToggle(PINK), VerticalToggle(LIGHT_GREEN), VerticalToggle(DARK_GREEN), Empty, VerticalBarrier(LIGHT_GREEN, true), Empty)
                row(VerticalTrack, UpRightTurn, UpLeftTurn, Empty, VerticalBarrier(PINK, true), Empty)
                row(UpRightTurn, HorizontalTrack, HorizontalTrack, HorizontalTrack, FixedUpRightLeftFork, EndingTrack)
            }
        )
        val level3_8A = setOf(
            buildBoard {
                row(DownRightTurn, FixedHorizontalTrack, DownRightTurn, HorizontalBarrier(DARK_GREEN, true), HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrier(PINK, true), EndingTrack)
                row(VerticalTrack, Empty, VerticalTrack, Empty, DownRightTurn, HorizontalTrack, DownLeftTurn)
                row(UpRightTurn, HorizontalToggle(PINK), UpRightLeftFork, HorizontalToggle(LIGHT_GREEN), UpLeftRightFork, HorizontalToggle(DARK_GREEN), UpLeftTurn)
            }
        )
        val level3_8B = setOf(
            buildBoard {
                row(Empty, Empty, HorizontalToggle(DARK_GREEN), DownRightTurn, HorizontalToggle(Color.PURPLE), DownLeftTurn, HorizontalToggle(DARK_GREEN), Empty, HorizontalToggle(Color.PURPLE), Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn, Obstacle, VerticalToggle(DARK_GREEN), Obstacle, VerticalToggle(LIGHT_GREEN), Obstacle, VerticalToggle(PINK), Obstacle, DownRightTurn, LeftTunnel(BROWN, CarPosition(4, 0, RIGHT)))
                row(Empty, UpRightTurn, HorizontalToggle(LIGHT_GREEN), UpLeftTurn, HorizontalToggle(PINK), UpRightTurn, HorizontalToggle(LIGHT_GREEN), HorizontalTrack, HorizontalToggle(PINK), UpLeftTurn, Empty)
                row(Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle)
                row(RightTunnel(BROWN, CarPosition(1, 10, LEFT)), FixedHorizontalTrack, HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrier(DARK_GREEN, true), HorizontalBarrier(Color.PURPLE, true), HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrier(DARK_GREEN, true), HorizontalBarrier(Color.PURPLE, true), HorizontalBarrier(PINK, true), FixedHorizontalTrack, EndingTrack)
            },
            buildBoard {
                row(Empty, DownRightTurn, HorizontalToggle(DARK_GREEN), DownLeftTurn, HorizontalToggle(Color.PURPLE), DownRightTurn, HorizontalToggle(DARK_GREEN), HorizontalTrack, HorizontalToggle(Color.PURPLE), DownLeftTurn, Empty)
                row(FixedHorizontalTrack, UpLeftTurn, Obstacle, VerticalToggle(DARK_GREEN), Obstacle, VerticalToggle(LIGHT_GREEN), Obstacle, VerticalToggle(PINK), Obstacle, UpRightTurn, LeftTunnel(BROWN, CarPosition(4, 0, RIGHT)))
                row(Empty, Empty, HorizontalToggle(LIGHT_GREEN), UpRightTurn, HorizontalToggle(PINK), UpLeftTurn, HorizontalToggle(LIGHT_GREEN), Empty, HorizontalToggle(PINK), Empty, Empty)
                row(Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle)
                row(RightTunnel(BROWN, CarPosition(1, 10, LEFT)), FixedHorizontalTrack, HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrier(DARK_GREEN, true), HorizontalBarrier(Color.PURPLE, true), HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrier(DARK_GREEN, true), HorizontalBarrier(Color.PURPLE, true), HorizontalBarrier(PINK, true), FixedHorizontalTrack, EndingTrack)
            }
        )
        val level3_9 = setOf(
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, DownLeftTurn, Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), UpRightTurn, DownLeftTurn, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, DownLeftTurn, VerticalToggle(LIGHT_GREEN), Empty, VerticalToggle(DARK_GREEN), Empty, Empty)
                row(Empty, Empty, UpRightTurn, UpLeftTurn, DownRightTurn, UpRightLeftFork, HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), HorizontalTrack, DownLeftTurn, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalTrack, VerticalToggle(PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpRightTurn, UpLeftTurn, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), Empty, VerticalTrack, Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn, Empty, VerticalToggle(LIGHT_GREEN), Empty, VerticalToggle(DARK_GREEN), Empty, Empty)
                row(Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, DownRightTurn, UpRightLeftFork, HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), HorizontalTrack, DownLeftTurn, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalTrack, VerticalToggle(PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpRightTurn, UpLeftTurn, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), Empty, VerticalTrack, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, DownLeftTurn, VerticalToggle(LIGHT_GREEN), Empty, VerticalToggle(DARK_GREEN), Empty, Empty)
                row(Empty, Empty, UpRightTurn, UpLeftTurn, DownRightTurn, UpRightLeftFork, HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), DownLeftTurn, Empty, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn, DownLeftTurn, VerticalToggle(PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpRightTurn, UpLeftTurn, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, DownLeftTurn, Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), UpRightTurn, DownLeftTurn, Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn, Empty, VerticalToggle(LIGHT_GREEN), Empty, VerticalToggle(DARK_GREEN), Empty, Empty)
                row(Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, DownRightTurn, UpRightLeftFork, HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), DownLeftTurn, Empty, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, VerticalTrack, Empty, VerticalToggle(PINK), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, DownLeftTurn, Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), UpRightTurn, DownLeftTurn, Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn, Empty, VerticalToggle(LIGHT_GREEN), Empty, VerticalToggle(DARK_GREEN), Empty, Empty)
                row(Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, DownRightTurn, UpRightLeftFork, HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), HorizontalTrack, DownLeftTurn, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalTrack, VerticalToggle(PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpRightTurn, UpLeftTurn, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, DownLeftTurn, Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), UpRightTurn, DownLeftTurn, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, DownLeftTurn, VerticalToggle(LIGHT_GREEN), Empty, VerticalToggle(DARK_GREEN), Empty, Empty)
                row(Empty, Empty, UpRightTurn, UpLeftTurn, DownRightTurn, UpRightLeftFork, HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), DownLeftTurn, Empty, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn, DownLeftTurn, VerticalToggle(PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpRightTurn, UpLeftTurn, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, DownLeftTurn, Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), UpRightTurn, DownLeftTurn, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, DownLeftTurn, VerticalToggle(LIGHT_GREEN), Empty, VerticalToggle(DARK_GREEN), Empty, Empty)
                row(Empty, Empty, UpRightTurn, UpLeftTurn, DownRightTurn, UpRightLeftFork, HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), DownLeftTurn, Empty, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, VerticalTrack, Empty, VerticalToggle(PINK), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, DownLeftTurn, Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), UpRightTurn, DownLeftTurn, Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn, Empty, VerticalToggle(LIGHT_GREEN), Empty, VerticalToggle(DARK_GREEN), Empty, Empty)
                row(Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, DownRightTurn, UpRightLeftFork, HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), DownLeftTurn, Empty, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn, DownLeftTurn, VerticalToggle(PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpRightTurn, UpLeftTurn, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), Empty, VerticalTrack, Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn, Empty, VerticalToggle(LIGHT_GREEN), Empty, VerticalToggle(DARK_GREEN), Empty, Empty)
                row(Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, DownRightTurn, UpRightLeftFork, HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), DownLeftTurn, Empty, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, VerticalTrack, Empty, VerticalToggle(PINK), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), Empty, VerticalTrack, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, DownLeftTurn, VerticalToggle(LIGHT_GREEN), Empty, VerticalToggle(DARK_GREEN), Empty, Empty)
                row(Empty, Empty, UpRightTurn, UpLeftTurn, DownRightTurn, UpRightLeftFork, HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), DownLeftTurn, Empty, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, VerticalTrack, Empty, VerticalToggle(PINK), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), Empty, VerticalTrack, Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn, Empty, VerticalToggle(LIGHT_GREEN), Empty, VerticalToggle(DARK_GREEN), Empty, Empty)
                row(Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, DownRightTurn, UpRightLeftFork, HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), DownLeftTurn, Empty, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn, DownLeftTurn, VerticalToggle(PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpRightTurn, UpLeftTurn, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(Empty, Empty, Empty, VerticalBarrier(color = PINK, open = true), Empty, VerticalTrack, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, DownLeftTurn, VerticalToggle(LIGHT_GREEN), Empty, VerticalToggle(DARK_GREEN), Empty, Empty)
                row(Empty, Empty, UpRightTurn, UpLeftTurn, DownRightTurn, UpRightLeftFork, HorizontalBarrier(color = DARK_GREEN, open = true), EndingTrack)
                row(FixedHorizontalTrack, HorizontalBarrier(color = LIGHT_GREEN, open = true), HorizontalTrack, DownLeftTurn, VerticalBarrier(color = DARK_GREEN, open = true), Empty, Empty, Empty)
                row(Empty, Empty, Empty, VerticalTrack, VerticalToggle(PINK), Empty, Empty, Empty)
                row(Empty, Empty, Empty, UpRightTurn, UpLeftTurn, Empty, Empty, Empty)
            }
        )
        val level3_10 = setOf(
            buildBoard {
                row(DownTunnel(BROWN, CarPosition(4, 3, RIGHT)), Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty)
                row(UpRightDownFork, DownLeftTurn, Empty, Empty, VerticalTrack, Empty, Empty, Empty)
                row(VerticalToggle(DARK_GREEN), VerticalTrack, Empty, Empty, VerticalTrack, Empty, Empty, Empty)
                row(UpRightTurn, UpLeftTurn, Empty, Empty, DownRightUpFork, HorizontalTrack, HorizontalBarrier(DARK_GREEN, true), EndingTrack)
                row(Empty, Empty, Empty, RightTunnel(BROWN, CarPosition(0, 0, DOWN)), UpLeftTurn, Empty, Empty, Empty)
            }
        )
        val level3_10A = setOf(
            buildBoard {
                row(Empty, DownTunnel(BROWN, CarPosition(4, 3, LEFT)), Empty, RightTunnel(GRAY, CarPosition(4, 1, RIGHT)), DownLeftRightFork, HorizontalToggle(DARK_GREEN), DownLeftTurn)
                row(DownRightTurn, UpLeftTurn, Empty, Empty, UpRightTurn, HorizontalTrack, UpLeftTurn)
                row(UpRightTurn, FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrier(DARK_GREEN, true), EndingTrack)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, RightTunnel(GRAY, CarPosition(0, 3, RIGHT)), HorizontalToggle(LIGHT_GREEN), LeftTunnel(BROWN, CarPosition(0, 1, DOWN)), Empty, Empty, Empty)
            }
        )
        val level3_10B = setOf(
            buildBoard {
                row(FixedVerticalTrack, Empty, Empty, DownTunnel(BROWN, CarPosition(5, 3, LEFT)), Empty, Empty, Empty)
                row(FixedUpRightTurn, HorizontalBarrier(DARK_GREEN, true), HorizontalTrack, UpLeftTurn, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightTurn, FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack)
                row(Empty, DownRightTurn, UpLeftDownFork, Empty, Empty, Empty, Empty)
                row(Empty, VerticalTrack, UpRightDownFork, LeftTunnel(BROWN, CarPosition(0, 3, DOWN)), Empty, Empty, Empty)
                row(Empty, UpRightToggle(DARK_GREEN), UpLeftTurn, Empty, Empty, Empty, Empty)
            },
            buildBoard {
                row(FixedVerticalTrack, Empty, Empty, DownTunnel(color=BROWN, exitPosition=CarPosition(row=5, column=3, direction=LEFT)), Empty, Empty, Empty)
                row(FixedUpRightTurn, HorizontalBarrier(color=DARK_GREEN, open=true), HorizontalTrack, UpLeftTurn, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, DownRightTurn, HorizontalTrack, FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack)
                row(Empty, VerticalTrack, Empty, Empty, Empty, Empty, Empty)
                row(Empty, UpRightDownFork, DownLeftRightFork, LeftTunnel(color=BROWN, exitPosition=CarPosition(row=0, column=3, direction=DOWN)), Empty, Empty, Empty)
                row(Empty, UpRightToggle(DARK_GREEN), UpLeftTurn, Empty, Empty, Empty, Empty)
            },
            buildBoard {
                row(FixedVerticalTrack, Empty, Empty, DownTunnel(color=BROWN, exitPosition=CarPosition(row=5, column=3, direction=LEFT)), Empty, Empty, Empty)
                row(FixedUpRightTurn, HorizontalBarrier(color=DARK_GREEN, open=true), HorizontalTrack, UpLeftTurn, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightTurn, FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack)
                row(Empty, DownRightTurn, UpLeftTurn, Empty, Empty, Empty, Empty)
                row(Empty, UpRightDownFork, DownLeftRightFork, LeftTunnel(color=BROWN, exitPosition=CarPosition(row=0, column=3, direction=DOWN)), Empty, Empty, Empty)
                row(Empty, UpRightToggle(DARK_GREEN), UpLeftTurn, Empty, Empty, Empty, Empty)
            }
        )
        val level3_10C = setOf(
            buildBoard {
                row(RightTunnel(color=GREEN, exitPosition=CarPosition(row=1, column=4, direction=DOWN)), DownLeftRightFork, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, HorizontalToggle(PINK), HorizontalTrack, LeftTunnel(color=GRAY, exitPosition=CarPosition(row=6, column=0, direction=RIGHT)))
                row(Empty, UpRightTurn, DownLeftTurn, Empty, DownTunnel(color=GREEN, exitPosition=CarPosition(row=0, column=0, direction=RIGHT)), Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightUpFork, DownRightLeftFork, UpLeftTurn, Empty, Empty, Empty, Empty)
                row(RightTunnel(color=BROWN, exitPosition=CarPosition(row=6, column=8, direction=LEFT)), FixedHorizontalTrack, UpLeftTurn, UpRightTurn, DownRightLeftFork, HorizontalBarrier(color=DARK_GREEN, open=true), HorizontalBarrier(color=LIGHT_GREEN, open=true), HorizontalBarrier(color=PINK, open=true), EndingTrack)
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=8, direction=LEFT)), HorizontalTrack, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, HorizontalToggle(LIGHT_GREEN), FixedHorizontalTrack, HorizontalToggle(PINK), HorizontalTrack, LeftTunnel(color=BROWN, exitPosition=CarPosition(row=3, column=0, direction=RIGHT)))
            },
            buildBoard {
                row(RightTunnel(color=GREEN, exitPosition=CarPosition(row=1, column=4, direction=DOWN)), HorizontalTrack, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, HorizontalToggle(PINK), HorizontalTrack, LeftTunnel(color=GRAY, exitPosition=CarPosition(row=6, column=0, direction=RIGHT)))
                row(Empty, Empty, Empty, Empty, DownTunnel(color=GREEN, exitPosition=CarPosition(row=0, column=0, direction=RIGHT)), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, DownRightTurn, UpLeftTurn, Empty, Empty, Empty, Empty)
                row(RightTunnel(color=BROWN, exitPosition=CarPosition(row=6, column=8, direction=LEFT)), FixedHorizontalTrack, HorizontalTrack, UpLeftTurn, DownRightTurn, HorizontalBarrier(color=DARK_GREEN, open=true), HorizontalBarrier(color=LIGHT_GREEN, open=true), HorizontalBarrier(color=PINK, open=true), EndingTrack)
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, UpRightTurn, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=8, direction=LEFT)), HorizontalTrack, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, HorizontalToggle(LIGHT_GREEN), FixedHorizontalTrack, HorizontalToggle(PINK), UpLeftTurn, LeftTunnel(color=BROWN, exitPosition=CarPosition(row=3, column=0, direction=RIGHT)))
            },
            buildBoard {
                row(RightTunnel(color=GREEN, exitPosition=CarPosition(row=1, column=4, direction=DOWN)), DownRightTurn, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, HorizontalToggle(PINK), HorizontalTrack, LeftTunnel(color=GRAY, exitPosition=CarPosition(row=6, column=0, direction=RIGHT)))
                row(Empty, VerticalTrack, Empty, Empty, DownTunnel(color=GREEN, exitPosition=CarPosition(row=0, column=0, direction=RIGHT)), Empty, Empty, Empty, Empty)
                row(Empty, UpRightTurn, DownLeftTurn, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(color=BROWN, exitPosition=CarPosition(row=6, column=8, direction=LEFT)), FixedHorizontalTrack, UpLeftTurn, Empty, DownRightTurn, HorizontalBarrier(color=DARK_GREEN, open=true), HorizontalBarrier(color=LIGHT_GREEN, open=true), HorizontalBarrier(color=PINK, open=true), EndingTrack)
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, UpRightTurn, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=8, direction=LEFT)), HorizontalTrack, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, HorizontalToggle(LIGHT_GREEN), FixedHorizontalTrack, HorizontalToggle(PINK), UpLeftTurn, LeftTunnel(color=BROWN, exitPosition=CarPosition(row=3, column=0, direction=RIGHT)))
            },
            buildBoard {
                row(RightTunnel(color=GREEN, exitPosition=CarPosition(row=1, column=4, direction=DOWN)), HorizontalTrack, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, HorizontalToggle(PINK), HorizontalTrack, LeftTunnel(color=GRAY, exitPosition=CarPosition(row=6, column=0, direction=RIGHT)))
                row(Empty, Empty, Empty, Empty, DownTunnel(color=GREEN, exitPosition=CarPosition(row=0, column=0, direction=RIGHT)), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, DownRightTurn, UpLeftTurn, Empty, Empty, Empty, Empty)
                row(RightTunnel(color=BROWN, exitPosition=CarPosition(row=6, column=8, direction=LEFT)), FixedHorizontalTrack, DownLeftTurn, UpRightTurn, DownRightLeftFork, HorizontalBarrier(color=DARK_GREEN, open=true), HorizontalBarrier(color=LIGHT_GREEN, open=true), HorizontalBarrier(color=PINK, open=true), EndingTrack)
                row(Empty, DownRightTurn, UpLeftDownFork, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty)
                row(Empty, UpRightTurn, UpLeftTurn, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=8, direction=LEFT)), HorizontalTrack, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, HorizontalToggle(LIGHT_GREEN), FixedHorizontalTrack, HorizontalToggle(PINK), HorizontalTrack, LeftTunnel(color=BROWN, exitPosition=CarPosition(row=3, column=0, direction=RIGHT)))
            },
            buildBoard {
                row(RightTunnel(color=GREEN, exitPosition=CarPosition(row=1, column=4, direction=DOWN)), HorizontalTrack, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, HorizontalToggle(PINK), HorizontalTrack, LeftTunnel(color=GRAY, exitPosition=CarPosition(row=6, column=0, direction=RIGHT)))
                row(Empty, Empty, Empty, Empty, DownTunnel(color=GREEN, exitPosition=CarPosition(row=0, column=0, direction=RIGHT)), Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, DownRightTurn, UpLeftTurn, Empty, Empty, Empty, Empty)
                row(RightTunnel(color=BROWN, exitPosition=CarPosition(row=6, column=8, direction=LEFT)), FixedHorizontalTrack, DownLeftTurn, UpRightTurn, DownRightLeftFork, HorizontalBarrier(color=DARK_GREEN, open=true), HorizontalBarrier(color=LIGHT_GREEN, open=true), HorizontalBarrier(color=PINK, open=true), EndingTrack)
                row(Empty, Empty, UpRightDownFork, DownLeftTurn, FixedVerticalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn, UpLeftTurn, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=8, direction=LEFT)), HorizontalTrack, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, HorizontalToggle(LIGHT_GREEN), FixedHorizontalTrack, HorizontalToggle(PINK), HorizontalTrack, LeftTunnel(color=BROWN, exitPosition=CarPosition(row=3, column=0, direction=RIGHT)))
            },
            buildBoard {
                row(RightTunnel(color=GREEN, exitPosition=CarPosition(row=1, column=4, direction=DOWN)), DownRightTurn, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, HorizontalToggle(PINK), HorizontalTrack, LeftTunnel(color=GRAY, exitPosition=CarPosition(row=6, column=0, direction=RIGHT)))
                row(Empty, UpRightTurn, DownLeftTurn, Empty, DownTunnel(color=GREEN, exitPosition=CarPosition(row=0, column=0, direction=RIGHT)), Empty, Empty, Empty, Empty)
                row(Empty, Empty, VerticalTrack, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(color=BROWN, exitPosition=CarPosition(row=6, column=8, direction=LEFT)), FixedHorizontalTrack, UpLeftTurn, Empty, DownRightTurn, HorizontalBarrier(color=DARK_GREEN, open=true), HorizontalBarrier(color=LIGHT_GREEN, open=true), HorizontalBarrier(color=PINK, open=true), EndingTrack)
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, UpRightTurn, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=8, direction=LEFT)), HorizontalTrack, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, HorizontalToggle(LIGHT_GREEN), FixedHorizontalTrack, HorizontalToggle(PINK), UpLeftTurn, LeftTunnel(color=BROWN, exitPosition=CarPosition(row=3, column=0, direction=RIGHT)))
            },
            buildBoard {
                row(RightTunnel(color=GREEN, exitPosition=CarPosition(row=1, column=4, direction=DOWN)), HorizontalTrack, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, HorizontalToggle(PINK), HorizontalTrack, LeftTunnel(color=GRAY, exitPosition=CarPosition(row=6, column=0, direction=RIGHT)))
                row(Empty, Empty, Empty, Empty, DownTunnel(color=GREEN, exitPosition=CarPosition(row=0, column=0, direction=RIGHT)), Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightTurn, HorizontalTrack, UpLeftTurn, Empty, Empty, Empty, Empty)
                row(RightTunnel(color=BROWN, exitPosition=CarPosition(row=6, column=8, direction=LEFT)), FixedHorizontalTrack, UpLeftTurn, Empty, DownRightTurn, HorizontalBarrier(color=DARK_GREEN, open=true), HorizontalBarrier(color=LIGHT_GREEN, open=true), HorizontalBarrier(color=PINK, open=true), EndingTrack)
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, UpRightTurn, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=0, column=8, direction=LEFT)), HorizontalTrack, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, HorizontalToggle(LIGHT_GREEN), FixedHorizontalTrack, HorizontalToggle(PINK), UpLeftTurn, LeftTunnel(color=BROWN, exitPosition=CarPosition(row=3, column=0, direction=RIGHT)))
            },
            buildBoard {
                row(RightTunnel(GREEN, CarPosition(1, 4, DOWN)), HorizontalTrack, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, HorizontalToggle(PINK), HorizontalTrack, LeftTunnel(GRAY, CarPosition(6, 0, RIGHT)))
                row(Empty, DownRightTurn, DownLeftTurn, Empty, DownTunnel(GREEN, CarPosition(0, 0, RIGHT)), Empty, Empty, Empty, Empty)
                row(Empty, UpRightTurn, DownLeftUpFork, DownRightTurn, UpLeftTurn, Empty, Empty, Empty, Empty)
                row(RightTunnel(BROWN, CarPosition(6, 8, LEFT)), FixedHorizontalTrack, UpLeftTurn, UpRightTurn, DownRightLeftFork, HorizontalBarrier(DARK_GREEN, true), HorizontalBarrier(LIGHT_GREEN, true), HorizontalBarrier(PINK, true), EndingTrack)
                row(Empty, Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 8, LEFT)), HorizontalTrack, HorizontalToggle(DARK_GREEN), FixedHorizontalTrack, HorizontalToggle(LIGHT_GREEN), FixedHorizontalTrack, HorizontalToggle(PINK), HorizontalTrack, LeftTunnel(BROWN, CarPosition(3, 0, RIGHT)))
            }
        )
        val level3_11 = setOf(
            buildBoard {
                row(Empty, Empty, DownTunnel(BROWN, CarPosition(4, 4, UP)), Empty, DownTunnel(GRAY, CarPosition(4, 2, UP)), Empty, Empty)
                row(Empty, Empty, UpRightDownFork, DownLeftTurn, VerticalToggle(DARK_GREEN), Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn, UpRightTurn, UpLeftTurn, FixedDownRightUpFork, FixedHorizontalTrack, EndingTrack)
                row(Empty, UpRightTurn, DownLeftTurn, Empty, VerticalBarrier(DARK_GREEN, true), Empty, Empty)
                row(Empty, Empty, UpTunnel(GRAY, CarPosition(0, 4, DOWN)), Empty, UpTunnel(BROWN, CarPosition(0, 2, DOWN)), Empty, Empty)
            },
        )
        val level3_11A = setOf(
            buildBoard {
                row(Empty, Empty, Empty, Empty, DownTunnel(BROWN, CarPosition(4, 4, UP)), Empty, Empty, Empty)
                row(Empty, Empty, Empty, DownRightTurn, DownLeftUpFork, Empty, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalToggle(LIGHT_GREEN), DownLeftUpFork, UpRightTurn, HorizontalBarrier(LIGHT_GREEN, true), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, UpRightTurn, DownLeftTurn, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, UpTunnel(BROWN, CarPosition(0, 4, DOWN)), Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, DownTunnel(color=BROWN, exitPosition=CarPosition(row=4, column=4, direction=UP)), Empty, Empty, Empty)
                row(Empty, Empty, Empty, DownRightTurn, UpLeftTurn, Empty, Empty, Empty)
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalToggle(LIGHT_GREEN), UpLeftDownFork, DownRightTurn, HorizontalBarrier(color=LIGHT_GREEN, open=true), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, UpRightTurn, UpLeftDownFork, Empty, Empty, Empty)
                row(Empty, Empty, Empty, Empty, UpTunnel(color=BROWN, exitPosition=CarPosition(row=0, column=4, direction=DOWN)), Empty, Empty, Empty)
            }
        )
        val level3_11B = setOf(
            buildBoard {
                row(DownRightTurn, HorizontalTrack, FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, true), FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, false), FixedHorizontalTrack)
                row(UpRightTurn, DownRightLeftFork, HorizontalToggle(DARK_GREEN), DownLeftRightFork, DownLeftTurn, Empty, Empty)
                row(RightTunnel(BROWN, CarPosition(4, 0, RIGHT)), UpLeftTurn, Empty, UpRightTurn, UpLeftTurn, Empty, Empty)
                row(Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, Obstacle)
                row(RightTunnel(BROWN, CarPosition(2, 0, RIGHT)), HorizontalBarrier(DARK_GREEN, false), FixedHorizontalTrack, HorizontalBarrier(DARK_GREEN, true), DownLeftTurn, DownRightTurn, EndingTrack)
                row(Empty, DownRightTurn, DownLeftTurn, Empty, DownRightUpFork, UpLeftTurn, Empty)
                row(Empty, UpRightTurn, UpRightLeftFork, HorizontalToggle(DARK_GREEN), UpLeftTurn, Empty, Empty)
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

    object World4 {
        val level4_1 = setOf(
            buildBoard {
                row(DownRightTurn, HorizontalToggle(Color.PURPLE), HorizontalTrack, HorizontalTrack, FixedHorizontalTrack)
                row(VerticalTrack, Empty, Empty, Empty, Empty)
                row(UpRightDownToggleableFork(Color.PURPLE), FixedHorizontalTrack, EndingTrack, FixedHorizontalTrack, FixedHorizontalTrack)
                row(VerticalTrack, Empty, Empty, Empty, Empty)
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty)
            }
        )
        val level4_2 = setOf(
            buildBoard {
                row(FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, Empty)
                row(UpRightTurn, HorizontalTrack, DownLeftUpFork, Empty, Empty)
                row(Obstacle, Obstacle, VerticalToggle(Color.PURPLE), Empty, Empty)
                row(DownRightTurn, DownLeftTurn, FixedVerticalTrack, Empty, Empty)
                row(UpRightTurn, UpRightLeftFork, UpRightLeftToggleableFork(Color.PURPLE), HorizontalTrack, EndingTrack)
            }
        )
        val level4_3 = setOf(
            buildBoard {
                row(Empty, DownRightTurn, HorizontalTrack, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, UpLeftDownToggleableFork(Color.PURPLE), Obstacle, DownRightUpToggleableFork(Color.PURPLE), EndingTrack)
                row(DownRightTurn, UpLeftDownFork, DownRightTurn, UpLeftDownFork, Empty)
                row(UpRightTurn, UpLeftToggle(Color.PURPLE), UpRightTurn, FixedUpLeftTurn, Empty)
            }
        )
        val level4_3A = setOf(
            buildBoard {
                row(Empty, DownRightTurn, HorizontalToggle(Color.PURPLE), HorizontalTrack, DownRightLeftFork, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, UpLeftDownToggleableFork(Color.PURPLE), FixedHorizontalTrack, DownLeftTurn, VerticalToggle(Color.PURPLE), UpRightDownToggleableFork(Color.PURPLE), EndingTrack)
                row(Empty, UpRightTurn, HorizontalToggle(Color.PURPLE), UpLeftTurn, UpRightTurn, UpLeftTurn, Empty)
            }
        )
        val level4_3B = setOf(
            buildBoard {
                row(FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty)
                row(FixedVerticalTrack, DownRightTurn, DownLeftTurn, DownRightTurn, DownLeftTurn, Empty)
                row(DownRightUpFork, UpLeftDownFork, VerticalToggle(Color.PURPLE), VerticalTrack, DownRightUpFork, EndingTrack)
                row(UpRightTurn, UpLeftRightFork, UpRightLeftToggleableFork(Color.PURPLE), UpRightLeftToggleableFork(Color.PURPLE), UpLeftTurn, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            buildBoard {
                row(FixedVerticalTrack, DownRightTurn, DownLeftTurn, Empty, Empty, Empty)
                row(FixedVerticalTrack, VerticalTrack, VerticalTrack, DownRightTurn, DownLeftTurn, Empty)
                row(UpRightTurn, UpLeftDownFork, VerticalToggle(Color.PURPLE), VerticalTrack, DownRightUpFork, EndingTrack)
                row(Empty, UpRightTurn, UpRightLeftToggleableFork(Color.PURPLE), UpRightLeftToggleableFork(Color.PURPLE), UpLeftTurn, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            },
            buildBoard {
                row(FixedVerticalTrack, Empty, Empty, DownRightTurn, DownLeftTurn, Empty)
                row(FixedVerticalTrack, DownRightTurn, DownLeftTurn, DownRightUpFork, UpLeftTurn, Empty)
                row(UpRightTurn, UpLeftDownFork, VerticalToggle(Color.PURPLE), VerticalTrack, DownRightTurn, EndingTrack)
                row(Empty, UpRightTurn, UpRightLeftToggleableFork(Color.PURPLE), UpRightLeftToggleableFork(Color.PURPLE), UpLeftTurn, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level4_4 = setOf(
            buildBoard {
                row(Empty, Empty, Empty, Empty, Empty)
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty)
                row(FixedVerticalTrack, DownRightToggle(Color.PURPLE), DownLeftToggle(Color.PURPLE), DownRightUpToggleableFork(Color.PURPLE), EndingTrack)
                row(Empty, UpRightTurn, UpRightLeftFork, UpLeftTurn, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level4_4A = setOf(
            buildBoard {
                row(Empty, Empty, DownRightTurn, HorizontalTrack, FixedHorizontalTrack)
                row(DownRightTurn, DownLeftTurn, FixedDownRightUpFork, FixedDownLeftTurn, Empty)
                row(UpRightTurn, DownLeftUpToggle(Color.PURPLE), VerticalToggle(Color.PURPLE), DownRightUpToggleableFork(Color.PURPLE), EndingTrack)
                row(Empty, UpRightDownFork, FixedUpRightLeftFork, FixedUpLeftTurn, Empty)
                row(FixedHorizontalTrack, UpLeftTurn, Empty, Empty, Empty)
            }
        )
        val level4_5 = setOf(
            buildBoard {
                row(Empty, Empty, DownRightTurn, DownRightLeftFork, DownLeftTurn, Empty, Empty)
                row(Empty, Empty, UpRightTurn, UpLeftDownFork, VerticalToggle(Color.PURPLE), Empty, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, FixedHorizontalTrack, UpLeftRightFork, UpRightLeftToggleableFork(ORANGE), DownRightLeftToggleableFork(Color.PURPLE), EndingTrack)
                row(Empty, VerticalTrack, FixedDownRightTurn, HorizontalTrack, HorizontalTrack, UpLeftToggle(ORANGE), Empty)
                row(Empty, UpRightTurn, UpLeftTurn, Empty, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, DownLeftTurn, Empty, Empty)
                row(Empty, Empty, Empty, VerticalTrack, VerticalToggle(Color.PURPLE), Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn, FixedHorizontalTrack, UpRightLeftFork, UpRightLeftToggleableFork(ORANGE), DownRightLeftToggleableFork(Color.PURPLE), EndingTrack)
                row(DownRightTurn, UpLeftTurn, FixedDownRightTurn, HorizontalTrack, HorizontalTrack, UpLeftToggle(ORANGE), Empty)
                row(UpRightTurn, HorizontalTrack, UpLeftTurn, Empty, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, DownLeftTurn, Empty, Empty)
                row(Empty, Empty, Empty, VerticalTrack, VerticalToggle(Color.PURPLE), Empty, Empty)
                row(FixedHorizontalTrack, DownLeftTurn, FixedHorizontalTrack, UpRightLeftFork, UpRightLeftToggleableFork(ORANGE), DownRightLeftToggleableFork(Color.PURPLE), EndingTrack)
                row(Empty, VerticalTrack, FixedDownRightTurn, DownLeftTurn, DownRightTurn, UpLeftToggle(ORANGE), Empty)
                row(Empty, UpRightTurn, UpLeftTurn, UpRightTurn, UpLeftTurn, Empty, Empty)
            }
        )
        val level4_5A = setOf(
            buildBoard {
                row(Empty, Empty, DownRightTurn, HorizontalTrack, DownLeftTurn, Empty)
                row(Empty, Empty, VerticalTrack, DownRightToggle(ORANGE), UpLeftTurn, Empty)
                row(DownRightTurn, FixedHorizontalTrack, UpRightLeftFork, UpRightLeftToggleableFork(ORANGE), DownRightLeftToggleableFork(Color.PURPLE), EndingTrack)
                row(UpRightDownFork, HorizontalTrack, DownLeftTurn, Empty, UpRightToggle(Color.PURPLE), DownLeftTurn)
                row(UpRightTurn, FixedHorizontalTrack, UpLeftRightFork, HorizontalTrack, HorizontalTrack, UpLeftTurn)
            },
            buildBoard {
                row(Empty, Empty, DownRightTurn, HorizontalTrack, DownLeftTurn, Empty)
                row(DownRightTurn, HorizontalTrack, UpLeftTurn, DownRightToggle(ORANGE), UpLeftTurn, Empty)
                row(UpRightTurn, FixedHorizontalTrack, DownRightLeftFork, UpRightLeftToggleableFork(ORANGE), DownRightLeftToggleableFork(Color.PURPLE), EndingTrack)
                row(Empty, Empty, UpRightDownFork, DownLeftTurn, UpRightToggle(Color.PURPLE), DownLeftTurn)
                row(Empty, FixedHorizontalTrack, UpRightLeftFork, UpLeftRightFork, HorizontalTrack, UpLeftTurn)
            },
            buildBoard {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty)
                row(VerticalTrack, Empty, Empty, DownRightToggle(ORANGE), UpLeftTurn, Empty)
                row(UpRightTurn, FixedHorizontalTrack, DownRightLeftFork, UpRightLeftToggleableFork(ORANGE), DownRightLeftToggleableFork(Color.PURPLE), EndingTrack)
                row(Empty, Empty, UpRightDownFork, DownLeftTurn, UpRightToggle(Color.PURPLE), DownLeftTurn)
                row(Empty, FixedHorizontalTrack, UpRightLeftFork, UpLeftRightFork, HorizontalTrack, UpLeftTurn)
            },
            buildBoard {
                row(Empty, DownRightTurn, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty)
                row(DownRightTurn, UpLeftTurn, Empty, DownRightToggle(ORANGE), UpLeftTurn, Empty)
                row(UpRightTurn, FixedHorizontalTrack, DownRightLeftFork, UpRightLeftToggleableFork(ORANGE), DownRightLeftToggleableFork(Color.PURPLE), EndingTrack)
                row(Empty, Empty, UpRightDownFork, DownLeftTurn, UpRightToggle(Color.PURPLE), DownLeftTurn)
                row(Empty, FixedHorizontalTrack, UpRightLeftFork, UpLeftRightFork, HorizontalTrack, UpLeftTurn)
            },
            buildBoard {
                row(Empty, Empty, DownRightTurn, HorizontalTrack, DownLeftTurn, Empty)
                row(Empty, Empty, VerticalTrack, DownRightToggle(ORANGE), UpLeftTurn, Empty)
                row(DownRightTurn, FixedHorizontalTrack, UpRightLeftFork, UpRightLeftToggleableFork(ORANGE), DownRightLeftToggleableFork(Color.PURPLE), EndingTrack)
                row(UpRightTurn, HorizontalTrack, DownLeftRightFork, DownLeftTurn, UpRightToggle(Color.PURPLE), DownLeftTurn)
                row(Empty, FixedHorizontalTrack, UpLeftTurn, UpRightTurn, HorizontalTrack, UpLeftTurn)
            }
        )
        val level4_6 = setOf(
            buildBoard {
                row(DownRightTurn, DownLeftTurn, FixedVerticalTrack, Empty, Empty, Empty)
                row(VerticalTrack, UpRightTurn, UpLeftTurn, Empty, Empty, Empty)
                row(VerticalToggle(Color.PURPLE), Empty, FixedVerticalTrack, DownRightTurn, HorizontalBarrier(Color.PURPLE, true), EndingTrack)
                row(DownRightUpFork, DownLeftTurn, FixedVerticalTrack, VerticalTrack, Empty, Empty)
                row(UpRightTurn, UpRightLeftFork, UpRightLeftToggleableFork(Color.PURPLE), UpLeftTurn, Empty, Empty)
            }
        )
        val level4_6A = setOf(
            buildBoard {
                row(FixedDownRightTurn, FixedDownLeftTurn, Empty, Empty, DownRightTurn, HorizontalBarrier(Color.PURPLE, true), EndingTrack)
                row(UpRightDownToggleableFork(Color.PURPLE), UpLeftRightToggleableFork(Color.PURPLE), DownLeftTurn, DownRightTurn, UpLeftDownFork, Empty, Empty)
                row(FixedVerticalTrack, Empty, UpRightTurn, UpRightLeftToggle(Color.PURPLE), UpLeftRightFork, FixedHorizontalTrack, Empty)
            }
        )
        val level4_6B = setOf(
            buildBoard {
                row(DownRightTurn, FixedHorizontalTrack, HorizontalToggle(Color.PURPLE), DownLeftRightFork, DownLeftTurn, Empty, Empty)
                row(VerticalTrack, Empty, Empty, UpRightTurn, UpLeftTurn, Empty, Empty)
                row(UpRightDownFork, HorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalBarrier(Color.PURPLE, true), EndingTrack)
                row(VerticalTrack, Empty, FixedDownRightTurn, FixedDownLeftTurn, Empty, DownRightTurn, DownLeftTurn)
                row(UpRightTurn, FixedHorizontalTrack, UpLeftRightToggleableFork(Color.PURPLE), UpRightLeftToggleableFork(Color.PURPLE), HorizontalToggle(Color.PURPLE), UpLeftRightFork, UpLeftTurn)
            }
        )
        val level4_6C = setOf(
            buildBoard {
                row(Empty, FixedVerticalTrack, Empty, Empty, Empty)
                row(Empty, DownRightUpFork, DownLeftTurn, Empty, Empty)
                row(Empty, FixedVerticalTrack, UpRightDownToggleableFork(Color.PURPLE), HorizontalBarrier(Color.PURPLE, true), EndingTrack)
                row(DownRightTurn, UpLeftDownFork, UpRightTurn, HorizontalTrack, DownLeftTurn)
                row(UpRightTurn, UpRightLeftToggleableFork(Color.PURPLE), HorizontalTrack, HorizontalToggle(Color.PURPLE), UpLeftTurn)
            }
        )
        val level4_7 = setOf(
            buildBoard {
                row(FixedDownRightTurn, FixedHorizontalTrack, FixedDownRightLeftFork, FixedDownLeftTurn, Empty)
                row(UpRightDownToggleableFork(Color.PURPLE), HorizontalToggle(Color.PURPLE), FixedDownLeftUpFork, FixedVerticalTrack, Empty)
                row(UpRightDownFork, DownLeftRightFork, DownLeftUpFork, FixedVerticalTrack, Empty)
                row(VerticalTrack, UpRightTurn, UpLeftDownFork, VerticalBarrier(color=Color.PURPLE, open=true), Empty)
                row(FixedVerticalTrack, Empty, FixedVerticalTrack, FixedUpRightTurn, EndingTrack)
            },
            buildBoard {
                row(FixedDownRightTurn, FixedHorizontalTrack, FixedDownRightLeftFork, FixedDownLeftTurn, Empty)
                row(UpRightDownToggleableFork(Color.PURPLE), HorizontalToggle(Color.PURPLE), FixedDownLeftUpFork, FixedVerticalTrack, Empty)
                row(UpRightDownFork, HorizontalTrack, DownLeftUpFork, FixedVerticalTrack, Empty)
                row(UpRightDownFork, HorizontalTrack, UpLeftDownFork, VerticalBarrier(color=Color.PURPLE, open=true), Empty)
                row(FixedVerticalTrack, Empty, FixedVerticalTrack, FixedUpRightTurn, EndingTrack)
            },
            buildBoard {
                row(FixedDownRightTurn, FixedHorizontalTrack, FixedDownRightLeftFork, FixedDownLeftTurn, Empty)
                row(UpRightDownToggleableFork(Color.PURPLE), HorizontalToggle(Color.PURPLE), FixedDownLeftUpFork, FixedVerticalTrack, Empty)
                row(UpRightDownFork, HorizontalTrack, UpLeftTurn, FixedVerticalTrack, Empty)
                row(UpRightDownFork, HorizontalTrack, DownLeftTurn, VerticalBarrier(color=Color.PURPLE, open=true), Empty)
                row(FixedVerticalTrack, Empty, FixedVerticalTrack, FixedUpRightTurn, EndingTrack)
            },
            buildBoard {
                row(FixedDownRightTurn, FixedHorizontalTrack, FixedDownRightLeftFork, FixedDownLeftTurn, Empty)
                row(UpRightDownToggleableFork(Color.PURPLE), HorizontalToggle(Color.PURPLE), FixedDownLeftUpFork, FixedVerticalTrack, Empty)
                row(DownRightUpFork, DownRightLeftFork, UpLeftDownFork, FixedVerticalTrack, Empty)
                row(UpRightDownFork, UpLeftTurn, VerticalTrack, VerticalBarrier(color=Color.PURPLE, open=true), Empty)
                row(FixedVerticalTrack, Empty, FixedVerticalTrack, FixedUpRightTurn, EndingTrack)
            },
            buildBoard {
                row(FixedDownRightTurn, FixedHorizontalTrack, FixedDownRightLeftFork, FixedDownLeftTurn, Empty)
                row(UpRightDownToggleableFork(Color.PURPLE), HorizontalToggle(Color.PURPLE), FixedDownLeftUpFork, FixedVerticalTrack, Empty)
                row(DownRightUpFork, HorizontalTrack, UpLeftDownFork, FixedVerticalTrack, Empty)
                row(UpRightDownFork, HorizontalTrack, UpLeftDownFork, VerticalBarrier(color=Color.PURPLE, open=true), Empty)
                row(FixedVerticalTrack, Empty, FixedVerticalTrack, FixedUpRightTurn, EndingTrack)
            },
            buildBoard {
                row(FixedDownRightTurn, FixedHorizontalTrack, FixedDownRightLeftFork, FixedDownLeftTurn, Empty)
                row(UpRightDownToggleableFork(Color.PURPLE), HorizontalToggle(Color.PURPLE), FixedDownLeftUpFork, FixedVerticalTrack, Empty)
                row(UpRightTurn, HorizontalTrack, UpLeftDownFork, FixedVerticalTrack, Empty)
                row(DownRightTurn, HorizontalTrack, UpLeftDownFork, VerticalBarrier(color=Color.PURPLE, open=true), Empty)
                row(FixedVerticalTrack, Empty, FixedVerticalTrack, FixedUpRightTurn, EndingTrack)
            },
            buildBoard {
                row(FixedDownRightTurn, FixedHorizontalTrack, FixedDownRightLeftFork, FixedDownLeftTurn, Empty)
                row(UpRightDownToggleableFork(Color.PURPLE), HorizontalToggle(Color.PURPLE), FixedDownLeftUpFork, FixedVerticalTrack, Empty)
                row(VerticalTrack, DownRightTurn, DownLeftUpFork, FixedVerticalTrack, Empty)
                row(UpRightDownFork, UpLeftRightFork, UpLeftDownFork, VerticalBarrier(color=Color.PURPLE, open=true), Empty)
                row(FixedVerticalTrack, Empty, FixedVerticalTrack, FixedUpRightTurn, EndingTrack)
            },
            buildBoard {
                row(FixedDownRightTurn, FixedHorizontalTrack, FixedDownRightLeftFork, FixedDownLeftTurn, Empty)
                row(UpRightDownToggleableFork(Color.PURPLE), HorizontalToggle(Color.PURPLE), FixedDownLeftUpFork, FixedVerticalTrack, Empty)
                row(VerticalTrack, DownRightTurn, UpLeftTurn, FixedVerticalTrack, Empty)
                row(UpRightDownFork, UpLeftRightFork, DownLeftTurn, VerticalBarrier(color=Color.PURPLE, open=true), Empty)
                row(FixedVerticalTrack, Empty, FixedVerticalTrack, FixedUpRightTurn, EndingTrack)
            },
            buildBoard {
                row(FixedDownRightTurn, FixedHorizontalTrack, FixedDownRightLeftFork, FixedDownLeftTurn, Empty)
                row(UpRightDownToggleableFork(Color.PURPLE), HorizontalToggle(Color.PURPLE), FixedDownLeftUpFork, FixedVerticalTrack, Empty)
                row(UpRightDownFork, DownLeftRightFork, UpLeftTurn, FixedVerticalTrack, Empty)
                row(VerticalTrack, UpRightTurn, DownLeftTurn, VerticalBarrier(color=Color.PURPLE, open=true), Empty)
                row(FixedVerticalTrack, Empty, FixedVerticalTrack, FixedUpRightTurn, EndingTrack)
            },
            buildBoard {
                row(FixedDownRightTurn, FixedHorizontalTrack, FixedDownRightLeftFork, FixedDownLeftTurn, Empty)
                row(UpRightDownToggleableFork(Color.PURPLE), HorizontalToggle(Color.PURPLE), FixedDownLeftUpFork, FixedVerticalTrack, Empty)
                row(UpRightTurn, DownLeftTurn, VerticalTrack, FixedVerticalTrack, Empty)
                row(DownRightTurn, UpRightLeftFork, UpLeftDownFork, VerticalBarrier(color=Color.PURPLE, open=true), Empty)
                row(FixedVerticalTrack, Empty, FixedVerticalTrack, FixedUpRightTurn, EndingTrack)
            },
            buildBoard {
                row(FixedDownRightTurn, FixedHorizontalTrack, FixedDownRightLeftFork, FixedDownLeftTurn, Empty)
                row(UpRightDownToggleableFork(Color.PURPLE), HorizontalToggle(Color.PURPLE), FixedDownLeftUpFork, FixedVerticalTrack, Empty)
                row(UpRightTurn, DownRightLeftFork, UpLeftDownFork, FixedVerticalTrack, Empty)
                row(DownRightTurn, UpLeftTurn, VerticalTrack, VerticalBarrier(color=Color.PURPLE, open=true), Empty)
                row(FixedVerticalTrack, Empty, FixedVerticalTrack, FixedUpRightTurn, EndingTrack)
            },
            buildBoard {
                row(FixedDownRightTurn, FixedHorizontalTrack, FixedDownRightLeftFork, FixedDownLeftTurn, Empty)
                row(UpRightDownToggleableFork(Color.PURPLE), HorizontalToggle(Color.PURPLE), FixedDownLeftUpFork, FixedVerticalTrack, Empty)
                row(DownRightUpFork, DownLeftTurn, VerticalTrack, FixedVerticalTrack, Empty)
                row(UpRightDownFork, UpRightLeftFork, UpLeftDownFork, VerticalBarrier(Color.PURPLE, true), Empty)
                row(FixedVerticalTrack, Empty, FixedVerticalTrack, FixedUpRightTurn, EndingTrack)
            }
        )
        val level4_7A = setOf(
            buildBoard {
                row(FixedHorizontalTrack, DownRightLeftFork, HorizontalToggle(Color.PURPLE), HorizontalBarrier(color=ORANGE, open=true), DownLeftToggle(Color.PURPLE), Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, UpRightTurn, DownLeftTurn, Empty, FixedVerticalTrack, Empty, Empty, VerticalTrack, Empty)
                row(Empty, Empty, VerticalTrack, Empty, FixedVerticalTrack, Empty, Empty, DownRightUpFork, EndingTrack)
                row(Empty, Empty, VerticalTrack, Empty, VerticalToggle(ORANGE), Empty, Empty, VerticalTrack, Empty)
                row(Empty, Empty, UpRightTurn, HorizontalTrack, UpLeftRightToggleableFork(ORANGE), HorizontalBarrier(color=Color.PURPLE, open=true), HorizontalToggle(ORANGE), UpLeftTurn, Empty)
            },
            buildBoard {
                row(FixedHorizontalTrack, DownRightLeftFork, HorizontalToggle(Color.PURPLE), HorizontalBarrier(color=ORANGE, open=true), DownLeftToggle(Color.PURPLE), Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, VerticalTrack, Empty, Empty, FixedVerticalTrack, Empty, Empty, VerticalTrack, Empty)
                row(Empty, UpRightTurn, DownLeftTurn, Empty, FixedVerticalTrack, Empty, Empty, DownRightUpFork, EndingTrack)
                row(Empty, Empty, VerticalTrack, Empty, VerticalToggle(ORANGE), Empty, Empty, VerticalTrack, Empty)
                row(Empty, Empty, UpRightTurn, HorizontalTrack, UpLeftRightToggleableFork(ORANGE), HorizontalBarrier(color=Color.PURPLE, open=true), HorizontalToggle(ORANGE), UpLeftTurn, Empty)
            },
            buildBoard {
                row(FixedHorizontalTrack, DownRightLeftFork, HorizontalToggle(Color.PURPLE), HorizontalBarrier(color=ORANGE, open=true), DownLeftToggle(Color.PURPLE), Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, VerticalTrack, Empty, Empty, FixedVerticalTrack, Empty, Empty, VerticalTrack, Empty)
                row(Empty, VerticalTrack, Empty, Empty, FixedVerticalTrack, Empty, Empty, DownRightUpFork, EndingTrack)
                row(Empty, UpRightTurn, HorizontalTrack, DownLeftTurn, VerticalToggle(ORANGE), Empty, Empty, VerticalTrack, Empty)
                row(Empty, Empty, Empty, UpRightTurn, UpLeftRightToggleableFork(ORANGE), HorizontalBarrier(color=Color.PURPLE, open=true), HorizontalToggle(ORANGE), UpLeftTurn, Empty)
            },
            buildBoard {
                row(FixedHorizontalTrack, DownRightLeftFork, HorizontalToggle(Color.PURPLE), HorizontalBarrier(color=ORANGE, open=true), DownLeftToggle(Color.PURPLE), Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, VerticalTrack, Empty, Empty, FixedVerticalTrack, Empty, Empty, VerticalTrack, Empty)
                row(Empty, VerticalTrack, Empty, Empty, FixedVerticalTrack, Empty, Empty, DownRightUpFork, EndingTrack)
                row(Empty, VerticalTrack, Empty, Empty, VerticalToggle(ORANGE), Empty, Empty, VerticalTrack, Empty)
                row(Empty, UpRightTurn, HorizontalTrack, HorizontalTrack, UpLeftRightToggleableFork(ORANGE), HorizontalBarrier(color=Color.PURPLE, open=true), HorizontalToggle(ORANGE), UpLeftTurn, Empty)
            },
            buildBoard {
                row(FixedHorizontalTrack, DownRightLeftFork, HorizontalToggle(Color.PURPLE), HorizontalBarrier(color=ORANGE, open=true), DownLeftToggle(Color.PURPLE), Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, UpRightTurn, DownLeftTurn, Empty, FixedVerticalTrack, Empty, Empty, VerticalTrack, Empty)
                row(Empty, Empty, UpRightTurn, DownLeftTurn, FixedVerticalTrack, Empty, Empty, DownRightUpFork, EndingTrack)
                row(Empty, Empty, Empty, VerticalTrack, VerticalToggle(ORANGE), Empty, Empty, VerticalTrack, Empty)
                row(Empty, Empty, Empty, UpRightTurn, UpLeftRightToggleableFork(ORANGE), HorizontalBarrier(color=Color.PURPLE, open=true), HorizontalToggle(ORANGE), UpLeftTurn, Empty)
            },
            buildBoard {
                row(FixedHorizontalTrack, DownRightLeftFork, HorizontalToggle(Color.PURPLE), HorizontalBarrier(color=ORANGE, open=true), DownLeftToggle(Color.PURPLE), Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, UpRightTurn, DownLeftTurn, Empty, FixedVerticalTrack, Empty, Empty, VerticalTrack, Empty)
                row(Empty, Empty, VerticalTrack, Empty, FixedVerticalTrack, Empty, Empty, DownRightUpFork, EndingTrack)
                row(Empty, Empty, UpRightTurn, DownLeftTurn, VerticalToggle(ORANGE), Empty, Empty, VerticalTrack, Empty)
                row(Empty, Empty, Empty, UpRightTurn, UpLeftRightToggleableFork(ORANGE), HorizontalBarrier(color=Color.PURPLE, open=true), HorizontalToggle(ORANGE), UpLeftTurn, Empty)
            },
            buildBoard {
                row(FixedHorizontalTrack, DownRightLeftFork, HorizontalToggle(Color.PURPLE), HorizontalBarrier(ORANGE, true), DownLeftToggle(Color.PURPLE), Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, VerticalTrack, Empty, Empty, FixedVerticalTrack, Empty, Empty, VerticalTrack, Empty)
                row(Empty, UpRightTurn, DownLeftTurn, Empty, FixedVerticalTrack, Empty, Empty, DownRightUpFork, EndingTrack)
                row(Empty, Empty, UpRightTurn, DownLeftTurn, VerticalToggle(ORANGE), Empty, Empty, VerticalTrack, Empty)
                row(Empty, Empty, Empty, UpRightTurn, UpLeftRightToggleableFork(ORANGE), HorizontalBarrier(Color.PURPLE, true), HorizontalToggle(ORANGE), UpLeftTurn, Empty)
            },
            buildBoard {
                row(FixedHorizontalTrack, DownRightLeftFork, HorizontalToggle(Color.PURPLE), HorizontalBarrier(color=ORANGE, open=true), DownLeftToggle(Color.PURPLE), Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, VerticalTrack, Empty, Empty, FixedVerticalTrack, Empty, Empty, VerticalTrack, Empty)
                row(Empty, UpRightTurn, HorizontalTrack, DownLeftTurn, FixedVerticalTrack, Empty, Empty, DownRightUpFork, EndingTrack)
                row(Empty, Empty, Empty, VerticalTrack, VerticalToggle(ORANGE), Empty, Empty, VerticalTrack, Empty)
                row(Empty, Empty, Empty, UpRightTurn, UpLeftRightToggleableFork(ORANGE), HorizontalBarrier(color=Color.PURPLE, open=true), HorizontalToggle(ORANGE), UpLeftTurn, Empty)
            },
            buildBoard {
                row(FixedHorizontalTrack, DownRightLeftFork, HorizontalToggle(Color.PURPLE), HorizontalBarrier(color=ORANGE, open=true), DownLeftToggle(Color.PURPLE), Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, UpRightTurn, HorizontalTrack, DownLeftTurn, FixedVerticalTrack, Empty, Empty, VerticalTrack, Empty)
                row(Empty, Empty, Empty, VerticalTrack, FixedVerticalTrack, Empty, Empty, DownRightUpFork, EndingTrack)
                row(Empty, Empty, Empty, VerticalTrack, VerticalToggle(ORANGE), Empty, Empty, VerticalTrack, Empty)
                row(Empty, Empty, Empty, UpRightTurn, UpLeftRightToggleableFork(ORANGE), HorizontalBarrier(color=Color.PURPLE, open=true), HorizontalToggle(ORANGE), UpLeftTurn, Empty)
            },
            buildBoard {
                row(FixedHorizontalTrack, DownRightLeftFork, HorizontalToggle(Color.PURPLE), HorizontalBarrier(color=ORANGE, open=true), DownLeftToggle(Color.PURPLE), Empty, Empty, FixedVerticalTrack, Empty)
                row(Empty, VerticalTrack, Empty, Empty, FixedVerticalTrack, Empty, Empty, VerticalTrack, Empty)
                row(Empty, VerticalTrack, Empty, Empty, FixedVerticalTrack, Empty, Empty, DownRightUpFork, EndingTrack)
                row(Empty, UpRightTurn, DownLeftTurn, Empty, VerticalToggle(ORANGE), Empty, Empty, VerticalTrack, Empty)
                row(Empty, Empty, UpRightTurn, HorizontalTrack, UpLeftRightToggleableFork(ORANGE), HorizontalBarrier(color=Color.PURPLE, open=true), HorizontalToggle(ORANGE), UpLeftTurn, Empty)
            }
        )
        val level4_7B = setOf(
            buildBoard {
                row(DownRightTurn, FixedHorizontalTrack, HorizontalToggle(ORANGE), DownLeftRightFork, DownLeftTurn, Empty)
                row(UpRightTurn, HorizontalTrack, DownLeftTurn, UpRightTurn, UpLeftTurn, Empty)
                row(Empty, Empty, UpRightTurn, DownRightLeftFork, HorizontalBarrier(color=Color.PURPLE, open=true), EndingTrack)
                row(Empty, FixedDownRightTurn, FixedDownLeftTurn, UpRightTurn, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, FixedUpRightLeftFork, UpRightLeftToggleableFork(ORANGE), HorizontalToggle(Color.PURPLE), UpLeftTurn, Empty)
            },
            buildBoard {
                row(DownRightTurn, FixedHorizontalTrack, HorizontalToggle(ORANGE), DownLeftRightFork, DownLeftTurn, Empty)
                row(VerticalTrack, Empty, Empty, UpRightTurn, UpLeftTurn, Empty)
                row(UpRightTurn, HorizontalTrack, HorizontalTrack, DownRightLeftFork, HorizontalBarrier(color=Color.PURPLE, open=true), EndingTrack)
                row(Empty, FixedDownRightTurn, FixedDownLeftTurn, UpRightTurn, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, FixedUpRightLeftFork, UpRightLeftToggleableFork(ORANGE), HorizontalToggle(Color.PURPLE), UpLeftTurn, Empty)
            },
            buildBoard {
                row(DownRightTurn, FixedHorizontalTrack, HorizontalToggle(ORANGE), DownLeftRightFork, DownLeftTurn, Empty)
                row(UpRightTurn, DownLeftTurn, Empty, UpRightTurn, UpLeftTurn, Empty)
                row(Empty, UpRightTurn, HorizontalTrack, DownRightLeftFork, HorizontalBarrier(Color.PURPLE, true), EndingTrack)
                row(Empty, FixedDownRightTurn, FixedDownLeftTurn, UpRightTurn, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, FixedUpRightLeftFork, UpRightLeftToggleableFork(ORANGE), HorizontalToggle(Color.PURPLE), UpLeftTurn, Empty)
            }
        )
        val level4_8 = setOf(
            buildBoard {
                row(Empty, FixedVerticalTrack, Empty)
                row(DownRightTurn, UpLeftRightFork, DownLeftTurn)
                row(VerticalToggle(Color.PURPLE), Obstacle, VerticalToggle(ORANGE))
                row(UpRightDownToggleableFork(ORANGE), HorizontalTrack, DownLeftUpToggleableFork(Color.PURPLE))
                row(UpRightTurn, DownRightLeftFork, UpLeftTurn)
                row(Empty, FixedVerticalTrack, Empty)
                row(Empty, UpRightBarrier(Color.PURPLE, true), EndingTrack)
            }
        )
        val level4_8A = setOf(
            buildBoard {
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn, DownLeftTurn, Empty, Empty, Empty, Empty)
                row(FixedHorizontalTrack, DownRightLeftFork, DownRightLeftToggleableFork(Color.PURPLE), DownLeftUpFork, Empty, Empty, Empty, Empty)
                row(Empty, VerticalTrack, VerticalToggle(Color.PURPLE), VerticalToggle(ORANGE), Empty, Empty, Empty, Empty)
                row(Empty, UpRightDownFork, UpRightLeftToggleableFork(ORANGE), FixedUpRightLeftFork, FixedHorizontalTrack, HorizontalBarrier(ORANGE, true), HorizontalBarrier(Color.PURPLE, true), EndingTrack)
                row(Empty, UpRightTurn, DownLeftTurn, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level4_8B = setOf(
            buildBoard {
                row(RightTunnel(GRAY, CarPosition(3, 0, RIGHT)), DownRightLeftFork, DownLeftTurn, Empty, DownTunnel(BEIGE, CarPosition(3, 7, LEFT)), Empty, Empty, Empty)
                row(Empty, VerticalToggle(Color.PURPLE), VerticalTrack, Empty, FixedUpRightTurn, HorizontalBarrier(ORANGE, true), FixedHorizontalTrack, EndingTrack)
                row(Empty, VerticalTrack, DownRightUpFork, HorizontalToggle(ORANGE), HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(0, 0, RIGHT)), UpLeftDownToggleableFork(ORANGE), UpRightTurn, HorizontalToggle(Color.PURPLE), DownRightLeftToggleableFork(Color.PURPLE), UpRightLeftToggleableFork(ORANGE), FixedHorizontalTrack, LeftTunnel(BEIGE, CarPosition(0, 4, DOWN)))
                row(Empty, UpRightTurn, DownLeftRightFork, HorizontalTrack, UpLeftDownFork, Empty, Empty, Empty)
                row(Empty, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, Empty, Empty)
            }
        )
        val level4_9 = setOf(
            buildBoard {
                row(Empty, FixedVerticalTrack, Empty, Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, UpRightTurn, DownLeftTurn, Empty, Empty, VerticalBarrier(Color.PURPLE, true), Empty, Empty)
                row(DownRightTurn, DownLeftRightToggleableFork(Color.PURPLE), VerticalTrack, Empty, Empty, VerticalBarrier(ORANGE, true), Empty, Empty)
                row(VerticalToggle(Color.PURPLE), VerticalToggle(ORANGE), VerticalToggle(LIGHT_BLUE), Empty, Empty, VerticalBarrier(LIGHT_BLUE, true), Empty, Empty)
                row(VerticalTrack, UpRightLeftToggleableFork(LIGHT_BLUE), UpRightLeftFork, HorizontalTrack, HorizontalTrack, UpRightLeftFork, FixedHorizontalTrack, EndingTrack)
                row(UpRightTurn, DownLeftTurn, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level4_9A = setOf(
            buildBoard {
                row(Empty, Empty, Empty, Empty, DownTunnel(color=BEIGE, exitPosition=CarPosition(row=4, column=8, direction=LEFT)), Empty, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=4, column=0, direction=RIGHT)), HorizontalTrack, DownLeftToggle(ORANGE), Empty, FixedUpRightTurn, FixedHorizontalTrack, HorizontalBarrier(color=ORANGE, open=true), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, UpRightTurn, DownLeftTurn, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightTurn, DownLeftUpFork, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=1, column=0, direction=RIGHT)), HorizontalTrack, UpLeftToggle(Color.PURPLE), UpRightDownFork, HorizontalToggle(Color.PURPLE), HorizontalTrack, DownRightLeftFork, DownRightLeftToggleableFork(Color.PURPLE), LeftTunnel(color=BEIGE, exitPosition=CarPosition(row=0, column=4, direction=DOWN)))
                row(Empty, Empty, Empty, VerticalTrack, Empty, DownRightTurn, DownLeftUpFork, VerticalTrack, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, UpRightTurn, UpLeftTurn, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, DownTunnel(color=BEIGE, exitPosition=CarPosition(row=4, column=8, direction=LEFT)), Empty, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=4, column=0, direction=RIGHT)), HorizontalTrack, DownLeftToggle(ORANGE), Empty, FixedUpRightTurn, FixedHorizontalTrack, HorizontalBarrier(color=ORANGE, open=true), FixedHorizontalTrack, EndingTrack)
                row(Empty, DownRightTurn, DownLeftUpFork, Empty, Empty, Empty, Empty, Empty, Empty)
                row(Empty, UpRightTurn, UpRightLeftFork, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=1, column=0, direction=RIGHT)), DownLeftTurn, UpLeftToggle(Color.PURPLE), Empty, HorizontalToggle(Color.PURPLE), UpRightDownFork, HorizontalTrack, DownRightLeftToggleableFork(Color.PURPLE), LeftTunnel(color=BEIGE, exitPosition=CarPosition(row=0, column=4, direction=DOWN)))
                row(Empty, UpRightTurn, HorizontalTrack, DownLeftTurn, Empty, VerticalTrack, Empty, Empty, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, DownTunnel(color=BEIGE, exitPosition=CarPosition(row=4, column=8, direction=LEFT)), Empty, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=4, column=0, direction=RIGHT)), HorizontalTrack, DownLeftToggle(ORANGE), Empty, FixedUpRightTurn, FixedHorizontalTrack, HorizontalBarrier(color=ORANGE, open=true), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, UpRightTurn, DownLeftTurn, Empty, Empty, Empty, Empty, Empty)
                row(Empty, DownRightTurn, HorizontalTrack, UpRightLeftFork, HorizontalTrack, DownLeftTurn, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=1, column=0, direction=RIGHT)), UpLeftDownFork, UpLeftToggle(Color.PURPLE), Empty, HorizontalToggle(Color.PURPLE), UpRightDownFork, HorizontalTrack, DownRightLeftToggleableFork(Color.PURPLE), LeftTunnel(color=BEIGE, exitPosition=CarPosition(row=0, column=4, direction=DOWN)))
                row(Empty, UpRightTurn, HorizontalTrack, DownLeftTurn, Empty, VerticalTrack, Empty, Empty, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, DownTunnel(color=BEIGE, exitPosition=CarPosition(row=4, column=8, direction=LEFT)), Empty, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=4, column=0, direction=RIGHT)), HorizontalTrack, DownLeftToggle(ORANGE), Empty, FixedUpRightTurn, FixedHorizontalTrack, HorizontalBarrier(color=ORANGE, open=true), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, UpRightTurn, DownLeftTurn, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightTurn, UpRightLeftFork, HorizontalTrack, DownLeftTurn, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=1, column=0, direction=RIGHT)), DownRightLeftFork, UpLeftToggle(Color.PURPLE), Empty, HorizontalToggle(Color.PURPLE), VerticalTrack, Empty, DownRightLeftToggleableFork(Color.PURPLE), LeftTunnel(color=BEIGE, exitPosition=CarPosition(row=0, column=4, direction=DOWN)))
                row(Empty, UpRightTurn, HorizontalTrack, DownLeftTurn, Empty, UpRightDownFork, HorizontalTrack, UpLeftTurn, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, DownTunnel(color=BEIGE, exitPosition=CarPosition(row=4, column=8, direction=LEFT)), Empty, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=4, column=0, direction=RIGHT)), HorizontalTrack, DownLeftToggle(ORANGE), Empty, FixedUpRightTurn, FixedHorizontalTrack, HorizontalBarrier(color=ORANGE, open=true), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, UpRightTurn, DownLeftTurn, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightTurn, UpRightLeftFork, HorizontalTrack, DownLeftTurn, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=1, column=0, direction=RIGHT)), DownRightLeftFork, UpLeftToggle(Color.PURPLE), Empty, HorizontalToggle(Color.PURPLE), VerticalTrack, DownRightTurn, DownRightLeftToggleableFork(Color.PURPLE), LeftTunnel(color=BEIGE, exitPosition=CarPosition(row=0, column=4, direction=DOWN)))
                row(Empty, UpRightTurn, HorizontalTrack, DownLeftTurn, Empty, UpRightDownFork, UpLeftTurn, Empty, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, DownTunnel(color=BEIGE, exitPosition=CarPosition(row=4, column=8, direction=LEFT)), Empty, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=4, column=0, direction=RIGHT)), HorizontalTrack, DownLeftToggle(ORANGE), Empty, FixedUpRightTurn, FixedHorizontalTrack, HorizontalBarrier(color=ORANGE, open=true), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, DownRightUpFork, DownLeftTurn, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, UpRightTurn, UpRightLeftFork, HorizontalTrack, HorizontalTrack, DownLeftTurn, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=1, column=0, direction=RIGHT)), DownLeftTurn, UpLeftToggle(Color.PURPLE), Empty, HorizontalToggle(Color.PURPLE), Empty, UpRightDownFork, DownRightLeftToggleableFork(Color.PURPLE), LeftTunnel(color=BEIGE, exitPosition=CarPosition(row=0, column=4, direction=DOWN)))
                row(Empty, UpRightTurn, HorizontalTrack, DownLeftTurn, Empty, DownRightTurn, UpLeftTurn, Empty, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, DownTunnel(BEIGE, CarPosition(4, 8, LEFT)), Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(4, 0, RIGHT)), HorizontalTrack, DownLeftToggle(ORANGE), Empty, FixedUpRightTurn, FixedHorizontalTrack, HorizontalBarrier(ORANGE, true), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, UpRightTurn, DownLeftTurn, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightTurn, DownLeftUpFork, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(1, 0, RIGHT)), HorizontalTrack, UpLeftToggle(Color.PURPLE), UpRightDownFork, HorizontalToggle(Color.PURPLE), HorizontalTrack, DownLeftRightFork, DownRightLeftToggleableFork(Color.PURPLE), LeftTunnel(BEIGE, CarPosition(0, 4, DOWN)))
                row(Empty, Empty, Empty, VerticalTrack, Empty, DownRightTurn, DownLeftUpFork, VerticalTrack, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, UpRightTurn, UpLeftTurn, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, DownTunnel(color=BEIGE, exitPosition=CarPosition(row=4, column=8, direction=LEFT)), Empty, Empty, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=4, column=0, direction=RIGHT)), HorizontalTrack, DownLeftToggle(ORANGE), Empty, FixedUpRightTurn, FixedHorizontalTrack, HorizontalBarrier(color=ORANGE, open=true), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, UpRightTurn, DownLeftTurn, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, DownRightTurn, DownLeftUpFork, Empty, DownRightTurn, DownLeftTurn, Empty, Empty)
                row(RightTunnel(color=GRAY, exitPosition=CarPosition(row=1, column=0, direction=RIGHT)), HorizontalTrack, UpLeftToggle(Color.PURPLE), UpRightDownFork, HorizontalToggle(Color.PURPLE), UpLeftDownFork, UpRightTurn, DownRightLeftToggleableFork(Color.PURPLE), LeftTunnel(color=BEIGE, exitPosition=CarPosition(row=0, column=4, direction=DOWN)))
                row(Empty, Empty, Empty, VerticalTrack, Empty, UpRightDownFork, HorizontalTrack, UpLeftTurn, Empty)
                row(Empty, Empty, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, Empty, Empty)
            }
        )
        val level4_9B = setOf(
            buildBoard {
                row(Empty, Empty, Empty, Empty, DownTunnel(BEIGE, CarPosition(4, 8, LEFT)), Empty, Empty, Empty, Empty)
                row(RightTunnel(MINT, CarPosition(7, 8, LEFT)), HorizontalTrack, DownLeftToggle(ORANGE), Empty, FixedUpRightTurn, FixedHorizontalTrack, HorizontalBarrier(ORANGE, true), FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, VerticalTrack, Obstacle, Empty, Empty, Empty, Empty, Empty)
                row(Empty, Empty, VerticalTrack, Obstacle, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(7, 0, RIGHT)), HorizontalTrack, UpLeftToggle(Color.PURPLE), DownRightTurn, HorizontalToggle(Color.PURPLE), HorizontalTrack, HorizontalTrack, DownRightLeftToggleableFork(Color.PURPLE), LeftTunnel(BEIGE, CarPosition(0, 4, DOWN)))
                row(Empty, Empty, Empty, VerticalTrack, Obstacle, Empty, Empty, VerticalTrack, Empty)
                row(Empty, Empty, Empty, VerticalTrack, Empty, Empty, DownRightTurn, UpLeftDownFork, Empty)
                row(RightTunnel(GRAY, CarPosition(4, 0, RIGHT)), HorizontalTrack, DownLeftTurn, UpRightTurn, DownRightLeftFork, HorizontalTrack, UpRightLeftFork, UpLeftRightToggleableFork(Color.PURPLE), LeftTunnel(MINT, CarPosition(1, 0, RIGHT)))
                row(Empty, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty)
            },
            buildBoard {
                row(Empty, Empty, Empty, Empty, DownTunnel(BEIGE, CarPosition(4, 8, LEFT)), Empty, Empty, Empty, Empty)
                row(RightTunnel(MINT, CarPosition(7, 8, LEFT)), HorizontalTrack, DownLeftToggle(ORANGE), Empty, FixedUpRightTurn, FixedHorizontalTrack, HorizontalBarrier(ORANGE, open=true), FixedHorizontalTrack, EndingTrack)
                row(Empty, DownRightTurn, UpLeftTurn, Obstacle, Empty, Empty, Empty, Empty, Empty)
                row(Empty, UpRightDownFork, DownLeftTurn, Obstacle, Empty, Empty, Empty, Empty, Empty)
                row(RightTunnel(GRAY, CarPosition(7, 0, RIGHT)), UpRightLeftFork, UpLeftToggle(Color.PURPLE), Empty, HorizontalToggle(Color.PURPLE), Empty, DownRightTurn, DownRightLeftToggleableFork(Color.PURPLE), LeftTunnel(BEIGE, CarPosition(0, 4, DOWN)))
                row(Empty, Empty, Empty, Empty, Obstacle, Empty, UpRightTurn, DownLeftUpFork, Empty)
                row(Empty, Empty, Empty, Empty, Empty, Empty, DownRightTurn, UpLeftDownFork, Empty)
                row(RightTunnel(GRAY, CarPosition(4, 0, RIGHT)), HorizontalTrack, DownLeftTurn, Empty, DownRightTurn, HorizontalTrack, UpRightLeftFork, UpLeftRightToggleableFork(Color.PURPLE), LeftTunnel(MINT, CarPosition(1, 0, RIGHT)))
                row(Empty, Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty)
            }
        )

        val solutions = mapOf(
            "4-1" to level4_1,
            "4-2" to level4_2,
            "4-3" to level4_3,
            "4-3A" to level4_3A,
            "4-3B" to level4_3B,
            "4-4" to level4_4,
            "4-4A" to level4_4A,
            "4-5" to level4_5,
            "4-5A" to level4_5A,
            "4-6" to level4_6,
            "4-6A" to level4_6A,
            "4-6B" to level4_6B,
            "4-6C" to level4_6C,
            "4-7" to level4_7,
            "4-7A" to level4_7A,
            "4-7B" to level4_7B,
            "4-8" to level4_8,
            "4-8A" to level4_8A,
            "4-8B" to level4_8B,
            "4-9" to level4_9,
            "4-9A" to level4_9A,
            "4-9B" to level4_9B,
        )
    }

    object World5 {
        val level5_1 = setOf(
            buildBoard {
                row(Obstacle, Obstacle, DownPlatform(1, false), Obstacle, Obstacle)
                row(Empty, DownRightTurn, HorizontalStop(1), DownLeftTurn, Empty)
                row(Empty, VerticalTrack, Empty, VerticalTrack, Empty)
                row(FixedHorizontalTrack, UpLeftTurn, Empty, UpRightTurn, EndingTrack)
            }
        )
        val level5_2 = setOf(
            buildBoard {
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, EndingTrack)
                row(VerticalStop(1), LeftPlatform(1, false), Empty, Empty)
                row(FixedVerticalTrack, Empty, Empty, Empty)
                row(UpRightTurn, HorizontalTrack, FixedHorizontalTrack, Empty)
            }
        )
        val level5_3 = setOf(
            buildBoard {
                row(Empty, DownRightTurn, HorizontalTrack, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, UpRightLeftFork, FixedHorizontalTrack, DownLeftUpFork, Empty)
                row(Obstacle, Obstacle, DownPlatform(2, false), UpRightDownFork, EndingTrack)
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalStop(2), UpLeftTurn, Empty)
                row(Empty, Empty, Empty, Empty, Empty)
            }
        )
        val level5_4 = setOf(
            buildBoard {
                row(Empty, FixedHorizontalTrack, FixedHorizontalTrack, DownLeftTurn, Empty)
                row(DownRightTurn, HorizontalTrack, HorizontalTrack, UpLeftTurn, Empty)
                row(UpRightTurn, HorizontalStop(2), HorizontalStop(1), DownLeftTurn, Empty)
                row(Empty, UpPlatform(2, false), UpPlatform(1, false), VerticalTrack, Empty)
                row(Empty, Empty, Empty, UpRightTurn, EndingTrack)
            }
        )
        val level5_5 = setOf(
            buildBoard {
                row(Obstacle, Obstacle, DownPlatform(2, false), Obstacle, Obstacle)
                row(DownRightTurn, FixedHorizontalTrack, HorizontalStop(2), DownLeftTurn, Empty)
                row(VerticalTrack, Empty, Empty, UpRightDownFork, DownLeftTurn)
                row(DownRightUpFork, FixedHorizontalTrack, HorizontalStop(1), UpLeftRightFork, UpLeftTurn)
                row(FixedVerticalTrack, Empty, UpPlatform(1, false), Empty, Empty)
                row(UpRightTurn, FixedHorizontalTrack, EndingTrack, FixedHorizontalTrack, FixedHorizontalTrack)
            }
        )
        val level5_6 = setOf(
            buildBoard {
                row(Empty, Empty, DownTunnel(LIGHT_GRAY, CarPosition(5, 7, LEFT)), Empty, Empty, DownTunnel(GRAY, CarPosition(4, 1, RIGHT)), Empty, Empty)
                row(Empty, Empty, VerticalTrack, Empty, Empty, FixedVerticalTrack, Empty, Empty)
                row(Empty, Empty, VerticalTrack, Empty, Empty, FixedUpRightTurn, FixedHorizontalTrack, EndingTrack)
                row(Empty, Empty, FixedVerticalTrack, Empty, Empty, Empty, Empty, Empty)
                row(Empty, RightTunnel(GRAY, CarPosition(0, 5, DOWN)), UpLeftRightFork, HorizontalTrack, HorizontalStop(1), HorizontalTrack, DownLeftTurn, Empty)
                row(Empty, Empty, Empty, Empty, UpPlatform(1, false), DownRightTurn, UpRightLeftFork, LeftTunnel(LIGHT_GRAY, CarPosition(0, 2, DOWN)))
                row(Empty, FixedHorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalStop(2), UpLeftTurn, Obstacle, Empty)
                row(Obstacle, Obstacle, Obstacle, Obstacle, UpPlatform(2, false), Obstacle, Obstacle, Obstacle)
            }
        )
        val level5_7 = setOf(
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, DownLeftTurn, Empty, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, UpLeftDownToggleableFork(LIGHT_BLUE), UpRightTurn, DownRightLeftFork, EndingTrack)
                row(Empty, Empty, Empty, UpRightDownFork, DownLeftTurn, UpRightTurn, DownLeftTurn)
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalToggle(LIGHT_BLUE), UpLeftTurn, UpRightTurn, HorizontalStop(3), UpLeftTurn)
                row(Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, UpPlatform(3, false), Obstacle)
            },
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, DownLeftTurn, Empty, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, UpLeftDownToggleableFork(LIGHT_BLUE), UpRightTurn, HorizontalTrack, EndingTrack)
                row(Empty, Empty, Empty, UpRightDownFork, DownLeftRightFork, HorizontalTrack, DownLeftTurn)
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalToggle(LIGHT_BLUE), UpLeftTurn, UpRightTurn, HorizontalStop(3), UpLeftTurn)
                row(Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, UpPlatform(3, false), Obstacle)
            },
            buildBoard {
                row(Empty, Empty, Empty, DownRightTurn, HorizontalTrack, DownLeftTurn, Empty)
                row(FixedHorizontalTrack, FixedHorizontalTrack, FixedHorizontalTrack, UpLeftDownToggleableFork(LIGHT_BLUE), Empty, UpRightTurn, EndingTrack)
                row(Empty, Empty, Empty, UpRightDownFork, DownLeftRightFork, HorizontalTrack, DownLeftTurn)
                row(FixedHorizontalTrack, HorizontalTrack, HorizontalToggle(LIGHT_BLUE), UpLeftTurn, UpRightTurn, HorizontalStop(3), UpLeftTurn)
                row(Obstacle, Obstacle, Obstacle, Obstacle, Obstacle, UpPlatform(3, false), Obstacle)
            }
        )
        val level5_8 = setOf(
            buildBoard {
                row(DownRightTurn, HorizontalStop(1), HorizontalTrack, DownRightLeftToggleableFork(LIGHT_BLUE), HorizontalTrack, DownLeftTurn, DownRightTurn, DownLeftTurn)
                row(VerticalToggle(LIGHT_BLUE), UpPlatform(1, false), Empty, VerticalTrack, Obstacle, VerticalTrack, VerticalToggle(LIGHT_BLUE), VerticalTrack)
                row(UpRightTurn, HorizontalTrack, FixedHorizontalTrack, DownLeftUpFork, FixedHorizontalTrack, UpRightLeftFork, UpLeftRightFork, UpLeftTurn)
                row(Empty, Empty, Obstacle, UpRightTurn, HorizontalBarrier(LIGHT_BLUE, true), FixedHorizontalTrack, EndingTrack, FixedHorizontalTrack)
            }
        )

        val solutions = mapOf(
            "5-1" to level5_1,
            "5-2" to level5_2,
            "5-3" to level5_3,
            "5-4" to level5_4,
            "5-5" to level5_5,
            "5-6" to level5_6,
            "5-7" to level5_7,
            "5-8" to level5_8,
        )
    }

    val solutions = World1.solutions +
            World2.solutions +
            World3.solutions +
            World4.solutions +
            World5.solutions
}