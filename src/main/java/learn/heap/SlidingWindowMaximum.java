package learn.heap;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    LinkedList<Integer> deq = new LinkedList<>();
    int [] nums;


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length*k==0)
            return new int[0];
        if (k == 1)
            return nums;

        this.nums = nums;
        int n = nums.length;
        int[] res = new int[n-k+1];
        for (int i=0;i<k;i++){
            clean_deque(i,k);
            deq.addLast(i);
        }
        res[0] = nums[deq.getFirst()];

        for(int i = k;i<n;i++){
            clean_deque(i,k);
            deq.addLast(i);
            res[i-k+1] = nums[deq.getFirst()];
        }
        return res;
    }

    private void clean_deque(int i, int k){
        if (!deq.isEmpty() && deq.getFirst()==i-k)
            deq.removeFirst();

        while (!deq.isEmpty() && nums[i]>nums[deq.getLast()])
            deq.removeLast();
    }
}
