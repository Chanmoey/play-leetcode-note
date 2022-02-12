package LeetCode187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Chanmoey
 * @date 2022年02月12日
 */
class Solution {

    private static final int SUB_DNA_LENGTH = 10;

    public List<String> findRepeatedDnaSequences(String s) {
        String subString;
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 0; i <= s.length() - SUB_DNA_LENGTH; i++) {
            subString = s.substring(i, i + 10);
            if (set.contains(subString)) {
                res.add(subString);
            } else {
                set.add(subString);
            }
        }

        return new ArrayList<>(res);
    }
}
