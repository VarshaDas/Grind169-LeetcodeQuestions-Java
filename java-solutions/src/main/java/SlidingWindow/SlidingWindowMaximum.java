package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 * 
 * Brute Force Approach:
 * The brute force approach to solve this problem is using nested loops to iterate through each possible window. 
 * For each window, iterate to find the maximum value within that window.
 * 
 * Time Complexity: O(n*K)
 * Space Complexity: O(1)
 * 
 * Optimal Approach:
 * To optimize the solution, you can use a monotonic decreasing queue. 
 * 
 * Monotonic queue is a queue that maintains a certain order of elements (either strictly increasing or strictly decreasing) as elements are added or removed. 
 * Specifically, for this problem, we use a monotonic decreasing queue.
 * Now to implement this monotonic decreasing queue, you will need to maintain a deque that stores indices in a monotonically decreasing order.
 * 
 * Remove elements from the deque that are out of the current window range. 
 * Make sure that the deque only contains elements that maintain the decreasing order (larger values at the front).
 * Add elements to the deque while maintaining the decreasing order. Retrieve the maximum value (from the front of the deque) for the current window.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Practice Link: https://leetcode.com/problems/sliding-window-maximum/description/
 * 
 */

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();

        int[] output = new int[n-k+1];
        int resultIndex = 0;

        for(int i = 0; i < n;i++){
            //to remove the items which are out of window
            while(!deque.isEmpty() && deque.peekFirst() < i - k + 1){
                deque.pollFirst();
            }
            //to remove items smaller than current
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if( i >= k - 1){
                output[resultIndex++] = nums[deque.peekFirst()];
            }
        }
        return output;
    }
}
