package LeetCode84;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Chanmoey
 * @date 2022年01月29日
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int x = stack.peek();
                res = Math.max(res, heights[x]);
                stack.pop();
                if (!stack.isEmpty()) {
                    res = Math.max(res, heights[x] * (i - 1 - (stack.peek() + 1) + 1));
                } else {
                    res = Math.max(res, heights[x] * i);
                }
            }
            stack.push(i);
        }

        if (!stack.empty()) {
            int r = stack.peek();
            while (!stack.isEmpty()) {
                int x = stack.peek();
                stack.pop();
                res = Math.max(res, heights[x]);

                if (!stack.isEmpty()) {
                    res = Math.max(res, heights[x] * (r - (stack.peek() + 1) + 1));
                } else {
                    res = Math.max(res, heights[x] * n);
                }
            }
        }

        return res;
    }
}