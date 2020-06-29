package learn.lists;


import learn.common.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {
    /**
     *  Complexity: O(max(n,m))
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if (l1 == null && l2 == null)
            return null;

        ListNode result=new ListNode();
        ListNode cur = result;
        int overflow=0;
        while ( l1!=null || l2!=null ) {

            int digit = 0;
            if (l1 != null) {
                digit += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                digit += l2.val;
                l2 = l2.next;
            }

            digit += overflow;
            overflow = digit / 10;
            digit = digit % 10;

            cur.next = new ListNode(digit);
            cur = cur.next;
        }
        if (overflow>0) {
            cur.next = new ListNode(overflow);
        }
        return result.next;
    }
}
