package LeetCode224;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Chanmoey
 * @date 2022年11月20日
 */
class Solution {

    public int calculate(String s) {
        int sum = 0;
        int sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                val = val * sign;
                sign = 1;
                sum += val;
            } else if (c == '(') {
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            } else if (c == ')') {
                sum *= stack.pop();
                sum += stack.pop();
            } else if (c == '-') {
                sign *= -1;
            }
        }

        return sum;
    }
}
