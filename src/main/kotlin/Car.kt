package com.bartoszwesolowski

data class Car(
    val number: Int,
    val color: CarColor,
    val position: CarPosition,
) {
    val direction = position.direction
}