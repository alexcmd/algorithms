package learn.common;


import java.util.Arrays;
import java.util.Objects;

/**
 *  !!!Leetcode predefined code.!!!
 *  !!!Using fields directly (w/o getters and setters)!!!
 */
public class ListNode {
     public int val;
     public ListNode next;
     public ListNode() {}
     public ListNode(int... values) {
          val = values[0];
          if (values.length>1)
               next = new ListNode(Arrays.copyOfRange(values,1, values.length));
     }
     public ListNode(int val) { this.val = val; }
     public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          ListNode listNode = (ListNode) o;
          return val == listNode.val &&
                  ((next == null && listNode.next==null) || (next!=null && next.equals(listNode.next)));
     }

     @Override
     public int hashCode() {
          return Objects.hash(val, next);
     }

     @Override
     public String toString() {
          return ""+val;
     }
}

