package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        // Create a map to store the character frequency of the target string
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        // Initialize variables for the sliding window
        int start = 0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        int count = t.length();

        // Iterate over the string using two pointers
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);

            // Decrement the count of the character in the target map
            if (targetMap.containsKey(ch)) {
                int freq = targetMap.get(ch);
                if (freq > 0) {
                    count--;
                }
                targetMap.put(ch, freq - 1);
            }

            // If all characters in the target string are found
            while (count == 0) {
                // Update the minimum window length and start position
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    minStart = start;
                }

                // Increment the count of the character at the start of the window
                char startCh = s.charAt(start);
                if (targetMap.containsKey(startCh)) {
                    int freq = targetMap.get(startCh);
                    if (freq == 0) {
                        count++;
                    }
                    targetMap.put(startCh, freq + 1);
                }

                // Move the start pointer to the right
                start++;
            }
        }

        // If no minimum window found, return an empty string
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        // Return the minimum window substring
        return s.substring(minStart, minStart + minLength);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
       String len =  minimumWindowSubstring.minWindow("ADOBECODEBANC","ABC");
        System.out.println(len);
    }

}
