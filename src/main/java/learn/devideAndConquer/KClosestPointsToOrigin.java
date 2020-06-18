package learn.devideAndConquer;

import java.util.*;
import java.util.stream.Collectors;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingDouble(a -> Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2))) );
        return Arrays.copyOf(points,K);
    }

    public List<Integer> majorityElement(int[] nums) {
        int bound = nums.length/3;
        int max_val=-Integer.MIN_VALUE;
        HashMap<Integer,Integer> counter = new HashMap<>();
        HashSet<Integer> result = new LinkedHashSet<>();
        for(int val: nums){
            int cnt = counter.getOrDefault(val,0)+1;
            if (cnt>bound && !result.contains(val)) {
                result.add(val);
            }
            counter.put(val, cnt);
        }

        return result.stream().collect(Collectors.toList());

    }
}
