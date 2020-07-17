package learn.arrays;

import learn.backtracking.Permutations;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsTest {
    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, Arrays.asList(
                        Arrays.asList(1,2,3),
                        Arrays.asList(1,3,2),
                        Arrays.asList(2,1,3),
                        Arrays.asList(2,3,1),
                        Arrays.asList(3,2,1),
                        Arrays.asList(3,1,2)

                ))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int[] input, List<List<Integer>> expected){
        var actual = new Permutations().permute(input);
        assertEquals(expected, actual);
    }

}