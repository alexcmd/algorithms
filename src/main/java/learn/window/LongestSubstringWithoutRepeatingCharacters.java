package learn.window;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() ==0)
            return 0;

        HashSet<Character> chs = new HashSet<>();


        int result = 0;
        int i=0,j=0;
        int n = s.length();
        while (i<n && j<n){
            if (!chs.contains(s.charAt(j))){
                chs.add(s.charAt(j));
                j++;
                result = Math.max(result,j-i);
            }
            else{
                chs.remove(s.charAt(i));
                i++;
            }

        }
        return result;
    }

}
