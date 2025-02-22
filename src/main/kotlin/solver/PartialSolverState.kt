package solver

import model.Action
import model.Position
import model.Tile

data class PartialSolverState(
    val state: SolverState,
    val actions: List<Action>,
    val enterTiles: Map<Position, Tile>,
) {
    fun applyActions(): SolverState {
        var newState = state
        for (action in actions) {
            newState = newState.apply(action)
        }
        return newState
    }
}