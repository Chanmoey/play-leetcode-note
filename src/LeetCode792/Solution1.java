package LeetCode792;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年07月20日
 */
class Solution1 {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>(words.length * 2);
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            if (isSubsequence(s, key)) {
                res += entry.getValue();
            }
        }

        return res;
    }

    private boolean isSubsequence(String origin, String target) {
        if (target.length() > origin.length()) {
            return false;
        }

        int j = 0;
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) == target.charAt(j)) {
                j++;
                if (j == target.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}
