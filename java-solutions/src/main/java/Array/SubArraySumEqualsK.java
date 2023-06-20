package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 *
 * To solve the problem using a brute force approach, we can iterate through all possible subarrays and count the number of subarrays with the target sum.
 *
 * Initialize a variable count to 0, which will keep track of the count of subarrays with the target sum.
 * Iterate through all possible subarrays by using two nested loops:
 * The outer loop will consider the starting index of the subarray from 0 to n-1.
 * The inner loop will consider the ending index of the subarray from the current starting index to n-1.
 * For each subarray, calculate the sum of its elements.
 * If the sum equals the target sum k, increment the count by 1.
 * After iterating through all possible subarrays, the value of count will represent the total number of subarrays with the sum equal to k.
 *
 * The time complexity of the brute force approach is O(n^3), where n is the length of the input array. This is because we have two nested loops and, for each subarray, we calculate the sum by iterating through its element
 *
 *
 * Intuition (for optimal solution):
 * We can solve this problem using the cumulative sum technique. We maintain a running sum of the elements as we iterate through the array.
 * For each index i, we calculate the cumulative sum up to that index and store it in a HashMap.
 *
 * The key in the HashMap represents the cumulative sum, and the value represents the count of subarrays with that cumulative sum.
 *
 * As we iterate through the array, for each index i, we check if there is a subarray with sum (cumulativeSum - k) that ends at index i. If such a subarray exists, it means we have found a subarray with sum k.
 * We increment the count by the number of subarrays with sum (cumulativeSum - k) that we have encountered so far.
 *
 * Time Complexity: O(n)
 * The time complexity of this approach is O(n) because we iterate through the array once, and for each index, we perform constant time operations to check for subarrays with sum k and update the count.
 *
 * Space Complexity: O(n)
 * The space complexity is O(n) because in the worst case, all the elements in the array could have distinct cumulative sums, and we need to store them in the HashMap.
 *
 */

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {

        int count = 0;
        int sum = 0;
        Map<Integer,Integer> map1 = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            sum = sum + nums[i];

            if(sum == k){
                count++;
            }

            if(map1.containsKey(sum - k)){
                count = count + map1.get(sum - k);
            }

            map1.put(sum, map1.getOrDefault(sum,0)+1);
        }

        return count;
    }
}
