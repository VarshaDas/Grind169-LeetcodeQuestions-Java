package String;

import java.util.Arrays;

public class ReverseWords
{
    public static void main(String[] args) {
        String a = " hello    world ";
        String rev = reverse(a.trim().split("\\s+"));
        System.out.println(rev);
    }


    public static String reverse(String[] words) {
        int left = 0, right = words.length - 1;
        System.out.println(Arrays.toString(words));
        while (!words[left].equals("") && left <= right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left += 1;
            right -= 1;
        }
        String res = String.join(" ", words);
        return res;
    }
}
