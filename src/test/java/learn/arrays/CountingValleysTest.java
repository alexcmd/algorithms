package learn.arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CountingValleysTest {


    private static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.of(8, "UDDDUDUU", 1),
                Arguments.of(8, "DDUUUUDD", 1)

        );
    }

    @ParameterizedTest
    @MethodSource("getData")
    void countingValleys(int steps, String path, int expected) {
        var cv = new CountingValleys();
        assertEquals(expected, cv.countingValleys(steps, path));
    }
}