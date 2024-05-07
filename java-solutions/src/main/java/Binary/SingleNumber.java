package Binary;

/*
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * 
 * Brute Force Approach:
 * Use two nested loops where the outer loop iterates over each element num in the array, and the inner loop checks if num appears elsewhere in the array. 
 * For each num, count its occurrences in the array. If the count is 1, then num is the unique number.
 * 
 * Time Complexity: O(n² )
 * Space Complexity: O(1)
 * 
 * Optimal Approach:
 * You can optimize the approach by using bitwise XOR operation.
 * XOR operation between two same numbers results in 0, and between any number and 0 results in the number itself.
 * Iterate through the array and perform XOR of all elements. XORing all elements will cancel out the pairs (since 𝑎⊕𝑎=0a⊕a=0) and leave the unique number.
 * 
 * Time Complexity: O(1)
 * Space Complexity: O(n)
 * 
 * Practice Link: https://leetcode.com/problems/single-number/description/
 * 
 */

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; //Perform XOR operation
        }
        return result;
    }
}
