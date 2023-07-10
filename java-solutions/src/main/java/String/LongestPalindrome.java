package String;

import java.util.HashMap;
import java.util.Map;

/**

 Given a string, find the length of the longest palindrome that can be formed using the characters of the string.

 Approach/Intuition:

 The approach to find the longest palindrome is to count the occurrences of each character in the string.

 For each character, if its count is even, it can be included in the palindrome as it can form pairs.

 If the count is odd, we can include all but one occurrence of that character in the palindrome, as it can be placed in the middle.

 By considering these rules, we can calculate the length of the longest palindrome.

 Time Complexity: O(n), where n is the length of the input string. We iterate through the string once to count the occurrences.

 The space complexity of the updated code is O(n), where n is the length of the input string.

**/
 public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        // Count the occurrences of each character
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int palindromeLength = 0;
        boolean hasOddCount = false;

        // Calculate the length of the longest palindrome
        for (int count : charCount.values()) {
            if (count % 2 == 0) {
                palindromeLength += count;
            } else {
                palindromeLength += count - 1;
                hasOddCount = true;
            }
        }

        // Include one character with odd count in the middle if applicable
        if (hasOddCount) {
            palindromeLength++;
        }

        return palindromeLength;
    }

}
