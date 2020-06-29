package learn.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LRUCacheTest {


    @Test
    public void Test1(){
        LRUCache cache = new LRUCache( 2 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1,cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        assertEquals(-1,cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        assertEquals(-1,cache.get(1));       // returns -1 (not found)
        assertEquals(3,cache.get(3));       // returns 3
        assertEquals(4,cache.get(4));       // returns 4
    }
    @Test
    public void Test2(){
        LRUCache cache = new LRUCache( 3 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);    // evicts key 1
        assertEquals(4,cache.get(4));       // returns 4
        assertEquals(3,cache.get(3));       // returns 3
        assertEquals(2,cache.get(2));       // returns 2
        assertEquals(-1,cache.get(1));       // returns -1 (not found)
        cache.put(5, 5);    // evicts key 4
        assertEquals(-1,cache.get(1));       // returns -1 (not found)
        assertEquals(2,cache.get(2));       // returns 2
        assertEquals(3,cache.get(3));       // returns 3
        assertEquals(-1,cache.get(4));       // returns -1 (not found)
        assertEquals(5,cache.get(5));       // returns 5
    }

    @Test
    public void Test3(){
        LRUCache cache = new LRUCache( 1 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);  // evicts key 1
        assertEquals(-1,cache.get(1));
        cache.put(3, 3);    // evicts key 2
        assertEquals(-1,cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 3
        assertEquals(-1,cache.get(1));       // returns -1 (not found)
        assertEquals(-1,cache.get(3));       // returns 3
        assertEquals(4,cache.get(4));       // returns 4
    }
}