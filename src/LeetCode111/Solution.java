package LeetCode111;

import TreeNode.TreeNode;

/**
 * dfs Solution
 */
class Solution {
//    public int minDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int lDepth = this.minDepth(root.left);
//        int rDepth = this.minDepth(root.right);
//
//        if (lDepth == 0 || rDepth == 0) {
//            return 1 + (lDepth == 0 ? rDepth : lDepth);
//        }
//
//        return 1 + Math.min(lDepth, rDepth);
//    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int ret = Integer.MAX_VALUE;
        if (root.left != null) {
            ret = Math.min(ret, this.minDepth(root.left));
        }
        if (root.right != null) {
            ret = Math.min(ret, this.minDepth(root.right));
        }

        return 1 + ret;
    }
}
