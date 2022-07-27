package LeetCode114;

import treenode.TreeNode;

/**
 * @author Chanmoey
 * @date 2022年07月27日
 */
public class Solution1 {

    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = prev;
        prev = root;
    }
}
