package learn.window;

import java.util.HashMap;
import java.util.HashSet;

public class TotalFruit {
    public int totalFruit(int[] tree) {
        int k=2;
        int i=0,j=0;
        int ans = 0;
        int n = tree.length;

        HashMap<Integer,Integer> counter = new HashMap<>();

        while (i<n && j<n){
            if (counter.containsKey(tree[j]) || counter.size()<k){
                Integer cnt = counter.get(tree[j]);
                if (cnt == null)
                    cnt = 0;
                counter.put(tree[j],cnt+1);
                j++;
                ans = Math.max(ans, j-i);
            }
            else {
                Integer cnt = counter.get(tree[i]);
                if (cnt == 1)
                    counter.remove(tree[i]);
                else
                    counter.put(tree[i], cnt - 1);

                i++;
            }

        }
        return ans;
    }
}
