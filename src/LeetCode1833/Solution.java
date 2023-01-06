package LeetCode1833;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2023年01月06日
 */
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int res = 0;
        for (int cost : costs) {
            if (cost <= coins) {
                res++;
                coins -= cost;
            } else {
                break;
            }
        }

        return res;
    }
}
