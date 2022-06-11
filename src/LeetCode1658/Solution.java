package LeetCode1658;

/**
 * @author Chanmoey
 * @date 2022年06月11日
 */
class Solution {
    public int minOperations(int[] nums, int x) {

        int length = nums.length;
        int min = length + 1;
        int l = 0;
        int r = length;

        // 先从左到右查看。
        int sum = 0;
        while (sum < x && l < length) {
            sum += nums[l++];
        }

        if (sum == x) {
            min = l;
        }

        // 逐渐将右边的元素加进来。
        while (l > 0) {
            sum -= nums[--l];
            while (sum < x && r > 0) {
                sum += nums[--r];
            }

            if (sum == x) {
                min = Math.min(min, l + length - r);
            }
        }

        return min < length + 1 ? min : -1;
    }
}
