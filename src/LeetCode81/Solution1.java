package LeetCode81;

/**
 * O(n - k) + O(logK)
 *
 * @author Chanmoey
 * @date 2022年03月28日
 */
class Solution1 {
    public boolean search(int[] nums, int target) {

        int start = -1;
        int end = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            start = 0;
            end = nums.length - 1;
        } else if (target <= nums[nums.length - 1]) {
            end = nums.length - 1;
        } else if (target >= nums[0]) {
            end = start - 1;
            start = 0;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
