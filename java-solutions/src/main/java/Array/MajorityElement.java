package Array;

/*
Intuition:
The majority element in an array is defined as the element that appears more than n/2 times, where n is the size of the array.
One simple approach to find the majority element is to use a brute force algorithm that checks each element and counts
its occurrences in the array. The element with the highest count that exceeds n/2 is considered the majority element.

Brute Force Approach:

Initialize a variable, majority, to store the current majority element, and count to keep track of its occurrence count.
Iterate through each element, num, in the array.
For each element, iterate through the array again to count the number of occurrences.
If the count exceeds n/2, update the majority element and its count.
Return the majority element as the result.

The brute force approach works by examining each element and counting its occurrences, but it requires nested loops,
resulting in a time complexity of O(n^2) since we iterate through the array twice. While this approach is simple to implement,
it may not be efficient for large arrays.

We can optimize the algorithm using the Boyer-Moore Voting Algorithm, which has a time complexity of O(n).

The intuition behind the optimized approach is that if we cancel out each occurrence of an element with all the other elements that
 are different from it, the remaining element will be the majority element.

 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 1;
        int maj = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(nums[i] == nums[maj]){
                count++;
            } else {
                count--;
            }

            if(count == 0){
                count = 1;
                maj = i;
            }
        }

        return nums[maj];
    }

}
