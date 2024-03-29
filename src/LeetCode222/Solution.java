package LeetCode222;

import treenode.TreeNode;

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return this.countNodes(root.left) + this.countNodes(root.right) + 1;
    }
}
