package LeetCode1443;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2023年01月11日
 */
class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        return dfs(0, -1, adj, hasApple);
    }

    private int dfs(int node, int parent, Map<Integer, List<Integer>> adj, List<Boolean> hasApple) {
        // 叶子节点，不再消耗步数
        if (!adj.containsKey(node)) {
            return 0;
        }

        int totalTime = 0;
        int childTime = 0;

        for (int child : adj.get(node)) {
            if (child == parent) {
                continue;
            }

            childTime = dfs(child, node, adj, hasApple);

            if (childTime > 0 || Boolean.TRUE.equals(hasApple.get(child))) {
                totalTime += childTime + 2;
            }
        }

        return totalTime;
    }
}
