package com.gonsalves.leetcode.Strings.easy;

import java.util.Arrays;

public class ReverseStringTwo {

    public static String reverseStr(String s, int k) {
        char[] letters = s.toCharArray();
        String subsection = reverseSubString(s.substring(0,k).toCharArray());
        System.out.println(subsection);
        String subsection2 = reverseSubString(s.substring((s.length()-1)/2*k).toCharArray());
        System.out.println(subsection2);
        return subsection + subsection2;
    }

    public static String reverseSubString(char[] s) {
        char temp;
        for (int i = 0; i < s.length/2; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
        return Arrays.toString(s);
    }


    public static void main(String[] args) {
        String input = "abcdefg";
        System.out.println(7/2 +1);
        System.out.println(reverseStr(input, 2));
    }
}
