package model

import kotlinx.collections.immutable.PersistentList
import solver.GetInProgress
import java.util.EnumSet

data class Breadcrumb(
    val cars: PersistentList<Car>,
    val toggledColors: EnumSet<Color>,
    val getInProgress: GetInProgress,
)