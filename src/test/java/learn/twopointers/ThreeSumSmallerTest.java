package learn.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumSmallerTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{-2,0,1,3},2,2),
                Arguments.of(new int[]{1,1,-2},1,1)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int[] input, int target, int expected){
        int actual = new ThreeSumSmaller().threeSumSmaller(input,target);
        assertEquals(expected,actual);
    }
}