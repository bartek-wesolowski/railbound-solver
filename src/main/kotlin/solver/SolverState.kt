package solver

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import model.Action
import model.Board
import model.Car
import model.Direction
import model.ExpectedCars
import model.Position
import java.util.EnumSet

data class SolverState(
    val board: Board,
    val activeCars: ImmutableArray<Car>,
    val tracksUsed: Int,
    val expectedCars: ExpectedCars,
    val traverseDirections: Map<Position, EnumSet<Direction>>,
) {
    private val hashCode by lazy(LazyThreadSafetyMode.NONE) {
        var result = board.hashCode()
        result = 31 * result + activeCars.hashCode()
        result = 31 * result + tracksUsed
        result = 31 * result + expectedCars.hashCode()
        result
    }

    override fun hashCode(): Int = hashCode

    override fun toString(): String {
        return "SolverState(\nboard=$board,\nactiveCars=$activeCars,\ntracksUsed=$tracksUsed,\nexpectedCar=$expectedCars\n)"
    }

    fun apply(action: Action): SolverState {
        return copy(board = board.apply(action))
    }
}