package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int n = heights.length;
            int maxArea = 0;

            for (int i = 0; i <= n; i++) {
                while (!stack.isEmpty() && (i == n || heights[i] < heights[stack.peek()])) {
                    int height = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
                stack.push(i);
            }

            return maxArea;
        }
    }

