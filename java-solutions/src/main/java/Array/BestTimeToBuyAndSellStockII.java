package Array;

/*
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 * 
 * Approach:
 * Brute Force Approach:
 * The brute force approach to solve this would be iterating through each pair of days (buy day and sell day) and calculating the profit for each pair.
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 * 
 *
 * Optimal  Approach - Peak-Valley Approach:
 * Iterate through the array of prices and keep track of the peak (highest price) and valley (lowest price) encountered so far. 
 * Calculate the profit by subtracting the valley price from the peak price.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Leetcode Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 */

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=0;i<prices.length-1;i++)
        {
            if(prices[i] < prices[i+1])
            {
                profit=profit + (prices[i+1]-prices[i]);
            }
        }
        return profit;
    }
}
