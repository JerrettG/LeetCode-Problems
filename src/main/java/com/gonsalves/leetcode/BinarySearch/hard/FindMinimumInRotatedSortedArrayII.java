package com.gonsalves.leetcode.BinarySearch.hard;

public class FindMinimumInRotatedSortedArrayII {

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            mid = low + (high-low)/2;

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                min = Math.min(min, nums[mid]);
                low++;
                high--;
            }

            else if (nums[low] <= nums[mid]) {
                if (nums[low] < min && min <= nums[mid] ) {
                    high = mid-1;
                    min = Math.min(min, nums[low]);
                }
                else {
                    min = Math.min(min, nums[low]);
                    low = mid+1;
                }
            }
            else {
                if (nums[mid] > min && min <= nums[high]) {
                    low = mid+1;
                    min = Math.min(min, nums[mid]);
                }
                else {
                    high = mid-1;
                    min = Math.min(min, nums[mid]);
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {

    }
}
