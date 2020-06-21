package learn.gready;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length==0)
            return 0;
        int curSum = nums[0];
        int globalSum = nums[0];
        for (int i = 1; i < nums.length ; i++) {  // O(N)
            curSum = Math.max(nums[i], curSum+nums[i]);
            globalSum = Math.max(globalSum, curSum);
        }
        return globalSum; // O(N)
    }
}
