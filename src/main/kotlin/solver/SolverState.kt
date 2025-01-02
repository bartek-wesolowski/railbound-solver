package solver

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import model.Board
import model.Car
import model.CarColor
import java.util.EnumMap

data class SolverState(
    val board: Board,
    val activeCars: ImmutableArray<Car>,
    val tracksUsed: Int,
    val expectedCar: EnumMap<CarColor, Int>
) {
    override fun toString(): String {
        return "SolverState(\nboard=$board,\nactiveCars=$activeCars,\ntracksUsed=$tracksUsed,\nexpectedCar=$expectedCar\n)"
    }
}