package LeetCode785;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年03月03日
 */
class Solution {

    private int[][] graph;
    private int[] colors;

    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        int V = graph.length;

        // -1 表示 红色，1 表示蓝色，0 表示未染色。
        this.colors = new int[V];

        for (int v = 0; v < V; v++) {
            if (this.colors[v] == 0) {
                if (!dfs(v, 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int v, int color) {
        this.colors[v] = color;

        for (int w : this.graph[v]) {
            if (this.colors[w] == 0) {
                if (!dfs(w, -color)) {
                    return false;
                }
            } else if (this.colors[w] == color) {
                return false;
            }
        }

        return true;
    }
}
