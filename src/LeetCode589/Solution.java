package LeetCode589;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年03月02日
 */
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> order = new ArrayList<>();
        this.preorder(root, order);
        return order;
    }

    public void preorder(Node root, List<Integer> order) {
        if (root == null) {
            return;
        }

        order.add(root.val);
        for (Node child:
             root.children) {
            preorder(child, order);
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}