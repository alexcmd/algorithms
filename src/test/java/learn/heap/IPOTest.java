package learn.heap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IPOTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2,0,new int[]{1,2,3},new int[]{0,1,1}, 4),
                Arguments.of(1,0,new int[]{1,2,3},new int[]{0,1,1}, 1),
                Arguments.of(1,100,new int[]{1,2,3},new int[]{0,1,1}, 103),
                Arguments.of(2,100,new int[]{1,2,3},new int[]{0,1,1}, 105),
                Arguments.of(10,100,new int[]{1,2,3},new int[]{0,1,1}, 106)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int k, int W, int[] profit, int[] capital, int expected){
        int actual = new IPO().findMaximizedCapital(k, W, profit, capital);
        assertEquals(expected,actual);
    }

}