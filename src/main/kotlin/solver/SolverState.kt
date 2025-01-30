package solver

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import model.Action
import model.Board
import model.Car
import model.ExpectedCars

data class SolverState(
    val board: Board,
    val activeCars: ImmutableArray<Car>,
    val tracksUsed: Int,
    val expectedCars: ExpectedCars,
) {
    override fun toString(): String {
        return "SolverState(\nboard=$board,\nactiveCars=$activeCars,\ntracksUsed=$tracksUsed,\nexpectedCar=$expectedCars\n)"
    }

    fun apply(action: Action): SolverState {
        return copy(board = board.apply(action))
    }
}