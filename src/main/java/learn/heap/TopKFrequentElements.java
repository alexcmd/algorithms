package learn.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
/*
* Given a non-empty array of integers, return the k most frequent elements.
*/
public class TopKFrequentElements {
    private int n;
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length * k ==0)
            return new int[0];

        HashMap<Integer, Integer> counter = new LinkedHashMap<>();
        for (int i : nums) {
            if (!counter.containsKey(i))
                counter.put(i, 0);
            counter.put(i, counter.get(i) + 1);
        }
        PriorityQueue<Integer> q = new PriorityQueue<>(k, Comparator.comparingInt(counter::get));
        for (int i: counter.keySet()){
            q.add(i);
            if (q.size()>k)
                q.poll();
        }

        int[] res = new int[k];
        for (int i=k-1;i>=0;i--){
            res[i] = q.poll();
        }
        return res;
    }
}
