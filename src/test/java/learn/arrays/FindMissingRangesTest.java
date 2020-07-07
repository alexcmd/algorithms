package learn.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FindMissingRangesTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 3, 50, 75},1,50, Arrays.asList("2", "4->49")),
                Arguments.of(new int[]{0, 1, 3, 50, 75},0,99, Arrays.asList("2", "4->49", "51->74", "76->99")),
                Arguments.of(new int[0], 1,1,Arrays.asList("1")),
                Arguments.of(new int[]{1},1,1, new ArrayList<>()),
                Arguments.of(new int[]{0, 1, 3, 50, 75},1,75, Arrays.asList("2", "4->49", "51->74")),
                Arguments.of(new int[]{0, 1, 3, 50, 74},1,75, Arrays.asList("2", "4->49", "51->73","75")),
                Arguments.of(new int[]{-1},-2,-1, Arrays.asList("-2")),
                Arguments.of(new int[]{-2},-2,-1, Arrays.asList("-1")),
                Arguments.of(new int[]{5},-1,1, Arrays.asList("-1->4")),
                Arguments.of(new int[]{-5},-1,1, Arrays.asList("-4->1")),
                Arguments.of(new int[]{5},-3,-1, Arrays.asList("-3->4")),
                Arguments.of(new int[]{-5},-3,-1, Arrays.asList("-4->-1"))

        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int[] input, int lower, int upper, List<String> expected){
        var actual = new FindMissingRanges().findMissingRanges(input,lower,upper);
        assertEquals(expected, actual);
    }

}