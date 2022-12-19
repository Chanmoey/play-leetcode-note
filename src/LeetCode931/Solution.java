package LeetCode931;

/**
 * @author Chanmoey
 * @date 2022年12月13日
 */
class Solution {

    private int m;
    private int n;

    public int minFallingPathSum(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;

        if (m == 1 || n == 1) {
            return matrix[0][0];
        }

        Integer[][] dp = new Integer[m][n];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            ans = Math.min(ans, minFallingPathSum(matrix, 0, i, dp));
        }

        return ans;
    }

    private int minFallingPathSum(int[][] matrix, int row, int col, Integer[][] dp) {

        if (dp[row][col] != null) {
            return dp[row][col];
        }

        // 到底了
        if (row == n - 1) {
            return dp[row][col] = matrix[row][col];
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if (col > 0) {
            left = minFallingPathSum(matrix, row + 1, col - 1, dp);
        }

        int straight = minFallingPathSum(matrix, row + 1, col, dp);

        if (col < n - 1) {
            right = minFallingPathSum(matrix, row + 1, col + 1, dp);
        }

        dp[row][col] = Math.min(left, Math.min(straight, right)) + matrix[row][col];

        return dp[row][col];
    }
}
