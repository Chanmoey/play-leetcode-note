package LeetCode1288;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年02月20日
 */
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });

        int res = intervals.length;
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][1] <= intervals[j][1]) {
                    res--;
                    break;
                }
            }
        }

        return res;
    }
}