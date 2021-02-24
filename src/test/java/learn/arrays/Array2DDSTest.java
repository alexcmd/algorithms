package learn.arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Array2DDSTest {


    private static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {-9, -9, -9, 1, 1, 1},
                                {0, -9, 0, 4, 3, 2},
                                {-9, -9, -9, 1, 2, 3},
                                {0, 0, 8, 6, 6, 0},
                                {0, 0, 0, -2, 0, 0},
                                {0, 0, 1, 2, 4, 0}},
                        28
                ));
    }

    @ParameterizedTest
    @MethodSource("getData")
    void hourglassSum(int[][] arr, int expected) {
        assertEquals(expected, new Array2DDS().hourglassSum(arr));
    }
}