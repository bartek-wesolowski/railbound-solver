package model

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import com.danrusu.pods4k.immutableArrays.buildImmutableArray
import com.danrusu.pods4k.immutableArrays.toImmutableArray
import model.Action.ToggleBarrier
import model.Action.ToggleFork
import model.Direction.DOWN
import model.Direction.LEFT
import model.Direction.RIGHT
import model.Direction.UP
import model.Tile.*
import model.Tile.BaseHorizontalTrack.FixedHorizontalTrack
import model.Tile.BaseHorizontalTrack.HorizontalBarrier
import model.Tile.BaseVerticalTrack.*
import util.mapAt
import java.util.EnumSet

data class Board(
    val tiles: ImmutableArray<ImmutableArray<Tile>>,
    val barriers: Map<BarrierColor, List<Position>>,
    val toggleableForks: Map<ForkColor, List<Position>>,
) {
    constructor(tiles: ImmutableArray<ImmutableArray<Tile>>, requireFixed: Boolean) : this(
        tiles = tiles,
        barriers = buildMap {
            for (r in tiles.indices) {
                for (c in tiles[r].indices) {
                    val tile = tiles[r][c]
                    if (tile is Barrier) {
                        val position = Position(r, c)
                        if (tile.color in keys) {
                            put(tile.color, getValue(tile.color) + position)
                        } else {
                            put(tile.color, listOf(Position(r, c)))
                        }
                    }
                }
            }
            require(values.all { it.isNotEmpty() })
        },
        toggleableForks = buildMap {
            for (r in tiles.indices) {
                for (c in tiles[r].indices) {
                    val tile = tiles[r][c]
                    if (tile is Fork && tile.color != null) {
                        val color = tile.color!!
                        val position = Position(r, c)
                        if (tile.color in keys) {
                            put(color, getValue(color) + position)
                        } else {
                            put(color, listOf(Position(r, c)))
                        }
                    }
                }
            }
            require(values.all { it.isNotEmpty() })
        },
    ) {
        if (requireFixed) {
            for (r in tiles.indices) {
                for (c in tiles[r].indices) {
                    val tile = tiles[r][c]
                    require(
                        tile is Empty ||
                        tile is EndingTrack ||
                        tile is Obstacle ||
                        tile is Tunnel ||
                        tile is HorizontalBarrier ||
                        tile is VerticalBarrier ||
                        tile is FixedHorizontalTrack ||
                                tile is FixedVerticalTrack ||
                                (tile is Turn && tile.fixed) ||
                                (tile is Fork && tile.fixed)
                    ) {
                        "All tiles must be fixed, but found $tile at $r, $c"
                    }
                }
            }
        }
    }

    operator fun get(row: Int, column: Int): Tile {
        return tiles[row][column]
    }

    operator fun get(position: Position): Tile {
        return tiles[position.row][position.column]
    }

    val rows: Int = tiles.size
    val columns: Int = tiles.first().size

    override fun toString(): String {
        val sb = StringBuilder("[\n")
        for (row in tiles) {
            sb.appendLine("\t$row")
        }
        sb.append("]")
        return sb.toString()
    }

    fun canInsert(row: Int, column: Int, tile: Tile, traverseDirections: EnumSet<Direction>): Boolean {
        if (row < 0 || row >= rows) return false
        if (column < 0 || column >= columns) return false

        if (DOWN in tile.incomingDirections && row == 0) return false
        if (UP in tile.incomingDirections && row == rows - 1) return false
        if (RIGHT in tile.incomingDirections && column == 0) return false
        if (LEFT in tile.incomingDirections && column == columns - 1) return false

        if (
            DOWN in tile.incomingDirections &&
            tiles[row - 1][column] != Empty &&
            !tiles[row - 1][column].isValidIncomingDirection(UP, traverseDirections)
        ) return false
        if (
            UP in tile.incomingDirections &&
            tiles[row + 1][column] != Empty &&
            !tiles[row + 1][column].isValidIncomingDirection(DOWN, traverseDirections)
        ) return false
        if (
            RIGHT in tile.incomingDirections &&
            tiles[row][column - 1] != Empty &&
            !tiles[row][column - 1].isValidIncomingDirection(LEFT, traverseDirections)
        ) return false
        if (
            LEFT in tile.incomingDirections &&
            tiles[row][column + 1] != Empty &&
            !tiles[row][column + 1].isValidIncomingDirection(RIGHT, traverseDirections)
        ) return false

        return true
    }

    fun withInserted(row: Int, column: Int, direction: Direction, tile: Tile): Board {
        // TODO possibly also modify the neighbors
        // TODO check if the next tile is properly attached when moving cars
        return with(row, column, tile)
    }

    fun with(row: Int, column: Int, tile: Tile): Board = copy(
        tiles = tiles.mapAt(row) { rowTiles ->
            rowTiles.mapAt(column) { tile }
        }
    )

    fun with(position: Position, tile: Tile): Board = with(position.row, position.column, tile)

    fun matches(solution: Board): Boolean {
        for (r in tiles.indices) {
            for (c in tiles[r].indices) {
                if (!tiles[r][c].matches(solution.tiles[r][c])) return false
            }
        }
        return true
    }

    fun apply(action: Action): Board {
        return when (action) {
            is ToggleBarrier -> {
                val positions = barriers.getValue(action.color)
                var updatedBoard: Board = this
                for (position in positions) {
                    updatedBoard = updatedBoard.with(
                        position,
                        (tiles[position.row][position.column] as Barrier).toggled() as Tile
                    )
                }
                updatedBoard
            }

            is ToggleFork -> {
                val positions = toggleableForks.getValue(action.color)
                var updatedBoard: Board = this
                for (position in positions) {
                    updatedBoard = updatedBoard.with(
                        position,
                        (tiles[position.row][position.column] as Fork).toggled() as Tile
                    )
                }
                updatedBoard
            }
        }
    }

    companion object {
        fun buildBoard(
            rows: Int,
            requireFixed: Boolean = false,
            initializer: ImmutableArray.Builder<ImmutableArray<Tile>>.() -> Unit
        ) = Board(
            buildImmutableArray(rows) {
                initializer()
            },
            requireFixed
        )

        fun ImmutableArray.Builder<ImmutableArray<Tile>>.row(vararg tiles: Tile) {
            add(tiles.toImmutableArray())
        }
    }
}