package model

sealed class Action {
    data class ToggleBarrier(val color: BarrierColor) : Action()
}
