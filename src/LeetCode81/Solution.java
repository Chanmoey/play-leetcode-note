package LeetCode81;

/**
 * 直接遍历一遍
 *
 * @author Chanmoey
 * @date 2022年03月28日
 */
class Solution {
    public boolean search(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }

        return false;
    }
}
