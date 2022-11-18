package com.gonsalves.leetcode.TwoPointers;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static int[] sortedSquares(int[] nums) {
        return new int[0];
    }

    public static void main(String[] args) {
        int[] input = {-4,-1,0,3,10};
        int[] answer = {0,1,9,16,100};
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Result: "+Arrays.toString(sortedSquares(input)));
        System.out.println("Answer: " + Arrays.toString(answer));
    }
}
