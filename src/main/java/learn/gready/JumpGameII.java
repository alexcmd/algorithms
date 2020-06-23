package learn.gready;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 */
public class JumpGameII {
    /**
     * Complexity: O(N)
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
       if (nums.length<2)
           return 0;
       int maxPos = nums[0];
       int maxSteps = nums[0];
       int result = 1 ;
       for(int i = 1; i<nums.length;i++){
           if (i>maxSteps){
               result++;
               maxSteps = maxPos;
           }
           maxPos = Math.max(maxPos, i+nums[i]);
       }
       return result;
    }
}
