package LeetCode1260;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年04月11日
 */
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k = k % (m * n);

        int[] arr = new int[m * n];
        int idx = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                arr[idx++] = ints[j];
            }
        }

        arr = this.shiftArray(arr, k);
        List<List<Integer>> res = new ArrayList<>();
        idx = 0;
        for (int i = 0; i < m; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                res.get(i).add(arr[idx++]);
            }
        }

        return res;
    }

    private int[] shiftArray(int[] arr, int k) {
        int[] res = new int[arr.length];
        int idx = k;
        for (int i = 0; i < arr.length - k; i++) {
            res[idx++] = arr[i];
        }

        idx = 0;
        for (int i = arr.length - k; i < arr.length; i++) {
            res[idx++] = arr[i];
        }

        return res;
    }
}
