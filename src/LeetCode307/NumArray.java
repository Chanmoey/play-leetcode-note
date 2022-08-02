package LeetCode307;

/**
 * Time Limit Exceeded
 *
 * @author Chanmory
 * @date 2022年7月31日
 */
class NumArray {

    private final int[] nums;
    private final int[] sum;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.sum = new int[nums.length];
        this.sum[0] = nums[0];
        for (int i = 1; i < this.sum.length; i++) {
            this.sum[i] = nums[i] + this.sum[i - 1];
        }
    }

    public void update(int index, int val) {
        this.nums[index] = val;
        if (index == 0) {
            this.sum[0] = val;
            for (int i = 1; i < this.sum.length; i++) {
                this.sum[i] = nums[i] + this.sum[i - 1];
            }
        } else {
            for (int i = index; i < this.sum.length; i++) {
                this.sum[i] = this.sum[i - 1] + this.nums[i];
            }
        }

    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return this.sum[right];
        }
        return this.sum[right] - this.sum[left - 1];
    }
}
