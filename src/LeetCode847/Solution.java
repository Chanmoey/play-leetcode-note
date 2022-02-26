package LeetCode847;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 参考讨论区
 *
 * @author Chanmoey
 * @date 2022年02月26日
 */
class Solution {

    static class Node {
        int visited;
        int dist;
        int node;

        Node(int node, int dist, int visited) {
            this.node = node;
            this.dist = dist;
            this.visited = visited;
        }
    }

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Set<Integer>[] visited = new HashSet[n];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            visited[i] = new HashSet<>();
            queue.add(new Node(i, 0, 1 << i));
            visited[i].add(1 << i);
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.visited == (1 << n) - 1) {
                return node.dist;
            }
            for (int nei : graph[node.node]) {
                int mask = node.visited | (1 << nei);
                if (visited[nei].add(mask)) {
                    queue.add(new Node(nei, 1 + node.dist, mask));
                }
            }
        }
        return -1;
    }
}
