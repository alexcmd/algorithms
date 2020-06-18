package learn.heap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class FindMedianFromDataStreamTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{-1,-2,-3,-4,-5},new double[]{-1,-1.5,-2,-2.5,-3}),
                Arguments.of(new int[]{2,3,4,1},new double[]{2,2.5,3,2.5})

        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int[] input, double[] expected){
        FindMedianFromDataStream median = new FindMedianFromDataStream();
        double[] actual = new double[expected.length];
        for (int i = 0; i < input.length; i++) {
            median.addNum(input[i]);
            actual[i] =median.findMedian();
        }
        assertArrayEquals(expected, actual);
    }
}