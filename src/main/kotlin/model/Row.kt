package model

class Row(val tiles: Array<Tile>) {
    init {
        require(tiles.isNotEmpty())
    }

    private val hashCode: Int by lazy(LazyThreadSafetyMode.NONE) { tiles.contentHashCode() }

    val columns: Int get() = tiles.size

    val indices: IntRange get() = tiles.indices

    operator fun get(column: Int): Tile = tiles[column]

    fun matches(solution: Row): Boolean {
        require(columns == solution.columns)
        for (column in 0 until columns) {
            if (!tiles[column].matches(solution[column])) return false
        }
        return true
    }

    fun mapAt(column: Int, tile: Tile): Row {
        return Row(tiles.copyOf().also { it[column] = tile })
    }

    inline fun forEach(action: (Tile) -> Unit) {
        tiles.forEach(action)
    }

    override fun hashCode(): Int = hashCode

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Row) return false
        return tiles.contentEquals(other.tiles)
    }

    override fun toString(): String {
        return tiles.joinToString(prefix = "[", postfix = "]")
    }
}
