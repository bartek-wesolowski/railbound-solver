package compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import model.Car
import model.CarColor

@Composable
fun Cars(
    cars: List<Car>,
    carColor: CarColor,
    tileSize: Dp,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        cars.forEach { car ->
            Car(
                car,
                carColor,
                tileSize,
                Modifier.offset(
                    x = tileSize * car.column,
                    y = tileSize * car.row
                )
            )
        }
    }
}