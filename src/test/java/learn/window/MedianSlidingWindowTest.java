package learn.window;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MedianSlidingWindowTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{2147483647,2147483647},2,new double[]{2147483647.00000}),
                Arguments.of(new int[]{1,4,2,3},2,new double[]{2.5,3.0,2.5}),
                Arguments.of(new int[]{1,3,-1,-3,5,3,6,7},3,new double[]{1,-1,-1,3,5,6}),
                Arguments.of(new int[]{1,4,2,3},4,new double[]{2.5})


        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int[] input, int k, double[] expected){
        double[] actual = new MedianSlidingWindow().medianSlidingWindow(input, k);
        assertArrayEquals(expected,actual);
    }

}