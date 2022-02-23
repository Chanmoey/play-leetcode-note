package LeetCode133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chanmoey
 * @date 2022年02月23日
 */
class Solution {

    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        return node == null ? null : this.cloneGraph(node, new HashMap<>());
    }

    public Node cloneGraph(Node node, Map<Integer, Node> cloneMap) {

        if (cloneMap.containsKey(node.val)) {
            return cloneMap.get(node.val);
        }

        Node clone = cloneMap.computeIfAbsent(node.val, k -> new Node(node.val));

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor, cloneMap));
        }

        return clone;
    }
}
