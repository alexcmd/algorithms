package learn.hash;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    public void Test1(){
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] expected = new int[]{0,1};
        int[] actual = new TwoSum().twoSum(arr,target);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void Test2(){
        int[] arr = new int[]{3,2,4};
        int target = 6;
        int[] expected = new int[]{1,2};
        int[] actual = new TwoSum().twoSum(arr,target);
        assertArrayEquals(expected,actual);
    }

}