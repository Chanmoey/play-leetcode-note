package LeetCode905;

/**
 * @author Chanmoey
 * @date 2022年05月02日
 */
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (nums[i] % 2 == 0 && i < j) {
                i ++;
            }

            while (nums[j] % 2 == 1 && i < j) {
                j --;
            }

            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        return nums;
    }
}
