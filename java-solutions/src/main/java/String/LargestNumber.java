package String;

import java.util.Arrays;
import java.util.Comparator;

/*
 *
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * 
 * Approach:
 * 
 * Brute Force Approach:
 * 
 * The simplest approach to this problem is considering all possible orderings of the numbers and selecting the one that results in the largest integer when concatenated. 
 * 1. Generate all possible permutations of the given array of numbers.
 * 2. For each permutation, concatenate the numbers to form a single integer.
 * 3. Keep track of the maximum integer obtained among all permutations.
 * 4. Return the maximum integer.
 * 
 * The time complexity of this approach is  O(n!), where n is the number of elements in the array, as we are generating all permutations of an array of n elements. 
 * 
 * Optimal Solution:
 * For solving this problem in an optimized way, we need to convert the array of integers into an array of strings, so that we can easily compare and concatenate them.
 * The intuition behind this approach is that by comparing and sorting the strings in the right order, 
 * we can ensure that the final concatenation forms the largest number.
 * 
 * 1. Convert each number in the array to a string.
 * 2. Sort the array of strings in a custom way:
 *      - Compare strings a and b as a + b vs. b + a.
 *      - Sort in descending order based on the custom comparison.
 * 3. Concatenate the sorted strings to form the result.
 * 4. Handle special cases where the result is "0" to ensure the correct output.
 * 
 * The comparator should compare two strings by concatenating them in different orders and choosing the 
 * order that forms the larger number. For example, if we have two strings "a" and "b", we compare "ab" and "ba" to determine the larger string.
 * 
 * Time Complexity: O(n log n), where n is the number of elements in the array, as we are sorting the array of strings. 
 * 
 * Space Complexity:  O(n), where n is the total number of characters in all the strings.
 * 
 * Leetcode link: https://leetcode.com/problems/largest-number/
 *  
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        // Convert numbers to strings
        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        // Custom comparison function
        Comparator<String> comp = (str1, str2) -> (str2+str1).compareTo(str1+str2);

        // Sort the strings using the custom comparison function
        Arrays.sort(strArr, comp);

        // Handle leading zeros
        if (strArr[0].equals("0")) {
            return "0";
        }

        // Concatenate the sorted strings
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }

        return sb.toString();
    }
}
