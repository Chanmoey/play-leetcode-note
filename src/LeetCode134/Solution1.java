package LeetCode134;

/**
 * @author Chanmoey
 * @date 2022年01月21日
 */
public class Solution1 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, tank = 0, res = 0;
        for (int i = 0; i < cost.length; i ++) {
            totalGas += gas[i] - cost[i];
            tank += gas[i] - cost[i];

            if (tank < 0) {
                tank = 0;
                res = i + 1;
            }
        }

        return totalGas >= 0 ? res : -1;
    }
}
