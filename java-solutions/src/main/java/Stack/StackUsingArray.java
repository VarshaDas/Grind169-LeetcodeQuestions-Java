package Stack;

public class StackUsingArray {
    /**
     * Stack implementation using an array.
     */

        private int[] stack;
        private int top;
        private int capacity;

        /**
         * Constructs an empty stack with the specified capacity.
         *
         * @param capacity the maximum capacity of the stack
         */
        public StackUsingArray(int capacity) {
            this.capacity = capacity;
            stack = new int[capacity];
            top = -1;
        }

        /**
         * Adds an element to the top of the stack.
         *
         * @param element the element to be added
         * @throws IllegalStateException if the stack is full
         */
        public void push(int element) {
            if (isFull()) {
                throw new IllegalStateException("Stack is full. Cannot push element.");
            }
            top++;
            stack[top] = element;
        }

        private boolean isFull() {
            return top == capacity;
        }

        public int pop(){
            if(isStackEmpty()){
                throw new IllegalStateException("Stack is empty. Cannot pop element.");
            }
            int element = stack[top];
            top--;
            return element;
        }

        private boolean isStackEmpty() {
            return top == -1;
        }

        private int peek(){
            return stack[top];
        }


    public static void main(String[] args) {
        StackUsingArray arrayStack = new StackUsingArray(5);
        arrayStack.push(5);
        arrayStack.push(12);
        arrayStack.push(9);
        arrayStack.push(2);
        int popped= arrayStack.pop();
        System.out.println(popped);
        System.out.println(arrayStack.peek());
        arrayStack.push(7);
        System.out.println(arrayStack.peek());


    }
}

