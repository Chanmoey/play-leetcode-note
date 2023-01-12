package LeetCode1519;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2023年01月12日
 */
class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }
        int[] res = new int[n];

        dfs(0, -1, adj, labels.toCharArray(), res);
        return res;
    }

    private int[] dfs(int node, int parent, Map<Integer, List<Integer>> adj,
                      char[] labels, int[] res) {
        int[] nodeCount = new int[26];
        nodeCount[labels[node] - 'a']++;

        if (!adj.containsKey(node)) {
            return nodeCount;
        }

        for (int child : adj.get(node)) {
            if (child == parent) {
                continue;
            }

            int[] childCount = dfs(child, node, adj, labels, res);

            for (int i = 0; i < 26; i++) {
                nodeCount[i] += childCount[i];
            }
        }

        res[node] = nodeCount[labels[node] - 'a'];
        return nodeCount;
    }
}
