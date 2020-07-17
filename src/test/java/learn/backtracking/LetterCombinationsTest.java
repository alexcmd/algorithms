package learn.backtracking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LetterCombinationsTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("23", Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
                Arguments.of("9", Arrays.asList("w","x","y","z"))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void letterCombinations(String input, List<String> expected) {
        var actual = new LetterCombinations().letterCombinations(input);
        assertEquals(expected,actual);
    }
}