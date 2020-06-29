package learn.design;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 */
public class LRUCache {  // Space usage O(N)

    private int capacity;
    private HashMap<Integer, Node> nodes = new HashMap<>();
    private Node first = null;
    private Node last = null;
    private int currentCapacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Complexity: O(1)
     * @param key
     * @return
     */
    public int get(int key) {
        if (!nodes.containsKey(key))
            return -1;
        var node = nodes.get(key);
        putAhead(node);
        return node.item;

    }


    /**
     * Complexity: O(1)
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        var node =nodes.get(key);
        if (node==null){
            if (nodes.size() == capacity)
                removeLastRecentUse();
            node = new Node(key,value);
            node.next = first;
            if (first!=null)
                first.prev = node;
            first = node;
            if(last ==null)
                last = first;
            nodes.put(key, node);

        }
        else{
            node.item = value;
            putAhead(node);
        }


    }

    private void removeLastRecentUse(){
        if (last == null)
            return;
        nodes.remove(last.key);
        var prev = last.prev;
        if (prev!=null)
            prev.next = null;
        last.prev = null;
        last = prev;
    }

    private void putAhead(Node node) {
        if (node.equals(first))
            return;

        var prev = node.prev;
        var next = node.next;

        prev.next = next;

        if (next == null){
            last = prev;
        }
        else{
            next.prev = prev;
        }

        node.prev = null;
        node.next = first;
        first.prev = node;
        first = node;
    }


    private class Node{
        private int key;
        private int item;
        private Node next;
        private Node prev;

        public Node() {
        }

        public Node(int key, int item) {
            this.key = key;
            this.item = item;
        }

        public Node(int key, int item, Node next) {
            this.key = key;
            this.item = item;
            this.next = next;
        }


    }
}
