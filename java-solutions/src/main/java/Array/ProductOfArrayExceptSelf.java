package Array;

/*

Given an array nums[] of size n, construct a Product Array P (of same size n) such that P[i] is equal to the product of all the elements of nums except nums[i].

Intuition:
The initial approach to this can be finding out the total product of the array and then dividing each element from the total product to find out the product of subarray.
But, if an element is 0, dividing by zero will return an error and the total product will also be 0.

Approach:

Brute Force Approach:

1. Find the total product of the elements in the array.
2. Iterate through the loop and divide each element from the total product.
3. Assign this product as the product of the subarray.
4. Return the product array.

This approach will not work because there can be zero in the array, and in that case, the total product will be zero.

Optimal Solution:
1. Count the number of zeros in the array and store it in a variable count.
2. Find the total product of the array, excluding the zeros.
3. For each element in the array, if count is equal to one and the current element is not 0, then set the product of the subarray to 0. This means that zero is present in the subarray. Hence, the product should be 0.
4. If count is equal to one and the current element is 0, then set the product of the subarray to the total product of the array. 
5. If count is more than one, then set the product of the subarray to zero as there are multiple zeros present in the subarray. 
6. Else, divide the current element from the total product of the array. Assign this value to the product of the subarray.
7. Return the product array. 


Time complexity: O(n)
The algorithm iterates through the array once, performing constant-time operations for each element.

Space complexity: O(n), as we are returning the product array of size n.
The algorithm uses an array of size n to store the products of the subarrays.

Practice link: https://practice.geeksforgeeks.org/problems/product-array-puzzle4525/1
 */

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int count = 0;
        int product = 1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                count++;
            } else{
                product *= nums[i];
            }
        }

        for(int i = 0;i<nums.length;i++){
            if(count == 1 && nums[i] != 0){   
                ans[i] = 0;
            } else if(count == 1 && nums[i] == 0){
                ans[i] = product;
            } else if (count >= 2){
                ans[i] = 0;
            } else {
                ans[i] = product/nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(nums1);
        System.out.println("Product of Array Except Self for nums1: " + Arrays.toString(result1));

        // Test case 2
        int[] nums2 = {0, 1, 2, 3};
        int[] result2 = solution.productExceptSelf(nums2);
        System.out.println("Product of Array Except Self for nums2: " + Arrays.toString(result2));

        // Test case 3
        int[] nums3 = {4, 0, 2, 1, 0};
        int[] result3 = solution.productExceptSelf(nums3);
        System.out.println("Product of Array Except Self for nums3: " + Arrays.toString(result3));
    }
    }
