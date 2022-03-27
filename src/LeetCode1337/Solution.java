package LeetCode1337;

import java.util.PriorityQueue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }

            return a[0] - b[0];
        });

        for (int i = 0; i < mat.length; i++) {
            int soldier = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    soldier++;
                }
            }
            minHeap.add(new int[]{soldier, i});
        }

        for (int i = 0; i < k && !minHeap.isEmpty(); i++) {
            res[i] = minHeap.poll()[1];
        }

        return res;
    }
}
