package compose

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import model.ExpectedCars
import model.Levels
import solver.SolverState

@Composable
fun SolverState(
    state: SolverState,
    tileSize: Dp,
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        Board(state.board, tileSize)
        state.activeCars.forEach { car ->
            Car(
                car,
                tileSize,
                Modifier.offset(
                    x = tileSize * car.position.column,
                    y = tileSize * car.position.row
                )
            )
        }
        // uncomment to show traverse directions
//        for ((position, directions) in state.traverseDirections) {
//            Text(
//                directions.toString(),
//                Modifier.offset(
//                    x = tileSize * position.column,
//                    y = tileSize * position.row
//                )
//            )
//        }
    }
}

@Preview
@Composable
private fun SolverStatePreview() {
    val level = Levels.World1.level1_11A
    SolverState(
        state = SolverState(
            board = level.board,
            activeCars = level.cars,
            tracksUsed = 0,
            expectedCars = ExpectedCars(level.cars),
            traverseDirections = emptyMap(),
        ),
        tileSize = 100.dp
    )
}