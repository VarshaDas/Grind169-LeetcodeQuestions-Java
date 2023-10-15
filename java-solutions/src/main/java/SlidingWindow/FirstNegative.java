package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

class FirstNegatives {

    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Deque<Integer> negIndices = new LinkedList<>();
        long[] output = new long[N-K + 1];

        // Traverse through the array
        for (int i = 0; i < N; i++) {
            // If the deque is not empty and the leftmost element
            // is out of the current window,
            // then remove it from the deque
            if (!negIndices.isEmpty() && negIndices.peekFirst() == i - K) {
                negIndices.pollFirst();
            }

            // If the current element is negative, add its index to the deque
            if (A[i] < 0) {
                negIndices.offerLast(i);
            }

            // If the current window is of size k, 
            // print the first negative integer (if present)
            if (i >= K - 1) {
                // If the deque is not empty, 

                if (!negIndices.isEmpty() ) {
                    output[i-K+1] = A[negIndices.peekFirst()];
                }
            }
        }
        return output;
    }
}