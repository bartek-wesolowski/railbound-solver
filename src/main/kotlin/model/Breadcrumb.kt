package model

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.PersistentSet
import solver.GetInProgress
import java.util.EnumSet

data class Breadcrumb(
    val cars: PersistentList<Car>,
    val toggledColors: EnumSet<Color>,
    val toggledForks: PersistentSet<Position>,
    val getInProgress: GetInProgress,
)