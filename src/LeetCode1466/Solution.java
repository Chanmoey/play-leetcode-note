package LeetCode1466;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年03月19日
 */
class Solution {

    private static class Edge {
        int vertex, count;
        public Edge(int vertex, int count) {
            this.vertex = vertex;
            this.count = count;
        }
    }

    public int minReorder(int n, int[][] connections) {
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            graph.get(connection[0]).add(new Edge(connection[1], 1));
            graph.get(connection[1]).add(new Edge(connection[0], 0));
        }

        return dfs(graph, 0, new boolean[n]);
    }

    private int dfs(List<List<Edge>> graph, int source, boolean[] isVisited) {
        int cost = 0;
        isVisited[source] = true;

        for(Edge neighbour : graph.get(source)) {
            if(!isVisited[neighbour.vertex]) {
                cost += neighbour.count + dfs(graph, neighbour.vertex, isVisited);
            }
        }
        return cost;
    }
}
