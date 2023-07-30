package String;

import java.util.Arrays;
import java.util.Comparator;

/*
Convert the array of integers into an array of strings, so that we can easily compare and concatenate them.

Sort the array of strings using a custom comparator.
The comparator should compare two strings by concatenating them in different orders and choosing the
order that forms the larger number. For example, if we have two strings "a" and "b", we compare "ab"
and "ba" to determine the larger string.

After sorting, concatenate all the strings in the sorted array to form the largest possible number.

The intuition behind this approach is that by comparing and sorting the strings in the right order,
we can ensure that the final concatenation forms the largest number.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        // Convert numbers to strings
        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        // Custom comparison function
        Comparator<String> comp = (str1, str2) -> (str2+str1).compareTo(str1+str2);

        // Sort the strings using the custom comparison function
        Arrays.sort(strArr, comp);

        // Handle leading zeros
        if (strArr[0].equals("0")) {
            return "0";
        }

        // Concatenate the sorted strings
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }

        return sb.toString();
    }
}
