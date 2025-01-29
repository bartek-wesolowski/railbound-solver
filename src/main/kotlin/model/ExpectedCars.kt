package model

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import java.util.EnumMap

class ExpectedCars private constructor(
    private val expectedCars: EnumMap<CarColor, Int>
) {
    constructor(cars: ImmutableArray<Car>) : this(
        EnumMap<CarColor, Int>(CarColor::class.java).apply {
            cars.forEach { put(it.color, 1) }
        }
    )

    fun isExpected(car: Car): Boolean = expectedCars.getValue(car.color) == car.number

    fun withNextExpected(carColor: CarColor): ExpectedCars {
        val newExpectedCars = EnumMap(expectedCars)
        newExpectedCars[carColor] = newExpectedCars.getValue(carColor) + 1
        return ExpectedCars(newExpectedCars)
    }

    override fun equals(other: Any?): Boolean {
        return expectedCars.equals((other as? ExpectedCars)?.expectedCars)
    }

    override fun hashCode(): Int {
        return expectedCars.hashCode()
    }

    override fun toString(): String {
        return expectedCars.toString()
    }
}