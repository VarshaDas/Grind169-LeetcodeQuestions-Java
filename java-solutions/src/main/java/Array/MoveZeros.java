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
 * Optimal Approach - Two pointers:
 * Maintain two pointers, left and right. Iterate through the array with the right pointer and whenever a non-zero element is encountered, swap it with the element at the left pointer and increment both pointers.
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
