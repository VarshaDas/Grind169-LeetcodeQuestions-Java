package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 * 
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 * 1.  You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
 * 2.  Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 * 3.  Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * 
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 * 
 * Brute Force Approach:
 * The brute force approach to solve this problem involves considering all possible subarrays, and for each starting point, try to pick fruits until you encounter a fruit that cannot be added to the basket. 
 * 1. Keep track of the types of fruits in the current basket and their counts in a HashMap. 
 * 2. If the current basket can contain the fruit, we add it to the basket and increment the count of collected fruits.
 * 3. If the current fruit cannot be added to the basket (i.e., the basket already contains two types of fruits), we break the loop and move to the next starting point.
 * 
 * Time Complexity: O(n²)
 * Space Complexity: O(n)
 * 
 * Optimal Approach:
 * As you have only two baskets, and each basket can only hold a single type of fruit, this means you can collect only two types of fruits. 
 * On observing the given examples, it can be concluded that you have to find the longest subarray with distinct values, but keep in mind, the count of distinct values should be exactly two. 
 * So, you can maintain a sliding window, and while moving the right pointer, keep track of the count of each type of fruit in the window(distinct values in the window).
 * 
 * If the the count is more than two, shrink the window from left until only two types of fruit remain.
 * Update the length of subarray in each iteration, and once the loop completes its execution, you will have the required count.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Practice Link: https://leetcode.com/problems/fruit-into-baskets/description/
 * 
 */

public class FruitsIntoBasket {

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitCount = new HashMap<>();
        int maxCount = 0;
        int left = 0;

        for (int right = 0; right < fruits.length; right++) {
            int currentFruit = fruits[right];
            fruitCount.put(currentFruit, fruitCount.getOrDefault(currentFruit, 0) + 1);

            while (fruitCount.size() > 2) {
                int fruitToRemove = fruits[left];
                fruitCount.put(fruitToRemove, fruitCount.get(fruitToRemove) - 1);
                if (fruitCount.get(fruitToRemove) == 0) {
                    fruitCount.remove(fruitToRemove);
                }
                left++;
            }

            maxCount = Math.max(maxCount, right - left + 1);
        }

        return maxCount;
    }
}

