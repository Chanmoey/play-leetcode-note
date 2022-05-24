package LeetCode32;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 错误的解法!!!
 *
 * @author Chanmoey
 * @date 2022年05月24日
 */
class Solution {

    public int longestValidParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int max = 0;
        int length = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.addLast(c);
            }
            if (c == ')') {
                if (!stack.isEmpty()) {
                    length += 2;
                    max = Math.max(max, length);
                    stack.removeLast();
                } else {
                    length = 0;
                }
            }
        }

        return max;
    }
}