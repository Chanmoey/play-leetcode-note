package LeetCode784;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年01月13日
 */
class Solution {

    private final List<String> list = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {

        this.combine(s.toCharArray(), 0);
        return list;
    }

    private void switchLowerAndUpper(char[] chars, int index) {
        if (Character.isUpperCase(chars[index])) {
            chars[index] = Character.toLowerCase(chars[index]);
        } else {
            chars[index] = Character.toUpperCase(chars[index]);
        }
    }

    private void combine(char[] chars, int index) {
        list.add(new String(chars));

        for (int i = index; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                this.switchLowerAndUpper(chars, i);
                combine(chars, i + 1);
                this.switchLowerAndUpper(chars, i);
            }
        }
    }
}
