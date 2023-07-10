package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Given a collection of intervals, merge overlapping intervals and return a new collection of merged intervals.

The algorithm takes a list of intervals and sorts them based on their start times.
It then iterates through the sorted intervals and checks if the current interval overlaps with the
previous interval. If there is an overlap, the algorithm merges the intervals by updating the end time
of the previous interval. If there is no overlap, the current interval is added to the result list as a new merged interval. This process continues until all intervals are processed.

The time complexity of this algorithm is O(n log n), where n is the number of intervals.
The algorithm sorts the intervals, which takes O(n log n) time. After sorting, it iterates through
the sorted intervals once, which takes O(n) time. Hence, the overall time complexity is dominated by
 the sorting step.

The space complexity is O(n) since we need to store the merged intervals in a separate list.
In the worst case, if there are no overlapping intervals, the result list will contain the same number
of intervals as the input list.


 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        List<int[]> output = new ArrayList<>();
        int[] prev = intervals[0];
        output.add(prev);

        for(int[] interval : intervals){
            int prevend = prev[1];
            int currbegin = interval[0];
            int currend = interval[1];

            if(currbegin <= prevend){
                prev[1] = Math.max(prevend, currend);
            } else {
                prev = interval;
                output.add(interval);
            }
        }
        return output.toArray(new int[output.size()][]);
    }
}
