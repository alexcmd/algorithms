package learn.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class FindMedianSortedArraysTest {


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1,3}, new int[]{2}, 2.0),
                Arguments.of(new int[]{1,2}, new int[]{3,4}, 2.5),
                Arguments.of(new int[]{1}, new int[]{3,4}, 3.0),
                Arguments.of(new int[0], new int[]{3,4}, 3.5),
                Arguments.of(new int[]{1,2,3}, new int[0], 2),
                Arguments.of(new int[]{1}, new int[0], 1),
                Arguments.of( new int[0], new int[]{1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int[] a, int[] b, double expected) throws Exception {
        double actual = new FindMedianSortedArrays().findMedianSortedArrays(a, b);
        assertEquals(expected,actual);
    }
}