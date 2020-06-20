package learn.gready;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are a number of spherical balloons spread in two-dimensional space.
 * For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal,
 * y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice.
 * Start is always smaller than end. There will be at most 104 balloons.
 *
 * An arrow can be shot up exactly vertically from different points along the x-axis.
 * A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend.
 * There is no limit to the number of arrows that can be shot.
 * An arrow once shot keeps travelling up infinitely.
 * The problem is to find the minimum number of arrows that must be shot to burst all balloons.
 *
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length==0)
            return 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int result = 1;
        int first_end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0]>first_end){
                result++;
                first_end = points[i][1];
            }
        }

        return result;

    }
}
