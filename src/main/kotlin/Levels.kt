package com.bartoszwesolowski

import com.bartoszwesolowski.CarColor.Red
import com.bartoszwesolowski.Direction.RIGHT
import com.bartoszwesolowski.Direction.UP
import com.bartoszwesolowski.Tile.Empty
import com.bartoszwesolowski.Tile.EndingTrack
import com.bartoszwesolowski.Tile.HorizontalTrack
import com.bartoszwesolowski.Tile.Obstacle
import com.bartoszwesolowski.Tile.VerticalTrack

val board1_1 = Board(
    arrayOf(
        arrayOf(HorizontalTrack, Empty, Empty, Empty, EndingTrack),
    )
)

val cars1_1 = arrayListOf(
    Car(1, Red, CarPosition(0, 0, RIGHT)),
)

val board1_2 = Board(
    arrayOf(
        arrayOf(Empty, Empty, Empty, Obstacle, Empty, EndingTrack),
        arrayOf(Empty, Obstacle, Empty, Obstacle, Empty),
        arrayOf(VerticalTrack, Obstacle, Empty, Empty, Empty, Obstacle),
    )
)

val cars1_2 = arrayListOf(
    Car(1, Red, CarPosition(2, 0, UP)),
)