import com.bartoszwesolowski.Levels
import com.bartoszwesolowski.Solutions
import com.bartoszwesolowski.Solver
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolverTest {
    private val solver = Solver()

    @Test
    fun level1_1() = assertEquals(
        Solutions.World1.level1_1,
        solver.findSolutions(Levels.World1.level1_1)
    )

    @Test
    fun level1_2() = assertEquals(
        Solutions.World1.level1_2,
        solver.findSolutions(Levels.World1.level1_2)
    )

    @Test
    fun level1_3() = assertEquals(
        Solutions.World1.level1_3,
        solver.findSolutions(Levels.World1.level1_3)
    )

    @Test
    fun level1_4() = assertEquals(
        Solutions.World1.level1_4,
        solver.findSolutions(Levels.World1.level1_4)
    )

    @Test
    fun level1_5() = assertEquals(
        Solutions.World1.level1_5,
        solver.findSolutions(Levels.World1.level1_5)
    )

    @Test
    fun level1_6() = assertEquals(
        Solutions.World1.level1_6,
        solver.findSolutions(Levels.World1.level1_6)
    )

    @Test
    fun level1_7() = assertEquals(
        Solutions.World1.level1_7,
        solver.findSolutions(Levels.World1.level1_7)
    )
}