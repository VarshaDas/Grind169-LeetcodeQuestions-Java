package BinarySearch;

/*
The intuition behind this approach is to use binary search to efficiently find the pivot point or the smallest element in the rotated sorted array.
By comparing elements at the start (low) and end (high) of the search range,
we determine whether the subarray is sorted or not and adjust the search range accordingly.
This approach reduces the time complexity to logarithmic O(log N) in finding the minimum element.

We handle the edge case where the input array nums has only one element.
In this case, the minimum element is the only element in the array, so we return nums[0].

We initialize two pointers, low and high, which represent the start and end indices of the
search range in the array.

Inside the while loop, we perform binary search iterations until the low and high pointers meet (low < high).

We check if nums[low] < nums[high].
If this condition is true, it means that the subarray between low and high is already sorted in ascending order.
Therefore, the minimum element must be nums[low], and we break out of the loop.

If the subarray is not sorted, we calculate the middle index mid as the average of low and high.

We compare nums[mid] with nums[high] to determine which half of the array might contain the minimum element.

If nums[mid] > nums[high], it means the pivot point (the point where the rotation occurs) lies between mid and high.
Hence, the minimum element cannot be present at or after mid. We update low = mid + 1 to search in the right half of the array.

If nums[mid] <= nums[high], it means the pivot point lies before mid or at mid itself.
In this case, the minimum element can be at or before mid. We update high = mid to search in the left half of the array.

We repeat steps 4-8 until the low and high pointers meet.

Finally, when the search range is narrowed down to a single element (low = high),
 we have found the minimum element. We return nums[low].
 */
public class MinimumInSortedRotatedArray {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            if(nums[low] < nums[high]){
                break;
            }
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[high]){
                low = mid + 1;

            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
