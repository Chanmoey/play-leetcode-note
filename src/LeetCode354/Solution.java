package LeetCode354;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年05月25日
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            // 根据宽度从小到大排序，根据高度从高到低排序
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });

        int[] dp = new int[envelopes.length];
        int res = 0;
        for (int[] env : envelopes) {
            int height = env[1];
            int left = Arrays.binarySearch(dp, 0, res, height);
            if (left < 0) {
                left = -(left + 1);
            }
            if (left == res) {
                res++;
            }
            dp[left] = height;
        }

        return res;
    }
}
