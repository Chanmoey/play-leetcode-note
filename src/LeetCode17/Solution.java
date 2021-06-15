package LeetCode17;

import java.util.ArrayList;
import java.util.List;

// 时间复杂度O(2^n)
class Solution {

    public List<String> res = new ArrayList<>();

    String[] letters = {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")){
            return this.res;
        }
        this.findCombinations(digits, 0, "");
        return this.res;
    }

    private void findCombinations(String digits, int index, String s) {

        if (index == digits.length()) {
            this.res.add(s);
            return;
        }

        char c = digits.charAt(index);

        String letters = this.letters[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            this.findCombinations(digits, index + 1, s+letters.charAt(i));
        }
        // return;
    }
}
