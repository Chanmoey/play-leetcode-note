package LeetCode980;

class Solution1 {

    private int[][] graph;
    private static final int[][] D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] isVisited;
    private int m;
    private int n;
    private int start;
    private int end;

    public int uniquePathsIII(int[][] grid) {
        this.graph = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.isVisited = new boolean[this.m][this.n];
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

        return this.floodFill(start, left);
    }

    private int floodFill(int start, int left) {

        int x = start / this.n;
        int y = start % this.n;

        this.isVisited[x][y] = true;
        left--;
        if (left == 0 && start == this.end) {
            this.isVisited[x][y] = false;
            return 1;
        }

        int res = 0;
        for (int[] d : D) {
            int newX = x + d[0];
            int newY = y + d[1];
            if (this.inArea(newX, newY) && !this.isVisited[newX][newY]
                    && this.graph[newX][newY] == 0) {
                res += floodFill(newX * this.n + newY, left);
            }
        }
        this.isVisited[x][y] = false;
        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }
}
