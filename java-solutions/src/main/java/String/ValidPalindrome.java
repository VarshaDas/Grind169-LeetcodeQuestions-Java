package String;

/*
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * Brute Force Approach:
 * Store the reverse of the string in a new string. Compare both of them to check whether they are equal.
 * Time Complexity: O(n)
 * Space Complexity: O(n), for storing the reversed string
 * 
 * Optimal Approach - Two Pointers:
 * Use two pointers(start and end) to compare characters from the beginning and end of the string, skipping non-alphanumeric characters and ignoring case differences.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Leetcode Link: https://leetcode.com/problems/valid-palindrome/description/
 * 
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
}
