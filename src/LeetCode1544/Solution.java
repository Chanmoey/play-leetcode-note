package LeetCode1544;

/**
 * @author Chanmoey
 * @date 2022年11月08日
 */
class Solution {
    public String makeGood(String s) {
        char[] chars = s.toCharArray();

        int i = 0;
        int j = i + 1;

        while (j < s.length()) {
            if (chars[i] != chars[j] &&
                    (Character.toUpperCase(chars[i]) == chars[j] || Character.toLowerCase(chars[i]) == chars[j])) {
                chars[i] = chars[j] = '*';
                j++;
                while (i >= 0 && chars[i] == '*') {
                    i--;
                }
                if (i < 0) {
                    i = j;
                    j++;
                }
            } else {
                i = j;
                j++;
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
