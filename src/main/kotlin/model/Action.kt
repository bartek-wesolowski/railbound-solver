package model

sealed class Action {
    data class ToggleBarrier(val row: Int, val column: Int) : Action()
}
