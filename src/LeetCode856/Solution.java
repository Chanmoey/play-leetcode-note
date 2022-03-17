package LeetCode856;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Chanmoey
 * @date 2022年03月17日
 */
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(String.valueOf(c));
            } else {
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    queue.add(stack.pop());
                }
                stack.pop();
                if (queue.isEmpty()) {
                    stack.push("1");
                } else {
                    int temp = 0;
                    for (String ss : queue) {
                        temp += Integer.parseInt(ss);
                    }
                    stack.add(String.valueOf(2 * temp));
                    queue.clear();
                }
            }
        }

        int res = 0;
        for (String ss : stack) {
            res += Integer.parseInt(ss);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.scoreOfParentheses("(()()(()))(()()())");
    }
}
