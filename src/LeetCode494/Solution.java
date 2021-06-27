package LeetCode494;

class Solution {

    private int ret;

    public int findTargetSumWays(int[] nums, int target) {

        if (nums.length == 1 && Math.abs(nums[0]) == Math.abs(target)) {
            return 1;
        }

        this.ret = 0;
        this.findTargetSumWay(nums, target, 0);
        return this.ret;
    }

    private void findTargetSumWay(int[] nums, int target, int index) {

        if (index == nums.length - 1) {

            if (nums[index] == 0 && target == 0) {
                this.ret += 2;
            }else if (Math.abs(nums[index]) == Math.abs(target)){
                this.ret ++;
            }
            return;
        }

        findTargetSumWay(nums, target + nums[index], index + 1);
        findTargetSumWay(nums, target - nums[index], index + 1);
    }
}
