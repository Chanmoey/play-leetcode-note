package LeetCode609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * "root/a 1.txt(abcd) 2.txt(efgh)"
 * "root/c 3.txt(abcd)"
 * "root/c/d 4.txt(efgh)"
 * "root 4.txt(efgh)"
 * Runtime: 26 ms, faster than 88.96% of Java online submissions for Find Duplicate File in System.
 *
 * @author Chanmoey
 * @date 2022年09月19日
 */
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> fileMap = new HashMap<>();

        for (String path : paths) {
            String[] word = path.split(" ");
            String root = word[0] + '/';

            for (int i = 1; i < word.length; i++) {
                int open = word[i].indexOf('(');
                int close = word[i].indexOf(')');

                String content = word[i].substring(open + 1, close);
                String fileName = word[i].substring(0, open);
                fileMap.computeIfAbsent(content, key -> new ArrayList<>()).add(root + fileName);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> value : fileMap.values()) {
            if (value.size() > 1) {
                res.add(value);
            }
        }

        return res;
    }
}
