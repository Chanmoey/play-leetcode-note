package LeetCode404;

import treenode.TreeNode;

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return this.sumOfLeftLeaves(root, "head");
    }

    private int sumOfLeftLeaves(TreeNode root, String side) {

        if (root == null) {
            return 0;
        }

        // 判断该结点是否是左叶子结点 —— left leave node
        if (root.left == null && root.right == null && side.equals("left")) {
            return root.val;
        }

        return this.sumOfLeftLeaves(root.left, "left") +
                this.sumOfLeftLeaves(root.right, "right");
    }
}
