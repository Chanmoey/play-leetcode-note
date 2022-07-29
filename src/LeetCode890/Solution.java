package LeetCode890;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2022年07月29日
 */
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>(words.length);
        for (String word : words) {
            if (match(word, pattern)) {
                res.add(word);
            }
        }

        return res;
    }

    private boolean match(String word, String pattern) {
        // word.length == pattern.length
        char[] wc = word.toCharArray();
        char[] pc = pattern.toCharArray();
        Map<Character, Character> map = new HashMap<>(word.length() * 2);
        Set<Character> used = new HashSet<>(word.length());
        for (int i = 0; i < wc.length; i++) {
            if (map.containsKey(wc[i])) {
                if (map.get(wc[i]) != pc[i]) {
                    return false;
                }
            } else {
                // 如果 wc[i] 没有出现过，但是 pc[i] 出现过了，那肯定产生映射冲突了，返回false
                if (used.contains(pc[i])) {
                    return false;
                }
                // 添加 word[i] —> pattern[i] 的映射
                map.put(wc[i], pc[i]);

                // 防止 pattern[i] 被重复添加
                used.add(pc[i]);
            }
        }

        return true;
    }

//    private boolean isSameStr(char[] word, char[] pattern) {
//        // word.length == pattern.length
//        for (int i = 0; i < word.length; i++) {
//            if (word[i] != pattern[i]) {
//                return false;
//            }
//        }
//
//        return true;
//    }
}
