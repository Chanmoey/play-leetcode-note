package LeetCode1584;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Chanmoey
 * @date 2022年04月26日
 */
public class Solution {

    private static class Edge implements Comparable<Edge> {

        private final int v;

        private final int w;

        private final int weight;

        public int getV() {
            return v;
        }

        public int getW() {
            return w;
        }

        public int getWeight() {
            return weight;
        }

        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }


    public int minCostConnectPoints(int[][] points) {
        List<List<Edge>> graph = this.createGraph(points);
        List<Edge> mst = this.prim(graph);
        return this.getWeight(mst);
    }

    private List<Edge> prim(List<List<Edge>> graph) {
        List<Edge> mst = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()];
        visited[0] = true;

        Queue<Edge> minHeap = new PriorityQueue<>();
        minHeap.addAll(graph.get(0));

        while (!minHeap.isEmpty()) {
            Edge minEdge = minHeap.remove();

            if (visited[minEdge.getV()] && visited[minEdge.getW()]) {
                continue;
            }

            mst.add(minEdge);

            int newV = visited[minEdge.getV()] ? minEdge.getW() : minEdge.getV();
            visited[newV] = true;

            for (Edge e : graph.get(newV)) {
                if (!visited[e.getW()]) {
                    minHeap.add(e);
                }
            }
        }

        return mst;
    }

    private int getWeight(List<Edge> mst) {
        int sumWeight = 0;
        for (Edge e : mst) {
            sumWeight += e.getWeight();
        }

        return sumWeight;
    }

    private List<List<Edge>> createGraph(int[][] points) {
        int nodes = points.length;
        List<List<Edge>> graph = new ArrayList<>(nodes);
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
            for (int j = 0; j < nodes; j++) {
                if (i != j) {
                    graph.get(i).add(new Edge(i, j, this.manhattan(points[i], points[j])));
                }
            }
        }

        return graph;
    }

    private int manhattan(int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));
    }
}
