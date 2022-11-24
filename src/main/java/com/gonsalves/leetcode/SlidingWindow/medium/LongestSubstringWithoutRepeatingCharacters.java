package com.gonsalves.leetcode.SlidingWindow.medium;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
/*
    Given a string s, find the length of the longest substring without repeating characters.

    Example 1:
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
    Example 2:
        Input: s = "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.
    Example 3:
        Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


    Constraints:
        0 <= s.length <= 5 * 104
        s consists of English letters, digits, symbols and spaces.
 */

    /**
     * This method uses the sliding window technique in order to find the length of the longest substring without repeating
     * characters in a String s. It accomplishes this by using a Set since every letter in the substring needs to be unique.
     * We expand our window to the right and add each letter to the set as long as the letter at index right is not
     * contained in our set. If we encounter a letter contained in the set, we shrink the window from the left until we
     * are 1 index past the first occurrence of that letter, removing letters no longer in the scope of our window along
     * the way. We use a maxLength variable to keep track of the max size of our window.
     * @param s The input string we will be finding the longest substring for.
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;

        HashSet<Character> set = new HashSet<>();
        while(right < s.length()) {
            if (set.contains(s.charAt(right))) { //shrink window from the left until you've removed the first occurrence of letter at right pointer
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left)); //remove character of left pointer from set since they are no longer in the scope of our window
                    left++;
                }
                left++;
            }
            else {                            //expand window to the right allowing for more values
                set.add(s.charAt(right));
                if (right-left+1 > maxLength)
                    maxLength = right-left+1;
            }
            right++;
        }

        return maxLength;
    }

    public static void main(String[]args) {
        String input1 = "abcabcbb";
        int answer1 = 3;
        String input2 = "pwwkew";
        int answer2 = 3;
        String input3 = "bbbbbb";
        int answer3 = 1;
        String input4 = "tmmzuxt";
        int answer4 = 5;

        System.out.println("TEST 1");
        System.out.println("Input:  " + input1);
        System.out.println("Result: " + lengthOfLongestSubstring(input1));
        System.out.println("Answer: " + answer1+ "\n");

        System.out.println("TEST 2");
        System.out.println("Input:  " + input2);
        System.out.println("Result: " + lengthOfLongestSubstring(input2));
        System.out.println("Answer: " + answer2+ "\n");

        System.out.println("TEST 3");
        System.out.println("Input:  " + input3);
        System.out.println("Result: " + lengthOfLongestSubstring(input3));
        System.out.println("Answer: " + answer3+ "\n");

        System.out.println("TEST 4");
        System.out.println("Input:  " + input4);
        System.out.println("Result: " + lengthOfLongestSubstring(input4));
        System.out.println("Answer: " + answer4+ "\n");

    }
}
