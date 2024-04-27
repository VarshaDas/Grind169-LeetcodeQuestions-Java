package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 * For example, "ACGAATTCCG" is a DNA sequence.
 * 
 * When studying DNA, it is useful to identify repeated sequences within the DNA.
 * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
 * 
 * Brute Force Approach:
 * 1. Initialize two sets: seen to keep track of all substrings seen so far and repeated to store the repeated substrings.
 * 2. Iterate through each substring of length 10 in the input string s.
 * 3. For each substring, check if it is already in the seen set. If it is, add it to the repeated set. Otherwise, add it to the seen set.
 * 4. After processing all substrings, add all elements from the repeated set to the result list.
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 * 
 * Optimal Approach:
 * Now, to solve this problem in linear time, you can use the same sets: seen and repeated, and a HashMap map to store the frequency of each substring. 
 * 1. Iterate through each substring of length 10 in the input string and for each substring, increment its count in map or initialize it to 1 if it's not present.
 * 2. When you encounter the same substring again, increment its count in the HashMap  to 2.
 * 3. Now, check if the count becomes 2 because it indicates that the substring has been encountered more than once. This means that the substring is repeated. Therefore, add it to the result list.
 * 
 * Practice Link: https://leetcode.com/problems/repeated-dna-sequences/
 * 
 */

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        // Iterate through each substring of length 10
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);

            // Increment the count of the current substring in the map
            map.put(substring, map.getOrDefault(substring, 0) + 1);

            // If the count becomes 2, add the substring to the result list
            if (map.get(substring) == 2) {
                result.add(substring);
            }
        }
        return result;
    }
}
