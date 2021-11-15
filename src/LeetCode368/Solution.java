package LeetCode368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chanmory
 * @date 2021年11月15日 8:21
 * @description LeetCode第368题。
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(pre, -1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 &&
                        1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    pre[i] = j;
                }
            }
        }

        int maxDp = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > maxDp) {
                maxDp = dp[i];
                idx = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        while (idx != -1) {
            res.add(nums[idx]);
            idx = pre[idx];
        }

        return res;
    }
}
