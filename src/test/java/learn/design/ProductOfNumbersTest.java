package learn.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfNumbersTest {

    @Test
    public void Test1() {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        var actual = productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
        assertEquals(20, actual);
        actual = productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
        assertEquals(40, actual);
        actual = productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
        assertEquals(0, actual);
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        actual = productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32
        assertEquals(32, actual);
    }
}