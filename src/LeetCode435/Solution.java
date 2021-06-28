package LeetCode435;


import java.util.Arrays;

/**
 * 动态规划
 * */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[a.length - 1], b[b.length - 1]));

        int[] memo = new int[intervals.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][intervals[j].length - 1]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }

        int res = 0;
        for (int j : memo) {
            res = Math.max(res, j);
        }

        return intervals.length - res;
    }
}
