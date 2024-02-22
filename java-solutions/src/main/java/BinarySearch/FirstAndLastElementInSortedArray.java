package BinarySearch;
/*
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * 
 * Approach:
 * 
 * Brute Force Approach:
 * Linearly search through the entire array to find the target, then expand this search to find the first and last occurrence of target.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Optimal Approach - Binary Search:
 * To achieve a time complexity of O(log n), you can use binary search twice(for starting and ending position). 
 * Once target is found, continue binary searching towards the left to find the first occurrence of target. 
 * Similarly, perform another binary search to find the ending position of the target element by searching towards the right.
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * 
 * Leetcode Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 * 
 */

public class FirstAndLastElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        while(low <= high)
        {
            int mid = low+ (high-low)/2;
            if(nums[mid] == target)
            {
                ans[0]=mid;
                high = mid - 1;
            }
            else if(nums[mid]<target) {
                low = mid+1;
            }
            else {
                high = mid - 1;
            }
        }
        if(ans[0] == -1)
        {
            return ans;
        }
        
        low = 0;
        high = nums.length -1;
        while(low <= high)
        {
            int mid = low+ (high-low)/2;
            if(nums[mid] == target)
            {
                ans[1]=mid;
                low = mid + 1;
            }
            else if(nums[mid]<target) {
                low = mid+1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
        
    }
    
}
