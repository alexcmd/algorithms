package learn.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {
    private List<List<Integer>> list = new ArrayList<>();

    /**
     * Time complexity: O(N!)
     * 0 postion -> n
     * 1 postion -> n-1
     * k postion -> n-k
     * n postion -> 1
     *  n*(n-1)*...*(n-k)*...*1 -> n! combination
     * Space complexity O(N!)
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        generate(nums, 0);
        return list;

    }

    /**
     * Backtracking algorithm implementation
     * @param nums current permutation
     * @param position next index
     */
    private void generate(int[] nums, int position){
        if (position == nums.length){
            List<Integer> p = new ArrayList<>(nums.length);
            for (int i: nums){
                p.add(i);
            }
            list.add(p);
            return;
        }
        for (int i=position; i<nums.length;i++){ // try k times k-1 elements
            swap(nums,i, position);
            generate(nums,position+1);
            swap(nums,position,i);
        }
    }

    private void swap(int[] nums, int from, int to){
        int tmp = nums[from];
        nums[from] = nums[to] ;
        nums[to] = tmp;
    }
}
