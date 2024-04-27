package SlidingWindow;

/*
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 * 
 * Brute Force Approach:
 * Iterate through every possible substring of length k in the given string, count the number of vowels in each substring, and find the maximum count.
 * 
 * Time Complexity: O((n - k + 1) * k)
 * Space Complexity: O(1)
 * 
 * Optimal Approach:
 * The optimized approach involves using a sliding window to iterate through the array and find the maximum number of vowels in any substring of length k.
 * 1. Iterate through the first window of size k, counting the number of vowels and updating currentVowels and maxVowels.
 * 2. Slide the window towards the right by one character at a time and update currentVowels accordingly.
 * 3. Update maxVowels to keep track of the maximum number of vowels encountered so far.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Practice Link: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
 * 
 */

public class MaxVowelsInSubarrayOfSizeK {
    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currentVowels = 0;
        String vowels = "aeiou";

        // Calculate vowels count in the first window of size k
        for (int i = 0; i < k; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                currentVowels++;
            }
        }
        maxVowels = currentVowels;

        // Slide the window and update maxVowels
        for (int i = k; i < s.length(); i++) {
            // Remove the leftmost character from the window
            if (vowels.indexOf(s.charAt(i - k)) != -1) {
                currentVowels--;
            }
            // Add the rightmost character to the window
            if (vowels.indexOf(s.charAt(i)) != -1) {
                currentVowels++;
            }
            // Update maxVowels
            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }
}
