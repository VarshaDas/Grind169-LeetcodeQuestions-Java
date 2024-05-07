package Binary;

/*
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * Optimal Approach:
 * 
 * 1. Iterate  through each bit (32 bits for a 32-bit integer), extract each bit, and construct the reversed bit representation.
 * 2. Iterate 32 times (once for each bit in a 32-bit integer), and left-shift the reversed integer by 1 . 
 *    This shifts the existing reversed bits to the left to make space for the next bit.
 * 3. Extract the least significant bit of the input number using bitwise AND with 1 . This isolates the least significant bit of n. 
 * 4. Set the extracted bit in the reversed integer using bitwise OR. This adds the extracted bit to the reversed integer.
 * 
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * 
 * Practice Link: https://leetcode.com/problems/reverse-bits/description/
 * 
 */

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;
        int bitLength = 32;

        for (int i = 0; i < bitLength; i++) {
            // Shift 'reversed' to the left to make space for the next bit
            reversed <<= 1;
            // Extract the least significant bit of 'n' and add it to 'reversed'
            reversed |= (n & 1);
            // Right shift 'n' to process the next bit
            n >>>= 1;
        }

        return reversed;
    }
}
