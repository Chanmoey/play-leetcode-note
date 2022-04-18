package LeetCode669;

import treenode.TreeNode;

/**
 * @author Chanmoey
 * @date 2022年04月15日
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null) {
            return null;
        }

        if (root.val >= low && root.val <= high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        } else if (root.val < low) {
            root = trimBST(root.right, low, high);
        } else {
            root = trimBST(root.left, low, high);
        }

        return root;
    }
}