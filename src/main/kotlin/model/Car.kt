package model

data class Car(
    val number: Int,
    val position: CarPosition,
) {
    val row = position.row
    val column = position.column
    val direction = position.direction
}