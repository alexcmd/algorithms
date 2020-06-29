package learn.lists;

import learn.common.ListNode;
import  static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AddTwoNumbersTest {
    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new ListNode(0), new ListNode(1), new ListNode(1)),
                Arguments.of(new ListNode(2, new ListNode(4, new ListNode(3))),
                        new ListNode(5, new ListNode(6, new ListNode(4))),
                        new ListNode(7, new ListNode(0, new ListNode(8)))),
                Arguments.of(null,null,null),
                Arguments.of(new ListNode(0),null, new ListNode()),
                Arguments.of(null,new ListNode(0), new ListNode()),
                Arguments.of(null,new ListNode(1), new ListNode(1)),
                Arguments.of(new ListNode(1), null, new ListNode(1))


        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(ListNode l1, ListNode l2, ListNode expected){
        ListNode actual =new AddTwoNumbers().addTwoNumbers(l1,l2);
        assertEquals(expected,actual);
    }

}