package LeetCode844;

/**
 * @author Chanmoey
 * @date 2022年05月01日
 */
class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] stack1 = new char[s.length()];
        char[] stack2 = new char[t.length()];
        int top1 = -1, top2 = -1;

        int i = 0;
        while (i < s.length() && i < t.length()) {
            if (s.charAt(i) != '#') {
                top1++;
                stack1[top1] = s.charAt(i);
            } else {
                top1--;
                top1 = Math.max(top1, -1);
            }

            if (t.charAt(i) != '#') {
                top2++;
                stack2[top2] = t.charAt(i);
            } else {
                top2--;
                top2 = Math.max(top2, -1);
            }

            i++;
        }

        while (i < s.length()) {
            if (s.charAt(i) != '#') {
                top1++;
                stack1[top1] = s.charAt(i);
            } else {
                top1--;
                top1 = Math.max(top1, -1);
            }
            i++;
        }

        while (i < t.length()) {
            if (t.charAt(i) != '#') {
                top2++;
                stack2[top2] = t.charAt(i);
            } else {
                top2--;
                top2 = Math.max(top2, -1);
            }

            i++;
        }

        if (top1 != top2) {
            return false;
        }

        if (top1 == -1) {
            return true;
        }

        i = 0;
        while (i <= top1) {
            if (stack1[i] != stack2[i]) {
                return false;
            }

            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.backspaceCompare("a", "b");
    }
}
