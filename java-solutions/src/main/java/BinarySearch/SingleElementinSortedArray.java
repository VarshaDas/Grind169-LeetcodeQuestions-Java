package BinarySearch;

/*
Intuition:
The given array is sorted, and every element appears twice except for one element.
 To find the single element, we can use a modified binary search approach.

We initialize two pointers, "low" and "high", to the start and end indices of the array, respectively.
 We perform binary search iterations until "low" is less than or equal to "high".

In each iteration, we calculate the middle index, "mid", as the average of "low" and "high".
 We check if "mid" is even or odd.

If "mid" is even:

If "nums[mid]" is not equal to "nums[mid+1]", it means the single element is present on the left side of "mid".
 We update "high" to "mid - 1".
If "nums[mid]" is equal to "nums[mid+1]", it means the single element is present on the right side of "mid".
We update "low" to "mid + 1".


If "mid" is odd:

If "nums[mid]" is not equal to "nums[mid+1]", it means the single element is present on the right side of "mid".
 We update "low" to "mid + 1".
If "nums[mid]" is equal to "nums[mid+1]", it means the single element is present on the left side of "mid".
We update "high" to "mid - 1".
We adjust the "low" and "high" pointers based on the above conditions and continue the search u
ntil "low" is no longer less than or equal to "high".
Finally, we return the element at the "low" index, which is the single element in the array.

This approach leverages the property of the sorted array and eliminates half of the search space in each iteration, resulting in an efficient solution.

Time Complexity: O(log n), where n is the length of the input array. In each iteration, we reduce the search space by half.
Space Complexity: O(1), as we are using a constant amount of extra space.
 */
public class SingleElementinSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 2;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid % 2 == 0){
                if(nums[mid] != nums[mid+1]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(nums[mid] != nums[mid+1]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return nums[low];
    }
}
