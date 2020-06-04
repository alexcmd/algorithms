package learn.heap;

public class KthLargestFromScratch {

    private final int[] nums;
    private int nums_length;
    private int[] queue;
    public KthLargestFromScratch(int k, int[] nums) {
        queue = new int[k];
        nums_length =  nums.length;
        this.nums = nums;
        prepare_sorted_queue();

    }

    public int add(int val) {
        if (val<queue[queue.length-1])
            return queue[queue.length-1];

        int insert_position = binary_search(val);
        if (queue.length - 1 - insert_position >= 0)
            System.arraycopy(queue, insert_position, queue, insert_position + 1, queue.length - 1 - insert_position);
        queue[insert_position] = val;
        return queue[queue.length-1];


    }

    private void build_max_heap(){

        for (int i = (nums.length-1)/2;i>=0;i--){
            max_heapify(i);
        }
    }

    private void max_heapify(int i){
        int l = 2*i;
        int r = 2*i+1;
        int max_id = i;
        if (l<nums_length && nums[l]> nums[max_id]){
            max_id = l;
        }
        if (r<nums_length && nums[r]> nums[max_id]){
            max_id = r;
        }
        if (max_id!=i){
            int tmp = nums[i];
            nums[i] = nums[max_id];
            nums[max_id] = tmp;
            max_heapify(max_id);
        }
    }

    private void prepare_sorted_queue(){
        build_max_heap();
        int n = queue.length;
        for (int i=0;i<n;i++){
            if (nums_length ==0) {
                queue[i] = Integer.MIN_VALUE;
                continue;
            }
            queue[i] = nums[0];
            nums[0] = nums[nums_length-1];
            nums_length--;
            max_heapify(0);
        }
    }

    private int binary_search(int val){
        int low = 0;
        int high = queue.length-1;
        while (low<high){
            int mid = (low+high)/2;

            if (val>= queue[mid])
                high=mid;
            else
                low=mid+1;
        }
        return high;
    }




}
