package learn.hash;

import java.util.*;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length()<p.length())
            return result;

        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        for(Character c: p.toCharArray()){
            if (pMap.containsKey(c)){
                pMap.put(c, pMap.get(c)+1);
            }
            else {
                pMap.put(c,1);
                sMap.put(c,0);
            }
        }
        int w_size = p.length();


        for (int i=0;i<s.length();i++){

            int l_idx = i-w_size;
            if (l_idx>=0  && sMap.containsKey(s.charAt(l_idx))) {
                sMap.put(s.charAt(l_idx), sMap.get(s.charAt(l_idx)) - 1);


            }

            Character c = s.charAt(i);
            if (!pMap.containsKey(c) ) {
                continue;
            }

            sMap.put(c, sMap.get(c)+1);
            if (sMap.equals(pMap))
                result.add(i-w_size+1);

        }
        return result;

    }
}
