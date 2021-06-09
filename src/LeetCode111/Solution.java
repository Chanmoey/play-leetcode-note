package LeetCode111;

import TreeNode.TreeNode;

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null || root.right == null) {
            return 1;
        }

        return Math.min(this.minDepth(root.left), this.minDepth(root.right)) + 1;
    }
}
