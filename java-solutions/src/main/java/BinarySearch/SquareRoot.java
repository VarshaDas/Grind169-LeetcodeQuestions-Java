package BinarySearch;
/*
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 * You must not use any built-in exponent function or operator.
 * 
 * Approach:
 * 
 * Brute Force Approach:
 * Start from 0 and incrementally check each number until the square of that number exceeds or equals the given integer x.
 * Time Complexity: O(sqrt(x))
 * Space Complexity: O(1)
 * 
 * Optimal Approach - Binary Search:
 * Square root of a number will never be greater than the mid of that number (half of the number). 
 * Use this observation to apply binary search algorithm to find the square root within the range of 0 to x.
 * Time Complexity: O(log x)
 * Space Complexity: O(1)
 * 
 * 
 * Leetcode Link: https://leetcode.com/problems/sqrtx/description/
 * 
 */

public class SquareRoot {
    public int mySqrt(int x) {
        if(x<2)
            return x;
        int ans = 0;
        int start = 1;
        int end = x/2;
        while(start<=end)
        {
            int mid = (start+end) / 2;
            int square = mid*mid;
            if(square == x)
                return mid;
            else if(square < x)
            {
                ans = mid;
                start = mid + 1;
            }
            else
                end = mid - 1;
        }
        return ans;
    }
    
}
