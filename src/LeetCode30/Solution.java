package LeetCode30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年08月13日
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length;
        int len = words[0].length();

        List<Integer> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (int i = 0; i < s.length() - (n * len) + 1; i++) {
            Map<String, Integer> temp = new HashMap<>();
            for (int j = i; j < i + n * len; j += len) {
                String str = s.substring(j, j + len);
                temp.put(str, temp.getOrDefault(str, 0) + 1);
            }
            if (map.equals(temp)) {
                res.add(i);
            }
        }

        return res;
    }
}
