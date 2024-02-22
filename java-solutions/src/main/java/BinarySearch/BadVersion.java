package BinarySearch;

/*
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * 
 * Approach:
 * 
 * Brute Force Approach:
 * Iterate over each version starting from 1 until you find the first bad version using the isBadVersion API.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Optimal Approach:
 * Since the versions are sorted and all versions after a bad one are also bad, you can use binary search to find the first bad version efficiently.
 * 
 * Algorithm:
 * 1. Set start = 1 and end = n
 * 2. While start <= end:
 *    a. Set mid = start + (end-start)/2;
 *    b. If isBadVersion(mid) is True:
 *           Set ans = mid
 *           Shift end to the right side, to sraech for first bad version
 *       Else:
 *           Shift start to the left side
 * 3. Return ans
 * 
 * Leetcode Link: https://leetcode.com/problems/first-bad-version/
 * 
 */

public class BadVersion {
    public int firstBadVersion(int n) {
        int ans = -1;
        int start = 1;
        int end = n;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(isBadVersion(mid))
            {
                ans = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return ans;
    }
    
}
