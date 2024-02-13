package Array;

/**
 * 
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * 
 * Brute Force Approach:
 * The initial thought to solve this problem would be to use two nested loops to calculate the sum and compare it with target.
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 * 
 * Optimal Approach: Two pointers
 * Since the array is already sorted, you can use two pointers, one starting from the beginning and the other from the end, to find the pair with the target sum.
 * Time Complexity: O(n), as we are traversing the array only once.
 * Space Complexity: O(1)
 * 
 * 
 * Leetcode link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 */

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (numbers[left] + numbers[right] != target) {
		if (numbers[left] + numbers[right] < target) 
            left++;
		else 
            right--;
	    }
        return new int[] {left+1, right+1};
    }
    
}
