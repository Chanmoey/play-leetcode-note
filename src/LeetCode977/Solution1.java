package LeetCode977;

/**
 * @author Chanmoey
 * @date 2022年01月07日
 */
public class Solution1 {

    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] arr = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i --) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                arr[i] = nums[left] * nums[left];
                left ++;
            } else {
                arr[i] = nums[right] * nums[right];
                right --;
            }
        }

        return arr;
    }
}
