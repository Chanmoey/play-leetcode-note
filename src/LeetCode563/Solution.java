package LeetCode563;

import TreeNode.TreeNode;

/**
 * @author Chanmoey
 * @date 2021年12月08日 10:08
 * @description
 */
class Solution {

    private int res = 0;

    public int findTilt(TreeNode root) {
        this.sum(root);
        return this.res;
    }

    private int sum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = sum(root.left);
        int right = sum(root.right);

        res += Math.abs(left - right);
        return left + right + root.val;
    }
}
