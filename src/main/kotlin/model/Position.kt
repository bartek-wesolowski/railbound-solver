package model

@JvmInline
value class Position private constructor(
    private val value: Int
) {
    constructor(row: Int, column: Int) : this(row * 32 + column) {
        require(row >= 0 && column >= 0) { "Row and column must be non-negative" }
        require(row < 32 && column < 32) { "Row and column must be less than 32" }
    }

    val row: Int
        get() = value / 32

    val column: Int
        get() = value % 32
}
