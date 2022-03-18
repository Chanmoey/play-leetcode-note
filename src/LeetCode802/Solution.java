package LeetCode802;

import java.util.*;

/**
 * @author Chanmoey
 * @date 2022年03月18日
 */
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList();
        int n = graph.length;

        // 0代表未访问，1代表以访问，2代表安全节点
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (dfs(graph, visited, i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean dfs(int[][] graph, int[] visited, int i) {
        if (visited[i] != 0) {
            return visited[i] == 2;
        }
        visited[i] = 1;
        for (int node : graph[i]) {
            if (!dfs(graph, visited, node)) {
                return false;
            }
        }
        visited[i] = 2;
        return true;
    }
}
