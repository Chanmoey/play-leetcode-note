package LeetCode112;

import TreeNode.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return this.hasPathSum(root.left, targetSum - root.val) ||
                this.hasPathSum(root.right, targetSum - root.val);
    }
}
