package learn.window;

import java.util.Arrays;

public class MedianSlidingWindow {

        private int[] window;
        private int window_size;

        public double[] medianSlidingWindow(int[] nums, int k) {
            if (k==0 || nums.length==0)
                return new double[0];

            window = Arrays.copyOfRange(nums, 0, k);
            window_size = window.length;

            double[] ans = new double[nums.length - k +1];
            heapSort();
            int j = 0;
            ans[j++] = getMedian();
            for (int i = k;i<nums.length;i++){
                replace(nums[i-k],nums[i]);
                ans[j++] = getMedian();
            }
            return ans;
        }

    private double getMedian() {
        int i = (window_size-1)/2;
        if (window_size%2==0){
            return ((double) window[i]+ (double) window[i+1])/2.0;
        }
        else {
            return window[i];
        }
    }

    private void buildMaxHeap(){
            for(int i = (window.length-1)/2; i>=0 ; i--){
                maxHeapify(i);
            }
        }

        private void maxHeapify(int i){
            int left = i*2;
            int right=i*2+1;
            int max_idx = i;
            if (left<window_size && window[left]> window[max_idx])
                max_idx = left;
            if (right<window_size && window[right]> window[max_idx])
                max_idx= right;
            if (max_idx != i){
                int tmp = window[max_idx];
                window[max_idx] = window[i];
                window[i] = tmp;
                maxHeapify(max_idx);
            }

        }

        private void replace(int old, int val){
            int old_idx = binarySearch(old);
            window[old_idx] = val;
            heapSort();
        }


        private void heapSort(){
            buildMaxHeap();
            int init_size = window_size;
            for (int i = init_size-1; i>0;i--){
                int tmp = window[0];
                window[0] = window[i];
                window[i] = tmp;
                window_size--;
                maxHeapify(0);
            }
            window_size = window.length;
        }

        private int binarySearch(int val){
            int left = 0, right = window_size-1;
            while (left<=right){
                int m = (left+right)/2;
                if (window[m] == val)
                    return m;
                if (window[m]< val)
                    left = m+1;
                else
                    right = m-1;
            }
            return  -1;
        }

}
