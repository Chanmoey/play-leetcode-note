package LeetCode986;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmory
 * @date 2021年11月24日 10:03
 * @description
 */
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[][]{};
        }

        int i = 0, j = 0;
        int startMax = 0, endMin = 0;
        List<int[]> res = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {
            startMax = Math.max(firstList[i][0], secondList[j][0]);
            endMin = Math.min(firstList[i][1], secondList[j][1]);

            if (endMin >= startMax) {
                res.add(new int[]{startMax, endMin});
            }

            if (endMin == firstList[i][1]) {
                i++;
            }

            if (endMin == secondList[j][1]) {
                j++;
            }
        }

        return res.toArray(new int[res.size()][2]);
    }
}
