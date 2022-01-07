package LeetCode1026;

import treenode.TreeNode;

/**
 * @author Chanmoey
 * @date 2021年12月31日
 */
class Solution {

    private int maxValue = 0;

    public int maxAncestorDiff(TreeNode root) {
        this.findMaxValue(root, root, root);
        this.findMaxValue(root, root, root);
        return maxValue;
    }

    private void findMaxValue(TreeNode node, TreeNode maxNode, TreeNode minNode) {

        if (node == null) {
            return;
        }

        maxNode = maxNode.val > node.val ? maxNode : node;
        minNode = minNode.val < node.val ? minNode : node;

        this.maxValue = Math.max(this.maxValue, Math.abs(maxNode.val - minNode.val));

        findMaxValue(node.left, maxNode, minNode);
        findMaxValue(node.right, maxNode, minNode);
    }
}
