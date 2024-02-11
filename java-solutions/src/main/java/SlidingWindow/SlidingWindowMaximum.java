package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        CopyOnWriteArrayList
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
