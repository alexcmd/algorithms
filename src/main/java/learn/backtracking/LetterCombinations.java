package learn.backtracking;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinations {


    private final List<String> letters = new ArrayList<>();

    private final HashMap<Character, List<Character>> charMap = new HashMap<>(){{
        put('1', Collections.emptyList());
        put('2', Arrays.asList('a','b','c'));
        put('3', Arrays.asList('d','e','f'));
        put('4', Arrays.asList('g','h','i'));
        put('5', Arrays.asList('j','k','l'));
        put('6', Arrays.asList('m','n','o'));
        put('7', Arrays.asList('p','q','r','s'));
        put('8', Arrays.asList('t','u','v'));
        put('9', Arrays.asList('w','x','y','z'));
        put('0', Collections.emptyList());
    }};

    ArrayList<List<Character>> chars = new ArrayList<>();
    /**
     * Total combination binom(n,k)=n!/k!(n-k)!=n!/2(n-2)!
     * Time complexity: O(N*K^2)
     * Space complexity O(N*K^2)
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits ==null || digits.length()==0)
            return letters;

        var d = digits.toCharArray();
        for (char c : d) {
            chars.add(charMap.get(c));
        }

        generate(new LinkedList<>(), 0,digits.length());

        return letters;

    }

    private void generate(LinkedList<Character> builder,  int pos, int max){
        if (pos==max) {
            var sb = new StringBuilder(max);
            for (var item : builder){
                sb.append(item);
            }
            letters.add(sb.toString());
            return;
        }

            var list = chars.get(pos);
            for (var c: list){
                builder.addLast(c);

                generate(builder,pos+1,max);

                builder.removeLast();
            }



    }


}
