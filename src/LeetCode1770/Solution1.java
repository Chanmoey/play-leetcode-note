package LeetCode1770;

/**
 * 深度优先遍历，递归穷举，毫无疑问会 TLE。
 *
 * @author Chanmoey
 * @date 2022年09月16日
 */
class Solution1 {
    public int maximumScore(int[] nums, int[] multipliers) {
        return maximum(nums, 0, nums.length - 1, multipliers, 0);
    }

    public int maximum(int[] nums, int l, int r, int[] multipliers, int idx) {

        if (idx < multipliers.length) {
            if (l < r) {
                int left = nums[l] * multipliers[idx];
                int right = nums[r] * multipliers[idx];

                return Math.max(left + maximum(nums, l + 1, r, multipliers, idx + 1),
                        right + maximum(nums, l, r - 1, multipliers, idx + 1));
            } else {
                return nums[l] * multipliers[idx];
            }
        } else {
            return 0;
        }
    }
}
