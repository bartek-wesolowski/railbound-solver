package solver

import model.Action
import model.Action.TakePassenger
import model.Car

class GetInProgress private constructor(
    private val progress: Array<Int?>
) {
    constructor(cars: Collection<Car>) : this(Array(cars.size) { null })

    operator fun get(carNumber: Int) = progress[carNumber - 1]

    fun update(actions: List<Action>): GetInProgress {
        if (progress.isEmpty() && actions.none { it is TakePassenger }) return this
        val newProgress = progress.copyOf()
        for (i in progress.indices) {
            val carProgress = progress[i]
            if (carProgress != null) {
                if (carProgress == 0) {
                    newProgress[i] = 1
                } else {
                    newProgress[i] = null
                }
            }
        }
        for (action in actions) {
            if (action is TakePassenger) {
                newProgress[action.carNumber - 1] = 0
            }
        }
        return if (newProgress.all { it == null }) {
            EMPTY[progress.size - 1]
        } else {
            GetInProgress(newProgress)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GetInProgress) return false
        return progress.contentEquals(other.progress)
    }

    override fun hashCode(): Int = progress.contentHashCode()

    private companion object {
        val EMPTY: Array<GetInProgress> = arrayOf(
            GetInProgress(arrayOfNulls(1)),
            GetInProgress(arrayOfNulls(2)),
            GetInProgress(arrayOfNulls(3)),
            GetInProgress(arrayOfNulls(4)),
        )
    }
}