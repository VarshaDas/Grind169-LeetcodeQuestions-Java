package SlidingWindow;
/*
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 * 
 * Brute Force Approach:
 * Iterate through all possible subarrays of the given array and calculate the sum of its elements. 
 * If the sum equals or exceeds the target, update the minimum length of the subarray encountered so far and finally, return it.
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 * 
 * Optimal Approach:
 * 1. Initialize a min variable to track the minimum length of the subarray and a sum variable to track the sum of the current subarray. 
 * 2. Iterate through the array using a sliding window. Start from the initial position(index 0) and expand towards the right by adding the current element to sum.
 * 3. If sum is greater than or equal to the target, calculate the length of the current subarray and update min accordingly.
 * 4. To make sure the window slides through the array, you will have to shrink the array in each iteration. To do so, subtract the current element from the sum and then move the left pointer forward. 
 * 5. When the loop terminates, the required minimum length of the subarray will be in min.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Practice Link: https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * 
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int i =0;
        int j =0;
        while(j < nums.length){
            sum = sum + nums[j];
            while(sum >= target){
                min = Math.min(min, j-i+1);
                sum = sum - nums[i];
                i++;
            }
            j++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;

    }
}
