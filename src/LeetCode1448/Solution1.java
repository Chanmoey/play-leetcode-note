package LeetCode1448;

import treenode.TreeNode;

/**
 * @author Chanmoey
 * @date 2022年09月01日
 */
class Solution1 {

    private int res = 0;
    public int goodNodes(TreeNode root) {
        int max = root.val;
        dfs(root, max);
        return res;
    }

    public void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        }

        if (root.val >= max) {
            max = root.val;
            res ++;
        }

        dfs(root.left, max);
        dfs(root.right, max);
    }
}
