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
import model.Action.Toggle
import model.Barrier
import model.HasAction
import model.Tile
import model.Tile.BaseHorizontalTrack.FixedHorizontalTrack
import model.Tile.BaseHorizontalTrack.HorizontalBarrier
import model.Tile.BaseHorizontalTrack.HorizontalTrack
import model.Tile.BaseVerticalTrack.FixedVerticalTrack
import model.Tile.BaseVerticalTrack.VerticalBarrier
import model.Tile.BaseVerticalTrack.VerticalTrack
import model.Tile.DownTunnel
import model.Tile.Empty
import model.Tile.EndingTrack
import model.Tile.Fork.BaseDownLeftRightFork.DownLeftRightFork
import model.Tile.Fork.BaseDownLeftRightFork.DownLeftRightToggle
import model.Tile.Fork.BaseDownLeftRightFork.DownLeftRightToggleableFork
import model.Tile.Fork.BaseDownLeftRightFork.FixedDownLeftRightFork
import model.Tile.Fork.BaseDownLeftUpFork.DownLeftUpFork
import model.Tile.Fork.BaseDownLeftUpFork.DownLeftUpToggle
import model.Tile.Fork.BaseDownLeftUpFork.DownLeftUpToggleableFork
import model.Tile.Fork.BaseDownLeftUpFork.FixedDownLeftUpFork
import model.Tile.Fork.BaseDownRightLeftFork.DownRightLeftFork
import model.Tile.Fork.BaseDownRightLeftFork.DownRightLeftToggle
import model.Tile.Fork.BaseDownRightLeftFork.DownRightLeftToggleableFork
import model.Tile.Fork.BaseDownRightLeftFork.FixedDownRightLeftFork
import model.Tile.Fork.BaseDownRightUpFork.DownRightUpFork
import model.Tile.Fork.BaseDownRightUpFork.DownRightUpToggle
import model.Tile.Fork.BaseDownRightUpFork.DownRightUpToggleableFork
import model.Tile.Fork.BaseDownRightUpFork.FixedDownRightUpFork
import model.Tile.Fork.BaseUpLeftDownFork.FixedUpLeftDownFork
import model.Tile.Fork.BaseUpLeftDownFork.UpLeftDownFork
import model.Tile.Fork.BaseUpLeftDownFork.UpLeftDownToggle
import model.Tile.Fork.BaseUpLeftDownFork.UpLeftDownToggleableFork
import model.Tile.Fork.BaseUpLeftRightFork.FixedUpLeftRightFork
import model.Tile.Fork.BaseUpLeftRightFork.UpLeftRightFork
import model.Tile.Fork.BaseUpLeftRightFork.UpLeftRightToggle
import model.Tile.Fork.BaseUpLeftRightFork.UpLeftRightToggleableFork
import model.Tile.Fork.BaseUpRightDownFork.FixedUpRightDownFork
import model.Tile.Fork.BaseUpRightDownFork.UpRightDownFork
import model.Tile.Fork.BaseUpRightDownFork.UpRightDownToggle
import model.Tile.Fork.BaseUpRightDownFork.UpRightDownToggleableFork
import model.Tile.Fork.BaseUpRightLeftFork.FixedUpRightLeftFork
import model.Tile.Fork.BaseUpRightLeftFork.UpRightLeftFork
import model.Tile.Fork.BaseUpRightLeftFork.UpRightLeftToggle
import model.Tile.Fork.BaseUpRightLeftFork.UpRightLeftToggleableFork
import model.Tile.LeftTunnel
import model.Tile.Obstacle
import model.Tile.RightTunnel
import model.Tile.Turn
import model.Tile.Turn.BaseDownLeftTurn.DownLeftToggle
import model.Tile.Turn.BaseDownLeftTurn.DownLeftTurn
import model.Tile.Turn.BaseDownLeftTurn.FixedDownLeftTurn
import model.Tile.Turn.BaseDownRightTurn.DownRightToggle
import model.Tile.Turn.BaseDownRightTurn.DownRightTurn
import model.Tile.Turn.BaseDownRightTurn.FixedDownRightTurn
import model.Tile.Turn.BaseUpLeftTurn.FixedUpLeftTurn
import model.Tile.Turn.BaseUpLeftTurn.UpLeftTurn
import model.Tile.Turn.BaseUpRightTurn.FixedUpRightTurn
import model.Tile.Turn.BaseUpRightTurn.UpRightBarrier
import model.Tile.Turn.BaseUpRightTurn.UpRightToggle
import model.Tile.Turn.BaseUpRightTurn.UpRightTurn
import model.Tile.UpTunnel
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
            is HorizontalTrack -> drawHorizontalTrack(size, trackColor)
            is FixedHorizontalTrack -> drawHorizontalTrack(size, fixedTrackColor)
            is HorizontalBarrier -> drawHorizontalBarrier(size, tile.getColor(), tile.open)
            is VerticalTrack -> drawVerticalTrack(size, trackColor)
            is FixedVerticalTrack -> drawVerticalTrack(size, fixedTrackColor)
            is VerticalBarrier -> drawVerticalBarrier(size, tile.getColor(), tile.open)
            is DownRightTurn -> drawDownRightTurn(size, trackColor)
            is FixedDownRightTurn -> drawDownRightTurn(size, fixedTrackColor)
            is DownRightToggle -> {
                drawDownRightTurn(size, fixedTrackColor)
                drawAction(size, tile.action)
            }
            is DownLeftTurn -> drawDownLeftTurn(size, trackColor)
            is FixedDownLeftTurn -> drawDownLeftTurn(size, fixedTrackColor)
            is DownLeftToggle -> {
                drawDownLeftTurn(size, trackColor)
                drawAction(size, tile.action)
            }
            is UpRightTurn -> drawUpRightTurn(size, trackColor)
            is FixedUpRightTurn -> drawUpRightTurn(size, fixedTrackColor)
            is UpRightToggle -> {
                drawUpRightTurn(size, trackColor)
                drawAction(size, tile.action)
            }
            is UpLeftTurn -> drawUpLeftTurn(size, trackColor)
            is FixedUpLeftTurn -> drawUpLeftTurn(size, fixedTrackColor)
            is Turn.BaseUpLeftTurn.UpLeftToggle -> {
                drawUpLeftTurn(size, trackColor)
                drawAction(size, tile.action)
            }
            is UpRightBarrier -> drawUpRightBarrier(size, tile.getColor(), tile.open)

            is DownLeftRightFork -> drawDownLeftRightFork(size, trackColor)
            is FixedDownLeftRightFork -> drawDownLeftRightFork(size, fixedTrackColor)
            is DownLeftRightToggle -> {
                drawDownLeftRightFork(size, fixedTrackColor)
                drawAction(size, tile.action)
            }
            is DownLeftRightToggleableFork -> drawDownLeftRightFork(size, Color(tile.color.color))

            is DownLeftUpFork -> drawDownLeftUpFork(size, trackColor)
            is FixedDownLeftUpFork -> drawDownLeftUpFork(size, fixedTrackColor)
            is DownLeftUpToggle -> {
                drawDownLeftUpFork(size, fixedTrackColor)
                drawAction(size, tile.action)
            }
            is DownLeftUpToggleableFork -> drawDownLeftUpFork(size, Color(tile.color.color))

            is DownRightLeftFork -> drawDownRightLeftFork(size, trackColor)
            is FixedDownRightLeftFork -> drawDownRightLeftFork(size, fixedTrackColor)
            is DownRightLeftToggle -> {
                drawDownRightLeftFork(size, fixedTrackColor)
                drawAction(size, tile.action)
            }
            is DownRightLeftToggleableFork -> drawDownRightLeftFork(size, Color(tile.color.color))

            is DownRightUpFork -> drawDownRightUpFork(size, trackColor)
            is FixedDownRightUpFork -> drawDownRightUpFork(size, fixedTrackColor)
            is DownRightUpToggle -> {
                drawDownRightUpFork(size, fixedTrackColor)
                drawAction(size, tile.action)
            }
            is DownRightUpToggleableFork -> drawDownRightUpFork(size, Color(tile.color.color))

            is UpLeftDownFork -> drawUpLeftDownFork(size, trackColor)
            is FixedUpLeftDownFork -> drawUpLeftDownFork(size, fixedTrackColor)
            is UpLeftDownToggle -> {
                drawUpLeftDownFork(size, fixedTrackColor)
                drawAction(size, tile.action)
            }
            is UpLeftDownToggleableFork -> drawUpLeftDownFork(size, Color(tile.color.color))

            is UpLeftRightFork -> drawUpLeftRightFork(size, trackColor)
            is FixedUpLeftRightFork -> drawUpLeftRightFork(size, fixedTrackColor)
            is UpLeftRightToggleableFork -> drawUpLeftRightFork(size, Color(tile.color.color))
            is UpLeftRightToggle -> {
                drawUpLeftRightFork(size, trackColor)
                drawAction(size, tile.action)
            }

            is UpRightDownFork -> drawUpRightDownFork(size, trackColor)
            is FixedUpRightDownFork -> drawUpRightDownFork(size, fixedTrackColor)
            is UpRightDownToggle -> {
                drawUpRightDownFork(size, fixedTrackColor)
                drawAction(size, tile.action)
            }
            is UpRightDownToggleableFork -> drawUpRightDownFork(size, Color(tile.color.color))

            is UpRightLeftFork -> drawUpRightLeftFork(size, trackColor)
            is FixedUpRightLeftFork -> drawUpRightLeftFork(size, fixedTrackColor)
            is UpRightLeftToggle -> {
                drawUpRightLeftFork(size, fixedTrackColor)
                drawAction(size, tile.action)
            }
            is UpRightLeftToggleableFork -> drawUpRightLeftFork(size, Color(tile.color.color))

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

