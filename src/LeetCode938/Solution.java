package LeetCode938;

import treenode.TreeNode;

/**
 * @author Chanmoey
 * @date 2021年12月14日 8:38
 * @description 这个方式没有根据搜素树的性质进行优化。
 */
class Solution {

    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }

        this.getSumInRange(root, low, high);
        return this.sum;
    }

    private void getSumInRange(TreeNode root, int low, int high) {

        if (root == null) {
            return;
        }

        if (root.val >= low && root.val <= high) {
            this.sum += root.val;
        }

        getSumInRange(root.left, low, high);
        getSumInRange(root.right, low, high);
    }
}
