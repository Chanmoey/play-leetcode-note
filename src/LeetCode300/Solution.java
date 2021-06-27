package LeetCode300;

class Solution {
    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        // 对memo进行初始化，并且判断nums数组是否是降序的，如果是直接返回1即可，否则才进行DP
        boolean isDecrease = true;
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = 1;
            if (i < nums.length - 1 && nums[i] < nums[i + 1]) {
                isDecrease = false;
            }
        }

        if (isDecrease) {
            return 1;
        }

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                    max = Math.max(max, memo[i]);
                }
            }
        }

        return max;
    }
}
