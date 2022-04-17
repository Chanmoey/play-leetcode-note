package LeetCode538;

import treenode.TreeNode;

class Solution {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        reverseInorder(root);
        return root;
    }

    private void reverseInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        reverseInorder(root.right);
        root.val = root.val + sum;
        sum = root.val;
        reverseInorder(root.left);
    }
}
