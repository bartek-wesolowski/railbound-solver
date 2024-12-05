package com.bartoszwesolowski

import com.bartoszwesolowski.CarColor.Red
import com.bartoszwesolowski.Direction.LEFT
import com.bartoszwesolowski.Direction.RIGHT
import com.bartoszwesolowski.Direction.UP
import com.bartoszwesolowski.Tile.*

val board1_1 = Board.fromRows(
    arrayOf(HorizontalTrack, Empty, Empty, Empty, EndingTrack),
)

val cars1_1 = arrayListOf(
    Car(1, Red, CarPosition(0, 0, RIGHT)),
)

val board1_2 = Board.fromRows(
    arrayOf(Empty, Empty, Empty, Obstacle, Empty, EndingTrack),
    arrayOf(Empty, Obstacle, Empty, Obstacle, Empty, Obstacle),
    arrayOf(VerticalTrack, Obstacle, Empty, Empty, Empty, Obstacle),
)

val cars1_2 = arrayListOf(
    Car(1, Red, CarPosition(2, 0, UP)),
)

val board1_3 = Board.fromRows(
    arrayOf(HorizontalTrack, DownLeftRightFork, HorizontalTrack, Empty, EndingTrack),
    arrayOf(Empty, VerticalTrack, Empty, VerticalTrack, Empty),
    arrayOf(Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, Empty),
)

val cars1_3 = arrayListOf(
    Car(1, Red, CarPosition(0, 0, RIGHT)),
)

val board1_4 = Board.fromRows(
    arrayOf(Empty, Empty, VerticalTrack, Empty, Empty),
    arrayOf(Empty, DownRightTurn, Empty, DownLeftTurn, Empty),
    arrayOf(HorizontalTrack, Empty, Obstacle, Empty, EndingTrack),
    arrayOf(Empty, UpRightTurn, Empty, UpLeftTurn, Empty),
    arrayOf(Empty, Empty, VerticalTrack, Empty, Empty),
)

val cars1_4 = arrayListOf(
    Car(1, Red, CarPosition(2, 0, RIGHT)),
)

val board1_5 = Board.fromRows(
    arrayOf(Empty, Empty, Empty, EndingTrack),
    arrayOf(Empty, Obstacle, Obstacle, Obstacle),
    arrayOf(Empty, Empty, Empty, HorizontalTrack),
)

val cars1_5 = arrayListOf(
    Car(1, Red, CarPosition(2, 3, LEFT)),
)