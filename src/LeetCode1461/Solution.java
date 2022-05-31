package LeetCode1461;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Chanmoey
 * @date 2022年05月31日
 */
class Solution {
    public boolean hasAllCodes(String s, int k) {

        if ((s.length() - k + 1) < (1 << k)) {
            return false;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }

        List<String> list = new ArrayList<>();
        this.combination(k, "0", list);
        this.combination(k, "1", list);

        for (String sub : list) {
            if (!set.contains(sub)) {
                return false;
            }
        }

        return true;
    }

    private void combination(int k, String sub, List<String> list) {
        if (sub.length() == k) {
            list.add(sub);
            return;
        }

        combination(k, sub + '0', list);
        combination(k, sub + '1', list);
    }
}
