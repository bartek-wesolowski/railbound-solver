package model

import kotlinx.collections.immutable.PersistentSet
import kotlinx.collections.immutable.toPersistentSet
import model.Action.TakePassenger
import model.Action.ToggleColor
import model.Action.ToggleFork
import model.Direction.DOWN
import model.Direction.LEFT
import model.Direction.RIGHT
import model.Direction.UP
import model.Tile.BaseHorizontalTrack.FixedHorizontalTrack
import model.Tile.BaseHorizontalTrack.HorizontalBarrier
import model.Tile.BaseHorizontalTrack.HorizontalStop
import model.Tile.BaseHorizontalTrack.HorizontalToggle
import model.Tile.BaseVerticalTrack.FixedVerticalTrack
import model.Tile.BaseVerticalTrack.VerticalBarrier
import model.Tile.BaseVerticalTrack.VerticalStop
import model.Tile.BaseVerticalTrack.VerticalToggle
import model.Tile.Empty
import model.Tile.EndingTrack
import model.Tile.Fork
import model.Tile.Obstacle
import model.Tile.Platform
import model.Tile.Platform.DownPlatform
import model.Tile.Platform.LeftPlatform
import model.Tile.Platform.RightPlatform
import model.Tile.Platform.UpPlatform
import model.Tile.Turn
import util.mapAt
import java.util.EnumMap
import java.util.EnumSet
import java.util.IdentityHashMap

