package LeetCode343;

import java.util.Arrays;

class Solution {

    private int[] memo;

    public int integerBreak(int n) {
        this.memo = new int[n + 1];
        Arrays.fill(this.memo, -1);
        return this.breakIntegerByDp(n);
    }

    private int maxInTreeNumber(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    /**
     * 自顶向下的记忆化搜索方式
     * 将 n 至少分割成两个部分，获得n的最大乘积
     */
    private int breakInteger(int n) {

        if (n == 1) {
            return 1;
        }

        int noNumber = -1;
        if (this.memo[n] != noNumber) {
            return this.memo[n];
        }

        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = this.maxInTreeNumber(res, i * (n - i), i * this.breakInteger(n - i));
        }
        this.memo[n] = res;
        return res;
    }

    /**
     * 自底向下的动态规划方式
     * */
    private int breakIntegerByDp(int n) {
        assert n >= 2;
        this.memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                this.memo[i] = this.maxInTreeNumber(this.memo[i], j * (i - j), j * this.memo[i - j]);
            }
        }

        return this.memo[n];
    }
}
