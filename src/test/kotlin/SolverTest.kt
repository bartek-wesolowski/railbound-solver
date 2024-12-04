import com.bartoszwesolowski.Board
import com.bartoszwesolowski.Solver
import com.bartoszwesolowski.Tile.DownLeftRightFork
import com.bartoszwesolowski.Tile.DownLeftTurn
import com.bartoszwesolowski.Tile.DownRightTurn
import com.bartoszwesolowski.Tile.Empty
import com.bartoszwesolowski.Tile.EndingTrack
import com.bartoszwesolowski.Tile.HorizontalTrack
import com.bartoszwesolowski.Tile.Obstacle
import com.bartoszwesolowski.Tile.UpLeftTurn
import com.bartoszwesolowski.Tile.UpRightTurn
import com.bartoszwesolowski.Tile.VerticalTrack
import com.bartoszwesolowski.board1_1
import com.bartoszwesolowski.board1_2
import com.bartoszwesolowski.board1_3
import com.bartoszwesolowski.board1_4
import com.bartoszwesolowski.cars1_1
import com.bartoszwesolowski.cars1_2
import com.bartoszwesolowski.cars1_3
import com.bartoszwesolowski.cars1_4
import kotlin.test.Test
import kotlin.test.assertEquals

class SolverTest {
    private val solver = Solver()

    @Test
    fun level1_1() {
        assertEquals(
            listOf(
                Board(
                    arrayOf(
                        arrayOf(HorizontalTrack, HorizontalTrack, HorizontalTrack, HorizontalTrack, EndingTrack),
                    )
                )
            ),
            solver.findSolutions(board1_1, cars1_1),
        )
    }

    @Test
    fun level1_2() {
        assertEquals(
            listOf(
                Board(
                    arrayOf(
                        arrayOf(DownRightTurn, HorizontalTrack, DownLeftTurn, Obstacle, DownRightTurn, EndingTrack),
                        arrayOf(VerticalTrack, Obstacle, VerticalTrack, Obstacle, VerticalTrack, Obstacle),
                        arrayOf(VerticalTrack, Obstacle, UpRightTurn, HorizontalTrack, UpLeftTurn, Obstacle),
                    )
                )
            ),
            solver.findSolutions(board1_2, cars1_2),
        )
    }

    @Test
    fun level1_3() {
        assertEquals(
            listOf(
                Board(
                    arrayOf(
                        arrayOf(HorizontalTrack, DownLeftRightFork, HorizontalTrack, DownRightTurn, EndingTrack),
                        arrayOf(Empty, VerticalTrack, Empty, VerticalTrack, Empty),
                        arrayOf(Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, Empty),
                    )
                )
            ),
            solver.findSolutions(board1_3, cars1_3),
        )
    }

    @Test
    fun level1_4() {
        assertEquals(
            listOf(
                Board(
                    arrayOf(
                        arrayOf(Empty, Empty, VerticalTrack, Empty, Empty),
                        arrayOf(Empty, DownRightTurn, Empty, DownLeftTurn, Empty),
                        arrayOf(HorizontalTrack, DownLeftTurn, Obstacle, DownRightTurn, EndingTrack),
                        arrayOf(Empty, UpRightTurn, HorizontalTrack, UpLeftTurn, Empty),
                        arrayOf(Empty, Empty, VerticalTrack, Empty, Empty),
                    )
                ),
                Board(
                    arrayOf(
                        arrayOf(Empty, Empty, VerticalTrack, Empty, Empty),
                        arrayOf(Empty, DownRightTurn, HorizontalTrack, DownLeftTurn, Empty),
                        arrayOf(HorizontalTrack, UpLeftTurn, Obstacle, UpRightTurn, EndingTrack),
                        arrayOf(Empty, UpRightTurn, Empty, UpLeftTurn, Empty),
                        arrayOf(Empty, Empty, VerticalTrack, Empty, Empty),
                    )
                )
            ),
            solver.findSolutions(board1_4, cars1_4),
        )
    }
}