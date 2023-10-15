package Intervals;

import java.util.Arrays;
import java.util.Comparator;

/*
 Leetcode link - https://leetcode.com/problems/non-overlapping-intervals/description/

 */
public class NonOverlappingIntervals {


        public int eraseOverlapIntervals(int[][] intervals) {
            if(intervals.length <= 1){
                return 0;
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
            int n = intervals.length;
            int count  = 0;
            int end = intervals[0][1];

            for(int i = 1 ; i < n; i++ ){
                if(intervals[i][0] < end){
                    count++;
                } else {
                    end = intervals[i][1];
                }
            }

            return count;
        }
    }
