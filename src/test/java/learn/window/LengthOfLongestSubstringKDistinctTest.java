package learn.window;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLongestSubstringKDistinctTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("eceba",2,3),
                Arguments.of("aa",1,2),
                Arguments.of("a",0,0),
                Arguments.of("",3,0),
                Arguments.of(null,0,0)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(String input, int k, int expected){
        var actual = new LengthOfLongestSubstringKDistinct().lengthOfLongestSubstringKDistinct(input,k);
        assertEquals(expected, actual);
    }
}