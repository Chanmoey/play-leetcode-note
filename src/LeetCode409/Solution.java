package LeetCode409;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * hashmap
 *
 * @author Chanmoey
 * @date 2022年02月09日
 */
class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int length = 0;

        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        Map.Entry<Character, Integer> temp;
        boolean haveOdd = false;

        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.getValue() % 2 == 0) {
                length += temp.getValue();
            } else {
                haveOdd = true;
                length += temp.getValue() - 1;
            }
        }

        return haveOdd ? length + 1 : length;
    }
}
