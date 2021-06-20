package LeetCode213;

class Solution {

    /**
     * 避免程序中出现魔法值
     * */
    final static int ZERO = 0;
    final static int ONE = 1;
    final static int TWO = 2;


    public int rob(int[] nums) {

        int numsLength = nums.length;

        if (numsLength == ZERO) {
            return 0;
        }
        if (numsLength == ONE) {
            return nums[0];
        }
        if (numsLength == TWO) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(this.robByDp(nums, 0, numsLength - 2), this.robByDp(nums, 1, numsLength - 1));

    }

    private int robByDp(int[] nums, int start, int end) {

        int preMax = nums[start];
        int curMax = Math.max(preMax, nums[start + 1]);

        for (int i = start + TWO; i <= end; i++) {
            int temp = curMax;
            curMax = Math.max(nums[i] + preMax, curMax);
            preMax = temp;
        }

        return curMax;
    }
}
