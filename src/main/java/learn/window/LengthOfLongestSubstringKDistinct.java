package learn.window;


import java.util.HashMap;
import java.util.HashSet;

/*
* Given a string, find the length of the longest substring T that contains at most k distinct characters.
*/
public class LengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s ==null || s.length()==0 || k==0)
            return 0;
        HashMap<Character, Integer> chrs = new HashMap<>();
        int res =0;
        int i=0,j=0;
        int n= s.length();
        while (i<n && j<n){
            var j_chr = s.charAt(j);
            if (chrs.containsKey(j_chr) || chrs.size()<k){
                Integer cnt =  chrs.get(j_chr);
                if (cnt == null)
                    cnt = 0;
                chrs.put(j_chr,cnt+1);
                j++;
                res = Math.max(res, j-i);
            }
            else{
                Character i_chr = s.charAt(i);
                Integer cnt = chrs.get(i_chr);

                if (cnt == 1)
                    chrs.remove(i_chr);
                else
                    chrs.put(i_chr,cnt-1);
                i++;
            }
        }
        return  res;

    }
}
