package com.gonsalves.leetcode.TwoPointers.medium;

import java.util.Arrays;

public class RotateArray {

    /*
    Given an array, rotate the array to the right by k steps, where k is non-negative.

    Example 1:
        Input: nums = [1,2,3,4,5,6,7], k = 3
        Output: [5,6,7,1,2,3,4]
        Explanation:
        rotate 1 steps to the right: [7,1,2,3,4,5,6]
        rotate 2 steps to the right: [6,7,1,2,3,4,5]
        rotate 3 steps to the right: [5,6,7,1,2,3,4]

    Example 2:
        Input: nums = [-1,-100,3,99], k = 2
        Output: [3,99,-1,-100]
        Explanation:
        rotate 1 steps to the right: [99,-1,-100,3]
        rotate 2 steps to the right: [3,99,-1,-100]

    Constraints:
        1 <= nums.length <= 105
        -231 <= nums[i] <= 231 - 1
        0 <= k <= 105

    Follow up:

    Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
    Could you do it in-place with O(1) extra space?
     */

    public static void rotate(int[] nums, int k) {
        // step1: reverse the array in place so [1,2,3,4,5,6,7] becomes [7,6,5,4,3,2,1] when k =3
        // step2: split the array into two. so you get [7,6,5] and [4,3,2,1]
        // step3: reverse both the two parts. [5,6,7] and [1,2,3,4]

        k = k % nums.length; //this takes care of the edge cases where k > nums.length such as [-1] where k = 2
        swap(nums, 0, nums.length-1);
        swap(nums, 0, k-1);
        swap(nums, k, nums.length-1);
    }

    public static void swap(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] input1 = {1,2,3,4,5,6,7};
        int[] answer1 = {5,6,7,1,2,3,4};
        int[] input2 = {-1};
        int[] answer2 = {-1};
        int k1 = 3;
        int k2 = 2;
        System.out.println("Input:  " + Arrays.toString(input1));
        rotate(input1, k1);
        System.out.println("Result: " + Arrays.toString(input1));
        System.out.println("Answer: " + Arrays.toString(answer1));
        System.out.print("\n\n");
        System.out.println("Input:  " + Arrays.toString(input2));
        rotate(input2, k2);
        System.out.println("Result: " + Arrays.toString(input2));
        System.out.println("Answer: " + Arrays.toString(answer2));
    }
}
