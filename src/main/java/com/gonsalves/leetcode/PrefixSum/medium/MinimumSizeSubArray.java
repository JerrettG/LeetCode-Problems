package com.gonsalves.leetcode.PrefixSum.medium;

public class MinimumSizeSubArray {

    public static int minSubArrayLen(int target, int[] nums) {
        /*
          Sliding window technique with two pointer, Time = O(n), Space = O(1):
         Having two pointers allows you to iterate only once through the array and increment your left pointer whenever
         reach a point where your sum >= target. You continue to increment your left pointer until the sum is no longer
         >= target, during which you update the min if the size of your window is less than your current minimum window
         length. If the value of min has never changed, it means there was never a point where sum >= target, so you return
         a sentinel value of 0.
         */
        int left = 0, sum = 0;
        int min = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(right - left+1, min);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    public static void main(String[] args) {
        int input = 11;
        int[] inputArray = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(input, inputArray));
    }
}
