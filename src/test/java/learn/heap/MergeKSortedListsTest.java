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
                Arguments.of()
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(ListNode[] input, ListNode expected){
        new MergeKSortedLists().mergeKLists(input);
    }

}