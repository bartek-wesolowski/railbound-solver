package model

sealed class Action {
    data class ToggleColor(val color: Color) : Action()
    data class TakePassenger(val carNumber: Int, val platformPosition: Position) : Action()
}
