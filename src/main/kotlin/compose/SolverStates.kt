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
import solver.SolverState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SolverStates(
    solverStates: Sequence<SolverState>,
    tileSize: Dp,
    modifier: Modifier = Modifier,
) {
    val iterator by remember { mutableStateOf(solverStates.iterator()) }
    var state by remember { mutableStateOf(iterator.next()) }
    SolverState(
        state = state,
        tileSize = tileSize,
        modifier = modifier.onClick {
            if (iterator.hasNext()) {
                state = iterator.next()
            }
        }
    )
}