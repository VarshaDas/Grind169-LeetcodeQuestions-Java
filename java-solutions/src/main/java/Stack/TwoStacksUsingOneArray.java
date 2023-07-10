package Stack;

public class TwoStacksUsingOneArray {
    int[] arr;
    int top1;
    int top2;

    int maxsize;

    // Initialize TwoStack.
    public TwoStacksUsingOneArray(int s) {
        this.maxsize = s;
        arr = new int[s];
        top1 = -1;
        top2 = maxsize;

    }

    // Push in stack 1.
    public void push1(int num) {
        // Write your code here
        if (top1 < top2 - 1) {
            arr[top1++] = num;
        }

    }

    // Push in stack 2.
    public void push2(int num) {
        // Write your code here

    }

    // Pop from stack 1 and return popped element.
    public int pop1() {
        // Write your code here

    }

    // Pop from stack 2 and return popped element.
    public int pop2() {
        // Write your code here

    }

}
