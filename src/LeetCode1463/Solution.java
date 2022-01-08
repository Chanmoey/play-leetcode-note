package LeetCode1463;

/**
 * @author Chanmoey
 * @date 2022年01月08日
 */
class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        int ret = this.dfs(0, 0, grid[0].length - 1, grid, dp);
        return Math.max(ret, 0);
    }

    private int dfs(int r1, int c1, int c2, int[][] arr, int[][][] dp) {
        if (c1 >= arr[0].length || c2 >= arr[0].length || c1 < 0 || c2 < 0) {
            return Integer.MIN_VALUE;
        }

        if (r1 == arr.length - 1) {
            return c1 != c2 ? arr[r1][c1] + arr[r1][c2] : arr[r1][c1];
        }

        if (dp[r1][c1][c2] != 0) {
            return dp[r1][c1][c2];
        }

        int cherries = 0;
        if (c1 == c2) {
            cherries += arr[r1][c1];
        } else {
            cherries += arr[r1][c1] + arr[r1][c2];
        }

        int maxValue = Integer.MIN_VALUE;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                maxValue = Math.max(maxValue, dfs(r1 + 1, c1 + i, c2 + j, arr, dp));
            }
        }

        cherries += maxValue;
        dp[r1][c1][c2] = cherries;
        return cherries;
    }
}
