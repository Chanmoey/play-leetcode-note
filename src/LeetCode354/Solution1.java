package LeetCode354;

import java.util.Arrays;

/**
 * Time Limit Exceeded!!!
 *
 * @author Chanmoey
 * @date 2022年05月25日
 */
class Solution1 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    break;
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
