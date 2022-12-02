package com.gonsalves.leetcode.DepthFirstSearch.medium;

import java.util.Arrays;

public class MaxAreaOfIsland {
/*
    You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

    The area of an island is the number of cells with a value 1 in the island.

    Return the maximum area of an island in grid. If there is no island, return 0.



    Example 1:
        Input: grid =
            [
                [0,0,1,0,0,0,0,1,0,0,0,0,0],
                [0,0,0,0,0,0,0,1,1,1,0,0,0],
                [0,1,1,0,1,0,0,0,0,0,0,0,0],
                [0,1,0,0,1,1,0,0,1,0,1,0,0],
                [0,1,0,0,1,1,0,0,1,1,1,0,0],
                [0,0,0,0,0,0,0,0,0,0,1,0,0],
                [0,0,0,0,0,0,0,1,1,1,0,0,0],
                [0,0,0,0,0,0,0,1,1,0,0,0,0]
            ]
        Output: 6
        Explanation: The answer is not 11, because the island must be connected 4-directionally.

    Example 2:
        Input: grid = [[0,0,0,0,0,0,0,0]]
        Output: 0

    Constraints:
        m == grid.length
        n == grid[i].length
        1 <= m, n <= 50
        grid[i][j] is either 0 or 1.
 */

    /**
     * This method uses depth-first search in order to find the max area of an island within an m x n binary matrix with
     * the assumption that all four areas surrounding the grid are water. This method has a memory complexity of O(m * n)
     * because of the use of the visited matrix which keeps track of the visited elements in the matrix. This solution can
     * be improved to a memory complexity of O(1) (disregarding the recursive calls) by altering the original matrix to use
     * a value that represents the element as having been visited such as -
     * @param grid the grid which we will find the max area of an island for
     * @return the max area of an island in grid
     */

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        //Iterate through each item in the grid
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {
                //check to see if the element in grid[][] is in our visited[][] matrix
                if (visited[i][j])
                    continue;
                //every grid[][] we visit we must put into the visited[][] matrix
                visited[i][j] = true;


                //when we find a 1, use depth first search to find it's area
                if (grid[i][j] == 1) {
                    int islandArea = findAreaOfIsland(grid, visited, i, j);
                    maxArea = Math.max(islandArea, maxArea);
                }
            }
        }
        return maxArea;
    }

    private static int findAreaOfIsland(int[][] grid, boolean[][] visited, int row, int column) {
        int area = 0;

        //base case
        visited[row][column] = true;
        area++;

        //recursive case
        //check right
        if (column < grid[row].length-1 && !visited[row][column+1] && grid[row][column+1] == 1)
            area += findAreaOfIsland(grid, visited, row, column+1);
        //check bottom
        if (row < grid.length-1 && !visited[row+1][column] && grid[row+1][column] == 1)
            area += findAreaOfIsland(grid, visited, row+1, column);
        //check left
        if (column > 0 && !visited[row][column-1] && grid[row][column-1] == 1)
            area += findAreaOfIsland(grid, visited, row, column-1);
        //check top
        if (row > 0 && !visited[row-1][column] && grid[row-1][column] == 1)
            area += findAreaOfIsland(grid, visited, row-1, column);

        return area;
    }

    /*
    This code snippet is the recursive method that uses a memory complexity of O(1)

    private static int findAreaOfIsland(int[][] grid, int row, int column) {
        int area = 0;

        //base case
        grid[row][column] = 0;
        area++;

        //recursive case
        //check right
        if (column < grid[row].length-1  && grid[row][column+1] == 1)
            area += findAreaOfIsland(grid, visited, row, column+1);
        //check bottom
        if (row < grid.length-1  && grid[row+1][column] == 1)
            area += findAreaOfIsland(grid, visited, row+1, column);
        //check left
        if (column > 0 && grid[row][column-1] == 1)
            area += findAreaOfIsland(grid, visited, row, column-1);
        //check top
        if (row > 0 && grid[row-1][column] == 1)
            area += findAreaOfIsland(grid, visited, row-1, column);

        return area;
    }
     */



    public static void main(String[]args) {
        int[][] input = new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        int expected = 6;
        int actual = maxAreaOfIsland(input);
        System.out.println("Input:  ");
        Arrays.stream(input).forEach(row -> System.out.println(Arrays.toString(row)));
        System.out.println("Actual: " + actual);
        System.out.println("Expected: " +expected);

        int[][] input2 = new int[][] {{0,0,0,0,0,0,0,0}};
        expected = 0;
        actual = maxAreaOfIsland(input2);

        System.out.println("\nInput:  ");
        Arrays.stream(input2).forEach(row -> System.out.println(Arrays.toString(row)));
        System.out.println("Actual: " + actual);
        System.out.println("Expected: " +expected);
    }
}
