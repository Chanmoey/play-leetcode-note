package LeetCode98;

import treenode.TreeNode;

/**
 * @author Chanmoey
 * @date 2022年02月03日
 */
class Solution2 {

    private long min = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);

        if (root.val <= min) {
            return false;
        }

        min = root.val;

        boolean right = isValidBST(root.right);

        return left && right;
    }
}