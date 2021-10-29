package LeetCode994;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int fresh = 0, res = 0;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> deque = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    deque.add(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while (deque.size() > 0 && fresh > 0) {

            int k = deque.size();
            for (int i = 0; i < k; i++) {

                int[] rotten = deque.poll();
                assert rotten != null;
                int x = rotten[0];
                int y = rotten[1];

                for (int[] d : dir) {
                    int newX = x + d[0];
                    int newY = y + d[1];
                    if (newX >= 0 && newX < m &&
                            newY >= 0 && newY < n && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        fresh--;
                        deque.add(new int[]{newX, newY});
                    }
                }
            }

            res++;
        }

        return fresh > 0 ? -1 : res;
    }
}
