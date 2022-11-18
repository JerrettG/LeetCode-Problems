package com.gonsalves.leetcode.BinarySearch.easy;

public class BinarySearch {
/*
    Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
        Input: nums = [-1,0,3,5,9,12], target = 9
        Output: 4
        Explanation: 9 exists in nums and its index is 4

    Example 2:
        Input: nums = [-1,0,3,5,9,12], target = 2
        Output: -1
        Explanation: 2 does not exist in nums so return -1


    Constraints:

    1 <= nums.length <= 104
    -104 < nums[i], target < 104
    All the integers in nums are unique.
    nums is sorted in ascending order.
 */
    public static int search(int[]nums, int target) {
        int high = nums.length-1;
        int low = 0;
        int mid;
        while (low <= high) {
            mid = (high+low)/2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[1000];
        for (int i = 0; i < nums.length; i++)
            nums[i] = i;
        int target = (int) (Math.random() * 1001);
        System.out.println("Target: " + target);

        System.out.println(search(nums, target));
    }
}
