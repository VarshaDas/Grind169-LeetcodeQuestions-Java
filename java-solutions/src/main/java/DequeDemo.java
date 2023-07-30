import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {

        public static void main(String[] args) {
            Deque<Integer> deque = new ArrayDeque<>();

            // Adding elements to the deque
            deque.offerFirst(1); // Adding element at the front
            deque.offerLast(2); // Adding element at the end
            deque.offerFirst(3);
            deque.offerLast(4);
            System.out.println("Deque after adding elements: " + deque); // Output: [3, 1, 2, 4]

            // Removing elements from the deque
            int frontElement = deque.pollFirst(); // Removing element from the front
            int rearElement = deque.pollLast(); // Removing element from the end
            System.out.println("Front element removed: " + frontElement); // Output: 3
            System.out.println("Rear element removed: " + rearElement); // Output: 4
            System.out.println("Deque after removing elements: " + deque); // Output: [1, 2]

            // Accessing elements from the deque
            int firstElement = deque.peekFirst(); // Accessing element at the front
            int lastElement = deque.peekLast(); // Accessing element at the end
            System.out.println("First element: " + firstElement); // Output: 1
            System.out.println("Last element: " + lastElement); // Output: 2
            System.out.println("Final deque: " + deque); // Output: [1, 2]
        }
    }


