package LeetCode922;

/**
 * Could you solve it in-place?
 */
class Solution1 {
    public int[] sortArrayByParityII(int[] nums) {
        int len = nums.length;
        int even = 0, odd = 1;

        while (even < len && odd < len) {

            while (even < len && (nums[even] & 1) == 0) {
                even += 2;
            }

            while (odd < len && (nums[odd] & 1) == 1) {
                odd += 2;
            }

            if (even < len && odd < len) {
                this.swap(nums, even, odd);
            }
        }

        return nums;
    }

    private void swap(int[] nums, int index, int otherIndex) {
        int temp = nums[index];
        nums[index] = nums[otherIndex];
        nums[otherIndex] = temp;
    }
}
