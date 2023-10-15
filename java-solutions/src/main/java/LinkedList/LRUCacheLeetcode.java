package LinkedList;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLeetcode {

        private final int capacity;
        private final LinkedHashMap<Integer, Integer> cache;

        public LRUCacheLeetcode(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
        }

        public int get(int key) {
            return cache.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            if (cache.size() >= capacity && !cache.containsKey(key)) {
                Iterator<Map.Entry<Integer, Integer>> iterator = cache.entrySet().iterator();
                iterator.next();
                iterator.remove();
            }
            cache.put(key, value);
        }

        public static void main(String[] args) {
            LRUCacheLeetcode cache = new LRUCacheLeetcode(2);

            cache.put(1, 1);
            cache.put(2, 2);

            System.out.println(cache.get(1)); // Output: 1

            cache.put(3, 3); // Removes 2 because it's the least recently used item.

            System.out.println(cache.get(2)); // Output: -1 (2 is no longer in the cache)
            System.out.println(cache.get(3)); // Output: 3
        }
    }


