package solver

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.PersistentSet
import model.Board
import model.Breadcrumb
import model.Car
import model.Color
import model.Direction
import model.Position
import model.Tile
import java.util.EnumSet

data class SolverState(
    val board: Board,
    val activeCars: PersistentList<Car>,
    val tracks: Int,
    val expectedCar: Int,
    val traverseDirections: Map<Position, EnumSet<Direction>>,
    val enterTiles: Map<Position, Tile>,
    val getInProgress: GetInProgress,
    val toggledColors: EnumSet<Color>,
    val toggledForks: PersistentSet<Position>,
    val requiredTilesRemaining: PersistentSet<Position>,
    val breadcrumbs: PersistentSet<Breadcrumb>,
    val carBreadcrumbs: CarBreadcrumbs,
) {
    fun createBreadcrumb() = Breadcrumb(activeCars, toggledColors, toggledForks, getInProgress)
}