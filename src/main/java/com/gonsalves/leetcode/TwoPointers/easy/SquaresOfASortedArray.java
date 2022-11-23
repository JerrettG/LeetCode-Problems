package com.gonsalves.leetcode.TwoPointers.easy;

import java.util.Arrays;

public class SquaresOfASortedArray {
    /*
    Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

    Example 1:
        Input: nums = [-4,-1,0,3,10]
        Output: [0,1,9,16,100]
        Explanation: After squaring, the array becomes [16,1,0,9,100].
        After sorting, it becomes [0,1,9,16,100].

    Example 2:
        Input: nums = [-7,-3,2,3,11]
        Output: [4,9,9,49,121]


    Constraints:
        1 <= nums.length <= 104
        -104 <= nums[i] <= 104
        nums is sorted in non-decreasing order.

    Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
     */


    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        int[] squares = new int[nums.length];
        /* To do this in O(n) time and O(n) space we can use two pointers because it is a sorted array.
           The pointers start at the beginning and end of the array and make their way to the middle until all values
           are inserted into the squares array. We compare the squares of the values of the pointers to see which is greater
           because we know that the ends of the array will be the lowest possible value and the highest possible value.
           Since the square of -4 is a positive, we can make the comparison to the square of 10, 100, and insert whichever
           is highest at the end of the squares array because as we make our way inwards in the nums array, the squares
           get smaller
         */
        for (int i = squares.length-1; i >= 0; i--) {
            int rightSquare = nums[right] * nums[right];
            int leftSquare = nums[left] * nums[left];
            if (leftSquare > rightSquare) {
                squares[i] = leftSquare;
                left++;
            }
            else {
                squares[i] = rightSquare;
                right--;
            }

        }

        return squares;
    }

    public static void main(String[] args) {
        int[] input = {-4,-1,0,3,10};
        int[] answer = {0,1,9,16,100};
        System.out.println("Input:  " + Arrays.toString(input));
        System.out.println("Result: "+Arrays.toString(sortedSquares(input)));
        System.out.println("Answer: " + Arrays.toString(answer));
    }
}
