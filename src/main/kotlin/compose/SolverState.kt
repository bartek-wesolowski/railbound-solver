package compose

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import model.CarColor
import model.Levels
import solver.SolverState

@Composable
fun SolverState(
    state: SolverState,
    carColor: CarColor,
    tileSize: Dp,
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        Board(state.board, tileSize)
        Cars(state.activeCars, carColor, tileSize)
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
            expectedCar = 1,
            traverseDirections = emptyMap(),
            enterTiles = emptyMap(),
        ),
        carColor = CarColor.RED,
        tileSize = 100.dp
    )
}