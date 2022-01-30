package LeetCode189;

/**
 * @author Chanmoey
 * @date 2022年01月30日
 */
class Solution1 {
    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        int[] result = new int[nums.length];
        System.arraycopy(nums, nums.length - k, result, 0, k);
        System.arraycopy(nums, 0, result, k, nums.length - k);
        System.arraycopy(result, 0, nums, 0, nums.length);
    }
}
