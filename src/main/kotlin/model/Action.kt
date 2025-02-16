package model

sealed class Action {
    data class Toggle(val color: Color) : Action()
}
