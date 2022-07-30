package LeetCode916;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Limit Exceeded
 *
 * @author Chanmoey
 * @date 2022年07月30日
 */
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>(words1.length);
        for (String origin : words1) {
            int[] map = charMap(origin);
            boolean universal = true;
            for (String target : words2) {
                if (!isSubStr(map.clone(), target)) {
                    universal = false;
                    break;
                }
            }
            if (universal) {
                res.add(origin);
            }
        }

        return res;
    }

    private int[] charMap(String s) {
        int[] charMap = new int[26];

        for (char c : s.toCharArray()) {
            charMap[c - 'a']++;
        }

        return charMap;
    }

    private boolean isSubStr(int[] map, String target) {
        for (char c : target.toCharArray()) {
            if (map[c - 'a'] == 0) {
                return false;
            }

            map[c - 'a']--;
        }

        return true;
    }
}
