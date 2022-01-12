package LeetCode701;

import treenode.TreeNode;

/**
 * @author Chanmoey
 * @date 2022年01月12日
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}
