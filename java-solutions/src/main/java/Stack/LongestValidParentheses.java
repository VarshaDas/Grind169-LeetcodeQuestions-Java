package Stack;

import java.util.Stack;

public class LongestValidParentheses {


        public static int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1); // Initialize the stack with a dummy index

            int maxLen = 0;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }

            return maxLen;
        }

        public static void main(String[] args) {
            String input1 = "()";
            String input2 = ")()())";

            System.out.println("Longest valid parentheses for " + input1 + ": " + longestValidParentheses(input1)); // Output: 2
            System.out.println("Longest valid parentheses for " + input2 + ": " + longestValidParentheses(input2)); // Output: 4
        }
    }


