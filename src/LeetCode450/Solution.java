package LeetCode450;

import treenode.TreeNode;

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = this.deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = this.deleteNode(root.right, key);
            return root;
        } else {

            if (root.left == null) {
                root = root.right;
                return root;
            } else if (root.right == null) {
                root = root.left;
                return root;
            } else {
                TreeNode minNode = this.findMin(root.right);
                minNode.right = this.deleteMin(root.right);
                minNode.left = root.left;
                root = minNode;
                return root;
            }
        }
    }

    private TreeNode deleteMin(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return null;
        }

        if (root.left == null) {
            return root.right;
        }

        root.left = this.deleteMin(root.left);
        return root;
    }

    private TreeNode findMin(TreeNode root) {

        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }

        return this.findMin(root.left);
    }
}
