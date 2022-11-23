package com.gonsalves.leetcode.Strings.easy;

public class ReverseWordsInStringIII {
    /*
    Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

    Example 1:
        Input: s = "Let's take LeetCode contest"
        Output: "s'teL ekat edoCteeL tsetnoc"

    Example 2:
        Input: s = "God Ding"
        Output: "doG gniD"

    Constraints:
        1 <= s.length <= 5 * 104
        s contains printable ASCII characters.
        s does not contain any leading or trailing spaces.
        There is at least one word in s.
        All the words in s are separated by a single space.
     */


    public static String reverseWords(String s) {
        String[] words = s.split("\s");
        for (int i = 0; i < words.length; i++)
            words[i] = reverseString(words[i]);

        return String.join("\s", words);
    }

    private static String reverseString (String input) {
        char[] reversed = new char[input.length()];
        for (int i = input.length()-1; i >=0; i--)
            reversed[input.length()-1-i] = input.charAt(i);

        return String.valueOf(reversed);
    }

    public static void main(String[] args) {
        String input1 = "Let's take LeetCode contest";
        String input2 = "God Ding";
        String result = reverseWords(input1);
        String answer1 = "s'teL ekat edoCteeL tsetnoc";
        String answer2 = "doG gniD";

        System.out.println("TEST 1");
        System.out.println("Input:  " + input1);
        System.out.println("Result: " + result);
        System.out.println("Answer: " + answer1);
        System.out.println("Passed: " + result.equals(answer1)+"\n");
        result = reverseWords(input2);
        System.out.println("TEST 2");
        System.out.println("Input:  " + input2);
        System.out.println("Result: " + result);
        System.out.println("Answer: " + answer2);
        System.out.println("Passed: " + result.equals(answer2)+"\n");

    }
}
