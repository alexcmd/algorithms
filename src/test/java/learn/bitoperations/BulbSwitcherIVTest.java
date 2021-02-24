package learn.bitoperations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BulbSwitcherIVTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("10111", 3),
                Arguments.of("101", 3),
                Arguments.of("00000", 0),
                Arguments.of("001011101", 5),
                Arguments.of("10011111010101000011101010011001000",16)

        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void minFlips( String input, int expected) {
        int actual = new BulbSwitcherIV().minFlips(input);
        assertEquals(expected, actual);
    }
}