package solver

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import model.Action

data class PartialSolverState(
    val state: SolverState,
    val actions: ImmutableArray<Action>,
) {
    fun applyActions(): SolverState {
        var newState = state
        for (action in actions) {
            newState = newState.apply(action)
        }
        return newState
    }
}