package LeetCode1672;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年01月31日
 */
class Solution1 {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] num : accounts) {
            maxWealth = Math.max(maxWealth, Arrays.stream(num).sum());
        }
        return maxWealth;
    }
}
