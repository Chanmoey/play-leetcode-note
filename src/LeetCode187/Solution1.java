package LeetCode187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2023年01月10日
 */
class Solution1 {


    public List<String> findRepeatedDnaSequences(String s) {

        if (s.length() < 10) {
            return new ArrayList<>();
        }

        int[] map = new int[256];
        map['A'] = 1;
        map['C'] = 2;
        map['G'] = 3;
        map['T'] = 4;

        HashSet<Long> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();

        long hash = 0;
        long ten9 = (long) 1e9;

        for (int i = 0; i < 9; i++) {
            hash = hash * 10 + map[s.charAt(i)];
        }

        // 滚动hash
        for (int i = 9; i < s.length(); i++) {
            hash = hash * 10 + map[s.charAt(i)];
            if (seen.contains(hash)) {
                res.add(s.substring(i - 9, i + 1));
            } else {
                seen.add(hash);
            }
            hash -= map[s.charAt(i - 9)] * ten9;
        }

        return new ArrayList<>(res);
    }
}
