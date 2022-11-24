package com.gonsalves.leetcode.SlidingWindow.medium;

import java.util.HashMap;
import java.util.Map;

public class PermutationInStrings {

/*
    Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

    In other words, return true if one of s1's permutations is the substring of s2.

    Example 1:
        Input: s1 = "ab", s2 = "eidbaooo"
        Output: true
        Explanation: s2 contains one permutation of s1 ("ba").

    Example 2:
        Input: s1 = "ab", s2 = "eidboaoo"
        Output: false

    Constraints:
        1 <= s1.length, s2.length <= 104
        s1 and s2 consist of lowercase English letters.
 */

    /**
     * This method uses the sliding window technique in order to determine if String s2, contains a permutation of
     * String s1. A permutation is a String containing the exact number of each character in the original String, but
     * with any random assortment of those letters. For example "abc" can have permutations: "acb", "bac", "bca", "cab","cba".
     * In order to determine if a permutation of one string exists in another string, we have a window equal to the size
     * of the permutation string and slide the window through the tested string. All characters within the window will be compared
     * to a Map containing the characters in the permutation String as keys and their number of occurrences in the permutation
     * String as values. We decrement the count of the character within the map if the character enters the window and
     * increase the count once it leaves our window's scope. Everytime a character count is decremented, we check to see
     * if the count for that character is 0, meaning we have gotten all necessary occurrences of that character.
     * If the count is 0, we increase our matches counter and compare the matches counter to the size of the map because
     * in order for the permutation to exist in the tested String, we would have to have the number of matches equal to
     * the number of different characters. When we increment the count of a character, that character is no longer in scope,
     * and we would need to find another occurrence of that character in order to complete the permutation. If the value
     * of the character count was 0 before, we would have to decrease the number of matches because we no longer have
     * found all occurrences for that character.
     *
     * @param s1 The string which permutations are based off of
     * @param s2 The string we will be testing contains permutations of s1.
     * @return True if s2 contains a permutation of s1, false otherwise.
     */
    public static boolean checkInclusion(String s1, String s2) {
        //No permutation of s1 can exist in s2 if s1 is longer than s2
        if (s1.length() > s2.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int numMatches = 0;

        for (int i = 0; i < s1.length(); i++) //Fill our map with all characters and their counts in s1
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0)+1);

        while (right < s2.length()) {
            char rightCharacter = s2.charAt(right);
            if (map.containsKey(rightCharacter)) {
                //Right character appears in our permutation so we must decrement its count
                map.put(rightCharacter, map.get(rightCharacter) - 1);
                //Since count was decremented we need to check if we have found all occurrences of this character
                if (map.get(rightCharacter)==0)
                    numMatches++;
            }
            //Return true if we have our window contains all characters with the exact number of occurrences of each character
            if (numMatches == map.size())
                return true;
            //Window is bigger than the size of the permutation String so we must remove the left character
            if (right >= s1.length()-1) {
                char leftCharacter = s2.charAt(left);
                //Check to see if character removed is part of permutation String and increment the count if so
                if (map.containsKey(leftCharacter)) {
                //If the number of occurrences previously matched as it will no longer match after incrementing
                    if (map.get(leftCharacter) == 0)
                        numMatches--;
                    map.put(leftCharacter, map.get(leftCharacter) + 1);

                }
                left++;
            }
            right++;
        }

        return false;

    }

    private static void test(String s1, String s2, boolean expected) {
        boolean answer = checkInclusion(s1, s2);
        System.out.println("Input:  s1 = \"" + s1 + "\", s2 = \"" + s2 + "\"" );
        System.out.println("Result: " + answer);
        System.out.println("Expected: " + expected);
        System.out.println("Passed: " + (answer == expected));
        System.out.println();
    }

    public static void main(String[] args) {
        String s11 = "ab";
        String s21 = "eidbaooo";
        boolean expected1 = true;

        String s12 = "ab";
        String s22 = "eidboaoo";
        boolean expected2 = false;

        String s13 = "abcdxabcde";
        String s23 = "abcdeabcdx";
        boolean expected3 = true;

        String s14 = "horse";
        String s24 = "roe";
        boolean expected4 = false;

        test(s11, s21, expected1);
        test(s12, s22, expected2);
        test(s13, s23, expected3);
        test(s14, s24, expected4);
    }
}
