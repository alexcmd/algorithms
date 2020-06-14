package learn.window;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SubarraysWithKDistinctTest {


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1,2,1,2,3},2,7),
                Arguments.of(new int[]{1,2,1,3,4},3,3),
                Arguments.of(new int[]{1,1,1,1},2,0),
                Arguments.of(new int[]{1,1,1,1},1,10),
                Arguments.of(new int[]{1},4,0),
                Arguments.of(new int[0],1,0),
                Arguments.of(new int[]{1,2},0,0)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int[] input, int k, int expected){
        int actual = new SubarraysWithKDistinct().subarraysWithKDistinct(input, k);
        assertEquals(expected,actual);
    }

}