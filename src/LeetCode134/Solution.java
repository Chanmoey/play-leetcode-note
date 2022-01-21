package LeetCode134;

import java.util.Arrays;

/**
 * 此方法部分可解，某些极端测试用例会TLE。
 *
 * @author Chanmoey
 * @date 2022年01月21日
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int station;
        int tank;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }

            int index = i;
            station = 0;
            tank = 0;
            while (station < cost.length) {
                tank = tank + gas[index % gas.length] - cost[index % cost.length];

                if (tank < 0) {
                    break;
                }
                station++;
                index++;
            }

            if (station >= cost.length) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canCompleteCircuit(new int[]{4, 5, 3, 1, 4}, new int[]{5, 4, 3, 4, 2}));
    }
}
