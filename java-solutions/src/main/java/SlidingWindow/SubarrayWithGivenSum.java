package SlidingWindow;

import java.util.ArrayList;

/*
 * Given an unsorted array A of size N that contains only non negative integers, 
 * find a continuous sub-array that adds to a given number S and return the left and right index(1-based indexing) of that subarray.
 * In case of multiple subarrays, return the subarray indexes which come first on moving from left to right.
 * 
 * Brute Force Approach:
 * To find subarrays, you can use two loops to iterate over all possible subarrays and calculate the sum of each subarray. 
 * Check whether the sum equals S, if yes, return the indexes of the subarray.
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 * 
 * Optimal Solution:
 * 
 * To solve this problem in linear time, you can maintain a window for the subarray, which will start from 0 and gradually move towards the right.
 * 1. To track the sum of the current subarray, initialize a currentSum variable.
 * 2. Keep expanding the window towards the right until the currentSum is greater than or equal to S. By expanding, we mean adding elements to the currentSum.
 * 3. Once the currentSum exceeds S, shrink the window from the left until the currentSum is less than S.
 * 4. In each iteration, keep checking if the currentSum is equal to S. If yes, return the indexes of that subarray.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Practice Link: https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
 * 
 */

public class SubarrayWithGivenSum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> result = new ArrayList<>();
        
        int i = 0;
        int currentSum = 0;
        for(int j=0;j<n;j++)
        {
            currentSum = currentSum + arr[j];
            
            while(currentSum > s)
            {
                currentSum = currentSum - arr[i];
                i++;
            }
            
            if(currentSum == s && i<=j)
            {
                result.add(i+1);
                result.add(j+1);
                return result;
            }
        }
        result.add(-1);
        return result;
    }
    
}
