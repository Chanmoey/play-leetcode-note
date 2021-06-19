package LeetCode70;



class Solution {

    private int[] memo;

    /**
     *  动态规划
     * */
    public int climbStairs(int n) {
        this.memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }

    /**
     * 自顶向下的记忆化搜索
     * */
    private int bfs(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (memo[n] == -1) {
            memo[n] = this.bfs(n - 1) + this.bfs(n - 2);
        }

        return memo[n];
    }
}
