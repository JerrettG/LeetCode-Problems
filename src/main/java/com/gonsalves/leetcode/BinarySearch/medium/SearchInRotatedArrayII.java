package com.gonsalves.leetcode.BinarySearch.medium;

import java.util.Arrays;

public class SearchInRotatedArrayII {
    /*
    There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

    Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

    Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

    You must decrease the overall operation steps as much as possible.

    Example 1:
        Input: nums = [2,5,6,0,0,1,2], target = 0
        Output: true

    Example 2:
        Input: nums = [2,5,6,0,0,1,2], target = 3
        Output: false

    Constraints:
        1 <= nums.length <= 5000
        -104 <= nums[i] <= 104
        nums is guaranteed to be rotated at some pivot.
        -104 <= target <= 104


    Follow up:
    This problem is similar to Search in Rotated Sorted Array, but nums may contain duplicates.
    Would this affect the runtime complexity? How and why?
     */

    /**
     * This method uses a modified binary search in order to determine if the target value is contained in the input array, nums.
     * Nums is a sorted array that has been rotated by an unknown amount.
     * @param nums the sorted input array AFTER it has been rotated that contains duplicates
     * @param target the value we are searching for in the input array
     * @return true if target is in nums, false otherwise.
     */
    public static boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid;

        while (low <= high) {
            mid = low +(high-low) /2;
            if (nums[mid] == target)
                return true;
            //We don't know which side to search so we just have to move our low and high pointers inwards
            if (nums[mid] == nums[high] && nums[mid] == nums[low]) {
                high--;
                low++;
            }
            //Array looks something like this [4,5,6,|7|,0,1,2] where |7| is nums[mid]
            else if (nums[mid] >= nums[low]) {
                //We need to search the left side because low < Target and the Target < mid | low Target  mid   high
                if (nums[low] <= target && target < nums[mid])
                    high = mid-1;
                //We need to search right side because mid > low but target > mid | low  mid Target  high
                else
                    low = mid+1;
            }
            //Array looks something like this [7,0,1,|2|,4,5,6] where |2| is nums[mid]
            else {
                //We need to search the right side because
                if (target > nums[mid]&& target <= nums[high])//l    m  T  h
                    low = mid +1;
                else
                    high = mid-1;                             //l T  m     h
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[] input1n2 = {2,5,6,0,0,1,2}, input3 = {1,0,1,1,1}, input4 = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        int target = 0, target2 = 3, target3 = 0, target4= 2;
        boolean answer = true, answer2 = false, answer3 = true, answer4 = true;

        System.out.println("Input: nums = " + Arrays.toString(input1n2) + ", target = " + target);
        System.out.println("Result: " + search(input1n2, target));
        System.out.println("Answer: " + answer + "\n");

        System.out.println("Input: nums = " + Arrays.toString(input1n2) + ", target = " + target2);
        System.out.println("Result: " + search(input1n2, target2));
        System.out.println("Answer: " + answer2 + "\n");

        System.out.println("Input: nums = " + Arrays.toString(input3) + ", target = " + target3);
        System.out.println("Result: " + search(input3, target3));
        System.out.println("Answer: " + answer3 + "\n");

        System.out.println("Input: nums = " + Arrays.toString(input4) + ", target = " + target4);
        System.out.println("Result: " + search(input4, target4));
        System.out.println("Answer: " + answer4 + "\n");
    }
}
