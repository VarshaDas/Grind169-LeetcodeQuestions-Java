package Array;

/*
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 * 
 * Approach:
 * Brute Force Approach:
 * Iterate through all possible pairs of lines and calculate the area formed by each pair. Return the maximum area.
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 * 
 * Optimal Approach - Two pointers:
 * Maintain two pointers start and end; calculate the area formed by the two lines represented by the pointers. Move the pointer with the shorter line inward and update the maximum area accordingly. Repeat until the two pointers meet.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Leetcode Link: https://leetcode.com/problems/container-with-most-water/
 */

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int area = minHeight * width;
            maxArea = Math.max(maxArea, area);

            // Move the pointer with the smaller height towards the center
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
