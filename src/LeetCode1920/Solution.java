package LeetCode1920;

class Solution {
    public int[] buildArray(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = nums[nums[i]];
        }

        return ret;
    }
}
