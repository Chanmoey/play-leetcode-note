package LeetCode938;

import treenode.TreeNode;

/**
 * 稍稍优化编码风格，函数式风格的编码，不修改外部变量的值
 *
 * @author Chanmoey
 * @date 2022年12月07日
 */
class Solution1 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return getSumInRange(root, low, high);
    }

    private int getSumInRange(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }
        if (node.val < low) {
            return getSumInRange(node.right, low, high);
        } else if (node.val > high) {
            return getSumInRange(node.left, low, high);
        } else {
            return node.val + getSumInRange(node.left, low, high) + getSumInRange(node.right, low, high);
        }
    }
}
