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
import model.Action
import model.Action.*
import model.Color.DARK_GREEN
import model.Fork
import model.HasAction
import model.Tile
import model.Tile.*
import model.Tile.BaseHorizontalTrack.FixedHorizontalTrack
import model.Tile.BaseHorizontalTrack.HorizontalBarrier
import model.Tile.BaseHorizontalTrack.HorizontalTrack
import model.Tile.BaseVerticalTrack.FixedVerticalTrack
import model.Tile.BaseVerticalTrack.VerticalBarrier
import model.Tile.BaseVerticalTrack.VerticalTrack
import model.TunnelColor
import model.Turn

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
            is HorizontalTrack -> drawHorizontalTrack(size, trackColor)
            is FixedHorizontalTrack -> drawHorizontalTrack(size, fixedTrackColor)
            is HorizontalBarrier -> drawHorizontalBarrier(size, tile.color, tile.open)
            is VerticalTrack -> drawVerticalTrack(size, trackColor)
            is FixedVerticalTrack -> drawVerticalTrack(size, fixedTrackColor)
            is VerticalBarrier -> drawVerticalBarrier(size, tile.color, tile.open)
            is DownRightTurn -> drawDownRightTurn(size, tile.getColor())
            is DownLeftTurn -> drawDownLeftTurn(size, tile.getColor())
            is UpRightTurn -> drawUpRightTurn(size, tile.getColor())
            is UpLeftTurn -> drawUpLeftTurn(size, tile.getColor())
            is DownLeftRightFork -> drawDownLeftRightFork(size, tile.getColor())
            is DownLeftUpFork -> drawDownLeftUpFork(size, tile.getColor())
            is DownRightLeftFork -> drawDownRightLeftFork(size, tile.getColor())
            is DownRightUpFork -> drawDownRightUpFork(size, tile.getColor())
            is UpLeftDownFork -> drawUpLeftDownFork(size, tile.getColor())
            is UpLeftRightFork -> drawUpLeftRightFork(size, tile.getColor())
            is UpRightDownFork -> drawUpRightDownFork(size, tile.getColor())
            is UpRightLeftFork -> drawUpRightLeftFork(size, tile.getColor())
            Empty -> {}
            EndingTrack -> drawEndingTrack(size)
            Obstacle -> drawObstacle(size)
            is DownTunnel -> drawDownTunnel(size, tile.color)
            is LeftTunnel -> drawLeftTunnel(size, tile.color)
            is RightTunnel -> drawRightTunnel(size, tile.color)
            is UpTunnel -> drawUpTunnel(size, tile.color)
        }
        if (tile is HasAction) {
            drawAction(size, tile.action)
        }
    }
}

private fun Turn.getColor(): Color {
    return if (fixed) fixedTrackColor else trackColor
}

private fun Fork.getColor(): Color {
    return if (color != null) Color(color!!.color) else (if (fixed) fixedTrackColor else trackColor)
}

