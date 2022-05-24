package LeetCode32;

/**
 * @author Chanmoey
 * @date 2022年05月24日
 */
class Solution1 {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                max = Math.max(max, left + right);
            }

            // ) 括号多于 (，无法闭合。
            if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }

            if (left == right) {
                max = Math.max(max, left + right);
            }

            // ( 括号多于 )，无法闭合。
            if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return max;
    }
}
