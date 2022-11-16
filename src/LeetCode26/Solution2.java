package LeetCode26;

/**
 * @author Chanmoey
 * @date 2022年11月11日
 */
class Solution2 {
    public int removeDuplicates(int[] nums) {
        int top = -1;
        for (int i = 0; i < nums.length; i++) {
            if (top == -1 || nums[top] != nums[i]) {
                top++;
                nums[top] = nums[i];
            }
        }

        return top + 1;
    }
}
