import java.util.*;

class LRUCache {
    class Node {
        int key, val;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int cap;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insertToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        if (map.size() == cap) {
            remove(tail.prev);  
        }

        Node newnode = new Node(key, value);
        insertToHead(newnode);
    }

    private void remove(Node node) {
        map.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToHead(Node node) {
        map.put(node.key, node);

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}
