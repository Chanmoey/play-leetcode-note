package LeetCode532;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2022年02月09日
 */
class Solution {
    public int findPairs(int[] nums, int k) {

        if (k == 0) {
            return this.countRepeat(nums);
        }

        // 数组排序并去重
        nums = Arrays.stream(nums).sorted().distinct().toArray();

        int res = 0;
        int diff;
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                diff = nums[j] - nums[i];
                if (diff == k) {
                    res++;
                } else if (diff > k) {
                    break;
                }
            }
        }

        return res;
    }

    private int countRepeat(int[] nums) {

        Arrays.sort(nums);

        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                count++;
                int j = i + 1;
                while (j < nums.length && nums[j] == nums[i]) {
                    j++;
                }
                if (j >= nums.length) {
                    break;
                }
                i = j - 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countRepeat(new int[]{1, 2, 1, 2, 1}));
    }
}
