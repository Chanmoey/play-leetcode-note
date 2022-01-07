package LeetCode394;

import java.util.Collections;

/**
 * @author Chanmoey
 * @date 2021年12月19日 10:30
 * @description
 */
class Solution {
    public String decodeString(String s) {
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ']') {
                i++; // i 指向 ]
                continue;
            }

            int j = i;
            while (s.charAt(j) != '[') {
                j--; // j 指向 [
            }

            String repeatLetters = s.substring(j + 1, i);
            int k = j; // k 指向 [
            j--;

            while (j > 0 && Character.isDigit(s.charAt(j))) {
                j--;
            }

            if (j != 0) {
                j++;
            }

            int repeatTimes = Integer.parseInt(s.substring(j, k));
            s = this.replace(s, j, i - j + 1, this.repeat(repeatLetters, repeatTimes));
            i = j + repeatTimes * repeatLetters.length();
        }

        return s;
    }

    private String repeat(String substr, int times) {
//        return String.valueOf(substr).repeat(Math.max(0, times)); Java 8 不兼容
        return String.join("", Collections.nCopies(Math.max(0, times), substr));
    }

    private String replace(String targetString, int start, int length, String repeatString) {
        String headString = targetString.substring(0, start);
        String tailString = null;
        if (start + length <= targetString.length()) {
            tailString = targetString.substring(start + length);
        }

        if (tailString != null) {
            return headString + repeatString + tailString;
        }

        return headString + repeatString;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.decodeString("3[a]2[bc]"));
    }
}
