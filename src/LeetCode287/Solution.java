package LeetCode287;

import java.util.Arrays;

/**
 * O(nlogn)
 *
 * @author Chanmoey
 * @date 2022年03月29日
 */
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }

        return -1;
    }
}
