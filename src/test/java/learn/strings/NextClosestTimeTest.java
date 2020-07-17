package learn.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NextClosestTimeTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("19:34","19:39"),
                Arguments.of("23:59","22:22"),
                Arguments.of("00:01","00:10")
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(String input, String expected) {
        var actual = new NextClosestTime().nextClosestTime(input);
        assertEquals(expected, actual);
    }

}