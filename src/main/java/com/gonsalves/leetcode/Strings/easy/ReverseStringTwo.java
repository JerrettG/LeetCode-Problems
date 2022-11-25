package com.gonsalves.leetcode.Strings.easy;

import java.util.Arrays;

public class ReverseStringTwo {

    public static String reverseStr(String s, int k) {
        char[] letters = s.toCharArray();
        //Iterate through the array by 2k, for every 2k determine if the remaining letters in the String is less than k.
        //If the remaining letters in the String is less than k, reverse the remaining letters, otherwise reverse the first k letters
        for (int i = 0; i < s.length();i += 2*k) {
            int end = Math.min(i+k, s.length());
            reverseSubString(letters, i, end);
        }
        return String.valueOf(letters);
    }

    public static void reverseSubString(char[] s, int start, int end) {
        char temp;

        for (int i = 0; i < (end-start)/2; i++) {
            temp = s[i+start];
            s[i+start] = s[end-1-i];
            s[end-1-i] = temp;
        }

    }


    public static void main(String[] args) {
        String input =
                "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        String actual = reverseStr(input, 39);
        String expected = "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqllgsqddebemjanqcqnfkjmi";
        System.out.println(input.length());
        System.out.println(actual.equals(expected));
        System.out.println(actual);
    }
}
