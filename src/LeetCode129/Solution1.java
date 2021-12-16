package LeetCode129;

import treenode.TreeNode;

class Solution1 {

    private int res = 0;

    public int sumNumbers(TreeNode root) {

        this.sumNumbers(root, 0);
        return this.res;
    }

    private void sumNumbers(TreeNode root, int lastSum) {
        if (root == null) {
            return;
        }

        if (root.right == null && root.left == null) {
            this.res += lastSum * 10 + root.val;
            return;
        }

        lastSum = lastSum * 10 + root.val;

        sumNumbers(root.right, lastSum);
        sumNumbers(root.left, lastSum);
    }
}
