package LeetCode17;

import java.util.ArrayList;
import java.util.List;

// 时间复杂度O(n^3)
class Solution1 {

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
        List<String> res = new ArrayList<>();
        if (digits.equals("")) {
            return res;
        }

        for (int i = 0; i < digits.length(); i++) {
            String letterString = this.letters[digits.charAt(i) - '0'];
            if (res.isEmpty()) {
                for (int j = 0; j < letterString.length(); j++) {
                    res.add(String.valueOf(letterString.charAt(j)));
                }
            } else {
                List<String> copy = new ArrayList<>();
                for (String s : res) {
                    for (int j = 0; j < letterString.length(); j++) {
                        copy.add(s + letterString.charAt(j));
                    }
                }
                res = copy;
            }
        }
        return res;
    }
}
