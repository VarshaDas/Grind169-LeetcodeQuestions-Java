package Array;

import java.util.Arrays;

/*
 * 
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * 
 * Approach:
 * Brute Force Approach:
 * The simplest approach to solve this would seem to use three nested loops and calcuate the sum of all possible triplets in the array. Compare the absolute differences between the sums and the target to find the closest one.
 * Time Complexity: O(n³)
 * Space Complexity: O(1)
 * 
 * Optimal Approach: Sorting and Two Pointers
 * An optimized approach involves sorting the array first. Then, using a combination of two pointers and a loop, you can iterate through the array to find the closest sum to the target.
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 * 
 * Leetcode Link: https://leetcode.com/problems/3sum-closest/
 * 
 */

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }

        return closestSum;
        
    }
    
}
