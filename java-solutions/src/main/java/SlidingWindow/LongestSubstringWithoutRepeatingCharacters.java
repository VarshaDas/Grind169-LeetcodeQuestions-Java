package SlidingWindow;

import java.util.HashSet;
import java.util.Set;


/*
Brute Force Approach:
Iterate through all possible starting and ending indices to generate substrings. 
For each substring, check if all characters are unique. Keep track of the maximum length found for substrings with unique characters.
Time Complexity: O(n³)
Space Complexity: O(1)


Optimal Approach:
Now, to solve this problem in linear time, you can use sliding window algorithm and a set to keep track of characters in the current window.
1. Consider two pointers:
    i : Starting index of the window.
    j : Ending index of the window.
Therefore, the current substring will be the string inside the window, that is, the string from i to j-1.
2. Initialize max to store the length of the longest substring.
3. Use a set to store the characters of the substring, as you require unique characters.
        There can be two conditions:
        i ) If charAt(j) is not present in the set, append it to the set. Update the max variable. Increment the position of j. 
        ii ) If charAt(j) is present in the set, remove charAt(i) from the set. Increment the value of i.
4. Return max

Time Complexity: O(n)
Space Complexity: O(n)

Practice Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> setOfUniqueCharacters = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = 0;
        int len = s.length();

        while(j < len){
            if(!setOfUniqueCharacters.contains(s.charAt(j))){
                setOfUniqueCharacters.add(s.charAt(j));
                j++;
            } else {
                setOfUniqueCharacters.remove(s.charAt(i));
                i++;
            }
            max= Math.max(max, setOfUniqueCharacters.size());
        }
        return max;
    }
}

