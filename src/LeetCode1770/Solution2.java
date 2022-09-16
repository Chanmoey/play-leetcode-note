package LeetCode1770;

/**
 * Solution1 + 记忆化搜索
 *
 * @author Chanmoey
 * @date 2022年09月16日
 */
class Solution2 {
    int n;
    int m;

    public int maximumScore(int[] nums, int[] multipliers) {
        n = nums.length;
        m = multipliers.length;
        return helper(nums, multipliers, 0, 0, new Integer[m][m]);
    }

    private int helper(int[] nums, int[] multipliers, int left, int index, Integer[][] dp) {
        int right = n - 1 - (index - left);
        if (index == m) return 0;

        if (dp[left][index] != null) return dp[left][index];

        int res = Math.max(
                nums[left] * multipliers[index] + helper(nums, multipliers, left + 1, index + 1, dp),
                nums[right] * multipliers[index] + helper(nums, multipliers, left, index + 1, dp));

        dp[left][index] = res;
        return res;
    }
}
