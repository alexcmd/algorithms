package learn.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedSetTest {

    @Test
    public void Test1(){
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        assertEquals(true,randomSet.insert(1));

        // Returns false as 2 does not exist in the set.
        assertEquals(false,randomSet.remove(2));

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        assertEquals(true,randomSet.insert(2));

        // getRandom should return either 1 or 2 randomly.
        randomSet.getRandom();

        // Removes 1 from the set, returns true. Set now contains [2].
        assertEquals(true,randomSet.remove(1));

        // 2 was already in the set, so return false.
        assertEquals(false,randomSet.insert(2));

        // Since 2 is the only number in the set, getRandom always return 2.
        assertEquals(2,randomSet.getRandom());
    }

    @Test
    public void Test2() {
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();
        assertEquals(false,randomSet.remove(0));
        assertEquals(false,randomSet.remove(0));
        assertEquals(true,randomSet.insert(0));
        assertEquals(0,randomSet.getRandom());
        assertEquals(true,randomSet.remove(0));
        assertEquals(true,randomSet.insert(0));

    }
}