package learn.gready;

import learn.gready.MaximumSubarray;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubarrayTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6),
                Arguments.of(new int[]{-2},-2),
                Arguments.of(new int[0],0),
                Arguments.of(new int[]{1,2,4,0},7) // non-negative array -> whole array sum
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int[] input, int expected){
        int actual = new MaximumSubarray().maxSubArray(input);
        assertEquals(expected, actual);
    }
}