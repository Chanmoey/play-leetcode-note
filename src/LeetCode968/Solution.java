package LeetCode968;

import treenode.TreeNode;

/**
 * @author Chanmoey
 * @date 2022年06月17日
 */
class Solution {

    private int res = 0;

    public int minCameraCover(TreeNode root) {
        return (dfs(root) < 1 ? 1 : 0) + res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 2;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left == 0 || right == 0) {
            this.res++;
            return 1;
        }

        return left == 1 || right == 1 ? 2 : 0;
    }
}
