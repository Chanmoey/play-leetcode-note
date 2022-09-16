package LeetCode1770;

/**
 * @author Chanmoey
 * @date 2022年09月16日
 */
class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int sum = 0;
        int l = 0;
        int r = nums.length - 1;

        for (int multiplier : multipliers) {
            if (multiplier > 0) {
                if (nums[l] > nums[r]) {
                    sum += nums[l] * multiplier;
                    l++;
                } else {
                    sum += nums[r] * multiplier;
                    r--;
                }
            } else {
                if (nums[l] > nums[r]) {
                    sum += nums[r] * multiplier;
                    r--;
                } else {
                    sum += nums[l] * multiplier;
                    l++;
                }
            }
        }

        return sum;
    }
}
