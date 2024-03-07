package BinarySearch;

/*
 * 
 * An array arr is a mountain if the following properties hold:
 *  1. arr.length >= 3
 *  2. There exists some i with 0 < i < arr.length - 1 such that:
 *        arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
 *        arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 
 * Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 * You must solve it in O(log(arr.length)) time complexity.
 * 
 * Approach:
 * 
 * To achieve a time complexity of O(log n), you can use binary search algorithm. 
 * Start by initializing pointers at the start (low) and end (high) of the array. Narrow down the search range iteratively by comparing the middle element with its adjacent elements to determine whether the peak lies to the left or right. 
 * By adjusting the pointers based on the comparison, you eventually converge on the peak element.
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * 
 */

public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int ans = -1;
        int low = 0;
        int high = arr.length-1;

        while(low <= high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid] < arr[mid+1]){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
        
    }
    
}
