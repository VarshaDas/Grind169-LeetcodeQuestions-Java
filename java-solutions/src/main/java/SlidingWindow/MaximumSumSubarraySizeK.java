package SlidingWindow;

public class MaximumSumSubarraySizeK {
    public static int maxSumSubarrayOfSizeK(int[] nums, int K) {
        int start = 0;
        int end = 0;
        int maxSum = 0;
        int currentSum = 0;

        while (end < nums.length) {
            currentSum += nums[end];

            if (end - start + 1 == K) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= nums[start];
                start++;
            }

            end++;
        }

        return maxSum;
    }

}
