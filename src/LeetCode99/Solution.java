package LeetCode99;

import treenode.TreeNode;

import javax.swing.*;
import java.nio.charset.IllegalCharsetNameException;

/**
 * @author Chanmoey
 * @date 2022年04月19日
 */
class Solution {

    private TreeNode first;
    private TreeNode second;
    private TreeNode pre = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        this.inorderTraversal(root);
        this.swap();
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);

        if (this.pre.val > root.val) {
            if (first == null) {
                first = pre;
            }

            second = root;
        }

        this.pre = root;

        inorderTraversal(root.right);
    }

    private void swap() {
        int temp = this.first.val;
        this.first.val = this.second.val;
        this.second.val = temp;
    }
}
