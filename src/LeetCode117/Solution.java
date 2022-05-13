package LeetCode117;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Chanmoey
 * @date 2022年05月13日
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
}

class Solution {

    private static class Pair {
        int level;
        Node node;

        public Pair(int level, Node node) {
            this.level = level;
            this.node = node;
        }

        public int getLevel() {
            return this.level;
        }

        public Node getNode() {
            return this.node;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        List<List<Node>> inorder = this.inorderTraversal(root);
        this.connectInorder(inorder);
        return root;
    }

    private List<List<Node>> inorderTraversal(Node root) {
        List<List<Node>> inorder = new LinkedList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair cur = queue.remove();
            int level = cur.getLevel();
            Node node = cur.getNode();

            if (level == inorder.size()) {
                inorder.add(new LinkedList<>());
            }
            inorder.get(level).add(node);

            if (node.left != null) {
                queue.add(new Pair(level + 1, node.left));
            }

            if (node.right != null) {
                queue.add(new Pair(level + 1, node.right));
            }
        }

        return inorder;
    }

    private void connectInorder(List<List<Node>> inorder) {
        for (List<Node> list : inorder) {
            int size = list.size();
            for (int i = 0; i < size - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }

            // 这句可以省略，默认就是null。
            list.get(size - 1).next = null;
        }
    }
}
