package LeetCode572;

import TreeNode.TreeNode;

class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null || subRoot == null) {
            return false;
        }

        if (this.isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        } else if (p == null ) {
            return false;
        } else if(q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return this.isSameTree(p.left, q.left) && this.isSameTree(p.right, q.right);
    }
}
