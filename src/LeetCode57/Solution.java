package LeetCode57;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2023年01月17日
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0){
            res.add(newInterval);
            return res.toArray(new int[0][0]);
        }
        boolean done = false;
        for (int i = 0; i < intervals.length; i++) {

            if (done) {
                res.add(intervals[i]);
                continue;
            }

            if (newInterval[0] > intervals[i][0]) {
                if (newInterval[0] > intervals[i][1]) {
                    res.add(intervals[i]);
                } else {
                    newInterval[0] = intervals[i][0];
                    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                }
                if(i == intervals.length - 1) {
                    res.add(newInterval);
                }
            } else {
                if (newInterval[1] < intervals[i][0]) {
                    res.add(newInterval);
                    res.add(intervals[i]);
                    done = true;
                } else {
                    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                    if(i == intervals.length - 1) {
                        res.add(newInterval);
                    }
                }
            }
        }

        return res.toArray(new int[0][0]);
    }
}