private fun DrawScope.drawVerticalTrack(size: Dp, color: Color) {
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

private fun DrawScope.drawVerticalBarrier(size: Dp, color: model.Color, open: Boolean) {
    drawVerticalTrack(size, fixedTrackColor)
    val trackStrokeWidth = getTrackStrokeWidth(size)
    if (open) {
        val x1 = (size * 0.25f).toPx()
        val y1 = (size / 2).toPx()
        val x2 = (size * 0.35f).toPx()
        val y2 = (size * 0.05f).toPx()
        drawLine(
            color = Color(color.color),
            start = Offset(x1, y1),
            end = Offset(x2, y2),
            strokeWidth = trackStrokeWidth
        )
    } else {
        val x1 = (size * 0.25f).toPx()
        val x2 = (size * 0.75f).toPx()
        val y = (size / 2).toPx()
        drawLine(
            color = Color(color.color),
            start = Offset(x1, y),
            end = Offset(x2, y),
            strokeWidth = trackStrokeWidth
        )
    }
}

private fun DrawScope.drawAction(
    size: Dp,
    action: Action?,
) {
    when (action) {
        is ToggleBarrier -> drawBarrierSwitch(size, action.color)
        is ToggleFork -> drawForkSwitch(size, action.color)
        null -> Unit
    }
}

private fun DrawScope.drawBarrierSwitch(
    size: Dp,
    color: model.Color
) {
    drawSwitch(size, Color(color.color))
}

private fun DrawScope.drawForkSwitch(
    size: Dp,
    color: model.Color
) {
    drawSwitch(size, Color(color.color))
}

private fun DrawScope.drawSwitch(
    size: Dp,
    color: Color
) {
    val squareSize = (size * 0.3f).toPx()
    drawRect(
        color = color,
        topLeft = Offset((size * 0.35f).toPx(), (size * 0.35f).toPx()),
        size = Size(squareSize, squareSize)
    )
}

private fun DrawScope.drawHorizontalTrack(size: Dp, color: Color) {
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

private fun DrawScope.drawHorizontalBarrier(size: Dp, color: model.Color, open: Boolean) {
    drawHorizontalTrack(size, fixedTrackColor)
    val trackStrokeWidth = getTrackStrokeWidth(size)
    if (open) {
        val x1 = (size / 2).toPx()
        val y1 = (size * 0.75f).toPx()
        val y2 = (size * 0.65f).toPx()
        val x2 = (size * 0.95f).toPx()
        drawLine(
            color = Color(color.color),
            start = Offset(x1, y1),
            end = Offset(x2, y2),
            strokeWidth = trackStrokeWidth
        )
    } else {
        val y1 = (size * 0.25f).toPx()
        val y2 = (size * 0.75f).toPx()
        val x = (size / 2).toPx()
        drawLine(
            color = Color(color.color),
            start = Offset(x, y1),
            end = Offset(x, y2),
            strokeWidth = trackStrokeWidth
        )
    }
}

private fun DrawScope.drawEndingTrack(size: Dp) {
    drawHorizontalTrack(size, color = Color.Red)
}

private fun DrawScope.drawDownRightTurn(size: Dp, color: Color) {
    drawTurn(size, 180f, color)
}

private fun DrawScope.drawDownLeftTurn(size: Dp, color: Color) {
    drawTurn(size, 270f, color)
}

private fun DrawScope.drawUpRightTurn(size: Dp, color: Color) {
    drawTurn(size, 90f, color)
}

private fun DrawScope.drawUpLeftTurn(size: Dp, color: Color) {
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

private fun DrawScope.drawDownLeftRightFork(size: Dp, color: Color) {
    drawDownLeftTurn(size, color)
    drawHorizontalTrack(size, color)
}

private fun DrawScope.drawDownLeftUpFork(size: Dp, color: Color) {
    drawDownLeftTurn(size, color)
    drawVerticalTrack(size, color)
}

private fun DrawScope.drawDownRightLeftFork(size: Dp, color: Color) {
    drawDownRightTurn(size, color)
    drawHorizontalTrack(size, color)
}

private fun DrawScope.drawDownRightUpFork(size: Dp, color: Color) {
    drawDownRightTurn(size, color)
    drawVerticalTrack(size, color)
}

private fun DrawScope.drawUpLeftDownFork(size: Dp, color: Color) {
    drawUpLeftTurn(size, color)
    drawVerticalTrack(size, color)
}

private fun DrawScope.drawUpLeftRightFork(size: Dp, color: Color) {
    drawUpLeftTurn(size, color)
    drawHorizontalTrack(size, color)
}

private fun DrawScope.drawUpRightDownFork(size: Dp, color: Color) {
    drawUpRightTurn(size, color)
    drawVerticalTrack(size, color)
}

private fun DrawScope.drawUpRightLeftFork(size: Dp, color: Color) {
    drawUpRightTurn(size, color)
    drawHorizontalTrack(size, color)
}

private fun DrawScope.drawDownTunnel(size: Dp, color: TunnelColor) {
    drawVerticalTrack(size, fixedTrackColor)
    drawArc(
        color = Color(color.color),
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
        color = Color(color.color),
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
        color = Color(color.color),
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
        color = Color(color.color),
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

@Preview
@Composable
private fun TilePreview() {
    Tile(
        tile = FixedHorizontalTrack(ToggleBarrier(DARK_GREEN)),
        size = 100.dp
    )
}