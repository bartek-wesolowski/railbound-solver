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
import model.Solutions
import solver.Solver

private val tileSize = 70.dp
private const val levelName = "2-9"
private val level = Levels.World2.levels.getValue(levelName)
private val predefinedSolutions = Solutions.World2.solutions.getValue(levelName)
private val predefinedSolution = predefinedSolutions.first()
private val solver = Solver()
private val solverSolutions = solver.findSolutions(level)

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
                    solverStates = solver.getSolverStates(level)
                        .filter { it.board.matches(predefinedSolution) },
                    tileSize = tileSize,
                )
                Solutions(
                    solutions = if (solverSolutions.isNotEmpty()) solverSolutions else predefinedSolutions,
                    tileSize = tileSize,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}
