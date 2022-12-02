package com.gonsalves.leetcode.DepthFirstSearch.easy;

import java.util.Arrays;

public class FloodFill {
    /*
    An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

    You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

    To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

    Return the modified image after performing the flood fill.

    Example 1:
        Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
        Output: [[2,2,2],[2,2,0],[2,0,1]]
        Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
        Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

    Example 2:
        Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
        Output: [[0,0,0],[0,0,0]]
        Explanation: The starting pixel is already colored 0, so no changes are made to the image.

    Constraints:
        m == image.length
        n == image[i].length
        1 <= m, n <= 50
        0 <= image[i][j], color < 216
        0 <= sr < m
        0 <= sc < n
     */

    /**
     * This method performs a flood fill on an image matrix starting at image[sr][sc] and will change the color of any
     * connecting pixels in its adjacent 4 directions, plus any pixes connecting to those pixels adjacently that have
     * the same starting color. It uses depth-first search in order to accomplish this by recursively calling itself with
     * varied inputs based on the different states of its adjacent pixels. The depth-first search ensures that every pixel
     * in one branch of the matrix that matches the original color is altered before moving on to the next branch.
     * @param image matrix of image to be altered
     * @param sr starting row
     * @param sc starting column
     * @param color new color
     * @return the altered matrix
     */
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (sr > image.length && sc > image[0].length) return image;
        if (image[sr][sc] == color) return image; //if new color is the same as current color that means image is already how it needs to be

        flood(image, sr, sc, color);

        return image;
    }

    private static void flood(int[][] image, int sr, int sc, int color) {
        /*We can change the color of the starting pixel we are on immediately when this method is called since
          anytime this method is called, it is checked that the pixel's color matches the initial color
        */
        int oldColor = image[sr][sc]; //oldColor == 0
        image[sr][sc] = color; // currentColor == 2

        if (sr < image.length - 1 && oldColor == image[sr + 1][sc]) {
            flood(image, sr + 1, sc, color);
        }

        if (sr > 0 && oldColor == image[sr - 1][sc]) {
            flood(image, sr - 1, sc, color);
        }

        if (sc < image[sr].length - 1 && oldColor == image[sr][sc + 1]) {
            flood(image, sr, sc + 1, color);
        }

        if (sc > 0 && oldColor == image[sr][sc - 1]) {
            flood(image, sr, sc - 1, color);
        }
    }



    public static void main(String[] args) {
        int[][] input = new int[][] {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        int[][] expected = new int[][] {
                {2,2,2},
                {2,2,0},
                {2,0,2}
        };

        System.out.print("INPUT: \n");
        Arrays.stream(input).forEach(row -> System.out.println(Arrays.toString(row)));
        int[][] result = floodFill(input, 1,1,2);
        System.out.print("\nACTUAL: \n");
        Arrays.stream(result).forEach(row -> System.out.println(Arrays.toString(row)));
        System.out.print("\nEXPECTED: \n");
        Arrays.stream(expected).forEach(row -> System.out.println(Arrays.toString(row)));

    }
}
