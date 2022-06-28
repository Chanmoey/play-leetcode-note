package LeetCode1647;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Chanmoey
 * @date 2022年06月29日
 */
class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for (char c: s.toCharArray()) count[c - 'a']++;

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n: count) {
            if (n != 0) {
                freqMap.put(n, freqMap.getOrDefault(n,0) + 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(freqMap.keySet());

        int deletions = 0;
        while (!pq.isEmpty()) {
            int val = pq.poll();
            int freq = freqMap.get(val);
            deletions += freq - 1;
            if (freq > 1 && val > 1) {
                if (!freqMap.containsKey(val-1)) {
                    pq.add(val-1);
                }
                freqMap.put(val-1, freqMap.getOrDefault(val-1,0) + freq-1);
            }
        }

        return deletions;
    }
}
