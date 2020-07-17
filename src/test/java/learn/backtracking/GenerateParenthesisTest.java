package learn.backtracking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesisTest {

    private static Stream<Arguments> TestData() {
        return Stream.of(
                Arguments.of(3, Arrays.asList(
                        "((()))",
                        "(()())",
                        "(())()",
                        "()(())",
                        "()()()"
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("TestData")
    void generateParenthesis(int input, List<String> expected) {
        var actual = new GenerateParenthesis().generateParenthesis(input);
        assertEquals(actual, expected);
    }
}