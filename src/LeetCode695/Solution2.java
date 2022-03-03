package LeetCode695;

import java.util.HashSet;

/**
 * @author Chanmoey
 * @date 2022年03月03日
 */
class Solution2 {

    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int m, n;
    private int[][] grid;

    private boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        this.m = grid.length;
        if (this.m == 0) {
            return 0;
        }
        this.n = grid[0].length;
        if (this.n == 0) {
            return 0;
        }

        this.grid = grid;

        int res = 0;
        this.visited = new boolean[this.m][this.n];
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (!visited[i][j] & grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j));
                }
            }
        }

        return res;
    }

    private int dfs(int x, int y) {
        this.visited[x][y] = true;
        int res = 1;
        for (int d = 0; d < 4; d++) {
            int newX = x + dirs[d][0];
            int newY = y + dirs[d][1];
            if (this.inArea(newX, newY) && !visited[newX][newY] && this.grid[newX][newY] == 1) {
                res += dfs(newX, newY);
            }
        }

        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }
}

