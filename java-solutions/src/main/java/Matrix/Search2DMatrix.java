package Matrix;

import java.util.Arrays;

/*
You are given an m x n integer  matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int high = rows-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(target >= matrix[mid][0] && target <= matrix[mid][cols-1]){
                boolean exists = binarySearch1D(matrix[mid], target);
                if(exists){
                    return true;
                }
            }
            else if(target < matrix[mid][0]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

     public boolean binarySearch1D(int[] arr, int target){
         int low = 0;
         int high = arr.length-1;
         while(low <= high){
             int mid = low + (high- low)/2;
             if(arr[mid] == target){
                  return true;
             }
             else if(arr[mid] < target){
                 low = mid + 1;
             } else {
                 high = mid -1;
             }
         }
         return false;
     }

}
