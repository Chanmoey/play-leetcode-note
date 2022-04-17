package LeetCode897;

import treenode.TreeNode;

class Solution {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyHead = new TreeNode(-1);
        this.inorderTraversal(root, dummyHead);

        return dummyHead.right;
    }

    private TreeNode inorderTraversal(TreeNode root, TreeNode dummy) {
        if (root == null) {
            return dummy;
        }

        dummy = inorderTraversal(root.left, dummy);
        dummy.right = root;
        root.left = null;
        dummy = root;
        return inorderTraversal(root.right, dummy);
    }
}
