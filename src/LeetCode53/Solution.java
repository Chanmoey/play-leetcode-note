package LeetCode53;

class Solution {
    public int maxSubArray(int[] nums) {

        int res = -100000;
        for (int i : nums) {
            if (i > res) {
                res = i;
            }
        }

        if (res < 0) {
            return res;
        }

        int sum = 0;
        for (int i : nums) {
            if (sum + i < 0) {
                sum = 0;
            } else {
                res = Math.max(res, sum + i);
                sum += i;
            }
        }

        return res;
    }
}
