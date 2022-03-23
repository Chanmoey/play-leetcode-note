package LeetCode886;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年03月23日
 */
class Solution {
    private List<Integer>[] graph;
    private int[] colors;
    private boolean[] visited;
    private boolean isBipartite = true;

    public boolean possibleBipartition(int n, int[][] dislikes) {

        this.graph = creatGraph(n, dislikes);

        this.visited = new boolean[graph.length];
        this.colors = new int[graph.length];

        for (int v = 1; v <= n; v++) {
            if (!this.visited[v]) {
                if (!this.dfs(v, 0)) {
                    this.isBipartite = false;
                    break;
                }
            }
        }

        return this.isBipartite;
    }

    private boolean dfs(int v, int color) {
        this.visited[v] = true;
        this.colors[v] = color;
        for (int w : this.graph[v]) {
            if (!this.visited[w]) {
                if (!dfs(w, 1 - color)) {
                    return false;
                }
            } else if (this.colors[w] == color) {
                return false;
            }
        }

        return true;
    }

    private List<Integer>[] creatGraph(int n, int[][] dis) {

        List<Integer>[] graph = new LinkedList[n + 1];


        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] twoPeople : dis) {
            int a = twoPeople[0];
            int b = twoPeople[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        return graph;
    }
}
