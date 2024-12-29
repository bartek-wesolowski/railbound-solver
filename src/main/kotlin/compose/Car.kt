package compose

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import model.Car
import model.CarColor
import model.CarPosition
import model.Direction

private const val carWidthPercent = 0.5f
private const val carHeightPercent = 0.75f

@Composable
fun Car(
    car: Car,
    tileSize: Dp,
    modifier: Modifier = Modifier,
) {
    Canvas(modifier = modifier.size(tileSize)) {
        val color = when (car.color) {
            CarColor.Red -> Red
        }
        val topLeft = when (car.direction) {
            Direction.UP -> Offset(
                x = (tileSize.toPx() * (1 - carWidthPercent) / 2),
                y = (tileSize.toPx() * (1 - carHeightPercent))
            )
            Direction.DOWN -> Offset(
                x = (tileSize.toPx() * (1 - carWidthPercent) / 2),
                y = 0f
            )
            Direction.LEFT -> Offset(
                x = (tileSize.toPx() * (1 - carHeightPercent)),
                y = (tileSize.toPx() * (1 - carWidthPercent) / 2)
            )
            Direction.RIGHT -> Offset(
                x = 0f,
                y = (tileSize.toPx() * (1 - carWidthPercent) / 2)
            )
        }
        val size = when (car.direction) {
            Direction.UP, Direction.DOWN -> Size(
                width = tileSize.toPx() * carWidthPercent,
                height = tileSize.toPx() * carHeightPercent
            )
            Direction.LEFT, Direction.RIGHT -> Size(
                width = tileSize.toPx() * carHeightPercent,
                height = tileSize.toPx() * carWidthPercent
            )
        }
        drawRect(
            color = color,
            topLeft = topLeft,
            size = size
        )
    }
}

@Preview
@Composable
private fun CarPreview() {
    Car(
        Car(
            number = 1,
            color = CarColor.Red,
            position = CarPosition(0, 0, Direction.LEFT),
        ),
        100.dp,
    )
}