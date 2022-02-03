package LeetCode98;

import treenode.TreeNode;

/**
 *
 * 错误题解，只能判断左孩比父小，右孩比父大，但是二叉树的定义可不仅仅是这样的。
 *
 * @author Chanmoey
 * @date 2022年02月03日
 */
class Solution1 {
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null) {
            if (root.left.val >= root.val) {
                return false;
            }
        }

        if (root.right != null) {
            if (root.right.val <= root.val) {
                return false;
            }
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }
}
