package learn.common;


import java.util.Objects;

/**
 *  !!!Leetcode predefined code.!!!
 *  !!!Using fields directly (w/o getters and setters)!!!
 */
public class ListNode {
     public int val;
     public ListNode next;
     public ListNode() {}
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
