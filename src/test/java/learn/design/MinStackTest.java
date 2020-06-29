package learn.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    @Test
    public void Test1(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(-3,minStack.getMin()); // return -3
        minStack.pop();
        assertEquals(0,minStack.top());    // return 0
        assertEquals(-2,minStack.getMin()); // return -2
    }

}