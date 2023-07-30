package Array;

import java.util.HashMap;
import java.util.Map;

/*
The given code aims to find the length of the longest subarray in the given array nums with an equal number of 0s and 1s.
It uses a technique called prefix sum along with a hashmap to keep track of the count and position of the prefix sums.

The key idea behind this approach is to keep track of the count of 0s and 1s encountered so far using a prefix sum.
Whenever the same count is encountered again, it implies that the subarray between the previous occurrence and
the current index has an equal number of 0s and 1s. By calculating the length of this subarray for each occurrence of a count,
 we can find the maximum length of such subarrays.

Time Complexity: The code iterates through the array once, resulting in a time complexity of O(n), where n is the length
of the array nums.

Space Complexity: The space complexity is O(n) because in the worst case, all elements of the array can have distinct
prefix sums stored in the hashmap.
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int count = 0;  // Variable to keep track of the count of 0s and 1s encountered so far
        int maxLength = 0;  // Variable to store the maximum length of the subarray
        Map<Integer, Integer> countMap = new HashMap<>();  // Hashmap to store the count and its corresponding index

        countMap.put(0, -1);  // Initial entry in the hashmap to handle the case when subarray starts from index 0

        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 1 ? 1 : -1);  // Increment count by 1 if the element is 1, else decrement by 1

            if (countMap.containsKey(count)) {
                // If the current count is already present in the hashmap, calculate the length of the subarray
                // by subtracting the previous index (stored in the hashmap) from the current index
                maxLength = Math.max(maxLength, i - countMap.get(count));
            } else {
                // If the current count is not present in the hashmap, add an entry with the count and its corresponding index
                countMap.put(count, i);
            }
        }

        return maxLength;

    }
}
