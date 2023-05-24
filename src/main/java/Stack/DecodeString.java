package Stack;

import java.util.Stack;

/**
 * /**
 *
 * The DecodeString class provides a method to decode a given string using a specific pattern.
 * The input string is encoded with a repeating pattern, where a substring is enclosed within square brackets along with a number indicating the repeat count.
 * The goal is to decode the string by expanding the repeating pattern based on the provided repeat counts.
 * The intuition behind the problem is to use two stacks: one for storing the repeat counts (countStack) and another for storing the partial decoded strings (stringStack).
 * We iterate through the characters of the input string and perform the following actions based on the character type:
 * If the character is a digit, we update the repeat count by multiplying the previous count by 10 and adding the current digit. This allows us to handle multi-digit repeat counts.
 * If the character is an opening bracket '[' (indicating the start of a repeating substring), we push the current repeat count (count) to the countStack and the current partial decoded string (curr) to the stringStack.
 * We then reset the repeat count to 0 and the current partial decoded string to an empty string, as we start a new repetition.
 * If the character is a closing bracket ']' (indicating the end of a repeating substring), we pop the previous partial decoded string (popped from the stringStack) and repeat count (popped from the countStack).
 * We append the current partial decoded string (curr) to the popped partial decoded string repeat times, where repeat is the value of the popped repeat count.
 * This step represents the expansion of the repeating pattern. We update the current partial decoded string (curr) with the newly decoded string.
 * If the character is neither a digit, opening bracket '[', nor closing bracket ']', it is a regular character. We simply append it to the current partial decoded string (curr).
 * After processing all characters in the input string, the final decoded string is stored in curr. We return curr as the result.
 * By leveraging the stack data structure, we can handle nested repetitions efficiently. The repeat counts and partial decoded strings are pushed and popped from the stacks accordingly,
 * allowing us to maintain the correct state during the decoding process.
 *
 * Leetcode link: https://leetcode.com/problems/decode-string/
 */
public class DecodeString {
    public static void main(String[] args) {
        String input = "3[a]2[bc]";
        System.out.println(decodeString(input));
    }

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int count = 0;
        String curr = "";
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(count);
                stringStack.push(curr);
                count = 0;
                curr = "";
            } else if (c == ']') {
                StringBuilder decodedString = new StringBuilder(stringStack.pop());
                int repeat = countStack.pop();
                for (int i = 1; i <= repeat; i++) {
                    decodedString.append(curr);
                }
                curr = decodedString.toString();
            } else {
                curr += c;
            }
        }
        return curr;
    }
    /*
    The time complexity of the given algorithm is O(n), where n is the length of the input string.
    This is because we iterate through each character of the string once.

    The space complexity of the algorithm is O(n) as well.
    This is because in the worst case scenario, all characters of the input string can be part of the decoded string
     */
}
