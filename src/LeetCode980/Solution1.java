package LeetCode980;

import java.util.Arrays;

class Solution1 {

    private int[][] graph;
    private static final int[][] D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m;
    private int n;
    private int start;
    private int end;

    public int uniquePathsIII(int[][] grid) {
        this.graph = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        int left = this.m * this.n;

        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (grid[i][j] == 1) {
                    this.start = i * this.n + j;
                    this.graph[i][j] = 0;
                } else if (grid[i][j] == 2) {
                    this.end = i * this.n + j;
                    this.graph[i][j] = 0;
                } else if (grid[i][j] == -1) {
                    left--;
                }
            }
        }

        int visited = 0;
        return this.floodFill(visited, start, left);
    }

    private int floodFill(int visited, int v, int left) {

        visited += (1 << v);
        left--;
        if (left == 0 && v == this.end) {
            return 1;
        }

        int x = v / this.n;
        int y = v % this.n;
        int res = 0;
        for (int[] d : D) {
            int newX = x + d[0];
            int newY = y + d[1];
            int next = newX * this.n + newY;
            if (this.inArea(newX, newY) && (visited & (1 << next)) == 0
                    && this.graph[newX][newY] == 0) {
                res += floodFill(visited, next, left);
            }
        }

        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }
}
