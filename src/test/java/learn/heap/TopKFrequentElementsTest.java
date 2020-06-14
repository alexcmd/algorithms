package learn.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentElementsTest {

    @Test
    public void Test1(){
        int[] arr = new int[]{1,1,1,2,2,3};
        int k = 2;
        TopKFrequentElements frequentElements = new TopKFrequentElements();
        int[] result = frequentElements.topKFrequent(arr, k);
        Assertions.assertArrayEquals(result, new int[]{1,2});
    }

    @Test
    public void Test2(){
        int[] arr = new int[]{1};
        int k = 1;
        TopKFrequentElements frequentElements = new TopKFrequentElements();
        int[] result = frequentElements.topKFrequent(arr, k);
        Assertions.assertArrayEquals(result, new int[]{1});
    }

    @Test
    public void Test3(){
        int[] arr = new int[]{1};
        int k = 2;
        TopKFrequentElements frequentElements = new TopKFrequentElements();
        int[] result = frequentElements.topKFrequent(arr, k);
        Assertions.assertArrayEquals(result, new int[]{1});
    }

}