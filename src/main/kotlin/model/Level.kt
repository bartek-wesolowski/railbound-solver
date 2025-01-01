package model

data class Level(
    val name: String,
    val board: Board,
    val cars: ArrayList<Car>,
    val tracks: Int,
)