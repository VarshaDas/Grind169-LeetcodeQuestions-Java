package BinarySearch;

/* 
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * 
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 * 
 * Approach:
 * 
 * Brute Force Approach:
 * Iterate through the array; keep track of the minimum element found so far. If the current element is less than the minimum element, update the minimum element. After iterating through the entire array, return the minimum element found.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Optimal Approach:
 * The intuition behind this approach is to use binary search to efficiently find the pivot point or the smallest element in the rotated sorted array.
 * By comparing elements at the start (low) and end (high) of the search range, we determine whether the subarray is sorted or not and adjust the search range accordingly.
 * This approach reduces the time complexity to logarithmic O(log N) in finding the minimum element.
 * 
 * We handle the edge case where the input array nums has only one element.
 * In this case, the minimum element is the only element in the array, so we return nums[0].
 *
 * 1. We initialize two pointers, low and high, which represent the start and end indices of the search range in the array.
 * 2. Inside the while loop, we perform binary search iterations until the low and high pointers meet (low < high).
 * 3. We check if nums[low] < nums[high].
 *    a. If this condition is true, it means that the subarray between low and high is already sorted in ascending order.
 *    b. Therefore, the minimum element must be nums[low], and we break out of the loop.
 * 4. If the subarray is not sorted, we calculate the middle index mid as the average of low and high.
 * 5. We compare nums[mid] with nums[high] to determine which half of the array might contain the minimum element.
 * 6. If nums[mid] > nums[high], it means the pivot point (the point where the rotation occurs) lies between mid and high. 
 *    a. Hence, the minimum element cannot be present before mid. We update low = mid + 1 to search in the right half of the array.
 * 7. If nums[mid] <= nums[high], it means the pivot point lies before mid or at mid itself.
 *    a. In this case, the minimum element can be at or before mid. We update high = mid to search in the left half of the array.
 * 8. We repeat steps 4-8 until the low and high pointers meet.
 * 
 * Finally, when the search range is narrowed down to a single element (low = high), we have found the minimum element. We return nums[low].
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * 
 * Leetcode Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/cmd
 * 
 */
public class MinimumInSortedRotatedArray {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            if(nums[low] < nums[high]){
                break;
            }
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[high]){
                low = mid + 1;

            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
