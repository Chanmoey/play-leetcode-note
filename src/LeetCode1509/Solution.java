package LeetCode1509;

import java.util.Arrays;

class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }

        int n = nums.length;
        Arrays.sort(nums);

        int res = nums[n - 1] - nums[0];
        for (int i = 0; i < 4; i++) {
            res = Math.min(res, nums[n-4+i] - nums[i]);
        }

        return res;
    }
}
