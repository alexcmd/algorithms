package learn.arrays;

import java.util.Arrays;

public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int k) {
        if (A.length <2)
            return -1;

        Arrays.sort(A);
        int n = A.length;
        int i=0;int j=n-1;
        int ans=-1;

        while (i<j){
            if (A[i]+A[j]<k){
                ans = Math.max(ans, A[i]+A[j]);
                i++;

            }
            else{
                j--;
            }
        }
        return ans;
    }
}
