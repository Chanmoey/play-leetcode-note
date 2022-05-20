package LeetCode462;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年05月20日
 */
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        return this.calculate(nums, nums[nums.length / 2]);
    }

    private int calculate(int[] nums, int target){
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - target);
        }

        return res;
    }
}