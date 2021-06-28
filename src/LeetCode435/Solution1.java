package LeetCode435;

import java.util.Arrays;

class Solution1 {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[a.length - 1] != b[b.length - 1] ?
                Integer.compare(a[a.length - 1], b[b.length - 1]) :
                Integer.compare(a[0], b[0]));

        int res = 1;
        int pre = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[pre][intervals[pre].length - 1]) {
                res++;
                pre = i;
            }
        }

        return intervals.length - res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        Solution1 s = new Solution1();
        s.eraseOverlapIntervals(intervals);
    }
}
