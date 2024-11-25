package com.bartoszwesolowski

import com.bartoszwesolowski.CarColor.Red
import com.bartoszwesolowski.Direction.RIGHT
import com.bartoszwesolowski.Tile.Empty
import com.bartoszwesolowski.Tile.EndingTrack
import com.bartoszwesolowski.Tile.HorizontalTrack

val board1_1 = Board(
    arrayOf(
        arrayOf(HorizontalTrack, Empty, Empty, Empty, EndingTrack),
    )
)

val cars1_1 = arrayListOf(
    Car(1, Red, CarPosition(0, 0, RIGHT)),
)