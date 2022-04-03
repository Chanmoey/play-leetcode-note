package LeetCode31;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年04月03日
 */
class Solution1 {
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int len = nums.length;
        int left = len - 2;

        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }

        if (left >= 0) {
            int right = nums.length - 1;
            while (right >= 0 && nums[left] >= nums[right]) {
                right--;
            }

            swap(nums, left, right);
        }
        reverseLeft2End(nums, left + 1);
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void reverseLeft2End(int[] nums, int left) {
        int end = nums.length - 1;
        while (left < end) {
            swap(nums, left, end);
            left++;
            end--;
        }
    }
}