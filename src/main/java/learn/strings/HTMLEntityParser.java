package learn.strings;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * HTML entity parser is the parser that takes HTML code as input and replace all
 * the entities of the special characters by the characters itself.
 *
 * The special characters and their entities for HTML are:
 *
 * Quotation Mark: the entity is &quot; and symbol character is ".
 * Single Quote Mark: the entity is &apos; and symbol character is '.
 * Ampersand: the entity is &amp; and symbol character is &.
 * Greater Than Sign: the entity is &gt; and symbol character is >.
 * Less Than Sign: the entity is &lt; and symbol character is <.
 * Slash: the entity is &frasl; and symbol character is /.
 * Given the input text string to the HTML parser, you have to implement the entity parser.
 *
 * Return the text after replacing the entities by the special characters.
 *
 *
 *
 * Example 1:
 *
 * Input: text = "&amp; is an HTML entity but &ambassador; is not."
 * Output: "& is an HTML entity but &ambassador; is not."
 * Explanation: The parser will replace the &amp; entity by &
 * Example 2:
 *
 * Input: text = "and I quote: &quot;...&quot;"
 * Output: "and I quote: \"...\""
 * Example 3:
 *
 * Input: text = "Stay home! Practice on Leetcode :)"
 * Output: "Stay home! Practice on Leetcode :)"
 * Example 4:
 *
 * Input: text = "x &gt; y &amp;&amp; x &lt; y is always false"
 * Output: "x > y && x < y is always false"
 * Example 5:
 *
 * Input: text = "leetcode.com&frasl;problemset&frasl;all"
 * Output: "leetcode.com/problemset/all"
 */
public class HTMLEntityParser {

    HashMap<String, String> map = new LinkedHashMap<>(){{
        put("&quot;","\"");
        put("&apos;","'");
        put("&gt;",">");
        put("&lt;","<");
        put("&frasl;","/");
        put("&amp;","&");
    }};

    public String entityParserBrutForce(String text) {
        if (text == null || text.length()==0)
            return text;

        for (var key:map.keySet()){
            text = text.replaceAll(key, map.get(key));
        }
        return text;

    }


    public String entityParserWindow(String text) {
        if (text == null || text.length()==0)
            return text;
        var result = new StringBuilder();
        var n = text.length();
        for (int i = 0; i < n; i++) {
            if (text.charAt(i) == '&'){
                int end = i;
                while (end<n && text.charAt(end)!=';' && text.charAt(end)!=' '){
                    end++;
                }
                var substring = text.substring(i,end+1);
                var newStr = map.get(substring);
                if (newStr == null)
                    result.append(substring);
                else
                    result.append(newStr);
                i=end;
            }
            else
                result.append(text.charAt(i));

        }


        return result.toString();

    }
}
