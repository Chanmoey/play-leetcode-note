package LeetCode389;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年02月07日
 */
class Solution {
    public char findTheDifference(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        for (int i = 0; i < s.length(); i++) {
            if (sChar[i] != tChar[i]) {
                return tChar[i];
            }
        }

        return tChar[tChar.length - 1];
    }
}
