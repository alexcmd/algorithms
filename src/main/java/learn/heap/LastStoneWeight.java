package learn.heap;

public class LastStoneWeight {
    private int[] stones;
    private int n;

    public int lastStoneWeight(int[] stones) {
        if (stones.length==0)
            return 0;
        this.stones = stones;
        this.n = stones.length;
        build_max_heap();
        return simulate();
    }

    private void build_max_heap() {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            max_heapify(i);
        }
    }

    private void max_heapify(int i) {
        int l = 2 * i;
        int r = 2 * i + 1;
        int max_id = i;
        if (l < n && stones[l] > stones[max_id]) {
            max_id = l;
        }
        if (r < n && stones[r] > stones[max_id]) {
            max_id = r;
        }
        if (max_id != i) {
            int tmp = stones[i];
            stones[i] = stones[max_id];
            stones[max_id] = tmp;
            max_heapify(max_id);
        }
    }

    private int simulate() {
        while (n > 1) {
            int y = extract_max();
            int x = extract_max();
            int res = y - x;
            if (res == 0)
                continue;
            n++;
            increase_key(n-1, res);

        }
        return stones[0];
    }

    private int extract_max() {
        int res = stones[0];
        stones[0] = stones[n - 1];
        stones[n - 1] = 0;
        n--;
        max_heapify(0);
        return res;
    }

    private void increase_key(int i, int val) {
        stones[i] = val;
        int p = i / 2;
        while (i > 0 && stones[p] < stones[i]) {
            int tmp = stones[i];
            stones[i] = stones[p];
            stones[p] = tmp;
            i = p;
            p = i/2;
        }
    }


}




