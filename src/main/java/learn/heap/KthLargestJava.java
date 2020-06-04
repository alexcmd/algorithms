package learn.heap;

import java.util.PriorityQueue;

public class KthLargestJava {
    private final int k;
    private PriorityQueue<Integer> queue;
    public KthLargestJava(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        this.k = k;
        for (int i:nums){
            queue.offer(i);
            if (queue.size()>k)
                queue.poll();
        }

    }

    public int add(int val){
        queue.offer(val);
        if (queue.size()>k)
            queue.poll();
        return queue.peek();
    }
}
