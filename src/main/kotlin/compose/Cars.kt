package compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import model.CarColor
import model.Cars

@Composable
fun Cars(
    cars: Cars,
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