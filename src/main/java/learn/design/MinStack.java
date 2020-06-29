package learn.design;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;


/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * Constraints:
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 */
public class MinStack { // Space O(N)

    // value0 is current value,
    // value1 is current min value
    LinkedList<Pair<Integer, Integer>> stack = new LinkedList<>();


    public MinStack() {

    }

    /**
     * Push element x onto stack.
     * Complexity: O(1)
     * @param x
     */
    public void push(int x) {
        var top =  stack.peek();
        int min;
        if (top!=null && top.min<x)
            min = top.min;
        else
            min = x;

        stack.push(new Pair<>(x, min));

    }

    /**
     * Removes the element on top of the stack.
     * Complexity: O(1)
     */
    public void pop() {
        var value = stack.pop();
    }

    /**
     * Get the top element.
     * Complexity: O(1)
     * @return
     */
    public int top() {
        //possible unboxing null but cause Constraints in exercise definition and we won't check
        var item = stack.peek();
        return item!=null?item.value:-1;
    }

    /**
     * Retrieve the minimum element in the stack.
     * Complexity: O(1)
     * @return
     */
    public int getMin() {
        //possible unboxing null but cause Constraints in exercise definition and we won't check
        var item = stack.peek();
        return item!=null?item.min:-1;
    }


    private class Pair<E,K>{
        private final E value;
        private final K min;

        public Pair(E value, K min) {

            this.value = value;
            this.min = min;
        }
    }



}
