package LeetCode189;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年01月07日
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }

        if (k >= nums.length) {
            k = k % nums.length;
        }

        int[] arr = new int[nums.length];

        int index = k - 1;
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            arr[index --] = nums[i];
        }

        index = k;
        for (int i = 0; i < nums.length - k; i++) {
            arr[index++] = nums[i];
        }

        System.arraycopy(arr, 0, nums, 0, arr.length);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
