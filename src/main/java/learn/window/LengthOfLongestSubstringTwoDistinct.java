package learn.window;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null)
            return 0;
        HashMap<Character,Integer> chr = new HashMap<>();

        int res = 0;
        int i=0,j=0;
        int n = s.length();
        while (i<n && j<n){
            Character j_chr = s.charAt(j);
            if (chr.containsKey(j_chr) || chr.size()<2){
                Integer cnt = chr.get(j_chr);
                if (cnt==null)
                    cnt=0;
                chr.put(j_chr,cnt+1);
                j++;
                res = Math.max(res,j-i);
            }
            else{
                char i_chr = s.charAt(i);
                int cnt = chr.get(i_chr);
                if (cnt==1)
                    chr.remove(i_chr);
                else
                    chr.put(i_chr,cnt-1);
                i++;
            }

        }
        return res;

    }
}
