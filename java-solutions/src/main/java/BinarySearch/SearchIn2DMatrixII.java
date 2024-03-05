package BinarySearch;

/*
 * 
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *  1. Integers in each row are sorted in ascending from left to right.
 *  2. Integers in each column are sorted in ascending from top to bottom.
 * 
 * Approach:
 * As the integers in the matrix are sorted from left to right as well as top to bottom, perform a binary search considering both, rows as well as columns. 
 * If the target is less than the current element, move leftwards in the same row. If the target is greater than the current element, move downwards in the same column.
 * 
 * Algorithm:
 * 1. Start from the top-right corner of the matrix (or bottom-left corner).
 * 2. Compare the target with the element at the current position.
 * 3. If the target is equal to the current element, return true.
 * 4. If the target is less than the current element, move leftwards in the same row.
 * 5. If the target is greater than the current element, move downwards in the same column.
 * 6. Repeat steps 3-5 until the target is found or the boundary of the matrix is reached.
 * 
 * Time Complexity: O(log m + log n)
 * Space Complexity: O(1)
 * 
 * Leetcode Link: https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 * 
 */

public class SearchIn2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        
        return false;
    }
}
