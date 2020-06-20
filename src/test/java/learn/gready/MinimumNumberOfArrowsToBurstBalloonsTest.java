package learn.gready;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinimumNumberOfArrowsToBurstBalloonsTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][]{ new int[]{10,16}, new int[]{2,8}, new int[]{1,6}, new int[]{7,12}}, 2),
                Arguments.of(new int[][]{ new int[]{10,16}}, 1),
                Arguments.of(new int[0][], 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int[][] input, int expected){
        int actual = new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(input);
        assertEquals(expected,actual);
    }

}