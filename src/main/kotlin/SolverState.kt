package com.bartoszwesolowski

import java.util.EnumMap

data class SolverState(
    val board: Board,
    val activeCars: ArrayList<Car>,
    val tracksUsed: Int,
    val expectedCar: EnumMap<CarColor, Int>
) {
    override fun toString(): String {
        return "SolverState(\nboard=$board,\nactiveCars=$activeCars,\ntracksUsed=$tracksUsed,\nexpectedCar=$expectedCar\n)"
    }
}