package learn.heap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class KClosestPointsToOriginTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{1,3}, new int[]{-2,2}}, 1, new int[][]{new int[]{-2,2}})
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int[][] input,int k, int[][] expected){
        int[][] actual = new KClosestPointsToOrigin().kClosest(input, k);
        assertArrayEquals(expected, actual);
    }

}