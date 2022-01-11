package LeetCode1022;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmoey
 * @date 2022年01月11日
 */
class Solution1 {

    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        this.getAllPath(root, 0);
        return this.sum;
    }

    private void getAllPath(TreeNode root, int num) {

        if (root == null) {
            return;
        }

        num = 2 * num + root.val;

        if (root.left == null && root.right == null) {
            this.sum += num;
            return;
        }

        if (root.left != null) {
            getAllPath(root.left, num);
        }
        if (root.right != null) {
            getAllPath(root.right, num);
        }
    }
}
