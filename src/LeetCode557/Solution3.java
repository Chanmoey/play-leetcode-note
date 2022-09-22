package LeetCode557;

/**
 * @author Chanmoey
 * @date 2022年09月22日
 */
class Solution3 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        for (int j = i + 1; j < chars.length; j++) {
            if (chars[j] == ' ') {
                reverse(chars, i, j);
                i = j + 1;
            } else if (j == chars.length - 1) {
                reverse(chars, i, j + 1);
            }
        }


        return new String(chars);
    }

    /**
     * 反转 [left, right)
     */
    private void reverse(char[] chars, int left, int right) {
        int i = left;
        int j = right - 1;
        char temp;
        while (i < j) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
