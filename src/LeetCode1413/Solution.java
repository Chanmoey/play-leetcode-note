package LeetCode1413;

import java.util.Arrays;

class Solution {
    public int minStartValue(int[] nums) {

        int minSum = Integer.MAX_VALUE;

        int sum = 0;
        for (int num : nums) {
            sum += num;
            minSum = Math.min(minSum, sum);
        }

        if (minSum > 0) {
            return 1;
        }

        return Math.abs(minSum) + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minStartValue(new int[]{1, 2}));
    }
}
