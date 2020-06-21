package learn.hash;

import org.javatuples.Pair;

import java.util.*;

public class TreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Pair<Integer,Integer>> founded = new HashSet<>();
        HashSet<Integer> dubs = new HashSet<>();
        HashMap<Integer,Integer> seen = new HashMap<>();

        for (int i=0;i<nums.length;++i){
            if (dubs.add(nums[i])){
                for (int j = i+1; j < nums.length; ++j) {
                    int val = -nums[i]-nums[j];
                    if (seen.containsKey(val) && seen.get(val)==i){
                        int v1 = Math.min(nums[i], Math.min(val, nums[j]));
                        int v2 = Math.max(nums[i], Math.max(val,nums[j]));
                        if (founded.add(new Pair<>(v1, v2))){
                            res.add(Arrays.asList(nums[i], val, nums[j]));
                        }
                    }
                    seen.put(nums[j],i);
                }
            }
        }
        return res;

    }
}
