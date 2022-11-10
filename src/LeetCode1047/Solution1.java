package LeetCode1047;

/**
 * 使用栈
 *
 * @author Chanmoey
 * @date 2022年11月10日
 */
public class Solution1 {

    public String removeDuplicates(String s) {

        char[] stack = new char[s.length()];
        int top = -1;

        for (char c : s.toCharArray()) {
            if (top == -1) {
                stack[++top] = c;
            } else {
                if (stack[top] == c) {
                    top --;
                } else {
                    stack[++top] = c;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
        }

        return sb.toString();
    }
}
