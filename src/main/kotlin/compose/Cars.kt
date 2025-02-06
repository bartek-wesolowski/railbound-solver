package compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.danrusu.pods4k.immutableArrays.ImmutableArray
import model.Car

@Composable
fun Cars(
    cars: ImmutableArray<Car>,
    tileSize: Dp,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        cars.forEach { car ->
            Car(
                car,
                tileSize,
                Modifier.offset(
                    x = tileSize * car.position.column,
                    y = tileSize * car.position.row
                )
            )
        }
    }
}