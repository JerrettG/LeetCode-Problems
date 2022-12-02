package com.gonsalves.leetcode.BinarySearch.medium;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    /*
    Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

    If target is not found in the array, return [-1, -1].

    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
        Input: nums = [5,7,7,8,8,10], target = 8
        Output: [3,4]
    Example 2:
        Input: nums = [5,7,7,8,8,10], target = 6
        Output: [-1,-1]
    Example 3:
        Input: nums = [], target = 0
        Output: [-1,-1]

    Constraints:
        0 <= nums.length <= 105
        -109 <= nums[i] <= 109
        nums is a non-decreasing array.
        -109 <= target <= 109
     */

    /**
     * This method searches the nums array and retrieves the first and last index of the target value in the array. It
     * accomplishes this by using calling a binary search twice to find the first index and the last index.
     * @param nums input array
     * @param target target we are searching for the first and last position of
     * @return int[] with starting and ending indexes of the target. Returns {-1,-1} if target not in array
     */
    public static int[] searchRange(int[] nums, int target) {
        return new int[] {searchFirst(nums, target), searchLast(nums, target)};
    }

    /**
     * Uses a binary search to find the first index of the target value in the array. Returns -1 if value not in array
     * @param nums input array
     * @param target target value we are searching for
     * @return first index of the target value in the array, -1 if not in array
     */
    private static int searchFirst(int[]nums, int target) {
        if (nums.length == 0)
            return -1;

        int low = 0;
        int high = nums.length-1;
        int mid;
        int index = 0;

        while (low <= high) {
            mid = low + (high-low)/2;

            if (nums[mid] == target){
                index = mid;
                high = mid-1;
            }
            else if (nums[mid] > target) {
                high = mid-1;
            }
            else
                low = mid+1;
        }

        if (nums[index] == target)
            return index;
        else
            return -1;

    }
    /**
     * Uses a binary search to find the last index of the target value in the array. Returns -1 if value not in array
     * @param nums input array
     * @param target target value we are searching for
     * @return last index of the target value in the array, -1 if not in array
     */
    private static int searchLast(int[]nums, int target) {
        if (nums.length == 0)
            return -1;

        int low = 0;
        int high = nums.length-1;
        int mid;
        int index = 0;

        while (low <= high) {
            mid = low + (high-low)/2;
            if (nums[mid] == target) {
                index = mid;
                low = mid+1;
            }
            else if ( nums[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }

        if (nums[index] == target)
            return index;
        else
            return -1;

    }

    public static void main(String[] args) {
        int[] input = {5,7,7,8,8,10}, input2 = {};
        int target = 8, target2 = 6, target3 = 0;
        int[] answer = {3,4}, answer2 = {-1,-1}, answer3 = {-1,-1};

        System.out.println("Result: " + Arrays.toString(searchRange(input, target)));
        System.out.println("Answer: " + Arrays.toString(answer) + "\n");
        System.out.println("Result: " + Arrays.toString(searchRange(input, target2)));
        System.out.println("Answer: " + Arrays.toString(answer2) + "\n");
        System.out.println("Result: " + Arrays.toString(searchRange(input2, target3)));
        System.out.println("Answer: " + Arrays.toString(answer3) + "\n");
    }
}
