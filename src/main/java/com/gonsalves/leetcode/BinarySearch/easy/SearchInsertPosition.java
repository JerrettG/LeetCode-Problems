package com.gonsalves.leetcode.BinarySearch.easy;

import java.util.Arrays;

public class SearchInsertPosition {
/*
    Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
        Input: nums = [1,3,5,6], target = 5
        Output: 2

    Example 2:
        Input: nums = [1,3,5,6], target = 2
        Output: 1

    Example 3:
        Input: nums = [1,3,5,6], target = 7
        Output: 4


    Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums contains distinct values sorted in ascending order.
    -104 <= target <= 104
 */

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        if (target < nums[0])
            return 0;
        else if (target > nums[high])
            return nums.length;
        else {
            while (low <= high) {
                int mid = (high+low)/2;

                if (nums[mid] == target)
                    return mid;
                else if (nums[mid] > target) {
                    if (nums[mid-1] < target)
                        return mid;
                    high = mid-1;
                }
                else {
                    if (nums[mid+1] > target)
                        return mid+1;
                    low = mid+1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] input = {1,3,5,6};
        int target1 = 5;
        int answer1 = 2;
        int result1 = searchInsert(input, target1);
        int target2 = 7;
        int answer2 = 4;
        int result2 = searchInsert(input, target2);

        System.out.println("Array: " + Arrays.toString(input));
        System.out.println("Target 1: " + target1);
        System.out.println("Result: " + result1);
        System.out.println("Answer: " + answer1);
        System.out.println("\nTarget 2: " +target2);
        System.out.println("Result: " + result2);
        System.out.println("Answer:" + answer2);
    }
}
