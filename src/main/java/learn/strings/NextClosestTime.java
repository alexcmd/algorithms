package learn.strings;

import java.util.HashSet;

/**
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.
 *
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 *
 * Example 1:
 *
 * Input: "19:34"
 * Output: "19:39"
 * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
 * Example 2:
 *
 * Input: "23:59"
 * Output: "22:22"
 * Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next
 */
public class NextClosestTime {
    /**
     * Calculate next closest time to given contains only digits from input
     * @param time
     * @return
     */
    public String nextClosestTime(String time) {
        int hours = Integer.parseInt(time.substring(0,2));
        int minutes = Integer.parseInt(time.substring(3));
        HashSet<Integer> digits = new HashSet<>();
        int pos =0;
        for (int i = 0; i < time.length(); i++) {

            if (time.charAt(i)==':')
                continue;
             digits.add(time.charAt(i)-'0');
        }
        int base =hours*60+minutes;
        int cur = base;
        int diff = 24*60;

        for (int i: digits){
            for (int j: digits){
                int h = i*10+j;
                if (h>23)
                    continue;
                for (int k: digits){
                    for (int l: digits){
                        int m = k*10+l;
                        if (m>59)
                            continue;
                        int next = h*60+m;
                        int nextDiff =Math.floorMod (next - base,24*60);
                        if (nextDiff>0 && nextDiff<diff)
                        {
                            cur = next;
                            diff = nextDiff;
                        }

                    }
                }

            }

        }

        hours = cur/60;
        minutes = cur%60;
        return String.format("%02d:%02d",hours,minutes);

    }
}
