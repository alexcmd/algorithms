package learn.gready;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameIITest {
    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{2,3,1,1,4}, 2),
                Arguments.of(new int[]{3,1,1,4}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(int[] input, int expected){
        int actual = new JumpGameII().jump(input);
        assertEquals(expected, actual);
    }
}