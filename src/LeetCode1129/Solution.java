package LeetCode1129;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年03月19日
 */
class Solution {

    private static class Edge {
        int v, color, distance;

        public Edge(int v, int color, int distance) {
            this.v = v;
            this.color = color;
            this.distance = distance;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Edge>> graph = new ArrayList<>();
        int[] ans = new int[n];

        // 初始化图
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 1 为红色，-1为蓝色。
        for (int[] redEdge : redEdges) {
            graph.get(redEdge[0]).add(new Edge(redEdge[1], 1, 0));
        }
        for (int[] blueEdge : blueEdges) {
            graph.get(blueEdge[0]).add(new Edge(blueEdge[1], -1, 0));
        }

        ArrayDeque<Edge> queue = new ArrayDeque<>();

        boolean[][] isVisited = new boolean[n][3];

        Arrays.fill(ans, -1);
        queue.add(new Edge(0, 1, 0));
        queue.add(new Edge(0, -1, 0));


        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            ans[edge.v] = ans[edge.v] == -1 ? edge.distance : Math.min(ans[edge.v], edge.distance);

            isVisited[edge.v][edge.color + 1] = true;

            for (Edge neighbour : graph.get(edge.v)) {
                if (!isVisited[neighbour.v][neighbour.color + 1] && neighbour.color == -edge.color) {
                    queue.add(new Edge(neighbour.v, neighbour.color, edge.distance + 1));
                }
            }
        }

        return ans;
    }
}
