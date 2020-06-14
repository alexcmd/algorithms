package learn.twopointers;

import learn.twopointers.FourSum;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FourSumTest {

    @Test
    public void Test1(){
        var arr = new int[] {1, 0, -1, 0, -2, 2};
        var target = 0;
        var expected = Arrays.asList(
                Arrays.asList(-1,  0, 0, 1),
                Arrays.asList(-2, -1, 1, 2),
                Arrays.asList(-2,  0, 0, 2));

//        var actual = new FourSum().fourSum(arr,target);
//        assertEquals(expected,actual);

    }

}