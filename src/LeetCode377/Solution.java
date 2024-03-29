package LeetCode377;

import java.util.Arrays;

class Solution {

    private int[] memo;
    private final static int NULL = -1;

    public int combinationSum4(int[] nums, int target) {

        /* use dfs
            if (nums.length == 0) {
                return 0;
            }

            this.memo = new int[target + 1];
            Arrays.fill(this.memo, NULL);
            this.dfs(nums, target);

            return this.memo[target];
        */

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        this.memo = new int[target + 1];
        this.memo[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    if (this.memo[i] == -1 || this.memo[i - num] == -1 ||
                            (long) this.memo[i] + (long) this.memo[i - num] > Integer.MAX_VALUE) {
                        this.memo[i] = -1;
                    } else {
                        this.memo[i] += this.memo[i - num];
                    }
                }
            }
        }

        return this.memo[target];
    }

    private int dfs(int[] nums, int target) {

        if (target == 0) {
            return 1;
        }

        if (this.memo[target] != NULL) {
            return this.memo[target];
        }

        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += dfs(nums, target - num);
            }
        }

        return this.memo[target] = res;
    }
}
