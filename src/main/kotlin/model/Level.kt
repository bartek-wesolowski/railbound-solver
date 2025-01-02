package model

import com.danrusu.pods4k.immutableArrays.ImmutableArray

data class Level(
    val name: String,
    val board: Board,
    val cars: ImmutableArray<Car>,
    val tracks: Int,
)