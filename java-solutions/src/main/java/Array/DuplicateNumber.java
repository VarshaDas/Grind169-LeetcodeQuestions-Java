package Array;
/*
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * 
 * Brute Force Approach:
 * Use nested loops to compare each element with every other element in the array to check if that element is a repeated number.
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 * 
 * Optimal Approach:
 * To solve this in linear time, you can use Floyd's Tortoise and Hare Algorithm (Cycle Detection Algorithm). 
 * 1. Use two pointers, slow (tortoise) and fast (hare), initialized at the start of the array.
 * 2. Move slow by one step and fast by two steps within the array. 
 *    If there's a cycle in the array due to a duplicate number, the slow and fast pointers will meet at some point within the cycle.
 * 3. Reset one pointer to the start of the array and move both pointers at the same pace (one step at a time). 
 *    The point where they meet is the entry point of the cycle, which corresponds to the duplicate number.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Practice Link: https://leetcode.com/problems/find-the-duplicate-number/description/
 * 
 */

public class DuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entry point of cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // or fast (both will point to the duplicate number)
    }
}
