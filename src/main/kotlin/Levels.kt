package com.bartoszwesolowski

import com.bartoszwesolowski.CarColor.Red
import com.bartoszwesolowski.Direction.LEFT
import com.bartoszwesolowski.Direction.RIGHT
import com.bartoszwesolowski.Direction.UP
import com.bartoszwesolowski.Tile.*

object Levels {
    object World1 {
        val levels = listOf(
            Level(
                board = Board.fromRows(
                    arrayOf(HorizontalTrack, Empty, Empty, Empty, EndingTrack),
                ),
                cars = arrayListOf(
                    Car(1, Red, CarPosition(0, 0, RIGHT)),
                )
            ),
            Level(
                board = Board.fromRows(
                    arrayOf(Empty, Empty, Empty, Obstacle, Empty, EndingTrack),
                    arrayOf(Empty, Obstacle, Empty, Obstacle, Empty, Obstacle),
                    arrayOf(VerticalTrack, Obstacle, Empty, Empty, Empty, Obstacle),
                ),
                cars = arrayListOf(
                    Car(1, Red, CarPosition(2, 0, UP)),
                )
            ),
            Level(
                board = Board.fromRows(
                    arrayOf(HorizontalTrack, DownLeftRightFork, HorizontalTrack, Empty, EndingTrack),
                    arrayOf(Empty, VerticalTrack, Empty, VerticalTrack, Empty),
                    arrayOf(Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, Empty),
                ),
                cars = arrayListOf(
                    Car(1, Red, CarPosition(0, 0, RIGHT)),
                )
            ),
            Level(
                board = Board.fromRows(
                    arrayOf(Empty, Empty, VerticalTrack, Empty, Empty),
                    arrayOf(Empty, DownRightTurn, Empty, DownLeftTurn, Empty),
                    arrayOf(HorizontalTrack, Empty, Obstacle, Empty, EndingTrack),
                    arrayOf(Empty, UpRightTurn, Empty, UpLeftTurn, Empty),
                    arrayOf(Empty, Empty, VerticalTrack, Empty, Empty),
                ),
                cars = arrayListOf(
                    Car(1, Red, CarPosition(2, 0, RIGHT)),
                )
            ),
            Level(
                board = Board.fromRows(
                    arrayOf(Empty, Empty, Empty, EndingTrack),
                    arrayOf(Empty, Obstacle, Obstacle, Obstacle),
                    arrayOf(Empty, Empty, Empty, HorizontalTrack),
                ),
                cars = arrayListOf(
                    Car(1, Red, CarPosition(2, 3, LEFT)),
                )
            ),
        )
    }
}

