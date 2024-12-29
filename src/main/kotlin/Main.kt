import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.onClick
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import compose.SolverState
import model.Levels
import solver.Solver
import solver.SolverState

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun App(
    solverStates: Sequence<SolverState>,
) {
    MaterialTheme {
        val iterator by remember { mutableStateOf(solverStates.iterator()) }
        var state by remember { mutableStateOf(iterator.next()) }
        SolverState(
            state = state,
            tileSize = 100.dp,
            modifier = Modifier.onClick {
                if (iterator.hasNext()) {
                    state = iterator.next()
                }
            }
        )
    }
}

fun main() = application {
    val solver = Solver()
    val solverStates = solver.getSolverStates(Levels.World1.level1_11)
    Window(
        title = "Railbound Solver",
        onCloseRequest = ::exitApplication
    ) {
        App(
            solverStates
        )
    }
}
