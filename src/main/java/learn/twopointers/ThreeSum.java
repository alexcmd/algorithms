package learn.twopointers;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero. *
 * Note:
 *  The solution set must not contain duplicate triplets.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (nums.length<3)
            return result;
        Arrays.sort(nums); // O(nlogn)
        HashSet<Pair<Integer, Integer>> founded = new HashSet<>();
        int right = nums.length - 1;
        for (int i = 0; i < nums.length-2; i++) { //O(nlogn)
            int mid = i + 1;
            while (mid < right) {
                int sum = nums[i] + nums[mid] + nums[right];
                if (sum < 0) {
                    mid++;
                } else if (sum > 0) {
                    right--;
                } else {
                    if (founded.add(new Pair<>(nums[i],nums[mid])))
                        result.add(Arrays.asList(nums[i], nums[mid], nums[right]));
                    mid++;
                }
            }
        }
        return result;
    }
}
