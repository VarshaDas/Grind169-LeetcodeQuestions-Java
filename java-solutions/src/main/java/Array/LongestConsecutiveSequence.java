package Array;


import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * Intuition:
 * The consecutive numbers in the array may not be in a continuous order. They may be scattered across the array. The simplest way to solve this problem is to sort the array and  then find the longest consecutive sequence. 
 * 
 * Approach:
 * 
 * Brute Force approach:
 * The brute force approach for this problem is to solve it by:
 * 1. Sorting the array in ascending or descending order. Initialize a max value for the counter, which will be updated later. 
 * 2. Iterate through the elements of the array.
 * 3. Check whether the current element is one more than the previous element. 
 * 4. If yes, keep incrementing the counter. As soon as some other number is found, update the max value of the counter and break from the loop.
 * 5. Once we reach the end of the array, display the max value of the counter.
 * 
 * 
 * Optimal Solution: 
 * To find the longest consecutive sequence, we can use a HashSet to store all the numbers in the array.
 * Then, for each number in the array, we can check if its previous number (number - 1) exists in the HashSet.
 * If it does not exist, it means this number is the starting point of a new sequence.
 * We can then iterate forward from this number, counting the length of the consecutive sequence until we reach a number that does not exist in the HashSet.
 * We update the maximum length of the consecutive sequence whenever we find a longer sequence.
 *
 * Time Complexity: O(n)
 * The algorithm iterates over the array once to populate the HashSet, and then for each number, we perform constant time operations to check for consecutive numbers.
 *
 * Space Complexity: O(n)
 * The algorithm uses a HashSet to store all the numbers in the array. In the worst case, all the numbers in the array are distinct and need to be stored in the HashSet.
 * 
 * 
 * Leetcode link: https://leetcode.com/problems/longest-consecutive-sequence/
 *
 */

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int maxLength = 0;

        // Add all numbers to a set for O(1) lookup
        for (int num : nums) {
            numSet.add(num);
        }

        // Iterate through each number in the set
        for (int num : numSet) {
            // Check if num-1 is in the set, if it is, skip this number
            if(!numSet.contains(num-1)){

                // Otherwise, we have found a new sequence
                int currentNum = num;
                int currentLength = 1;

                // Iterate through the consecutive numbers until we reach the end of the sequence
                while (numSet.contains(currentNum+1)) {
                    currentNum++;
                    currentLength++;
                }

                // Update the maxLength if necessary
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
