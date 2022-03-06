package LeetCode740;

/**
 * @author Chanmoey
 * @date 2022年03月05日
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;

        int[] sum = new int[n];
        int[] dp = new int[n];

        for (int num : nums) {
            sum[num] += num;
        }

        dp[0] = 0;
        dp[1] = sum[1];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + sum[i], dp[i - 1]);
        }

        return dp[n - 1];
    }
}