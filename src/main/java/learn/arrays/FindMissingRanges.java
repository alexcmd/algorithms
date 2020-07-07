package learn.arrays;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper],
 * return its missing ranges.
 *
 * Example:
 *
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 */
public class FindMissingRanges {

    /**
     *
     * @param nums sorted array
     * @param lower lower bound
     * @param upper upper bound
     * @return List of missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int localLower = lower;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (localLower<cur){
                result.add(format(localLower, cur-1));
            }
            if (cur == upper)
                return result;

            localLower = cur+1;
        }

        if(localLower<=upper){
            result.add(format(localLower,upper));
        }
        return result;
    }

    private String format(int a, int b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        if (b>a){
            sb.append("->").append(b);
        }
        return sb.toString();
    }
}
