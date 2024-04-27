package SlidingWindow;

/*
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 * 
 * Brute Force Approach:
 * The brute force approach involves considering all possible subarrays and for each subarray, 
 * calculate the product of the subarray and if the product is less than k, increment the count.
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 * 
 * Optimal Approach:
 * Now, you can optimize the previous solution using sliding window approach. Before starting with the approach, you need to check if k is less than or equal to 1, as no subarray's  product can be less than or equal to 0 or 1.
 * Moving on, you need to maintain a window and a count of the subarrays. 
 * 1. Expand the subarray towards the right and keep updating the product of the current subarray. 
 * 2. While product is greater than or equal to k, shrink the window from the left by dividing the product by the leftmost element. 
 * 3. Also, calculate the size of the current window.
 * 4. If the product is less than k, increment count by the length of the current window and shrink the window from the left.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Practice Link: https://leetcode.com/problems/subarray-product-less-than-k/
 */
public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if( k <= 1){
            return 0;
        }
        int product = 1;
        int i = 0;
        int j = 0;
        int count = 0;
        int n = nums.length;

        while( j < n){
            product *= nums[j];
            while(product >= k){
                product = product / nums[i];
                i++;
            }

            int window = j - i + 1;
            if(product < k){
                count += window;
            }
            j++;
        }

        return count;
    }
}
