package LeetCode200;

class Solution {

    private boolean[][] visited;
    private int m, n;
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    public int numIslands(char[][] grid) {

        this.m = grid.length;
        if (m == 0) {
            return 0;
        }
        this.n = grid[0].length;
        this.visited = new boolean[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !this.visited[i][j]) {
                    res++;
                    this.floodFill(grid, i, j);
                }
            }
        }

        return res;

    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }

    private void floodFill(char[][] grid, int x, int y) {

        this.visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + this.d[i][0];
            int newY = y + this.d[i][1];
            if (this.inArea(newX, newY) && !this.visited[newX][newY] && grid[newX][newY] == '1') {
                this.floodFill(grid, newX, newY);
            }
        }
    }
}
