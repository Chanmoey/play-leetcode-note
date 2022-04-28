package LeetCode1631;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Chanmoey
 * @date 2022年04月28日
 */
class Solution {

    private static final int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        if (m == 1 && n == 1) {
            return 0;
        }

        int[][] efforts = new int[m][n];
        for (int[] arr : efforts) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        queue.add(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int effort = cur[2];

            for (int[] dir : DIR) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                    continue;
                }

                int newEffort = Math.max(effort, Math.abs(heights[newX][newY] - heights[x][y]));

                if (newEffort < efforts[newX][newY]) {
                    efforts[newX][newY] = newEffort;
                    queue.add(new int[]{newX, newY, newEffort});
                }
            }
        }

        return efforts[m - 1][n - 1];
    }
}
