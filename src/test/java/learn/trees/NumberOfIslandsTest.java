package learn.trees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfIslandsTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new char[][]{new char[]{'1','1','1'},new char[]{'0','1','0'},new char[]{'1','1','1'}},1),
                Arguments.of(new char[][]{new char[]{'1','1','1','1','0'},new char[]{'1','1','0','1','0'},new char[]{'1','1','0','0','0'},new char[]{'0','0','0','0','0'}},1),
                Arguments.of(new char[][]{new char[]{'1','1','0','0','0'},new char[]{'1','1','0','0','0'},new char[]{'0','0','1','0','0'},new char[]{'0','0','0','1','1'}},3),
                Arguments.of(new char[][]{new char[]{'1','0'},new char[]{'1','1'}},1),
                Arguments.of(new char[][]{new char[]{'0','0'},new char[]{'0','0'}},0)

        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(char[][] input, int expected){
        int actual = new NumberOfIslands().numIslands(input);
        assertEquals(expected, actual);

    }

}