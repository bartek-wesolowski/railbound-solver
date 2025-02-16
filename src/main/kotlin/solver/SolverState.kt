package solver

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import model.Action
import model.Board
import model.Car
import model.Direction
import model.Position
import model.Tile
import java.util.EnumSet

data class SolverState(
    val board: Board,
    val activeCars: ImmutableArray<Car>,
    val tracksUsed: Int,
    val expectedCar: Int,
    val traverseDirections: Map<Position, EnumSet<Direction>>,
    val enterTiles: Map<Position, Tile>,
) {
    private val hashCode by lazy(LazyThreadSafetyMode.NONE) {
        var result = board.hashCode()
        result = 31 * result + activeCars.hashCode()
        result = 31 * result + tracksUsed
        result = 31 * result + expectedCar
        result
    }

    override fun hashCode(): Int = hashCode

    fun apply(action: Action): SolverState {
        return copy(board = board.apply(action))
    }
}