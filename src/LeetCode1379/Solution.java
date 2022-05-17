package LeetCode1379;

import treenode.TreeNode;

/**
 * @author Chanmoey
 * @date 2022年05月17日
 */
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original,
                                        final TreeNode cloned,
                                        final TreeNode target) {

        return this.bfs(cloned, target.val);
    }

    private TreeNode bfs(TreeNode root, int value) {
        if (root == null) {
            return null;
        }

        if (root.val == value) {
            return root;
        }

        TreeNode left = this.bfs(root.left, value);
        TreeNode right = this.bfs(root.right, value);

        return left == null ? right : left;
    }
}
