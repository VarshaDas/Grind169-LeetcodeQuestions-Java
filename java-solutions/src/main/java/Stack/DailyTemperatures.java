package Stack;

import java.util.Stack;

/*

Leetcode link - https://leetcode.com/problems/daily-temperatures/description/

*/
public class DailyTemperatures {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] result = new int[n];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int idx = stack.pop();
                    result[idx] = i - idx;
                }
                stack.push(i);
            }

            return result;
        }
}

