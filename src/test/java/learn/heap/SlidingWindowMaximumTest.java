package learn.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowMaximumTest {

    @Test
    public void Test1(){
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

        int[] ints = slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7},3);
        assertArrayEquals(new int[]{3,3,5,5,6,7}, ints);
    }

    @Test
    public void Test2(){
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

        int[] ints = slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7},8);
        assertArrayEquals(new int[]{7}, ints);
    }

    @Test
    public void Test3(){
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

        int[] ints = slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7},1);
        assertArrayEquals(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, ints);
    }

}