package learn.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Median is the middle value in an ordered integer list.
If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3
[2,3], the median is (2 + 3) / 2 = 2.5
Design a data structure that supports the following two operations:
void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.

Example:
    addNum(1)
    addNum(2)
    findMedian() -> 1.5
    addNum(3)
    findMedian() -> 2

 */
public class FindMedianFromDataStream {

    PriorityQueue<Integer> first_q = new PriorityQueue<>(); // handle first part of array
    PriorityQueue<Integer> second_q = new PriorityQueue<>((a1, a2) -> Integer.compare(a2,a1));     // handle second part of array


    public FindMedianFromDataStream() {

    }

    public void addNum(int num) {
        first_q.add(num);
        second_q.add(first_q.poll());
        if (first_q.size()<second_q.size()) {
            first_q.add(second_q.poll());
        }
    }

    public double findMedian() {
        if ((first_q.size()+second_q.size())%2 == 0){
            return ((double)first_q.peek()+(double)second_q.peek())/2.0;
        }
        else{
            return first_q.peek();
        }
    }
}
