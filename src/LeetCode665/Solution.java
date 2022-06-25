package LeetCode665;

/**
 * @author Chanmoey
 * @date 2022年06月26日
 */
class Solution {
    public boolean checkPossibility(int[] nums) {
        int modified = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < prev) {
                if (modified == 1) {
                    return false;
                }
                modified++;
                if (i >= 2 && nums[i - 2] > nums[i]) continue;
            }
            prev = nums[i];
        }
        return true;
    }
}