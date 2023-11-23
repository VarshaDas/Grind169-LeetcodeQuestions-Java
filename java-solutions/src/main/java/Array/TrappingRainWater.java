package Array;

/**
     * Trapping Rain Water:
     * Given an elevation map representing the height of bars, this method calculates the total amount
     * of rainwater that can be trapped between the bars.
     * 
     * @param heights An array of integers representing the height of the bars.
     * @return The total amount of rainwater trapped.
     *
     * Approach:
     * 
     * Brute Force Approach:
     * The brute force approach to this problem is to iterate through each element in the heights array and 
     * calculate the trapped rainwater by finding the maximum heights to its left and right. The trapped water at each position 
     * can be determined by taking the minimum of the left and right maximum heights and subtracting the current height. 
     * This can be understood by the algorithm below:
     * 
     * 1. Iterate through each element heights[i] from index 1 to n-2.
     * 2. For each element, find the maximum height to its left (leftMax) and the maximum height to its right (rightMax).
     * 3. Calculate the trapped water at the current position as min(leftMax, rightMax) - heights[i], and accumulate the result.
     * 
     * The time complexity of this approach is O(n^2) because, 
     * for each element, it searches the entire array to find the maximum heights to its left and right.
     * 
     * 
     * Optimal Solution:
     * We create two arrays, leftMax and rightMax, to store the maximum height from the left and right side
     * respectively for each bar.
     * By doing so, we can determine the maximum height that water can be trapped at each position.
     * Then, we iterate through each bar and calculate the trapped water by taking the minimum height
     * between the left and right maximums and subtracting the current bar's height.
     * Finally, we sum up the trapped water for each bar and return the total amount.
     *
     * Time Complexity: O(n) The code iterates through the array of heights three times: one for calculating the left maximums,
     * one for calculating the right maximums, and one for calculating the trapped water.
     * Since each iteration takes O(n) time, the overall time complexity is O(n).
     *
     * Space Complexity: O(n) The code uses two additional arrays, leftMax and rightMax,
     * of size n to store the maximum heights from the left and right side. Hence, the space complexity is O(n).
     *
     * Leetcode link - https://leetcode.com/problems/trapping-rain-water/description/
     */

public class TrappingRainWater {
    public static int trapRainWater(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        // Calculate the maximum height from the left for each bar
        leftMax[0] = heights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }
        // Calculate the maximum height from the right for each bar
        rightMax[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }
        int trappedWater = 0;

        // Calculate the trapped water for each bar
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            trappedWater += minHeight - heights[i];
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int[] input = {4,2,0,3,2,5};
        System.out.println(trapRainWater(input));

    }
}
