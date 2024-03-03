package BinarySearch;

/*
 * Given an array of integers citations where citations[i] is the number of citations a 
 * researcher received for their ith paper and citations is sorted in ascending order, return the researcher's h-index.
 * 
 * According to the definition of h-index on Wikipedia: 
 * The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 * 
 * You must write an algorithm that runs in logarithmic time.
 * 
 * Approach:
 * To find the H-index, you have to find out the maximum value, say m, such that there are at least m number of papers which have more than or equal to m citations(m will be the h-index).
 * To do this, you can use binary search to check whether the element at mid index is satisfying the required condition.
 * The number of papers having citations more than m will be all the papers to the right of mid, including mid(as array is sorted in ascending order). 
 * If element at mid is less than the papers, search in the right half, else search in the left half of the array.
 * 
 * Algorithm:
 * 1. Initialize left and right pointers to the start and end indices of the input array citations.
 * 2. Perform binary search within the range [left, right].
 * 3. At each iteration, calculate the midpoint mid and the number of papers (papers) with citations greater than or equal to citations[mid].
 * 4. If the number of papers equals citations[mid], it means the researcher has published at least papers papers with papers citations each, which is the definition of the h-index. Return papers.
 * 5. If citations[mid] is less than papers, it means we need to search in the right half of the array. Update left = mid + 1.
 * 6. If citations[mid] is greater than papers, it means we need to search in the left half of the array. Update right = mid - 1.
 * 7. Repeat steps 2-6 until left exceeds right.
 * 8. If the loop terminates, it means no exact h-index value was found. In this case, return n - left, where left points to the position where the h-index would be inserted if it were present in the array.
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * 
 * Leetcode Link: https://leetcode.com/problems/h-index-ii/description/
 * 
 */

public class HIndexII {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int papers = n - mid;

            if (citations[mid] == papers) {
                return papers;
            } else if (citations[mid] < papers) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return n - left;
    }
    
}
