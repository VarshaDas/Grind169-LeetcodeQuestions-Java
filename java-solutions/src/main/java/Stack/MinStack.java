package Stack;

import java.util.Stack;

/**
 * The MinStack class implements a stack data structure that supports push, pop, top, and getMin operations.
 * It keeps track of the minimum value in the stack at any given time.

 * The approach is to use two stacks: one stack (mainStack) to store the actual elements,
 * and another stack (minStack) to keep track of the minimum element at the top of the stack.

 * When pushing a new element, it is added to the mainStack.
 * If the minStack is empty or the new element is less than or equal to the current minimum (peek of minStack),
 * then the new element is also added to the minStack, as it becomes the new minimum.

 * When popping an element, it is removed from the mainStack.
 * If the popped element is equal to the current minimum (peek of minStack), then the minimum element is also removed from the minStack.

 * The top operation simply returns the element at the top of the mainStack.

 * The getMin operation returns the element at the top of the minStack, which represents the minimum element in the stack.

 * The time complexity of all operations (push, pop, top, getMin) is O(1) because the stack operations have constant time complexity.
 * The space complexity is O(n), where n is the number of elements in the stack, as we are using an additional minStack to keep track of the minimum element.
 *
 * Leetcode link: https://leetcode.com/problems/min-stack/description/
 */
public class MinStack {

    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    /**
     * Initializes an empty MinStack.
     */
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * Pushes the given value onto the stack.
     *
     * @param val The value to be pushed.
     */
    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    /**
     * Removes the top element from the stack.
     */
    public void pop() {
        int val = mainStack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return The top element of the stack.
     */
    public int top() {
        return mainStack.peek();
    }

    /**
     * Returns the minimum element in the stack.
     *
     * @return The minimum element in the stack.
     */
    public int getMin() {
        return minStack.peek();
    }

    /**
     * Main method to test the MinStack implementation.
     */
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(2);
        stack.push(7);
        stack.push(1);

        System.out.println("Top element: " + stack.top());  // Output: 1
        System.out.println("Minimum element: " + stack.getMin());  // Output: 1

        stack.pop();
        System.out.println("Top element after pop: " + stack.top());  // Output: 7
        System.out.println("Minimum element after pop: " + stack.getMin());  // Output: 2
    }
}
