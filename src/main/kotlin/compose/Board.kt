package compose

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import model.Board
import model.Solutions

@Composable
fun Board(
    board: Board
) {
    Column {
        board.tiles.forEach { row ->
            Row {
                row.forEach { tile ->
                    Tile(tile)
                }
            }
        }
    }
}

@Preview
@Composable
private fun BoardPreview() {
    MaterialTheme {
        Board(
            Solutions.World1.level1_11A.first()
        )
    }
}