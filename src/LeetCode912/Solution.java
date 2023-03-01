package LeetCode912;

/**
 * ?????????????????????不知道为什么TLE，且TLE的测试用例是空的
 *
 * @author Chanmoey
 * @date 2023年03月01日
 */
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort2Way(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 对数组[l, r]区间进行归并排序
     */
    private void quickSort2Way(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(nums, l, r);
        quickSort2Way(nums, l, p - 1);
        quickSort2Way(nums, p + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int start = nums[l];
        int i = l + 1;
        int j = r;
        // [l...i) <= start, (j...r] >= start
        while (true) {
            while (i <= j) {
                if (nums[i] > start) {
                    break;
                }
                i++;
            }

            while (i <= j) {
                if (nums[j] < start) {
                    break;
                }
                j--;
            }

            if (i >= j) {
                break;
            }


            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

        }

        nums[l] = nums[j];
        nums[j] = start;
        return j;
    }
}
