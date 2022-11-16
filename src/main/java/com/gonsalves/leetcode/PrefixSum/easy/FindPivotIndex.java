package com.gonsalves.leetcode.PrefixSum.easy;

import java.util.Arrays;

public class FindPivotIndex {
    /*
    Given an array of integers nums, calculate the pivot index of this array.

    The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

    If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

    Return the leftmost pivot index. If no such index exists, return -1.

    Example 1:

        Input: nums = [1,7,3,6,5,6]
        Output: 3
        Explanation:
        The pivot index is 3.
        Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
        Right sum = nums[4] + nums[5] = 5 + 6 = 11

    Example 2:

        Input: nums = [1,2,3]
        Output: -1
        Explanation:
        There is no index that satisfies the conditions in the problem statement.

    Example 3:

        Input: nums = [2,1,-1]
        Output: 0
        Explanation:
        The pivot index is 0.
        Left sum = 0 (no elements to the left of index 0)
        Right sum = nums[1] + nums[2] = 1 + -1 = 0


    Constraints:

        1 <= nums.length <= 104
        -1000 <= nums[i] <= 1000

     */


    public static int pivotIndex(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        //index 0 for leftSum is 0 and index nums.length-1 for rightSum is 0
        leftSum[0] = 0;
        rightSum[rightSum.length-1] = 0;

        //one pass through and add keep track of the left sum for the current index and the right sum for current index and place in corresponding arrays
        for (int i = 1; i < nums.length; i++) {
            //leftSum = previousSum + currentIndex-1
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }
        //leftSum = [0, 1, 3]
        for (int i = nums.length-2; i >= 0; i--) {
            //pass through left and right arrays to see if any are equal
            rightSum[i] = rightSum[i+1] + nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum[i] == rightSum[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {1,7,3,6,5,6};
        int answer = 3;
        int result = pivotIndex(input);
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Result: " + result);
        System.out.println("Answer: " + answer);
    }
}
