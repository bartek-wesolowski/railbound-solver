package com.bartoszwesolowski

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

        if (Direction.UP in tile.attachments && row == 0) return false
        if (Direction.DOWN in tile.attachments && row == rows - 1) return false
        if (Direction.LEFT in tile.attachments && column == 0) return false
        if (Direction.RIGHT in tile.attachments && column == columns - 1) return false

        if (Direction.UP in tile.attachments && tiles[row - 1][column] is Tile.Obstacle) return false
        if (Direction.DOWN in tile.attachments && tiles[row + 1][column] is Tile.Obstacle) return false
        if (Direction.LEFT in tile.attachments && tiles[row][column - 1] is Tile.Obstacle) return false
        if (Direction.RIGHT in tile.attachments && tiles[row][column + 1] is Tile.Obstacle) return false

        return true // TODO add more checks
    }

    fun with(row: Int, column: Int, tile: Tile): Board {
        val newTiles = tiles.map { it.copyOf() }.toTypedArray()
        newTiles[row][column] = tile
        return Board(newTiles)
    }
}