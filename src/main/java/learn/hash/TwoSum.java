package learn.hash;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i=0;i<nums.length;i++){
            if (!map.containsKey(nums[i]))
                map.put(nums[i],i);
        }

        for (int i =0; i< nums.length;i++){
            int next = target - nums[i];
            if (map.containsKey(next) && map.get(next)!=i){
                return new int[]{i, map.get(next)};
            }
        }
        return new int[0];
    }
}
