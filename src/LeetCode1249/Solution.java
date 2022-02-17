package LeetCode1249;

/**
 * @author Chanmoey
 * @date 2022年02月17日
 */
class Solution {
    public String minRemoveToMakeValid(String s) {

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')') {
                int j = i - 1;
                for (; j >= 0; j--) {
                    if (chars[j] == '(') {
                        break;
                    }
                }

                if (j >= 0) {
                    chars[i] = 'R';
                    chars[j] = 'L';
                } else {
                    chars[i] = '*';
                }
            }
        }

        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '(') {
                int j = i + 1;
                for (; j < chars.length; j++) {
                    if (chars[j] == ')') {
                        break;
                    }
                }

                if (j < chars.length) {
                    chars[i] = 'L';
                    chars[j] = 'R';
                } else {
                    chars[i] = '*';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c == 'L') {
                sb.append('(');
            } else if (c == 'R') {
                sb.append(')');
            } else if (c == '*') {
                continue;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
