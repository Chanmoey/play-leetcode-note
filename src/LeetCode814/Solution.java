package LeetCode814;

import treenode.TreeNode;

/**
 * @author Chanmoey
 * @date 2022年09月06日
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        prune(root);

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }

        return root;
    }

    // 返回 true 表示该子树不含1，可以删除，否则false
    private boolean prune(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = prune(root.left);
        boolean right = prune(root.right);

        if (left) {
            root.left = null;
        }

        if (right) {
            root.right = null;
        }

        return left && right && (root.val == 0);
    }
}
