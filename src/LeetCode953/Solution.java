package LeetCode953;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年03月06日
 */
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>(order.length() * 2);
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!sorted(words[i], words[i + 1], map)) {
                return false;
            }
        }

        return true;
    }

    private boolean sorted(String word1, String word2, Map<Character, Integer> map) {
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()){
            if (map.get(word1.charAt(i)) < map.get(word2.charAt(j))) {
                return true;
            } else if (map.get(word1.charAt(i)) > map.get(word2.charAt(j))) {
                return false;
            }
            i++;
            j++;
        }
        return word1.length() <= word2.length();
    }
}
