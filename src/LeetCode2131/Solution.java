package LeetCode2131;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年11月03日
 */
class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>(words.length * 2);
        int pair = 0;
        int sym = 0;
        for (String word : words) {
            String reverse = word.charAt(1) + "" + word.charAt(0);
            if (map.getOrDefault(reverse, 0) > 0) {
                pair++;
                map.put(reverse, map.getOrDefault(reverse, 0) - 1);
                if (reverse.equals(word)) {
                    sym--;
                }
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
                if (reverse.equals(word)) {
                    sym++;
                }
            }
        }

        return pair * 4 + (sym > 0 ? 2 : 0);
    }
}
