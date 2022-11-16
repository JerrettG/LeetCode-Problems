package com.gonsalves.leetcode.PrefixSum.easy;

import java.util.Arrays;

public class RunningSumOfOneDimArray {
    /*
    Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

    Return the running sum of nums.

    Example 1:

        Input: nums = [1,2,3,4]
        Output: [1,3,6,10]
        Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

    Example 2:

        Input: nums = [1,1,1,1,1]
        Output: [1,2,3,4,5]
        Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].

    Example 3:

        Input: nums = [3,1,2,10,1]
        Output: [3,4,6,16,17]


    Constraints:

        1 <= nums.length <= 1000
        -10^6 <= nums[i] <= 10^6
         */
    public static int[] runningSum(int[] nums) {
        //sum array length == nums.length
        int[] runningSum = new int[nums.length];
        //previousSum
        int previousSum = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentSum = previousSum + nums[i];
            //add current index to previousSum to get current runningSum
            runningSum[i] = currentSum;
            previousSum = currentSum;
        }
        return runningSum;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        int[] answer = {1,3,6,10};
        int[] result = runningSum(input);
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Result: "+ Arrays.toString(result));
        System.out.println("Answer: " + Arrays.toString(answer));

    }
}
