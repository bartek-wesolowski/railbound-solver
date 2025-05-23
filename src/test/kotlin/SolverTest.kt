import model.Levels
import model.Solutions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import solver.Solver
import java.util.stream.Stream

class SolverTest {
    private val solver = Solver()

    @ParameterizedTest(name = "{0}")
    @MethodSource("getWorld1LevelNames")
    fun world1(levelName: String) = assertEquals(
        Solutions.World1.solutions.getValue(levelName),
        solver.findSolutions(Levels.World1.levels.getValue(levelName))
    )

    @ParameterizedTest(name = "{0}")
    @MethodSource("getWorld2LevelNames")
    fun world2(levelName: String) = assertEquals(
        Solutions.World2.solutions.getValue(levelName),
        solver.findSolutions(Levels.World2.levels.getValue(levelName))
    )

    @ParameterizedTest(name = "{0}")
    @MethodSource("getWorld3LevelNames")
    fun world3(levelName: String) = assertEquals(
        Solutions.World3.solutions.getValue(levelName),
        solver.findSolutions(Levels.World3.levels.getValue(levelName))
    )

    @ParameterizedTest(name = "{0}")
    @MethodSource("getWorld4LevelNames")
    fun world4(levelName: String) {
        if (levelName != "4-9B") {
            assertEquals(
                Solutions.World4.solutions.getValue(levelName),
                solver.findSolutions(Levels.World4.levels.getValue(levelName))
            )
        } else {
            val solutions = solver.findSolutions(Levels.World4.levels.getValue(levelName))
            assertTrue(solutions.containsAll(Solutions.World4.solutions.getValue(levelName)))
            assertEquals(128, solutions.size)
        }
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("getWorld5LevelNames")
    fun world5(levelName: String) {
        if (levelName == "5-4C") {
            val solutions = solver.findSolutions(Levels.World5.levels.getValue(levelName))
            assertTrue(solutions.containsAll(Solutions.World5.solutions.getValue(levelName)))
            assertEquals(651, solutions.size)
        } else if (levelName == "5-5B") {
            val solutions = solver.findSolutions(Levels.World5.levels.getValue(levelName))
            assertTrue(solutions.containsAll(Solutions.World5.solutions.getValue(levelName)))
            assertEquals(652, solutions.size)
        } else {
            assertEquals(
                Solutions.World5.solutions.getValue(levelName),
                solver.findSolutions(Levels.World5.levels.getValue(levelName))
            )
        }
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("getWorld6LevelNames")
    fun world6(levelName: String) {
        if (levelName == "6-9C") {
            val solutions = solver.findSolutions(Levels.World6.levels.getValue(levelName))
            assertTrue(solutions.containsAll(Solutions.World6.solutions.getValue(levelName)))
            assertEquals(70, solutions.size)
        } else if (levelName == "6-9D") {
            val solutions = solver.findSolutions(Levels.World6.levels.getValue(levelName))
            assertTrue(solutions.containsAll(Solutions.World6.solutions.getValue(levelName)))
            assertEquals(77, solutions.size)
        } else {
            assertEquals(
                Solutions.World6.solutions.getValue(levelName),
                solver.findSolutions(Levels.World6.levels.getValue(levelName))
            )
        }
    }

    private companion object {
        @JvmStatic
        fun getWorld1LevelNames(): Stream<Arguments> {
            return Solutions.World1.solutions.keys.stream().map { Arguments.of(it) }
        }

        @JvmStatic
        fun getWorld2LevelNames(): Stream<Arguments> {
            return Solutions.World2.solutions.keys.stream().map { Arguments.of(it) }
        }

        @JvmStatic
        fun getWorld3LevelNames(): Stream<Arguments> {
            return Solutions.World3.solutions.keys.stream().map { Arguments.of(it) }
        }

        @JvmStatic
        fun getWorld4LevelNames(): Stream<Arguments> {
            return Solutions.World4.solutions.keys.stream().map { Arguments.of(it) }
        }

        @JvmStatic
        fun getWorld5LevelNames(): Stream<Arguments> {
            return Solutions.World5.solutions.keys.stream().map { Arguments.of(it) }
        }

        @JvmStatic
        fun getWorld6LevelNames(): Stream<Arguments> {
            return Solutions.World6.solutions.keys.stream().map { Arguments.of(it) }
        }
    }
}