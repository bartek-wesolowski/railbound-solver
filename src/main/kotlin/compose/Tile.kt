package compose

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import model.Tile
import model.Tile.*

private val trackColor = Color.Gray
private const val trackStrokeWidthPercent = 0.05f

@Composable
fun Tile(
    tile: Tile,
    size: Dp
) {
    Canvas(modifier = Modifier.size(size)) {
        drawBorder()
        when (tile) {
            FixedHorizontalTrack -> drawHorizontalTrack(size)
            FixedVerticalTrack -> drawVerticalTrack(size)
            HorizontalTrack -> drawHorizontalTrack(size)
            VerticalTrack -> drawVerticalTrack(size)
            DownRightTurn -> drawDownRightTurn(size)
            DownLeftTurn -> drawDownLeftTurn(size)
            UpRightTurn -> drawUpRightTurn(size)
            UpLeftTurn -> drawUpLeftTurn(size)
            DownLeftRightFork -> drawDownLeftRightFork(size)
            DownLeftUpFork -> drawDownLeftUpFork(size)
            DownRightLeftFork -> drawDownRightLeftFork(size)
            DownRightUpFork -> drawDownRightUpFork(size)
            Empty -> {}
            EndingTrack -> drawHorizontalTrack(size)
            FixedDownLeftTurn -> drawDownLeftTurn(size)
            FixedDownRightTurn -> drawDownRightTurn(size)
            FixedUpLeftTurn -> drawUpLeftTurn(size)
            FixedUpRightTurn -> drawUpRightTurn(size)
            Obstacle -> drawObstacle(size)
            UpLeftDownFork -> drawUpLeftDownFork(size)
            UpLeftRightFork -> drawUpLeftRightFork(size)
            UpRightDownFork -> drawUpRightDownFork(size)
            UpRightLeftFork -> drawUpRightLeftFork(size)
        }
    }
}

private fun DrawScope.drawVerticalTrack(size: Dp) {
    val x1 = (size * 0.25f).toPx()
    val x2 = (size * 0.75f).toPx()
    val trackStrokeWidth = getTrackStrokeWidth(size)
    drawLine(
        color = trackColor,
        start = Offset(x1, 0f),
        end = Offset(x1, size.toPx()),
        strokeWidth = trackStrokeWidth
    )
    drawLine(
        color = trackColor,
        start = Offset(x2, 0f),
        end = Offset(x2, size.toPx()),
        strokeWidth = trackStrokeWidth
    )
}

private fun DrawScope.drawHorizontalTrack(size: Dp) {
    val y1 = (size * 0.25f).toPx()
    val y2 = (size * 0.75f).toPx()
    val trackStrokeWidth = getTrackStrokeWidth(size)
    drawLine(
        color = trackColor,
        start = Offset(0f, y1),
        end = Offset(size.toPx(), y1),
        strokeWidth = trackStrokeWidth
    )
    drawLine(
        color = trackColor,
        start = Offset(0f, y2),
        end = Offset(size.toPx(), y2),
        strokeWidth = trackStrokeWidth
    )
}

private fun DrawScope.drawDownRightTurn(size: Dp) {
    drawTurn(size, 180f)
}

private fun DrawScope.drawDownLeftTurn(size: Dp) {
    drawTurn(size, 270f)
}

private fun DrawScope.drawUpRightTurn(size: Dp) {
    drawTurn(size, 90f)
}

private fun DrawScope.drawUpLeftTurn(size: Dp) {
    drawTurn(size, 0f)
}

private fun DrawScope.drawTurn(
    size: Dp,
    startAngle: Float,
) {
    val trackStrokeWidth = getTrackStrokeWidth(size)
    val size1 = (size * 0.5f).toPx()
    val size2 = (size * 1.5f).toPx()
    val topLeft1 = when (startAngle) {
        0f -> Offset(-size1 / 2, -size1 / 2)
        90f -> Offset(size.toPx() - size1 / 2, -size1 / 2)
        180f -> Offset(size.toPx() - size1 / 2, size.toPx() - size1 / 2)
        270f -> Offset(-size1 / 2, size.toPx() - size1 / 2)
        else -> throw IllegalArgumentException("startAngle not supported: $startAngle")
    }
    val topLeft2 = when (startAngle) {
        0f -> Offset(-size2 / 2, -size2 / 2)
        90f -> Offset(size.toPx() - size2 / 2, -size2 / 2)
        180f -> Offset(size.toPx() - size2 / 2, size.toPx() - size2 / 2)
        270f -> Offset(-size2 / 2, size.toPx() - size2 / 2)
        else -> throw IllegalArgumentException("startAngle not supported: $startAngle")
    }
    drawArc(
        color = trackColor,
        startAngle = startAngle,
        sweepAngle = 90f,
        useCenter = false,
        topLeft = topLeft1,
        size = Size(size1, size1),
        style = Stroke(width = trackStrokeWidth)
    )
    drawArc(
        color = trackColor,
        startAngle = startAngle,
        sweepAngle = 90f,
        useCenter = false,
        topLeft = topLeft2,
        size = Size(size2, size2),
        style = Stroke(width = trackStrokeWidth)
    )
}

private fun DrawScope.drawDownLeftRightFork(size: Dp) {
    drawDownLeftTurn(size)
    drawHorizontalTrack(size)
}

private fun DrawScope.drawDownLeftUpFork(size: Dp) {
    drawDownLeftTurn(size)
    drawVerticalTrack(size)
}

private fun DrawScope.drawDownRightLeftFork(size: Dp) {
    drawDownRightTurn(size)
    drawHorizontalTrack(size)
}

private fun DrawScope.drawDownRightUpFork(size: Dp) {
    drawDownRightTurn(size)
    drawVerticalTrack(size)
}

private fun DrawScope.drawUpLeftDownFork(size: Dp) {
    drawUpLeftTurn(size)
    drawVerticalTrack(size)
}

private fun DrawScope.drawUpLeftRightFork(size: Dp) {
    drawUpLeftTurn(size)
    drawHorizontalTrack(size)
}

private fun DrawScope.drawUpRightDownFork(size: Dp) {
    drawUpRightTurn(size)
    drawVerticalTrack(size)
}

private fun DrawScope.drawUpRightLeftFork(size: Dp) {
    drawUpRightTurn(size)
    drawHorizontalTrack(size)
}

private fun DrawScope.drawObstacle(size: Dp) {
    drawCircle(
        color = Color.Gray,
        radius = size.toPx() / 4
    )
}

private fun DrawScope.drawBorder() {
    drawRect(
        color = Color.Gray,
        style = Stroke(width = 1.dp.toPx())
    )
}

private fun DrawScope.getTrackStrokeWidth(size: Dp): Float = (size * trackStrokeWidthPercent).toPx()

@Preview
@Composable
private fun TilePreview() {
    Tile(
        tile = UpLeftTurn,
        size = 100.dp
    )
}