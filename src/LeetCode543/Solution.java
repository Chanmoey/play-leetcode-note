package LeetCode543;

import TreeNode.TreeNode;

class Solution {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        this.dfs(root);
        return this.max;
    }

    private int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        this.max = Math.max(this.max, left + right);

        return Math.max(left, right) + 1;
    }
}