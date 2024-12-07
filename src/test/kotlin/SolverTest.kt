import com.bartoszwesolowski.Levels
import com.bartoszwesolowski.Solutions
import com.bartoszwesolowski.Solver
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SolverTest {
    private val solver = Solver()

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11])
    fun world1(levelNumber: Int) = assertEquals(
        Solutions.World1.solutions[levelNumber - 1],
        solver.findSolutions(Levels.World1.levels[levelNumber - 1])
    )
}