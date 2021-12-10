package LeetCode790;

/**
 * @author Chanmoey
 * @date 2021年12月10日 17:20
 * @description 参考discuss中的解法。
 * https://leetcode.com/problems/domino-and-tromino-tiling/discuss/1620735/JAVA-or-DP-or-Detailed-Explanation-Using-Image
 */
class Solution {
    public int numTilings(int n) {
        int[] dp = new int[n + 4];
        int mod = (int) (Math.pow(10, 9) + 7);

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int i = 4; i <= n; i++) {
            dp[i] = ((2 * dp[i - 1]) % mod) + dp[i - 3];
            dp[i] %= mod;
        }

        return dp[n];
    }
}
