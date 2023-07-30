package SlidingWindow;

import java.util.HashMap;


/*
Brute Force Approach:
The brute force approach involves checking every possible substring of the given string and finding the longest substring with K unique characters. Here's the step-by-step process for the brute force approach:

Initialize a variable maxLength to store the length of the longest substring.
Iterate over every possible substring in the given string:
Start with the first character and consider all substrings starting from that character.
For each starting position, iterate through the string and keep track of the unique characters encountered.
If the number of unique characters equals K, update maxLength if the current substring length is greater than maxLength.
Return maxLength as the length of the longest substring with K unique characters.

The brute force approach has a time complexity of O(n^3) as it involves three nested loops.
It is not an efficient solution for large input sizes. The sliding window approach described earlier has a time complexity
of O(n) and is much more efficient.

Intuition for optimized approach:
To find the longest substring with K unique characters, we can use the sliding window technique.
We'll maintain a window of characters and keep expanding it until we have K unique characters in the window.
If the number of unique characters exceeds K, we'll contract the window from the left side until we have K unique characters
again. We'll track the maximum length of the window as we iterate through the string.


 */
public class LongestSubstringWithoutRepeatingCharacters {

        public int longestSubstringWithKUniqueChars(String str, int k) {
            int start = 0; // Start pointer
            int end = 0; // End pointer
            HashMap<Character, Integer> charFreqMap = new HashMap<>(); // HashMap to track character frequencies
            int maxLength = -1; // Maximum length of substring with K unique characters

            while (end < str.length()) {
                char currentChar = str.charAt(end);
                charFreqMap.put(currentChar, charFreqMap.getOrDefault(currentChar, 0) + 1);

                while (charFreqMap.size() > k) {
                    char leftChar = str.charAt(start);
                    charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
                    if (charFreqMap.get(leftChar) == 0) {
                        charFreqMap.remove(leftChar);
                    }
                    start++;
                }

                if (charFreqMap.size() == k) {
                    maxLength = Math.max(maxLength, end - start + 1);
                }

                end++;
            }
            return maxLength;
        }


}
