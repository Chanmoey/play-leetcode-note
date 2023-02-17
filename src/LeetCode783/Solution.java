package LeetCode783;

import treenode.TreeNode;

import java.util.TreeSet;

/**
 * @author Chanmoey
 * @date 2023年02月17日
 */
class Solution {

    private int res = Integer.MAX_VALUE;
    private final TreeSet<Integer> set = new TreeSet<>();

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        Integer floor = set.floor(root.val);
        if (floor != null) {
            int abs = Math.abs(root.val - floor);
            res = Math.min(abs, res);
        }
        Integer cell = set.ceiling(root.val);
        if (cell != null) {
            int abs = Math.abs(root.val - cell);
            res = Math.min(abs, res);
        }
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}