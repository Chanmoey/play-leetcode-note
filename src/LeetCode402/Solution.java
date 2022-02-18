package LeetCode402;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Chanmoey
 * @date 2022年02月18日
 */
class Solution {
    public String removeKdigits(String num, int k) {

        if (num.length() <= k) {
            return "0";
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : num.toCharArray()) {
            while (stack.size() > 0 && k > 0 && stack.getLast() > c) {
                k--;
                stack.removeLast();
            }

            stack.addLast(c);
        }

        while (k > 0) {
            k--;
            stack.removeLast();
        }

        while (stack.size() > 0 && stack.getFirst().equals('0')) {
            stack.removeFirst();
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        return sb.length() > 0 ? sb.toString() : "0";
    }
}
