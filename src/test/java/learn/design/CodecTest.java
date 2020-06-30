package learn.design;

import learn.common.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CodecTest {

    private static Stream<Arguments> testDataSerialize() {
        return Stream.of(
                Arguments.of(null, "[]"),
                Arguments.of(new TreeNode(1), "[1]"),
                Arguments.of(new TreeNode(1, new TreeNode(2),null), "[1,2]"),
                Arguments.of(new TreeNode(1, null,new TreeNode(3)), "[1,null,3]"),
                Arguments.of(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5))), "[1,2,3,null,null,4,5]")
        );
    }

    private static Stream<Arguments> testDataDeserialize() {
        return Stream.of(
                Arguments.of("", null),
                Arguments.of("[]", null),
                Arguments.of("[null]", null),
                Arguments.of("[1]", new TreeNode(1)),
                Arguments.of("[1,null, null]", new TreeNode(1)),
                Arguments.of("[1,null]", new TreeNode(1)),
                Arguments.of("[1,2,3,null,null,4,5]", new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5))))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataSerialize")
    public void serialize(TreeNode input, String expected) {
        String actual = new Codec().serialize(input);
        assertEquals(expected,actual);

    }

    @ParameterizedTest
    @MethodSource("testDataDeserialize")
    public void deserialize(String input, TreeNode  expected) {
        var actual = new Codec().deserialize(input);
        assertEquals(expected,actual);
    }
}