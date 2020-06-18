package learn.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> topK = new PriorityQueue<>(
                Comparator.comparingDouble(a -> -Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2)))
        );

        //O(n*log(k))
        for (int[] point : points) {
            topK.add(point);
            if (topK.size() > K)
                topK.poll();
        }

        //O(k)
        int[][] result = new int[topK.size()][];
        for (int i = result.length-1; i >=0 ; i--) {
            result[i] = topK.poll();
        }

        // -> worst case k=n - > O(n log(n))
        return result;
    }
}
