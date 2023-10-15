package Stack;

import java.util.Stack;

/**

 Given two strings s and t, return true if they are equal when both are typed into empty text editors.
 '#' means a backspace character.

 Approach:

 To compare two strings after processing the backspaces, we can use a stack for each string.

 Iterate through each character in the first string, s:
 If the character is not '#', push it onto the stack.
 If the character is '#', check if the stack is not empty. If it is not empty, pop the top element from the stack.
 Repeat the above steps for the second string, t.
 After processing both strings, compare the contents of the two stacks. If they are equal, return true; otherwise, return false.
 Intuition:

 Using stacks allows us to simulate typing into an empty text editor. We process the backspaces by removing the last
 typed character from the stack if it exists. Finally, we compare the remaining characters in both stacks to determine
 if the strings are equal.

 Time Complexity: O(n), where n is the length of the longer string between s and t.

 We iterate through both strings once to process the backspaces and compare the stacks.
 Space Complexity: O(n), where n is the length of the longer string between s and t.

 We use two stacks to store the processed characters in each string.
 Example:

 Input: s = "ab#c", t = "ad#c"

 Output: true

 Explanation: After processing the backspaces, both strings become "ac", which are equal. */
public class BackSpaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch != '#') {
                stackS.push(ch);
            } else if (!stackS.isEmpty()) {
                stackS.pop();
            }
        }

        for (char ch : t.toCharArray()) {
            if (ch != '#') {
                stackT.push(ch);
            } else if (!stackT.isEmpty()) {
                stackT.pop();
            }
        }


        return stackS.equals(stackT);
    }
}
