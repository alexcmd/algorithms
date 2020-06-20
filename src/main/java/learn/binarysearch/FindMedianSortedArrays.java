package learn.binarysearch;

import jdk.jshell.spi.ExecutionControl;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       if (nums1.length>nums2.length){
           int[] tmp = nums1;
           nums1 = nums2;
           nums2 = tmp;
       }
       if (nums1.length == 0)
           return nums2.length%2==1?nums2[nums2.length/2]: ((double) nums2[nums2.length/2-1] + (double) nums2[nums2.length/2])/2.0;


       int m = nums1.length;
       int n = nums2.length;
       int left = 0, right=m;
       while (left<=right){
           int i = (left+right)/2;
           int j = (m+n+1)/2 - i;
           if ( i< right && nums2[j-1]>nums1[i])
               left = i+1;
           else if (i>left && nums1[i-1]>nums2[j])
               right = i-1;
           else{
               int maxLeft;
               if (i==0)
                   maxLeft = nums2[j-1];
               else if ( j==0)
                   maxLeft = nums1[i-1];
               else
                   maxLeft = Math.max(nums1[i-1], nums2[j-1]);
               if ((n+m)%2==1)
                   return maxLeft;


               int maxRight;
               if (i==m)
                   maxRight = nums2[j];
               else if (j==n)
                   maxRight = nums1[i];
               else
                   maxRight = Math.min(nums1[i],nums2[j]);
               return ((double) maxLeft+(double) maxRight)/2.0;
           }

       }
       return Integer.MIN_VALUE;
    }
}
