package Array;

import java.util.Arrays;

/**

 Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color
 are adjacent, with the colors in the order red, white, and blue.

 We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

 Approach:
 The brute force approach for the "Sort Colors" problem would involve performing a simple comparison-based sorting algorithm,
 such as bubble sort or insertion sort.
 The brute force approach compares adjacent elements in the array and swaps them if they are in the wrong order.
 This process is repeated until the entire array is sorted.
 The time complexity of the brute force approach is O(n^2) in the worst case, where n is the length of the array.

 It is not an optimal solution for this problem, as there exists a more efficient algorithm using the Dutch National Flag approach.

 This problem can be solved using the Dutch National Flag algorithm, also known as the 3-way partitioning algorithm.

 The idea is to maintain three pointers: low, mid, and high. The low pointer represents the boundary of the red color,
 the mid pointer represents the boundary of the white color, and the high pointer represents the boundary of the blue color.
 We iterate through the array and perform the following operations:

 If the current element is 0 (red), we swap it with the element at the low pointer and increment both low and mid pointers.

 If the current element is 1 (white), we simply increment the mid pointer.

 If the current element is 2 (blue), we swap it with the element at the high pointer and decrement the high pointer.

 The algorithm ensures that all elements before the low pointer are red (0), all elements between the low and mid pointers are white (1),
 and all elements after the high pointer are blue (2), resulting in a sorted array.
 Time Complexity: O(n)
 The algorithm iterates through the array once, performing constant-time operations for each element.
 Space Complexity: O(1)
 The algorithm uses only a constant amount of extra space to store the pointers.

 Leetcode link: https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }


    private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public static void main(String[] args) {
            int[] nums = {2, 0, 2, 2, 1, 1, 0, 0};

            SortColors sorter = new SortColors();
            sorter.sortColors(nums);

            System.out.println(Arrays.toString(nums));
        }
}
