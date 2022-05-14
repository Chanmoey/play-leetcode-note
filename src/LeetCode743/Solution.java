package LeetCode743;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年05月14日
 */
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        return this.bellman(times, n, k);
    }

    private int bellman(int[][] times, int n, int k) {
        int[] delay = new int[n + 1];
        Arrays.fill(delay, Integer.MAX_VALUE);
        delay[0] = 0;
        delay[k] = 0;

        for (int i = 0; i < n; i++) {
            for (int[] time : times) {
                delay[time[1]] = Math.min(delay[time[1]], delay[time[0]] == Integer.MAX_VALUE
                        ? Integer.MAX_VALUE : delay[time[0]] + time[2]);
            }
        }

        int max = Arrays.stream(delay).max().getAsInt();
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.networkDelayTime(new int[][] {{1, 2, 3}}, 2, 2);
    }
}
