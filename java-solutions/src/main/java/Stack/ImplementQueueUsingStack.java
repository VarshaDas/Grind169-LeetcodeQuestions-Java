package Stack;

import java.util.Stack;

/*

**Approach:**
The queue is implemented using two stacks: `inputStack` and `outputStack`.
The `inputStack` is used for enqueuing elements, while the `outputStack` is used for
dequeuing and peeking elements.

When an element needs to be dequeued or peeked, and if the `outputStack` is empty,
the elements are transferred from the `inputStack` to the `outputStack` in reverse order.
This ensures that the first enqueued element becomes the first dequeued element, implementing the FIFO (First-In-First-Out) behavior of a queue.


**Time Complexity:**
The time complexity for enqueueing an element is O(1) as it involves pushing the element onto the `inputStack`.
The time complexity for dequeuing and peeking an element is amortized O(1) because if the `outputStack` is empty,
we transfer elements from the `inputStack` to the `outputStack`, which takes O(n) time where n is the number of elements
in the queue. However, on average, each element is transferred only once, resulting in an amortized O(1) time complexity.

**Space Complexity:**
The space complexity is O(n), where n is the number of elements in the queue. Both the `inputStack` and `outputStack`
can potentially hold all the elements in the queue.

 */
public class ImplementQueueUsingStack {

    Stack<Integer> inputStack;
    Stack<Integer> outputStack;


    public ImplementQueueUsingStack() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        while (outputStack.isEmpty()) {
            transferElements();
        }

        return outputStack.pop();

    }

    public int peek() {
        while (outputStack.isEmpty()) {
            transferElements();
        }

        return outputStack.peek();
    }

    public boolean empty() {
        return outputStack.isEmpty() && inputStack.isEmpty();
    }

    private void transferElements() {
        while (!inputStack.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
    }

    public static void main(String[] args) {
        ImplementQueueUsingStack queue = new ImplementQueueUsingStack();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop()); // Output: 1
        System.out.println(queue.peek());    // Output: 2
        queue.push(4);
        System.out.println(queue.pop()); // Output: 2
        System.out.println(queue.empty());   // Output: false

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

