package LeetCode59;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年02月06日
 */
class Solution {

    private static final int[][] DIR = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] generateMatrix(int n) {
        int number = 1;
        int[][] matrix = new int[n][n];
        int end = n * n;
        int choseDir = 0;
        int x = 0, y = 0;
        int[] nowDir = DIR[choseDir % DIR.length];
        while (number <= end) {
            matrix[x][y] = number++;
            if (changeDir(matrix, x, y, nowDir)) {
                choseDir++;
            }
            nowDir = DIR[choseDir % DIR.length];
            x = x + nowDir[0];
            y = y + nowDir[1];
        }

        return matrix;
    }

    private boolean changeDir(int[][] matrix, int x, int y, int[] dir) {
        int newX = x + dir[0];
        int newY = y + dir[1];

        if (newX >= matrix.length || newX < 0
                || newY < 0 || newY >= matrix.length) {
            return true;
        }
        return matrix[newX][newY] != 0;
    }
}
