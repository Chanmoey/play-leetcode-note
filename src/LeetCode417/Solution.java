package LeetCode417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private int m, n;
    private final int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> res = new ArrayList<>();
        this.m = heights.length;
        if (this.m == 0) {
            return res;
        }
        this.n = heights[0].length;

        boolean[][] pacific = new boolean[this.m][this.n];
        boolean[][] atlantic = new boolean[this.m][this.n];

        for (int i = 0; i < this.m; i++) {
            this.floodFill(heights, pacific, i, 0);
            this.floodFill(heights, atlantic, i, this.n - 1);
        }

        for (int j = 0; j < this.n; j++) {
            this.floodFill(heights, pacific, 0, j);
            this.floodFill(heights, atlantic, m - 1, j);
        }

        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;

    }

    private void floodFill(int[][] heights, boolean[][] visited, int x, int y) {

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (this.inArea(newX, newY) && !visited[newX][newY] && heights[newX][newY] >= heights[x][y]) {
                this.floodFill(heights, visited, newX, newY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }
}
