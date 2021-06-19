package LeetCode63;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        for (int y = n - 1; y >= 0; y--) {
            for (int x = m - 1; x >= 0; x--) {

                if (obstacleGrid[x][y] == 1) {
                    dp[x][y] = 0;
                } else {
                    if (x + 1 < m && y + 1 < n) {
                        dp[x][y] = dp[x + 1][y] + dp[x][y + 1];
                    } else if (x + 1 < m && y + 1 >= n) {
                        dp[x][y] = dp[x + 1][y];
                    } else if (x + 1 >= m && y + 1 < n){
                        dp[x][y] = dp[x][y + 1];
                    }
                }
            }
        }

        return dp[0][0];
    }
}
