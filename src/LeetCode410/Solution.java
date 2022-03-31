package LeetCode410;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年03月31日
 */
class Solution {

    private int n;

    public int splitArray(int[] nums, int m) {
        this.n = nums.length;
        long[] pre = new long[this.n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return dfs(m - 1, 0, pre, dp);
    }

    private int dfs(int m, int start, long[] pre, int[][] dp) {
        if (dp[m][start] != -1) {
            return dp[m][start];
        }
        if (m == 0) {
            return dp[m][start] = (int) (pre[n] - pre[start]);
        }

        int res = Integer.MAX_VALUE;
        for (int i = start; i + m < n; i++) {
            res = Math.min(res, Math.max((int) (pre[i + 1] - pre[start]), dfs(m - 1, i + 1, pre, dp)));
        }
        return dp[m][start] = res;
    }
}
