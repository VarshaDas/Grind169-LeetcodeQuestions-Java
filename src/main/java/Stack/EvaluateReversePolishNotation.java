package Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] input = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(input));

    }

    /**
     * Evaluates the given RPN expression and returns the result.
     *
     * @param tokens An array of tokens representing the RPN expression.
     * @return The result of evaluating the RPN expression.
     */

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    /**
     * Time Complexity: O(n)
     * The algorithm iterates through each token in the input array once, where n is the length of the array.
     * Each operation within the loop, such as stack push and pop, takes constant time.
     *
     * Space Complexity: O(n)
     * In the worst case, the stack can contain all the tokens from the input array.
     * Therefore, the space complexity is linear with respect to the input size.
     */
}

