package LeetCode85;

/**
 * @author Chanmoey
 * @date 2021年11月30日 8:31
 * @description 动态规划。
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int R = matrix.length, C = matrix[0].length;

        int[][] dp = new int[R][C];

        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
            for (int j = 1; j < C; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = dp[i][j - 1] + 1;
                }
            }
        }

        int res = this.max(dp[0]);

        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int w = dp[i][j];
                for (int k = i; k >= 0; k--) {
                    w = Math.min(w, dp[k][j]);
                    res = Math.max(res, w * (i - k + 1));
                }
            }
        }

        return res;
    }

    private int max(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int j : arr) {
            max = Math.max(j, max);
        }

        return max;
    }
}
