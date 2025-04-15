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

    val lastIndex: Int
        get() = list.lastIndex

    operator fun get(index: Int): Car = list[index]


    fun withNewCarPosition(carIndex: Int, carPosition: CarPosition): Cars {
        val builder = list.builder()
        builder[carIndex] = get(carIndex).copy(position = carPosition)
        return Cars(builder.build())
    }

    fun removeAt(position: Int): Cars = Cars(list.removeAt(position))
}