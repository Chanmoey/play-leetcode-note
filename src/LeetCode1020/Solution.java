package LeetCode1020;

/**
 * @author Chanmoey
 * @date 2022年03月12日
 */
class Solution {

    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int[][] grid;
    int m, n;

    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (i == 0 || i == this.m - 1 || j == 0 || j == this.n - 1) {
                    if (this.grid[i][j] == 1) {
                        floodFill(i, j);
                    }
                }
            }
        }

        return this.landNumber();
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }

    private void floodFill(int x, int y) {
        this.grid[x][y] = 0;

        for (int[] dir : DIRS) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (this.inArea(nextX, nextY) && this.grid[nextX][nextY] == 1) {
                floodFill(nextX, nextY);
            }
        }
    }

    private int landNumber() {
        int res = 0;
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.grid[i][j] == 1) {
                    res++;
                }
            }
        }

        return res;
    }
}
