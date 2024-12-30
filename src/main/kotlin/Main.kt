import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import compose.Solutions
import compose.SolverStates
import model.Levels
import solver.Solver

private val tileSize = 100.dp
private val level = Levels.World1.level1_13A
private val solver = Solver()

fun main() = application {
    Window(
        title = "Railbound Solver",
        state = WindowState(
            size = DpSize(
                width = tileSize * level.board.columns * 2 + 16.dp,
                height = tileSize * level.board.rows + 28.dp
            )
        ),
        onCloseRequest = ::exitApplication
    ) {
        MaterialTheme {
            Row {
                SolverStates(
                    solverStates = solver.getSolverStates(level),
                    tileSize = tileSize,
                )
                Solutions(
                    solutions = solver.findSolutions(level),
                    tileSize = tileSize,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}
