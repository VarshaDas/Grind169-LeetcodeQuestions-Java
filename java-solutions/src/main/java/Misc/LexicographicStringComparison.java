package Misc;

import java.util.Arrays;

/*
Given a string, write a function to find the lexicographically smallest and largest substring of length k.

Example input/output:

Input: "hello world", k = 3 Output: Smallest: wor", Largest-"rld"
Input: "abcd", k = 2 Output: Smallest - "ab", Largest - "cd"

Brute force approach: One approach to solving this problem is to iterate through all possible substrings of length k,
compare them lexicographically, and return the smallest and largest ones.

Time complexity: O(n), where n is the length of the input string.
We iterate through the input string once and compare each k-length substring to the current smallest
and largest substrings.

Space complexity: O(1), as we only store the smallest and largest substrings and a temporary substring
during iteration.

 */
public class LexicographicStringComparison {
    public static String[] findSmallestLargestSubstring(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);
        for (int i = 1; i <= s.length() - k; i++) {
            String substring = s.substring(i, i + k);
            if (substring.compareTo(smallest) < 0) {
                smallest = substring;
            }
            if (substring.compareTo(largest) > 0) {
                largest = substring;
            }
        }
        return new String[] {smallest, largest};
    }

    public static void main(String[] args) {
        String[] out = findSmallestLargestSubstring("varsha", 3);
        System.out.println(Arrays.toString(out));
    }
}

