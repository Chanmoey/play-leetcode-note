package LeetCode1254;

/**
 * @author Chanmoey
 * @date 2022年03月11日
 */
class Solution {

    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int[][] grid;
    int m, n, res;

    public int closedIsland(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.res = 0;

        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (grid[i][j] == 0) {
                    if (floodFill(i, j)) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    private boolean floodFill(int x, int y) {
        if (x < 0 || y < 0 || x >= this.m || y >= this.n) {
            return false;
        }

        if (grid[x][y] == 1) {
            return true;
        }

        this.grid[x][y] = 1;
        boolean res = true;

        for (int[] dir : DIRS) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            res &= floodFill(nextX, nextY);
        }

        return res;
    }
}
