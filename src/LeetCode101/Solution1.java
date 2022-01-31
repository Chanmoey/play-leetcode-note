package LeetCode101;

import treenode.TreeNode;

/**
 * @author Chanmoey
 * @date 2022年01月31日
 */
class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t2.left, t1.right);
    }
}
