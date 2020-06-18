package learn.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/*
Suppose LeetCode will start its IPO soon.
In order to sell a good price of its shares to Venture Capital,
 LeetCode would like to work on some projects to increase its capital before the IPO.
Since it has limited resources, it can only finish at most k distinct projects before the IPO.
Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
You are given several projects. For each project i, it has a pure profit Pi and a minimum capital
of Ci is needed to start the corresponding project. Initially, you have W capital.
When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital,
and output your final maximized capital.

 */
public class IPO {
    public int findMaximizedCapital(int k, int W, int[] profits, int[] capital) {
        PriorityQueue<int[]> queue_profits = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // min heap, 0: profit, 1: capital
        for (int i = 0; i < profits.length; i++) {
            queue_profits.add(new int[]{profits[i],capital[i]});
        }

        PriorityQueue<Integer> max_capital = new PriorityQueue<>((a,b)-> b-a); //max_heap
        while (k>0) {
            while (!queue_profits.isEmpty() && queue_profits.peek()[1] <= W) {
                max_capital.add(queue_profits.poll()[0]);
            }

            if (max_capital.isEmpty())
                break;

            W+=max_capital.poll();
            k--;
        }
        return W;
    }
}
