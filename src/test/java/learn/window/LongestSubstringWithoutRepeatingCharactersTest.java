package learn.window;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of(null,0),
                Arguments.of("",0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    public void Test1(String input, int expected){
        var actual = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(input);
        assertEquals(expected,actual);
    }


}