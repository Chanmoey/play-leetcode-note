package LeetCode227;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Chanmoey
 * @date 2021年12月25日 9:19
 * @description
 */
class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ) {
            if (Character.isDigit(s.charAt(i))) {
                int endIndex = nextDigitEndIndex(s, i);
                stack.addLast(Integer.parseInt(s.substring(i, endIndex)));
                i = endIndex;
                if (i >= s.length()) {
                    break;
                }
            }

            if (s.charAt(i) == '+') {
                int endIndex = nextDigitEndIndex(s, i + 1);
                stack.addLast(Integer.parseInt(s.substring(i + 1, endIndex)));
                i = endIndex;
                if (i >= s.length()) {
                    break;
                }
            }

            if (s.charAt(i) == '-') {
                int endIndex = nextDigitEndIndex(s, i + 1);
                stack.addLast(-1 * Integer.parseInt(s.substring(i + 1, endIndex)));
                i = endIndex;
                if (i >= s.length()) {
                    break;
                }
            }

            if (s.charAt(i) == '*') {
                int endIndex = nextDigitEndIndex(s, i + 1);
                stack.addLast(stack.removeLast() * Integer.parseInt(s.substring(i + 1, endIndex)));
                i = endIndex;
                if (i >= s.length()) {
                    break;
                }
            }

            if (s.charAt(i) == '/') {
                int endIndex = nextDigitEndIndex(s, i + 1);
                stack.addLast(stack.removeLast() / Integer.parseInt(s.substring(i + 1, endIndex)));
                i = endIndex;
                if (i >= s.length()) {
                    break;
                }
            }
        }

        int res = 0;
        for (Integer item : stack) {
            res += item;
        }

        return res;
    }

    private int nextDigitEndIndex(String s, int startIndex) {
        for (; startIndex < s.length(); startIndex++) {
            if (!Character.isDigit(s.charAt(startIndex))) {
                break;
            }
        }

        return Math.min(startIndex, s.length());
    }
}
