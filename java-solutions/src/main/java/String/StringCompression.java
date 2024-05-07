package String;
/*
 * Given an array of characters chars, compress it using the following algorithm:
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * 1. If the group's length is 1, append the character to s.
 * 2. Otherwise, append the character followed by the group's length.
 * 
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 * After you are done modifying the input array, return the new length of the array.
 * 
 * Optimal Approach:
 * You can use two pointers (write and read) to traverse and modify the array in-place. 
 * 1. Initialize write to 0 to update the compressed array in-place and start to 0 to track the start of each group of consecutive characters.
 * 2. Start from the initial position and traverse through the array using the read pointer. 
 * 3. If the current character and previous character are same, increment the length of the group.
 * 4. If they are different, it means that group has ended. So, write the current character in the array and if the group length is greater than 1, convert the length to character and update the array. 
 * 5. Update write pointer to move to the next position.
 * 6. After traversing the array, write pointer will contain the length of the new compressed array.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Practice Link: https://leetcode.com/problems/string-compression/
 * 
 */

public class StringCompression {
    public int compress(char[] chars) {
        int write = 0;
        int start = 0;
        
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read] != chars[read + 1]) {
                chars[write++] = chars[start]; // Write current character
                
                int length = read - start + 1;
                if (length > 1) {
                    String lengthStr = String.valueOf(length);
                    for (char c : lengthStr.toCharArray()) {
                        chars[write++] = c; // Write length as characters
                    }
                }
                
                // Move start to the next group
                start = read + 1;
            }
        }
        
        return write;
    }
}
