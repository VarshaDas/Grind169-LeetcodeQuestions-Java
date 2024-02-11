package Array;

/*
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * 
 * Approach:
 * Brute Force Approach:
 * Rotate the array to the right by one step k times, shifting each element one position to the right each time.
 * Time Complexity: O(n*k)
 * Space Complexity: O(1)
 * 
 * Optimal Approach:
 * First, reverse the entire array. Then, we reverse the first k elements, followed by reversing the remaining elements.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Leetcode Link: https://leetcode.com/problems/rotate-array/description/
 */

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // Handle cases where k is greater than the length of the array
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        } 
    }
    
}
