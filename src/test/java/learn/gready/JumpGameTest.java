package learn.gready;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{5,9,3,2,1,0,2,3,3,1,0,0},true),
                Arguments.of(new int[]{1,2,0,1}, true),
                Arguments.of(new int[]{2,0}, true),
                Arguments.of(new int[]{2,3,1,1,4},true),
                Arguments.of(new int[]{3,2,1,0,4}, false),
                Arguments.of(new int[]{1}, true),
                Arguments.of(new int[]{0}, true),
                Arguments.of(new int[]{1,0,0}, false),
                Arguments.of(new int[]{1,0}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int[] input, boolean expected){
        boolean actual = new JumpGame().canJump(input);
        assertEquals(expected,actual);
    }

}