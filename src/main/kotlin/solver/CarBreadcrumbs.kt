package solver

import kotlinx.collections.immutable.PersistentSet
import kotlinx.collections.immutable.persistentSetOf
import kotlinx.collections.immutable.plus
import model.Car
import model.CarPosition

@JvmInline
value class CarBreadcrumbs private constructor(
    private val breadcrumbs: Array<PersistentSet<CarPosition>?>
) {
    constructor(cars: Collection<Car>) : this(
        Array(cars.size) { index ->
            persistentSetOf(cars.first { it.number - 1 == index }.position)
        }
    )

    fun plus(carNumber: Int, position: CarPosition): CarBreadcrumbs {
        return if (breadcrumbs[carNumber - 1] != null) {
            CarBreadcrumbs(
                breadcrumbs.copyOf().apply {
                    set(carNumber - 1, get(carNumber - 1)!!.plus(position))
                }
            )
        } else {
            CarBreadcrumbs(
                breadcrumbs.copyOf().apply {
                    set(carNumber - 1, persistentSetOf(position))
                }
            )
        }
    }

    fun reset(carNumber: Int): CarBreadcrumbs {
        return CarBreadcrumbs(
            breadcrumbs.copyOf().apply {
                set(carNumber - 1, null)
            }
        )
    }

    fun contains(carNumber: Int, position: CarPosition): Boolean {
        return breadcrumbs[carNumber - 1]?.contains(position) ?: false
    }
}