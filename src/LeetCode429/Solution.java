package LeetCode429;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Chanmoey
 * @date 2022年09月05日
 */

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}


class Solution {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> level = new ArrayList<>();

        if (root == null) {
            return level;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            level.add(new ArrayList<>());

            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                level.get(level.size() - 1).add(cur.val);
                queue.addAll(cur.children);
            }
        }

        return level;
    }
}
