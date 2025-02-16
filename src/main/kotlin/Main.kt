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
private const val levelName = "4-2"
private val level = Levels.levels.getValue(levelName)
private val predefinedSolutions = Solutions.solutions.getValue(levelName)
private val solver = Solver()
private val solverSolutions = solver.findSolutions(level)
private val solutions = solverSolutions.ifEmpty { predefinedSolutions }

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
                        .filter { state -> solutions.any { state.board.matches(it) } },
                    carColor = level.carColor,
                    tileSize = tileSize,
                )
                Solutions(
                    solutions = solutions,
                    cars = level.cars,
                    tileSize = tileSize,
                    carColor = level.carColor,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}
