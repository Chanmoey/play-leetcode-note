package LeetCode20;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        if (s.length() <= 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char aChar : chars) {

            if (stack.isEmpty()) {
                stack.push(aChar);
            }else if (aChar == ')' && stack.peek().equals('(')) {
                stack.pop();
            } else if
            (aChar == ']' && stack.peek().equals('[')) {
                stack.pop();
            } else if
            (aChar == '}' && stack.peek().equals('{')) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }

        return stack.isEmpty();
    }
}