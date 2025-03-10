package solver

import kotlinx.collections.immutable.PersistentMap
import kotlinx.collections.immutable.PersistentSet
import kotlinx.collections.immutable.minus
import kotlinx.collections.immutable.persistentMapOf
import kotlinx.collections.immutable.persistentSetOf
import kotlinx.collections.immutable.plus
import model.CarPosition

@JvmInline
value class CarBreadcrumbs(private val breadcrumbs: PersistentMap<Int, PersistentSet<CarPosition>>) {
    constructor() : this(persistentMapOf())

    fun plus(carNumber: Int, position: CarPosition): CarBreadcrumbs {
        return if (carNumber in breadcrumbs) {
            CarBreadcrumbs(breadcrumbs.plus(carNumber to breadcrumbs.getValue(carNumber).plus(position)))
        } else {
            CarBreadcrumbs(breadcrumbs.plus(carNumber to persistentSetOf(position)))
        }
    }

    fun reset(carNumber: Int): CarBreadcrumbs {
        return CarBreadcrumbs(breadcrumbs.minus(carNumber))
    }

    fun contains(carNumber: Int, position: CarPosition): Boolean {
        return carNumber in breadcrumbs && breadcrumbs.getValue(carNumber).contains(position)
    }
}