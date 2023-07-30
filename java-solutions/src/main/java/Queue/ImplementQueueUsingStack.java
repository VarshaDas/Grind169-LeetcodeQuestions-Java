package Queue;

import java.util.Stack;

/*
The intuition behind implementing a queue using stacks is to utilize two stacks to simulate the behavior of a queue.
In a queue, elements are inserted from one end (rear) and removed from the other end (front).
However, in a stack, elements are inserted and removed from the same end.

To simulate a queue using stacks, we can use two stacks: an input stack and an output stack.
The input stack is used to enqueue elements, while the output stack is used to dequeue elements.

When we enqueue an element, we simply push it onto the input stack.
This operation takes O(1) time complexity.

When we dequeue an element, we first check if the output stack is empty.
If it is empty, we transfer all the elements from the input stack to the output stack
by popping from the input stack and pushing onto the output stack.
This step ensures that the elements in the output stack are in the correct order for dequeuing.
Then, we simply pop the top element from the output stack, which represents the front element of
the queue. This operation also takes O(1) time complexity.

By using this approach, we can achieve the FIFO (First-In-First-Out) behavior of a queue
using two stacks.
The time complexity of implementing a queue using stacks is as follows:

Enqueue operation: O(1)
Dequeue operation: O(1)
Peek operation: O(1)
The space complexity of implementing a queue using stacks is O(n),
where n is the number of elements stored in the queue.
This space is required to store the elements in the input and output stacks.
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
        while(outputStack.isEmpty()){
            transferElements();
        }

        return outputStack.pop();

    }

    public int peek() {
        while(outputStack.isEmpty()){
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
        ImplementQueueUsingStack queueUsingStack = new ImplementQueueUsingStack();
        queueUsingStack.push(10);
        queueUsingStack.push(5);
        queueUsingStack.push(6);
        queueUsingStack.push(7);
        queueUsingStack.push(8);
        queueUsingStack.pop();
        System.out.println(queueUsingStack.peek());
    }
}
