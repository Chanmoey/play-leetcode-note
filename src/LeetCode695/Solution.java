package LeetCode695;

/**
 * @author Chanmoey
 * @date 2022年01月08日
 */
class Solution {

    private int maxArea = 0;
    private int m, n;
    private int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.grid[i][j] == 1) {
                    int item = this.floodFill(i, j);
                    this.maxArea = Math.max(this.maxArea, item);
                }
            }
        }

        return this.maxArea;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }

    private int floodFill(int x, int y) {
        if (!inArea(x, y) || this.grid[x][y] == 0) {
            return 0;
        }

        this.grid[x][y] = 0;
        int area = 1;
        area += floodFill(x + 1, y);
        area += floodFill(x - 1, y);
        area += floodFill(x, y + 1);
        area += floodFill(x, y - 1);
        return area;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxAreaOfIsland(new int[][]{{1, 0, 1}, {1, 1, 1}, {0, 0, 1}}));
    }
}
