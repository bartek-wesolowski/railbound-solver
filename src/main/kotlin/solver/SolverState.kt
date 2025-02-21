package solver

import model.Action
import model.Board
import model.Car
import model.Direction
import model.Position
import model.Tile
import java.util.EnumSet

data class SolverState(
    val board: Board,
    val activeCars: List<Car>,
    val tracksUsed: Int,
    val expectedCar: Int,
    val traverseDirections: Map<Position, EnumSet<Direction>>,
    val enterTiles: Map<Position, Tile>,
) {
    private val hashCode: Int by lazy(LazyThreadSafetyMode.NONE) {
        var result = board.hashCode()
        result = 31 * result + activeCars.hashCode()
        result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SolverState) return false

        if (board != other.board) return false
        if (activeCars != other.activeCars) return false

        return true
    }

    override fun hashCode(): Int = hashCode

    fun apply(action: Action): SolverState {
        return copy(board = board.apply(action))
    }
}