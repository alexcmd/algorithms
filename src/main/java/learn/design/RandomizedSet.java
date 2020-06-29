package learn.design;

import java.util.*;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements
 *      (it's guaranteed that at least one element exists when this method is called).
 *      Each element must have the same probability of being returned.
 */
public class RandomizedSet {

    private final Random rnd;
    private final HashMap<Integer, Integer> hashMap;
    private final ArrayList<Integer> list;

    public RandomizedSet() {
        rnd = new Random(Integer.MAX_VALUE);
        hashMap = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     * @param val
     * @return
     */
    public boolean insert(int val) {
        if (hashMap.containsKey(val))
            return false;

        hashMap.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element
     * @param val
     * @return
     */
    public boolean remove(int val) {
        if (!hashMap.containsKey(val))
            return false;

        var idx = hashMap.get(val);
        hashMap.remove(val);
        var moving = list.get(list.size() - 1);
        if (moving!=val) {
            hashMap.put(moving, idx);
            list.set(idx, moving);
        }

        list.remove(list.size() - 1);

        return true;
    }

    /**
     * Get a random element from the set.
     * @return
     */
    public int getRandom() {
        var idx = rnd.nextInt(list.size());
        return list.get(idx);
    }
}
