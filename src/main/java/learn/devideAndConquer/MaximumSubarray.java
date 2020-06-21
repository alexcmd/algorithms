package learn.devideAndConquer;

public class MaximumSubarray {
    int[] A;
    public int maxSubArray(int[] nums) {
        A = nums;
        if (nums.length==0)
            return 0;
        return helper(0, A.length-1); // T(N) = aT(N/b) + [merge] , (a=2, b=2)
    }

    private int helper( int left, int right){
        if (left == right)
            return A[left];
        int center = (left+ right)/2;

        int leftSum = helper(left,center);
        int rightSum = helper(center+1, right); // O(2* (k/2))
        int crossSum = crossSum(left,right, center); // O(N)

        return Math.max(Math.max(leftSum,rightSum), crossSum);
    }


    private int crossSum(int left, int right, int center){
        if (left == right)
            return A[left];

        int localSum = A[center];
        int bestLeftSum = A[center];
        for (int i = center-1; i >= left ; i--) {
            localSum+= A[i];
            bestLeftSum = Math.max(bestLeftSum, localSum);
        }

        localSum = A[center+1];
        int bestRightSum = A[center+1];
        for (int i = center+2; i <= right; i++) {
            localSum +=A[i];
            bestRightSum = Math.max(bestRightSum,localSum);
        }

        return bestLeftSum+bestRightSum;
    }


}
