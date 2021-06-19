package LeetCode198;

import java.util.Arrays;

/**
 * 状态：<考虑>偷取[x...n-1]范围里的房子<函数的定义>
 * 根据状态的定义，状态的转移：
 * f(0) = max{v(0) + f(2), v(1) + f(3), v(2) + f(4), ..., v(n-3) + f(n-1), v(n-2), v(n-1)}
 */
class Solution {

    private int[] memo;
    private static final int NULL = -1;

    public int rob(int[] nums) {
        this.memo = new int[nums.length];
        Arrays.fill(this.memo, NULL);
        return this.tryRobByDp(nums);
    }

    private int tryRob(int[] nums, int start) {

        if (start >= nums.length) {
            return 0;
        }

        if (this.memo[start] != NULL) {
            return this.memo[start];
        }

        int res = 0;
        for (int i = start; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        this.memo[start] = res;
        return res;
    }

    private int tryRobByDp(int[] nums) {

        int numsLength = nums.length;
        if (numsLength == 0) {
            return 0;
        }
        this.memo[numsLength - 1] = nums[numsLength - 1];

        int stepTwo = 2;
        for (int i = numsLength - stepTwo; i >= 0; i--) {
            this.memo[i] = Math.max(memo[i+1], nums[i] + (i + 2 < numsLength ? this.memo[i + 2] : 0));
        }

        return this.memo[0];
    }
}
