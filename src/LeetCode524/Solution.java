package LeetCode524;

import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年06月09日
 */
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String dic : dictionary) {
            if (isSubString(dic, s)
                    && (dic.length() > res.length() || dic.length() == res.length() && dic.compareTo(res) < 0)) {
                res = dic;
            }
        }

        return res;
    }

    private boolean isSubString(String source, String target) {
        int i = 0;
        int j = 0;
        while (i < source.length() && j < target.length()) {
            if (source.charAt(i) == target.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == source.length();
    }
}
