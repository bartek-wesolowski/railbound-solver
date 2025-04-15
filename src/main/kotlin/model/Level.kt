package model

import model.Tile.BaseHorizontalTrack.FixedHorizontalTrack
import model.Tile.BaseVerticalTrack.FixedVerticalTrack

data class Level(
    val name: String,
    val board: Board,
    val carColor: CarColor,
    val cars: Cars,
    val tracks: Int,
) {
    init {
        for (car in cars) {
            require(car.row >= 0 && car.row < board.rows) {
                "Car ${car.number} row ${car.row} is out of bounds"
            }
            require(car.column >= 0 && car.column < board.columns) {
                "Car ${car.number} column ${car.column} is out of bounds"
            }
            val tile = board[car.row, car.column]
            require(tile is FixedHorizontalTrack || tile is FixedVerticalTrack) {
                "Car ${car.number} is not on a fixed straight track"
            }
            if (tile is FixedHorizontalTrack) {
                require(car.direction == Direction.LEFT || car.direction == Direction.RIGHT) {
                    "Car ${car.number} is not facing left or right"
                }
            } else {
                require(car.direction == Direction.UP || car.direction == Direction.DOWN) {
                    "Car ${car.number} is not facing up or down"
                }
            }
            for (otherCar in cars) {
                if (car != otherCar) {
                    require(car.row != otherCar.row || car.column != otherCar.column) {
                        "Cars ${car.number} and ${otherCar.number} are on the same tile"
                    }
                    require(car.number != otherCar.number) {
                        "Cars ${car.number} and ${otherCar.number} have the same number"
                    }
                }
            }
        }
    }
}