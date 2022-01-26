package LeetCode387;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年01月26日
 */
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        char firstUniq = '*';
        for (Character key : map.keySet()) {
            if (map.get(key) == 1) {
                firstUniq = key;
                break;
            }
        }
        
        if (firstUniq == '*') {
            return -1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == firstUniq) {
                return i;
            }
        }

        return -1;
    }
}
