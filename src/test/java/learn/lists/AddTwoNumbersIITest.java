package learn.lists;

import learn.common.ListNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersIITest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3)))),
                        new ListNode(5,new ListNode(6, new ListNode(4))),
                        new ListNode(7,8,0,7)
                        )
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void addTwoNumbers(ListNode input1, ListNode input2, ListNode expected) {
        ListNode actual = new AddTwoNumbersII().addTwoNumbers(input1, input2);
        assertEquals(expected,actual);
    }
}