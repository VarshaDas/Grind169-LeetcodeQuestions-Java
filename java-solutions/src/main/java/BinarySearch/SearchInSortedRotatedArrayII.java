package BinarySearch;

/*
 * 
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 *  Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
 * 
 * Approach:
 * 
 * Brute Force Approach:
 * Start iterating through the array from index 0 to n-1. If the current element is equal to the target, return True. If the loop completes without finding the target, return False.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Optimal Approach:
 * 
 * Instead of comparing the middle element with the left and right elements, you can handle the cases where the middle element is equal to the left or right elements. 
 * If the middle element is equal to the left element, increment the left pointer. 
 * Similarly, if the middle element is equal to the right element, decrement the right pointer. 
 * This helps in handling duplicate elements and ensures that the search is continued towards the unsorted part of the array.
 * 
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * 
 * Leetcode Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 * 
 */

public class SearchInSortedRotatedArrayII {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid]==target){
                return true;
            }

             if (nums[start] == nums[mid]) {
                start++;
                continue;
            }

            if(nums[start]<nums[mid]){
                if(nums[start] <= target && target < nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
            else{
                if(nums[mid]<target && target<= nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
     return false;
        
    }
    
}
