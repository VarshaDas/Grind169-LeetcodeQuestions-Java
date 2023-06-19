package String;

/*
The intuition behind finding the longest common prefix among a given array of strings is to
 compare each string character by character until a mismatch is found or the shortest string is exhausted.
  By iterating through the strings, we can gradually narrow down the common prefix.

Here's the intuition for the approach used in the code:

1. We start by assuming the first string in the array as the initial prefix.
2. For each subsequent string in the array, we compare it with the current prefix.
3. If the current prefix is not a prefix of the current string, we remove the last character from the prefix and repeat the comparison.
4. We continue this process until we find the longest common prefix or the prefix becomes empty.

The time complexity of the approach to find the longest common prefix among a given array of strings is O(n * m), where n is the number of strings in the array and m is the length of the shortest string. This is because we iterate through all the strings and compare each character until a mismatch is found or the shortest string is exhausted.

The space complexity of the approach is O(1) since we only use a constant amount of extra space to store the common prefix. We do not use any additional data structures that depend on the input size.

 */
public class LongestCommonPrefix {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) {
                        return "";
                    }
                }
            }
            return prefix;
        }
}