package learn.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TreeSumTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 1, 2, -1, -4}, Arrays.asList(Arrays.asList(-1, 0, 1), Arrays.asList(-1,-1,2)))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int[] input, List<List<Integer>> expected){
        List<List<Integer>> actual = new TreeSum().threeSum(input);
        assertEquals(expected, actual);
    }
}