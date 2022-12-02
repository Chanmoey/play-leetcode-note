package LeetCode1657;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年12月02日
 */
class Solution {

    private static final int N = 26;

    public boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[N];
        int[] freq2 = new int[N];
        for (int i = 0; i < word1.length(); i++) {
            freq1[word1.charAt(i) - 'a']++;
            freq2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < N; i++) {
            if (freq1[i] != freq2[i] && (freq1[i] == 0 || freq2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);
        for (int i = 0; i < N; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
}
