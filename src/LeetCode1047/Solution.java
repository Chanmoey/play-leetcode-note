package LeetCode1047;

/**
 * 双指针
 *
 * @author Chanmoey
 * @date 2022年11月10日
 */
class Solution {
    public String removeDuplicates(String s) {

        char[] chars = s.toCharArray();

        int i = 0;
        for (int j = i + 1; j < chars.length; j++) {
            if (chars[i] == chars[j]) {
                chars[i] = chars[j] = '*';
                while (i >= 0 && chars[i] == '*') {
                    i--;
                }
                if (i == -1) {
                    i = j;
                }
            } else {
                i = j;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c != '*') {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
