package SlidingWindow;

/*

 Leetcode - https://leetcode.com/problems/subarray-product-less-than-k/

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
