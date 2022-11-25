package LeetCode493;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年11月24日
 */
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
    }

    // 排序[l, r]
    private int mergeSort(int[] nums, int l, int r, int[] temp) {
        if (l >= r) {
            return 0;
        }
        int res = 0;
        int mid = l + (r - l) / 2;
        res += mergeSort(nums, l, mid, temp);
        res += mergeSort(nums, mid + 1, r, temp);
        if (nums[mid] > nums[mid + 1]) {
            res += merge(nums, l, mid, r, temp);
        }
        return res;
    }

    private int merge(int[] nums, int l, int mid, int r, int[] temp) {
        System.arraycopy(nums, l, temp, l, r - l + 1);
        int i = l;
        int j = mid + 1;
        int res = 0;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = temp[j++];
            } else if (j > r) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                if (temp[i] > 2 * temp[j]) {
                    res += mid - i + 1;
                }
                nums[k] = temp[j++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 3, 1};
        Solution s = new Solution();
        s.reversePairs(nums);
        System.out.println(Arrays.toString(nums));
    }
}
