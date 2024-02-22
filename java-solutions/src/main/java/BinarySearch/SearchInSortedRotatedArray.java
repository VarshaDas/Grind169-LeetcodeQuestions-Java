package BinarySearch;

public class SearchInSortedRotatedArray {
    /**
     * Search in Rotated Sorted Array:
     * Given a rotated sorted array and a target value, this method searches for the target value in the array.
     * 
     * Approach: 
     * 
     * Brute Force Approach:
     * Iterate through the entire array to find the target element.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * Optimal Approach:
     * The approach used here is a modified version of the binary search algorithm.
     * We maintain two pointers, left and right, that represent the start and end indices of the subarray we are considering. In each iteration, we calculate the middle index mid. We then compare the target value with the middle element of the subarray. If they are equal, we return the middle index as the result. Otherwise, we check if the left or right half of the subarray is sorted.
     * If the left half is sorted, we check if the target value falls within the range of the left half. If it does, we update the right pointer to mid - 1 and continue searching in the left half. Otherwise, we update the left pointer to mid + 1 and continue searching in the right half.
     * If the right half is sorted, we check if the target value falls within the range of the right half. If it does, we update the left pointer to mid + 1 and continue searching in the right half. Otherwise, we update the right pointer to mid - 1 and continue searching in the left half.
     * Time Complexity: O(log n) The time complexity of this algorithm is logarithmic
     * since we divide the search space in half in each iteration.
     * Space Complexity: O(1) The space complexity is constant as we only use a few variables
     * to keep track of indices during the search.
     *
     * @param nums   The rotated sorted array.
     * @param target The target value to search for.
     * @return The index of the target value in the array, or -1 if it is not found.
     * <p>
     * Leetcode link : https://leetcode.com/problems/search-in-rotated-sorted-array/description/
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Search in the left half
                } else {
                    left = mid + 1; // Search in the right half
                }
            }
            // The right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // Search in the right half
                } else {
                    right = mid - 1; // Search in the left half
                }
            }
        }

        return -1; // Target value not found
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 5;
        System.out.println(search(arr, target));
    }
}
