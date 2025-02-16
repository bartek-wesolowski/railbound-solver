package model

sealed class Action {
    data class ToggleBarrier(val color: Color) : Action()
    data class ToggleFork(val color: Color) : Action()
}
