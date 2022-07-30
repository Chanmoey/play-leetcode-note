package LeetCode916;

import java.util.Arrays;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年07月30日
 */
public class Solution1 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        final int[] maxFreq = new int[26];
        Arrays.stream(words2)
                .map(this::toCharMap)
                .forEach(c -> {
                    for (int i = 0; i < 26; i++) {
                        // 找到各个字母中，出现最多的次数
                        maxFreq[i] = Math.max(maxFreq[i], c[i]);
                    }
                });

        return Arrays.stream(words1)
                .filter(s -> possible(toCharMap(s), maxFreq))
                .toList();
    }

    private boolean possible(int[] charMap, int[] maxFreq) {
        for (int i = 0; i < 26; i++) {
            if (charMap[i] < maxFreq[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] toCharMap(String s) {
        int[] charMap = new int[26];

        for (char c : s.toCharArray()) {
            charMap[c - 'a']++;
        }

        return charMap;
    }
}
