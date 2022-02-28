package LeetCode976;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年02月28日
 */
class Solution {
    public int largestPerimeter(int[] nums) {

        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }

        return 0;
    }
}
