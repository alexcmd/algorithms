package learn.strings;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.
 * It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
 * The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 *
 * Constraints:
 *
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */
public class ReorderDataInLogFiles {
    /**
     * Time complexity: O(N)
     * Space complexity: O(N)
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) { // T(N)+ T(N)-> O(N)
        PriorityQueue<String[]> heap = new PriorityQueue<>((a,b)->{
            int c = b[1].compareTo(a[1]);
            if (c!=0)
                return c;
            return b[0].compareTo(a[0]);

        });

        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i < logs.length; i++) { // T(N)
            var log = logs[i];
            var idx = log.indexOf(' ');
            if (log.charAt(idx+1)>='0' && log.charAt(idx+1)<='9'){
                result.addLast(log);
            }
            else{
                heap.add(new String[]{log.substring(0,idx), log.substring(idx)});
            }
        }
        while (!heap.isEmpty()){ // worst case when all items is letter-log -> T(N)
            var log = heap.poll();
            result.addFirst(log[0]+log[1]);
        }

        String[] ans = new String[logs.length];
        return result.toArray(ans);
    }
}
