package Matrix;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Leetcode link: https://leetcode.com/problems/spiral-matrix/

*/
public class Spiralmatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        //The algorithm maintains four variables: rowBegin, rowEnd, colBegin, and colEnd, which represent the boundaries of
        // the current layer being traversed. The initial values of these variables correspond to the boundaries of the entire
        // matrix.
        int rowBegin = 0;
        int rowEnd = matrix.length-1;

        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while(rowBegin <= rowEnd && colBegin <= colEnd){

            //Traverse the top row of the layer from colBegin to colEnd and add the elements to the result list.
            //Increment rowBegin to exclude the top row from future traversals.
            for(int i = colBegin; i <= colEnd; i++){
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            //raverse the right column of the layer from rowBegin to rowEnd and add the elements to the result list.
            //Decrement colEnd to exclude the right column from future traversals.
            for(int i = rowBegin; i <= rowEnd; i++){
                result.add(matrix[i][colEnd]);
            }
            colEnd--;


            //Check if there are more rows to traverse (rowBegin <= rowEnd), and if so, traverse the bottom row of the layer from colEnd to colBegin (in reverse order) and add the elements to the result list.
            //Decrement rowEnd to exclude the bottom row from future traversals.
            if(rowBegin <= rowEnd){
                for(int i = colEnd; i>= colBegin;i--){
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            //Check if there are more columns to traverse (colBegin <= colEnd), and if so, traverse the left column of the layer from rowEnd to rowBegin (in reverse order) and add the elements to the result list.
            //Increment colBegin to exclude the left column from future traversals
            if(colBegin <= colEnd){
                for(int i = rowEnd; i>= rowBegin;i--){
                    result.add(matrix[i][colBegin]);
                }
            }

            colBegin++;

        }

        return result;
    }
}
