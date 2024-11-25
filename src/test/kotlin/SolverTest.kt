import com.bartoszwesolowski.Board
import com.bartoszwesolowski.Solver
import com.bartoszwesolowski.board1_1
import com.bartoszwesolowski.board1_2
import com.bartoszwesolowski.cars1_1
import com.bartoszwesolowski.cars1_2
import kotlin.test.Test
import kotlin.test.assertEquals
import com.bartoszwesolowski.Tile.*

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
                        arrayOf(BottomRightTurn, HorizontalTrack, BottomLeftTurn, Obstacle, BottomRightTurn, EndingTrack),
                        arrayOf(VerticalTrack, Obstacle, VerticalTrack, Obstacle, VerticalTrack, Obstacle),
                        arrayOf(VerticalTrack, Obstacle, TopRightTurn, HorizontalTrack, TopLeftTurn, Obstacle),
                    )
                )
            ),
            solver.findSolutions(board1_2, cars1_2),
        )
    }
}