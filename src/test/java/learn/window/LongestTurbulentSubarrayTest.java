package learn.window;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestTurbulentSubarrayTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{9,9},1),
                Arguments.of(new int[]{0,8,45,88,48,68,28,55,17,24},8),
                Arguments.of(new int[] {9,4,2,10,7,8,8,1,9}, 5),
                Arguments.of(new int[]{4,8,12,16},2),
                Arguments.of(new int[]{100},1),
                Arguments.of(new int[0],0)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int[] input, int expected){
        var actual = new LongestTurbulentSubarray().maxTurbulenceSize(input);
        assertEquals(expected,actual);
    }
}