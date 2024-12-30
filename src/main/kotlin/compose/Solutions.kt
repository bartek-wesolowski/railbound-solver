package compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.onClick
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import model.Board

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Solutions(
    solutions: Iterable<Board>,
    tileSize: Dp,
    modifier: Modifier = Modifier,
) {
    val iterator by remember { mutableStateOf(solutions.iterator()) }
    var solution by remember { mutableStateOf(iterator.next()) }
    Board(
        board = solution,
        tileSize = tileSize,
        modifier = modifier.onClick {
            if (iterator.hasNext()) {
                solution = iterator.next()
            }
        }
    )
}