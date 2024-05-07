package Binary;

/*
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * 
 * Brute Force Approach:
 * Iterate through each number from 0 to n and counting the number of 1's in its binary representation using 
 * built-in function Integer.bitCount(i) which returns the number of 1's in the two's complement binary representation of i.
 * 
 * Time Complexity: O(n*w), where w is the number of bits required to represent the largest number in the range.
 * Space Complexity: O(n)
 * 
 * Optimal Approach:
 * You can optimize this approach by calculating the number of bits of a number 'i' based on the previous number's calculated value. 
 * Initialize an array of size n+1 to store the count of '1' bits for each number and set the first value to 0, as 0 has 0 '1' bits.
 * Iterate through the numbers from 1 to n, and for each number, you can calculate the number of '1' bits by: bits[i] = bits[i >> 1] + (i & 1).
 *      1. bits[i >> 1]retrieves the count of '1' bits for the number obtained by shifting i to the right by one bit (i / 2).
 *      2. (i & 1) adds 1 to the count if i is odd ( as odd numbers have 1 in their least significant bit).
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Practice Link: https://leetcode.com/problems/counting-bits/description/
 * 
 */

public class CountingBits {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        bits[0] = 0;
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
