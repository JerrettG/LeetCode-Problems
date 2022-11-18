package com.gonsalves.leetcode.Strings.easy;

import java.util.Stack;

public class isSubsequence {

    public static boolean isSubsequence(String s, String t) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        for (int i = t.length()-1; i >=0; i--) {
            if (!stack.isEmpty() && stack.peek().equals(t.charAt(i)))
                stack.pop();
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean result = isSubsequence(s, t);
        System.out.println(result);

    }
}
