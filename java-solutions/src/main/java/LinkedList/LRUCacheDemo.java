package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDemo<K,V> {

    private final int capacity;
    private final Map<K, Node<K, V>> cache;
    private final Node<K, V> dummyHead;
    private final Node<K, V> dummyTail;

    public LRUCacheDemo(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.dummyHead = new Node<>(null, null);
        this.dummyTail = new Node<>(null, null);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            Node<K, V> node = cache.get(key);
            moveToHead(node);
            return node.value;
        }
        return null;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            Node<K, V> node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            if (cache.size() >= capacity) {
                Node<K, V> removed = removeTail();
                cache.remove(removed.key);
            }
            Node<K, V> newNode = new Node<>(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
        }
    }

    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node<K, V> node) {
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next = node;
        node.next.prev = node;
    }

    private Node<K, V> removeTail() {
        Node<K, V> tail = dummyTail.prev;
        removeNode(tail);
        return tail;
    }





    public static void main(String[] args) {
        LRUCacheDemo<Integer, String> cache = new LRUCacheDemo<>(2);

        cache.put(1, "One");
        cache.put(2, "Two");

        System.out.println(cache.get(1)); // Output: "One"
        System.out.println(cache.get(2)); // Output: "Two"

        // Accessing 1 will make it the most recently used item.
        cache.put(3, "Three");

        System.out.println(cache.get(2)); // Output: null (evicted)
    }
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}


