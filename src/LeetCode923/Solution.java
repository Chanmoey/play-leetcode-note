package LeetCode923;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Arrays;

/**
 * Time Limit Exceeded
 *
 * @author Chanmoey
 * @date 2022年04月06日
 */
class Solution {

    private static final int MOD = 1000000007;
    private final int[][][] dp = new int[3001][301][4];

    public int threeSumMulti(int[] arr, int target) {
        for (int i = 0; i < this.dp.length; i++) {
            for (int j = 0; j < this.dp[0].length; j++) {
                for (int k = 0; k < this.dp[0][0].length; k++) {
                    this.dp[i][j][k] = -1;
                }
            }
        }

        return search(arr, arr.length, 0, 3, target);
    }

    private int search(int[] arr, int n, int idx, int count, int target) {
        if (count == 0) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (idx >= n) {
            return 0;
        }

        if (target < 0 || count < 0) {
            return 0;
        }

        if (this.dp[idx][target][count] != -1) {
            return dp[idx][target][count];
        }

        int ans = 0;
        ans += search(arr, n, idx + 1, count - 1, target - arr[idx]);
        ans %= MOD;
        ans += search(arr, n, idx + 1, count, target);
        return this.dp[idx][target][count] = ans % MOD;
    }
}