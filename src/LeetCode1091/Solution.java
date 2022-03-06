package LeetCode1091;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chanmoey
 * @date 2022年03月03日
 */
class Solution {
    private static final int[][] DIR = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    private int[][] grid;
    private boolean[][] visited;
    private int m, n;

    public int shortestPathBinaryMatrix(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[this.m][this.n];

        if (grid[0][0] == 1) {
            return -1;
        }

        if (this.m == 1 && this.n == 1) {
            return 1;
        }

        return bfs();
    }

    private int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        this.visited[0][0] = true;

        int[] cur;
        while (!queue.isEmpty()) {
            cur = queue.remove();
            for (int[] ints : DIR) {
                int nextX = cur[0] + ints[0];
                int nextY = cur[1] + ints[1];
                if (this.inArea(nextX, nextY) && this.grid[nextX][nextY] == 0 && !this.visited[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY, cur[2] + 1});
                    this.visited[nextX][nextY] = true;

                    if (nextX == this.m - 1 && nextY == this.n - 1) {
                        return cur[2] + 1;
                    }
                }
            }
        }

        return -1;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }
}
