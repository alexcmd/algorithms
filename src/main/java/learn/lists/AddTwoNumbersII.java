package learn.lists;

import learn.common.ListNode;

import java.util.LinkedList;
import java.util.Stack;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();

        while (l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode cur  = new ListNode();
        int next=0;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            int s1 = 0;
            if (!stack1.isEmpty())
                s1 = stack1.pop();
            int s2 =0;
            if (!stack2.isEmpty())
                s2 = stack2.pop();
            int sum = s1+s2+next;
            cur.val  = sum %10;
            next = sum / 10;
            cur = new ListNode(0, cur);

        }
        if (next!=0){
            cur.val=next;
            cur = new ListNode(0, cur);
        }


        return cur.next;

    }
}
