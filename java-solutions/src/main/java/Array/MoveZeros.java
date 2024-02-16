package Array;

/*
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * 
 * Approach:
 * Brute Force Approach:
 * Iterate through the array and whenever a zero is encountered, shift all subsequent non-zero elements one position to the left to fill the gap.
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 * 
 * Optimal Approach :
 * Maintain two pointers, nonZeroPointer (keeps track of the position where the next non-zero element should be placed, and another pointer i (iterates through the array). 
 * Iterate through the array; move all non-zero elements to the front of the array while maintaining their original order using the two pointers.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Leetcode Link: https://leetcode.com/problems/move-zeroes/description/
 */

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int nonZeroPointer = 0;
        // Move all non-zero elements to the beginning of the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroPointer++] = nums[i];
            }
        }
        // Fill the remaining positions with zeros
        while (nonZeroPointer < nums.length) {
            nums[nonZeroPointer++] = 0;
        }
    }
    
}
