package com.gonsalves.leetcode.TwoPointers.medium;

import java.util.Arrays;

public class ContainerWithMostWater {
    /**
     * This method uses a two pointer approach to be able to calculate the maximum amount of water a container of
     * height[i] * n will hold. This method starts with a pointer at the leftmost and rightmost sides. The area is calculated
     * and compared to the maxArea while the pointers work towards the center. The pointer with the smallest height[i]
     * value will progress inwards. If their values are equal, both pointers move inwards
     * @param height The input array of heights
     * @return the maximum area of a container with an area of height[i] * n
     */
    public static int maxArea(int[] height) {
        //area is equal to n * height where height is Math.min(leftValue, rightValue) and n is rightIndex-leftIndex
        // Array is atleast size 2;

        int maxArea = 0;
        int left = 0;
        int right = height.length-1;
        // [2, 2, 5, 7, 6]
        //  L           R   area = 8
        //     L        R   area = 6
        //        L     R   area = 10
        //           L  R   area = 6
        // [1, 8, 6, 2, 5, 4, 8, 3, 7]
        //  L                       R  area = 8
        //     L                    R  area = 49
        //     L                 R     area = 18
        //     L              R        area = 40,
        //     L1 L2       R1 R2       area = 16, 24
        //     L1    L2 R1    R2       area = 15, 6
        //     L1    R1 L2    R2       area = 4, 10
        //     L1 R1       L2 R2       area = 6, 4



        while (left < right) {
            int area = (right-left)*Math.min(height[left], height[right]);
            if (area > maxArea)
                maxArea = area;
            if (height[left] > height[right])
                right--;
            else if (height[left] < height[right])
                left++;
            else {
                right--;
                left++;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] input1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int answer1 = 49;
        int result1 = maxArea(input1);
        int[] input2 = {2,3,4,5,18,17,6};
        int answer2 = 17;
        int result2 = maxArea(input2);

        System.out.println("Input:  "+ Arrays.toString(input1));
        System.out.println("Result: " + result1);
        System.out.println("Answer: " + answer1);
        System.out.println("Passed: " + (result1 == answer1) + "\n");

        System.out.println("Input:  "+ Arrays.toString(input2));
        System.out.println("Result: " + result2);
        System.out.println("Answer: " + answer2);
        System.out.println("Passed: " + (result2 == answer2));
    }
}
