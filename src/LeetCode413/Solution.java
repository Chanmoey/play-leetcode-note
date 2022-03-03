package LeetCode413;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        int res = 0;
        int diff;
        int count = 0;
        int preDiff = nums[1] - nums[0];

        for (int i = 1; i < nums.length - 1; i++) {
            diff = nums[i + 1] - nums[i];

            if (diff == preDiff) {
                count++;
            } else {
                preDiff = diff;
                count = 0;
            }

            res += count;
        }

        return res;
    }
}