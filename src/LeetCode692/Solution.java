package LeetCode692;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2022年10月19日
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>(words.length * 2);
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return a.getKey().compareTo(b.getKey());
            } else {
                return b.getValue() - a.getValue();
            }
        });
        queue.addAll(map.entrySet());

        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(queue.remove().getKey());
        }

        return res;
    }
}
