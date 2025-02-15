package model

sealed class Action {
    data class ToggleBarrier(val color: BarrierColor) : Action()
    data class ToggleFork(val color: ForkColor) : Action()
}
