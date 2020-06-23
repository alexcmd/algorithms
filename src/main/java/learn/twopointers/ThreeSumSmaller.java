package learn.twopointers;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k
 * with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 */
public class ThreeSumSmaller {
    /**
     * Complexity: O(N^2)
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length<3)
            return 0;
        int result = 0;

        Arrays.sort(nums); // O(NlogN)

        for (int i = 0; i < nums.length - 2; i++) { // O(N^2)
            int mid = i+1;
            int right = nums.length-1;
            int t2 = target - nums[i];
            while (mid<right){   // O(N)
                    int sum = nums[mid]+nums[right];
                    if (sum < t2){
                        result+=right-mid;
                        mid++;
                    }
                    else{
                        right--;
                    }
            }

        }

        return result;
    }
}
