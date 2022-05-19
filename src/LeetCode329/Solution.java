package LeetCode329;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年05月19日
 */
class Solution {

    private int m;
    private int n;
    private int[][] matrix;
    private int[][] dp;

    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        this.m = matrix.length;
        if (this.m == 0) {
            return 0;
        }
        this.n = matrix[0].length;
        if (this.n == 0) {
            return 0;
        }

        this.matrix = matrix;
        this.dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int res = 1;
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (dp[i][j] == -1) {
                    res = Math.max(res, dfs(i, j));
                }
            }
        }

        return res;
    }

    private int dfs(int x, int y) {
        if (this.dp[x][y] != -1) {
            return this.dp[x][y];
        }

        int res = 1;
        for (int[] d : DIRS) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            if (this.inArea(nextX, nextY) && this.matrix[nextX][nextY] > this.matrix[x][y]) {
                res = Math.max(res, 1 + dfs(nextX, nextY));
            }
        }
        this.dp[x][y] = res;

        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }
}
