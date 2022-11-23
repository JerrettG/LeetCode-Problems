package com.gonsalves.leetcode.TwoPointers.medium;

import java.util.Arrays;

public class TwoSumII {
    /*
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
    
    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
    
    The tests are generated such that there is exactly one solution. You may not use the same element twice.
    
    Your solution must use only constant extra space.
    
     
    
    Example 1:
        Input: numbers = [2,7,11,15], target = 9
        Output: [1,2]
        Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

    Example 2:
        Input: numbers = [2,3,4], target = 6
        Output: [1,3]
        Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

    Example 3:
        Input: numbers = [-1,0], target = -1
        Output: [1,2]
        Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

    Constraints:
        2 <= numbers.length <= 3 * 104
        -1000 <= numbers[i] <= 1000
        numbers is sorted in non-decreasing order.
        -1000 <= target <= 1000
        The tests are generated such that there is exactly one solution.
     */

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int sum = numbers[left] + numbers[right];
        while (sum != target) {
            if (sum > target)
                right--;
            else
                left++;
            sum = numbers[left] + numbers[right];
        }
        return new int[] {left+1, right+1};
    }

    public static void main(String[] args) {
        int[] input1 = {2,7, 11, 15};
        int[] answer1 = {1,2};
        int target1 = 9;
        int[] result1 = twoSum(input1, target1);

        int[] input2 = {2,3, 4};
        int[] answer2 = {1,3};
        int target2 = 6;
        int[] result2 = twoSum(input2, target2);

        int[] input3 = {-1,0};
        int[] answer3 = {1,2};
        int target3 = -1;
        int[] result3 = twoSum(input3, target3);
        System.out.println("TEST 1");
        System.out.println("Input:  " + Arrays.toString(input1));
        System.out.println("Result: " + Arrays.toString(result1));
        System.out.println("Answer: " + Arrays.toString(answer1));
        System.out.println("Passed: " + Arrays.equals(result1, answer1)+ "\n");

        System.out.println("TEST 2");
        System.out.println("Input:  " + Arrays.toString(input2));
        System.out.println("Result: " + Arrays.toString(result2));
        System.out.println("Answer: " + Arrays.toString(answer2));
        System.out.println("Passed: " + Arrays.equals(result2, answer2)+ "\n");

        System.out.println("TEST 3");
        System.out.println("Input:  " + Arrays.toString(input3));
        System.out.println("Result: " + Arrays.toString(result3));
        System.out.println("Answer: " + Arrays.toString(answer3));
        System.out.println("Passed: " + Arrays.equals(result3, answer3));


    }
}
