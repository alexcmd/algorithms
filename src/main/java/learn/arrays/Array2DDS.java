package learn.arrays;

import java.lang.reflect.Array;

/**
 * 2D Convolution 6x6 matrix by 3x3 matrix
 *
 * Given a  2D Array, : *
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 *
 *
 * An hourglass in  is a subset of values with indices falling in this pattern in 's graphical representation:
 *
 * a b c    1 0 1
 *   d      1 1 1
 * e f g    1 0 1
 * There are  hourglasses in . An hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum. The array will always be .
 *
 */
public class Array2DDS {
    private static final int[][] core = new int[][]{{1,0,1},{1,1,1},{1,0,1}};

    public int hourglassSum(int[][] arr){
        int maxConv = Integer.MIN_VALUE;

        int[][] tmp = new int[4][4];
        var x = arr.length;
        var y =arr[0].length;
        for (int i=0; i<=x-core.length;i++){
            for(int j =0;j<=y-core[0].length;j++){
                var sum = 0;
                for(int k = 0;k<core.length;k++)
                    for (int l = 0;l<core[k].length;l++){
                        sum+= arr[i+k][j+l]*core[l][k];
                    }
                tmp[i][j] = sum;
                maxConv = Math.max(sum, maxConv);
            }
        }
        return maxConv;
    }
}
