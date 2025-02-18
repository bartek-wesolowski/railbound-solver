package solver

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import model.Action
import model.Position
import model.Tile

data class PartialSolverState(
    val state: SolverState,
    val actions: ImmutableArray<Action>,
    val enterTiles: Map<Position, Tile>,
) {
    fun applyActions(): SolverState {
        var newState = state
        for (action in actions) {
            newState = newState.apply(action)
        }
        return newState.copy(enterTiles = enterTiles)
    }
}