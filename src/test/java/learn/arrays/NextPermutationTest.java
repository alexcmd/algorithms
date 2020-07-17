package learn.arrays;

import learn.backtracking.NextPermutation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NextPermutationTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, new int[]{1,3,2}),
                Arguments.of(new int[]{3,2,1}, new int[]{1,2,3}),
                Arguments.of(new int[]{2,1}, new int[]{1,2}),
                Arguments.of(new int[]{2,3,1}, new int[]{3,1,2}),
                Arguments.of(new int[]{1,2,1}, new int[]{2,1,1}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[0], new int[0])

        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public  void  Test1(int[] input, int[]  expected){
        new NextPermutation().nextPermutation(input);
        assertArrayEquals(expected, input);
    }
}