package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest palindrome that can be formed using the characters of the string.
 * 
 * Approach:
 * 
 * Brute force approach:
 * The simplest approach to solve this problem can be to try all possible combinations of characters to check if they can form a palindrome,
 * and find the length of the longest palindrome. 
 * The algorithm is as follows:
 * 1. Iterate over all possible substrings using two nested loops.
 * 2. Check each substring for palindrome property using the helper function.
 * 3. Keep track of the maximum length encountered.
 * 4. Return the maximum length.
 * 
 * This approach has a time complexity of O(n^3). Hence, this is not a preferrable way to solve this problem. 
 * 
 * Optimal Solution:
 * The optimal approach to find the longest palindrome is to count the occurrences of each character in the string and use them to calculate the length of the longest palindrome.
 * For each character: 
 *     If its count is even, it can be included in the palindrome as it can form pairs.
 *     If the count is odd, we can include all but one occurrence of that character in the palindrome, as it can be placed in the middle.
 *     Palindromes can have characters in pairs (even count) and at most one character with an odd count.
 * By considering these rules, we can calculate the length of the longest palindrome.
 * 
 * The algorithm is as follows:
 * 1. Initialize a HashMap 'charCount' to count the frequency of each character in the input string.
 * 2. Iterate through the character counts to calculate the length of the longest palindrome.
 * 3. Return the maximum length of the palindrome. 
 * 
 * Time Complexity: O(n), where n is the length of the input string. We iterate through the string once to count the occurrences.
 * 
 * Space Complexity: O(n), where n is the length of the input string, as we are using a HashMap of size n to store the frequency of each character. 
 * 
 * Leetcode Link: https://leetcode.com/problems/longest-palindrome/
 * 
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
