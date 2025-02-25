package model

import java.util.EnumSet

data class Breadcrumb(
    val cars: List<Car>,
    val toggledColors: EnumSet<Color>
)