data class Board(
    val tiles: Array<Row>,
    val tunnelExits: Map<CarPosition, CarPosition>,
    private val toggleables: Map<Color, List<Position>>,
    private val platforms: Map<Stop, Position>,
    val requiredTiles: PersistentSet<Position>,
    val hasToggleableForks: Boolean,
) {
    val rows: Int = tiles.size
    val columns: Int = tiles.first().columns

    constructor(tiles: Array<Row>) : this(
        tiles = tiles,
        tunnelExits = buildMap {
            val entranceByColor = EnumMap<TunnelColor, CarPosition>(TunnelColor::class.java)
            for (r in tiles.indices) {
                for (c in tiles[r].indices) {
                    val tile = tiles[r][c]
                    if (tile !is Tunnel) continue
                    val entrance1 = CarPosition(r, c, tile.incomingDirections.first())
                    if (tile.color in entranceByColor) {
                        if (contains(entrance1)) throw IllegalStateException("Tunnel already exists")
                        val entrance2 = entranceByColor.getValue(tile.color)
                        if (contains(entrance2)) throw IllegalStateException("Tunnel already exists")
                        put(entrance1, CarPosition(entrance2.row, entrance2.column, entrance2.direction.opposite()))
                        put(entrance2, CarPosition(entrance1.row, entrance1.column, entrance1.direction.opposite()))
                    } else {
                        entranceByColor.put(tile.color, entrance1)
                    }
                }
            }
        },
        toggleables = EnumMap<Color, List<Position>>(Color::class.java).apply {
            for (r in tiles.indices) {
                for (c in tiles[r].indices) {
                    val tile = tiles[r][c]
                    if (tile is ColorToggleable) {
                        val color = tile.color
                        val position = Position(r, c)
                        if (color in keys) {
                            put(color, getValue(color) + position)
                        } else {
                            put(color, listOf(position))
                        }
                    }
                }
            }
            require(values.all { it.isNotEmpty() })
        },
        platforms = IdentityHashMap<Stop, Position>().apply {
            for (r in tiles.indices) {
                for (c in tiles[r].indices) {
                    val tile = tiles[r][c]
                    if (tile is HorizontalStop) {
                        if (r > 0 && tiles[r - 1][c] is DownPlatform && (tiles[r - 1][c] as Platform).number == tile.number) {
                            put(tile, Position(r - 1, c))
                        } else if (r < tiles.size - 1 && tiles[r + 1][c] is UpPlatform && (tiles[r + 1][c] as Platform).number == tile.number) {
                            put(tile, Position(r + 1, c))
                        } else {
                            throw IllegalStateException("Missing stop for platform row: $r, column $c")
                        }
                    } else if (tile is VerticalStop) {
                        if (c > 0 && tiles[r][c - 1] is RightPlatform && (tiles[r][c - 1] as Platform).number == tile.number) {
                            put(tile, Position(r, c - 1))
                        } else if (c < tiles[0].columns - 1 && tiles[r][c + 1] is LeftPlatform && (tiles[r][c + 1] as Platform).number == tile.number) {
                            put(tile, Position(r, c + 1))
                        } else {
                            throw IllegalStateException("Missing stop for platform row: $r, column $c")
                        }
                    }
                }
            }
        },
        requiredTiles = buildSet {
            for (r in tiles.indices) {
                for (c in tiles[r].indices) {
                    val tile = tiles[r][c]
                    when (tile) {
                        is HorizontalStop -> {
                            if (tiles[r][c - 1] is Empty) add(Position(r, c - 1))
                            if (tiles[r][c + 1] is Empty) add(Position(r, c + 1))
                        }

                        is VerticalStop -> {
                            if (tiles[r - 1][c] is Empty) add(Position(r - 1, c))
                            if (tiles[r + 1][c] is Empty) add(Position(r + 1, c))
                        }

                        is EndingTrack -> {
                            if (tiles[r][c - 1] is Empty) add(Position(r, c - 1))
                        }

                        else -> Unit
                    }
                }
            }
        }.toPersistentSet(),
        hasToggleableForks = hasToggleableForks(tiles)
    )

    constructor(tiles: Array<Row>, requireFixed: Boolean) : this(
        tiles = tiles,
    ) {
        for (row in tiles) {
            if (row.columns != columns) {
                throw IllegalArgumentException("All rows must have the same number of columns")
            }
        }
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
                                tile is HorizontalToggle ||
                                tile is FixedVerticalTrack ||
                                tile is VerticalToggle ||
                                tile is Platform ||
                                tile is Stop ||
                                (tile is Turn && tile.fixed) ||
                                (tile is Fork && tile.fixed)
                    ) {
                        "All tiles must be fixed, but found $tile at $r, $c"
                    }
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Board) return false
        return tiles.contentEquals(other.tiles)
    }

    override fun hashCode(): Int = tiles.contentHashCode()

    operator fun get(row: Int, column: Int): Tile {
        return tiles[row][column]
    }

    operator fun get(position: Position): Tile {
        return tiles[position.row][position.column]
    }

    private operator fun set(row: Int, column: Int, tile: Tile) {
        tiles[row].tiles[column] = tile
    }

    override fun toString(): String {
        val sb = StringBuilder("[\n")
        for (row in tiles) {
            sb.appendLine("\t$row")
        }
        sb.append("]")
        return sb.toString()
    }

    fun getPlatformPosition(stop: Stop): Position = platforms.getValue(stop)

    fun getPlatform(stop: Stop): Platform = this[getPlatformPosition(stop)] as Platform

    fun isAllPlatformsEmpty(): Boolean = platforms.keys.all { !getPlatform(it).isFull }

    fun tryInsert(row: Int, column: Int, tile: Tile, traverseDirections: Map<Position, EnumSet<Direction>>): List<Board> {
        if (row < 0 || row >= rows) return emptyList()
        if (column < 0 || column >= columns) return emptyList()

        if (DOWN in tile.incomingDirections && row == 0) return emptyList()
        if (UP in tile.incomingDirections && row == rows - 1) return emptyList()
        if (RIGHT in tile.incomingDirections && column == 0) return emptyList()
        if (LEFT in tile.incomingDirections && column == columns - 1) return emptyList()

        var upTileModifications: List<Tile?> = listOfNullTile
        if (DOWN in tile.incomingDirections && tiles[row - 1][column] != Empty) {
            val upTile = tiles[row - 1][column]
            if (UP !in upTile.incomingDirections) {
                val tileTraverseDirections =
                    traverseDirections.getOrDefault(Position(row - 1, column), noTraverseDirections)
                val possibleModifications = (upTile as? ModifiableTile)?.getPossibleModifications(UP, tileTraverseDirections)
                if (possibleModifications.isNullOrEmpty()) {
                    return emptyList()
                } else {
                    upTileModifications = possibleModifications
                }
            }
        }

        var downTileModifications: List<Tile?> = listOfNullTile
        if (UP in tile.incomingDirections && tiles[row + 1][column] != Empty) {
            val downTile = tiles[row + 1][column]
            if (DOWN !in downTile.incomingDirections) {
                val tileTraverseDirections =
                    traverseDirections.getOrDefault(Position(row + 1, column), noTraverseDirections)
                val possibleModifications = (downTile as? ModifiableTile)?.getPossibleModifications(DOWN, tileTraverseDirections)
                if (possibleModifications.isNullOrEmpty()) {
                    return emptyList()
                } else {
                    downTileModifications = possibleModifications
                }
            }
        }

        var leftTileModifications: List<Tile?> = listOfNullTile
        if (RIGHT in tile.incomingDirections && tiles[row][column - 1] != Empty) {
            val leftTile = tiles[row][column - 1]
            if (LEFT !in leftTile.incomingDirections) {
                val tileTraverseDirections =
                    traverseDirections.getOrDefault(Position(row, column - 1), noTraverseDirections)
                val possibleModifications = (leftTile as? ModifiableTile)?.getPossibleModifications(LEFT, tileTraverseDirections)
                if (possibleModifications.isNullOrEmpty()) {
                    return emptyList()
                } else {
                    leftTileModifications = possibleModifications
                }
            }
        }

        var rightTileModifications: List<Tile?> = listOfNullTile
        if (LEFT in tile.incomingDirections && tiles[row][column + 1] != Empty) {
            val rightTile = tiles[row][column + 1]
            if (RIGHT !in rightTile.incomingDirections) {
                val tileTraverseDirections =
                    traverseDirections.getOrDefault(Position(row, column + 1), noTraverseDirections)
                val possibleModifications = (rightTile as? ModifiableTile)?.getPossibleModifications(RIGHT, tileTraverseDirections)
                if (possibleModifications.isNullOrEmpty()) {
                    return emptyList()
                } else {
                    rightTileModifications = possibleModifications
                }
            }
        }

        val totalModifications =
            upTileModifications.size * downTileModifications.size * leftTileModifications.size * rightTileModifications.size
        return buildList(totalModifications) {
            for (modifiedUpTile in upTileModifications) {
                for (modifiedDownTile in downTileModifications) {
                    for (modifiedLeftTile in leftTileModifications) {
                        for (modifiedRightTile in rightTileModifications) {
                            var newBoard = this@Board.with(row, column, tile)
                            if (modifiedUpTile != null) newBoard = newBoard.with(row - 1, column, modifiedUpTile)
                            if (modifiedDownTile != null) newBoard = newBoard.with(row + 1, column, modifiedDownTile)
                            if (modifiedLeftTile != null) newBoard[row, column - 1] = modifiedLeftTile
                            if (modifiedRightTile != null) newBoard[row, column + 1] = modifiedRightTile
                            add(newBoard)
                        }
                    }
                }
            }
        }
    }

    private fun with(row: Int, column: Int, tile: Tile): Board = copy(
        tiles = tiles.mapAt(row) { rowTiles ->
            rowTiles.mapAt(column, tile)
        }
    )

    private fun with(position: Position, tile: Tile): Board = with(position.row, position.column, tile)

    fun matches(solution: Board): Boolean {
        for (r in tiles.indices) {
            if (!tiles[r].matches(solution.tiles[r])) return false
        }
        return true
    }

    fun withAppliedActions(actions: List<Action>): Board {
        var updatedBoard = this
        for (action in actions) {
            updatedBoard = updatedBoard.withAppliedAction(action)
        }
        return updatedBoard
    }

    fun merge(other: Board): Board {
        val newTiles = Array(rows) { r ->
            Row(Array(columns) { c ->
                val thisTile = tiles[r][c]
                val otherTile = other.tiles[r][c]
                if (thisTile is Empty) {
                    otherTile
                } else {
                    thisTile
                }
            })
        }
        return Board(newTiles)
    }

    private fun withAppliedAction(action: Action): Board {
        return when (action) {
            is ToggleColor -> {
                val barrierPositions = toggleables[action.color].orEmpty()
                var updatedBoard: Board = this
                for (position in barrierPositions) {
                    updatedBoard = updatedBoard.with(
                        position,
                        (tiles[position.row][position.column] as ColorToggleable).toggled()
                    )
                }
                updatedBoard
            }

            is ToggleFork -> {
                with(
                    action.row,
                    action.column,
                    (this[action.row, action.column] as ToggleableFork).toggled()
                )
            }

            is TakePassenger -> {
                with(
                    action.platformPosition,
                    (this[action.platformPosition] as Platform).withoutPassenger()
                )
            }
        }
    }

    companion object {
        private val listOfNullTile: List<Tile?> = listOf(null)
        private val noTraverseDirections = EnumSet.noneOf(Direction::class.java)

        fun buildBoard(
            requireFixed: Boolean = false,
            initializer: MutableList<Row>.() -> Unit
        ) = Board(
            tiles = buildList {
                initializer()
            }.toTypedArray(),
            requireFixed = requireFixed
        )

        fun MutableList<Row>.row(vararg tiles: Tile) {
            add(Row(Array(tiles.size) { i -> tiles[i] }))
        }

        private fun hasToggleableForks(tiles: Array<Row>): Boolean {
            for (r in tiles.indices) {
                for (c in tiles[r].indices) {
                    val tile = tiles[r][c]
                    if (tile is ToggleableFork) {
                        return true
                    }
                }
            }
            return false
        }
    }
}