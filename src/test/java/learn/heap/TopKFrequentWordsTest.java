package learn.heap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentWordsTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2, new String[]{"i", "love"}),
                Arguments.of(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4, new String[]{"the", "is", "sunny", "day"}),
                Arguments.of(new String[]{}, 4, new String[]{}),
                Arguments.of(new String[]{"i"}, 2, new String[]{"i"})

        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(String[] input, int k, String[] expected){
        List<String> actual = new TopKFrequentWords().topKFrequent(input, k);
        assertEquals(Arrays.asList(expected), actual);
    }
}