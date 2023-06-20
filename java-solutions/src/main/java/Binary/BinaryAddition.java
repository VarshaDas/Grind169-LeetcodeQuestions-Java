package Binary;
/*
Approach:

The addBinary method takes two binary strings a and b as input.
It uses two pointers, i and j, to iterate over the binary strings from right to left.
It performs binary addition digit by digit, starting from the least significant bit (rightmost)
and moving towards the most significant bit (leftmost).

A StringBuilder is used to construct the result binary string.
The method keeps track of the carry and performs the necessary calculations to obtain the sum and carry for each bit.
The sum bits are appended to the StringBuilder in reverse order.
Finally, the carry, if non-zero, is appended to the StringBuilder as well.

The StringBuilder is reversed and converted to a string, which is then returned as the binary sum of the input strings.
Time Complexity: O(max(N, M))

Here, N and M are the lengths of the input binary strings a and b, respectively.
The method iterates over the longer string, performing constant time operations for each bit.

Space Complexity: O(max(N, M))

Leetcode link: https://leetcode.com/problems/add-binary/description/
 */
public class BinaryAddition {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
//        BinaryAddition binaryAddition = new BinaryAddition();
//        String a = "1010";
//        String b = "1011";
//        String result = binaryAddition.addBinary(a, b);
//        System.out.println("Binary Addition Result: " + result);
        String s1 = "varsha";
        String s2 = "varsha";
        System.out.println(s1.equals(s2));
    }
}
