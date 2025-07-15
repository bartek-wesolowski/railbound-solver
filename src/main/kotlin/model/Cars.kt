package model

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@JvmInline
value class Cars(private val list: PersistentList<Car>): Iterable<Car> {
    constructor(vararg cars: Car): this(persistentListOf(*cars))

    override fun iterator(): Iterator<Car> = list.iterator()

    val size: Int
        get() = list.size

    fun isEmpty(): Boolean = list.isEmpty()

    val firstNumber: Int
        get() = list.first().number

    val lastNumber: Int
        get() = list.last().number

    private fun index(carNumber: Int): Int = carNumber - firstNumber

    fun get(carNumber: Int): Car? {
        val index = index(carNumber)
        if (index < 0) return null
        return list[index]
    }

    fun withNewCarPosition(carNumber: Int, carPosition: CarPosition): Cars {
        val builder = list.builder()
        val index = index(carNumber)
        builder[index] = list[index].copy(position = carPosition)
        return Cars(builder.build())
    }

    fun removeCar(carNumber: Int): Cars {
        return Cars(list.removeAt(index(carNumber)))
    }
}