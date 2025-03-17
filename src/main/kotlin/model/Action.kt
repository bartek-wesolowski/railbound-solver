package model

sealed class Action {
    data class ToggleColor(val color: Color) : Action()
    data class ToggleFork(val row: Int, val column: Int) : Action()
    data class TakePassenger(val carNumber: Int, val platformPosition: Position) : Action()
}
