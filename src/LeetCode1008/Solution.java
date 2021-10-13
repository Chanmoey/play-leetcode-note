package LeetCode1008;

import TreeNode.TreeNode;

class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length <= 1) {
            return new TreeNode(preorder[0]);
        }

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            this.insert(root, preorder[i]);
        }

        return root;

    }

    private TreeNode insert(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        }

        if (val > root.val) {
            root.right = insert(root.right, val);
        }

        return root;
    }
}
