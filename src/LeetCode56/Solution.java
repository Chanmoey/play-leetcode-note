package LeetCode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2021年12月24日 8:35
 * @description
 */
class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> res = new ArrayList<>();

        int i = 0;
        while (i < intervals.length - 1) {
            int j = i + 1;
            for (; j < intervals.length; j ++) {
                if (intervals[i][1] >= intervals[j][0] && intervals[i][1] < intervals[j][1]) {
                    intervals[i][1] = intervals[j][1];
                }
                else if (intervals[i][1] < intervals[j][0]) {
                    res.add(intervals[i]);
                    i = j;
                    break;
                }
            }
            if (j == intervals.length) {
                res.add(intervals[i]);
                break;
            }
        }

        if (res.get(res.size() - 1)[1] < intervals[i][0]) {
            res.add(intervals[i]);
        }

        int[][] ret = new int[res.size()][];
        for (int k = 0; k < ret.length; k ++) {
            ret[k] = res.get(k);
        }

        return ret;
    }
}
