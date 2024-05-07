package String;

/*
 * Given a roman numeral, convert it to an integer.
 * 
 * Optimal Approach:
 * To convert a roman numeral to integer, you can use a HashMap to store the mappings of Roman numeral characters to their respective integer values 
 * and use it to quickly lookup for the value of any roman numeral.
 * There are two major rules of converting roman numeral to an integer: 
 * 1. If current value is greater or equal to the next value, both the values get added. 
 * 2. If the current value is less than the next value, it gets subtracted from the next value.
 * 
 * So, start with the last element in the result and traverse through the string 
 * and compare each character with the previous one to determine whether to add or subtract its value based on Roman numeral rules.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Practice Link: https://leetcode.com/problems/roman-to-integer/description/
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int l=s.length();
        int res=map.get(s.charAt(l-1));  //store last value in result
        for(int i=l-2;i>=0;i--)
        {
            // Compare current value with the previous value
            if(map.get(s.charAt(i))<map.get(s.charAt(i+1)))
            {
                res-=map.get(s.charAt(i));
            }
            else
            {
                res+=map.get(s.charAt(i));
            }
        }
        return res;
    }
}
