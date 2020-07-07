package learn.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HTMLEntityParserTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("&amp; is an HTML entity but &ambassador; is not.","& is an HTML entity but &ambassador; is not."),
                Arguments.of("and I quote: &quot;...&quot;","and I quote: \"...\""),
                Arguments.of("Stay home! Practice on Leetcode :)","Stay home! Practice on Leetcode :)"),
                Arguments.of("x &gt; y &amp;&amp; x &lt; y is always false","x > y && x < y is always false"),
                Arguments.of("leetcode.com&frasl;problemset&frasl;all","leetcode.com/problemset/all"),
                Arguments.of("",""),
                Arguments.of(null,null)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(String input, String expected){
        var actual = new HTMLEntityParser().entityParserBrutForce(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test2(String input, String expected){
        var actual = new HTMLEntityParser().entityParserWindow(input);
        assertEquals(expected, actual);
    }
}