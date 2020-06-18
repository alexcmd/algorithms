package learn.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumIITest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{2,7,11,15}, 9, new int[]{1,2}),
                Arguments.of(new int[]{2,7,11,15}, 9, new int[]{1,2}),
                Arguments.of(new int[]{2,7,11,15}, 9, new int[]{1,2}),
                Arguments.of(new int[]{2,7,11,15}, 9, new int[]{1,2})
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int[] input, int target, int[] expected) throws Exception {
        int[] actual = new TwoSumII().twoSum(input, target);
        assertEquals(expected,actual);
    }
}