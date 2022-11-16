package com.gonsalves.leetcode.Strings.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    /*
    Given two strings s and t, determine if they are isomorphic.

    Two strings s and t are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving the order of characters.
    No two characters may map to the same character, but a character may map to itself.



    Example 1:

    Input: s = "egg", t = "add"
    Output: true
    Example 2:

    Input: s = "foo", t = "bar"
    Output: false
    Example 3:

    Input: s = "paper", t = "title"
    Output: true

    Constraints:
        1 <= s.length <= 5 * 104
        t.length == s.length
        s and t consist of any valid ascii character.
     
     */
    public static boolean isIsomorphic(String s, String t) {
        /*In order for s and t to be isomorphic, all occurrences of the same letter in s must be replaced by the same letter
        in t. If it were "paper" "title", the maps would look something 
        like this: 
        p -> t   t -> p
        a -> i   i -> a
        p -> t   t -> p
        e -> l   l -> e
        r -> e   e -> r
        
        By looping through and adding the inverse key value pairs to maps, we know that the next time we encounter the same
        letter in s, the value from our map should equal to the current letter in t, and vice versa. If they do not, the
        two strings are not isomorphic.
        * */
        
        //Create two maps
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i< t.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if ((sMap.containsKey(sChar) && sMap.get(sChar) != tChar) || (tMap.containsKey(tChar) && tMap.get(tChar) != sChar))
                return false;

            sMap.put(sChar, tChar);
            tMap.put(tChar, sChar);
        }
        return true;
    }

    public static void main(String[] args) {
        String t = "title";
        String s = "paper";
        System.out.println(isIsomorphic(s, t));
    }
}
