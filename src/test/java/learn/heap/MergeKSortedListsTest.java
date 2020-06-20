package learn.heap;

import learn.common.ListNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MergeKSortedListsTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of( new ListNode[] {
                        new ListNode(1, new ListNode(4, new ListNode(5))),
                        new ListNode(1, new ListNode(3, new ListNode(4))),
                        new ListNode(2, new ListNode(6)),
                },
                        new ListNode(1,new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, new ListNode(6)))))))))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(ListNode[] input, ListNode expected){
        ListNode actual = new MergeKSortedLists().mergeKLists(input);
        assertEquals(expected,actual);
    }

}