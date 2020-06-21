package learn.design;

import java.util.ArrayList;

/**
 * Implement the class ProductOfNumbers that supports two methods:
 *
 * 1. add(int num)
 * Adds the number num to the back of the current list of numbers.
 *
 * 2. getProduct(int k)
 * Returns the product of the last k numbers in the current list.
 * You can assume that always the current list has at least k numbers.
 * At any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.
 */
public class ProductOfNumbers {

    ArrayList<Integer> sequence = new ArrayList<>(){{add(1);}};

    public ProductOfNumbers() {

    }

    /**
     * Adds the number num to the back of the current list of numbers.
     * Complexity:  O(1)
     * @param num next int number
     */
    public void add(int num) {

        if (num>0) {
            sequence.add(sequence.get(sequence.size()-1)* num);
        }
        else{
            sequence = new ArrayList<>(){{add(1);}};
        }
    }

    /**
     * Returns the product of the last k numbers in the current list.
     * Complexity:  O(1)
     * @param k
     * @return production of K last numbers
     */
    public int getProduct(int k) { //
        int size = sequence.size();
        if (k>= size)
            return 0;
        return sequence.get(size -1) / sequence.get(size-k-1);
    }
}
