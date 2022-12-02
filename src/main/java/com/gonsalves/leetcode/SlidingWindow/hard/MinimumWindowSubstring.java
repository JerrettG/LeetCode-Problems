package com.gonsalves.leetcode.SlidingWindow.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    /*
    Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

    The testcases will be generated such that the answer is unique.

    Example 1:
        Input: s = "ADOBECODEBANC", t = "ABC"
        Output: "BANC"
        Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

    Example 2:
        Input: s = "a", t = "a"
        Output: "a"
        Explanation: The entire string s is the minimum window.
    Example 3:
        Input: s = "a", t = "aa"
        Output: ""
        Explanation: Both 'a's from t must be included in the window.
        Since the largest window of s only has one 'a', return empty string.

    Constraints:
        m == s.length
        n == t.length
        1 <= m, n <= 105
        s and t consist of uppercase and lowercase English letters.


    Follow up: Could you find an algorithm that runs in O(m + n) time?
     */

    /**
     * This method uses the sliding window technique to find the minimum substring of t within s. It accomplishes this by
     * adding all characters of t in a map called 'need' that stores the number of occurrences of each letter
     * using two pointers and expanding the right pointer until all characters of t are covered. As the right pointer expands
     * it adds increments the count of every letter it 'needs' from t in the 'have' map. If the value of the character in
     * the 'have' map is >= the value of the character in the 'need' map, the number of matches is increased. Once we
     * have gotten all chars of t in s, we shrink the window by moving the left pointer, decrementing the count of each letter from the
     * 'have' map that appears in the 'need' map and decreasing the number of matches if the count is no long >= need value
     * @param s The string we are finding the minimum substring of t in.
     * @param t The substring we are finding in s
     * @return minimum length of the substring t in s.
     */
    public static String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        int left = 0;
        int right = 0;
        int numMatches = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> have = new HashMap<>();

        //Create a map of all characters and the number of occurrences of those characters from t String
        for (int i = 0; i < t.length(); i++)
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);


        //iterate through the s String and
        while (right < s.length()) {

            if (need.containsKey(s.charAt(right))) {
                have.put(s.charAt(right), have.getOrDefault(s.charAt(right), 0)+1); //increment have count for char
                if (have.get(s.charAt(right))-1 < need.get(s.charAt(right)) && have.get(s.charAt(right)) >= need.get(s.charAt(right)))
                    numMatches++;
            }
            right++;
            while (numMatches == need.size()) {
                if (right-left < minLength) {
                    minLength = right-left;
                    minStart = left;
                }
                char leftChar = s.charAt(left);
                left++;
                if (have.containsKey(leftChar)) {
                    have.put(leftChar, have.get(leftChar)-1);
                    if (have.get(leftChar) < need.get(leftChar))
                        numMatches--;
                }
            }

        }
        return minLength == Integer.MAX_VALUE ? "": s.substring(minStart, minStart + minLength);

    }


    public static void main(String[] args) {
        String s = "aa", t = "aa";
        String s2 = "ADOBECODEBANC", t2 = "ABC";
        System.out.println(minWindow(s, t));
        System.out.println(minWindow(s2, t2));
    }
}
