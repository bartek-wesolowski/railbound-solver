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
import model.TunnelColor

private val trackColor = Color.Gray
private val fixedTrackColor = Color.Black
private const val trackStrokeWidthPercent = 0.05f

@Composable
fun Tile(
    tile: Tile,
    size: Dp
) {
    Canvas(modifier = Modifier.size(size)) {
        drawBorder()
        when (tile) {
            FixedHorizontalTrack -> drawHorizontalTrack(size, fixedTrackColor)
            FixedVerticalTrack -> drawVerticalTrack(size, fixedTrackColor)
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
            EndingTrack -> drawEndingTrack(size)
            FixedDownLeftTurn -> drawDownLeftTurn(size, fixedTrackColor)
            FixedDownRightTurn -> drawDownRightTurn(size, fixedTrackColor)
            FixedUpLeftTurn -> drawUpLeftTurn(size, fixedTrackColor)
            FixedUpRightTurn -> drawUpRightTurn(size, fixedTrackColor)
            Obstacle -> drawObstacle(size)
            UpLeftDownFork -> drawUpLeftDownFork(size)
            UpLeftRightFork -> drawUpLeftRightFork(size)
            UpRightDownFork -> drawUpRightDownFork(size)
            UpRightLeftFork -> drawUpRightLeftFork(size)
            is DownTunnel -> drawDownTunnel(size, tile.color)
            is LeftTunnel -> drawLeftTunnel(size, tile.color)
            is RightTunnel -> drawRightTunnel(size, tile.color)
            is UpTunnel -> drawUpTunnel(size, tile.color)
        }
    }
}

private fun DrawScope.drawVerticalTrack(size: Dp, color: Color = trackColor) {
    val x1 = (size * 0.25f).toPx()
    val x2 = (size * 0.75f).toPx()
    val trackStrokeWidth = getTrackStrokeWidth(size)
    drawLine(
        color = color,
        start = Offset(x1, 0f),
        end = Offset(x1, size.toPx()),
        strokeWidth = trackStrokeWidth
    )
    drawLine(
        color = color,
        start = Offset(x2, 0f),
        end = Offset(x2, size.toPx()),
        strokeWidth = trackStrokeWidth
    )
}

private fun DrawScope.drawHorizontalTrack(size: Dp, color: Color = trackColor) {
    val y1 = (size * 0.25f).toPx()
    val y2 = (size * 0.75f).toPx()
    val trackStrokeWidth = getTrackStrokeWidth(size)
    drawLine(
        color = color,
        start = Offset(0f, y1),
        end = Offset(size.toPx(), y1),
        strokeWidth = trackStrokeWidth
    )
    drawLine(
        color = color,
        start = Offset(0f, y2),
        end = Offset(size.toPx(), y2),
        strokeWidth = trackStrokeWidth
    )
}

private fun DrawScope.drawEndingTrack(size: Dp) {
    drawHorizontalTrack(size, color = Color.Red)
}

private fun DrawScope.drawDownRightTurn(size: Dp, color: Color = trackColor) {
    drawTurn(size, 180f, color)
}

private fun DrawScope.drawDownLeftTurn(size: Dp, color: Color = trackColor) {
    drawTurn(size, 270f, color)
}

private fun DrawScope.drawUpRightTurn(size: Dp, color: Color = trackColor) {
    drawTurn(size, 90f, color)
}

private fun DrawScope.drawUpLeftTurn(size: Dp, color: Color = trackColor) {
    drawTurn(size, 0f, color)
}

private fun DrawScope.drawTurn(
    size: Dp,
    startAngle: Float,
    color: Color,
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
        color = color,
        startAngle = startAngle,
        sweepAngle = 90f,
        useCenter = false,
        topLeft = topLeft1,
        size = Size(size1, size1),
        style = Stroke(width = trackStrokeWidth)
    )
    drawArc(
        color = color,
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

private fun DrawScope.drawDownTunnel(size: Dp, color: TunnelColor) {
    drawVerticalTrack(size, fixedTrackColor)
    drawArc(
        color = color.toColor(),
        startAngle = -150f,
        sweepAngle = 120f,
        useCenter = false,
        topLeft = Offset(0f, 0f),
        size = Size(size.toPx(), size.toPx()),
    )
}

private fun DrawScope.drawLeftTunnel(size: Dp, color: TunnelColor) {
    drawHorizontalTrack(size, fixedTrackColor)
    drawArc(
        color = color.toColor(),
        startAngle = -60f,
        sweepAngle = 120f,
        useCenter = false,
        topLeft = Offset(0f, 0f),
        size = Size(size.toPx(), size.toPx()),
    )
}

private fun DrawScope.drawRightTunnel(size: Dp, color: TunnelColor) {
    drawHorizontalTrack(size, fixedTrackColor)
    drawArc(
        color = color.toColor(),
        startAngle = 120f,
        sweepAngle = 120f,
        useCenter = false,
        topLeft = Offset(0f, 0f),
        size = Size(size.toPx(), size.toPx()),
    )
}

private fun DrawScope.drawUpTunnel(size: Dp, color: TunnelColor) {
    drawVerticalTrack(size, fixedTrackColor)
    drawArc(
        color = color.toColor(),
        startAngle = 30f,
        sweepAngle = 120f,
        useCenter = false,
        topLeft = Offset(0f, 0f),
        size = Size(size.toPx(), size.toPx()),
    )
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

private fun TunnelColor.toColor(): Color = when (this) {
    TunnelColor.GRAY -> Color.Gray
    TunnelColor.BROWN -> Color.Gray // TODO
}

@Preview
@Composable
private fun TilePreview() {
    Tile(
        tile = UpLeftTurn,
        size = 100.dp
    )
}