package LeetCode557;

import java.util.List;

/**
 * @author Chanmoey
 */
class Solution {
    public String reverseWords(String s) {
        String[] stringList = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringList.length; i ++) {
            sb.append(this.reverse(stringList[i]));
            if (i != stringList.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    private String reverse(String word) {
        char[] chars = word.toCharArray();
        int i = 0, j = word.length() - 1;
        char temp;
        while (i < j) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        return new String(chars);
    }
}
