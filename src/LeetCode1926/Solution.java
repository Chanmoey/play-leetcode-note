package LeetCode1926;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chanmoey
 * @date 2022年03月15日
 */
class Solution {

    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;

    public int nearestExit(char[][] maze, int[] entrance) {
        this.m = maze.length;
        this.n = maze[0].length;
        boolean[][] visited = new boolean[this.m][this.n];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, entrance[0], entrance[1]});
        visited[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int step = cur[0];
            int x = cur[1];
            int y = cur[2];

            for (int[] dir : DIRS) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                if (this.inArea(nextX, nextY)) {
                    if (!visited[nextX][nextY] && maze[nextX][nextY] == '.') {
                        if (this.inFringe(nextX, nextY)) {
                            return step + 1;
                        } else {
                            queue.add(new int[]{step + 1, nextX, nextY});
                            visited[nextX][nextY] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.m && y >= 0 && y < this.n;
    }

    private boolean inFringe(int x, int y) {
        return x == 0 || x == this.m - 1 || y == 0 || y == this.n - 1;
    }
}
