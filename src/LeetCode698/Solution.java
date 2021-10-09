package LeetCode698;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        if (k > nums.length) {
            return false;
        }

        int sum = this.sum(nums);
        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;
        boolean[] visited = new boolean[nums.length];
        return this.backtrack(nums, visited, target, 0, 0, k);
    }

    private int sum(int[] nums) {

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        return sum;
    }

    private boolean backtrack(int[] nums, boolean[] visited,
                              int target, int currSum, int inx, int k) {
        if (k == 0) {
            return true;
        }

        if (currSum == target) {
            return backtrack(nums, visited, target, 0, 0, k - 1);
        }

        for (int j = inx; j < nums.length; j++) {
            if (visited[j] || currSum + nums[j] > target) {
                continue;
            }

            visited[j] = true;
            if (backtrack(nums, visited, target,
                    currSum + nums[j], j + 1, k)) {
                return true;
            }
            visited[j] = false;
        }
        return false;
    }
}
