package learn.design;

import java.util.HashMap;

/**
 * Design a logger system that receive stream of messages along with its timestamps,
 * each message should be printed if and only if it is not printed in the last 10 seconds.
 *
 * Given a message and a timestamp (in seconds granularity),
 * return true if the message should be printed in the given timestamp, otherwise returns false.
 *
 * It is possible that several messages arrive roughly at the same time.
 */
public class LoggerRateLimiter { // Space O(N)

    private final HashMap<String, Integer> storage = new HashMap<>();

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     *         If this method returns false, the message will not be printed.
     *         The timestamp is in seconds granularity.
     * Complexity: O(1)
     *
     * @param timestamp
     * @param message
     * @return
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer last = storage.get(message);
        if (last==null || timestamp-last>=10){
            storage.put(message, timestamp);
            return true;
        }
        return false;
    }
}
