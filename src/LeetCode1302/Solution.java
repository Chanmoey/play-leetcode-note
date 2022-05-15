package LeetCode1302;

import treenode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 使用层序遍历，广度优先遍历，这是一个比较直观的方法。
 *
 * @author Chanmoey
 * @date 2022年05月15日
 */
class Solution {

    private record pair(TreeNode node, int level) {
    }

    public int deepestLeavesSum(TreeNode root) {
        List<List<TreeNode>> inorder = this.inorder(root);

        int sum = 0;
        for (TreeNode node : inorder.get(inorder.size() - 1)) {
            sum += node.val;
        }

        return sum;
    }

    private List<List<TreeNode>> inorder(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("root cannot be null!");
        }

        Deque<pair> queue = new LinkedList<>();
        queue.addLast(new pair(root, 0));

        List<List<TreeNode>> res = new LinkedList<>();

        while (!queue.isEmpty()) {
            pair cur = queue.removeFirst();
            TreeNode node = cur.node;
            int level = cur.level;

            if (res.size() == level) {
                res.add(new LinkedList<>());
            }
            res.get(level).add(node);

            if (node.left != null) {
                queue.addLast(new pair(node.left, level + 1));
            }

            if (node.right != null) {
                queue.addLast(new pair(node.right, level + 1));
            }
        }

        return res;
    }
}
