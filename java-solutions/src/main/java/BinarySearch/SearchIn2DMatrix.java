package BinarySearch;
/*
 * You are given an m x n integer matrix matrix with the following two properties:
 *      1. Each row is sorted in non-decreasing order.
 *      2. The first integer of each row is greater than the last integer of the previous row.
 * 
 * Given an integer target, return true if target is in matrix or false otherwise.
 * You must write a solution in O(log(m * n)) time complexity.
 * 
 * Approach: 
 * Treat the matrix as a flattened sorted array and perform binary search directly on it. Think of the 2D matrix as a 1D array with m * n elements. 
 * Initialize left as 0 and right as m * n-1, and then perform binary search as usual.
 * 
 * Algorithm:
 * 1. Initialize left as 0 and right as m * n - 1.
 * 2. While left <= right, calculate mid as (left + right) / 2.
 * 3. Convert mid to its corresponding row and column index.
 * 4. Compare the matrix[row][col] value with the target.
 *      If matrix[row][col] == target, return true.
 *      If matrix[row][col] < target, update left as mid + 1.
 *      If matrix[row][col] > target, update right as mid - 1.
 *      If the loop completes without finding the target, return false.
 * 
 * Time Complexity: O(log(m * n)
 * Space Complexity: O(1)
 * 
 * Leetcode Link: https://leetcode.com/problems/search-a-2d-matrix/description/
 * 
 */

public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0;
        int right = m * n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;
            
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
    

