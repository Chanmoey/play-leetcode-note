package LeetCode934;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 错误解法！！！错误原因：只考虑了单独的land，没有整体考虑island。
 *
 * @author Chanmoey
 * @date 2022年03月15日
 */
class Solution {

    /**
     * Java17可以改为record
     */
    static class Pair {
        private final int level;
        private final int[] position;

        public Pair(int level, int[] position) {
            this.level = level;
            this.position = position;
        }
    }

    private int shortest = Integer.MAX_VALUE;
    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;
    private int[][] grid;

    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (grid[i][j] == 1) {
                    Queue<Pair> queue = new LinkedList<>();
                    queue.add(new Pair(0, new int[]{i, j}));
                    boolean[][] visited = new boolean[this.m][this.n];
                    visited[i][j] = true;
                    this.findBridge(queue, visited);
                }
            }
        }

        return this.shortest;
    }

    private void findBridge(Queue<Pair> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int[] position = cur.position;
            int level = cur.level;

            int x = position[0];
            int y = position[1];
            for (int[] dir : DIRS) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (this.inArea(nextX, nextY) && !visited[nextX][nextY]) {
                    if (this.grid[nextX][nextY] == 1) {
                        this.shortest = Math.min(this.shortest, level);
                        return;
                    } else {
                        queue.add(new Pair(level + 1, new int[]{nextX, nextY}));
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }
}
