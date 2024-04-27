package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string you need to print the size of the longest possible substring that has exactly K unique characters. 
 * If there is no possible substring then print -1.
 * 
 * Brute Force Approach:
 * The brute force approach to find the longest substring with exactly K unique characters involves iterating through every possible substring of the given string and checking if it contains exactly K unique characters.
 * 
 * Time Complexity: O(n³)
 * Space Complexity: O(1)
 * 
 * Optimal Approach:
 * To find the length of the longest substring with K unique characters, you will need a HashMap to track the frequency of each element in the substring. 
 * This will allow to determine if a substring contains exactly K unique characters. 
 * You will also have to maintain a max variable to store the length of the longest substring found so far.
 * 
 * 1. Now, to apply sliding window, you need to initially start from the first position and expand the window towards the right. 
 * 2. Each time you find a new character, add it to the Map, and if it is already present, increment its frequency.
 * 3. In each iteration, if the number of unique characters in the current window exceeds K, shrink the window from left. 
 * 4. Decrease the count of the leftmost character in the map. 
 * 5. If the count of this character becomes 0 after decrementing, remove it from the map.
 * 6. After adjusting the window to contain exactly k unique characters, calculate the length of the current window and update max with the maximum length encountered so far. 
 * 7. After iterating through the entire string, you will get the required result in max.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Practice Link: https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
 * 
 */

public class LongestSubstringWithKUniqueCharacters {
    public int longestkSubstr(String s, int k) {
        int i = 0;
        int j = 0;
        
        Map<Character, Integer> charCounts = new HashMap<>();
        int max = -1;

        while(j<s.length())
        {
            charCounts.put(s.charAt(j), charCounts.getOrDefault(s.charAt(j),0)+1);
            while(charCounts.size() > k)
            {
                charCounts.put(s.charAt(i), charCounts.getOrDefault(s.charAt(i),0)-1);
            
                if(charCounts.get(s.charAt(i)) == 0){
                    charCounts.remove(s.charAt(i));
                }
                i++;
            }
            if(charCounts.size() == k)
            {
                max = Math.max(max, j-i+1);
            }
            j++;
        }
        return max;
    }
}
