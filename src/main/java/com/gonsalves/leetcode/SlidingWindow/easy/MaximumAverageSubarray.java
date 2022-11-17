package com.gonsalves.leetcode.SlidingWindow.easy;

public class MaximumAverageSubarray {

    public static double findMaxAverage(int[] nums, int k) {
        double maxAverage = Integer.MIN_VALUE;
        double average;
        int left = 0, right = k-1;
        int sum = 0;
        for (int i = 0; i < right; i++)
            sum+=nums[i];
        while (right < nums.length) {
            sum += nums[right];
            average = (double)sum/(double)k;
            maxAverage = Math.max(maxAverage, average);
            sum -= nums[left++];
            right++;
        }
        return maxAverage;
    }
}
