import model.Levels
import model.Solutions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import solver.Solver

class SolverTest {
    private val solver = Solver()

    @ParameterizedTest(name = "{0}")
    @ValueSource(
        strings = [
            "1-1",
            "1-2",
            "1-3",
            "1-4",
            "1-5",
            "1-6",
            "1-7",
            "1-8",
            "1-9",
            "1-10",
            "1-11",
            "1-11A",
            "1-11B",
            "1-12",
            "1-12A",
            "1-13",
            "1-13A",
            "1-14",
            "1-14A",
            "1-15",
            "1-15A",
        ]
    )
    fun world1(levelName: String) = assertEquals(
        Solutions.World1.solutions.getValue(levelName),
        solver.findSolutions(Levels.World1.levels.getValue(levelName))
    )
}