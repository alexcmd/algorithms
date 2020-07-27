package learn.trees.bst;

import learn.common.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TrimBSTTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(1, new TreeNode(0), new TreeNode(2)),
                        1,2,
                        new TreeNode(1, null, new TreeNode(2))),
                Arguments.of(
                        new TreeNode(3,
                                new TreeNode(0, null,
                                        new TreeNode(2,
                                                new TreeNode(1),null)),
                                new TreeNode(4)),
                        1,3,
                        new TreeNode(3, new TreeNode(2, new TreeNode(1), null),null)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void trimBST(TreeNode input,int left, int right, TreeNode expected) {
        TreeNode actual = new TrimBST().trimBST(input, left, right);
        assertEquals(expected, actual);
    }
}