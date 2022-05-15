package LeetCode1302;

import treenode.TreeNode;

/**
 * 递归，深度优先遍历。
 *
 * @author Chanmoey
 * @date 2022年05月15日
 */
class Solution1 {

    private int sum = 0;
    private int deepestLevel = 0;

    public int deepestLeavesSum(TreeNode root) {
        this.dfs(root, 0);
        return this.sum;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && level == this.deepestLevel) {
            this.sum += root.val;
        }

        if (root.left == null && root.right == null && level > this.deepestLevel) {
            this.sum = root.val;
            this.deepestLevel = level;
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
