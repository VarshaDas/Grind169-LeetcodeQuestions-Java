package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
 * You are given a string s and an integer k.
 * You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 * 
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 * 
 * Brute Force Approach:
 * The brute force approach for this problem involves the following steps:
 * 1. Initialize a variable maxLength to store the length of the longest substring with repeating characters after replacement.
 * 2. Iterate over every possible substring in the given string:
 *      a. Start with the first character and consider all substrings starting from that character.
 *      b. For each starting position, iterate through the string and try replacing characters to make them all the same.
 *      c. After replacing characters, calculate the length of the substring and update maxLength if the current substring length is greater than maxLength.
 * 3. Return maxLength as the length of the longest substring with repeating characters after replacement.
 * 
 * Time Complexity: O(n³)
 * Space Complexity: O(1)
 * 
 * Optimal Approach:
 * Now to solve this in linear time, you can use sliding window approach. 
 * You will need a variable maxRepeatCount to keep track of the maximum count of the repeating character and a HashMap to store the frequency of characters in the current window.
 * 1. Expand the map towards the right and keep updating the count of the newly added character in the HashMap and update maxRepeatCount with the maximum count of any repeating character encountered so far.
 * 2. Calculate the count of non-repeating characters in the current window. 
 * 3. If the count exceeds k, it means you have to perform replacements to make all characters in the window the same. 
 * 4. In this case, shrink the window towards left and decrement the count of leftmost character until the count of non-repeating characters becomes less than or equal to k.
 * 5. After adjusting the window, update maxLength with the maximum length of the current substring.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Practice Link: https://leetcode.com/problems/longest-repeating-character-replacement/description/
 * 
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxLength = 0;
        int maxRepeatCount = 0;
        int len = s.length();
        Map<Character,Integer> map1 = new HashMap<>();

        for(int right = 0;right<len;right++){
            char curr = s.charAt(right);
            map1.put(curr, map1.getOrDefault(curr, 0)+1);

            maxRepeatCount = Math.max(maxRepeatCount, map1.get(curr));
            int leastRepeat = (right - left + 1 ) - maxRepeatCount;

            if(leastRepeat > k){
                map1.put(s.charAt(left), map1.get(s.charAt(left)) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);

        }
        return maxLength;
    }
}
