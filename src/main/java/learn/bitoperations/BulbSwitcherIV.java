package learn.bitoperations;

public class BulbSwitcherIV {
    public int minFlips(String target) {
        int t=0;
        int cur = 0;
        int ans = 0;

        int n =target.length();
        int next_idx = n ;
        for (int i=n-1; i>=0; i--){
            if (target.charAt(i) == '1') {
                t |= (1 << (i));
                next_idx = i;
            }
        }


        while (next_idx<n){
            ans++;
            cur = flip(cur,n,next_idx);
            next_idx = findNextIdx(t,cur, n, next_idx);
        }

        return ans;
    }

    private int findNextIdx(int target, int cur, int size,  int last_idx) {
        for (int i = last_idx; i < size ; i++) {
            if (getBit(target,i) !=getBit(cur,i))
                return i;
        }
        return size;
    }

    private boolean getBit(int num, int pos){
        return (num & (1<<pos)) !=0;
    }

    private int flip(int num,int size, int pos){
        int mask = (-1>>>31-size)<<pos;
        return  num^mask;
    }


}
