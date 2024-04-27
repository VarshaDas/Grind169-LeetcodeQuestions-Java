package SlidingWindow;

import java.util.ArrayList;

/*
 * Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.
 * 
 * Brute Force Approach:
 * You can consider all possible subarrays of size K in the given array and iterate through them using nested loops. For each subarray, calculate the sum of its elements and keep track of the maximum sum.
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 * 
 * Optimal Approach:
 * To find the maximum sum subarray of size K, you can maintain a window of size K and calculate the sum of its elements.
 * Now, slide that window through the array, one element to the right at a time and update the sum of the window. Keep track of the maximum sum in each iteration and once the loop terminates, return the maximum sum.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Practice Link: https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
 * 
 */

public class MaximumSumSubarraySizeK {
    public static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        int maxSum = 0;
        int currentSum = 0;
        int startIndex = 0;
        
        // Calculate the sum of the first window of size k
        for (int i = 0; i < K; i++) {
            maxSum += Arr.get(i);
        }
        currentSum = maxSum;

        // Slide the window and update maxSum
        for (int i = K; i < N; i++) {
            currentSum = currentSum + Arr.get(i) - Arr.get(i - K);
            if (currentSum > maxSum) {
                maxSum = currentSum;
                startIndex = i - K + 1;
            }
        }
        return maxSum;
    }
}
