package Array;

/**

 Given an integer array nums sorted in non-decreasing order, return an array of the squares of
 each number sorted in non-decreasing order.

 Approach:
 To square each element of the array and sort the resulting array, we can use a two-pointer approach.

 Initialize two pointers, left and right, pointing to the start and end of the array, respectively.
 Compare the absolute values of the elements at the left and right pointers.
 If the absolute value at the left pointer is greater or equal to the absolute value at the right pointer, square the value at the left pointer and move the left pointer one step to the right.
 Otherwise, square the value at the right pointer and move the right pointer one step to the left.
 Repeat the above steps until the left and right pointers meet.
 Store the squared values in a new array in reverse order.
 Return the new array.

 Intuition:

 The two-pointer approach allows us to compare the absolute values of the elements from both ends of the array
 and square the larger value. By moving the pointers inward, we ensure that the resulting array is
 sorted in non-decreasing order.

 Time Complexity: O(n), where n is the length of the array nums.

 We iterate through the array once using the two-pointer approach.

 Space Complexity: O(n), where n is the length of the array nums.
 We use additional space to store the squared values in a new array.
 */

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] square = new int[n];
        int p1 = 0;
        int p2 = n-1;

        for(int i = n-1;i>=0;i--){
            if(Math.abs(nums[p1]) > Math.abs(nums[p2])){
                square[i] = nums[p1] * nums[p1];
                p1++;
            } else {
                square[i] = nums[p2] * nums[p2];
                p2--;
            }
        }
        return square;
    }
}
