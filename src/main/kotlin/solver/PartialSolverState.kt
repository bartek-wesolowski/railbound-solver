package solver

import model.Action

data class PartialSolverState(
    val state: SolverState,
    val actions: List<Action>,
) {
    fun applyActions(): SolverState {
        var newState = state
        for (action in actions) {
            newState = newState.apply(action)
        }
        return newState
    }
}