package Binary;

/*
 * Write a function that takes the binary representation of a positive integer and returns the number of  set bits it has (also known as the Hamming weight).
 * 
 * Brute Force Approach:
 * Convert the number into binary and count the number of 1s using a loop.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Optimal Approach:
 * To optimize the approach, you might be thinking of using right shift, like we did for Counting Bits problem, but remember that in Java, there is no unsigned integer type. 
 * In Java, the compiler represents signed integers using two's complement. So, for negative numbers, MSB will be 1, and using right shift in this case might lead to incorrect answers.
 * Start a loop which will run until n is not zero. In each iteration, update n by performing a bitwise AND between n and n - 1. 
 * This sets the least significant '1' bit to 0. Keep incrementing the count by 1.
 * 
 * Time Complexity: O(no. of set bits)
 * Space Complexity: O(1)
 * 
 * Practice Link: https://leetcode.com/problems/number-of-1-bits/description/
 * 
 */

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1); // Clear the lowest set bit
        }
        return count;
    }
}
