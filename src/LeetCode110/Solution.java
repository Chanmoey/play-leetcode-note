package LeetCode110;

import treenode.TreeNode;

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int lh = this.getTreeHeight(root.left);
        int rh = this.getTreeHeight(root.right);

        // return this.isBalanced(root.left) && this.isBalanced(root.right) && Math.abs(lh - rh) <= 1;
        if (Math.abs(lh - rh) <= 1) {
            return this.isBalanced(root.left) && this.isBalanced(root.right);
        } else {
            return false;
        }

    }

    private int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(this.getTreeHeight(root.left), this.getTreeHeight(root.right)) + 1;
    }
}
