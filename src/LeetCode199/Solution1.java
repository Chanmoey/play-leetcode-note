package LeetCode199;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);

        while (!cur.isEmpty()) {
            res.add(cur.get(cur.size() - 1).val);

            List<TreeNode> next = new ArrayList<>();
            for (TreeNode node : cur) {
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }

            cur = next;
        }

        return res;
    }
}
