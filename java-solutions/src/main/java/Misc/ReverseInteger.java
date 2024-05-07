package Misc;

/*
 * Given a signed 32-bit integer x, return x with its digits reversed. 
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * 
 * Brute Force Approach:
 * Convert the integer to a string, reverse the string, handle the sign, and convert it back to an integer.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Optimal Approach:
 * To optimize the approach, you can use integer arithmetic to reverse the digits of the number directly, without converting it to a string. 
 * Extract the last digit of the number and check for potential overflow before updating the reversed integer. 
 * If reversed is about to exceed the bounds of a 32-bit signed integer, return 0 to indicate overflow.
 * Update the reversed integer and remove the last digit in each iteration. 
 * The loop will continue until all digits of x have been processed.
 * 
 * Time Complexity: O(d)
 * Space Complexity: O(1)
 * 
 * Practice Link: https://leetcode.com/problems/reverse-integer/description/
 * 
 */

public class ReverseInteger {
    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10; // Get the last digit
            x /= 10; // Remove the last digit from x
            
            // Check for overflow before updating reversed
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // Return 0 in case of overflow
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // Return 0 in case of overflow
            }
            
            reversed = reversed * 10 + digit; // Append the current digit to reversed
        }
        return reversed;
    }
}
