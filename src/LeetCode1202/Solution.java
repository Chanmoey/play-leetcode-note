package LeetCode1202;

import java.util.*;

/**
 * 并查集
 *
 * @author Chanmoey
 * @date 2022年04月27日
 */
class Solution {

    private static class UF {
        public UF(int n) {
            id = new int[n];
            for (int i = 0; i < n; ++i) {
                id[i] = i;
            }
        }

        public void union(int u, int v) {
            id[find(u)] = find(v);
        }

        public int find(int u) {
            return id[u] == u ? u : (id[u] = find(id[u]));
        }

        private final int[] id;
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        StringBuilder ans = new StringBuilder();
        UF uf = new UF(s.length());
        Map<Integer, Queue<Character>> map = new HashMap<>();

        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        for (int i = 0; i < s.length(); ++i) {
            map.computeIfAbsent(uf.find(i), k -> new PriorityQueue<>()).offer(s.charAt(i));
        }

        for (int i = 0; i < s.length(); ++i) {
            ans.append(map.get(uf.find(i)).poll());
        }

        return ans.toString();
    }
}
