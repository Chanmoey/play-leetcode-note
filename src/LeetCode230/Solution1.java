package LeetCode230;

import TreeNode.TreeNode;

class Solution1 {
    private int index;

    public int kthSmallest(TreeNode root, int k) {
        this.index = 0;
        return kthSmallestNode(root, k).val;
    }

    private TreeNode kthSmallestNode(TreeNode node, int k) {

        if (node == null) {
            return null;
        }

        TreeNode res = kthSmallestNode(node.left, k);
        if (res != null) {
            return res;
        }

        index ++;
        if (index == k){
            return node;
        }

        return kthSmallestNode(node.right, k);
    }
}
