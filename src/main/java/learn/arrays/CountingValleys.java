package learn.arrays;

/**
 * An avid hiker keeps meticulous records of their hikes. During the last hike that took exactly  steps, for every step it was noted if it was an uphill, , or a downhill,  step. Hikes always start and end at sea level, and each step up or down represents a  unit change in altitude. We define the following terms:
 *
 * A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
 * A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
 * Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.
 * - A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
 * - A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
 */
public class CountingValleys {
    private static final Character UP = 'U';
    private static final Character DOWN = 'D';
    public int countingValleys(int steps, String path) {
        int curAlt = 0;
        int valleysCount = 0;
        char[] chars = path.toCharArray();
        for (int i=0; i< steps; i++){
            if (chars[i] == UP) {
                curAlt++;
                if (curAlt==0){
                    valleysCount++;
                }
            }
            if (chars[i] == DOWN) {
                curAlt--;

            }

        }
        return valleysCount;
    }
}
