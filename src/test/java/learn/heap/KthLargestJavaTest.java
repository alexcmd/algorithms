package learn.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestJavaTest {
    @Test
    public void Test1(){
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used Memory before" + usedMemoryBefore);
        int k = 3;
        int[] arr = new int[]{4,5,8,2};
        KthLargestJava kthLargest = new KthLargestJava(k, arr);
        Assertions.assertEquals(kthLargest.add(3),4);
        Assertions.assertEquals(kthLargest.add(5),5);
        Assertions.assertEquals(kthLargest.add(10),5);
        Assertions.assertEquals(kthLargest.add(9),8);
        Assertions.assertEquals(kthLargest.add(4),8);
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory increased:" + (usedMemoryAfter-usedMemoryBefore));

    }

    @Test
    public void Test2(){
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used Memory before" + usedMemoryBefore);
        int k = 1;
        int[] arr = new int[0];
        KthLargestJava kthLargest = new KthLargestJava(k, arr);
        Assertions.assertEquals(kthLargest.add(-3),-3);
        Assertions.assertEquals(kthLargest.add(-2),-2);
        Assertions.assertEquals(kthLargest.add(-4),-2);
        Assertions.assertEquals(kthLargest.add(0),0);
        Assertions.assertEquals(kthLargest.add(4),4);
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory increased:" + (usedMemoryAfter-usedMemoryBefore));

    }
}