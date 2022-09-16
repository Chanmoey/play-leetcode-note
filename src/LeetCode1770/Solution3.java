package LeetCode1770;

/**
 * 记忆化搜索
 * @author Chanmoey
 * @date 2022年09月16日
 */
class Solution3 {

    Integer[][] memo;
    int[] nums;
    int[] multipliers;
    int n;
    int m;

    public int maximumScore(int[] nums, int[] multipliers) {

        this.nums = nums;
        this.multipliers = multipliers;
        n = nums.length;
        m = multipliers.length;

        if (n >= m * 2) {
            int[] newNums = new int[m * 2];
            System.arraycopy(nums,0,newNums,0, m);
            System.arraycopy(nums, n - m,newNums, m, m);
            this.nums = newNums;
        }

        memo = new Integer[this.nums.length][this.nums.length];

        return memoization(0, this.nums.length - 1, 0);
    }

    private int memoization(int front, int back, int current) {
        if (current == m) {
            return 0;
        }
        if (memo[front][back] != null) {
            return memo[front][back];
        }

        int left = nums[front] * multipliers[current] + memoization(front + 1, back, current + 1);
        int right = nums[back] * multipliers[current] + memoization(front, back - 1, current + 1);
        memo[front][back] = Math.max(left, right);

        return memo[front][back];
    }
}
