package Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix, this algorithm traverses the elements in a spiral order and returns them as a list.
 * The matrix is traversed in a clockwise direction, starting from the top-left element
 * and moving towards the center.
 *
 *
 * The time complexity of this algorithm is O(m * n), where m is the number of rows and n is the number of columns in the matrix.
 * We need to visit each element in the matrix once to traverse it in a spiral order.
 *
 * The space complexity of this algorithm is O(1), as we are using only a constant amount of extra space to store the result.
 * The result list is the only additional space used, and its size is the same as the number of elements in the matrix.
 *
 * Leetcode link: https://leetcode.com/problems/spiral-matrix/description/
 *
 */

public class SpiralMatrix {
    /**
     * Traverses the given matrix in a spiral order and returns the elements as a list.
     *
     * @param matrix The input matrix to traverse.
     * @return A list containing the elements of the matrix in spiral order.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int rowBegin = 0;
        int rowEnd = matrix.length-1;

        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while(rowBegin <= rowEnd && colBegin <= colEnd){

            for(int i = colBegin; i <= colEnd; i++){
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            for(int i = rowBegin; i <= rowEnd; i++){
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowBegin <= rowEnd){
                for(int i = colEnd; i>= colBegin;i--){
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if(colBegin <= colEnd){
                for(int i = rowEnd; i>= rowBegin;i--){
                    result.add(matrix[i][colBegin]);
                }
            }

            colBegin++;

        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        SpiralMatrix spiralMatrix = new SpiralMatrix();

        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        System.out.println("Spiral Order: " + result);
    }
}
