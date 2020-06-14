package learn.window;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TotalFruitTest {
    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{3,3,3,1,2,1,1,2,3,3,4},5),
                Arguments.of(new int[]{1,2,1},3),
                Arguments.of(new int[]{0,1,2,2},3),
                Arguments.of(new int[]{1,2,3,2,2},4),
                Arguments.of(new int[0],0),
                Arguments.of(new int[]{1},1),
                Arguments.of(new int[]{1,2,3,4},2)

        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int[] input, int expected){
        int actual = new TotalFruit().totalFruit(input);
        assertEquals(expected,actual);
    }

}