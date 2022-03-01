package LeetCode338;

/**
 * @author Chanmoey
 * @date 2022年03月01日
 */
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        int[] memo = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            res[i] = this.dp(i, memo);
        }

        return res;
    }

    private int dp(int n, int[] memo) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        if (n % 2 == 0) {
            memo[n] = dp(n / 2, memo);
        } else {
            memo[n] = 1 + dp(n / 2, memo);
        }
        return memo[n];
    }
}
