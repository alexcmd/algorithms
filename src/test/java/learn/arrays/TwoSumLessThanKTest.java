package learn.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class TwoSumLessThanKTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{34,23,1,24,75,33,54,8},60,58),
                Arguments.of(new int[]{10,20,30},15,-1),
                Arguments.of(new int[0],10,-1),
                Arguments.of(new int[]{10},10,-1),
                Arguments.of(new int[]{10},100,-1)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int[] input, int k, int expected){
        var actual = new TwoSumLessThanK().twoSumLessThanK(input,k);
        assertEquals(expected,actual);
    }

}