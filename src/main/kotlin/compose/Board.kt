package compose

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import model.Board
import model.Solutions

@Composable
fun Board(
    board: Board,
    tileSize: Dp,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        board.tiles.forEach { row ->
            Row {
                row.forEach { tile ->
                    Tile(tile, tileSize)
                }
            }
        }
    }
}

@Preview
@Composable
private fun BoardPreview() {
    Board(
        Solutions.World1.level1_11A.first(),
        tileSize = 100.dp
    )
}