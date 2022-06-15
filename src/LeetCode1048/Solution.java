package LeetCode1048;

import java.util.*;

class Solution {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));

        int res = 1;

        Map<String, Integer> dp = new HashMap<>(words.length * 2);

        for (String word : words) {
            dp.put(word, 1);
            int maxPosSubChain = 0;
            for (int j = 0; j < word.length(); j++) {
                String sub = word.substring(0, j) + word.substring(j + 1);
                if (dp.containsKey(sub)) {
                    maxPosSubChain = Math.max(maxPosSubChain, dp.get(sub));
                }
            }
            dp.put(word, dp.get(word) + maxPosSubChain);
            res = Math.max(res, dp.get(word));
        }

        return res;
    }
}
