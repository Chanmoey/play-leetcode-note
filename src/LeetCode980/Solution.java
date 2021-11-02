package LeetCode980;

import java.util.Arrays;

class Solution {

    private static final int[][] D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] isVisited;
    private int res = 0;
    private int m;
    private int n;

    public int uniquePathsIII(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.isVisited = new boolean[this.m][this.n];
        int r = 0, c = 0;
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (grid[i][j] == 1) {
                    r = i;
                    c = j;
                }
            }
        }

        this.floodFill(grid, r, c);

        return res;
    }

    private void floodFill(int[][] grid, int x, int y) {

        if (grid[x][y] == 2) {
            if (this.isVisitedAll(grid)) {
                res++;
                return;
            }
        }

        if (grid[x][y] == -1) {
            return;
        }

        this.isVisited[x][y] = true;
        for (int[] d : D) {
            int newX = x + d[0];
            int newY = y + d[1];
            if (this.inArea(newX, newY) && !this.isVisited[newX][newY] &&
                    (grid[newX][newY] == 0 || grid[newX][newY] == 2)) {
                floodFill(grid, newX, newY);
            }
        }
        this.isVisited[x][y] = false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }

    /**
     * 判断是否所有的空节点都被访问过。
     * @param grid 参数
     * @return 结果
     */
    private boolean isVisitedAll(int[][] grid) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!this.isVisited[i][j] &&
                        grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
