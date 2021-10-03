package LeetCode55;

class Solution {
    public boolean canJump(int[] nums) {
        int step = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= step) {
                step = i;
            }
        }

        return step == 0;
    }


    /**
     * ime Limit Exceeded
     */
    private boolean recursion(int[] nums, int index) {
        if (nums[index] >= nums.length - 1 - index) {
            return true;
        }

        if (nums[index] == 0) {
            return false;
        }

        for (int i = nums[index]; i >= 1; i--) {
            if (recursion(nums, index + i)) {
                return true;
            }
        }

        return false;
    }
}