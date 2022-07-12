package LeetCode473;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年07月12日
 */
class Solution {
    private boolean[] selected;

    public boolean makesquare(int[] m) {
        int sum = Arrays.stream(m).sum();
        selected = new boolean[m.length + 1];
        if (sum % 4 != 0)
            return false;
        return backtrack(m, 0, 4, sum / 4, sum / 4);
    }

    public boolean backtrack(int[] nums, int start, int k, int currSum, int sum) {
        if (currSum < 0) {
            return false;
        }

        if (k == 0) {
            return true;
        }

        if (currSum == 0) {
            return backtrack(nums, 0, k - 1, sum, sum);
        }

        if (start == nums.length) {
            return false;
        }

        for (int i = start; i < nums.length; i++) {
            if (!selected[i]) {
                selected[i] = true;
                if (backtrack(nums, i + 1, k, currSum - nums[i], sum))
                    return true;
                selected[i] = false;
            }

        }
        return false;
    }
}
