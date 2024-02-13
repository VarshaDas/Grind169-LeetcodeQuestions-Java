package Array;

import java.util.Arrays;

/*
 *
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * 
 * 
 * Approach:
 * 
 * Brute Force Approach:
 * The initial thought to solve this problem would be to use two nested loops to calculate the sum and compare it with target.
 * Time Complexity: O(n²)
 *  Space Complexity: O(1) 
 * 
 * Better Approach: HashMap
 * Use a hash map to store the indices of elements. For each element num, check if target - num exists in the hash map.
 * Time Complexity: O(n)
 * Space Complexity: O(n), for storing the hashmap.
 * 
 * Optimized Approach: Sorting and two pointers.
 * Sort the array in ascending order. Then, use two pointers (one at the start and one at the end) to traverse the sorted array and find a match to target.
 * Time Complexity: O(n log n)  [Sorting: O(n log n) + Two pointers: O(n) = O(n log n)].
 * Space Complexity: O(1)
 * 
 * Leetcode link: https://leetcode.com/problems/two-sum/description/
 * 
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

      Arrays.sort(nums);
      int l=0,r=nums.length-1;
      int index[]=new int[2];
      while(l<r)
      {
        if(nums[l]+nums[r]==target)
        {
          index[0]=l;
          index[1]=r;
          break;
        }
        else if(nums[l]+nums[r]<target)
          l++;
        else
          r--;
      }
      return index;
    }
    
}
