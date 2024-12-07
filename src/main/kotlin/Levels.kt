package com.bartoszwesolowski

import com.bartoszwesolowski.CarColor.Red
import com.bartoszwesolowski.Direction.DOWN
import com.bartoszwesolowski.Direction.LEFT
import com.bartoszwesolowski.Direction.RIGHT
import com.bartoszwesolowski.Direction.UP
import com.bartoszwesolowski.Tile.*

object Levels {
    object World1 {
        val level1_1 = Level(
            board = Board.fromRows(
                arrayOf(FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack),
            ),
            cars = arrayListOf(
                Car(1, Red, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 3
        )
        val level1_2 = Level(
            board = Board.fromRows(
                arrayOf(Empty, Empty, Empty, Obstacle, Empty, EndingTrack),
                arrayOf(Empty, Obstacle, Empty, Obstacle, Empty, Obstacle),
                arrayOf(FixedVerticalTrack, Obstacle, Empty, Empty, Empty, Obstacle),
            ),
            cars = arrayListOf(
                Car(1, Red, CarPosition(2, 0, UP)),
            ),
            tracks = 10
        )
        val level1_3 = Level(
            board = Board.fromRows(
                arrayOf(FixedHorizontalTrack, DownLeftRightFork, FixedHorizontalTrack, Empty, EndingTrack),
                arrayOf(Empty, FixedVerticalTrack, Empty, FixedVerticalTrack, Empty),
                arrayOf(Empty, FixedUpRightTurn, FixedHorizontalTrack, FixedUpLeftTurn, Empty),
            ),
            cars = arrayListOf(
                Car(1, Red, CarPosition(0, 0, RIGHT)),
            ),
            tracks = 1
        )
        val level1_4 = Level(
            board = Board.fromRows(
                arrayOf(Empty, Empty, FixedVerticalTrack, Empty, Empty),
                arrayOf(Empty, FixedDownRightTurn, Empty, FixedDownLeftTurn, Empty),
                arrayOf(FixedHorizontalTrack, Empty, Obstacle, Empty, EndingTrack),
                arrayOf(Empty, FixedUpRightTurn, Empty, FixedUpLeftTurn, Empty),
                arrayOf(Empty, Empty, FixedVerticalTrack, Empty, Empty),
            ),
            cars = arrayListOf(
                Car(1, Red, CarPosition(2, 0, RIGHT)),
            ),
            tracks = 4
        )
        val level1_5 = Level(
            board = Board.fromRows(
                arrayOf(Empty, Empty, Empty, EndingTrack),
                arrayOf(Empty, Obstacle, Obstacle, Obstacle),
                arrayOf(Empty, Empty, Empty, FixedHorizontalTrack),
            ),
            cars = arrayListOf(
                Car(1, Red, CarPosition(2, 3, LEFT)),
            ),
            tracks = 7
        )
        val level1_6 = Level(
            board = Board.fromRows(
                arrayOf(Empty, Empty, Empty, Empty, Empty),
                arrayOf(FixedHorizontalTrack, Empty, Empty, Empty, EndingTrack),
                arrayOf(Empty, Empty, Empty, Empty, Empty),
            ),
            cars = arrayListOf(
                Car(1, Red, CarPosition(1, 0, RIGHT)),
            ),
            tracks = 3
        )
        val level1_7 = Level(
            board = Board.fromRows(
                arrayOf(FixedVerticalTrack, Empty, Empty),
                arrayOf(Empty, Obstacle, Empty),
                arrayOf(Empty, Empty, EndingTrack),
            ),
            cars = arrayListOf(
                Car(1, Red, CarPosition(0, 0, DOWN)),
            ),
            tracks = 3
        )
        val level1_8 = Level(
            board = Board.fromRows(
                arrayOf(FixedHorizontalTrack, FixedHorizontalTrack, DownRightLeftFork, EndingTrack),
                arrayOf(Empty, Empty, Empty, Empty),
                arrayOf(FixedHorizontalTrack, Empty, Empty, Empty),
            ),
            cars = arrayListOf(
                Car(1, Red, CarPosition(2, 0, RIGHT)),
            ),
            tracks = 3
        )
        val level1_9 = Level(
            board = Board.fromRows(
                arrayOf(FixedVerticalTrack, Obstacle, FixedVerticalTrack, Empty, Empty),
                arrayOf(Empty, Obstacle, FixedVerticalTrack, Empty, Empty),
                arrayOf(Empty, Empty, Empty, FixedHorizontalTrack, EndingTrack),
            ),
            cars = arrayListOf(
                Car(1, Red, CarPosition(0, 2, DOWN)),
                Car(2, Red, CarPosition(0, 0, DOWN)),
            ),
            tracks = 4
        )
        val level1_10 = Level(
            board = Board.fromRows(
                arrayOf(FixedHorizontalTrack, Empty, Empty, Empty, Empty),
                arrayOf(Empty, FixedDownRightTurn, Empty, FixedDownLeftTurn, Empty),
                arrayOf(Empty, FixedVerticalTrack, Obstacle, UpRightDownFork, EndingTrack),
                arrayOf(Empty, FixedUpRightTurn, Empty, FixedUpLeftTurn, Empty),
                arrayOf(FixedHorizontalTrack, Empty, Empty, Empty, Empty),
            ),
            cars = arrayListOf(
                Car(1, Red, CarPosition(0, 0, RIGHT)),
                Car(2, Red, CarPosition(4, 0, RIGHT)),
            ),
            tracks = 6
        )
        val level1_11 = Level(
            board = Board.fromRows(
                arrayOf(Empty, FixedHorizontalTrack, Empty, Empty),
                arrayOf(Empty, Obstacle, Empty, EndingTrack),
                arrayOf(Empty, FixedHorizontalTrack, Empty, Empty),
            ),
            cars = arrayListOf(
                Car(1, Red, CarPosition(0, 1, RIGHT)),
                Car(2, Red, CarPosition(2, 1, LEFT)),
            ),
            tracks = 5
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
        )
    }
}

