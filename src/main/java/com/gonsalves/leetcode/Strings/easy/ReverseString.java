package com.gonsalves.leetcode.Strings.easy;

public class ReverseString {

    public static void reverseString(char[] s) {
        char temp;
        for (int i = 0; i < s.length/2; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
    }
    }

    public static void main(String[] args) {
        char[] input = {'h','e','l','l','o'};
        System.out.println(input);
        reverseString(input);
        System.out.println(input);
    }
}
