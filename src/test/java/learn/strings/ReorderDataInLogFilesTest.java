package learn.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ReorderDataInLogFilesTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"},
                        new String[]{"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"}),
                Arguments.of(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"},
                        new String[]{"a2 act car","g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"})

        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(String[] input, String[] expected){
        var actual = new ReorderDataInLogFiles().reorderLogFiles(input);
        assertArrayEquals(expected,actual);
    }
}