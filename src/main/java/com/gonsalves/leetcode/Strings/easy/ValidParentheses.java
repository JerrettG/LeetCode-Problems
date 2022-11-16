package com.gonsalves.leetcode.Strings.easy;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] letters = s.toCharArray();
        for (char letter : letters) {
            if (stack.isEmpty() && (letter == ')' || letter=='}' || letter ==']'))
                return false;

            if (letter == '(' || letter == '{' || letter == '[') {
                stack.push(letter);
                continue;
            }
            if ( (letter == ')' && stack.peek().equals('(')) || (letter == '}' && stack.peek().equals('{')) || (letter == ']' && stack.peek().equals('[')))
                stack.pop();
            else
                stack.push(letter);

        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        String input =
                "(])";
        System.out.println(isValid(input));
    }
}
