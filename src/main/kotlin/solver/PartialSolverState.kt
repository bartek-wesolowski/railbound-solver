package solver

import model.Action
import model.Position
import model.Tile

data class PartialSolverState(
    val state: SolverState,
    val actions: List<Action>,
    val enterTiles: Map<Position, Tile>,
)