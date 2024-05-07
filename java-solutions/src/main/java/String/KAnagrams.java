package String;

/*
 * Given two strings of lowercase alphabets and a value K, your task is to complete the given function which tells if  two strings are K-anagrams of each other or not.
 * 
 * Brute Force Approach:
 * Generate all possible permutations of the first string s1, and then checking each permutation against s2 to see if it can become an anagram by changing at most k characters.
 * 
 * Time Complexity: O(n * n!)
 * Space Complexity: O(1)
 * 
 * Optimal Approach:
 * Now, to optimize this approach, you can use a HashMap to track character frequencies in both strings s1 and s2. First, check if the lengths of s1 and s2 are equal; if not, they are not K-anagrams.
 * Then, iterate through s1 to populate the hashmap with character frequencies.
 * Now, iterate through s2 and for each character, if it exists in the map and its frequency is greater than 0, decrement its frequency in the map; else, that character is considered as a necessary change. 
 * Finally, check if the total necessary changes is less than or equal to k; if yes, they are "k-anagrams".
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Practice Link: https://www.geeksforgeeks.org/problems/check-if-two-strings-are-k-anagrams-or-not/1
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class KAnagrams {
    boolean areKAnagrams(String s1, String s2, int k) {
        if (s1.length() != s2.length()) {
            return false;
        }
    
        Map<Character, Integer> map1 = new HashMap<>();
    
        // Populate map1 with character frequencies from s1
        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
    
        // Calculate necessary changes needed to transform s1 into s2
        int changesNeeded = 0;
    
        for (char c : s2.toCharArray()) {
            if (map1.containsKey(c) && map1.get(c) > 0) {
                map1.put(c, map1.get(c) - 1); // Decrement frequency in map1
            } else {
                changesNeeded++;
            }
        }
    
        // Check if total necessary changes are <= k
        return changesNeeded <= k;
    }
}
