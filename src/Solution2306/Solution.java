package Solution2306;

import java.util.HashSet;

/**
 * @author Chanmoey
 * @date 2023年02月09日
 */
class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String>[] initialGroup = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            initialGroup[i] = new HashSet<>();
        }
        for (String idea : ideas) {
            initialGroup[idea.charAt(0) - 'a'].add(idea.substring(1));
        }

        long res = 0;
        for (int i = 0; i < 25; i++) {
            if (initialGroup[i].isEmpty()) {
                continue;
            }
            for (int j = i + 1; j < 26; j++) {
                if (initialGroup[j].isEmpty()) {
                    continue;
                }
                int sameSuffix = 0;
                for (String leftSuffix : initialGroup[i]) {
                    if (initialGroup[j].contains(leftSuffix)) {
                        sameSuffix++;
                    }
                }
                res += 2 * ((long) (initialGroup[i].size() - sameSuffix) * (initialGroup[j].size() - sameSuffix));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.distinctNames(new String[]{"coffee", "donuts", "time", "toffee"}));
    }
}
