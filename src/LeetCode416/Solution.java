package LeetCode416;

import java.util.Arrays;

class Solution {
    /**
     * memo[i][c]表示索引为[0...i]的这些元素，是否可以完全填充一个容量为c的背包
     * -1表示未计算，0表示不可以填充，1表示可以填充
     */
    int[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int isEven = 2;
        if (sum % isEven != 0) {
            return false;
        }

        this.memo = new int[nums.length][sum / 2 + 1];
        for (int[] list : this.memo) {
            Arrays.fill(list, -1);
        }

        return this.tryPartition(nums, nums.length - 1, sum / 2);
    }

    /**
     * 使用nums[0...index-1],是否可以完全填充一个容量为sum的背包
     */
    private boolean tryPartition(int[] nums, int index, int sum) {

        if (sum == 0) {
            return true;
        }

        if (sum < 0 || index < 0) {
            return false;
        }

        if (this.memo[index][sum] != -1) {
            return this.memo[index][sum] == 1;
        }

        this.memo[index][sum] = (tryPartition(nums, index - 1, sum) ||
                tryPartition(nums, index - 1, sum - nums[index])) ? 1 : 0;

        return this.memo[index][sum] == 1;
    }
}
