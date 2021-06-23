package LeetCode416;

/**
 * @author Chanmoey
 */
public class Solution1 {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int two = 2;
        if (sum % two != 0) {
            return false;
        }

        int n = nums.length;
        int c = sum / two;
        boolean[] memo = new boolean[c + 1];

        for (int i = 0; i <= c; i++) {
            memo[i] = (nums[0] == i);
        }

        for (int i = 1; i < n; i++) {
            for (int j = c; j >= nums[i]; j--) {
                memo[j] = memo[j] || memo[j - nums[i]];
            }
        }

        return memo[c];
    }
}
