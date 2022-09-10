package LeetCode188;

/**
 * @author Chanmoey
 * @date 2022年09月10日
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0) {
            return 0;
        }

        int[][] dp = new int[k+1][2];
        for (int i = 0; i <= k; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }

        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                dp[i][0] = Math.min(dp[i][0], price - dp[i-1][1]);
                dp[i][1] = Math.max(dp[i][1], price - dp[i][0]);
            }
        }

        return dp[k][1];
    }
}
