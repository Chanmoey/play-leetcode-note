package LeetCode437;

import TreeNode.TreeNode;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return 0;
        }

        int res = findPath(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);

        return res;
    }

    // 从以node为根结点的二叉树中，寻找包含node的和为sum的路径
    // 返回路径的个数
    private int findPath(TreeNode node, int sum) {

        if (node == null) {
            return 0;
        }

        int res = 0;
        if (node.val == sum) {
            res++;
        }
        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);

        return res;
    }
}
