package Array;
import java.util.HashSet;

/*
 *
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * 
 * Approach:
 * Brute Force Approach:
 * The first thought you might get to solve it is comparing an element with every other element in the array. 
 * Time Complexity: O(n²)
 *  Space Complexity: O(1) 
 * 
 * Better Approach: Sorting
 * Sort the array in ascending order and compare adjacent elements to identify duplicates. 
 * Time Complexity: O(n log n), for sorting the array.
 * Space Complexity: O(n), for storing the sorted array. 
 * 
 * Optimized Approach: Hash Set
 * An optimized method involves using a hash set to store encountered elements. While iterating through the array, if an element is in the hash set, return true; otherwise, add the element to the hash set. If the loop completes without discovering any duplicates, return false. 
 * Time Complexity: O(n)
 * Space Complexity: O(n), additional space (hashset) is used.
 * 
 * Leetcode Link: https://leetcode.com/problems/contains-duplicate/description/
 * 
 */

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
