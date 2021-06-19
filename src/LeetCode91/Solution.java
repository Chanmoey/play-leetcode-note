package LeetCode91;

import java.util.Arrays;

class Solution {

    private int n = 0;
    private int[] dp;

    public int numDecodings(String s) {
        this.n = s.length();
        this.dp = new int[n];
        Arrays.fill(this.dp, -1);
        return this.dfs(s, 0);
    }

    private int dfs(String s, int start) {

        if (start >= s.length()) {
            return 1;
        }
        char zero = '0';
        if (s.charAt(start) == zero) {
            return 0;
        }
        int empty = -1;
        if (this.dp[start] != empty) {
            return this.dp[start];
        }

        int res =  dfs(s, start + 1);
        if (start + 1 < n && this.stringToInteger(s.substring(start, start + 2)) <= 26) {
            res += dfs(s, start + 2);
        }
        return this.dp[start] = res;
    }

    private int stringToInteger(String s) {
        return (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("06"));
    }
}
