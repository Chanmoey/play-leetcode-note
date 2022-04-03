package LeetCode31;

import java.util.Arrays;

/**
 * 错误题解。 错误用例：[1,3,2]
 *
 * @author Chanmoey
 * @date 2022年04月03日
 */
class Solution {
    public void nextPermutation(int[] nums) {
        boolean change = false;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                int temp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = temp;
                change = true;
                break;
            }
        }

        if (!change) {
            Arrays.sort(nums);
        }
    }
}
