package learn.window;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLongestSubstringTwoDistinctTest {


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("ccaabbb",5),
                Arguments.of("eceba",3),
                Arguments.of(null,0),
                Arguments.of("",0)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(String input, int expected){
        var actual = new LengthOfLongestSubstringTwoDistinct().lengthOfLongestSubstringTwoDistinct(input);
        assertEquals(expected,actual);
    }

}