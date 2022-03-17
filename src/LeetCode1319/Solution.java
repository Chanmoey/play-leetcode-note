package LeetCode1319;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 寻找联通分量的个数 - 1。
 *
 * @author Chanmoey
 * @date 2022年03月17日
 */
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (n - 1 > connections.length) {
            return -1;
        }

        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] e : connections) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];

        int c = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                this.dfs(graph, i, visited);
                c++;
            }
        }

        return c - 1;
    }

    private void dfs(List<Set<Integer>> graph, int v, boolean[] visited) {
        visited[v] = true;
        for (int next : graph.get(v)) {
            if (!visited[next]) {
                dfs(graph, next, visited);
            }
        }
    }
}
