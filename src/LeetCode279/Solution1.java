package LeetCode279;

import java.util.Arrays;

/**
 * 动态规划的解题方法
 * */
class Solution1 {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; ; j++) {
                int item = i - j * j;

                if (item < 0) {
                    break;
                } else if (item == 0) {
                    memo[i] = 1;
                } else {
                    memo[i] = Math.min(memo[i], memo[item] + 1);
                }
            }
        }

        return memo[n];
    }
}
