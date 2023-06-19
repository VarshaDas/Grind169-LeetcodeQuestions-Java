package Array;

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
