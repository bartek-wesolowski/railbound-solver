package model

data class Car(
    val number: Int,
    val position: CarPosition,
) {
    val direction = position.direction
}