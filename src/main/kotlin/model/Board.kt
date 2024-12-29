package model

import model.Direction.*
import com.danrusu.pods4k.immutableArrays.ImmutableArray
import com.danrusu.pods4k.immutableArrays.buildImmutableArray
import com.danrusu.pods4k.immutableArrays.toImmutableArray

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

    fun with(row: Int, column: Int, tile: Tile): Board {
        val newTiles = buildImmutableArray(tiles.size) {
            for (r in tiles.indices) {
                val tilesRow = tiles[r]
                if (r != row) {
                    add(tilesRow)
                } else {
                    add(
                        buildImmutableArray(tilesRow.size) {
                            for (c in tilesRow.indices) {
                                if (c != column) {
                                    add(tilesRow[c])
                                } else {
                                    add(tile)
                                }
                            }
                        }
                    )
                }
            }
        }
        return Board(newTiles)
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