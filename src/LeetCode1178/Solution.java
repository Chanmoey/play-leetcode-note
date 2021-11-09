package LeetCode1178;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private Map<Integer, Integer> freq = new HashMap<>();

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        for (String word : words) {
            int hash = this.getHash(word);
            int b = this.bitNum(hash);
            if (b <= 7) {
                freq.put(hash, freq.getOrDefault(hash, 0) + 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (String puzzle: puzzles) {
            int r = 0;
            for (int i = 64; i < 128; i++) {
                int hash = 0;
                for (int j = 0; j < 7; j++) {
                    if ((i & (1 << j)) > 0) {
                        hash += (1 << (puzzle.charAt(6 - j) - 'a'));
                    }
                }
                r += freq.getOrDefault(hash, 0);
            }
            res.add(r);
        }
        return res;
    }

    private int getHash(String s) {
        int hash = 0;

        for (char c : s.toCharArray()) {
            hash |= (1 << (c - 'a'));
        }
        return hash;
    }

    private int bitNum(int hash) {
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += ((hash & (1 << i)) != 0) ? 1 : 0;
        }
        return res;
    }
}
