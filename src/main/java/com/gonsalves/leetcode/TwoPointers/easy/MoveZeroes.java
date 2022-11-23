package com.gonsalves.leetcode.TwoPointers.easy;

import java.util.Arrays;

public class MoveZeroes {

/*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.

    Example 1:
        Input: nums = [0,1,0,3,12]
        Output: [1,3,12,0,0]

    Example 2:
        Input: nums = [0]
        Output: [0]

    Constraints:
        1 <= nums.length <= 104
        -231 <= nums[i] <= 231 - 1

    Follow up: Could you minimize the total number of operations done?
 */


    /*** My initial solution with Runtime: 53ms and faster than 9.89% submissions ****/
    public static void initialMoveZeroes(int[] nums) {
        // Step 1: iterate through the array
        // Step 2: when encountering a zero, move zero to the end

        //brute force method
        /*

         for (int i = 0; i < nums.length; i++) {
             if (nums[i] == 0) {
                 int j = i;
                 while (j < nums.length-1) {
                     int temp = nums[j];
                     nums[j] = nums[j+1];
                     nums[j+1] = temp;
                     j++;
                 }
             }

         }

        */
        int right = nums.length-1;
        for (int left = 0; left < right; left++) {
            while (nums[left] == 0 && right > left) {
                shiftElementsByOne(nums, left, right);
                nums[right] = 0;
                right--;
            }
        }
    }

    private static void shiftElementsByOne(int[] input, int start, int end) {
        while (start < end) {
            input[start] = input[++start];
        }
    }

    /*** Fastest runtime solution on leetcode ***/
    public static void fastestMoveZeroes(int[] nums) {
        int snowBallSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                snowBallSize++;
            else if (snowBallSize > 0) {
                nums[i-snowBallSize] = nums[i];
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] input1 = {0,1,0,3,12};
        int[] input2 = {0,0,1};
        int[] input3 = {1};

        int[] answer1 = {1,3,12,0,0};
        int[] answer2 = {1,0,0};
        int[] answer3 = {1};

        System.out.println("Input:  " + Arrays.toString(input1));
        initialMoveZeroes(input1);
        System.out.println("Result: " + Arrays.toString(input1));
        System.out.println("Answer: " + Arrays.toString(answer1));
        System.out.println(Arrays.equals(input1, answer1));

        System.out.println();

        System.out.println("Input:  " + Arrays.toString(input2));
        initialMoveZeroes(input2);
        System.out.println("Result: " + Arrays.toString(input2));
        System.out.println("Answer: " + Arrays.toString(answer2));
        System.out.println(Arrays.equals(input2, answer2));

        System.out.println();

        System.out.println("Input:  " + Arrays.toString(input3));
        initialMoveZeroes(input3);
        System.out.println("Result: " + Arrays.toString(input3));
        System.out.println("Answer: " + Arrays.toString(answer3));
        System.out.println(Arrays.equals(input3, answer3));
    }
}
