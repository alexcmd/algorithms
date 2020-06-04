package learn.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LastStoneWeightTest {

    @Test
    public void Test1(){
        int[] stones = new int []{ 2,7,4,1,8,1};
        LastStoneWeight stoneWeight = new LastStoneWeight();
        assertEquals(stoneWeight.lastStoneWeight(stones),1);
    }

    @Test
    public void Test2(){
        int[] stones = new int []{ 2};
        LastStoneWeight stoneWeight = new LastStoneWeight();
        assertEquals(stoneWeight.lastStoneWeight(stones),2);
    }

    @Test
    public void Test3(){
        int[] stones = new int []{ 2,7,4,1,10};
        LastStoneWeight stoneWeight = new LastStoneWeight();
        assertEquals(stoneWeight.lastStoneWeight(stones),0);
    }
    @Test
    public void Test4(){
        int[] stones = new int [0];
        LastStoneWeight stoneWeight = new LastStoneWeight();
        assertEquals(stoneWeight.lastStoneWeight(stones),0);
    }


}