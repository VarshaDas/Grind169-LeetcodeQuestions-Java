package Intervals;

import java.util.ArrayList;
import java.util.List;

/*
The idea behind this approach is to traverse the given intervals and identify the position where the new interval should be inserted
 while maintaining the sorted order. While traversing, merge any overlapping intervals with the new interval.
 This way, we can efficiently merge the intervals in linear time.

 Time Complexity:

The time complexity of this approach is O(N), where N is the number of intervals in the given list.
In the worst case, we may need to traverse all the intervals once to find the correct position to insert the new
interval and merge overlapping intervals.

Space Complexity:

The space complexity of this approach is O(1) since we are modifying the intervals in-place and using only a
constant amount of extra space to store the merged interval. The result list does not consume any additional space
 other than the input and output space.
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> out = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while(i< n && intervals[i][1] < newInterval[0]){
            out.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        out.add(newInterval);

        while(i < n ){
            out.add(intervals[i]);
            i++;
        }

        return out.toArray(new int[out.size()][]);


    }
}
