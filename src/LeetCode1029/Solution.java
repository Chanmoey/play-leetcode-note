package LeetCode1029;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Chanmoey
 * @date 2022年03月25日
 */
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> (a[0] - a[1])));
        int n = costs.length / 2;
        int spend = 0;
        for (int[] cost : costs) {
            if (n > 0) {
                spend += cost[0];
            } else {
                spend += cost[1];
            }
            n--;
        }

        return spend;
    }
}
