package BinarySearch;

/*
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:
 * [4,5,6,7,0,1,4] if it was rotated 4 times.
 * [0,1,4,4,5,6,7] if it was rotated 7 times.
 * 
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * 
 * Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
 * 
 * Approach:
 * To handle duplicates in the array while finding the minimum element in a rotated sorted array, you can make a slight adjustment to the binary search algorithm. 
 * When the value at the middle index is equal to the value at the high index, it indicates that the pivot point might lie in the right half of the array. 
 * In such cases, decrement the high index by one and continue with the binary search. 
 * This ensures that we explore both halves of the array even if there are duplicates.
 * 
 * Algorithm:
 * 1. Initialize two pointers, low and high, to the start and end indices of the array.
 * 2. While low is less than high:
 *      a. Check if the element at low is less than the element at high. If true, return the element at low as it's the minimum.
 *      b. Calculate the middle index mid.
 *      c. If nums[mid] is equal to nums[high], decrement high by 1 to handle duplicates.   
 *      d. If nums[mid] is greater than nums[high], move low to mid + 1.    
 *      e. Otherwise, move high to mid.
 * 3.Return nums[low] as the minimum element.
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * 
 * Leetcode Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 * 
 */

public class MinimumInSortedRotatedArrayII {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            if (nums[low] < nums[high]) {
                return nums[low];
            }

            int mid = low + (high - low) / 2;
            
            // Check if the pivot point lies in the right half
            if (nums[mid] == nums[high]) {
                high--;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
