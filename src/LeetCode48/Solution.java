package LeetCode48;

import java.util.Arrays;

/**
 * 多开一个二维数组。
 *
 * @author Chanmoey
 * @date 2022年02月06日
 */
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotMat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotMat[i][j] = matrix[n - 1 - j][i];
            }
        }

        for (int i = 0; i < n; i++) {
            System.arraycopy(rotMat[i], 0, matrix[i], 0, n);
        }
    }
}
