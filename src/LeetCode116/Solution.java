package LeetCode116;

import Pair.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2021年12月29日
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

/**
 * 层序遍历的思想。
 */
class Solution {
    public Node connect(Node root) {
        this.setNextPointer(this.getLayer(root));
        return root;
    }

    private List<List<Node>> getLayer(Node root) {
        List<List<Node>> lists = new ArrayList<>();
        Deque<Pair<Integer, Node>> queue = new ArrayDeque<>();
        Pair<Integer, Node> pair = new Pair<>(0, root);
        queue.addLast(pair);
        while (!queue.isEmpty()) {
            pair = queue.removeFirst();
            int level = pair.getKey();
            Node node = pair.getValue();

            if (level == lists.size()) {
                lists.add(new ArrayList<>());
            }
            if (node != null) {
                lists.get(level).add(node);
            }

            if (node != null) {
                queue.addLast(new Pair<>(level + 1, node.left));
                queue.addLast(new Pair<>(level + 1, node.right));
            }
        }

        return lists;
    }

    private void setNextPointer(List<List<Node>> lists) {
        for (List<Node> list : lists) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).next = i == list.size() - 1 ? null :list.get(i + 1);
            }
        }
    }
}
