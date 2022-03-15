package LeetCode934;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chanmoey
 * @date 2022年03月15日
 */
class Solution1 {
    int m, n;
    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;


        Queue<int[]> q = new LinkedList<>();
        boolean found = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    capture(grid, i, j, q);
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        while (!q.isEmpty()) {
            int len = q.size();
            while (len > 0) {
                int[] point = q.poll();
                int r = point[0];
                int c = point[1];

                for (int[] d : DIRS) {
                    int nextR = r + d[0];
                    int nextC = c + d[1];

                    if (this.inArea(nextR, nextC) && grid[nextR][nextC] != -1) {
                        if (grid[nextR][nextC] == 1) {
                            return point[2];
                        } else {
                            grid[nextR][nextC] = -1;
                        }

                        q.offer(new int[]{nextR, nextC, point[2] + 1});
                    }
                }
                len--;
            }
        }

        return -1;
    }

    private void capture(int[][] grid, int r, int c, Queue<int[]> q) {
        if (!this.inArea(r, c) || grid[r][c] <= 0) {
            return;
        }

        grid[r][c] = -1;
        q.offer(new int[]{r, c, 0});

        for (int[] d : DIRS) {
            int row = r + d[0];
            int col = c + d[1];
            capture(grid, row, col, q);
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }
}
