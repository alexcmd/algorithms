package learn.window;

/**
 * A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:
 *
 * For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
 * OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
 * That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
 *
 * Return the length of a maximum size turbulent subarray of A.
 */
public class LongestTurbulentSubarray {

    /**
     *  Length of a maximum size turbulent subarray of A.
     *  Complexity: O(N)
     * @param A input array
     * @return maximum turbulent sequence
     */
    public int maxTurbulenceSize(int[] A) {
        if(A.length==0)
            return 0;

        int left = 0;
        int right=1;
        int maxSubsequence = 1;

        while (right<A.length){
            int compare  = Integer.compare(A[right-1],A[right]);
            if (compare == 0)
                left=right;
            else if (right==A.length-1 || compare * Integer.compare(A[right],A[right+1])!=-1){
                maxSubsequence = Math.max(maxSubsequence, right-left+1);
                left=right;
            }
            right++;
        }
        return maxSubsequence;
    }
}
