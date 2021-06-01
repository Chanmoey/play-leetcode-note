package LeetCode35;

class Solution {
    public int searchInsert(int[] nums, int target) {

        if (nums.length == 1) {
            return target > nums[0] ? 1 : 0;
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {

            // 在一定程度上避免数据溢出
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
