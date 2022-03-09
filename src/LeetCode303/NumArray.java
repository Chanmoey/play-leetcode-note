package LeetCode303;

/**
 * @author Chanmoey
 * @date 2022年03月09日
 */
class NumArray {

    private final int[] sum;

    public NumArray(int[] nums) {
        int tempSum = 0;
        this.sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tempSum += nums[i];
            sum[i] = tempSum;
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return this.sum[right];
        }

        return this.sum[right] - this.sum[left - 1];
    }
}
