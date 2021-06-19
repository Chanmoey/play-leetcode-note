package LeetCode64;

class Solution {

    private int m, n;

    public int minPathSum(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;

        // 循环遍历grid中的每一个数，然后将其更新为：自身的数 + min(左边的数，上边的数)
        // 这样grid的最右下角就是问题的解
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.inArea(i - 1, j) && this.inArea(i, j - 1)) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                } else if (this.inArea(i - 1, j) && !this.inArea(i, j - 1)) {
                    grid[i][j] += grid[i - 1][j];
                } else if (!this.inArea(i - 1, j) && this.inArea(i, j - 1)) {
                    grid[i][j] += grid[i][j - 1];
                }
                // else 左边与上边都越界，不处理
            }
        }

        return grid[m - 1][n - 1];
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }
}
