package Array;

/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * 
 * Approach:
 * Brute Force Approach:
 * The first thought that might appear in your mind to solve this would be iterating through each pair of days (buy day and sell day) and calculating the profit for each pair.
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 * 
 * Better Approach:
 * You can use array preprocessing to keep track of how high the price went and track the maximum profit by iterating through the array once. 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Optimal Approach:
 * You can optimize the process by maintaining two variables, minProfit and maxProfit. Iterate through the array and keep updating maxProfit.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Leetcode Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

 */

public class BestTimeToBuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        
        return maxProfit;
        
    }
    
}
