package LeetCode26;

/**
 * @author Chanmoey
 * @date 2022年11月11日
 */
class Solution1 {
    public int removeDuplicates(int[] nums) {
        int[] stack = new int[nums.length];
        int top = -1;
        for (int num : nums) {
            if (top == -1 || stack[top] != num) {
                top++;
                stack[top] = num;
            }
        }

        System.arraycopy(stack, 0, nums, 0, top + 1);
        return top + 1;
    }
}