private fun Barrier.getColor() = Color(color.color)

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

private fun DrawScope.drawVerticalBarrier(size: Dp, color: Color, open: Boolean) {
    drawVerticalTrack(size, fixedTrackColor)
    val trackStrokeWidth = getTrackStrokeWidth(size)
    if (open) {
        val x1 = (size * 0.25f).toPx()
        val y1 = (size / 2).toPx()
        val x2 = (size * 0.35f).toPx()
        val y2 = (size * 0.05f).toPx()
        drawLine(
            color = color,
            start = Offset(x1, y1),
            end = Offset(x2, y2),
            strokeWidth = trackStrokeWidth
        )
    } else {
        val x1 = (size * 0.25f).toPx()
        val x2 = (size * 0.75f).toPx()
        val y = (size / 2).toPx()
        drawLine(
            color = color,
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
        is Toggle -> drawSwitch(size, Color(action.color.color))
        null -> Unit
    }
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

private fun DrawScope.drawHorizontalBarrier(size: Dp, color: Color, open: Boolean) {
    drawHorizontalTrack(size, fixedTrackColor)
    val trackStrokeWidth = getTrackStrokeWidth(size)
    if (open) {
        val x1 = (size / 2).toPx()
        val y1 = (size * 0.75f).toPx()
        val y2 = (size * 0.65f).toPx()
        val x2 = (size * 0.95f).toPx()
        drawLine(
            color = color,
            start = Offset(x1, y1),
            end = Offset(x2, y2),
            strokeWidth = trackStrokeWidth
        )
    } else {
        val y1 = (size * 0.25f).toPx()
        val y2 = (size * 0.75f).toPx()
        val x = (size / 2).toPx()
        drawLine(
            color = color,
            start = Offset(x, y1),
            end = Offset(x, y2),
            strokeWidth = trackStrokeWidth
        )
    }
}

private fun DrawScope.drawUpRightBarrier(size: Dp, color: Color, open: Boolean) {
    drawUpRightTurn(size, fixedTrackColor)
    val trackStrokeWidth = getTrackStrokeWidth(size)
    if (open) {
        val x1 = (size * 0.2f).toPx()
        val y1 = (size * 0.8f).toPx()
        val x2 = (size * 0.4f).toPx()
        val y2 = (size * 0.15f).toPx()
        drawLine(
            color = color,
            start = Offset(x1, y1),
            end = Offset(x2, y2),
            strokeWidth = trackStrokeWidth
        )
    } else {
        val x1 = (size * 0.2f).toPx()
        val y1 = (size * 0.8f).toPx()
        val x2 = (size * 0.8f).toPx()
        val y2 = (size * 0.2f).toPx()
        drawLine(
            color = color,
            start = Offset(x1, y1),
            end = Offset(x2, y2),
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
        tile = UpRightBarrier(model.Color.PURPLE, open = true),
        size = 100.dp
    )
}