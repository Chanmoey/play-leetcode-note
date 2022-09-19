package LeetCode609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对 Solution 稍稍改进一下：Runtime: 26 ms, faster than 97.24% of Java online submissions for Find Duplicate File in System.
 *
 * @author Chanmoey
 * @date 2022年09月19日
 */
class Solution1 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> fileMap = new HashMap<>();

        for (String path : paths) {
            String[] word = path.split(" ");
            String root = word[0] + '/';

            for (int i = 1; i < word.length; i++) {
                boolean isOpen = false;
                StringBuilder fileNameSb = new StringBuilder();
                StringBuilder contentSb = new StringBuilder();
                for (int j = 0; j < word[i].length(); j++) {
                    if (word[i].charAt(j) == '(') {
                        isOpen = true;
                    } else {
                        if (isOpen) {
                            // 这里 ')' 也会被添加到 contentSb 中，不过没关系
                            contentSb.append(word[i].charAt(j));
                        } else {
                            fileNameSb.append(word[i].charAt(j));
                        }
                    }
                }
                String content = contentSb.toString();
                String fileName = fileNameSb.toString();

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
