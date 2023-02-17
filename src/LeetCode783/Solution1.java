package LeetCode783;

import treenode.TreeNode;

/**
 * @author Chanmoey
 * @date 2023年02月17日
 */
class Solution1 {

    private int res = Integer.MAX_VALUE;
    private int before = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        res = Math.min(res, Math.abs(before - node.val));
        before = node.val;
        dfs(node.right);
    }
}
