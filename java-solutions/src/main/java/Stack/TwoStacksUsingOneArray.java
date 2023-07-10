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
            arr[++top1] = num;
        }

    }

    // Push in stack 2.
    public void push2(int num) {
        // Write your code here
        if (top1 < top2 - 1) {
            arr[--top2] = num;
        }

    }

    // Pop from stack 1 and return popped element.
    public int pop1() {
        // Write your code here
        if(top1 == -1){
            return -1;
        }
        return arr[top1--];

    }

    // Pop from stack 2 and return popped element.
    public int pop2() {
        // Write your code here
        if(top2 == maxsize) {
            return -1;
        }
        return arr[top2--];

    }

    public void display(){
        for(int i = 0;i<maxsize;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        TwoStacksUsingOneArray twoStacks = new TwoStacksUsingOneArray(5);
        twoStacks.push1(1);
        twoStacks.push2(2);
        twoStacks.push1(3);
        twoStacks.push2(4);
        twoStacks.push1(5);
        twoStacks.display();


        System.out.println("Popped element from Stack 1: " + twoStacks.pop1());  // Output: 5
        System.out.println("Popped element from Stack 2: " + twoStacks.pop2());  // Output: 4

    }

}
