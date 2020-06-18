package learn.heap;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> counter = new HashMap<>();

        for (String s: words){
            if (!counter.containsKey(s))
                counter.put(s,0);

             counter.put(s, counter.get(s)+1);
        }

        PriorityQueue<String> queue =
                new PriorityQueue<>((a,b)->counter.get(a).equals(counter.get(b))?b.compareTo(a):counter.get(a)-counter.get(b));
        for( var s : counter.keySet()){
            queue.add(s);
            if (queue.size()>k)
                queue.poll();
        }

        LinkedList<String> result = new LinkedList<>();
        while (!queue.isEmpty()){
            result.addFirst(queue.poll());
        }

        return result;

    }
}
