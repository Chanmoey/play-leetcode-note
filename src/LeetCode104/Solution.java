package LeetCode104;

import TreeNode.TreeNode;

class Solution {
    public int maxDepth(TreeNode root) {
        return this.maxDepth(root, 0);
    }

    private int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        int ld = this.maxDepth(root.left, depth);
        int rd = this.maxDepth(root.right, depth);

        return Math.max(ld, rd);
    }
}
