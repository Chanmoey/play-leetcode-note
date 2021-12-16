package LeetCode226;

import treenode.TreeNode;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // after executing "root.left = this.invertTree(root.right)", root.left will be overwritten.
        TreeNode temp = root.left;
        root.left = this.invertTree(root.right);
        root.right = this.invertTree(temp);
        return root;
    }
}
