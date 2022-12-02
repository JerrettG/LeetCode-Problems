package com.gonsalves.leetcode.BinarySearch.medium;

import java.util.Arrays;

public class SearchInRotatedArray {

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input1n2 = {4,5,6,7,0,1,2}, input3 = {1}, input4 = {5,1,3};
        int target = 0, target2 = 3, target3 = 0, target4 = 5;
        int answer = 4, answer2 = -1, answer3 = -1, answer4 = 0;
        System.out.println("Input:  nums = " + Arrays.toString(input1n2) + ", target = " + target);
        System.out.println("Result: " + search(input1n2, target));
        System.out.println("Answer: " + answer + "\n");

        System.out.println("Input:  nums = " + Arrays.toString(input1n2) + ", target = " + target2);
        System.out.println("Result: " + search(input1n2, target2));
        System.out.println("Answer: " + answer2+ "\n");

        System.out.println("Input:  nums = " + Arrays.toString(input3) + ", target = " + target3);
        System.out.println("Result: " + search(input3, target3));
        System.out.println("Answer: " + answer3+ "\n");

        System.out.println("Input:  nums = " + Arrays.toString(input4) + ", target = " + target4);
        System.out.println("Result: " + search(input4, target4));
        System.out.println("Answer: " + answer4+ "\n");
    }
}
