package LeetCode1162;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chanmoey
 * @date 2022年03月13日
 */
class Solution {

    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int[][] grid;
    private boolean[][] visited;
    int m, n;

    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        this.m = grid.length;
        this.n = grid[0].length;

        this.grid = grid;
        this.visited = new boolean[this.m][this.n];
        return this.bfs();
    }

    private int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int res = -1;
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (grid[i][j] == 1) {
                    this.visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int[] d : DIRS) {
                int newX = d[0] + x;
                int newY = d[1] + y;

                if (this.inArea(newX, newY) && !visited[newX][newY]) {
                    this.visited[newX][newY] = true;
                    this.grid[newX][newY] = this.grid[x][y] + 1;
                    res = Math.max(res, grid[newX][newY]);
                    queue.add(new int[]{newX, newY});
                }
            }
        }

        return res < 0 ? -1 : res - 1;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }
}
