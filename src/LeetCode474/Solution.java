package LeetCode474;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        // 记录各字符串中含有的 ‘0’ 和 ‘1’ 的个数。
        int[] mCount = new int[strs.length], nCount = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    mCount[i]++;
                } else {
                    nCount[i]++;
                }
            }
        }

        int[][][] memo = new int[strs.length][m + 1][n + 1];
        for (int u = mCount[0]; u <= m; u++) {
            for (int v = nCount[0]; v <= n; v++) {
                memo[0][u][v] = 1;
            }
        }

        for (int i = 1; i < strs.length; i++) {
            for (int u = 0; u <= m; u++) {
                for (int v = 0; v <= n; v++) {
                    memo[i][u][v] = memo[i - 1][u][v];
                    if (u >= mCount[i] && v >= nCount[i]) {
                        memo[i][u][v] = Math.max(memo[i][u][v], 1 + memo[i - 1][u - mCount[i]][v - nCount[i]]);
                    }
                }
            }
        }

        return memo[strs.length - 1][m][n];
    }
}