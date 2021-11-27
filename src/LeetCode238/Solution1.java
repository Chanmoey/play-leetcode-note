package LeetCode238;

/**
 * @author Chanmory
 * @date 2021年11月27日 15:58
 * @description Using without the operation.
 */
class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answers = new int[n];
        answers[0] = 1;
        for (int i = 1; i < n; i++) {
            answers[i] = answers[i - 1] * nums[i - 1];
        }
        int last = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            answers[i] = answers[i] * last;
            last *= nums[i];
        }
        return answers;
    }
}
