package LeetCode268;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年04月20日
 */
class Solution2 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = ((n + 1)) * n / 2;

        int sum = Arrays.stream(nums).sum();

        return totalSum - sum;
    }
}
