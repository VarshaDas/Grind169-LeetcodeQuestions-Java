package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
You are given a string s and an integer k.
You can choose any character of the string and change it to any other uppercase English character.
 You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing
the above operations.

The intuition behind this approach is to maintain two counts: the count of the character that repeats
the most and the count of characters that do not repeat. By finding the count of non-repeating characters
 and replacing them (at most K times), we can obtain the longest substring with the most repeating
 characters.
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
