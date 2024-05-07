package Binary;
/*
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * 
 * Brute Force Approach:
 * 
 * Sort the given array of numbers. Iterate through the sorted array to find the missing number by comparing each element with its expected value. 
 * The first number that doesn't match its expected value (i) is the missing number.
 * 
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 * 
 * Optimal Approach:
 * You can use XOR operation to find the missing number efficiently. Initialize missing as 0. XOR all numbers from 0 to n with all numbers in the array.
 * XOR operation between two same numbers results in 0, and between any number and 0 results in the number itself.
 * Due to the properties of XOR, the missing number will be left in missing after processing all numbers.
 * Then, perform another XOR operation on missing with each number in the array. 
 * The missing number will be left in missing after processing all numbers in the array.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Prcatice Link: https://leetcode.com/problems/missing-number/description/
 * 
 */

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int missing = 0;
        int n = nums.length;

        // XOR all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            missing ^= i;
        }

        // XOR all numbers in the array
        for (int num : nums) {
            missing ^= num;
        }

        return missing;
    }
}
