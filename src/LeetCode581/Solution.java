package LeetCode581;

import java.util.Stack;

/**
 * @author Chanmoey
 * @date 2022年05月03日
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> monotonic = new Stack<>();
        int left = -1, right = -1, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {

            // 如果当前元素比栈顶元素小，则违反单调栈的概念，调整栈。
            if (!monotonic.isEmpty() && monotonic.peek() > nums[i]) {

                // 一直pop，直到栈顶元素比当前元素小。
                while (!monotonic.isEmpty() && monotonic.peek() > nums[i]) {
                    monotonic.pop();
                }

                // 记录子数组的左边界。
                if (left == -1) {
                    left = monotonic.size();
                } else if (monotonic.size() < left) {
                    left = monotonic.size();
                }

                // 记录子数组的有边界。
                right = i;
            } else {

                // 只有当前元素比之前入栈过的最大值还要大的时候，才有必要将其入栈。
                if (nums[i] >= max) {
                    monotonic.push(nums[i]);
                } else {

                    // 如果当前元素比之前入栈的最大值还大，那么这个元素必然在无序子数组中，将记录为子数组右边界。
                    right = i;
                }
            }
            max = Math.max(max, nums[i]);
        }

        return monotonic.size() == nums.length ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findUnsortedSubarray(new int[] {1, 3, 5, 4, 2}));
    }
}
