package Misc;
/*
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * 
 * Brute Force Approach:
 * Convert the number to a string and then compare the characters from the start to end. 
 * If the characters match, it is a palindrome number.
 * 
 * Time Complexity: O(d), d is the number of digits in the number.
 * Space Complexity: O(d)
 * 
 * Optimal Approach:
 * Now, to optimize the solution, you can reverse this number and check whether it is equal to the original number.
 * If the reversed number is equal to the original number, that number is palindrome.
 * 
 * Time Complexity: O(log d), d is the number of digits in the number.
 * Space Complexity: O(1)
 * 
 * Practice Link: https://leetcode.com/problems/palindrome-number/
 * 
 */

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int n=x;
        int rev=0;
        while(n>0)
        {
            rev=(rev*10)+(n%10);
            n=n/10;
        }
        if(rev==x)
            return true;
        else
            return false;
    }
}
