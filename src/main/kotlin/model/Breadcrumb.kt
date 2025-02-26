package model

import kotlinx.collections.immutable.PersistentList
import java.util.EnumSet

data class Breadcrumb(
    val cars: PersistentList<Car>,
    val toggledColors: EnumSet<Color>
)