package com.bartoszwesolowski

import com.bartoszwesolowski.Direction.*

data class Board(val tiles: Array<Array<Tile>>) {
    operator fun get(row: Int, column: Int): Tile {
        return tiles[row][column]
    }

    val rows: Int = tiles.size
    val columns: Int = tiles.first().size

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Board

        return tiles.contentDeepEquals(other.tiles)
    }

    override fun hashCode(): Int {
        return tiles.contentDeepHashCode()
    }

    override fun toString(): String {
        val sb = StringBuilder("[\n")
        for (row in tiles) {
            sb.appendLine("\t${row.contentDeepToString()}")
        }
        sb.append("]\n")
        return sb.toString()
    }

    fun canInsert(row: Int, column: Int, tile: Tile): Boolean {
        if (row < 0 || row >= rows) return false
        if (column < 0 || column >= columns) return false
        if (tiles[row][column] !is Tile.Empty) return false

        if (UP in tile.outgoingAttachments && row == 0) return false
        if (DOWN in tile.outgoingAttachments && row == rows - 1) return false
        if (LEFT in tile.outgoingAttachments && column == 0) return false
        if (RIGHT in tile.outgoingAttachments && column == columns - 1) return false

        if (
            UP in tile.outgoingAttachments &&
            tiles[row - 1][column] != Tile.Empty &&
            DOWN !in tiles[row - 1][column].incomingAttachments
        ) return false
        if (
            DOWN in tile.outgoingAttachments &&
            tiles[row + 1][column] != Tile.Empty &&
            UP !in tiles[row + 1][column].incomingAttachments
        ) return false
        if (
            LEFT in tile.outgoingAttachments &&
            tiles[row][column - 1] != Tile.Empty &&
            RIGHT !in tiles[row][column - 1].incomingAttachments
        ) return false
        if (
            RIGHT in tile.outgoingAttachments &&
            tiles[row][column + 1] != Tile.Empty &&
            LEFT !in tiles[row][column + 1].incomingAttachments
        ) return false

        return true
    }

    fun with(row: Int, column: Int, tile: Tile): Board {
        val newTiles = tiles.map { it.copyOf() }.toTypedArray()
        newTiles[row][column] = tile
        return Board(newTiles)
    }

    companion object {
        fun fromRows(vararg rows: Array<Tile>): Board {
            return Board(arrayOf(*rows))
        }
    }
}