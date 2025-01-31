package model

import com.danrusu.pods4k.immutableArrays.ImmutableArray
import com.danrusu.pods4k.immutableArrays.buildImmutableArray
import com.danrusu.pods4k.immutableArrays.toImmutableArray
import model.Action.ToggleBarrier
import model.Direction.DOWN
import model.Direction.LEFT
import model.Direction.RIGHT
import model.Direction.UP
import model.Tile.BaseHorizontalTrack.HorizontalBarrier
import model.Tile.BaseVerticalTrack.VerticalBarrier
import util.mapAt

data class Board(val tiles: ImmutableArray<ImmutableArray<Tile>>) {
    operator fun get(row: Int, column: Int): Tile {
        return tiles[row][column]
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

    fun canInsert(row: Int, column: Int, tile: Tile): Boolean {
        if (row < 0 || row >= rows) return false
        if (column < 0 || column >= columns) return false
        if (tiles[row][column] !is Tile.Empty) return false

        if (DOWN in tile.incomingDirections && row == 0) return false
        if (UP in tile.incomingDirections && row == rows - 1) return false
        if (RIGHT in tile.incomingDirections && column == 0) return false
        if (LEFT in tile.incomingDirections && column == columns - 1) return false

        if (
            DOWN in tile.incomingDirections &&
            tiles[row - 1][column] != Tile.Empty &&
            !tiles[row - 1][column].isValidIncomingDirection(UP)
        ) return false
        if (
            UP in tile.incomingDirections &&
            tiles[row + 1][column] != Tile.Empty &&
            !tiles[row + 1][column].isValidIncomingDirection(DOWN)
        ) return false
        if (
            RIGHT in tile.incomingDirections &&
            tiles[row][column - 1] != Tile.Empty &&
            !tiles[row][column - 1].isValidIncomingDirection(LEFT)
        ) return false
        if (
            LEFT in tile.incomingDirections &&
            tiles[row][column + 1] != Tile.Empty &&
            !tiles[row][column + 1].isValidIncomingDirection(RIGHT)
        ) return false

        return true
    }

    fun withInserted(row: Int, column: Int, direction: Direction, tile: Tile): Board {
        // TODO possibly also modify the neighbors
        // TODO check if the next tile is properly attached when moving cars
        return with(row, column, tile)
    }

    fun with(row: Int, column: Int, tile: Tile): Board = Board(
        tiles.mapAt(row) { rowTiles ->
            rowTiles.mapAt(column) { tile }
        }
    )

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
                val tile = tiles[action.row][action.column]
                if (tile !is Barrier) throw IllegalStateException("Cannot toggle a non-barrier tile")
                when (tile) {
                    is HorizontalBarrier -> with(action.row, action.column, tile.toggled())
                    is VerticalBarrier -> with(action.row, action.column, tile.toggled())
                }
            }
        }
    }

    companion object {
        fun buildBoard(
            rows: Int,
            initializer: ImmutableArray.Builder<ImmutableArray<Tile>>.() -> Unit
        ) = Board(
            buildImmutableArray(rows) {
                initializer()
            }
        )

        fun ImmutableArray.Builder<ImmutableArray<Tile>>.row(vararg tiles: Tile) {
            add(tiles.toImmutableArray())
        }
    }
}