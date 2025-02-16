package model

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import model.Tile.BaseHorizontalTrack.FixedHorizontalTrack
import model.Tile.BaseVerticalTrack.FixedVerticalTrack

data class Level(
    val name: String,
    val board: Board,
    val carColor: CarColor,
    val cars: ImmutableArray<Car>,
    val tracks: Int,
) {
    init {
        for (car in cars) {
            require(car.row >= 0 && car.row < board.rows)
            require(car.column >= 0 && car.column < board.columns)
            val tile = board[car.row, car.column]
            require(tile is FixedHorizontalTrack || tile is FixedVerticalTrack)
            if (tile is FixedHorizontalTrack) {
                require(car.direction == Direction.LEFT || car.direction == Direction.RIGHT)
            } else {
                require(car.direction == Direction.UP || car.direction == Direction.DOWN)
            }
            for (otherCar in cars) {
                if (car != otherCar) {
                    require(car.row != otherCar.row || car.column != otherCar.column)
                    require(car.number != otherCar.number)
                }
            }
        }
    }
}